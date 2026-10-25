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
public final class CollectionMembershipTypeResult extends GeneratedMessage implements CollectionMembershipTypeResultOrBuilder {
    public static final int COLLECTIONMEMBERSHIPTYPES_FIELD_NUMBER = 1;
    private static final CollectionMembershipTypeResult DEFAULT_INSTANCE;
    private static final Parser<CollectionMembershipTypeResult> PARSER;
    private static final long serialVersionUID = 0;
    private List<CollectionMembershipType> collectionmembershiptypes_;

    /* synthetic */ CollectionMembershipTypeResult(GeneratedMessage.Builder builder, CollectionMembershipTypeResultIA collectionMembershipTypeResultIA) {
        this(builder);
    }

    static {
        RuntimeVersion.validateProtobufGencodeVersion(RuntimeVersion.RuntimeDomain.PUBLIC, 4, 27, 2, "", CollectionMembershipTypeResult.class.getName());
        DEFAULT_INSTANCE = new CollectionMembershipTypeResult();
        PARSER = new AnonymousClass1();
    }

    private CollectionMembershipTypeResult(GeneratedMessage.Builder<?> builder) {
        super(builder);
    }

    private CollectionMembershipTypeResult() {
        this.collectionmembershiptypes_ = Collections.emptyList();
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return Igdbproto.internal_static_proto_CollectionMembershipTypeResult_descriptor;
    }

