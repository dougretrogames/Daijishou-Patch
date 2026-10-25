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
public final class ReleaseDateStatusResult extends GeneratedMessage implements ReleaseDateStatusResultOrBuilder {
    private static final ReleaseDateStatusResult DEFAULT_INSTANCE;
    private static final Parser<ReleaseDateStatusResult> PARSER;
    public static final int RELEASEDATESTATUSES_FIELD_NUMBER = 1;
    private static final long serialVersionUID = 0;
    private List<ReleaseDateStatus> releasedatestatuses_;

    /* synthetic */ ReleaseDateStatusResult(GeneratedMessage.Builder builder, ReleaseDateStatusResultIA releaseDateStatusResultIA) {
        this(builder);
    }

    static {
        RuntimeVersion.validateProtobufGencodeVersion(RuntimeVersion.RuntimeDomain.PUBLIC, 4, 27, 2, "", ReleaseDateStatusResult.class.getName());
        DEFAULT_INSTANCE = new ReleaseDateStatusResult();
        PARSER = new AnonymousClass1();
    }

    private ReleaseDateStatusResult(GeneratedMessage.Builder<?> builder) {
        super(builder);
    }

    private ReleaseDateStatusResult() {
        this.releasedatestatuses_ = Collections.emptyList();
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return Igdbproto.internal_static_proto_ReleaseDateStatusResult_descriptor;
    }

