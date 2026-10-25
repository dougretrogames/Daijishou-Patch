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
import com.google.protobuf.SingleFieldBuilder;
import com.google.protobuf.Timestamp;
import com.google.protobuf.TimestampOrBuilder;
import com.google.protobuf.UninitializedMessageException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes6.dex */
public final class EventNetwork extends GeneratedMessage implements EventNetworkOrBuilder {
    public static final int CHECKSUM_FIELD_NUMBER = 7;
    public static final int CREATED_AT_FIELD_NUMBER = 5;
    private static final EventNetwork DEFAULT_INSTANCE;
    public static final int EVENT_FIELD_NUMBER = 2;
    public static final int ID_FIELD_NUMBER = 1;
    public static final int NETWORK_TYPE_FIELD_NUMBER = 4;
    private static final Parser<EventNetwork> PARSER;
    public static final int UPDATED_AT_FIELD_NUMBER = 6;
    public static final int URL_FIELD_NUMBER = 3;
    private static final long serialVersionUID = 0;
    private int bitField0_;
    private volatile Object checksum_;
    private Timestamp createdAt_;
    private Event event_;
    private long id_;
    private NetworkType networkType_;
    private Timestamp updatedAt_;
    private volatile Object url_;

    /* synthetic */ EventNetwork(GeneratedMessage.Builder builder, EventNetworkIA eventNetworkIA) {
        this(builder);
    }

    static {
        RuntimeVersion.validateProtobufGencodeVersion(RuntimeVersion.RuntimeDomain.PUBLIC, 4, 27, 2, "", EventNetwork.class.getName());
        DEFAULT_INSTANCE = new EventNetwork();
        PARSER = new AnonymousClass1();
    }

    private EventNetwork(GeneratedMessage.Builder<?> builder) {
        super(builder);
        this.id_ = 0L;
        this.url_ = "";
        this.checksum_ = "";
    }

    private EventNetwork() {
        this.id_ = 0L;
        this.url_ = "";
        this.checksum_ = "";
        this.url_ = "";
        this.checksum_ = "";
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return Igdbproto.internal_static_proto_EventNetwork_descriptor;
    }

