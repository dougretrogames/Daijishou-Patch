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
public final class CollectionMembershipResult extends GeneratedMessage implements CollectionMembershipResultOrBuilder {
    public static final int COLLECTIONMEMBERSHIPS_FIELD_NUMBER = 1;
    private static final CollectionMembershipResult DEFAULT_INSTANCE;
    private static final Parser<CollectionMembershipResult> PARSER;
    private static final long serialVersionUID = 0;
    private List<CollectionMembership> collectionmemberships_;

    /* synthetic */ CollectionMembershipResult(GeneratedMessage.Builder builder, CollectionMembershipResultIA collectionMembershipResultIA) {
        this(builder);
    }

    static {
        RuntimeVersion.validateProtobufGencodeVersion(RuntimeVersion.RuntimeDomain.PUBLIC, 4, 27, 2, "", CollectionMembershipResult.class.getName());
        DEFAULT_INSTANCE = new CollectionMembershipResult();
        PARSER = new AnonymousClass1();
    }

    private CollectionMembershipResult(GeneratedMessage.Builder<?> builder) {
        super(builder);
    }

    private CollectionMembershipResult() {
        this.collectionmemberships_ = Collections.emptyList();
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return Igdbproto.internal_static_proto_CollectionMembershipResult_descriptor;
    }