    @Override // com.google.protobuf.GeneratedMessage
    protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
        return Igdbproto.internal_static_proto_ReleaseDateStatusResult_fieldAccessorTable.ensureFieldAccessorsInitialized(ReleaseDateStatusResult.class, Builder.class);
    }

    @Override // proto.ReleaseDateStatusResultOrBuilder
    public List<ReleaseDateStatus> getReleasedatestatusesList() {
        return this.releasedatestatuses_;
    }

    @Override // proto.ReleaseDateStatusResultOrBuilder
    public List<? extends ReleaseDateStatusOrBuilder> getReleasedatestatusesOrBuilderList() {
        return this.releasedatestatuses_;
    }

    @Override // proto.ReleaseDateStatusResultOrBuilder
    public int getReleasedatestatusesCount() {
        return this.releasedatestatuses_.size();
    }

    @Override // proto.ReleaseDateStatusResultOrBuilder
    public ReleaseDateStatus getReleasedatestatuses(int i) {
        return this.releasedatestatuses_.get(i);
    }

    @Override // proto.ReleaseDateStatusResultOrBuilder
    public ReleaseDateStatusOrBuilder getReleasedatestatusesOrBuilder(int i) {
        return this.releasedatestatuses_.get(i);
    }

    public static ReleaseDateStatusResult parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer);
    }

    public static ReleaseDateStatusResult parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    public static ReleaseDateStatusResult parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString);
    }

    public static ReleaseDateStatusResult parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static ReleaseDateStatusResult parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr);
    }

    public static ReleaseDateStatusResult parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr, extensionRegistryLite);
    }

    public static ReleaseDateStatusResult parseFrom(InputStream inputStream) throws IOException {
        return (ReleaseDateStatusResult) GeneratedMessage.parseWithIOException(PARSER, inputStream);
    }

    public static ReleaseDateStatusResult parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (ReleaseDateStatusResult) GeneratedMessage.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static ReleaseDateStatusResult parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (ReleaseDateStatusResult) GeneratedMessage.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static ReleaseDateStatusResult parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (ReleaseDateStatusResult) GeneratedMessage.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static ReleaseDateStatusResult parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (ReleaseDateStatusResult) GeneratedMessage.parseWithIOException(PARSER, codedInputStream);
    }

    public static ReleaseDateStatusResult parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (ReleaseDateStatusResult) GeneratedMessage.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder newBuilderForType() {
        return newBuilder();
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static Builder newBuilder(ReleaseDateStatusResult releaseDateStatusResult) {
        return (Builder) DEFAULT_INSTANCE.toBuilder().mergeFrom((Message) releaseDateStatusResult);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder toBuilder() {
        return this == DEFAULT_INSTANCE ? new Builder((ReleaseDateStatusResultIA) null) : (Builder) new Builder((ReleaseDateStatusResultIA) null).mergeFrom((Message) this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.AbstractMessage
    public Builder newBuilderForType(AbstractMessage.BuilderParent builderParent) {
        return new Builder(builderParent, null);
    }

    public static final class Builder extends GeneratedMessage.Builder<Builder> implements ReleaseDateStatusResultOrBuilder {
        private int bitField0_;
        private RepeatedFieldBuilder<ReleaseDateStatus, ReleaseDateStatus.Builder, ReleaseDateStatusOrBuilder> releasedatestatusesBuilder_;
        private List<ReleaseDateStatus> releasedatestatuses_;

        /* synthetic */ Builder(AbstractMessage.BuilderParent builderParent, ReleaseDateStatusResultIA releaseDateStatusResultIA) {
            this(builderParent);
        }

        /* synthetic */ Builder(ReleaseDateStatusResultIA releaseDateStatusResultIA) {
            this();
        }

        private void buildPartial0(ReleaseDateStatusResult releaseDateStatusResult) {
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return Igdbproto.internal_static_proto_ReleaseDateStatusResult_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder
        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return Igdbproto.internal_static_proto_ReleaseDateStatusResult_fieldAccessorTable.ensureFieldAccessorsInitialized(ReleaseDateStatusResult.class, Builder.class);
        }

        private Builder() {
            this.releasedatestatuses_ = Collections.emptyList();
        }

        private Builder(AbstractMessage.BuilderParent builderParent) {
            super(builderParent);
            this.releasedatestatuses_ = Collections.emptyList();
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder clear() {
            super.clear();
            this.bitField0_ = 0;
            RepeatedFieldBuilder<ReleaseDateStatus, ReleaseDateStatus.Builder, ReleaseDateStatusOrBuilder> repeatedFieldBuilder = this.releasedatestatusesBuilder_;
            if (repeatedFieldBuilder == null) {
                this.releasedatestatuses_ = Collections.emptyList();
            } else {
                this.releasedatestatuses_ = null;
                repeatedFieldBuilder.clear();
            }
            this.bitField0_ &= -2;
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
        public Descriptors.Descriptor getDescriptorForType() {
            return Igdbproto.internal_static_proto_ReleaseDateStatusResult_descriptor;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public ReleaseDateStatusResult getDefaultInstanceForType() {
            return ReleaseDateStatusResult.getDefaultInstance();
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public ReleaseDateStatusResult build() {
            ReleaseDateStatusResult releaseDateStatusResultBuildPartial = buildPartial();
            if (releaseDateStatusResultBuildPartial.isInitialized()) {
                return releaseDateStatusResultBuildPartial;
            }
            throw newUninitializedMessageException((Message) releaseDateStatusResultBuildPartial);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public ReleaseDateStatusResult buildPartial() {
            ReleaseDateStatusResult releaseDateStatusResult = new ReleaseDateStatusResult(this, null);
            buildPartialRepeatedFields(releaseDateStatusResult);
            if (this.bitField0_ != 0) {
                buildPartial0(releaseDateStatusResult);
            }
            onBuilt();
            return releaseDateStatusResult;
        }

        private void buildPartialRepeatedFields(ReleaseDateStatusResult releaseDateStatusResult) {
            RepeatedFieldBuilder<ReleaseDateStatus, ReleaseDateStatus.Builder, ReleaseDateStatusOrBuilder> repeatedFieldBuilder = this.releasedatestatusesBuilder_;
            if (repeatedFieldBuilder == null) {
                if ((this.bitField0_ & 1) != 0) {
                    this.releasedatestatuses_ = Collections.unmodifiableList(this.releasedatestatuses_);
                    this.bitField0_ &= -2;
                }
                releaseDateStatusResult.releasedatestatuses_ = this.releasedatestatuses_;
                return;
            }
            releaseDateStatusResult.releasedatestatuses_ = repeatedFieldBuilder.build();
        }

        private void ensureReleasedatestatusesIsMutable() {
            if ((this.bitField0_ & 1) == 0) {
                this.releasedatestatuses_ = new ArrayList(this.releasedatestatuses_);
                this.bitField0_ |= 1;
            }
        }

        @Override // proto.ReleaseDateStatusResultOrBuilder
        public List<ReleaseDateStatus> getReleasedatestatusesList() {
            RepeatedFieldBuilder<ReleaseDateStatus, ReleaseDateStatus.Builder, ReleaseDateStatusOrBuilder> repeatedFieldBuilder = this.releasedatestatusesBuilder_;
            if (repeatedFieldBuilder == null) {
                return Collections.unmodifiableList(this.releasedatestatuses_);
            }
            return repeatedFieldBuilder.getMessageList();
        }

        @Override // proto.ReleaseDateStatusResultOrBuilder
        public int getReleasedatestatusesCount() {
            RepeatedFieldBuilder<ReleaseDateStatus, ReleaseDateStatus.Builder, ReleaseDateStatusOrBuilder> repeatedFieldBuilder = this.releasedatestatusesBuilder_;
            if (repeatedFieldBuilder == null) {
                return this.releasedatestatuses_.size();
            }
            return repeatedFieldBuilder.getCount();
        }

        @Override // proto.ReleaseDateStatusResultOrBuilder
        public ReleaseDateStatus getReleasedatestatuses(int i) {
            RepeatedFieldBuilder<ReleaseDateStatus, ReleaseDateStatus.Builder, ReleaseDateStatusOrBuilder> repeatedFieldBuilder = this.releasedatestatusesBuilder_;
            if (repeatedFieldBuilder == null) {
                return this.releasedatestatuses_.get(i);
            }
            return (ReleaseDateStatus) repeatedFieldBuilder.getMessage(i);
        }

        public Builder setReleasedatestatuses(int i, ReleaseDateStatus releaseDateStatus) {
            RepeatedFieldBuilder<ReleaseDateStatus, ReleaseDateStatus.Builder, ReleaseDateStatusOrBuilder> repeatedFieldBuilder = this.releasedatestatusesBuilder_;
            if (repeatedFieldBuilder == null) {
                releaseDateStatus.getClass();
                ensureReleasedatestatusesIsMutable();
                this.releasedatestatuses_.set(i, releaseDateStatus);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.setMessage(i, releaseDateStatus);
            return this;
        }

        public Builder setReleasedatestatuses(int i, ReleaseDateStatus.Builder builder) {
            RepeatedFieldBuilder<ReleaseDateStatus, ReleaseDateStatus.Builder, ReleaseDateStatusOrBuilder> repeatedFieldBuilder = this.releasedatestatusesBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureReleasedatestatusesIsMutable();
                this.releasedatestatuses_.set(i, builder.build());
                onChanged();
                return this;
            }
            repeatedFieldBuilder.setMessage(i, builder.build());
            return this;
        }

        public Builder addReleasedatestatuses(ReleaseDateStatus releaseDateStatus) {
            RepeatedFieldBuilder<ReleaseDateStatus, ReleaseDateStatus.Builder, ReleaseDateStatusOrBuilder> repeatedFieldBuilder = this.releasedatestatusesBuilder_;
            if (repeatedFieldBuilder == null) {
                releaseDateStatus.getClass();
                ensureReleasedatestatusesIsMutable();
                this.releasedatestatuses_.add(releaseDateStatus);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(releaseDateStatus);
            return this;
        }

        public Builder addReleasedatestatuses(int i, ReleaseDateStatus releaseDateStatus) {
            RepeatedFieldBuilder<ReleaseDateStatus, ReleaseDateStatus.Builder, ReleaseDateStatusOrBuilder> repeatedFieldBuilder = this.releasedatestatusesBuilder_;
            if (repeatedFieldBuilder == null) {
                releaseDateStatus.getClass();
                ensureReleasedatestatusesIsMutable();
                this.releasedatestatuses_.add(i, releaseDateStatus);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(i, releaseDateStatus);
            return this;
        }

        public Builder addReleasedatestatuses(ReleaseDateStatus.Builder builder) {
            RepeatedFieldBuilder<ReleaseDateStatus, ReleaseDateStatus.Builder, ReleaseDateStatusOrBuilder> repeatedFieldBuilder = this.releasedatestatusesBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureReleasedatestatusesIsMutable();
                this.releasedatestatuses_.add(builder.build());
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(builder.build());
            return this;
        }

        public Builder addReleasedatestatuses(int i, ReleaseDateStatus.Builder builder) {
            RepeatedFieldBuilder<ReleaseDateStatus, ReleaseDateStatus.Builder, ReleaseDateStatusOrBuilder> repeatedFieldBuilder = this.releasedatestatusesBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureReleasedatestatusesIsMutable();
                this.releasedatestatuses_.add(i, builder.build());
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(i, builder.build());
            return this;
        }

        public Builder addAllReleasedatestatuses(Iterable<? extends ReleaseDateStatus> iterable) {
            RepeatedFieldBuilder<ReleaseDateStatus, ReleaseDateStatus.Builder, ReleaseDateStatusOrBuilder> repeatedFieldBuilder = this.releasedatestatusesBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureReleasedatestatusesIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) iterable, (List) this.releasedatestatuses_);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addAllMessages(iterable);
            return this;
        }

        public Builder clearReleasedatestatuses() {
            RepeatedFieldBuilder<ReleaseDateStatus, ReleaseDateStatus.Builder, ReleaseDateStatusOrBuilder> repeatedFieldBuilder = this.releasedatestatusesBuilder_;
            if (repeatedFieldBuilder == null) {
                this.releasedatestatuses_ = Collections.emptyList();
                this.bitField0_ &= -2;
                onChanged();
                return this;
            }
            repeatedFieldBuilder.clear();
            return this;
        }

        public Builder removeReleasedatestatuses(int i) {
            RepeatedFieldBuilder<ReleaseDateStatus, ReleaseDateStatus.Builder, ReleaseDateStatusOrBuilder> repeatedFieldBuilder = this.releasedatestatusesBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureReleasedatestatusesIsMutable();
                this.releasedatestatuses_.remove(i);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.remove(i);
            return this;
        }

        public ReleaseDateStatus.Builder getReleasedatestatusesBuilder(int i) {
            return (ReleaseDateStatus.Builder) getReleasedatestatusesFieldBuilder().getBuilder(i);
        }

        @Override // proto.ReleaseDateStatusResultOrBuilder
        public ReleaseDateStatusOrBuilder getReleasedatestatusesOrBuilder(int i) {
            RepeatedFieldBuilder<ReleaseDateStatus, ReleaseDateStatus.Builder, ReleaseDateStatusOrBuilder> repeatedFieldBuilder = this.releasedatestatusesBuilder_;
            if (repeatedFieldBuilder == null) {
                return this.releasedatestatuses_.get(i);
            }
            return (ReleaseDateStatusOrBuilder) repeatedFieldBuilder.getMessageOrBuilder(i);
        }

        @Override // proto.ReleaseDateStatusResultOrBuilder
        public List<? extends ReleaseDateStatusOrBuilder> getReleasedatestatusesOrBuilderList() {
            RepeatedFieldBuilder<ReleaseDateStatus, ReleaseDateStatus.Builder, ReleaseDateStatusOrBuilder> repeatedFieldBuilder = this.releasedatestatusesBuilder_;
            if (repeatedFieldBuilder != null) {
                return repeatedFieldBuilder.getMessageOrBuilderList();
            }
            return Collections.unmodifiableList(this.releasedatestatuses_);
        }

        public ReleaseDateStatus.Builder addReleasedatestatusesBuilder() {
            return (ReleaseDateStatus.Builder) getReleasedatestatusesFieldBuilder().addBuilder(ReleaseDateStatus.getDefaultInstance());
        }

        public ReleaseDateStatus.Builder addReleasedatestatusesBuilder(int i) {
            return (ReleaseDateStatus.Builder) getReleasedatestatusesFieldBuilder().addBuilder(i, ReleaseDateStatus.getDefaultInstance());
        }

        public List<ReleaseDateStatus.Builder> getReleasedatestatusesBuilderList() {
            return getReleasedatestatusesFieldBuilder().getBuilderList();
        }

        private RepeatedFieldBuilder<ReleaseDateStatus, ReleaseDateStatus.Builder, ReleaseDateStatusOrBuilder> getReleasedatestatusesFieldBuilder() {
            if (this.releasedatestatusesBuilder_ == null) {
                this.releasedatestatusesBuilder_ = new RepeatedFieldBuilder<>(this.releasedatestatuses_, (this.bitField0_ & 1) != 0, getParentForChildren(), isClean());
                this.releasedatestatuses_ = null;
            }
            return this.releasedatestatusesBuilder_;
        }
    }

    public static ReleaseDateStatusResult getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* JADX INFO: renamed from: proto.ReleaseDateStatusResult$1, reason: invalid class name */
    class AnonymousClass1 extends AbstractParser<ReleaseDateStatusResult> {
        AnonymousClass1() {
        }

        @Override // com.google.protobuf.Parser
        public ReleaseDateStatusResult parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            Builder builderNewBuilder = ReleaseDateStatusResult.newBuilder();
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

    public static Parser<ReleaseDateStatusResult> parser() {
        return PARSER;
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Parser<ReleaseDateStatusResult> getParserForType() {
        return PARSER;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
    public ReleaseDateStatusResult getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }
}
