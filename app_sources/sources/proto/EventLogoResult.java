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
public final class EventLogoResult extends GeneratedMessage implements EventLogoResultOrBuilder {
    private static final EventLogoResult DEFAULT_INSTANCE;
    public static final int EVENTLOGOS_FIELD_NUMBER = 1;
    private static final Parser<EventLogoResult> PARSER;
    private static final long serialVersionUID = 0;
    private List<EventLogo> eventlogos_;

    /* synthetic */ EventLogoResult(GeneratedMessage.Builder builder, EventLogoResultIA eventLogoResultIA) {
        this(builder);
    }

    static {
        RuntimeVersion.validateProtobufGencodeVersion(RuntimeVersion.RuntimeDomain.PUBLIC, 4, 27, 2, "", EventLogoResult.class.getName());
        DEFAULT_INSTANCE = new EventLogoResult();
        PARSER = new AnonymousClass1();
    }

    private EventLogoResult(GeneratedMessage.Builder<?> builder) {
        super(builder);
    }

    private EventLogoResult() {
        this.eventlogos_ = Collections.emptyList();
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return Igdbproto.internal_static_proto_EventLogoResult_descriptor;
    }

    @Override // com.google.protobuf.GeneratedMessage
    protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
        return Igdbproto.internal_static_proto_EventLogoResult_fieldAccessorTable.ensureFieldAccessorsInitialized(EventLogoResult.class, Builder.class);
    }

    @Override // proto.EventLogoResultOrBuilder
    public List<EventLogo> getEventlogosList() {
        return this.eventlogos_;
    }

    @Override // proto.EventLogoResultOrBuilder
    public List<? extends EventLogoOrBuilder> getEventlogosOrBuilderList() {
        return this.eventlogos_;
    }

    @Override // proto.EventLogoResultOrBuilder
    public int getEventlogosCount() {
        return this.eventlogos_.size();
    }

    @Override // proto.EventLogoResultOrBuilder
    public EventLogo getEventlogos(int i) {
        return this.eventlogos_.get(i);
    }

    @Override // proto.EventLogoResultOrBuilder
    public EventLogoOrBuilder getEventlogosOrBuilder(int i) {
        return this.eventlogos_.get(i);
    }

    public static EventLogoResult parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer);
    }

    public static EventLogoResult parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    public static EventLogoResult parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString);
    }

    public static EventLogoResult parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static EventLogoResult parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr);
    }

    public static EventLogoResult parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr, extensionRegistryLite);
    }

    public static EventLogoResult parseFrom(InputStream inputStream) throws IOException {
        return (EventLogoResult) GeneratedMessage.parseWithIOException(PARSER, inputStream);
    }

    public static EventLogoResult parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (EventLogoResult) GeneratedMessage.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static EventLogoResult parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (EventLogoResult) GeneratedMessage.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static EventLogoResult parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (EventLogoResult) GeneratedMessage.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static EventLogoResult parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (EventLogoResult) GeneratedMessage.parseWithIOException(PARSER, codedInputStream);
    }

    public static EventLogoResult parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (EventLogoResult) GeneratedMessage.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder newBuilderForType() {
        return newBuilder();
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    /* WARN: Multi-variable type inference failed */
    public static Builder newBuilder(EventLogoResult eventLogoResult) {
        return (Builder) DEFAULT_INSTANCE.toBuilder().mergeFrom((Message) eventLogoResult);
    }

    /* WARN: Multi-variable type inference failed */
    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder toBuilder() {
        return this == DEFAULT_INSTANCE ? new Builder((EventLogoResultIA) null) : (Builder) new Builder((EventLogoResultIA) null).mergeFrom((Message) this);
    }

    /* INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.AbstractMessage
    public Builder newBuilderForType(AbstractMessage.BuilderParent builderParent) {
        return new Builder(builderParent, null);
    }

    public static final class Builder extends GeneratedMessage.Builder<Builder> implements EventLogoResultOrBuilder {
        private int bitField0_;
        private RepeatedFieldBuilder<EventLogo, EventLogo.Builder, EventLogoOrBuilder> eventlogosBuilder_;
        private List<EventLogo> eventlogos_;

        /* synthetic */ Builder(AbstractMessage.BuilderParent builderParent, EventLogoResultIA eventLogoResultIA) {
            this(builderParent);
        }

        /* synthetic */ Builder(EventLogoResultIA eventLogoResultIA) {
            this();
        }

        private void buildPartial0(EventLogoResult eventLogoResult) {
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return Igdbproto.internal_static_proto_EventLogoResult_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder
        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return Igdbproto.internal_static_proto_EventLogoResult_fieldAccessorTable.ensureFieldAccessorsInitialized(EventLogoResult.class, Builder.class);
        }

        private Builder() {
            this.eventlogos_ = Collections.emptyList();
        }

        private Builder(AbstractMessage.BuilderParent builderParent) {
            super(builderParent);
            this.eventlogos_ = Collections.emptyList();
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder clear() {
            super.clear();
            this.bitField0_ = 0;
            RepeatedFieldBuilder<EventLogo, EventLogo.Builder, EventLogoOrBuilder> repeatedFieldBuilder = this.eventlogosBuilder_;
            if (repeatedFieldBuilder == null) {
                this.eventlogos_ = Collections.emptyList();
            } else {
                this.eventlogos_ = null;
                repeatedFieldBuilder.clear();
            }
            this.bitField0_ &= -2;
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
        public Descriptors.Descriptor getDescriptorForType() {
            return Igdbproto.internal_static_proto_EventLogoResult_descriptor;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public EventLogoResult getDefaultInstanceForType() {
            return EventLogoResult.getDefaultInstance();
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public EventLogoResult build() {
            EventLogoResult eventLogoResultBuildPartial = buildPartial();
            if (eventLogoResultBuildPartial.isInitialized()) {
                return eventLogoResultBuildPartial;
            }
            throw newUninitializedMessageException((Message) eventLogoResultBuildPartial);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public EventLogoResult buildPartial() {
            EventLogoResult eventLogoResult = new EventLogoResult(this, null);
            buildPartialRepeatedFields(eventLogoResult);
            if (this.bitField0_ != 0) {
                buildPartial0(eventLogoResult);
            }
            onBuilt();
            return eventLogoResult;
        }

        private void buildPartialRepeatedFields(EventLogoResult eventLogoResult) {
            RepeatedFieldBuilder<EventLogo, EventLogo.Builder, EventLogoOrBuilder> repeatedFieldBuilder = this.eventlogosBuilder_;
            if (repeatedFieldBuilder == null) {
                if ((this.bitField0_ & 1) != 0) {
                    this.eventlogos_ = Collections.unmodifiableList(this.eventlogos_);
                    this.bitField0_ &= -2;
                }
                eventLogoResult.eventlogos_ = this.eventlogos_;
                return;
            }
            eventLogoResult.eventlogos_ = repeatedFieldBuilder.build();
        }

        private void ensureEventlogosIsMutable() {
            if ((this.bitField0_ & 1) == 0) {
                this.eventlogos_ = new ArrayList(this.eventlogos_);
                this.bitField0_ |= 1;
            }
        }

        @Override // proto.EventLogoResultOrBuilder
        public List<EventLogo> getEventlogosList() {
            RepeatedFieldBuilder<EventLogo, EventLogo.Builder, EventLogoOrBuilder> repeatedFieldBuilder = this.eventlogosBuilder_;
            if (repeatedFieldBuilder == null) {
                return Collections.unmodifiableList(this.eventlogos_);
            }
            return repeatedFieldBuilder.getMessageList();
        }

        @Override // proto.EventLogoResultOrBuilder
        public int getEventlogosCount() {
            RepeatedFieldBuilder<EventLogo, EventLogo.Builder, EventLogoOrBuilder> repeatedFieldBuilder = this.eventlogosBuilder_;
            if (repeatedFieldBuilder == null) {
                return this.eventlogos_.size();
            }
            return repeatedFieldBuilder.getCount();
        }

        @Override // proto.EventLogoResultOrBuilder
        public EventLogo getEventlogos(int i) {
            RepeatedFieldBuilder<EventLogo, EventLogo.Builder, EventLogoOrBuilder> repeatedFieldBuilder = this.eventlogosBuilder_;
            if (repeatedFieldBuilder == null) {
                return this.eventlogos_.get(i);
            }
            return (EventLogo) repeatedFieldBuilder.getMessage(i);
        }

        public Builder setEventlogos(int i, EventLogo eventLogo) {
            RepeatedFieldBuilder<EventLogo, EventLogo.Builder, EventLogoOrBuilder> repeatedFieldBuilder = this.eventlogosBuilder_;
            if (repeatedFieldBuilder == null) {
                eventLogo.getClass();
                ensureEventlogosIsMutable();
                this.eventlogos_.set(i, eventLogo);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.setMessage(i, eventLogo);
            return this;
        }

        public Builder setEventlogos(int i, EventLogo.Builder builder) {
            RepeatedFieldBuilder<EventLogo, EventLogo.Builder, EventLogoOrBuilder> repeatedFieldBuilder = this.eventlogosBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureEventlogosIsMutable();
                this.eventlogos_.set(i, builder.build());
                onChanged();
                return this;
            }
            repeatedFieldBuilder.setMessage(i, builder.build());
            return this;
        }

        public Builder addEventlogos(EventLogo eventLogo) {
            RepeatedFieldBuilder<EventLogo, EventLogo.Builder, EventLogoOrBuilder> repeatedFieldBuilder = this.eventlogosBuilder_;
            if (repeatedFieldBuilder == null) {
                eventLogo.getClass();
                ensureEventlogosIsMutable();
                this.eventlogos_.add(eventLogo);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(eventLogo);
            return this;
        }

        public Builder addEventlogos(int i, EventLogo eventLogo) {
            RepeatedFieldBuilder<EventLogo, EventLogo.Builder, EventLogoOrBuilder> repeatedFieldBuilder = this.eventlogosBuilder_;
            if (repeatedFieldBuilder == null) {
                eventLogo.getClass();
                ensureEventlogosIsMutable();
                this.eventlogos_.add(i, eventLogo);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(i, eventLogo);
            return this;
        }

        public Builder addEventlogos(EventLogo.Builder builder) {
            RepeatedFieldBuilder<EventLogo, EventLogo.Builder, EventLogoOrBuilder> repeatedFieldBuilder = this.eventlogosBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureEventlogosIsMutable();
                this.eventlogos_.add(builder.build());
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(builder.build());
            return this;
        }

        public Builder addEventlogos(int i, EventLogo.Builder builder) {
            RepeatedFieldBuilder<EventLogo, EventLogo.Builder, EventLogoOrBuilder> repeatedFieldBuilder = this.eventlogosBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureEventlogosIsMutable();
                this.eventlogos_.add(i, builder.build());
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(i, builder.build());
            return this;
        }

        public Builder addAllEventlogos(Iterable<? extends EventLogo> iterable) {
            RepeatedFieldBuilder<EventLogo, EventLogo.Builder, EventLogoOrBuilder> repeatedFieldBuilder = this.eventlogosBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureEventlogosIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) iterable, (List) this.eventlogos_);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addAllMessages(iterable);
            return this;
        }

        public Builder clearEventlogos() {
            RepeatedFieldBuilder<EventLogo, EventLogo.Builder, EventLogoOrBuilder> repeatedFieldBuilder = this.eventlogosBuilder_;
            if (repeatedFieldBuilder == null) {
                this.eventlogos_ = Collections.emptyList();
                this.bitField0_ &= -2;
                onChanged();
                return this;
            }
            repeatedFieldBuilder.clear();
            return this;
        }

        public Builder removeEventlogos(int i) {
            RepeatedFieldBuilder<EventLogo, EventLogo.Builder, EventLogoOrBuilder> repeatedFieldBuilder = this.eventlogosBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureEventlogosIsMutable();
                this.eventlogos_.remove(i);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.remove(i);
            return this;
        }

        public EventLogo.Builder getEventlogosBuilder(int i) {
            return (EventLogo.Builder) getEventlogosFieldBuilder().getBuilder(i);
        }

        @Override // proto.EventLogoResultOrBuilder
        public EventLogoOrBuilder getEventlogosOrBuilder(int i) {
            RepeatedFieldBuilder<EventLogo, EventLogo.Builder, EventLogoOrBuilder> repeatedFieldBuilder = this.eventlogosBuilder_;
            if (repeatedFieldBuilder == null) {
                return this.eventlogos_.get(i);
            }
            return (EventLogoOrBuilder) repeatedFieldBuilder.getMessageOrBuilder(i);
        }

        @Override // proto.EventLogoResultOrBuilder
        public List<? extends EventLogoOrBuilder> getEventlogosOrBuilderList() {
            RepeatedFieldBuilder<EventLogo, EventLogo.Builder, EventLogoOrBuilder> repeatedFieldBuilder = this.eventlogosBuilder_;
            if (repeatedFieldBuilder != null) {
                return repeatedFieldBuilder.getMessageOrBuilderList();
            }
            return Collections.unmodifiableList(this.eventlogos_);
        }

        public EventLogo.Builder addEventlogosBuilder() {
            return (EventLogo.Builder) getEventlogosFieldBuilder().addBuilder(EventLogo.getDefaultInstance());
        }

        public EventLogo.Builder addEventlogosBuilder(int i) {
            return (EventLogo.Builder) getEventlogosFieldBuilder().addBuilder(i, EventLogo.getDefaultInstance());
        }

        public List<EventLogo.Builder> getEventlogosBuilderList() {
            return getEventlogosFieldBuilder().getBuilderList();
        }

        private RepeatedFieldBuilder<EventLogo, EventLogo.Builder, EventLogoOrBuilder> getEventlogosFieldBuilder() {
            if (this.eventlogosBuilder_ == null) {
                this.eventlogosBuilder_ = new RepeatedFieldBuilder<>(this.eventlogos_, (this.bitField0_ & 1) != 0, getParentForChildren(), isClean());
                this.eventlogos_ = null;
            }
            return this.eventlogosBuilder_;
        }
    }

    public static EventLogoResult getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* INFO: renamed from: proto.EventLogoResult$1, reason: invalid class name */
    class AnonymousClass1 extends AbstractParser<EventLogoResult> {
        AnonymousClass1() {
        }

        @Override // com.google.protobuf.Parser
        public EventLogoResult parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            Builder builderNewBuilder = EventLogoResult.newBuilder();
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

    public static Parser<EventLogoResult> parser() {
        return PARSER;
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Parser<EventLogoResult> getParserForType() {
        return PARSER;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
    public EventLogoResult getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }
}
