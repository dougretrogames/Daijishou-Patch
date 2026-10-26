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
public final class CollectionResult extends GeneratedMessage implements CollectionResultOrBuilder {
    public static final int COLLECTIONS_FIELD_NUMBER = 1;
    private static final CollectionResult DEFAULT_INSTANCE;
    private static final Parser<CollectionResult> PARSER;
    private static final long serialVersionUID = 0;
    private List<Collection> collections_;

    /* synthetic */ CollectionResult(GeneratedMessage.Builder builder, CollectionResultIA collectionResultIA) {
        this(builder);
    }

    static {
        RuntimeVersion.validateProtobufGencodeVersion(RuntimeVersion.RuntimeDomain.PUBLIC, 4, 27, 2, "", CollectionResult.class.getName());
        DEFAULT_INSTANCE = new CollectionResult();
        PARSER = new AnonymousClass1();
    }

    private CollectionResult(GeneratedMessage.Builder<?> builder) {
        super(builder);
    }

    private CollectionResult() {
        this.collections_ = Collections.emptyList();
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return Igdbproto.internal_static_proto_CollectionResult_descriptor;
    }

    @Override // com.google.protobuf.GeneratedMessage
    protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
        return Igdbproto.internal_static_proto_CollectionResult_fieldAccessorTable.ensureFieldAccessorsInitialized(CollectionResult.class, Builder.class);
    }

    @Override // proto.CollectionResultOrBuilder
    public List<Collection> getCollectionsList() {
        return this.collections_;
    }

    @Override // proto.CollectionResultOrBuilder
    public List<? extends CollectionOrBuilder> getCollectionsOrBuilderList() {
        return this.collections_;
    }

    @Override // proto.CollectionResultOrBuilder
    public int getCollectionsCount() {
        return this.collections_.size();
    }

    @Override // proto.CollectionResultOrBuilder
    public Collection getCollections(int i) {
        return this.collections_.get(i);
    }

    @Override // proto.CollectionResultOrBuilder
    public CollectionOrBuilder getCollectionsOrBuilder(int i) {
        return this.collections_.get(i);
    }

    public static CollectionResult parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer);
    }

    public static CollectionResult parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    public static CollectionResult parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString);
    }

    public static CollectionResult parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static CollectionResult parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr);
    }

    public static CollectionResult parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr, extensionRegistryLite);
    }

    public static CollectionResult parseFrom(InputStream inputStream) throws IOException {
        return (CollectionResult) GeneratedMessage.parseWithIOException(PARSER, inputStream);
    }

    public static CollectionResult parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (CollectionResult) GeneratedMessage.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static CollectionResult parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (CollectionResult) GeneratedMessage.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static CollectionResult parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (CollectionResult) GeneratedMessage.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static CollectionResult parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (CollectionResult) GeneratedMessage.parseWithIOException(PARSER, codedInputStream);
    }

    public static CollectionResult parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (CollectionResult) GeneratedMessage.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder newBuilderForType() {
        return newBuilder();
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    /* WARN: Multi-variable type inference failed */
    public static Builder newBuilder(CollectionResult collectionResult) {
        return (Builder) DEFAULT_INSTANCE.toBuilder().mergeFrom((Message) collectionResult);
    }

    /* WARN: Multi-variable type inference failed */
    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder toBuilder() {
        return this == DEFAULT_INSTANCE ? new Builder((CollectionResultIA) null) : (Builder) new Builder((CollectionResultIA) null).mergeFrom((Message) this);
    }

    /* INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.AbstractMessage
    public Builder newBuilderForType(AbstractMessage.BuilderParent builderParent) {
        return new Builder(builderParent, null);
    }

    public static final class Builder extends GeneratedMessage.Builder<Builder> implements CollectionResultOrBuilder {
        private int bitField0_;
        private RepeatedFieldBuilder<Collection, Collection.Builder, CollectionOrBuilder> collectionsBuilder_;
        private List<Collection> collections_;

        /* synthetic */ Builder(AbstractMessage.BuilderParent builderParent, CollectionResultIA collectionResultIA) {
            this(builderParent);
        }

        /* synthetic */ Builder(CollectionResultIA collectionResultIA) {
            this();
        }

        private void buildPartial0(CollectionResult collectionResult) {
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return Igdbproto.internal_static_proto_CollectionResult_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder
        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return Igdbproto.internal_static_proto_CollectionResult_fieldAccessorTable.ensureFieldAccessorsInitialized(CollectionResult.class, Builder.class);
        }

        private Builder() {
            this.collections_ = Collections.emptyList();
        }

        private Builder(AbstractMessage.BuilderParent builderParent) {
            super(builderParent);
            this.collections_ = Collections.emptyList();
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder clear() {
            super.clear();
            this.bitField0_ = 0;
            RepeatedFieldBuilder<Collection, Collection.Builder, CollectionOrBuilder> repeatedFieldBuilder = this.collectionsBuilder_;
            if (repeatedFieldBuilder == null) {
                this.collections_ = Collections.emptyList();
            } else {
                this.collections_ = null;
                repeatedFieldBuilder.clear();
            }
            this.bitField0_ &= -2;
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
        public Descriptors.Descriptor getDescriptorForType() {
            return Igdbproto.internal_static_proto_CollectionResult_descriptor;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public CollectionResult getDefaultInstanceForType() {
            return CollectionResult.getDefaultInstance();
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public CollectionResult build() {
            CollectionResult collectionResultBuildPartial = buildPartial();
            if (collectionResultBuildPartial.isInitialized()) {
                return collectionResultBuildPartial;
            }
            throw newUninitializedMessageException((Message) collectionResultBuildPartial);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public CollectionResult buildPartial() {
            CollectionResult collectionResult = new CollectionResult(this, null);
            buildPartialRepeatedFields(collectionResult);
            if (this.bitField0_ != 0) {
                buildPartial0(collectionResult);
            }
            onBuilt();
            return collectionResult;
        }

        private void buildPartialRepeatedFields(CollectionResult collectionResult) {
            RepeatedFieldBuilder<Collection, Collection.Builder, CollectionOrBuilder> repeatedFieldBuilder = this.collectionsBuilder_;
            if (repeatedFieldBuilder == null) {
                if ((this.bitField0_ & 1) != 0) {
                    this.collections_ = Collections.unmodifiableList(this.collections_);
                    this.bitField0_ &= -2;
                }
                collectionResult.collections_ = this.collections_;
                return;
            }
            collectionResult.collections_ = repeatedFieldBuilder.build();
        }

        private void ensureCollectionsIsMutable() {
            if ((this.bitField0_ & 1) == 0) {
                this.collections_ = new ArrayList(this.collections_);
                this.bitField0_ |= 1;
            }
        }

        @Override // proto.CollectionResultOrBuilder
        public List<Collection> getCollectionsList() {
            RepeatedFieldBuilder<Collection, Collection.Builder, CollectionOrBuilder> repeatedFieldBuilder = this.collectionsBuilder_;
            if (repeatedFieldBuilder == null) {
                return Collections.unmodifiableList(this.collections_);
            }
            return repeatedFieldBuilder.getMessageList();
        }

        @Override // proto.CollectionResultOrBuilder
        public int getCollectionsCount() {
            RepeatedFieldBuilder<Collection, Collection.Builder, CollectionOrBuilder> repeatedFieldBuilder = this.collectionsBuilder_;
            if (repeatedFieldBuilder == null) {
                return this.collections_.size();
            }
            return repeatedFieldBuilder.getCount();
        }

        @Override // proto.CollectionResultOrBuilder
        public Collection getCollections(int i) {
            RepeatedFieldBuilder<Collection, Collection.Builder, CollectionOrBuilder> repeatedFieldBuilder = this.collectionsBuilder_;
            if (repeatedFieldBuilder == null) {
                return this.collections_.get(i);
            }
            return (Collection) repeatedFieldBuilder.getMessage(i);
        }

        public Builder setCollections(int i, Collection collection) {
            RepeatedFieldBuilder<Collection, Collection.Builder, CollectionOrBuilder> repeatedFieldBuilder = this.collectionsBuilder_;
            if (repeatedFieldBuilder == null) {
                collection.getClass();
                ensureCollectionsIsMutable();
                this.collections_.set(i, collection);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.setMessage(i, collection);
            return this;
        }

        public Builder setCollections(int i, Collection.Builder builder) {
            RepeatedFieldBuilder<Collection, Collection.Builder, CollectionOrBuilder> repeatedFieldBuilder = this.collectionsBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureCollectionsIsMutable();
                this.collections_.set(i, builder.build());
                onChanged();
                return this;
            }
            repeatedFieldBuilder.setMessage(i, builder.build());
            return this;
        }

        public Builder addCollections(Collection collection) {
            RepeatedFieldBuilder<Collection, Collection.Builder, CollectionOrBuilder> repeatedFieldBuilder = this.collectionsBuilder_;
            if (repeatedFieldBuilder == null) {
                collection.getClass();
                ensureCollectionsIsMutable();
                this.collections_.add(collection);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(collection);
            return this;
        }

        public Builder addCollections(int i, Collection collection) {
            RepeatedFieldBuilder<Collection, Collection.Builder, CollectionOrBuilder> repeatedFieldBuilder = this.collectionsBuilder_;
            if (repeatedFieldBuilder == null) {
                collection.getClass();
                ensureCollectionsIsMutable();
                this.collections_.add(i, collection);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(i, collection);
            return this;
        }

        public Builder addCollections(Collection.Builder builder) {
            RepeatedFieldBuilder<Collection, Collection.Builder, CollectionOrBuilder> repeatedFieldBuilder = this.collectionsBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureCollectionsIsMutable();
                this.collections_.add(builder.build());
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(builder.build());
            return this;
        }

        public Builder addCollections(int i, Collection.Builder builder) {
            RepeatedFieldBuilder<Collection, Collection.Builder, CollectionOrBuilder> repeatedFieldBuilder = this.collectionsBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureCollectionsIsMutable();
                this.collections_.add(i, builder.build());
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(i, builder.build());
            return this;
        }

        public Builder addAllCollections(Iterable<? extends Collection> iterable) {
            RepeatedFieldBuilder<Collection, Collection.Builder, CollectionOrBuilder> repeatedFieldBuilder = this.collectionsBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureCollectionsIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) iterable, (List) this.collections_);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addAllMessages(iterable);
            return this;
        }

        public Builder clearCollections() {
            RepeatedFieldBuilder<Collection, Collection.Builder, CollectionOrBuilder> repeatedFieldBuilder = this.collectionsBuilder_;
            if (repeatedFieldBuilder == null) {
                this.collections_ = Collections.emptyList();
                this.bitField0_ &= -2;
                onChanged();
                return this;
            }
            repeatedFieldBuilder.clear();
            return this;
        }

        public Builder removeCollections(int i) {
            RepeatedFieldBuilder<Collection, Collection.Builder, CollectionOrBuilder> repeatedFieldBuilder = this.collectionsBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureCollectionsIsMutable();
                this.collections_.remove(i);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.remove(i);
            return this;
        }

        public Collection.Builder getCollectionsBuilder(int i) {
            return (Collection.Builder) getCollectionsFieldBuilder().getBuilder(i);
        }

        @Override // proto.CollectionResultOrBuilder
        public CollectionOrBuilder getCollectionsOrBuilder(int i) {
            RepeatedFieldBuilder<Collection, Collection.Builder, CollectionOrBuilder> repeatedFieldBuilder = this.collectionsBuilder_;
            if (repeatedFieldBuilder == null) {
                return this.collections_.get(i);
            }
            return (CollectionOrBuilder) repeatedFieldBuilder.getMessageOrBuilder(i);
        }

        @Override // proto.CollectionResultOrBuilder
        public List<? extends CollectionOrBuilder> getCollectionsOrBuilderList() {
            RepeatedFieldBuilder<Collection, Collection.Builder, CollectionOrBuilder> repeatedFieldBuilder = this.collectionsBuilder_;
            if (repeatedFieldBuilder != null) {
                return repeatedFieldBuilder.getMessageOrBuilderList();
            }
            return Collections.unmodifiableList(this.collections_);
        }

        public Collection.Builder addCollectionsBuilder() {
            return (Collection.Builder) getCollectionsFieldBuilder().addBuilder(Collection.getDefaultInstance());
        }

        public Collection.Builder addCollectionsBuilder(int i) {
            return (Collection.Builder) getCollectionsFieldBuilder().addBuilder(i, Collection.getDefaultInstance());
        }

        public List<Collection.Builder> getCollectionsBuilderList() {
            return getCollectionsFieldBuilder().getBuilderList();
        }

        private RepeatedFieldBuilder<Collection, Collection.Builder, CollectionOrBuilder> getCollectionsFieldBuilder() {
            if (this.collectionsBuilder_ == null) {
                this.collectionsBuilder_ = new RepeatedFieldBuilder<>(this.collections_, (this.bitField0_ & 1) != 0, getParentForChildren(), isClean());
                this.collections_ = null;
            }
            return this.collectionsBuilder_;
        }
    }

    public static CollectionResult getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* INFO: renamed from: proto.CollectionResult$1, reason: invalid class name */
    class AnonymousClass1 extends AbstractParser<CollectionResult> {
        AnonymousClass1() {
        }

        @Override // com.google.protobuf.Parser
        public CollectionResult parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            Builder builderNewBuilder = CollectionResult.newBuilder();
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

    public static Parser<CollectionResult> parser() {
        return PARSER;
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Parser<CollectionResult> getParserForType() {
        return PARSER;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
    public CollectionResult getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }
}