    @Override // com.google.protobuf.GeneratedMessage
    protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
        return Igdbproto.internal_static_proto_CollectionMembershipTypeResult_fieldAccessorTable.ensureFieldAccessorsInitialized(CollectionMembershipTypeResult.class, Builder.class);
    }

    @Override // proto.CollectionMembershipTypeResultOrBuilder
    public List<CollectionMembershipType> getCollectionmembershiptypesList() {
        return this.collectionmembershiptypes_;
    }

    @Override // proto.CollectionMembershipTypeResultOrBuilder
    public List<? extends CollectionMembershipTypeOrBuilder> getCollectionmembershiptypesOrBuilderList() {
        return this.collectionmembershiptypes_;
    }

    @Override // proto.CollectionMembershipTypeResultOrBuilder
    public int getCollectionmembershiptypesCount() {
        return this.collectionmembershiptypes_.size();
    }

    @Override // proto.CollectionMembershipTypeResultOrBuilder
    public CollectionMembershipType getCollectionmembershiptypes(int i) {
        return this.collectionmembershiptypes_.get(i);
    }

    @Override // proto.CollectionMembershipTypeResultOrBuilder
    public CollectionMembershipTypeOrBuilder getCollectionmembershiptypesOrBuilder(int i) {
        return this.collectionmembershiptypes_.get(i);
    }

    public static CollectionMembershipTypeResult parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer);
    }

    public static CollectionMembershipTypeResult parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    public static CollectionMembershipTypeResult parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString);
    }

    public static CollectionMembershipTypeResult parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static CollectionMembershipTypeResult parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr);
    }

    public static CollectionMembershipTypeResult parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr, extensionRegistryLite);
    }

    public static CollectionMembershipTypeResult parseFrom(InputStream inputStream) throws IOException {
        return (CollectionMembershipTypeResult) GeneratedMessage.parseWithIOException(PARSER, inputStream);
    }

    public static CollectionMembershipTypeResult parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (CollectionMembershipTypeResult) GeneratedMessage.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static CollectionMembershipTypeResult parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (CollectionMembershipTypeResult) GeneratedMessage.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static CollectionMembershipTypeResult parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (CollectionMembershipTypeResult) GeneratedMessage.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static CollectionMembershipTypeResult parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (CollectionMembershipTypeResult) GeneratedMessage.parseWithIOException(PARSER, codedInputStream);
    }

    public static CollectionMembershipTypeResult parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (CollectionMembershipTypeResult) GeneratedMessage.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder newBuilderForType() {
        return newBuilder();
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static Builder newBuilder(CollectionMembershipTypeResult collectionMembershipTypeResult) {
        return (Builder) DEFAULT_INSTANCE.toBuilder().mergeFrom((Message) collectionMembershipTypeResult);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder toBuilder() {
        return this == DEFAULT_INSTANCE ? new Builder((CollectionMembershipTypeResultIA) null) : (Builder) new Builder((CollectionMembershipTypeResultIA) null).mergeFrom((Message) this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.AbstractMessage
    public Builder newBuilderForType(AbstractMessage.BuilderParent builderParent) {
        return new Builder(builderParent, null);
    }

    public static final class Builder extends GeneratedMessage.Builder<Builder> implements CollectionMembershipTypeResultOrBuilder {
        private int bitField0_;
        private RepeatedFieldBuilder<CollectionMembershipType, CollectionMembershipType.Builder, CollectionMembershipTypeOrBuilder> collectionmembershiptypesBuilder_;
        private List<CollectionMembershipType> collectionmembershiptypes_;

        /* synthetic */ Builder(AbstractMessage.BuilderParent builderParent, CollectionMembershipTypeResultIA collectionMembershipTypeResultIA) {
            this(builderParent);
        }

        /* synthetic */ Builder(CollectionMembershipTypeResultIA collectionMembershipTypeResultIA) {
            this();
        }

        private void buildPartial0(CollectionMembershipTypeResult collectionMembershipTypeResult) {
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return Igdbproto.internal_static_proto_CollectionMembershipTypeResult_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder
        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return Igdbproto.internal_static_proto_CollectionMembershipTypeResult_fieldAccessorTable.ensureFieldAccessorsInitialized(CollectionMembershipTypeResult.class, Builder.class);
        }

        private Builder() {
            this.collectionmembershiptypes_ = Collections.emptyList();
        }

        private Builder(AbstractMessage.BuilderParent builderParent) {
            super(builderParent);
            this.collectionmembershiptypes_ = Collections.emptyList();
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder clear() {
            super.clear();
            this.bitField0_ = 0;
            RepeatedFieldBuilder<CollectionMembershipType, CollectionMembershipType.Builder, CollectionMembershipTypeOrBuilder> repeatedFieldBuilder = this.collectionmembershiptypesBuilder_;
            if (repeatedFieldBuilder == null) {
                this.collectionmembershiptypes_ = Collections.emptyList();
            } else {
                this.collectionmembershiptypes_ = null;
                repeatedFieldBuilder.clear();
            }
            this.bitField0_ &= -2;
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
        public Descriptors.Descriptor getDescriptorForType() {
            return Igdbproto.internal_static_proto_CollectionMembershipTypeResult_descriptor;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public CollectionMembershipTypeResult getDefaultInstanceForType() {
            return CollectionMembershipTypeResult.getDefaultInstance();
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public CollectionMembershipTypeResult build() {
            CollectionMembershipTypeResult collectionMembershipTypeResultBuildPartial = buildPartial();
            if (collectionMembershipTypeResultBuildPartial.isInitialized()) {
                return collectionMembershipTypeResultBuildPartial;
            }
            throw newUninitializedMessageException((Message) collectionMembershipTypeResultBuildPartial);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public CollectionMembershipTypeResult buildPartial() {
            CollectionMembershipTypeResult collectionMembershipTypeResult = new CollectionMembershipTypeResult(this, null);
            buildPartialRepeatedFields(collectionMembershipTypeResult);
            if (this.bitField0_ != 0) {
                buildPartial0(collectionMembershipTypeResult);
            }
            onBuilt();
            return collectionMembershipTypeResult;
        }

        private void buildPartialRepeatedFields(CollectionMembershipTypeResult collectionMembershipTypeResult) {
            RepeatedFieldBuilder<CollectionMembershipType, CollectionMembershipType.Builder, CollectionMembershipTypeOrBuilder> repeatedFieldBuilder = this.collectionmembershiptypesBuilder_;
            if (repeatedFieldBuilder == null) {
                if ((this.bitField0_ & 1) != 0) {
                    this.collectionmembershiptypes_ = Collections.unmodifiableList(this.collectionmembershiptypes_);
                    this.bitField0_ &= -2;
                }
                collectionMembershipTypeResult.collectionmembershiptypes_ = this.collectionmembershiptypes_;
                return;
            }
            collectionMembershipTypeResult.collectionmembershiptypes_ = repeatedFieldBuilder.build();
        }

        private void ensureCollectionmembershiptypesIsMutable() {
            if ((this.bitField0_ & 1) == 0) {
                this.collectionmembershiptypes_ = new ArrayList(this.collectionmembershiptypes_);
                this.bitField0_ |= 1;
            }
        }

        @Override // proto.CollectionMembershipTypeResultOrBuilder
        public List<CollectionMembershipType> getCollectionmembershiptypesList() {
            RepeatedFieldBuilder<CollectionMembershipType, CollectionMembershipType.Builder, CollectionMembershipTypeOrBuilder> repeatedFieldBuilder = this.collectionmembershiptypesBuilder_;
            if (repeatedFieldBuilder == null) {
                return Collections.unmodifiableList(this.collectionmembershiptypes_);
            }
            return repeatedFieldBuilder.getMessageList();
        }

        @Override // proto.CollectionMembershipTypeResultOrBuilder
        public int getCollectionmembershiptypesCount() {
            RepeatedFieldBuilder<CollectionMembershipType, CollectionMembershipType.Builder, CollectionMembershipTypeOrBuilder> repeatedFieldBuilder = this.collectionmembershiptypesBuilder_;
            if (repeatedFieldBuilder == null) {
                return this.collectionmembershiptypes_.size();
            }
            return repeatedFieldBuilder.getCount();
        }

        @Override // proto.CollectionMembershipTypeResultOrBuilder
        public CollectionMembershipType getCollectionmembershiptypes(int i) {
            RepeatedFieldBuilder<CollectionMembershipType, CollectionMembershipType.Builder, CollectionMembershipTypeOrBuilder> repeatedFieldBuilder = this.collectionmembershiptypesBuilder_;
            if (repeatedFieldBuilder == null) {
                return this.collectionmembershiptypes_.get(i);
            }
            return (CollectionMembershipType) repeatedFieldBuilder.getMessage(i);
        }

        public Builder setCollectionmembershiptypes(int i, CollectionMembershipType collectionMembershipType) {
            RepeatedFieldBuilder<CollectionMembershipType, CollectionMembershipType.Builder, CollectionMembershipTypeOrBuilder> repeatedFieldBuilder = this.collectionmembershiptypesBuilder_;
            if (repeatedFieldBuilder == null) {
                collectionMembershipType.getClass();
                ensureCollectionmembershiptypesIsMutable();
                this.collectionmembershiptypes_.set(i, collectionMembershipType);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.setMessage(i, collectionMembershipType);
            return this;
        }

        public Builder setCollectionmembershiptypes(int i, CollectionMembershipType.Builder builder) {
            RepeatedFieldBuilder<CollectionMembershipType, CollectionMembershipType.Builder, CollectionMembershipTypeOrBuilder> repeatedFieldBuilder = this.collectionmembershiptypesBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureCollectionmembershiptypesIsMutable();
                this.collectionmembershiptypes_.set(i, builder.build());
                onChanged();
                return this;
            }
            repeatedFieldBuilder.setMessage(i, builder.build());
            return this;
        }

        public Builder addCollectionmembershiptypes(CollectionMembershipType collectionMembershipType) {
            RepeatedFieldBuilder<CollectionMembershipType, CollectionMembershipType.Builder, CollectionMembershipTypeOrBuilder> repeatedFieldBuilder = this.collectionmembershiptypesBuilder_;
            if (repeatedFieldBuilder == null) {
                collectionMembershipType.getClass();
                ensureCollectionmembershiptypesIsMutable();
                this.collectionmembershiptypes_.add(collectionMembershipType);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(collectionMembershipType);
            return this;
        }

        public Builder addCollectionmembershiptypes(int i, CollectionMembershipType collectionMembershipType) {
            RepeatedFieldBuilder<CollectionMembershipType, CollectionMembershipType.Builder, CollectionMembershipTypeOrBuilder> repeatedFieldBuilder = this.collectionmembershiptypesBuilder_;
            if (repeatedFieldBuilder == null) {
                collectionMembershipType.getClass();
                ensureCollectionmembershiptypesIsMutable();
                this.collectionmembershiptypes_.add(i, collectionMembershipType);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(i, collectionMembershipType);
            return this;
        }

        public Builder addCollectionmembershiptypes(CollectionMembershipType.Builder builder) {
            RepeatedFieldBuilder<CollectionMembershipType, CollectionMembershipType.Builder, CollectionMembershipTypeOrBuilder> repeatedFieldBuilder = this.collectionmembershiptypesBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureCollectionmembershiptypesIsMutable();
                this.collectionmembershiptypes_.add(builder.build());
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(builder.build());
            return this;
        }

        public Builder addCollectionmembershiptypes(int i, CollectionMembershipType.Builder builder) {
            RepeatedFieldBuilder<CollectionMembershipType, CollectionMembershipType.Builder, CollectionMembershipTypeOrBuilder> repeatedFieldBuilder = this.collectionmembershiptypesBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureCollectionmembershiptypesIsMutable();
                this.collectionmembershiptypes_.add(i, builder.build());
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(i, builder.build());
            return this;
        }

        public Builder addAllCollectionmembershiptypes(Iterable<? extends CollectionMembershipType> iterable) {
            RepeatedFieldBuilder<CollectionMembershipType, CollectionMembershipType.Builder, CollectionMembershipTypeOrBuilder> repeatedFieldBuilder = this.collectionmembershiptypesBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureCollectionmembershiptypesIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) iterable, (List) this.collectionmembershiptypes_);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addAllMessages(iterable);
            return this;
        }

        public Builder clearCollectionmembershiptypes() {
            RepeatedFieldBuilder<CollectionMembershipType, CollectionMembershipType.Builder, CollectionMembershipTypeOrBuilder> repeatedFieldBuilder = this.collectionmembershiptypesBuilder_;
            if (repeatedFieldBuilder == null) {
                this.collectionmembershiptypes_ = Collections.emptyList();
                this.bitField0_ &= -2;
                onChanged();
                return this;
            }
            repeatedFieldBuilder.clear();
            return this;
        }

        public Builder removeCollectionmembershiptypes(int i) {
            RepeatedFieldBuilder<CollectionMembershipType, CollectionMembershipType.Builder, CollectionMembershipTypeOrBuilder> repeatedFieldBuilder = this.collectionmembershiptypesBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureCollectionmembershiptypesIsMutable();
                this.collectionmembershiptypes_.remove(i);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.remove(i);
            return this;
        }

        public CollectionMembershipType.Builder getCollectionmembershiptypesBuilder(int i) {
            return (CollectionMembershipType.Builder) getCollectionmembershiptypesFieldBuilder().getBuilder(i);
        }

        @Override // proto.CollectionMembershipTypeResultOrBuilder
        public CollectionMembershipTypeOrBuilder getCollectionmembershiptypesOrBuilder(int i) {
            RepeatedFieldBuilder<CollectionMembershipType, CollectionMembershipType.Builder, CollectionMembershipTypeOrBuilder> repeatedFieldBuilder = this.collectionmembershiptypesBuilder_;
            if (repeatedFieldBuilder == null) {
                return this.collectionmembershiptypes_.get(i);
            }
            return (CollectionMembershipTypeOrBuilder) repeatedFieldBuilder.getMessageOrBuilder(i);
        }

        @Override // proto.CollectionMembershipTypeResultOrBuilder
        public List<? extends CollectionMembershipTypeOrBuilder> getCollectionmembershiptypesOrBuilderList() {
            RepeatedFieldBuilder<CollectionMembershipType, CollectionMembershipType.Builder, CollectionMembershipTypeOrBuilder> repeatedFieldBuilder = this.collectionmembershiptypesBuilder_;
            if (repeatedFieldBuilder != null) {
                return repeatedFieldBuilder.getMessageOrBuilderList();
            }
            return Collections.unmodifiableList(this.collectionmembershiptypes_);
        }

        public CollectionMembershipType.Builder addCollectionmembershiptypesBuilder() {
            return (CollectionMembershipType.Builder) getCollectionmembershiptypesFieldBuilder().addBuilder(CollectionMembershipType.getDefaultInstance());
        }

        public CollectionMembershipType.Builder addCollectionmembershiptypesBuilder(int i) {
            return (CollectionMembershipType.Builder) getCollectionmembershiptypesFieldBuilder().addBuilder(i, CollectionMembershipType.getDefaultInstance());
        }

        public List<CollectionMembershipType.Builder> getCollectionmembershiptypesBuilderList() {
            return getCollectionmembershiptypesFieldBuilder().getBuilderList();
        }

        private RepeatedFieldBuilder<CollectionMembershipType, CollectionMembershipType.Builder, CollectionMembershipTypeOrBuilder> getCollectionmembershiptypesFieldBuilder() {
            if (this.collectionmembershiptypesBuilder_ == null) {
                this.collectionmembershiptypesBuilder_ = new RepeatedFieldBuilder<>(this.collectionmembershiptypes_, (this.bitField0_ & 1) != 0, getParentForChildren(), isClean());
                this.collectionmembershiptypes_ = null;
            }
            return this.collectionmembershiptypesBuilder_;
        }
    }

    public static CollectionMembershipTypeResult getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* JADX INFO: renamed from: proto.CollectionMembershipTypeResult$1, reason: invalid class name */
    class AnonymousClass1 extends AbstractParser<CollectionMembershipTypeResult> {
        AnonymousClass1() {
        }

        @Override // com.google.protobuf.Parser
        public CollectionMembershipTypeResult parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            Builder builderNewBuilder = CollectionMembershipTypeResult.newBuilder();
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

    public static Parser<CollectionMembershipTypeResult> parser() {
        return PARSER;
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Parser<CollectionMembershipTypeResult> getParserForType() {
        return PARSER;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
    public CollectionMembershipTypeResult getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }
}
