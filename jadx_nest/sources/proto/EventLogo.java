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
public final class EventLogo extends GeneratedMessage implements EventLogoOrBuilder {
    public static final int ALPHA_CHANNEL_FIELD_NUMBER = 3;
    public static final int ANIMATED_FIELD_NUMBER = 4;
    public static final int CHECKSUM_FIELD_NUMBER = 11;
    public static final int CREATED_AT_FIELD_NUMBER = 9;
    private static final EventLogo DEFAULT_INSTANCE;
    public static final int EVENT_FIELD_NUMBER = 2;
    public static final int HEIGHT_FIELD_NUMBER = 5;
    public static final int ID_FIELD_NUMBER = 1;
    public static final int IMAGE_ID_FIELD_NUMBER = 6;
    private static final Parser<EventLogo> PARSER;
    public static final int UPDATED_AT_FIELD_NUMBER = 10;
    public static final int URL_FIELD_NUMBER = 7;
    public static final int WIDTH_FIELD_NUMBER = 8;
    private static final long serialVersionUID = 0;
    private boolean alphaChannel_;
    private boolean animated_;
    private int bitField0_;
    private volatile Object checksum_;
    private Timestamp createdAt_;
    private Event event_;
    private int height_;
    private long id_;
    private volatile Object imageId_;
    private Timestamp updatedAt_;
    private volatile Object url_;
    private int width_;

    /* synthetic */ EventLogo(GeneratedMessage.Builder builder, EventLogoIA eventLogoIA) {
        this(builder);
    }

    static {
        RuntimeVersion.validateProtobufGencodeVersion(RuntimeVersion.RuntimeDomain.PUBLIC, 4, 27, 2, "", EventLogo.class.getName());
        DEFAULT_INSTANCE = new EventLogo();
        PARSER = new AnonymousClass1();
    }

    private EventLogo(GeneratedMessage.Builder<?> builder) {
        super(builder);
        this.id_ = 0L;
        this.alphaChannel_ = false;
        this.animated_ = false;
        this.height_ = 0;
        this.imageId_ = "";
        this.url_ = "";
        this.width_ = 0;
        this.checksum_ = "";
    }

    private EventLogo() {
        this.id_ = 0L;
        this.alphaChannel_ = false;
        this.animated_ = false;
        this.height_ = 0;
        this.imageId_ = "";
        this.url_ = "";
        this.width_ = 0;
        this.checksum_ = "";
        this.imageId_ = "";
        this.url_ = "";
        this.checksum_ = "";
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return Igdbproto.internal_static_proto_EventLogo_descriptor;
    }