    @Override // com.google.protobuf.GeneratedMessage
    protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
        return Igdbproto.internal_static_proto_EventNetwork_fieldAccessorTable.ensureFieldAccessorsInitialized(EventNetwork.class, Builder.class);
    }

    @Override // proto.EventNetworkOrBuilder
    public long getId() {
        return this.id_;
    }

    @Override // proto.EventNetworkOrBuilder
    public boolean hasEvent() {
        return (this.bitField0_ & 1) != 0;
    }

    @Override // proto.EventNetworkOrBuilder
    public Event getEvent() {
        Event event = this.event_;
        return event == null ? Event.getDefaultInstance() : event;
    }

    @Override // proto.EventNetworkOrBuilder
    public EventOrBuilder getEventOrBuilder() {
        Event event = this.event_;
        return event == null ? Event.getDefaultInstance() : event;
    }

    @Override // proto.EventNetworkOrBuilder
    public String getUrl() {
        Object obj = this.url_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.url_ = stringUtf8;
        return stringUtf8;
    }

    @Override // proto.EventNetworkOrBuilder
    public ByteString getUrlBytes() {
        Object obj = this.url_;
        if (obj instanceof String) {
            ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.url_ = byteStringCopyFromUtf8;
            return byteStringCopyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // proto.EventNetworkOrBuilder
    public boolean hasNetworkType() {
        return (this.bitField0_ & 2) != 0;
    }

    @Override // proto.EventNetworkOrBuilder
    public NetworkType getNetworkType() {
        NetworkType networkType = this.networkType_;
        return networkType == null ? NetworkType.getDefaultInstance() : networkType;
    }

    @Override // proto.EventNetworkOrBuilder
    public NetworkTypeOrBuilder getNetworkTypeOrBuilder() {
        NetworkType networkType = this.networkType_;
        return networkType == null ? NetworkType.getDefaultInstance() : networkType;
    }

    @Override // proto.EventNetworkOrBuilder
    public boolean hasCreatedAt() {
        return (this.bitField0_ & 4) != 0;
    }

    @Override // proto.EventNetworkOrBuilder
    public Timestamp getCreatedAt() {
        Timestamp timestamp = this.createdAt_;
        return timestamp == null ? Timestamp.getDefaultInstance() : timestamp;
    }

    @Override // proto.EventNetworkOrBuilder
    public TimestampOrBuilder getCreatedAtOrBuilder() {
        Timestamp timestamp = this.createdAt_;
        return timestamp == null ? Timestamp.getDefaultInstance() : timestamp;
    }

    @Override // proto.EventNetworkOrBuilder
    public boolean hasUpdatedAt() {
        return (this.bitField0_ & 8) != 0;
    }

    @Override // proto.EventNetworkOrBuilder
    public Timestamp getUpdatedAt() {
        Timestamp timestamp = this.updatedAt_;
        return timestamp == null ? Timestamp.getDefaultInstance() : timestamp;
    }

    @Override // proto.EventNetworkOrBuilder
    public TimestampOrBuilder getUpdatedAtOrBuilder() {
        Timestamp timestamp = this.updatedAt_;
        return timestamp == null ? Timestamp.getDefaultInstance() : timestamp;
    }

    @Override // proto.EventNetworkOrBuilder
    public String getChecksum() {
        Object obj = this.checksum_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.checksum_ = stringUtf8;
        return stringUtf8;
    }

    @Override // proto.EventNetworkOrBuilder
    public ByteString getChecksumBytes() {
        Object obj = this.checksum_;
        if (obj instanceof String) {
            ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.checksum_ = byteStringCopyFromUtf8;
            return byteStringCopyFromUtf8;
        }
        return (ByteString) obj;
    }

    public static EventNetwork parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer);
    }

    public static EventNetwork parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    public static EventNetwork parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString);
    }

    public static EventNetwork parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static EventNetwork parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr);
    }

    public static EventNetwork parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr, extensionRegistryLite);
    }

    public static EventNetwork parseFrom(InputStream inputStream) throws IOException {
        return (EventNetwork) GeneratedMessage.parseWithIOException(PARSER, inputStream);
    }

    public static EventNetwork parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (EventNetwork) GeneratedMessage.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static EventNetwork parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (EventNetwork) GeneratedMessage.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static EventNetwork parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (EventNetwork) GeneratedMessage.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static EventNetwork parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (EventNetwork) GeneratedMessage.parseWithIOException(PARSER, codedInputStream);
    }

    public static EventNetwork parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (EventNetwork) GeneratedMessage.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder newBuilderForType() {
        return newBuilder();
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static Builder newBuilder(EventNetwork eventNetwork) {
        return (Builder) DEFAULT_INSTANCE.toBuilder().mergeFrom((Message) eventNetwork);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder toBuilder() {
        return this == DEFAULT_INSTANCE ? new Builder((EventNetworkIA) null) : (Builder) new Builder((EventNetworkIA) null).mergeFrom((Message) this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.AbstractMessage
    public Builder newBuilderForType(AbstractMessage.BuilderParent builderParent) {
        return new Builder(builderParent, null);
    }

    public static final class Builder extends GeneratedMessage.Builder<Builder> implements EventNetworkOrBuilder {
        private int bitField0_;
        private Object checksum_;
        private SingleFieldBuilder<Timestamp, Timestamp.Builder, TimestampOrBuilder> createdAtBuilder_;
        private Timestamp createdAt_;
        private SingleFieldBuilder<Event, Event.Builder, EventOrBuilder> eventBuilder_;
        private Event event_;
        private long id_;
        private SingleFieldBuilder<NetworkType, NetworkType.Builder, NetworkTypeOrBuilder> networkTypeBuilder_;
        private NetworkType networkType_;
        private SingleFieldBuilder<Timestamp, Timestamp.Builder, TimestampOrBuilder> updatedAtBuilder_;
        private Timestamp updatedAt_;
        private Object url_;

        /* synthetic */ Builder(AbstractMessage.BuilderParent builderParent, EventNetworkIA eventNetworkIA) {
            this(builderParent);
        }

        /* synthetic */ Builder(EventNetworkIA eventNetworkIA) {
            this();
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return Igdbproto.internal_static_proto_EventNetwork_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder
        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return Igdbproto.internal_static_proto_EventNetwork_fieldAccessorTable.ensureFieldAccessorsInitialized(EventNetwork.class, Builder.class);
        }

        private Builder() {
            this.url_ = "";
            this.checksum_ = "";
            maybeForceBuilderInitialization();
        }

        private Builder(AbstractMessage.BuilderParent builderParent) {
            super(builderParent);
            this.url_ = "";
            this.checksum_ = "";
            maybeForceBuilderInitialization();
        }

        private void maybeForceBuilderInitialization() {
            if (EventNetwork.alwaysUseFieldBuilders) {
                getEventFieldBuilder();
                getNetworkTypeFieldBuilder();
                getCreatedAtFieldBuilder();
                getUpdatedAtFieldBuilder();
            }
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder clear() {
            super.clear();
            this.bitField0_ = 0;
            this.id_ = 0L;
            this.event_ = null;
            SingleFieldBuilder<Event, Event.Builder, EventOrBuilder> singleFieldBuilder = this.eventBuilder_;
            if (singleFieldBuilder != null) {
                singleFieldBuilder.dispose();
                this.eventBuilder_ = null;
            }
            this.url_ = "";
            this.networkType_ = null;
            SingleFieldBuilder<NetworkType, NetworkType.Builder, NetworkTypeOrBuilder> singleFieldBuilder2 = this.networkTypeBuilder_;
            if (singleFieldBuilder2 != null) {
                singleFieldBuilder2.dispose();
                this.networkTypeBuilder_ = null;
            }
            this.createdAt_ = null;
            SingleFieldBuilder<Timestamp, Timestamp.Builder, TimestampOrBuilder> singleFieldBuilder3 = this.createdAtBuilder_;
            if (singleFieldBuilder3 != null) {
                singleFieldBuilder3.dispose();
                this.createdAtBuilder_ = null;
            }
            this.updatedAt_ = null;
            SingleFieldBuilder<Timestamp, Timestamp.Builder, TimestampOrBuilder> singleFieldBuilder4 = this.updatedAtBuilder_;
            if (singleFieldBuilder4 != null) {
                singleFieldBuilder4.dispose();
                this.updatedAtBuilder_ = null;
            }
            this.checksum_ = "";
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
        public Descriptors.Descriptor getDescriptorForType() {
            return Igdbproto.internal_static_proto_EventNetwork_descriptor;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public EventNetwork getDefaultInstanceForType() {
            return EventNetwork.getDefaultInstance();
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public EventNetwork build() {
            EventNetwork eventNetworkBuildPartial = buildPartial();
            if (eventNetworkBuildPartial.isInitialized()) {
                return eventNetworkBuildPartial;
            }
            throw newUninitializedMessageException((Message) eventNetworkBuildPartial);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public EventNetwork buildPartial() {
            EventNetwork eventNetwork = new EventNetwork(this, null);
            if (this.bitField0_ != 0) {
                buildPartial0(eventNetwork);
            }
            onBuilt();
            return eventNetwork;
        }

        private void buildPartial0(EventNetwork eventNetwork) {
            int i;
            Timestamp timestamp;
            Timestamp timestamp2;
            NetworkType networkType;
            Event event;
            int i2 = this.bitField0_;
            if ((i2 & 1) != 0) {
                eventNetwork.id_ = this.id_;
            }
            if ((i2 & 2) != 0) {
                SingleFieldBuilder<Event, Event.Builder, EventOrBuilder> singleFieldBuilder = this.eventBuilder_;
                if (singleFieldBuilder == null) {
                    event = this.event_;
                } else {
                    event = (Event) singleFieldBuilder.build();
                }
                eventNetwork.event_ = event;
                i = 1;
            } else {
                i = 0;
            }
            if ((i2 & 4) != 0) {
                eventNetwork.url_ = this.url_;
            }
            if ((i2 & 8) != 0) {
                SingleFieldBuilder<NetworkType, NetworkType.Builder, NetworkTypeOrBuilder> singleFieldBuilder2 = this.networkTypeBuilder_;
                if (singleFieldBuilder2 == null) {
                    networkType = this.networkType_;
                } else {
                    networkType = (NetworkType) singleFieldBuilder2.build();
                }
                eventNetwork.networkType_ = networkType;
                i |= 2;
            }
            if ((i2 & 16) != 0) {
                SingleFieldBuilder<Timestamp, Timestamp.Builder, TimestampOrBuilder> singleFieldBuilder3 = this.createdAtBuilder_;
                if (singleFieldBuilder3 == null) {
                    timestamp2 = this.createdAt_;
                } else {
                    timestamp2 = (Timestamp) singleFieldBuilder3.build();
                }
                eventNetwork.createdAt_ = timestamp2;
                i |= 4;
            }
            if ((i2 & 32) != 0) {
                SingleFieldBuilder<Timestamp, Timestamp.Builder, TimestampOrBuilder> singleFieldBuilder4 = this.updatedAtBuilder_;
                if (singleFieldBuilder4 == null) {
                    timestamp = this.updatedAt_;
                } else {
                    timestamp = (Timestamp) singleFieldBuilder4.build();
                }
                eventNetwork.updatedAt_ = timestamp;
                i |= 8;
            }
            if ((i2 & 64) != 0) {
                eventNetwork.checksum_ = this.checksum_;
            }
            eventNetwork.bitField0_ |= i;
        }

        @Override // proto.EventNetworkOrBuilder
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

        @Override // proto.EventNetworkOrBuilder
        public boolean hasEvent() {
            return (this.bitField0_ & 2) != 0;
        }

        @Override // proto.EventNetworkOrBuilder
        public Event getEvent() {
            SingleFieldBuilder<Event, Event.Builder, EventOrBuilder> singleFieldBuilder = this.eventBuilder_;
            if (singleFieldBuilder == null) {
                Event event = this.event_;
                return event == null ? Event.getDefaultInstance() : event;
            }
            return (Event) singleFieldBuilder.getMessage();
        }

        public Builder setEvent(Event event) {
            SingleFieldBuilder<Event, Event.Builder, EventOrBuilder> singleFieldBuilder = this.eventBuilder_;
            if (singleFieldBuilder == null) {
                event.getClass();
                this.event_ = event;
            } else {
                singleFieldBuilder.setMessage(event);
            }
            this.bitField0_ |= 2;
            onChanged();
            return this;
        }

        public Builder setEvent(Event.Builder builder) {
            SingleFieldBuilder<Event, Event.Builder, EventOrBuilder> singleFieldBuilder = this.eventBuilder_;
            if (singleFieldBuilder == null) {
                this.event_ = builder.build();
            } else {
                singleFieldBuilder.setMessage(builder.build());
            }
            this.bitField0_ |= 2;
            onChanged();
            return this;
        }

        public Builder mergeEvent(Event event) {
            Event event2;
            SingleFieldBuilder<Event, Event.Builder, EventOrBuilder> singleFieldBuilder = this.eventBuilder_;
            if (singleFieldBuilder == null) {
                if ((this.bitField0_ & 2) != 0 && (event2 = this.event_) != null && event2 != Event.getDefaultInstance()) {
                    getEventBuilder().mergeFrom((Message) event);
                } else {
                    this.event_ = event;
                }
            } else {
                singleFieldBuilder.mergeFrom(event);
            }
            if (this.event_ != null) {
                this.bitField0_ |= 2;
                onChanged();
            }
            return this;
        }

        public Builder clearEvent() {
            this.bitField0_ &= -3;
            this.event_ = null;
            SingleFieldBuilder<Event, Event.Builder, EventOrBuilder> singleFieldBuilder = this.eventBuilder_;
            if (singleFieldBuilder != null) {
                singleFieldBuilder.dispose();
                this.eventBuilder_ = null;
            }
            onChanged();
            return this;
        }

        public Event.Builder getEventBuilder() {
            this.bitField0_ |= 2;
            onChanged();
            return (Event.Builder) getEventFieldBuilder().getBuilder();
        }

        @Override // proto.EventNetworkOrBuilder
        public EventOrBuilder getEventOrBuilder() {
            SingleFieldBuilder<Event, Event.Builder, EventOrBuilder> singleFieldBuilder = this.eventBuilder_;
            if (singleFieldBuilder != null) {
                return (EventOrBuilder) singleFieldBuilder.getMessageOrBuilder();
            }
            Event event = this.event_;
            return event == null ? Event.getDefaultInstance() : event;
        }

        private SingleFieldBuilder<Event, Event.Builder, EventOrBuilder> getEventFieldBuilder() {
            if (this.eventBuilder_ == null) {
                this.eventBuilder_ = new SingleFieldBuilder<>(getEvent(), getParentForChildren(), isClean());
                this.event_ = null;
            }
            return this.eventBuilder_;
        }

        @Override // proto.EventNetworkOrBuilder
        public String getUrl() {
            Object obj = this.url_;
            if (!(obj instanceof String)) {
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.url_ = stringUtf8;
                return stringUtf8;
            }
            return (String) obj;
        }

        @Override // proto.EventNetworkOrBuilder
        public ByteString getUrlBytes() {
            Object obj = this.url_;
            if (obj instanceof String) {
                ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.url_ = byteStringCopyFromUtf8;
                return byteStringCopyFromUtf8;
            }
            return (ByteString) obj;
        }

        public Builder setUrl(String str) {
            str.getClass();
            this.url_ = str;
            this.bitField0_ |= 4;
            onChanged();
            return this;
        }

        public Builder clearUrl() {
            this.url_ = EventNetwork.getDefaultInstance().getUrl();
            this.bitField0_ &= -5;
            onChanged();
            return this;
        }

        public Builder setUrlBytes(ByteString byteString) {
            byteString.getClass();
            EventNetwork.checkByteStringIsUtf8(byteString);
            this.url_ = byteString;
            this.bitField0_ |= 4;
            onChanged();
            return this;
        }

        @Override // proto.EventNetworkOrBuilder
        public boolean hasNetworkType() {
            return (this.bitField0_ & 8) != 0;
        }

        @Override // proto.EventNetworkOrBuilder
        public NetworkType getNetworkType() {
            SingleFieldBuilder<NetworkType, NetworkType.Builder, NetworkTypeOrBuilder> singleFieldBuilder = this.networkTypeBuilder_;
            if (singleFieldBuilder == null) {
                NetworkType networkType = this.networkType_;
                return networkType == null ? NetworkType.getDefaultInstance() : networkType;
            }
            return (NetworkType) singleFieldBuilder.getMessage();
        }

        public Builder setNetworkType(NetworkType networkType) {
            SingleFieldBuilder<NetworkType, NetworkType.Builder, NetworkTypeOrBuilder> singleFieldBuilder = this.networkTypeBuilder_;
            if (singleFieldBuilder == null) {
                networkType.getClass();
                this.networkType_ = networkType;
            } else {
                singleFieldBuilder.setMessage(networkType);
            }
            this.bitField0_ |= 8;
            onChanged();
            return this;
        }

        public Builder setNetworkType(NetworkType.Builder builder) {
            SingleFieldBuilder<NetworkType, NetworkType.Builder, NetworkTypeOrBuilder> singleFieldBuilder = this.networkTypeBuilder_;
            if (singleFieldBuilder == null) {
                this.networkType_ = builder.build();
            } else {
                singleFieldBuilder.setMessage(builder.build());
            }
            this.bitField0_ |= 8;
            onChanged();
            return this;
        }

        public Builder mergeNetworkType(NetworkType networkType) {
            NetworkType networkType2;
            SingleFieldBuilder<NetworkType, NetworkType.Builder, NetworkTypeOrBuilder> singleFieldBuilder = this.networkTypeBuilder_;
            if (singleFieldBuilder == null) {
                if ((this.bitField0_ & 8) != 0 && (networkType2 = this.networkType_) != null && networkType2 != NetworkType.getDefaultInstance()) {
                    getNetworkTypeBuilder().mergeFrom((Message) networkType);
                } else {
                    this.networkType_ = networkType;
                }
            } else {
                singleFieldBuilder.mergeFrom(networkType);
            }
            if (this.networkType_ != null) {
                this.bitField0_ |= 8;
                onChanged();
            }
            return this;
        }

        public Builder clearNetworkType() {
            this.bitField0_ &= -9;
            this.networkType_ = null;
            SingleFieldBuilder<NetworkType, NetworkType.Builder, NetworkTypeOrBuilder> singleFieldBuilder = this.networkTypeBuilder_;
            if (singleFieldBuilder != null) {
                singleFieldBuilder.dispose();
                this.networkTypeBuilder_ = null;
            }
            onChanged();
            return this;
        }

        public NetworkType.Builder getNetworkTypeBuilder() {
            this.bitField0_ |= 8;
            onChanged();
            return (NetworkType.Builder) getNetworkTypeFieldBuilder().getBuilder();
        }

        @Override // proto.EventNetworkOrBuilder
        public NetworkTypeOrBuilder getNetworkTypeOrBuilder() {
            SingleFieldBuilder<NetworkType, NetworkType.Builder, NetworkTypeOrBuilder> singleFieldBuilder = this.networkTypeBuilder_;
            if (singleFieldBuilder != null) {
                return (NetworkTypeOrBuilder) singleFieldBuilder.getMessageOrBuilder();
            }
            NetworkType networkType = this.networkType_;
            return networkType == null ? NetworkType.getDefaultInstance() : networkType;
        }

        private SingleFieldBuilder<NetworkType, NetworkType.Builder, NetworkTypeOrBuilder> getNetworkTypeFieldBuilder() {
            if (this.networkTypeBuilder_ == null) {
                this.networkTypeBuilder_ = new SingleFieldBuilder<>(getNetworkType(), getParentForChildren(), isClean());
                this.networkType_ = null;
            }
            return this.networkTypeBuilder_;
        }

        @Override // proto.EventNetworkOrBuilder
        public boolean hasCreatedAt() {
            return (this.bitField0_ & 16) != 0;
        }

        @Override // proto.EventNetworkOrBuilder
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
            this.bitField0_ |= 16;
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
            this.bitField0_ |= 16;
            onChanged();
            return this;
        }

        public Builder mergeCreatedAt(Timestamp timestamp) {
            Timestamp timestamp2;
            SingleFieldBuilder<Timestamp, Timestamp.Builder, TimestampOrBuilder> singleFieldBuilder = this.createdAtBuilder_;
            if (singleFieldBuilder == null) {
                if ((this.bitField0_ & 16) != 0 && (timestamp2 = this.createdAt_) != null && timestamp2 != Timestamp.getDefaultInstance()) {
                    getCreatedAtBuilder().mergeFrom(timestamp);
                } else {
                    this.createdAt_ = timestamp;
                }
            } else {
                singleFieldBuilder.mergeFrom(timestamp);
            }
            if (this.createdAt_ != null) {
                this.bitField0_ |= 16;
                onChanged();
            }
            return this;
        }

        public Builder clearCreatedAt() {
            this.bitField0_ &= -17;
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
            this.bitField0_ |= 16;
            onChanged();
            return (Timestamp.Builder) getCreatedAtFieldBuilder().getBuilder();
        }

        @Override // proto.EventNetworkOrBuilder
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

        @Override // proto.EventNetworkOrBuilder
        public boolean hasUpdatedAt() {
            return (this.bitField0_ & 32) != 0;
        }

        @Override // proto.EventNetworkOrBuilder
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
            this.bitField0_ |= 32;
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
            this.bitField0_ |= 32;
            onChanged();
            return this;
        }

        public Builder mergeUpdatedAt(Timestamp timestamp) {
            Timestamp timestamp2;
            SingleFieldBuilder<Timestamp, Timestamp.Builder, TimestampOrBuilder> singleFieldBuilder = this.updatedAtBuilder_;
            if (singleFieldBuilder == null) {
                if ((this.bitField0_ & 32) != 0 && (timestamp2 = this.updatedAt_) != null && timestamp2 != Timestamp.getDefaultInstance()) {
                    getUpdatedAtBuilder().mergeFrom(timestamp);
                } else {
                    this.updatedAt_ = timestamp;
                }
            } else {
                singleFieldBuilder.mergeFrom(timestamp);
            }
            if (this.updatedAt_ != null) {
                this.bitField0_ |= 32;
                onChanged();
            }
            return this;
        }

        public Builder clearUpdatedAt() {
            this.bitField0_ &= -33;
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
            this.bitField0_ |= 32;
            onChanged();
            return (Timestamp.Builder) getUpdatedAtFieldBuilder().getBuilder();
        }

        @Override // proto.EventNetworkOrBuilder
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

        @Override // proto.EventNetworkOrBuilder
        public String getChecksum() {
            Object obj = this.checksum_;
            if (!(obj instanceof String)) {
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.checksum_ = stringUtf8;
                return stringUtf8;
            }
            return (String) obj;
        }

        @Override // proto.EventNetworkOrBuilder
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
            this.bitField0_ |= 64;
            onChanged();
            return this;
        }

        public Builder clearChecksum() {
            this.checksum_ = EventNetwork.getDefaultInstance().getChecksum();
            this.bitField0_ &= -65;
            onChanged();
            return this;
        }

        public Builder setChecksumBytes(ByteString byteString) {
            byteString.getClass();
            EventNetwork.checkByteStringIsUtf8(byteString);
            this.checksum_ = byteString;
            this.bitField0_ |= 64;
            onChanged();
            return this;
        }
    }

    public static EventNetwork getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* JADX INFO: renamed from: proto.EventNetwork$1, reason: invalid class name */
    class AnonymousClass1 extends AbstractParser<EventNetwork> {
        AnonymousClass1() {
        }

        @Override // com.google.protobuf.Parser
        public EventNetwork parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            Builder builderNewBuilder = EventNetwork.newBuilder();
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

    public static Parser<EventNetwork> parser() {
        return PARSER;
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Parser<EventNetwork> getParserForType() {
        return PARSER;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
    public EventNetwork getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }
}
