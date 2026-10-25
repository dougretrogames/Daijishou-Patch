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
public final class EventNetworkResult extends GeneratedMessage implements EventNetworkResultOrBuilder {
    private static final EventNetworkResult DEFAULT_INSTANCE;
    public static final int EVENTNETWORKS_FIELD_NUMBER = 1;
    private static final Parser<EventNetworkResult> PARSER;
    private static final long serialVersionUID = 0;
    private List<EventNetwork> eventnetworks_;

    /* synthetic */ EventNetworkResult(GeneratedMessage.Builder builder, EventNetworkResultIA eventNetworkResultIA) {
        this(builder);
    }

    static {
        RuntimeVersion.validateProtobufGencodeVersion(RuntimeVersion.RuntimeDomain.PUBLIC, 4, 27, 2, "", EventNetworkResult.class.getName());
        DEFAULT_INSTANCE = new EventNetworkResult();
        PARSER = new AnonymousClass1();
    }

    private EventNetworkResult(GeneratedMessage.Builder<?> builder) {
        super(builder);
    }

    private EventNetworkResult() {
        this.eventnetworks_ = Collections.emptyList();
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return Igdbproto.internal_static_proto_EventNetworkResult_descriptor;
    }

    @Override // com.google.protobuf.GeneratedMessage
    protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
        return Igdbproto.internal_static_proto_EventNetworkResult_fieldAccessorTable.ensureFieldAccessorsInitialized(EventNetworkResult.class, Builder.class);
    }

    @Override // proto.EventNetworkResultOrBuilder
    public List<EventNetwork> getEventnetworksList() {
        return this.eventnetworks_;
    }

    @Override // proto.EventNetworkResultOrBuilder
    public List<? extends EventNetworkOrBuilder> getEventnetworksOrBuilderList() {
        return this.eventnetworks_;
    }

    @Override // proto.EventNetworkResultOrBuilder
    public int getEventnetworksCount() {
        return this.eventnetworks_.size();
    }

    @Override // proto.EventNetworkResultOrBuilder
    public EventNetwork getEventnetworks(int i) {
        return this.eventnetworks_.get(i);
    }

    @Override // proto.EventNetworkResultOrBuilder
    public EventNetworkOrBuilder getEventnetworksOrBuilder(int i) {
        return this.eventnetworks_.get(i);
    }

    public static EventNetworkResult parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer);
    }

    public static EventNetworkResult parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    public static EventNetworkResult parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString);
    }

    public static EventNetworkResult parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static EventNetworkResult parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr);
    }

    public static EventNetworkResult parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr, extensionRegistryLite);
    }

    public static EventNetworkResult parseFrom(InputStream inputStream) throws IOException {
        return (EventNetworkResult) GeneratedMessage.parseWithIOException(PARSER, inputStream);
    }

    public static EventNetworkResult parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (EventNetworkResult) GeneratedMessage.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static EventNetworkResult parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (EventNetworkResult) GeneratedMessage.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static EventNetworkResult parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (EventNetworkResult) GeneratedMessage.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static EventNetworkResult parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (EventNetworkResult) GeneratedMessage.parseWithIOException(PARSER, codedInputStream);
    }

    public static EventNetworkResult parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (EventNetworkResult) GeneratedMessage.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder newBuilderForType() {
        return newBuilder();
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static Builder newBuilder(EventNetworkResult eventNetworkResult) {
        return (Builder) DEFAULT_INSTANCE.toBuilder().mergeFrom((Message) eventNetworkResult);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder toBuilder() {
        return this == DEFAULT_INSTANCE ? new Builder((EventNetworkResultIA) null) : (Builder) new Builder((EventNetworkResultIA) null).mergeFrom((Message) this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.AbstractMessage
    public Builder newBuilderForType(AbstractMessage.BuilderParent builderParent) {
        return new Builder(builderParent, null);
    }

    public static final class Builder extends GeneratedMessage.Builder<Builder> implements EventNetworkResultOrBuilder {
        private int bitField0_;
        private RepeatedFieldBuilder<EventNetwork, EventNetwork.Builder, EventNetworkOrBuilder> eventnetworksBuilder_;
        private List<EventNetwork> eventnetworks_;

        /* synthetic */ Builder(AbstractMessage.BuilderParent builderParent, EventNetworkResultIA eventNetworkResultIA) {
            this(builderParent);
        }

        /* synthetic */ Builder(EventNetworkResultIA eventNetworkResultIA) {
            this();
        }

        private void buildPartial0(EventNetworkResult eventNetworkResult) {
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return Igdbproto.internal_static_proto_EventNetworkResult_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder
        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return Igdbproto.internal_static_proto_EventNetworkResult_fieldAccessorTable.ensureFieldAccessorsInitialized(EventNetworkResult.class, Builder.class);
        }

        private Builder() {
            this.eventnetworks_ = Collections.emptyList();
        }

        private Builder(AbstractMessage.BuilderParent builderParent) {
            super(builderParent);
            this.eventnetworks_ = Collections.emptyList();
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder clear() {
            super.clear();
            this.bitField0_ = 0;
            RepeatedFieldBuilder<EventNetwork, EventNetwork.Builder, EventNetworkOrBuilder> repeatedFieldBuilder = this.eventnetworksBuilder_;
            if (repeatedFieldBuilder == null) {
                this.eventnetworks_ = Collections.emptyList();
            } else {
                this.eventnetworks_ = null;
                repeatedFieldBuilder.clear();
            }
            this.bitField0_ &= -2;
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
        public Descriptors.Descriptor getDescriptorForType() {
            return Igdbproto.internal_static_proto_EventNetworkResult_descriptor;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public EventNetworkResult getDefaultInstanceForType() {
            return EventNetworkResult.getDefaultInstance();
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public EventNetworkResult build() {
            EventNetworkResult eventNetworkResultBuildPartial = buildPartial();
            if (eventNetworkResultBuildPartial.isInitialized()) {
                return eventNetworkResultBuildPartial;
            }
            throw newUninitializedMessageException((Message) eventNetworkResultBuildPartial);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public EventNetworkResult buildPartial() {
            EventNetworkResult eventNetworkResult = new EventNetworkResult(this, null);
            buildPartialRepeatedFields(eventNetworkResult);
            if (this.bitField0_ != 0) {
                buildPartial0(eventNetworkResult);
            }
            onBuilt();
            return eventNetworkResult;
        }

        private void buildPartialRepeatedFields(EventNetworkResult eventNetworkResult) {
            RepeatedFieldBuilder<EventNetwork, EventNetwork.Builder, EventNetworkOrBuilder> repeatedFieldBuilder = this.eventnetworksBuilder_;
            if (repeatedFieldBuilder == null) {
                if ((this.bitField0_ & 1) != 0) {
                    this.eventnetworks_ = Collections.unmodifiableList(this.eventnetworks_);
                    this.bitField0_ &= -2;
                }
                eventNetworkResult.eventnetworks_ = this.eventnetworks_;
                return;
            }
            eventNetworkResult.eventnetworks_ = repeatedFieldBuilder.build();
        }

        private void ensureEventnetworksIsMutable() {
            if ((this.bitField0_ & 1) == 0) {
                this.eventnetworks_ = new ArrayList(this.eventnetworks_);
                this.bitField0_ |= 1;
            }
        }

        @Override // proto.EventNetworkResultOrBuilder
        public List<EventNetwork> getEventnetworksList() {
            RepeatedFieldBuilder<EventNetwork, EventNetwork.Builder, EventNetworkOrBuilder> repeatedFieldBuilder = this.eventnetworksBuilder_;
            if (repeatedFieldBuilder == null) {
                return Collections.unmodifiableList(this.eventnetworks_);
            }
            return repeatedFieldBuilder.getMessageList();
        }

        @Override // proto.EventNetworkResultOrBuilder
        public int getEventnetworksCount() {
            RepeatedFieldBuilder<EventNetwork, EventNetwork.Builder, EventNetworkOrBuilder> repeatedFieldBuilder = this.eventnetworksBuilder_;
            if (repeatedFieldBuilder == null) {
                return this.eventnetworks_.size();
            }
            return repeatedFieldBuilder.getCount();
        }

        @Override // proto.EventNetworkResultOrBuilder
        public EventNetwork getEventnetworks(int i) {
            RepeatedFieldBuilder<EventNetwork, EventNetwork.Builder, EventNetworkOrBuilder> repeatedFieldBuilder = this.eventnetworksBuilder_;
            if (repeatedFieldBuilder == null) {
                return this.eventnetworks_.get(i);
            }
            return (EventNetwork) repeatedFieldBuilder.getMessage(i);
        }

        public Builder setEventnetworks(int i, EventNetwork eventNetwork) {
            RepeatedFieldBuilder<EventNetwork, EventNetwork.Builder, EventNetworkOrBuilder> repeatedFieldBuilder = this.eventnetworksBuilder_;
            if (repeatedFieldBuilder == null) {
                eventNetwork.getClass();
                ensureEventnetworksIsMutable();
                this.eventnetworks_.set(i, eventNetwork);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.setMessage(i, eventNetwork);
            return this;
        }

        public Builder setEventnetworks(int i, EventNetwork.Builder builder) {
            RepeatedFieldBuilder<EventNetwork, EventNetwork.Builder, EventNetworkOrBuilder> repeatedFieldBuilder = this.eventnetworksBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureEventnetworksIsMutable();
                this.eventnetworks_.set(i, builder.build());
                onChanged();
                return this;
            }
            repeatedFieldBuilder.setMessage(i, builder.build());
            return this;
        }

        public Builder addEventnetworks(EventNetwork eventNetwork) {
            RepeatedFieldBuilder<EventNetwork, EventNetwork.Builder, EventNetworkOrBuilder> repeatedFieldBuilder = this.eventnetworksBuilder_;
            if (repeatedFieldBuilder == null) {
                eventNetwork.getClass();
                ensureEventnetworksIsMutable();
                this.eventnetworks_.add(eventNetwork);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(eventNetwork);
            return this;
        }

        public Builder addEventnetworks(int i, EventNetwork eventNetwork) {
            RepeatedFieldBuilder<EventNetwork, EventNetwork.Builder, EventNetworkOrBuilder> repeatedFieldBuilder = this.eventnetworksBuilder_;
            if (repeatedFieldBuilder == null) {
                eventNetwork.getClass();
                ensureEventnetworksIsMutable();
                this.eventnetworks_.add(i, eventNetwork);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(i, eventNetwork);
            return this;
        }

        public Builder addEventnetworks(EventNetwork.Builder builder) {
            RepeatedFieldBuilder<EventNetwork, EventNetwork.Builder, EventNetworkOrBuilder> repeatedFieldBuilder = this.eventnetworksBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureEventnetworksIsMutable();
                this.eventnetworks_.add(builder.build());
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(builder.build());
            return this;
        }

        public Builder addEventnetworks(int i, EventNetwork.Builder builder) {
            RepeatedFieldBuilder<EventNetwork, EventNetwork.Builder, EventNetworkOrBuilder> repeatedFieldBuilder = this.eventnetworksBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureEventnetworksIsMutable();
                this.eventnetworks_.add(i, builder.build());
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(i, builder.build());
            return this;
        }

        public Builder addAllEventnetworks(Iterable<? extends EventNetwork> iterable) {
            RepeatedFieldBuilder<EventNetwork, EventNetwork.Builder, EventNetworkOrBuilder> repeatedFieldBuilder = this.eventnetworksBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureEventnetworksIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) iterable, (List) this.eventnetworks_);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addAllMessages(iterable);
            return this;
        }

        public Builder clearEventnetworks() {
            RepeatedFieldBuilder<EventNetwork, EventNetwork.Builder, EventNetworkOrBuilder> repeatedFieldBuilder = this.eventnetworksBuilder_;
            if (repeatedFieldBuilder == null) {
                this.eventnetworks_ = Collections.emptyList();
                this.bitField0_ &= -2;
                onChanged();
                return this;
            }
            repeatedFieldBuilder.clear();
            return this;
        }

        public Builder removeEventnetworks(int i) {
            RepeatedFieldBuilder<EventNetwork, EventNetwork.Builder, EventNetworkOrBuilder> repeatedFieldBuilder = this.eventnetworksBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureEventnetworksIsMutable();
                this.eventnetworks_.remove(i);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.remove(i);
            return this;
        }

        public EventNetwork.Builder getEventnetworksBuilder(int i) {
            return (EventNetwork.Builder) getEventnetworksFieldBuilder().getBuilder(i);
        }

        @Override // proto.EventNetworkResultOrBuilder
        public EventNetworkOrBuilder getEventnetworksOrBuilder(int i) {
            RepeatedFieldBuilder<EventNetwork, EventNetwork.Builder, EventNetworkOrBuilder> repeatedFieldBuilder = this.eventnetworksBuilder_;
            if (repeatedFieldBuilder == null) {
                return this.eventnetworks_.get(i);
            }
            return (EventNetworkOrBuilder) repeatedFieldBuilder.getMessageOrBuilder(i);
        }

        @Override // proto.EventNetworkResultOrBuilder
        public List<? extends EventNetworkOrBuilder> getEventnetworksOrBuilderList() {
            RepeatedFieldBuilder<EventNetwork, EventNetwork.Builder, EventNetworkOrBuilder> repeatedFieldBuilder = this.eventnetworksBuilder_;
            if (repeatedFieldBuilder != null) {
                return repeatedFieldBuilder.getMessageOrBuilderList();
            }
            return Collections.unmodifiableList(this.eventnetworks_);
        }

        public EventNetwork.Builder addEventnetworksBuilder() {
            return (EventNetwork.Builder) getEventnetworksFieldBuilder().addBuilder(EventNetwork.getDefaultInstance());
        }

        public EventNetwork.Builder addEventnetworksBuilder(int i) {
            return (EventNetwork.Builder) getEventnetworksFieldBuilder().addBuilder(i, EventNetwork.getDefaultInstance());
        }

        public List<EventNetwork.Builder> getEventnetworksBuilderList() {
            return getEventnetworksFieldBuilder().getBuilderList();
        }

        private RepeatedFieldBuilder<EventNetwork, EventNetwork.Builder, EventNetworkOrBuilder> getEventnetworksFieldBuilder() {
            if (this.eventnetworksBuilder_ == null) {
                this.eventnetworksBuilder_ = new RepeatedFieldBuilder<>(this.eventnetworks_, (this.bitField0_ & 1) != 0, getParentForChildren(), isClean());
                this.eventnetworks_ = null;
            }
            return this.eventnetworksBuilder_;
        }
    }

    public static EventNetworkResult getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* JADX INFO: renamed from: proto.EventNetworkResult$1, reason: invalid class name */
    class AnonymousClass1 extends AbstractParser<EventNetworkResult> {
        AnonymousClass1() {
        }

        @Override // com.google.protobuf.Parser
        public EventNetworkResult parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            Builder builderNewBuilder = EventNetworkResult.newBuilder();
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

    public static Parser<EventNetworkResult> parser() {
        return PARSER;
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Parser<EventNetworkResult> getParserForType() {
        return PARSER;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
    public EventNetworkResult getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }
}