    @Override // com.google.protobuf.GeneratedMessage
    protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
        return Igdbproto.internal_static_proto_EventLogo_fieldAccessorTable.ensureFieldAccessorsInitialized(EventLogo.class, Builder.class);
    }

    @Override // proto.EventLogoOrBuilder
    public long getId() {
        return this.id_;
    }

    @Override // proto.EventLogoOrBuilder
    public boolean hasEvent() {
        return (this.bitField0_ & 1) != 0;
    }

    @Override // proto.EventLogoOrBuilder
    public Event getEvent() {
        Event event = this.event_;
        return event == null ? Event.getDefaultInstance() : event;
    }

    @Override // proto.EventLogoOrBuilder
    public EventOrBuilder getEventOrBuilder() {
        Event event = this.event_;
        return event == null ? Event.getDefaultInstance() : event;
    }

    @Override // proto.EventLogoOrBuilder
    public boolean getAlphaChannel() {
        return this.alphaChannel_;
    }

    @Override // proto.EventLogoOrBuilder
    public boolean getAnimated() {
        return this.animated_;
    }

    @Override // proto.EventLogoOrBuilder
    public int getHeight() {
        return this.height_;
    }

    @Override // proto.EventLogoOrBuilder
    public String getImageId() {
        Object obj = this.imageId_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.imageId_ = stringUtf8;
        return stringUtf8;
    }

    @Override // proto.EventLogoOrBuilder
    public ByteString getImageIdBytes() {
        Object obj = this.imageId_;
        if (obj instanceof String) {
            ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.imageId_ = byteStringCopyFromUtf8;
            return byteStringCopyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // proto.EventLogoOrBuilder
    public String getUrl() {
        Object obj = this.url_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.url_ = stringUtf8;
        return stringUtf8;
    }

    @Override // proto.EventLogoOrBuilder
    public ByteString getUrlBytes() {
        Object obj = this.url_;
        if (obj instanceof String) {
            ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.url_ = byteStringCopyFromUtf8;
            return byteStringCopyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // proto.EventLogoOrBuilder
    public int getWidth() {
        return this.width_;
    }

    @Override // proto.EventLogoOrBuilder
    public boolean hasCreatedAt() {
        return (this.bitField0_ & 2) != 0;
    }

    @Override // proto.EventLogoOrBuilder
    public Timestamp getCreatedAt() {
        Timestamp timestamp = this.createdAt_;
        return timestamp == null ? Timestamp.getDefaultInstance() : timestamp;
    }

    @Override // proto.EventLogoOrBuilder
    public TimestampOrBuilder getCreatedAtOrBuilder() {
        Timestamp timestamp = this.createdAt_;
        return timestamp == null ? Timestamp.getDefaultInstance() : timestamp;
    }

    @Override // proto.EventLogoOrBuilder
    public boolean hasUpdatedAt() {
        return (this.bitField0_ & 4) != 0;
    }

    @Override // proto.EventLogoOrBuilder
    public Timestamp getUpdatedAt() {
        Timestamp timestamp = this.updatedAt_;
        return timestamp == null ? Timestamp.getDefaultInstance() : timestamp;
    }

    @Override // proto.EventLogoOrBuilder
    public TimestampOrBuilder getUpdatedAtOrBuilder() {
        Timestamp timestamp = this.updatedAt_;
        return timestamp == null ? Timestamp.getDefaultInstance() : timestamp;
    }

    @Override // proto.EventLogoOrBuilder
    public String getChecksum() {
        Object obj = this.checksum_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.checksum_ = stringUtf8;
        return stringUtf8;
    }

    @Override // proto.EventLogoOrBuilder
    public ByteString getChecksumBytes() {
        Object obj = this.checksum_;
        if (obj instanceof String) {
            ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.checksum_ = byteStringCopyFromUtf8;
            return byteStringCopyFromUtf8;
        }
        return (ByteString) obj;
    }

    public static EventLogo parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer);
    }

    public static EventLogo parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    public static EventLogo parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString);
    }

    public static EventLogo parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static EventLogo parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr);
    }

    public static EventLogo parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr, extensionRegistryLite);
    }

    public static EventLogo parseFrom(InputStream inputStream) throws IOException {
        return (EventLogo) GeneratedMessage.parseWithIOException(PARSER, inputStream);
    }

    public static EventLogo parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (EventLogo) GeneratedMessage.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static EventLogo parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (EventLogo) GeneratedMessage.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static EventLogo parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (EventLogo) GeneratedMessage.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static EventLogo parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (EventLogo) GeneratedMessage.parseWithIOException(PARSER, codedInputStream);
    }

    public static EventLogo parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (EventLogo) GeneratedMessage.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder newBuilderForType() {
        return newBuilder();
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static Builder newBuilder(EventLogo eventLogo) {
        return (Builder) DEFAULT_INSTANCE.toBuilder().mergeFrom((Message) eventLogo);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder toBuilder() {
        return this == DEFAULT_INSTANCE ? new Builder((EventLogoIA) null) : (Builder) new Builder((EventLogoIA) null).mergeFrom((Message) this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.AbstractMessage
    public Builder newBuilderForType(AbstractMessage.BuilderParent builderParent) {
        return new Builder(builderParent, null);
    }

    public static final class Builder extends GeneratedMessage.Builder<Builder> implements EventLogoOrBuilder {
        private boolean alphaChannel_;
        private boolean animated_;
        private int bitField0_;
        private Object checksum_;
        private SingleFieldBuilder<Timestamp, Timestamp.Builder, TimestampOrBuilder> createdAtBuilder_;
        private Timestamp createdAt_;
        private SingleFieldBuilder<Event, Event.Builder, EventOrBuilder> eventBuilder_;
        private Event event_;
        private int height_;
        private long id_;
        private Object imageId_;
        private SingleFieldBuilder<Timestamp, Timestamp.Builder, TimestampOrBuilder> updatedAtBuilder_;
        private Timestamp updatedAt_;
        private Object url_;
        private int width_;

        /* synthetic */ Builder(AbstractMessage.BuilderParent builderParent, EventLogoIA eventLogoIA) {
            this(builderParent);
        }

        /* synthetic */ Builder(EventLogoIA eventLogoIA) {
            this();
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return Igdbproto.internal_static_proto_EventLogo_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder
        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return Igdbproto.internal_static_proto_EventLogo_fieldAccessorTable.ensureFieldAccessorsInitialized(EventLogo.class, Builder.class);
        }

        private Builder() {
            this.imageId_ = "";
            this.url_ = "";
            this.checksum_ = "";
            maybeForceBuilderInitialization();
        }

        private Builder(AbstractMessage.BuilderParent builderParent) {
            super(builderParent);
            this.imageId_ = "";
            this.url_ = "";
            this.checksum_ = "";
            maybeForceBuilderInitialization();
        }

        private void maybeForceBuilderInitialization() {
            if (EventLogo.alwaysUseFieldBuilders) {
                getEventFieldBuilder();
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
            this.alphaChannel_ = false;
            this.animated_ = false;
            this.height_ = 0;
            this.imageId_ = "";
            this.url_ = "";
            this.width_ = 0;
            this.createdAt_ = null;
            SingleFieldBuilder<Timestamp, Timestamp.Builder, TimestampOrBuilder> singleFieldBuilder2 = this.createdAtBuilder_;
            if (singleFieldBuilder2 != null) {
                singleFieldBuilder2.dispose();
                this.createdAtBuilder_ = null;
            }
            this.updatedAt_ = null;
            SingleFieldBuilder<Timestamp, Timestamp.Builder, TimestampOrBuilder> singleFieldBuilder3 = this.updatedAtBuilder_;
            if (singleFieldBuilder3 != null) {
                singleFieldBuilder3.dispose();
                this.updatedAtBuilder_ = null;
            }
            this.checksum_ = "";
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
        public Descriptors.Descriptor getDescriptorForType() {
            return Igdbproto.internal_static_proto_EventLogo_descriptor;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public EventLogo getDefaultInstanceForType() {
            return EventLogo.getDefaultInstance();
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public EventLogo build() {
            EventLogo eventLogoBuildPartial = buildPartial();
            if (eventLogoBuildPartial.isInitialized()) {
                return eventLogoBuildPartial;
            }
            throw newUninitializedMessageException((Message) eventLogoBuildPartial);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public EventLogo buildPartial() {
            EventLogo eventLogo = new EventLogo(this, null);
            if (this.bitField0_ != 0) {
                buildPartial0(eventLogo);
            }
            onBuilt();
            return eventLogo;
        }

        private void buildPartial0(EventLogo eventLogo) {
            int i;
            Timestamp timestamp;
            Timestamp timestamp2;
            Event event;
            int i2 = this.bitField0_;
            if ((i2 & 1) != 0) {
                eventLogo.id_ = this.id_;
            }
            if ((i2 & 2) != 0) {
                SingleFieldBuilder<Event, Event.Builder, EventOrBuilder> singleFieldBuilder = this.eventBuilder_;
                if (singleFieldBuilder == null) {
                    event = this.event_;
                } else {
                    event = (Event) singleFieldBuilder.build();
                }
                eventLogo.event_ = event;
                i = 1;
            } else {
                i = 0;
            }
            if ((i2 & 4) != 0) {
                eventLogo.alphaChannel_ = this.alphaChannel_;
            }
            if ((i2 & 8) != 0) {
                eventLogo.animated_ = this.animated_;
            }
            if ((i2 & 16) != 0) {
                eventLogo.height_ = this.height_;
            }
            if ((i2 & 32) != 0) {
                eventLogo.imageId_ = this.imageId_;
            }
            if ((i2 & 64) != 0) {
                eventLogo.url_ = this.url_;
            }
            if ((i2 & 128) != 0) {
                eventLogo.width_ = this.width_;
            }
            if ((i2 & 256) != 0) {
                SingleFieldBuilder<Timestamp, Timestamp.Builder, TimestampOrBuilder> singleFieldBuilder2 = this.createdAtBuilder_;
                if (singleFieldBuilder2 == null) {
                    timestamp2 = this.createdAt_;
                } else {
                    timestamp2 = (Timestamp) singleFieldBuilder2.build();
                }
                eventLogo.createdAt_ = timestamp2;
                i |= 2;
            }
            if ((i2 & 512) != 0) {
                SingleFieldBuilder<Timestamp, Timestamp.Builder, TimestampOrBuilder> singleFieldBuilder3 = this.updatedAtBuilder_;
                if (singleFieldBuilder3 == null) {
                    timestamp = this.updatedAt_;
                } else {
                    timestamp = (Timestamp) singleFieldBuilder3.build();
                }
                eventLogo.updatedAt_ = timestamp;
                i |= 4;
            }
            if ((i2 & 1024) != 0) {
                eventLogo.checksum_ = this.checksum_;
            }
            eventLogo.bitField0_ |= i;
        }

        @Override // proto.EventLogoOrBuilder
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

        @Override // proto.EventLogoOrBuilder
        public boolean hasEvent() {
            return (this.bitField0_ & 2) != 0;
        }

        @Override // proto.EventLogoOrBuilder
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

        @Override // proto.EventLogoOrBuilder
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

        @Override // proto.EventLogoOrBuilder
        public boolean getAlphaChannel() {
            return this.alphaChannel_;
        }

        public Builder setAlphaChannel(boolean z) {
            this.alphaChannel_ = z;
            this.bitField0_ |= 4;
            onChanged();
            return this;
        }

        public Builder clearAlphaChannel() {
            this.bitField0_ &= -5;
            this.alphaChannel_ = false;
            onChanged();
            return this;
        }

        @Override // proto.EventLogoOrBuilder
        public boolean getAnimated() {
            return this.animated_;
        }

        public Builder setAnimated(boolean z) {
            this.animated_ = z;
            this.bitField0_ |= 8;
            onChanged();
            return this;
        }

        public Builder clearAnimated() {
            this.bitField0_ &= -9;
            this.animated_ = false;
            onChanged();
            return this;
        }

        @Override // proto.EventLogoOrBuilder
        public int getHeight() {
            return this.height_;
        }

        public Builder setHeight(int i) {
            this.height_ = i;
            this.bitField0_ |= 16;
            onChanged();
            return this;
        }

        public Builder clearHeight() {
            this.bitField0_ &= -17;
            this.height_ = 0;
            onChanged();
            return this;
        }

        @Override // proto.EventLogoOrBuilder
        public String getImageId() {
            Object obj = this.imageId_;
            if (!(obj instanceof String)) {
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.imageId_ = stringUtf8;
                return stringUtf8;
            }
            return (String) obj;
        }

        @Override // proto.EventLogoOrBuilder
        public ByteString getImageIdBytes() {
            Object obj = this.imageId_;
            if (obj instanceof String) {
                ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.imageId_ = byteStringCopyFromUtf8;
                return byteStringCopyFromUtf8;
            }
            return (ByteString) obj;
        }

        public Builder setImageId(String str) {
            str.getClass();
            this.imageId_ = str;
            this.bitField0_ |= 32;
            onChanged();
            return this;
        }

        public Builder clearImageId() {
            this.imageId_ = EventLogo.getDefaultInstance().getImageId();
            this.bitField0_ &= -33;
            onChanged();
            return this;
        }

        public Builder setImageIdBytes(ByteString byteString) {
            byteString.getClass();
            EventLogo.checkByteStringIsUtf8(byteString);
            this.imageId_ = byteString;
            this.bitField0_ |= 32;
            onChanged();
            return this;
        }

        @Override // proto.EventLogoOrBuilder
        public String getUrl() {
            Object obj = this.url_;
            if (!(obj instanceof String)) {
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.url_ = stringUtf8;
                return stringUtf8;
            }
            return (String) obj;
        }

        @Override // proto.EventLogoOrBuilder
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
            this.bitField0_ |= 64;
            onChanged();
            return this;
        }

        public Builder clearUrl() {
            this.url_ = EventLogo.getDefaultInstance().getUrl();
            this.bitField0_ &= -65;
            onChanged();
            return this;
        }

        public Builder setUrlBytes(ByteString byteString) {
            byteString.getClass();
            EventLogo.checkByteStringIsUtf8(byteString);
            this.url_ = byteString;
            this.bitField0_ |= 64;
            onChanged();
            return this;
        }

        @Override // proto.EventLogoOrBuilder
        public int getWidth() {
            return this.width_;
        }

        public Builder setWidth(int i) {
            this.width_ = i;
            this.bitField0_ |= 128;
            onChanged();
            return this;
        }

        public Builder clearWidth() {
            this.bitField0_ &= -129;
            this.width_ = 0;
            onChanged();
            return this;
        }

        @Override // proto.EventLogoOrBuilder
        public boolean hasCreatedAt() {
            return (this.bitField0_ & 256) != 0;
        }

        @Override // proto.EventLogoOrBuilder
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
            this.bitField0_ |= 256;
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
            this.bitField0_ |= 256;
            onChanged();
            return this;
        }

        public Builder mergeCreatedAt(Timestamp timestamp) {
            Timestamp timestamp2;
            SingleFieldBuilder<Timestamp, Timestamp.Builder, TimestampOrBuilder> singleFieldBuilder = this.createdAtBuilder_;
            if (singleFieldBuilder == null) {
                if ((this.bitField0_ & 256) != 0 && (timestamp2 = this.createdAt_) != null && timestamp2 != Timestamp.getDefaultInstance()) {
                    getCreatedAtBuilder().mergeFrom(timestamp);
                } else {
                    this.createdAt_ = timestamp;
                }
            } else {
                singleFieldBuilder.mergeFrom(timestamp);
            }
            if (this.createdAt_ != null) {
                this.bitField0_ |= 256;
                onChanged();
            }
            return this;
        }

        public Builder clearCreatedAt() {
            this.bitField0_ &= -257;
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
            this.bitField0_ |= 256;
            onChanged();
            return (Timestamp.Builder) getCreatedAtFieldBuilder().getBuilder();
        }

        @Override // proto.EventLogoOrBuilder
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

        @Override // proto.EventLogoOrBuilder
        public boolean hasUpdatedAt() {
            return (this.bitField0_ & 512) != 0;
        }

        @Override // proto.EventLogoOrBuilder
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
            this.bitField0_ |= 512;
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
            this.bitField0_ |= 512;
            onChanged();
            return this;
        }

        public Builder mergeUpdatedAt(Timestamp timestamp) {
            Timestamp timestamp2;
            SingleFieldBuilder<Timestamp, Timestamp.Builder, TimestampOrBuilder> singleFieldBuilder = this.updatedAtBuilder_;
            if (singleFieldBuilder == null) {
                if ((this.bitField0_ & 512) != 0 && (timestamp2 = this.updatedAt_) != null && timestamp2 != Timestamp.getDefaultInstance()) {
                    getUpdatedAtBuilder().mergeFrom(timestamp);
                } else {
                    this.updatedAt_ = timestamp;
                }
            } else {
                singleFieldBuilder.mergeFrom(timestamp);
            }
            if (this.updatedAt_ != null) {
                this.bitField0_ |= 512;
                onChanged();
            }
            return this;
        }

        public Builder clearUpdatedAt() {
            this.bitField0_ &= -513;
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
            this.bitField0_ |= 512;
            onChanged();
            return (Timestamp.Builder) getUpdatedAtFieldBuilder().getBuilder();
        }

        @Override // proto.EventLogoOrBuilder
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

        @Override // proto.EventLogoOrBuilder
        public String getChecksum() {
            Object obj = this.checksum_;
            if (!(obj instanceof String)) {
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.checksum_ = stringUtf8;
                return stringUtf8;
            }
            return (String) obj;
        }

        @Override // proto.EventLogoOrBuilder
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
            this.bitField0_ |= 1024;
            onChanged();
            return this;
        }

        public Builder clearChecksum() {
            this.checksum_ = EventLogo.getDefaultInstance().getChecksum();
            this.bitField0_ &= -1025;
            onChanged();
            return this;
        }

        public Builder setChecksumBytes(ByteString byteString) {
            byteString.getClass();
            EventLogo.checkByteStringIsUtf8(byteString);
            this.checksum_ = byteString;
            this.bitField0_ |= 1024;
            onChanged();
            return this;
        }
    }

    public static EventLogo getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* JADX INFO: renamed from: proto.EventLogo$1, reason: invalid class name */
    class AnonymousClass1 extends AbstractParser<EventLogo> {
        AnonymousClass1() {
        }

        @Override // com.google.protobuf.Parser
        public EventLogo parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            Builder builderNewBuilder = EventLogo.newBuilder();
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

    public static Parser<EventLogo> parser() {
        return PARSER;
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Parser<EventLogo> getParserForType() {
        return PARSER;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
    public EventLogo getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }
}
