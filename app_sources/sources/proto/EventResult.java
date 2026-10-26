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
public final class EventResult extends GeneratedMessage implements EventResultOrBuilder {
    private static final EventResult DEFAULT_INSTANCE;
    public static final int EVENTS_FIELD_NUMBER = 1;
    private static final Parser<EventResult> PARSER;
    private static final long serialVersionUID = 0;
    private List<Event> events_;

    /* synthetic */ EventResult(GeneratedMessage.Builder builder, EventResultIA eventResultIA) {
        this(builder);
    }

    static {
        RuntimeVersion.validateProtobufGencodeVersion(RuntimeVersion.RuntimeDomain.PUBLIC, 4, 27, 2, "", EventResult.class.getName());
        DEFAULT_INSTANCE = new EventResult();
        PARSER = new AnonymousClass1();
    }

    private EventResult(GeneratedMessage.Builder<?> builder) {
        super(builder);
    }

    private EventResult() {
        this.events_ = Collections.emptyList();
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return Igdbproto.internal_static_proto_EventResult_descriptor;
    }

    @Override // com.google.protobuf.GeneratedMessage
    protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
        return Igdbproto.internal_static_proto_EventResult_fieldAccessorTable.ensureFieldAccessorsInitialized(EventResult.class, Builder.class);
    }

    @Override // proto.EventResultOrBuilder
    public List<Event> getEventsList() {
        return this.events_;
    }

    @Override // proto.EventResultOrBuilder
    public List<? extends EventOrBuilder> getEventsOrBuilderList() {
        return this.events_;
    }

    @Override // proto.EventResultOrBuilder
    public int getEventsCount() {
        return this.events_.size();
    }

    @Override // proto.EventResultOrBuilder
    public Event getEvents(int i) {
        return this.events_.get(i);
    }

    @Override // proto.EventResultOrBuilder
    public EventOrBuilder getEventsOrBuilder(int i) {
        return this.events_.get(i);
    }

    public static EventResult parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer);
    }

    public static EventResult parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    public static EventResult parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString);
    }

    public static EventResult parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static EventResult parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr);
    }

    public static EventResult parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr, extensionRegistryLite);
    }

    public static EventResult parseFrom(InputStream inputStream) throws IOException {
        return (EventResult) GeneratedMessage.parseWithIOException(PARSER, inputStream);
    }

    public static EventResult parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (EventResult) GeneratedMessage.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static EventResult parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (EventResult) GeneratedMessage.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static EventResult parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (EventResult) GeneratedMessage.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static EventResult parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (EventResult) GeneratedMessage.parseWithIOException(PARSER, codedInputStream);
    }

    public static EventResult parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (EventResult) GeneratedMessage.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder newBuilderForType() {
        return newBuilder();
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    /* WARN: Multi-variable type inference failed */
    public static Builder newBuilder(EventResult eventResult) {
        return (Builder) DEFAULT_INSTANCE.toBuilder().mergeFrom((Message) eventResult);
    }

    /* WARN: Multi-variable type inference failed */
    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder toBuilder() {
        return this == DEFAULT_INSTANCE ? new Builder((EventResultIA) null) : (Builder) new Builder((EventResultIA) null).mergeFrom((Message) this);
    }

    /* INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.AbstractMessage
    public Builder newBuilderForType(AbstractMessage.BuilderParent builderParent) {
        return new Builder(builderParent, null);
    }

    public static final class Builder extends GeneratedMessage.Builder<Builder> implements EventResultOrBuilder {
        private int bitField0_;
        private RepeatedFieldBuilder<Event, Event.Builder, EventOrBuilder> eventsBuilder_;
        private List<Event> events_;

        /* synthetic */ Builder(AbstractMessage.BuilderParent builderParent, EventResultIA eventResultIA) {
            this(builderParent);
        }

        /* synthetic */ Builder(EventResultIA eventResultIA) {
            this();
        }

        private void buildPartial0(EventResult eventResult) {
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return Igdbproto.internal_static_proto_EventResult_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder
        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return Igdbproto.internal_static_proto_EventResult_fieldAccessorTable.ensureFieldAccessorsInitialized(EventResult.class, Builder.class);
        }

        private Builder() {
            this.events_ = Collections.emptyList();
        }

        private Builder(AbstractMessage.BuilderParent builderParent) {
            super(builderParent);
            this.events_ = Collections.emptyList();
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder clear() {
            super.clear();
            this.bitField0_ = 0;
            RepeatedFieldBuilder<Event, Event.Builder, EventOrBuilder> repeatedFieldBuilder = this.eventsBuilder_;
            if (repeatedFieldBuilder == null) {
                this.events_ = Collections.emptyList();
            } else {
                this.events_ = null;
                repeatedFieldBuilder.clear();
            }
            this.bitField0_ &= -2;
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
        public Descriptors.Descriptor getDescriptorForType() {
            return Igdbproto.internal_static_proto_EventResult_descriptor;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public EventResult getDefaultInstanceForType() {
            return EventResult.getDefaultInstance();
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public EventResult build() {
            EventResult eventResultBuildPartial = buildPartial();
            if (eventResultBuildPartial.isInitialized()) {
                return eventResultBuildPartial;
            }
            throw newUninitializedMessageException((Message) eventResultBuildPartial);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public EventResult buildPartial() {
            EventResult eventResult = new EventResult(this, null);
            buildPartialRepeatedFields(eventResult);
            if (this.bitField0_ != 0) {
                buildPartial0(eventResult);
            }
            onBuilt();
            return eventResult;
        }

        private void buildPartialRepeatedFields(EventResult eventResult) {
            RepeatedFieldBuilder<Event, Event.Builder, EventOrBuilder> repeatedFieldBuilder = this.eventsBuilder_;
            if (repeatedFieldBuilder == null) {
                if ((this.bitField0_ & 1) != 0) {
                    this.events_ = Collections.unmodifiableList(this.events_);
                    this.bitField0_ &= -2;
                }
                eventResult.events_ = this.events_;
                return;
            }
            eventResult.events_ = repeatedFieldBuilder.build();
        }

        private void ensureEventsIsMutable() {
            if ((this.bitField0_ & 1) == 0) {
                this.events_ = new ArrayList(this.events_);
                this.bitField0_ |= 1;
            }
        }

        @Override // proto.EventResultOrBuilder
        public List<Event> getEventsList() {
            RepeatedFieldBuilder<Event, Event.Builder, EventOrBuilder> repeatedFieldBuilder = this.eventsBuilder_;
            if (repeatedFieldBuilder == null) {
                return Collections.unmodifiableList(this.events_);
            }
            return repeatedFieldBuilder.getMessageList();
        }

        @Override // proto.EventResultOrBuilder
        public int getEventsCount() {
            RepeatedFieldBuilder<Event, Event.Builder, EventOrBuilder> repeatedFieldBuilder = this.eventsBuilder_;
            if (repeatedFieldBuilder == null) {
                return this.events_.size();
            }
            return repeatedFieldBuilder.getCount();
        }

        @Override // proto.EventResultOrBuilder
        public Event getEvents(int i) {
            RepeatedFieldBuilder<Event, Event.Builder, EventOrBuilder> repeatedFieldBuilder = this.eventsBuilder_;
            if (repeatedFieldBuilder == null) {
                return this.events_.get(i);
            }
            return (Event) repeatedFieldBuilder.getMessage(i);
        }

        public Builder setEvents(int i, Event event) {
            RepeatedFieldBuilder<Event, Event.Builder, EventOrBuilder> repeatedFieldBuilder = this.eventsBuilder_;
            if (repeatedFieldBuilder == null) {
                event.getClass();
                ensureEventsIsMutable();
                this.events_.set(i, event);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.setMessage(i, event);
            return this;
        }

        public Builder setEvents(int i, Event.Builder builder) {
            RepeatedFieldBuilder<Event, Event.Builder, EventOrBuilder> repeatedFieldBuilder = this.eventsBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureEventsIsMutable();
                this.events_.set(i, builder.build());
                onChanged();
                return this;
            }
            repeatedFieldBuilder.setMessage(i, builder.build());
            return this;
        }

        public Builder addEvents(Event event) {
            RepeatedFieldBuilder<Event, Event.Builder, EventOrBuilder> repeatedFieldBuilder = this.eventsBuilder_;
            if (repeatedFieldBuilder == null) {
                event.getClass();
                ensureEventsIsMutable();
                this.events_.add(event);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(event);
            return this;
        }

        public Builder addEvents(int i, Event event) {
            RepeatedFieldBuilder<Event, Event.Builder, EventOrBuilder> repeatedFieldBuilder = this.eventsBuilder_;
            if (repeatedFieldBuilder == null) {
                event.getClass();
                ensureEventsIsMutable();
                this.events_.add(i, event);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(i, event);
            return this;
        }

        public Builder addEvents(Event.Builder builder) {
            RepeatedFieldBuilder<Event, Event.Builder, EventOrBuilder> repeatedFieldBuilder = this.eventsBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureEventsIsMutable();
                this.events_.add(builder.build());
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(builder.build());
            return this;
        }

        public Builder addEvents(int i, Event.Builder builder) {
            RepeatedFieldBuilder<Event, Event.Builder, EventOrBuilder> repeatedFieldBuilder = this.eventsBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureEventsIsMutable();
                this.events_.add(i, builder.build());
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(i, builder.build());
            return this;
        }

        public Builder addAllEvents(Iterable<? extends Event> iterable) {
            RepeatedFieldBuilder<Event, Event.Builder, EventOrBuilder> repeatedFieldBuilder = this.eventsBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureEventsIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) iterable, (List) this.events_);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addAllMessages(iterable);
            return this;
        }

        public Builder clearEvents() {
            RepeatedFieldBuilder<Event, Event.Builder, EventOrBuilder> repeatedFieldBuilder = this.eventsBuilder_;
            if (repeatedFieldBuilder == null) {
                this.events_ = Collections.emptyList();
                this.bitField0_ &= -2;
                onChanged();
                return this;
            }
            repeatedFieldBuilder.clear();
            return this;
        }

        public Builder removeEvents(int i) {
            RepeatedFieldBuilder<Event, Event.Builder, EventOrBuilder> repeatedFieldBuilder = this.eventsBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureEventsIsMutable();
                this.events_.remove(i);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.remove(i);
            return this;
        }

        public Event.Builder getEventsBuilder(int i) {
            return (Event.Builder) getEventsFieldBuilder().getBuilder(i);
        }

        @Override // proto.EventResultOrBuilder
        public EventOrBuilder getEventsOrBuilder(int i) {
            RepeatedFieldBuilder<Event, Event.Builder, EventOrBuilder> repeatedFieldBuilder = this.eventsBuilder_;
            if (repeatedFieldBuilder == null) {
                return this.events_.get(i);
            }
            return (EventOrBuilder) repeatedFieldBuilder.getMessageOrBuilder(i);
        }

        @Override // proto.EventResultOrBuilder
        public List<? extends EventOrBuilder> getEventsOrBuilderList() {
            RepeatedFieldBuilder<Event, Event.Builder, EventOrBuilder> repeatedFieldBuilder = this.eventsBuilder_;
            if (repeatedFieldBuilder != null) {
                return repeatedFieldBuilder.getMessageOrBuilderList();
            }
            return Collections.unmodifiableList(this.events_);
        }

        public Event.Builder addEventsBuilder() {
            return (Event.Builder) getEventsFieldBuilder().addBuilder(Event.getDefaultInstance());
        }

        public Event.Builder addEventsBuilder(int i) {
            return (Event.Builder) getEventsFieldBuilder().addBuilder(i, Event.getDefaultInstance());
        }

        public List<Event.Builder> getEventsBuilderList() {
            return getEventsFieldBuilder().getBuilderList();
        }

        private RepeatedFieldBuilder<Event, Event.Builder, EventOrBuilder> getEventsFieldBuilder() {
            if (this.eventsBuilder_ == null) {
                this.eventsBuilder_ = new RepeatedFieldBuilder<>(this.events_, (this.bitField0_ & 1) != 0, getParentForChildren(), isClean());
                this.events_ = null;
            }
            return this.eventsBuilder_;
        }
    }

    public static EventResult getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* INFO: renamed from: proto.EventResult$1, reason: invalid class name */
    class AnonymousClass1 extends AbstractParser<EventResult> {
        AnonymousClass1() {
        }

        @Override // com.google.protobuf.Parser
        public EventResult parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            Builder builderNewBuilder = EventResult.newBuilder();
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

    public static Parser<EventResult> parser() {
        return PARSER;
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Parser<EventResult> getParserForType() {
        return PARSER;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
    public EventResult getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }
}
