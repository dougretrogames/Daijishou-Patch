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
public final class CollectionTypeResult extends GeneratedMessage implements CollectionTypeResultOrBuilder {
    public static final int COLLECTIONTYPES_FIELD_NUMBER = 1;
    private static final CollectionTypeResult DEFAULT_INSTANCE;
    private static final Parser<CollectionTypeResult> PARSER;
    private static final long serialVersionUID = 0;
    private List<CollectionType> collectiontypes_;

    /* synthetic */ CollectionTypeResult(GeneratedMessage.Builder builder, CollectionTypeResultIA collectionTypeResultIA) {
        this(builder);
    }

    static {
        RuntimeVersion.validateProtobufGencodeVersion(RuntimeVersion.RuntimeDomain.PUBLIC, 4, 27, 2, "", CollectionTypeResult.class.getName());
        DEFAULT_INSTANCE = new CollectionTypeResult();
        PARSER = new AnonymousClass1();
    }

    private CollectionTypeResult(GeneratedMessage.Builder<?> builder) {
        super(builder);
    }

    private CollectionTypeResult() {
        this.collectiontypes_ = Collections.emptyList();
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return Igdbproto.internal_static_proto_CollectionTypeResult_descriptor;
    }

    @Override // com.google.protobuf.GeneratedMessage
    protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
        return Igdbproto.internal_static_proto_CollectionTypeResult_fieldAccessorTable.ensureFieldAccessorsInitialized(CollectionTypeResult.class, Builder.class);
    }

    @Override // proto.CollectionTypeResultOrBuilder
    public List<CollectionType> getCollectiontypesList() {
        return this.collectiontypes_;
    }

    @Override // proto.CollectionTypeResultOrBuilder
    public List<? extends CollectionTypeOrBuilder> getCollectiontypesOrBuilderList() {
        return this.collectiontypes_;
    }

    @Override // proto.CollectionTypeResultOrBuilder
    public int getCollectiontypesCount() {
        return this.collectiontypes_.size();
    }

    @Override // proto.CollectionTypeResultOrBuilder
    public CollectionType getCollectiontypes(int i) {
        return this.collectiontypes_.get(i);
    }

    @Override // proto.CollectionTypeResultOrBuilder
    public CollectionTypeOrBuilder getCollectiontypesOrBuilder(int i) {
        return this.collectiontypes_.get(i);
    }

    public static CollectionTypeResult parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer);
    }

    public static CollectionTypeResult parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    public static CollectionTypeResult parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString);
    }

    public static CollectionTypeResult parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static CollectionTypeResult parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr);
    }

    public static CollectionTypeResult parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr, extensionRegistryLite);
    }

    public static CollectionTypeResult parseFrom(InputStream inputStream) throws IOException {
        return (CollectionTypeResult) GeneratedMessage.parseWithIOException(PARSER, inputStream);
    }

    public static CollectionTypeResult parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (CollectionTypeResult) GeneratedMessage.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static CollectionTypeResult parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (CollectionTypeResult) GeneratedMessage.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static CollectionTypeResult parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (CollectionTypeResult) GeneratedMessage.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static CollectionTypeResult parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (CollectionTypeResult) GeneratedMessage.parseWithIOException(PARSER, codedInputStream);
    }

    public static CollectionTypeResult parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (CollectionTypeResult) GeneratedMessage.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder newBuilderForType() {
        return newBuilder();
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    /* WARN: Multi-variable type inference failed */
    public static Builder newBuilder(CollectionTypeResult collectionTypeResult) {
        return (Builder) DEFAULT_INSTANCE.toBuilder().mergeFrom((Message) collectionTypeResult);
    }

    /* WARN: Multi-variable type inference failed */
    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder toBuilder() {
        return this == DEFAULT_INSTANCE ? new Builder((CollectionTypeResultIA) null) : (Builder) new Builder((CollectionTypeResultIA) null).mergeFrom((Message) this);
    }

    /* INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.AbstractMessage
    public Builder newBuilderForType(AbstractMessage.BuilderParent builderParent) {
        return new Builder(builderParent, null);
    }

    public static final class Builder extends GeneratedMessage.Builder<Builder> implements CollectionTypeResultOrBuilder {
        private int bitField0_;
        private RepeatedFieldBuilder<CollectionType, CollectionType.Builder, CollectionTypeOrBuilder> collectiontypesBuilder_;
        private List<CollectionType> collectiontypes_;

        /* synthetic */ Builder(AbstractMessage.BuilderParent builderParent, CollectionTypeResultIA collectionTypeResultIA) {
            this(builderParent);
        }

        /* synthetic */ Builder(CollectionTypeResultIA collectionTypeResultIA) {
            this();
        }

        private void buildPartial0(CollectionTypeResult collectionTypeResult) {
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return Igdbproto.internal_static_proto_CollectionTypeResult_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder
        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return Igdbproto.internal_static_proto_CollectionTypeResult_fieldAccessorTable.ensureFieldAccessorsInitialized(CollectionTypeResult.class, Builder.class);
        }

        private Builder() {
            this.collectiontypes_ = Collections.emptyList();
        }

        private Builder(AbstractMessage.BuilderParent builderParent) {
            super(builderParent);
            this.collectiontypes_ = Collections.emptyList();
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder clear() {
            super.clear();
            this.bitField0_ = 0;
            RepeatedFieldBuilder<CollectionType, CollectionType.Builder, CollectionTypeOrBuilder> repeatedFieldBuilder = this.collectiontypesBuilder_;
            if (repeatedFieldBuilder == null) {
                this.collectiontypes_ = Collections.emptyList();
            } else {
                this.collectiontypes_ = null;
                repeatedFieldBuilder.clear();
            }
            this.bitField0_ &= -2;
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
        public Descriptors.Descriptor getDescriptorForType() {
            return Igdbproto.internal_static_proto_CollectionTypeResult_descriptor;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public CollectionTypeResult getDefaultInstanceForType() {
            return CollectionTypeResult.getDefaultInstance();
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public CollectionTypeResult build() {
            CollectionTypeResult collectionTypeResultBuildPartial = buildPartial();
            if (collectionTypeResultBuildPartial.isInitialized()) {
                return collectionTypeResultBuildPartial;
            }
            throw newUninitializedMessageException((Message) collectionTypeResultBuildPartial);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public CollectionTypeResult buildPartial() {
            CollectionTypeResult collectionTypeResult = new CollectionTypeResult(this, null);
            buildPartialRepeatedFields(collectionTypeResult);
            if (this.bitField0_ != 0) {
                buildPartial0(collectionTypeResult);
            }
            onBuilt();
            return collectionTypeResult;
        }

        private void buildPartialRepeatedFields(CollectionTypeResult collectionTypeResult) {
            RepeatedFieldBuilder<CollectionType, CollectionType.Builder, CollectionTypeOrBuilder> repeatedFieldBuilder = this.collectiontypesBuilder_;
            if (repeatedFieldBuilder == null) {
                if ((this.bitField0_ & 1) != 0) {
                    this.collectiontypes_ = Collections.unmodifiableList(this.collectiontypes_);
                    this.bitField0_ &= -2;
                }
                collectionTypeResult.collectiontypes_ = this.collectiontypes_;
                return;
            }
            collectionTypeResult.collectiontypes_ = repeatedFieldBuilder.build();
        }

        private void ensureCollectiontypesIsMutable() {
            if ((this.bitField0_ & 1) == 0) {
                this.collectiontypes_ = new ArrayList(this.collectiontypes_);
                this.bitField0_ |= 1;
            }
        }

        @Override // proto.CollectionTypeResultOrBuilder
        public List<CollectionType> getCollectiontypesList() {
            RepeatedFieldBuilder<CollectionType, CollectionType.Builder, CollectionTypeOrBuilder> repeatedFieldBuilder = this.collectiontypesBuilder_;
            if (repeatedFieldBuilder == null) {
                return Collections.unmodifiableList(this.collectiontypes_);
            }
            return repeatedFieldBuilder.getMessageList();
        }

        @Override // proto.CollectionTypeResultOrBuilder
        public int getCollectiontypesCount() {
            RepeatedFieldBuilder<CollectionType, CollectionType.Builder, CollectionTypeOrBuilder> repeatedFieldBuilder = this.collectiontypesBuilder_;
            if (repeatedFieldBuilder == null) {
                return this.collectiontypes_.size();
            }
            return repeatedFieldBuilder.getCount();
        }

        @Override // proto.CollectionTypeResultOrBuilder
        public CollectionType getCollectiontypes(int i) {
            RepeatedFieldBuilder<CollectionType, CollectionType.Builder, CollectionTypeOrBuilder> repeatedFieldBuilder = this.collectiontypesBuilder_;
            if (repeatedFieldBuilder == null) {
                return this.collectiontypes_.get(i);
            }
            return (CollectionType) repeatedFieldBuilder.getMessage(i);
        }

        public Builder setCollectiontypes(int i, CollectionType collectionType) {
            RepeatedFieldBuilder<CollectionType, CollectionType.Builder, CollectionTypeOrBuilder> repeatedFieldBuilder = this.collectiontypesBuilder_;
            if (repeatedFieldBuilder == null) {
                collectionType.getClass();
                ensureCollectiontypesIsMutable();
                this.collectiontypes_.set(i, collectionType);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.setMessage(i, collectionType);
            return this;
        }

        public Builder setCollectiontypes(int i, CollectionType.Builder builder) {
            RepeatedFieldBuilder<CollectionType, CollectionType.Builder, CollectionTypeOrBuilder> repeatedFieldBuilder = this.collectiontypesBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureCollectiontypesIsMutable();
                this.collectiontypes_.set(i, builder.build());
                onChanged();
                return this;
            }
            repeatedFieldBuilder.setMessage(i, builder.build());
            return this;
        }

        public Builder addCollectiontypes(CollectionType collectionType) {
            RepeatedFieldBuilder<CollectionType, CollectionType.Builder, CollectionTypeOrBuilder> repeatedFieldBuilder = this.collectiontypesBuilder_;
            if (repeatedFieldBuilder == null) {
                collectionType.getClass();
                ensureCollectiontypesIsMutable();
                this.collectiontypes_.add(collectionType);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(collectionType);
            return this;
        }

        public Builder addCollectiontypes(int i, CollectionType collectionType) {
            RepeatedFieldBuilder<CollectionType, CollectionType.Builder, CollectionTypeOrBuilder> repeatedFieldBuilder = this.collectiontypesBuilder_;
            if (repeatedFieldBuilder == null) {
                collectionType.getClass();
                ensureCollectiontypesIsMutable();
                this.collectiontypes_.add(i, collectionType);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(i, collectionType);
            return this;
        }

        public Builder addCollectiontypes(CollectionType.Builder builder) {
            RepeatedFieldBuilder<CollectionType, CollectionType.Builder, CollectionTypeOrBuilder> repeatedFieldBuilder = this.collectiontypesBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureCollectiontypesIsMutable();
                this.collectiontypes_.add(builder.build());
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(builder.build());
            return this;
        }

        public Builder addCollectiontypes(int i, CollectionType.Builder builder) {
            RepeatedFieldBuilder<CollectionType, CollectionType.Builder, CollectionTypeOrBuilder> repeatedFieldBuilder = this.collectiontypesBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureCollectiontypesIsMutable();
                this.collectiontypes_.add(i, builder.build());
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(i, builder.build());
            return this;
        }

        public Builder addAllCollectiontypes(Iterable<? extends CollectionType> iterable) {
            RepeatedFieldBuilder<CollectionType, CollectionType.Builder, CollectionTypeOrBuilder> repeatedFieldBuilder = this.collectiontypesBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureCollectiontypesIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) iterable, (List) this.collectiontypes_);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addAllMessages(iterable);
            return this;
        }

        public Builder clearCollectiontypes() {
            RepeatedFieldBuilder<CollectionType, CollectionType.Builder, CollectionTypeOrBuilder> repeatedFieldBuilder = this.collectiontypesBuilder_;
            if (repeatedFieldBuilder == null) {
                this.collectiontypes_ = Collections.emptyList();
                this.bitField0_ &= -2;
                onChanged();
                return this;
            }
            repeatedFieldBuilder.clear();
            return this;
        }

        public Builder removeCollectiontypes(int i) {
            RepeatedFieldBuilder<CollectionType, CollectionType.Builder, CollectionTypeOrBuilder> repeatedFieldBuilder = this.collectiontypesBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureCollectiontypesIsMutable();
                this.collectiontypes_.remove(i);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.remove(i);
            return this;
        }

        public CollectionType.Builder getCollectiontypesBuilder(int i) {
            return (CollectionType.Builder) getCollectiontypesFieldBuilder().getBuilder(i);
        }

        @Override // proto.CollectionTypeResultOrBuilder
        public CollectionTypeOrBuilder getCollectiontypesOrBuilder(int i) {
            RepeatedFieldBuilder<CollectionType, CollectionType.Builder, CollectionTypeOrBuilder> repeatedFieldBuilder = this.collectiontypesBuilder_;
            if (repeatedFieldBuilder == null) {
                return this.collectiontypes_.get(i);
            }
            return (CollectionTypeOrBuilder) repeatedFieldBuilder.getMessageOrBuilder(i);
        }

        @Override // proto.CollectionTypeResultOrBuilder
        public List<? extends CollectionTypeOrBuilder> getCollectiontypesOrBuilderList() {
            RepeatedFieldBuilder<CollectionType, CollectionType.Builder, CollectionTypeOrBuilder> repeatedFieldBuilder = this.collectiontypesBuilder_;
            if (repeatedFieldBuilder != null) {
                return repeatedFieldBuilder.getMessageOrBuilderList();
            }
            return Collections.unmodifiableList(this.collectiontypes_);
        }

        public CollectionType.Builder addCollectiontypesBuilder() {
            return (CollectionType.Builder) getCollectiontypesFieldBuilder().addBuilder(CollectionType.getDefaultInstance());
        }

        public CollectionType.Builder addCollectiontypesBuilder(int i) {
            return (CollectionType.Builder) getCollectiontypesFieldBuilder().addBuilder(i, CollectionType.getDefaultInstance());
        }

        public List<CollectionType.Builder> getCollectiontypesBuilderList() {
            return getCollectiontypesFieldBuilder().getBuilderList();
        }

        private RepeatedFieldBuilder<CollectionType, CollectionType.Builder, CollectionTypeOrBuilder> getCollectiontypesFieldBuilder() {
            if (this.collectiontypesBuilder_ == null) {
                this.collectiontypesBuilder_ = new RepeatedFieldBuilder<>(this.collectiontypes_, (this.bitField0_ & 1) != 0, getParentForChildren(), isClean());
                this.collectiontypes_ = null;
            }
            return this.collectiontypesBuilder_;
        }
    }

    public static CollectionTypeResult getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* INFO: renamed from: proto.CollectionTypeResult$1, reason: invalid class name */
    class AnonymousClass1 extends AbstractParser<CollectionTypeResult> {
        AnonymousClass1() {
        }

        @Override // com.google.protobuf.Parser
        public CollectionTypeResult parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            Builder builderNewBuilder = CollectionTypeResult.newBuilder();
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

    public static Parser<CollectionTypeResult> parser() {
        return PARSER;
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Parser<CollectionTypeResult> getParserForType() {
        return PARSER;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
    public CollectionTypeResult getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }
}
