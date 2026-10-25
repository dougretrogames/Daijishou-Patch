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

/* JADX INFO: loaded from: classes6.dex */
public final class Event extends GeneratedMessage implements EventOrBuilder {
    public static final int CHECKSUM_FIELD_NUMBER = 15;
    public static final int CREATED_AT_FIELD_NUMBER = 13;
    private static final Event DEFAULT_INSTANCE;
    public static final int DESCRIPTION_FIELD_NUMBER = 3;
    public static final int END_TIME_FIELD_NUMBER = 8;
    public static final int EVENT_LOGO_FIELD_NUMBER = 5;
    public static final int EVENT_NETWORKS_FIELD_NUMBER = 12;
    public static final int GAMES_FIELD_NUMBER = 10;
    public static final int ID_FIELD_NUMBER = 1;
    public static final int LIVE_STREAM_URL_FIELD_NUMBER = 9;
    public static final int NAME_FIELD_NUMBER = 2;
    private static final Parser<Event> PARSER;
    public static final int SLUG_FIELD_NUMBER = 4;
    public static final int START_TIME_FIELD_NUMBER = 6;
    public static final int TIME_ZONE_FIELD_NUMBER = 7;
    public static final int UPDATED_AT_FIELD_NUMBER = 14;
    public static final int VIDEOS_FIELD_NUMBER = 11;
    private static final long serialVersionUID = 0;
    private int bitField0_;
    private volatile Object checksum_;
    private Timestamp createdAt_;
    private volatile Object description_;
    private Timestamp endTime_;
    private EventLogo eventLogo_;
    private List<EventNetwork> eventNetworks_;
    private List<Game> games_;
    private long id_;
    private volatile Object liveStreamUrl_;
    private volatile Object name_;
    private volatile Object slug_;
    private Timestamp startTime_;
    private volatile Object timeZone_;
    private Timestamp updatedAt_;
    private List<GameVideo> videos_;

    /* synthetic */ Event(GeneratedMessage.Builder builder, EventIA eventIA) {
        this(builder);
    }

    static {
        RuntimeVersion.validateProtobufGencodeVersion(RuntimeVersion.RuntimeDomain.PUBLIC, 4, 27, 2, "", Event.class.getName());
        DEFAULT_INSTANCE = new Event();
        PARSER = new AnonymousClass1();
    }

    private Event(GeneratedMessage.Builder<?> builder) {
        super(builder);
        this.id_ = 0L;
        this.name_ = "";
        this.description_ = "";
        this.slug_ = "";
        this.timeZone_ = "";
        this.liveStreamUrl_ = "";
        this.checksum_ = "";
    }

    private Event() {
        this.id_ = 0L;
        this.name_ = "";
        this.description_ = "";
        this.slug_ = "";
        this.timeZone_ = "";
        this.liveStreamUrl_ = "";
        this.checksum_ = "";
        this.name_ = "";
        this.description_ = "";
        this.slug_ = "";
        this.timeZone_ = "";
        this.liveStreamUrl_ = "";
        this.games_ = Collections.emptyList();
        this.videos_ = Collections.emptyList();
        this.eventNetworks_ = Collections.emptyList();
        this.checksum_ = "";
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return Igdbproto.internal_static_proto_Event_descriptor;
    }