    @Override // com.google.protobuf.GeneratedMessage
    protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
        return Igdbproto.internal_static_proto_CollectionMembershipResult_fieldAccessorTable.ensureFieldAccessorsInitialized(CollectionMembershipResult.class, Builder.class);
    }

    @Override // proto.CollectionMembershipResultOrBuilder
    public List<CollectionMembership> getCollectionmembershipsList() {
        return this.collectionmemberships_;
    }

    @Override // proto.CollectionMembershipResultOrBuilder
    public List<? extends CollectionMembershipOrBuilder> getCollectionmembershipsOrBuilderList() {
        return this.collectionmemberships_;
    }

    @Override // proto.CollectionMembershipResultOrBuilder
    public int getCollectionmembershipsCount() {
        return this.collectionmemberships_.size();
    }

    @Override // proto.CollectionMembershipResultOrBuilder
    public CollectionMembership getCollectionmemberships(int i) {
        return this.collectionmemberships_.get(i);
    }

    @Override // proto.CollectionMembershipResultOrBuilder
    public CollectionMembershipOrBuilder getCollectionmembershipsOrBuilder(int i) {
        return this.collectionmemberships_.get(i);
    }

    public static CollectionMembershipResult parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer);
    }

    public static CollectionMembershipResult parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    public static CollectionMembershipResult parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString);
    }

    public static CollectionMembershipResult parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static CollectionMembershipResult parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr);
    }

    public static CollectionMembershipResult parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr, extensionRegistryLite);
    }

    public static CollectionMembershipResult parseFrom(InputStream inputStream) throws IOException {
        return (CollectionMembershipResult) GeneratedMessage.parseWithIOException(PARSER, inputStream);
    }

    public static CollectionMembershipResult parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (CollectionMembershipResult) GeneratedMessage.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static CollectionMembershipResult parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (CollectionMembershipResult) GeneratedMessage.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static CollectionMembershipResult parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (CollectionMembershipResult) GeneratedMessage.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static CollectionMembershipResult parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (CollectionMembershipResult) GeneratedMessage.parseWithIOException(PARSER, codedInputStream);
    }

    public static CollectionMembershipResult parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (CollectionMembershipResult) GeneratedMessage.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder newBuilderForType() {
        return newBuilder();
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static Builder newBuilder(CollectionMembershipResult collectionMembershipResult) {
        return (Builder) DEFAULT_INSTANCE.toBuilder().mergeFrom((Message) collectionMembershipResult);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder toBuilder() {
        return this == DEFAULT_INSTANCE ? new Builder((CollectionMembershipResultIA) null) : (Builder) new Builder((CollectionMembershipResultIA) null).mergeFrom((Message) this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.AbstractMessage
    public Builder newBuilderForType(AbstractMessage.BuilderParent builderParent) {
        return new Builder(builderParent, null);
    }

    public static final class Builder extends GeneratedMessage.Builder<Builder> implements CollectionMembershipResultOrBuilder {
        private int bitField0_;
        private RepeatedFieldBuilder<CollectionMembership, CollectionMembership.Builder, CollectionMembershipOrBuilder> collectionmembershipsBuilder_;
        private List<CollectionMembership> collectionmemberships_;

        /* synthetic */ Builder(AbstractMessage.BuilderParent builderParent, CollectionMembershipResultIA collectionMembershipResultIA) {
            this(builderParent);
        }

        /* synthetic */ Builder(CollectionMembershipResultIA collectionMembershipResultIA) {
            this();
        }

        private void buildPartial0(CollectionMembershipResult collectionMembershipResult) {
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return Igdbproto.internal_static_proto_CollectionMembershipResult_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder
        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return Igdbproto.internal_static_proto_CollectionMembershipResult_fieldAccessorTable.ensureFieldAccessorsInitialized(CollectionMembershipResult.class, Builder.class);
        }

        private Builder() {
            this.collectionmemberships_ = Collections.emptyList();
        }

        private Builder(AbstractMessage.BuilderParent builderParent) {
            super(builderParent);
            this.collectionmemberships_ = Collections.emptyList();
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder clear() {
            super.clear();
            this.bitField0_ = 0;
            RepeatedFieldBuilder<CollectionMembership, CollectionMembership.Builder, CollectionMembershipOrBuilder> repeatedFieldBuilder = this.collectionmembershipsBuilder_;
            if (repeatedFieldBuilder == null) {
                this.collectionmemberships_ = Collections.emptyList();
            } else {
                this.collectionmemberships_ = null;
                repeatedFieldBuilder.clear();
            }
            this.bitField0_ &= -2;
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
        public Descriptors.Descriptor getDescriptorForType() {
            return Igdbproto.internal_static_proto_CollectionMembershipResult_descriptor;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public CollectionMembershipResult getDefaultInstanceForType() {
            return CollectionMembershipResult.getDefaultInstance();
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public CollectionMembershipResult build() {
            CollectionMembershipResult collectionMembershipResultBuildPartial = buildPartial();
            if (collectionMembershipResultBuildPartial.isInitialized()) {
                return collectionMembershipResultBuildPartial;
            }
            throw newUninitializedMessageException((Message) collectionMembershipResultBuildPartial);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public CollectionMembershipResult buildPartial() {
            CollectionMembershipResult collectionMembershipResult = new CollectionMembershipResult(this, null);
            buildPartialRepeatedFields(collectionMembershipResult);
            if (this.bitField0_ != 0) {
                buildPartial0(collectionMembershipResult);
            }
            onBuilt();
            return collectionMembershipResult;
        }

        private void buildPartialRepeatedFields(CollectionMembershipResult collectionMembershipResult) {
            RepeatedFieldBuilder<CollectionMembership, CollectionMembership.Builder, CollectionMembershipOrBuilder> repeatedFieldBuilder = this.collectionmembershipsBuilder_;
            if (repeatedFieldBuilder == null) {
                if ((this.bitField0_ & 1) != 0) {
                    this.collectionmemberships_ = Collections.unmodifiableList(this.collectionmemberships_);
                    this.bitField0_ &= -2;
                }
                collectionMembershipResult.collectionmemberships_ = this.collectionmemberships_;
                return;
            }
            collectionMembershipResult.collectionmemberships_ = repeatedFieldBuilder.build();
        }

        private void ensureCollectionmembershipsIsMutable() {
            if ((this.bitField0_ & 1) == 0) {
                this.collectionmemberships_ = new ArrayList(this.collectionmemberships_);
                this.bitField0_ |= 1;
            }
        }

        @Override // proto.CollectionMembershipResultOrBuilder
        public List<CollectionMembership> getCollectionmembershipsList() {
            RepeatedFieldBuilder<CollectionMembership, CollectionMembership.Builder, CollectionMembershipOrBuilder> repeatedFieldBuilder = this.collectionmembershipsBuilder_;
            if (repeatedFieldBuilder == null) {
                return Collections.unmodifiableList(this.collectionmemberships_);
            }
            return repeatedFieldBuilder.getMessageList();
        }

        @Override // proto.CollectionMembershipResultOrBuilder
        public int getCollectionmembershipsCount() {
            RepeatedFieldBuilder<CollectionMembership, CollectionMembership.Builder, CollectionMembershipOrBuilder> repeatedFieldBuilder = this.collectionmembershipsBuilder_;
            if (repeatedFieldBuilder == null) {
                return this.collectionmemberships_.size();
            }
            return repeatedFieldBuilder.getCount();
        }

        @Override // proto.CollectionMembershipResultOrBuilder
        public CollectionMembership getCollectionmemberships(int i) {
            RepeatedFieldBuilder<CollectionMembership, CollectionMembership.Builder, CollectionMembershipOrBuilder> repeatedFieldBuilder = this.collectionmembershipsBuilder_;
            if (repeatedFieldBuilder == null) {
                return this.collectionmemberships_.get(i);
            }
            return (CollectionMembership) repeatedFieldBuilder.getMessage(i);
        }

        public Builder setCollectionmemberships(int i, CollectionMembership collectionMembership) {
            RepeatedFieldBuilder<CollectionMembership, CollectionMembership.Builder, CollectionMembershipOrBuilder> repeatedFieldBuilder = this.collectionmembershipsBuilder_;
            if (repeatedFieldBuilder == null) {
                collectionMembership.getClass();
                ensureCollectionmembershipsIsMutable();
                this.collectionmemberships_.set(i, collectionMembership);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.setMessage(i, collectionMembership);
            return this;
        }

        public Builder setCollectionmemberships(int i, CollectionMembership.Builder builder) {
            RepeatedFieldBuilder<CollectionMembership, CollectionMembership.Builder, CollectionMembershipOrBuilder> repeatedFieldBuilder = this.collectionmembershipsBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureCollectionmembershipsIsMutable();
                this.collectionmemberships_.set(i, builder.build());
                onChanged();
                return this;
            }
            repeatedFieldBuilder.setMessage(i, builder.build());
            return this;
        }

        public Builder addCollectionmemberships(CollectionMembership collectionMembership) {
            RepeatedFieldBuilder<CollectionMembership, CollectionMembership.Builder, CollectionMembershipOrBuilder> repeatedFieldBuilder = this.collectionmembershipsBuilder_;
            if (repeatedFieldBuilder == null) {
                collectionMembership.getClass();
                ensureCollectionmembershipsIsMutable();
                this.collectionmemberships_.add(collectionMembership);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(collectionMembership);
            return this;
        }

        public Builder addCollectionmemberships(int i, CollectionMembership collectionMembership) {
            RepeatedFieldBuilder<CollectionMembership, CollectionMembership.Builder, CollectionMembershipOrBuilder> repeatedFieldBuilder = this.collectionmembershipsBuilder_;
            if (repeatedFieldBuilder == null) {
                collectionMembership.getClass();
                ensureCollectionmembershipsIsMutable();
                this.collectionmemberships_.add(i, collectionMembership);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(i, collectionMembership);
            return this;
        }

        public Builder addCollectionmemberships(CollectionMembership.Builder builder) {
            RepeatedFieldBuilder<CollectionMembership, CollectionMembership.Builder, CollectionMembershipOrBuilder> repeatedFieldBuilder = this.collectionmembershipsBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureCollectionmembershipsIsMutable();
                this.collectionmemberships_.add(builder.build());
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(builder.build());
            return this;
        }

        public Builder addCollectionmemberships(int i, CollectionMembership.Builder builder) {
            RepeatedFieldBuilder<CollectionMembership, CollectionMembership.Builder, CollectionMembershipOrBuilder> repeatedFieldBuilder = this.collectionmembershipsBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureCollectionmembershipsIsMutable();
                this.collectionmemberships_.add(i, builder.build());
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(i, builder.build());
            return this;
        }

        public Builder addAllCollectionmemberships(Iterable<? extends CollectionMembership> iterable) {
            RepeatedFieldBuilder<CollectionMembership, CollectionMembership.Builder, CollectionMembershipOrBuilder> repeatedFieldBuilder = this.collectionmembershipsBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureCollectionmembershipsIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) iterable, (List) this.collectionmemberships_);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addAllMessages(iterable);
            return this;
        }

        public Builder clearCollectionmemberships() {
            RepeatedFieldBuilder<CollectionMembership, CollectionMembership.Builder, CollectionMembershipOrBuilder> repeatedFieldBuilder = this.collectionmembershipsBuilder_;
            if (repeatedFieldBuilder == null) {
                this.collectionmemberships_ = Collections.emptyList();
                this.bitField0_ &= -2;
                onChanged();
                return this;
            }
            repeatedFieldBuilder.clear();
            return this;
        }

        public Builder removeCollectionmemberships(int i) {
            RepeatedFieldBuilder<CollectionMembership, CollectionMembership.Builder, CollectionMembershipOrBuilder> repeatedFieldBuilder = this.collectionmembershipsBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureCollectionmembershipsIsMutable();
                this.collectionmemberships_.remove(i);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.remove(i);
            return this;
        }

        public CollectionMembership.Builder getCollectionmembershipsBuilder(int i) {
            return (CollectionMembership.Builder) getCollectionmembershipsFieldBuilder().getBuilder(i);
        }

        @Override // proto.CollectionMembershipResultOrBuilder
        public CollectionMembershipOrBuilder getCollectionmembershipsOrBuilder(int i) {
            RepeatedFieldBuilder<CollectionMembership, CollectionMembership.Builder, CollectionMembershipOrBuilder> repeatedFieldBuilder = this.collectionmembershipsBuilder_;
            if (repeatedFieldBuilder == null) {
                return this.collectionmemberships_.get(i);
            }
            return (CollectionMembershipOrBuilder) repeatedFieldBuilder.getMessageOrBuilder(i);
        }

        @Override // proto.CollectionMembershipResultOrBuilder
        public List<? extends CollectionMembershipOrBuilder> getCollectionmembershipsOrBuilderList() {
            RepeatedFieldBuilder<CollectionMembership, CollectionMembership.Builder, CollectionMembershipOrBuilder> repeatedFieldBuilder = this.collectionmembershipsBuilder_;
            if (repeatedFieldBuilder != null) {
                return repeatedFieldBuilder.getMessageOrBuilderList();
            }
            return Collections.unmodifiableList(this.collectionmemberships_);
        }

        public CollectionMembership.Builder addCollectionmembershipsBuilder() {
            return (CollectionMembership.Builder) getCollectionmembershipsFieldBuilder().addBuilder(CollectionMembership.getDefaultInstance());
        }

        public CollectionMembership.Builder addCollectionmembershipsBuilder(int i) {
            return (CollectionMembership.Builder) getCollectionmembershipsFieldBuilder().addBuilder(i, CollectionMembership.getDefaultInstance());
        }

        public List<CollectionMembership.Builder> getCollectionmembershipsBuilderList() {
            return getCollectionmembershipsFieldBuilder().getBuilderList();
        }

        private RepeatedFieldBuilder<CollectionMembership, CollectionMembership.Builder, CollectionMembershipOrBuilder> getCollectionmembershipsFieldBuilder() {
            if (this.collectionmembershipsBuilder_ == null) {
                this.collectionmembershipsBuilder_ = new RepeatedFieldBuilder<>(this.collectionmemberships_, (this.bitField0_ & 1) != 0, getParentForChildren(), isClean());
                this.collectionmemberships_ = null;
            }
            return this.collectionmembershipsBuilder_;
        }
    }

    public static CollectionMembershipResult getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* JADX INFO: renamed from: proto.CollectionMembershipResult$1, reason: invalid class name */
    class AnonymousClass1 extends AbstractParser<CollectionMembershipResult> {
        AnonymousClass1() {
        }

        @Override // com.google.protobuf.Parser
        public CollectionMembershipResult parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            Builder builderNewBuilder = CollectionMembershipResult.newBuilder();
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

    public static Parser<CollectionMembershipResult> parser() {
        return PARSER;
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Parser<CollectionMembershipResult> getParserForType() {
        return PARSER;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
    public CollectionMembershipResult getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }
}