    @Override // com.google.protobuf.GeneratedMessage
    protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
        return Igdbproto.internal_static_proto_Event_fieldAccessorTable.ensureFieldAccessorsInitialized(Event.class, Builder.class);
    }

    @Override // proto.EventOrBuilder
    public long getId() {
        return this.id_;
    }

    @Override // proto.EventOrBuilder
    public String getName() {
        Object obj = this.name_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.name_ = stringUtf8;
        return stringUtf8;
    }

    @Override // proto.EventOrBuilder
    public ByteString getNameBytes() {
        Object obj = this.name_;
        if (obj instanceof String) {
            ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.name_ = byteStringCopyFromUtf8;
            return byteStringCopyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // proto.EventOrBuilder
    public String getDescription() {
        Object obj = this.description_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.description_ = stringUtf8;
        return stringUtf8;
    }

    @Override // proto.EventOrBuilder
    public ByteString getDescriptionBytes() {
        Object obj = this.description_;
        if (obj instanceof String) {
            ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.description_ = byteStringCopyFromUtf8;
            return byteStringCopyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // proto.EventOrBuilder
    public String getSlug() {
        Object obj = this.slug_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.slug_ = stringUtf8;
        return stringUtf8;
    }

    @Override // proto.EventOrBuilder
    public ByteString getSlugBytes() {
        Object obj = this.slug_;
        if (obj instanceof String) {
            ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.slug_ = byteStringCopyFromUtf8;
            return byteStringCopyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // proto.EventOrBuilder
    public boolean hasEventLogo() {
        return (this.bitField0_ & 1) != 0;
    }

    @Override // proto.EventOrBuilder
    public EventLogo getEventLogo() {
        EventLogo eventLogo = this.eventLogo_;
        return eventLogo == null ? EventLogo.getDefaultInstance() : eventLogo;
    }

    @Override // proto.EventOrBuilder
    public EventLogoOrBuilder getEventLogoOrBuilder() {
        EventLogo eventLogo = this.eventLogo_;
        return eventLogo == null ? EventLogo.getDefaultInstance() : eventLogo;
    }

    @Override // proto.EventOrBuilder
    public boolean hasStartTime() {
        return (this.bitField0_ & 2) != 0;
    }

    @Override // proto.EventOrBuilder
    public Timestamp getStartTime() {
        Timestamp timestamp = this.startTime_;
        return timestamp == null ? Timestamp.getDefaultInstance() : timestamp;
    }

    @Override // proto.EventOrBuilder
    public TimestampOrBuilder getStartTimeOrBuilder() {
        Timestamp timestamp = this.startTime_;
        return timestamp == null ? Timestamp.getDefaultInstance() : timestamp;
    }

    @Override // proto.EventOrBuilder
    public String getTimeZone() {
        Object obj = this.timeZone_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.timeZone_ = stringUtf8;
        return stringUtf8;
    }

    @Override // proto.EventOrBuilder
    public ByteString getTimeZoneBytes() {
        Object obj = this.timeZone_;
        if (obj instanceof String) {
            ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.timeZone_ = byteStringCopyFromUtf8;
            return byteStringCopyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // proto.EventOrBuilder
    public boolean hasEndTime() {
        return (this.bitField0_ & 4) != 0;
    }

    @Override // proto.EventOrBuilder
    public Timestamp getEndTime() {
        Timestamp timestamp = this.endTime_;
        return timestamp == null ? Timestamp.getDefaultInstance() : timestamp;
    }

    @Override // proto.EventOrBuilder
    public TimestampOrBuilder getEndTimeOrBuilder() {
        Timestamp timestamp = this.endTime_;
        return timestamp == null ? Timestamp.getDefaultInstance() : timestamp;
    }

    @Override // proto.EventOrBuilder
    public String getLiveStreamUrl() {
        Object obj = this.liveStreamUrl_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.liveStreamUrl_ = stringUtf8;
        return stringUtf8;
    }

    @Override // proto.EventOrBuilder
    public ByteString getLiveStreamUrlBytes() {
        Object obj = this.liveStreamUrl_;
        if (obj instanceof String) {
            ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.liveStreamUrl_ = byteStringCopyFromUtf8;
            return byteStringCopyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // proto.EventOrBuilder
    public List<Game> getGamesList() {
        return this.games_;
    }

    @Override // proto.EventOrBuilder
    public List<? extends GameOrBuilder> getGamesOrBuilderList() {
        return this.games_;
    }

    @Override // proto.EventOrBuilder
    public int getGamesCount() {
        return this.games_.size();
    }

    @Override // proto.EventOrBuilder
    public Game getGames(int i) {
        return this.games_.get(i);
    }

    @Override // proto.EventOrBuilder
    public GameOrBuilder getGamesOrBuilder(int i) {
        return this.games_.get(i);
    }

    @Override // proto.EventOrBuilder
    public List<GameVideo> getVideosList() {
        return this.videos_;
    }

    @Override // proto.EventOrBuilder
    public List<? extends GameVideoOrBuilder> getVideosOrBuilderList() {
        return this.videos_;
    }

    @Override // proto.EventOrBuilder
    public int getVideosCount() {
        return this.videos_.size();
    }

    @Override // proto.EventOrBuilder
    public GameVideo getVideos(int i) {
        return this.videos_.get(i);
    }

    @Override // proto.EventOrBuilder
    public GameVideoOrBuilder getVideosOrBuilder(int i) {
        return this.videos_.get(i);
    }

    @Override // proto.EventOrBuilder
    public List<EventNetwork> getEventNetworksList() {
        return this.eventNetworks_;
    }

    @Override // proto.EventOrBuilder
    public List<? extends EventNetworkOrBuilder> getEventNetworksOrBuilderList() {
        return this.eventNetworks_;
    }

    @Override // proto.EventOrBuilder
    public int getEventNetworksCount() {
        return this.eventNetworks_.size();
    }

    @Override // proto.EventOrBuilder
    public EventNetwork getEventNetworks(int i) {
        return this.eventNetworks_.get(i);
    }

    @Override // proto.EventOrBuilder
    public EventNetworkOrBuilder getEventNetworksOrBuilder(int i) {
        return this.eventNetworks_.get(i);
    }

    @Override // proto.EventOrBuilder
    public boolean hasCreatedAt() {
        return (this.bitField0_ & 8) != 0;
    }

    @Override // proto.EventOrBuilder
    public Timestamp getCreatedAt() {
        Timestamp timestamp = this.createdAt_;
        return timestamp == null ? Timestamp.getDefaultInstance() : timestamp;
    }

    @Override // proto.EventOrBuilder
    public TimestampOrBuilder getCreatedAtOrBuilder() {
        Timestamp timestamp = this.createdAt_;
        return timestamp == null ? Timestamp.getDefaultInstance() : timestamp;
    }

    @Override // proto.EventOrBuilder
    public boolean hasUpdatedAt() {
        return (this.bitField0_ & 16) != 0;
    }

    @Override // proto.EventOrBuilder
    public Timestamp getUpdatedAt() {
        Timestamp timestamp = this.updatedAt_;
        return timestamp == null ? Timestamp.getDefaultInstance() : timestamp;
    }

    @Override // proto.EventOrBuilder
    public TimestampOrBuilder getUpdatedAtOrBuilder() {
        Timestamp timestamp = this.updatedAt_;
        return timestamp == null ? Timestamp.getDefaultInstance() : timestamp;
    }

    @Override // proto.EventOrBuilder
    public String getChecksum() {
        Object obj = this.checksum_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.checksum_ = stringUtf8;
        return stringUtf8;
    }

    @Override // proto.EventOrBuilder
    public ByteString getChecksumBytes() {
        Object obj = this.checksum_;
        if (obj instanceof String) {
            ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.checksum_ = byteStringCopyFromUtf8;
            return byteStringCopyFromUtf8;
        }
        return (ByteString) obj;
    }

    public static Event parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer);
    }

    public static Event parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    public static Event parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString);
    }

    public static Event parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static Event parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr);
    }

    public static Event parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr, extensionRegistryLite);
    }

    public static Event parseFrom(InputStream inputStream) throws IOException {
        return (Event) GeneratedMessage.parseWithIOException(PARSER, inputStream);
    }

    public static Event parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Event) GeneratedMessage.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static Event parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (Event) GeneratedMessage.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static Event parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Event) GeneratedMessage.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static Event parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (Event) GeneratedMessage.parseWithIOException(PARSER, codedInputStream);
    }

    public static Event parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Event) GeneratedMessage.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder newBuilderForType() {
        return newBuilder();
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static Builder newBuilder(Event event) {
        return (Builder) DEFAULT_INSTANCE.toBuilder().mergeFrom((Message) event);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder toBuilder() {
        return this == DEFAULT_INSTANCE ? new Builder((EventIA) null) : (Builder) new Builder((EventIA) null).mergeFrom((Message) this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.AbstractMessage
    public Builder newBuilderForType(AbstractMessage.BuilderParent builderParent) {
        return new Builder(builderParent, null);
    }

    public static final class Builder extends GeneratedMessage.Builder<Builder> implements EventOrBuilder {
        private int bitField0_;
        private Object checksum_;
        private SingleFieldBuilder<Timestamp, Timestamp.Builder, TimestampOrBuilder> createdAtBuilder_;
        private Timestamp createdAt_;
        private Object description_;
        private SingleFieldBuilder<Timestamp, Timestamp.Builder, TimestampOrBuilder> endTimeBuilder_;
        private Timestamp endTime_;
        private SingleFieldBuilder<EventLogo, EventLogo.Builder, EventLogoOrBuilder> eventLogoBuilder_;
        private EventLogo eventLogo_;
        private RepeatedFieldBuilder<EventNetwork, EventNetwork.Builder, EventNetworkOrBuilder> eventNetworksBuilder_;
        private List<EventNetwork> eventNetworks_;
        private RepeatedFieldBuilder<Game, Game.Builder, GameOrBuilder> gamesBuilder_;
        private List<Game> games_;
        private long id_;
        private Object liveStreamUrl_;
        private Object name_;
        private Object slug_;
        private SingleFieldBuilder<Timestamp, Timestamp.Builder, TimestampOrBuilder> startTimeBuilder_;
        private Timestamp startTime_;
        private Object timeZone_;
        private SingleFieldBuilder<Timestamp, Timestamp.Builder, TimestampOrBuilder> updatedAtBuilder_;
        private Timestamp updatedAt_;
        private RepeatedFieldBuilder<GameVideo, GameVideo.Builder, GameVideoOrBuilder> videosBuilder_;
        private List<GameVideo> videos_;

        /* synthetic */ Builder(AbstractMessage.BuilderParent builderParent, EventIA eventIA) {
            this(builderParent);
        }

        /* synthetic */ Builder(EventIA eventIA) {
            this();
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return Igdbproto.internal_static_proto_Event_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder
        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return Igdbproto.internal_static_proto_Event_fieldAccessorTable.ensureFieldAccessorsInitialized(Event.class, Builder.class);
        }

        private Builder() {
            this.name_ = "";
            this.description_ = "";
            this.slug_ = "";
            this.timeZone_ = "";
            this.liveStreamUrl_ = "";
            this.games_ = Collections.emptyList();
            this.videos_ = Collections.emptyList();
            this.eventNetworks_ = Collections.emptyList();
            this.checksum_ = "";
            maybeForceBuilderInitialization();
        }

        private Builder(AbstractMessage.BuilderParent builderParent) {
            super(builderParent);
            this.name_ = "";
            this.description_ = "";
            this.slug_ = "";
            this.timeZone_ = "";
            this.liveStreamUrl_ = "";
            this.games_ = Collections.emptyList();
            this.videos_ = Collections.emptyList();
            this.eventNetworks_ = Collections.emptyList();
            this.checksum_ = "";
            maybeForceBuilderInitialization();
        }

        private void maybeForceBuilderInitialization() {
            if (Event.alwaysUseFieldBuilders) {
                getEventLogoFieldBuilder();
                getStartTimeFieldBuilder();
                getEndTimeFieldBuilder();
                getGamesFieldBuilder();
                getVideosFieldBuilder();
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
            this.description_ = "";
            this.slug_ = "";
            this.eventLogo_ = null;
            SingleFieldBuilder<EventLogo, EventLogo.Builder, EventLogoOrBuilder> singleFieldBuilder = this.eventLogoBuilder_;
            if (singleFieldBuilder != null) {
                singleFieldBuilder.dispose();
                this.eventLogoBuilder_ = null;
            }
            this.startTime_ = null;
            SingleFieldBuilder<Timestamp, Timestamp.Builder, TimestampOrBuilder> singleFieldBuilder2 = this.startTimeBuilder_;
            if (singleFieldBuilder2 != null) {
                singleFieldBuilder2.dispose();
                this.startTimeBuilder_ = null;
            }
            this.timeZone_ = "";
            this.endTime_ = null;
            SingleFieldBuilder<Timestamp, Timestamp.Builder, TimestampOrBuilder> singleFieldBuilder3 = this.endTimeBuilder_;
            if (singleFieldBuilder3 != null) {
                singleFieldBuilder3.dispose();
                this.endTimeBuilder_ = null;
            }
            this.liveStreamUrl_ = "";
            RepeatedFieldBuilder<Game, Game.Builder, GameOrBuilder> repeatedFieldBuilder = this.gamesBuilder_;
            if (repeatedFieldBuilder == null) {
                this.games_ = Collections.emptyList();
            } else {
                this.games_ = null;
                repeatedFieldBuilder.clear();
            }
            this.bitField0_ &= -513;
            RepeatedFieldBuilder<GameVideo, GameVideo.Builder, GameVideoOrBuilder> repeatedFieldBuilder2 = this.videosBuilder_;
            if (repeatedFieldBuilder2 == null) {
                this.videos_ = Collections.emptyList();
            } else {
                this.videos_ = null;
                repeatedFieldBuilder2.clear();
            }
            this.bitField0_ &= -1025;
            RepeatedFieldBuilder<EventNetwork, EventNetwork.Builder, EventNetworkOrBuilder> repeatedFieldBuilder3 = this.eventNetworksBuilder_;
            if (repeatedFieldBuilder3 == null) {
                this.eventNetworks_ = Collections.emptyList();
            } else {
                this.eventNetworks_ = null;
                repeatedFieldBuilder3.clear();
            }
            this.bitField0_ &= -2049;
            this.createdAt_ = null;
            SingleFieldBuilder<Timestamp, Timestamp.Builder, TimestampOrBuilder> singleFieldBuilder4 = this.createdAtBuilder_;
            if (singleFieldBuilder4 != null) {
                singleFieldBuilder4.dispose();
                this.createdAtBuilder_ = null;
            }
            this.updatedAt_ = null;
            SingleFieldBuilder<Timestamp, Timestamp.Builder, TimestampOrBuilder> singleFieldBuilder5 = this.updatedAtBuilder_;
            if (singleFieldBuilder5 != null) {
                singleFieldBuilder5.dispose();
                this.updatedAtBuilder_ = null;
            }
            this.checksum_ = "";
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
        public Descriptors.Descriptor getDescriptorForType() {
            return Igdbproto.internal_static_proto_Event_descriptor;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public Event getDefaultInstanceForType() {
            return Event.getDefaultInstance();
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Event build() {
            Event eventBuildPartial = buildPartial();
            if (eventBuildPartial.isInitialized()) {
                return eventBuildPartial;
            }
            throw newUninitializedMessageException((Message) eventBuildPartial);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Event buildPartial() {
            Event event = new Event(this, null);
            buildPartialRepeatedFields(event);
            if (this.bitField0_ != 0) {
                buildPartial0(event);
            }
            onBuilt();
            return event;
        }

        private void buildPartialRepeatedFields(Event event) {
            RepeatedFieldBuilder<Game, Game.Builder, GameOrBuilder> repeatedFieldBuilder = this.gamesBuilder_;
            if (repeatedFieldBuilder == null) {
                if ((this.bitField0_ & 512) != 0) {
                    this.games_ = Collections.unmodifiableList(this.games_);
                    this.bitField0_ &= -513;
                }
                event.games_ = this.games_;
            } else {
                event.games_ = repeatedFieldBuilder.build();
            }
            RepeatedFieldBuilder<GameVideo, GameVideo.Builder, GameVideoOrBuilder> repeatedFieldBuilder2 = this.videosBuilder_;
            if (repeatedFieldBuilder2 == null) {
                if ((this.bitField0_ & 1024) != 0) {
                    this.videos_ = Collections.unmodifiableList(this.videos_);
                    this.bitField0_ &= -1025;
                }
                event.videos_ = this.videos_;
            } else {
                event.videos_ = repeatedFieldBuilder2.build();
            }
            RepeatedFieldBuilder<EventNetwork, EventNetwork.Builder, EventNetworkOrBuilder> repeatedFieldBuilder3 = this.eventNetworksBuilder_;
            if (repeatedFieldBuilder3 == null) {
                if ((this.bitField0_ & 2048) != 0) {
                    this.eventNetworks_ = Collections.unmodifiableList(this.eventNetworks_);
                    this.bitField0_ &= -2049;
                }
                event.eventNetworks_ = this.eventNetworks_;
                return;
            }
            event.eventNetworks_ = repeatedFieldBuilder3.build();
        }

        private void buildPartial0(Event event) {
            int i;
            Timestamp timestamp;
            Timestamp timestamp2;
            Timestamp timestamp3;
            Timestamp timestamp4;
            EventLogo eventLogo;
            int i2 = this.bitField0_;
            if ((i2 & 1) != 0) {
                event.id_ = this.id_;
            }
            if ((i2 & 2) != 0) {
                event.name_ = this.name_;
            }
            if ((i2 & 4) != 0) {
                event.description_ = this.description_;
            }
            if ((i2 & 8) != 0) {
                event.slug_ = this.slug_;
            }
            if ((i2 & 16) != 0) {
                SingleFieldBuilder<EventLogo, EventLogo.Builder, EventLogoOrBuilder> singleFieldBuilder = this.eventLogoBuilder_;
                if (singleFieldBuilder == null) {
                    eventLogo = this.eventLogo_;
                } else {
                    eventLogo = (EventLogo) singleFieldBuilder.build();
                }
                event.eventLogo_ = eventLogo;
                i = 1;
            } else {
                i = 0;
            }
            if ((i2 & 32) != 0) {
                SingleFieldBuilder<Timestamp, Timestamp.Builder, TimestampOrBuilder> singleFieldBuilder2 = this.startTimeBuilder_;
                if (singleFieldBuilder2 == null) {
                    timestamp4 = this.startTime_;
                } else {
                    timestamp4 = (Timestamp) singleFieldBuilder2.build();
                }
                event.startTime_ = timestamp4;
                i |= 2;
            }
            if ((i2 & 64) != 0) {
                event.timeZone_ = this.timeZone_;
            }
            if ((i2 & 128) != 0) {
                SingleFieldBuilder<Timestamp, Timestamp.Builder, TimestampOrBuilder> singleFieldBuilder3 = this.endTimeBuilder_;
                if (singleFieldBuilder3 == null) {
                    timestamp3 = this.endTime_;
                } else {
                    timestamp3 = (Timestamp) singleFieldBuilder3.build();
                }
                event.endTime_ = timestamp3;
                i |= 4;
            }
            if ((i2 & 256) != 0) {
                event.liveStreamUrl_ = this.liveStreamUrl_;
            }
            if ((i2 & 4096) != 0) {
                SingleFieldBuilder<Timestamp, Timestamp.Builder, TimestampOrBuilder> singleFieldBuilder4 = this.createdAtBuilder_;
                if (singleFieldBuilder4 == null) {
                    timestamp2 = this.createdAt_;
                } else {
                    timestamp2 = (Timestamp) singleFieldBuilder4.build();
                }
                event.createdAt_ = timestamp2;
                i |= 8;
            }
            if ((i2 & 8192) != 0) {
                SingleFieldBuilder<Timestamp, Timestamp.Builder, TimestampOrBuilder> singleFieldBuilder5 = this.updatedAtBuilder_;
                if (singleFieldBuilder5 == null) {
                    timestamp = this.updatedAt_;
                } else {
                    timestamp = (Timestamp) singleFieldBuilder5.build();
                }
                event.updatedAt_ = timestamp;
                i |= 16;
            }
            if ((i2 & 16384) != 0) {
                event.checksum_ = this.checksum_;
            }
            event.bitField0_ |= i;
        }

        @Override // proto.EventOrBuilder
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

        @Override // proto.EventOrBuilder
        public String getName() {
            Object obj = this.name_;
            if (!(obj instanceof String)) {
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.name_ = stringUtf8;
                return stringUtf8;
            }
            return (String) obj;
        }

        @Override // proto.EventOrBuilder
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
            this.name_ = Event.getDefaultInstance().getName();
            this.bitField0_ &= -3;
            onChanged();
            return this;
        }

        public Builder setNameBytes(ByteString byteString) {
            byteString.getClass();
            Event.checkByteStringIsUtf8(byteString);
            this.name_ = byteString;
            this.bitField0_ |= 2;
            onChanged();
            return this;
        }

        @Override // proto.EventOrBuilder
        public String getDescription() {
            Object obj = this.description_;
            if (!(obj instanceof String)) {
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.description_ = stringUtf8;
                return stringUtf8;
            }
            return (String) obj;
        }

        @Override // proto.EventOrBuilder
        public ByteString getDescriptionBytes() {
            Object obj = this.description_;
            if (obj instanceof String) {
                ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.description_ = byteStringCopyFromUtf8;
                return byteStringCopyFromUtf8;
            }
            return (ByteString) obj;
        }

        public Builder setDescription(String str) {
            str.getClass();
            this.description_ = str;
            this.bitField0_ |= 4;
            onChanged();
            return this;
        }

        public Builder clearDescription() {
            this.description_ = Event.getDefaultInstance().getDescription();
            this.bitField0_ &= -5;
            onChanged();
            return this;
        }

        public Builder setDescriptionBytes(ByteString byteString) {
            byteString.getClass();
            Event.checkByteStringIsUtf8(byteString);
            this.description_ = byteString;
            this.bitField0_ |= 4;
            onChanged();
            return this;
        }

        @Override // proto.EventOrBuilder
        public String getSlug() {
            Object obj = this.slug_;
            if (!(obj instanceof String)) {
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.slug_ = stringUtf8;
                return stringUtf8;
            }
            return (String) obj;
        }

        @Override // proto.EventOrBuilder
        public ByteString getSlugBytes() {
            Object obj = this.slug_;
            if (obj instanceof String) {
                ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.slug_ = byteStringCopyFromUtf8;
                return byteStringCopyFromUtf8;
            }
            return (ByteString) obj;
        }

        public Builder setSlug(String str) {
            str.getClass();
            this.slug_ = str;
            this.bitField0_ |= 8;
            onChanged();
            return this;
        }

        public Builder clearSlug() {
            this.slug_ = Event.getDefaultInstance().getSlug();
            this.bitField0_ &= -9;
            onChanged();
            return this;
        }

        public Builder setSlugBytes(ByteString byteString) {
            byteString.getClass();
            Event.checkByteStringIsUtf8(byteString);
            this.slug_ = byteString;
            this.bitField0_ |= 8;
            onChanged();
            return this;
        }

        @Override // proto.EventOrBuilder
        public boolean hasEventLogo() {
            return (this.bitField0_ & 16) != 0;
        }

        @Override // proto.EventOrBuilder
        public EventLogo getEventLogo() {
            SingleFieldBuilder<EventLogo, EventLogo.Builder, EventLogoOrBuilder> singleFieldBuilder = this.eventLogoBuilder_;
            if (singleFieldBuilder == null) {
                EventLogo eventLogo = this.eventLogo_;
                return eventLogo == null ? EventLogo.getDefaultInstance() : eventLogo;
            }
            return (EventLogo) singleFieldBuilder.getMessage();
        }

        public Builder setEventLogo(EventLogo eventLogo) {
            SingleFieldBuilder<EventLogo, EventLogo.Builder, EventLogoOrBuilder> singleFieldBuilder = this.eventLogoBuilder_;
            if (singleFieldBuilder == null) {
                eventLogo.getClass();
                this.eventLogo_ = eventLogo;
            } else {
                singleFieldBuilder.setMessage(eventLogo);
            }
            this.bitField0_ |= 16;
            onChanged();
            return this;
        }

        public Builder setEventLogo(EventLogo.Builder builder) {
            SingleFieldBuilder<EventLogo, EventLogo.Builder, EventLogoOrBuilder> singleFieldBuilder = this.eventLogoBuilder_;
            if (singleFieldBuilder == null) {
                this.eventLogo_ = builder.build();
            } else {
                singleFieldBuilder.setMessage(builder.build());
            }
            this.bitField0_ |= 16;
            onChanged();
            return this;
        }

        public Builder mergeEventLogo(EventLogo eventLogo) {
            EventLogo eventLogo2;
            SingleFieldBuilder<EventLogo, EventLogo.Builder, EventLogoOrBuilder> singleFieldBuilder = this.eventLogoBuilder_;
            if (singleFieldBuilder == null) {
                if ((this.bitField0_ & 16) != 0 && (eventLogo2 = this.eventLogo_) != null && eventLogo2 != EventLogo.getDefaultInstance()) {
                    getEventLogoBuilder().mergeFrom((Message) eventLogo);
                } else {
                    this.eventLogo_ = eventLogo;
                }
            } else {
                singleFieldBuilder.mergeFrom(eventLogo);
            }
            if (this.eventLogo_ != null) {
                this.bitField0_ |= 16;
                onChanged();
            }
            return this;
        }

        public Builder clearEventLogo() {
            this.bitField0_ &= -17;
            this.eventLogo_ = null;
            SingleFieldBuilder<EventLogo, EventLogo.Builder, EventLogoOrBuilder> singleFieldBuilder = this.eventLogoBuilder_;
            if (singleFieldBuilder != null) {
                singleFieldBuilder.dispose();
                this.eventLogoBuilder_ = null;
            }
            onChanged();
            return this;
        }

        public EventLogo.Builder getEventLogoBuilder() {
            this.bitField0_ |= 16;
            onChanged();
            return (EventLogo.Builder) getEventLogoFieldBuilder().getBuilder();
        }

        @Override // proto.EventOrBuilder
        public EventLogoOrBuilder getEventLogoOrBuilder() {
            SingleFieldBuilder<EventLogo, EventLogo.Builder, EventLogoOrBuilder> singleFieldBuilder = this.eventLogoBuilder_;
            if (singleFieldBuilder != null) {
                return (EventLogoOrBuilder) singleFieldBuilder.getMessageOrBuilder();
            }
            EventLogo eventLogo = this.eventLogo_;
            return eventLogo == null ? EventLogo.getDefaultInstance() : eventLogo;
        }

        private SingleFieldBuilder<EventLogo, EventLogo.Builder, EventLogoOrBuilder> getEventLogoFieldBuilder() {
            if (this.eventLogoBuilder_ == null) {
                this.eventLogoBuilder_ = new SingleFieldBuilder<>(getEventLogo(), getParentForChildren(), isClean());
                this.eventLogo_ = null;
            }
            return this.eventLogoBuilder_;
        }

        @Override // proto.EventOrBuilder
        public boolean hasStartTime() {
            return (this.bitField0_ & 32) != 0;
        }

        @Override // proto.EventOrBuilder
        public Timestamp getStartTime() {
            SingleFieldBuilder<Timestamp, Timestamp.Builder, TimestampOrBuilder> singleFieldBuilder = this.startTimeBuilder_;
            if (singleFieldBuilder == null) {
                Timestamp timestamp = this.startTime_;
                return timestamp == null ? Timestamp.getDefaultInstance() : timestamp;
            }
            return (Timestamp) singleFieldBuilder.getMessage();
        }

        public Builder setStartTime(Timestamp timestamp) {
            SingleFieldBuilder<Timestamp, Timestamp.Builder, TimestampOrBuilder> singleFieldBuilder = this.startTimeBuilder_;
            if (singleFieldBuilder == null) {
                timestamp.getClass();
                this.startTime_ = timestamp;
            } else {
                singleFieldBuilder.setMessage(timestamp);
            }
            this.bitField0_ |= 32;
            onChanged();
            return this;
        }

        public Builder setStartTime(Timestamp.Builder builder) {
            SingleFieldBuilder<Timestamp, Timestamp.Builder, TimestampOrBuilder> singleFieldBuilder = this.startTimeBuilder_;
            if (singleFieldBuilder == null) {
                this.startTime_ = builder.build();
            } else {
                singleFieldBuilder.setMessage(builder.build());
            }
            this.bitField0_ |= 32;
            onChanged();
            return this;
        }

        public Builder mergeStartTime(Timestamp timestamp) {
            Timestamp timestamp2;
            SingleFieldBuilder<Timestamp, Timestamp.Builder, TimestampOrBuilder> singleFieldBuilder = this.startTimeBuilder_;
            if (singleFieldBuilder == null) {
                if ((this.bitField0_ & 32) != 0 && (timestamp2 = this.startTime_) != null && timestamp2 != Timestamp.getDefaultInstance()) {
                    getStartTimeBuilder().mergeFrom(timestamp);
                } else {
                    this.startTime_ = timestamp;
                }
            } else {
                singleFieldBuilder.mergeFrom(timestamp);
            }
            if (this.startTime_ != null) {
                this.bitField0_ |= 32;
                onChanged();
            }
            return this;
        }

        public Builder clearStartTime() {
            this.bitField0_ &= -33;
            this.startTime_ = null;
            SingleFieldBuilder<Timestamp, Timestamp.Builder, TimestampOrBuilder> singleFieldBuilder = this.startTimeBuilder_;
            if (singleFieldBuilder != null) {
                singleFieldBuilder.dispose();
                this.startTimeBuilder_ = null;
            }
            onChanged();
            return this;
        }

        public Timestamp.Builder getStartTimeBuilder() {
            this.bitField0_ |= 32;
            onChanged();
            return (Timestamp.Builder) getStartTimeFieldBuilder().getBuilder();
        }

        @Override // proto.EventOrBuilder
        public TimestampOrBuilder getStartTimeOrBuilder() {
            SingleFieldBuilder<Timestamp, Timestamp.Builder, TimestampOrBuilder> singleFieldBuilder = this.startTimeBuilder_;
            if (singleFieldBuilder != null) {
                return (TimestampOrBuilder) singleFieldBuilder.getMessageOrBuilder();
            }
            Timestamp timestamp = this.startTime_;
            return timestamp == null ? Timestamp.getDefaultInstance() : timestamp;
        }

        private SingleFieldBuilder<Timestamp, Timestamp.Builder, TimestampOrBuilder> getStartTimeFieldBuilder() {
            if (this.startTimeBuilder_ == null) {
                this.startTimeBuilder_ = new SingleFieldBuilder<>(getStartTime(), getParentForChildren(), isClean());
                this.startTime_ = null;
            }
            return this.startTimeBuilder_;
        }

        @Override // proto.EventOrBuilder
        public String getTimeZone() {
            Object obj = this.timeZone_;
            if (!(obj instanceof String)) {
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.timeZone_ = stringUtf8;
                return stringUtf8;
            }
            return (String) obj;
        }

        @Override // proto.EventOrBuilder
        public ByteString getTimeZoneBytes() {
            Object obj = this.timeZone_;
            if (obj instanceof String) {
                ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.timeZone_ = byteStringCopyFromUtf8;
                return byteStringCopyFromUtf8;
            }
            return (ByteString) obj;
        }

        public Builder setTimeZone(String str) {
            str.getClass();
            this.timeZone_ = str;
            this.bitField0_ |= 64;
            onChanged();
            return this;
        }

        public Builder clearTimeZone() {
            this.timeZone_ = Event.getDefaultInstance().getTimeZone();
            this.bitField0_ &= -65;
            onChanged();
            return this;
        }

        public Builder setTimeZoneBytes(ByteString byteString) {
            byteString.getClass();
            Event.checkByteStringIsUtf8(byteString);
            this.timeZone_ = byteString;
            this.bitField0_ |= 64;
            onChanged();
            return this;
        }

        @Override // proto.EventOrBuilder
        public boolean hasEndTime() {
            return (this.bitField0_ & 128) != 0;
        }

        @Override // proto.EventOrBuilder
        public Timestamp getEndTime() {
            SingleFieldBuilder<Timestamp, Timestamp.Builder, TimestampOrBuilder> singleFieldBuilder = this.endTimeBuilder_;
            if (singleFieldBuilder == null) {
                Timestamp timestamp = this.endTime_;
                return timestamp == null ? Timestamp.getDefaultInstance() : timestamp;
            }
            return (Timestamp) singleFieldBuilder.getMessage();
        }

        public Builder setEndTime(Timestamp timestamp) {
            SingleFieldBuilder<Timestamp, Timestamp.Builder, TimestampOrBuilder> singleFieldBuilder = this.endTimeBuilder_;
            if (singleFieldBuilder == null) {
                timestamp.getClass();
                this.endTime_ = timestamp;
            } else {
                singleFieldBuilder.setMessage(timestamp);
            }
            this.bitField0_ |= 128;
            onChanged();
            return this;
        }

        public Builder setEndTime(Timestamp.Builder builder) {
            SingleFieldBuilder<Timestamp, Timestamp.Builder, TimestampOrBuilder> singleFieldBuilder = this.endTimeBuilder_;
            if (singleFieldBuilder == null) {
                this.endTime_ = builder.build();
            } else {
                singleFieldBuilder.setMessage(builder.build());
            }
            this.bitField0_ |= 128;
            onChanged();
            return this;
        }

        public Builder mergeEndTime(Timestamp timestamp) {
            Timestamp timestamp2;
            SingleFieldBuilder<Timestamp, Timestamp.Builder, TimestampOrBuilder> singleFieldBuilder = this.endTimeBuilder_;
            if (singleFieldBuilder == null) {
                if ((this.bitField0_ & 128) != 0 && (timestamp2 = this.endTime_) != null && timestamp2 != Timestamp.getDefaultInstance()) {
                    getEndTimeBuilder().mergeFrom(timestamp);
                } else {
                    this.endTime_ = timestamp;
                }
            } else {
                singleFieldBuilder.mergeFrom(timestamp);
            }
            if (this.endTime_ != null) {
                this.bitField0_ |= 128;
                onChanged();
            }
            return this;
        }

        public Builder clearEndTime() {
            this.bitField0_ &= -129;
            this.endTime_ = null;
            SingleFieldBuilder<Timestamp, Timestamp.Builder, TimestampOrBuilder> singleFieldBuilder = this.endTimeBuilder_;
            if (singleFieldBuilder != null) {
                singleFieldBuilder.dispose();
                this.endTimeBuilder_ = null;
            }
            onChanged();
            return this;
        }

        public Timestamp.Builder getEndTimeBuilder() {
            this.bitField0_ |= 128;
            onChanged();
            return (Timestamp.Builder) getEndTimeFieldBuilder().getBuilder();
        }

        @Override // proto.EventOrBuilder
        public TimestampOrBuilder getEndTimeOrBuilder() {
            SingleFieldBuilder<Timestamp, Timestamp.Builder, TimestampOrBuilder> singleFieldBuilder = this.endTimeBuilder_;
            if (singleFieldBuilder != null) {
                return (TimestampOrBuilder) singleFieldBuilder.getMessageOrBuilder();
            }
            Timestamp timestamp = this.endTime_;
            return timestamp == null ? Timestamp.getDefaultInstance() : timestamp;
        }

        private SingleFieldBuilder<Timestamp, Timestamp.Builder, TimestampOrBuilder> getEndTimeFieldBuilder() {
            if (this.endTimeBuilder_ == null) {
                this.endTimeBuilder_ = new SingleFieldBuilder<>(getEndTime(), getParentForChildren(), isClean());
                this.endTime_ = null;
            }
            return this.endTimeBuilder_;
        }

        @Override // proto.EventOrBuilder
        public String getLiveStreamUrl() {
            Object obj = this.liveStreamUrl_;
            if (!(obj instanceof String)) {
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.liveStreamUrl_ = stringUtf8;
                return stringUtf8;
            }
            return (String) obj;
        }

        @Override // proto.EventOrBuilder
        public ByteString getLiveStreamUrlBytes() {
            Object obj = this.liveStreamUrl_;
            if (obj instanceof String) {
                ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.liveStreamUrl_ = byteStringCopyFromUtf8;
                return byteStringCopyFromUtf8;
            }
            return (ByteString) obj;
        }

        public Builder setLiveStreamUrl(String str) {
            str.getClass();
            this.liveStreamUrl_ = str;
            this.bitField0_ |= 256;
            onChanged();
            return this;
        }

        public Builder clearLiveStreamUrl() {
            this.liveStreamUrl_ = Event.getDefaultInstance().getLiveStreamUrl();
            this.bitField0_ &= -257;
            onChanged();
            return this;
        }

        public Builder setLiveStreamUrlBytes(ByteString byteString) {
            byteString.getClass();
            Event.checkByteStringIsUtf8(byteString);
            this.liveStreamUrl_ = byteString;
            this.bitField0_ |= 256;
            onChanged();
            return this;
        }

        private void ensureGamesIsMutable() {
            if ((this.bitField0_ & 512) == 0) {
                this.games_ = new ArrayList(this.games_);
                this.bitField0_ |= 512;
            }
        }

        @Override // proto.EventOrBuilder
        public List<Game> getGamesList() {
            RepeatedFieldBuilder<Game, Game.Builder, GameOrBuilder> repeatedFieldBuilder = this.gamesBuilder_;
            if (repeatedFieldBuilder == null) {
                return Collections.unmodifiableList(this.games_);
            }
            return repeatedFieldBuilder.getMessageList();
        }

        @Override // proto.EventOrBuilder
        public int getGamesCount() {
            RepeatedFieldBuilder<Game, Game.Builder, GameOrBuilder> repeatedFieldBuilder = this.gamesBuilder_;
            if (repeatedFieldBuilder == null) {
                return this.games_.size();
            }
            return repeatedFieldBuilder.getCount();
        }

        @Override // proto.EventOrBuilder
        public Game getGames(int i) {
            RepeatedFieldBuilder<Game, Game.Builder, GameOrBuilder> repeatedFieldBuilder = this.gamesBuilder_;
            if (repeatedFieldBuilder == null) {
                return this.games_.get(i);
            }
            return (Game) repeatedFieldBuilder.getMessage(i);
        }

        public Builder setGames(int i, Game game) {
            RepeatedFieldBuilder<Game, Game.Builder, GameOrBuilder> repeatedFieldBuilder = this.gamesBuilder_;
            if (repeatedFieldBuilder == null) {
                game.getClass();
                ensureGamesIsMutable();
                this.games_.set(i, game);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.setMessage(i, game);
            return this;
        }

        public Builder setGames(int i, Game.Builder builder) {
            RepeatedFieldBuilder<Game, Game.Builder, GameOrBuilder> repeatedFieldBuilder = this.gamesBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureGamesIsMutable();
                this.games_.set(i, builder.build());
                onChanged();
                return this;
            }
            repeatedFieldBuilder.setMessage(i, builder.build());
            return this;
        }

        public Builder addGames(Game game) {
            RepeatedFieldBuilder<Game, Game.Builder, GameOrBuilder> repeatedFieldBuilder = this.gamesBuilder_;
            if (repeatedFieldBuilder == null) {
                game.getClass();
                ensureGamesIsMutable();
                this.games_.add(game);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(game);
            return this;
        }

        public Builder addGames(int i, Game game) {
            RepeatedFieldBuilder<Game, Game.Builder, GameOrBuilder> repeatedFieldBuilder = this.gamesBuilder_;
            if (repeatedFieldBuilder == null) {
                game.getClass();
                ensureGamesIsMutable();
                this.games_.add(i, game);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(i, game);
            return this;
        }

        public Builder addGames(Game.Builder builder) {
            RepeatedFieldBuilder<Game, Game.Builder, GameOrBuilder> repeatedFieldBuilder = this.gamesBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureGamesIsMutable();
                this.games_.add(builder.build());
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(builder.build());
            return this;
        }

        public Builder addGames(int i, Game.Builder builder) {
            RepeatedFieldBuilder<Game, Game.Builder, GameOrBuilder> repeatedFieldBuilder = this.gamesBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureGamesIsMutable();
                this.games_.add(i, builder.build());
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(i, builder.build());
            return this;
        }

        public Builder addAllGames(Iterable<? extends Game> iterable) {
            RepeatedFieldBuilder<Game, Game.Builder, GameOrBuilder> repeatedFieldBuilder = this.gamesBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureGamesIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) iterable, (List) this.games_);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addAllMessages(iterable);
            return this;
        }

        public Builder clearGames() {
            RepeatedFieldBuilder<Game, Game.Builder, GameOrBuilder> repeatedFieldBuilder = this.gamesBuilder_;
            if (repeatedFieldBuilder == null) {
                this.games_ = Collections.emptyList();
                this.bitField0_ &= -513;
                onChanged();
                return this;
            }
            repeatedFieldBuilder.clear();
            return this;
        }

        public Builder removeGames(int i) {
            RepeatedFieldBuilder<Game, Game.Builder, GameOrBuilder> repeatedFieldBuilder = this.gamesBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureGamesIsMutable();
                this.games_.remove(i);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.remove(i);
            return this;
        }

        public Game.Builder getGamesBuilder(int i) {
            return (Game.Builder) getGamesFieldBuilder().getBuilder(i);
        }

        @Override // proto.EventOrBuilder
        public GameOrBuilder getGamesOrBuilder(int i) {
            RepeatedFieldBuilder<Game, Game.Builder, GameOrBuilder> repeatedFieldBuilder = this.gamesBuilder_;
            if (repeatedFieldBuilder == null) {
                return this.games_.get(i);
            }
            return (GameOrBuilder) repeatedFieldBuilder.getMessageOrBuilder(i);
        }

        @Override // proto.EventOrBuilder
        public List<? extends GameOrBuilder> getGamesOrBuilderList() {
            RepeatedFieldBuilder<Game, Game.Builder, GameOrBuilder> repeatedFieldBuilder = this.gamesBuilder_;
            if (repeatedFieldBuilder != null) {
                return repeatedFieldBuilder.getMessageOrBuilderList();
            }
            return Collections.unmodifiableList(this.games_);
        }

        public Game.Builder addGamesBuilder() {
            return (Game.Builder) getGamesFieldBuilder().addBuilder(Game.getDefaultInstance());
        }

        public Game.Builder addGamesBuilder(int i) {
            return (Game.Builder) getGamesFieldBuilder().addBuilder(i, Game.getDefaultInstance());
        }

        public List<Game.Builder> getGamesBuilderList() {
            return getGamesFieldBuilder().getBuilderList();
        }

        private RepeatedFieldBuilder<Game, Game.Builder, GameOrBuilder> getGamesFieldBuilder() {
            if (this.gamesBuilder_ == null) {
                this.gamesBuilder_ = new RepeatedFieldBuilder<>(this.games_, (this.bitField0_ & 512) != 0, getParentForChildren(), isClean());
                this.games_ = null;
            }
            return this.gamesBuilder_;
        }

        private void ensureVideosIsMutable() {
            if ((this.bitField0_ & 1024) == 0) {
                this.videos_ = new ArrayList(this.videos_);
                this.bitField0_ |= 1024;
            }
        }

        @Override // proto.EventOrBuilder
        public List<GameVideo> getVideosList() {
            RepeatedFieldBuilder<GameVideo, GameVideo.Builder, GameVideoOrBuilder> repeatedFieldBuilder = this.videosBuilder_;
            if (repeatedFieldBuilder == null) {
                return Collections.unmodifiableList(this.videos_);
            }
            return repeatedFieldBuilder.getMessageList();
        }

        @Override // proto.EventOrBuilder
        public int getVideosCount() {
            RepeatedFieldBuilder<GameVideo, GameVideo.Builder, GameVideoOrBuilder> repeatedFieldBuilder = this.videosBuilder_;
            if (repeatedFieldBuilder == null) {
                return this.videos_.size();
            }
            return repeatedFieldBuilder.getCount();
        }

        @Override // proto.EventOrBuilder
        public GameVideo getVideos(int i) {
            RepeatedFieldBuilder<GameVideo, GameVideo.Builder, GameVideoOrBuilder> repeatedFieldBuilder = this.videosBuilder_;
            if (repeatedFieldBuilder == null) {
                return this.videos_.get(i);
            }
            return (GameVideo) repeatedFieldBuilder.getMessage(i);
        }

        public Builder setVideos(int i, GameVideo gameVideo) {
            RepeatedFieldBuilder<GameVideo, GameVideo.Builder, GameVideoOrBuilder> repeatedFieldBuilder = this.videosBuilder_;
            if (repeatedFieldBuilder == null) {
                gameVideo.getClass();
                ensureVideosIsMutable();
                this.videos_.set(i, gameVideo);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.setMessage(i, gameVideo);
            return this;
        }

        public Builder setVideos(int i, GameVideo.Builder builder) {
            RepeatedFieldBuilder<GameVideo, GameVideo.Builder, GameVideoOrBuilder> repeatedFieldBuilder = this.videosBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureVideosIsMutable();
                this.videos_.set(i, builder.build());
                onChanged();
                return this;
            }
            repeatedFieldBuilder.setMessage(i, builder.build());
            return this;
        }

        public Builder addVideos(GameVideo gameVideo) {
            RepeatedFieldBuilder<GameVideo, GameVideo.Builder, GameVideoOrBuilder> repeatedFieldBuilder = this.videosBuilder_;
            if (repeatedFieldBuilder == null) {
                gameVideo.getClass();
                ensureVideosIsMutable();
                this.videos_.add(gameVideo);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(gameVideo);
            return this;
        }

        public Builder addVideos(int i, GameVideo gameVideo) {
            RepeatedFieldBuilder<GameVideo, GameVideo.Builder, GameVideoOrBuilder> repeatedFieldBuilder = this.videosBuilder_;
            if (repeatedFieldBuilder == null) {
                gameVideo.getClass();
                ensureVideosIsMutable();
                this.videos_.add(i, gameVideo);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(i, gameVideo);
            return this;
        }

        public Builder addVideos(GameVideo.Builder builder) {
            RepeatedFieldBuilder<GameVideo, GameVideo.Builder, GameVideoOrBuilder> repeatedFieldBuilder = this.videosBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureVideosIsMutable();
                this.videos_.add(builder.build());
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(builder.build());
            return this;
        }

        public Builder addVideos(int i, GameVideo.Builder builder) {
            RepeatedFieldBuilder<GameVideo, GameVideo.Builder, GameVideoOrBuilder> repeatedFieldBuilder = this.videosBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureVideosIsMutable();
                this.videos_.add(i, builder.build());
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(i, builder.build());
            return this;
        }

        public Builder addAllVideos(Iterable<? extends GameVideo> iterable) {
            RepeatedFieldBuilder<GameVideo, GameVideo.Builder, GameVideoOrBuilder> repeatedFieldBuilder = this.videosBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureVideosIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) iterable, (List) this.videos_);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addAllMessages(iterable);
            return this;
        }

        public Builder clearVideos() {
            RepeatedFieldBuilder<GameVideo, GameVideo.Builder, GameVideoOrBuilder> repeatedFieldBuilder = this.videosBuilder_;
            if (repeatedFieldBuilder == null) {
                this.videos_ = Collections.emptyList();
                this.bitField0_ &= -1025;
                onChanged();
                return this;
            }
            repeatedFieldBuilder.clear();
            return this;
        }

        public Builder removeVideos(int i) {
            RepeatedFieldBuilder<GameVideo, GameVideo.Builder, GameVideoOrBuilder> repeatedFieldBuilder = this.videosBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureVideosIsMutable();
                this.videos_.remove(i);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.remove(i);
            return this;
        }

        public GameVideo.Builder getVideosBuilder(int i) {
            return (GameVideo.Builder) getVideosFieldBuilder().getBuilder(i);
        }

        @Override // proto.EventOrBuilder
        public GameVideoOrBuilder getVideosOrBuilder(int i) {
            RepeatedFieldBuilder<GameVideo, GameVideo.Builder, GameVideoOrBuilder> repeatedFieldBuilder = this.videosBuilder_;
            if (repeatedFieldBuilder == null) {
                return this.videos_.get(i);
            }
            return (GameVideoOrBuilder) repeatedFieldBuilder.getMessageOrBuilder(i);
        }

        @Override // proto.EventOrBuilder
        public List<? extends GameVideoOrBuilder> getVideosOrBuilderList() {
            RepeatedFieldBuilder<GameVideo, GameVideo.Builder, GameVideoOrBuilder> repeatedFieldBuilder = this.videosBuilder_;
            if (repeatedFieldBuilder != null) {
                return repeatedFieldBuilder.getMessageOrBuilderList();
            }
            return Collections.unmodifiableList(this.videos_);
        }

        public GameVideo.Builder addVideosBuilder() {
            return (GameVideo.Builder) getVideosFieldBuilder().addBuilder(GameVideo.getDefaultInstance());
        }

        public GameVideo.Builder addVideosBuilder(int i) {
            return (GameVideo.Builder) getVideosFieldBuilder().addBuilder(i, GameVideo.getDefaultInstance());
        }

        public List<GameVideo.Builder> getVideosBuilderList() {
            return getVideosFieldBuilder().getBuilderList();
        }

        private RepeatedFieldBuilder<GameVideo, GameVideo.Builder, GameVideoOrBuilder> getVideosFieldBuilder() {
            if (this.videosBuilder_ == null) {
                this.videosBuilder_ = new RepeatedFieldBuilder<>(this.videos_, (this.bitField0_ & 1024) != 0, getParentForChildren(), isClean());
                this.videos_ = null;
            }
            return this.videosBuilder_;
        }

        private void ensureEventNetworksIsMutable() {
            if ((this.bitField0_ & 2048) == 0) {
                this.eventNetworks_ = new ArrayList(this.eventNetworks_);
                this.bitField0_ |= 2048;
            }
        }

        @Override // proto.EventOrBuilder
        public List<EventNetwork> getEventNetworksList() {
            RepeatedFieldBuilder<EventNetwork, EventNetwork.Builder, EventNetworkOrBuilder> repeatedFieldBuilder = this.eventNetworksBuilder_;
            if (repeatedFieldBuilder == null) {
                return Collections.unmodifiableList(this.eventNetworks_);
            }
            return repeatedFieldBuilder.getMessageList();
        }

        @Override // proto.EventOrBuilder
        public int getEventNetworksCount() {
            RepeatedFieldBuilder<EventNetwork, EventNetwork.Builder, EventNetworkOrBuilder> repeatedFieldBuilder = this.eventNetworksBuilder_;
            if (repeatedFieldBuilder == null) {
                return this.eventNetworks_.size();
            }
            return repeatedFieldBuilder.getCount();
        }

        @Override // proto.EventOrBuilder
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
                this.bitField0_ &= -2049;
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

        @Override // proto.EventOrBuilder
        public EventNetworkOrBuilder getEventNetworksOrBuilder(int i) {
            RepeatedFieldBuilder<EventNetwork, EventNetwork.Builder, EventNetworkOrBuilder> repeatedFieldBuilder = this.eventNetworksBuilder_;
            if (repeatedFieldBuilder == null) {
                return this.eventNetworks_.get(i);
            }
            return (EventNetworkOrBuilder) repeatedFieldBuilder.getMessageOrBuilder(i);
        }

        @Override // proto.EventOrBuilder
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
                this.eventNetworksBuilder_ = new RepeatedFieldBuilder<>(this.eventNetworks_, (this.bitField0_ & 2048) != 0, getParentForChildren(), isClean());
                this.eventNetworks_ = null;
            }
            return this.eventNetworksBuilder_;
        }

        @Override // proto.EventOrBuilder
        public boolean hasCreatedAt() {
            return (this.bitField0_ & 4096) != 0;
        }

        @Override // proto.EventOrBuilder
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
            this.bitField0_ |= 4096;
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
            this.bitField0_ |= 4096;
            onChanged();
            return this;
        }

        public Builder mergeCreatedAt(Timestamp timestamp) {
            Timestamp timestamp2;
            SingleFieldBuilder<Timestamp, Timestamp.Builder, TimestampOrBuilder> singleFieldBuilder = this.createdAtBuilder_;
            if (singleFieldBuilder == null) {
                if ((this.bitField0_ & 4096) != 0 && (timestamp2 = this.createdAt_) != null && timestamp2 != Timestamp.getDefaultInstance()) {
                    getCreatedAtBuilder().mergeFrom(timestamp);
                } else {
                    this.createdAt_ = timestamp;
                }
            } else {
                singleFieldBuilder.mergeFrom(timestamp);
            }
            if (this.createdAt_ != null) {
                this.bitField0_ |= 4096;
                onChanged();
            }
            return this;
        }

        public Builder clearCreatedAt() {
            this.bitField0_ &= -4097;
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
            this.bitField0_ |= 4096;
            onChanged();
            return (Timestamp.Builder) getCreatedAtFieldBuilder().getBuilder();
        }

        @Override // proto.EventOrBuilder
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

        @Override // proto.EventOrBuilder
        public boolean hasUpdatedAt() {
            return (this.bitField0_ & 8192) != 0;
        }

        @Override // proto.EventOrBuilder
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
            this.bitField0_ |= 8192;
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
            this.bitField0_ |= 8192;
            onChanged();
            return this;
        }

        public Builder mergeUpdatedAt(Timestamp timestamp) {
            Timestamp timestamp2;
            SingleFieldBuilder<Timestamp, Timestamp.Builder, TimestampOrBuilder> singleFieldBuilder = this.updatedAtBuilder_;
            if (singleFieldBuilder == null) {
                if ((this.bitField0_ & 8192) != 0 && (timestamp2 = this.updatedAt_) != null && timestamp2 != Timestamp.getDefaultInstance()) {
                    getUpdatedAtBuilder().mergeFrom(timestamp);
                } else {
                    this.updatedAt_ = timestamp;
                }
            } else {
                singleFieldBuilder.mergeFrom(timestamp);
            }
            if (this.updatedAt_ != null) {
                this.bitField0_ |= 8192;
                onChanged();
            }
            return this;
        }

        public Builder clearUpdatedAt() {
            this.bitField0_ &= -8193;
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
            this.bitField0_ |= 8192;
            onChanged();
            return (Timestamp.Builder) getUpdatedAtFieldBuilder().getBuilder();
        }

        @Override // proto.EventOrBuilder
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

        @Override // proto.EventOrBuilder
        public String getChecksum() {
            Object obj = this.checksum_;
            if (!(obj instanceof String)) {
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.checksum_ = stringUtf8;
                return stringUtf8;
            }
            return (String) obj;
        }

        @Override // proto.EventOrBuilder
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
            this.bitField0_ |= 16384;
            onChanged();
            return this;
        }

        public Builder clearChecksum() {
            this.checksum_ = Event.getDefaultInstance().getChecksum();
            this.bitField0_ &= -16385;
            onChanged();
            return this;
        }

        public Builder setChecksumBytes(ByteString byteString) {
            byteString.getClass();
            Event.checkByteStringIsUtf8(byteString);
            this.checksum_ = byteString;
            this.bitField0_ |= 16384;
            onChanged();
            return this;
        }
    }

    public static Event getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* JADX INFO: renamed from: proto.Event$1, reason: invalid class name */
    class AnonymousClass1 extends AbstractParser<Event> {
        AnonymousClass1() {
        }

        @Override // com.google.protobuf.Parser
        public Event parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            Builder builderNewBuilder = Event.newBuilder();
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

    public static Parser<Event> parser() {
        return PARSER;
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Parser<Event> getParserForType() {
        return PARSER;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
    public Event getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }
}
