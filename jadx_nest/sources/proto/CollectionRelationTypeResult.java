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
public final class CollectionRelationTypeResult extends GeneratedMessage implements CollectionRelationTypeResultOrBuilder {
    public static final int COLLECTIONRELATIONTYPES_FIELD_NUMBER = 1;
    private static final CollectionRelationTypeResult DEFAULT_INSTANCE;
    private static final Parser<CollectionRelationTypeResult> PARSER;
    private static final long serialVersionUID = 0;
    private List<CollectionRelationType> collectionrelationtypes_;

    /* synthetic */ CollectionRelationTypeResult(GeneratedMessage.Builder builder, CollectionRelationTypeResultIA collectionRelationTypeResultIA) {
        this(builder);
    }

    static {
        RuntimeVersion.validateProtobufGencodeVersion(RuntimeVersion.RuntimeDomain.PUBLIC, 4, 27, 2, "", CollectionRelationTypeResult.class.getName());
        DEFAULT_INSTANCE = new CollectionRelationTypeResult();
        PARSER = new AnonymousClass1();
    }

    private CollectionRelationTypeResult(GeneratedMessage.Builder<?> builder) {
        super(builder);
    }

    private CollectionRelationTypeResult() {
        this.collectionrelationtypes_ = Collections.emptyList();
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return Igdbproto.internal_static_proto_CollectionRelationTypeResult_descriptor;
    }

    @Override // com.google.protobuf.GeneratedMessage
    protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
        return Igdbproto.internal_static_proto_CollectionRelationTypeResult_fieldAccessorTable.ensureFieldAccessorsInitialized(CollectionRelationTypeResult.class, Builder.class);
    }

    @Override // proto.CollectionRelationTypeResultOrBuilder
    public List<CollectionRelationType> getCollectionrelationtypesList() {
        return this.collectionrelationtypes_;
    }

    @Override // proto.CollectionRelationTypeResultOrBuilder
    public List<? extends CollectionRelationTypeOrBuilder> getCollectionrelationtypesOrBuilderList() {
        return this.collectionrelationtypes_;
    }

    @Override // proto.CollectionRelationTypeResultOrBuilder
    public int getCollectionrelationtypesCount() {
        return this.collectionrelationtypes_.size();
    }

    @Override // proto.CollectionRelationTypeResultOrBuilder
    public CollectionRelationType getCollectionrelationtypes(int i) {
        return this.collectionrelationtypes_.get(i);
    }

    @Override // proto.CollectionRelationTypeResultOrBuilder
    public CollectionRelationTypeOrBuilder getCollectionrelationtypesOrBuilder(int i) {
        return this.collectionrelationtypes_.get(i);
    }

    public static CollectionRelationTypeResult parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer);
    }

    public static CollectionRelationTypeResult parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    public static CollectionRelationTypeResult parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString);
    }

    public static CollectionRelationTypeResult parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static CollectionRelationTypeResult parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr);
    }

    public static CollectionRelationTypeResult parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr, extensionRegistryLite);
    }

    public static CollectionRelationTypeResult parseFrom(InputStream inputStream) throws IOException {
        return (CollectionRelationTypeResult) GeneratedMessage.parseWithIOException(PARSER, inputStream);
    }

    public static CollectionRelationTypeResult parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (CollectionRelationTypeResult) GeneratedMessage.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static CollectionRelationTypeResult parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (CollectionRelationTypeResult) GeneratedMessage.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static CollectionRelationTypeResult parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (CollectionRelationTypeResult) GeneratedMessage.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static CollectionRelationTypeResult parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (CollectionRelationTypeResult) GeneratedMessage.parseWithIOException(PARSER, codedInputStream);
    }

    public static CollectionRelationTypeResult parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (CollectionRelationTypeResult) GeneratedMessage.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder newBuilderForType() {
        return newBuilder();
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    /* WARN: Multi-variable type inference failed */
    public static Builder newBuilder(CollectionRelationTypeResult collectionRelationTypeResult) {
        return (Builder) DEFAULT_INSTANCE.toBuilder().mergeFrom((Message) collectionRelationTypeResult);
    }

    /* WARN: Multi-variable type inference failed */
    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder toBuilder() {
        return this == DEFAULT_INSTANCE ? new Builder((CollectionRelationTypeResultIA) null) : (Builder) new Builder((CollectionRelationTypeResultIA) null).mergeFrom((Message) this);
    }

    /* INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.AbstractMessage
    public Builder newBuilderForType(AbstractMessage.BuilderParent builderParent) {
        return new Builder(builderParent, null);
    }

    public static final class Builder extends GeneratedMessage.Builder<Builder> implements CollectionRelationTypeResultOrBuilder {
        private int bitField0_;
        private RepeatedFieldBuilder<CollectionRelationType, CollectionRelationType.Builder, CollectionRelationTypeOrBuilder> collectionrelationtypesBuilder_;
        private List<CollectionRelationType> collectionrelationtypes_;

        /* synthetic */ Builder(AbstractMessage.BuilderParent builderParent, CollectionRelationTypeResultIA collectionRelationTypeResultIA) {
            this(builderParent);
        }

        /* synthetic */ Builder(CollectionRelationTypeResultIA collectionRelationTypeResultIA) {
            this();
        }

        private void buildPartial0(CollectionRelationTypeResult collectionRelationTypeResult) {
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return Igdbproto.internal_static_proto_CollectionRelationTypeResult_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder
        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return Igdbproto.internal_static_proto_CollectionRelationTypeResult_fieldAccessorTable.ensureFieldAccessorsInitialized(CollectionRelationTypeResult.class, Builder.class);
        }

        private Builder() {
            this.collectionrelationtypes_ = Collections.emptyList();
        }

        private Builder(AbstractMessage.BuilderParent builderParent) {
            super(builderParent);
            this.collectionrelationtypes_ = Collections.emptyList();
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder clear() {
            super.clear();
            this.bitField0_ = 0;
            RepeatedFieldBuilder<CollectionRelationType, CollectionRelationType.Builder, CollectionRelationTypeOrBuilder> repeatedFieldBuilder = this.collectionrelationtypesBuilder_;
            if (repeatedFieldBuilder == null) {
                this.collectionrelationtypes_ = Collections.emptyList();
            } else {
                this.collectionrelationtypes_ = null;
                repeatedFieldBuilder.clear();
            }
            this.bitField0_ &= -2;
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
        public Descriptors.Descriptor getDescriptorForType() {
            return Igdbproto.internal_static_proto_CollectionRelationTypeResult_descriptor;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public CollectionRelationTypeResult getDefaultInstanceForType() {
            return CollectionRelationTypeResult.getDefaultInstance();
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public CollectionRelationTypeResult build() {
            CollectionRelationTypeResult collectionRelationTypeResultBuildPartial = buildPartial();
            if (collectionRelationTypeResultBuildPartial.isInitialized()) {
                return collectionRelationTypeResultBuildPartial;
            }
            throw newUninitializedMessageException((Message) collectionRelationTypeResultBuildPartial);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public CollectionRelationTypeResult buildPartial() {
            CollectionRelationTypeResult collectionRelationTypeResult = new CollectionRelationTypeResult(this, null);
            buildPartialRepeatedFields(collectionRelationTypeResult);
            if (this.bitField0_ != 0) {
                buildPartial0(collectionRelationTypeResult);
            }
            onBuilt();
            return collectionRelationTypeResult;
        }

        private void buildPartialRepeatedFields(CollectionRelationTypeResult collectionRelationTypeResult) {
            RepeatedFieldBuilder<CollectionRelationType, CollectionRelationType.Builder, CollectionRelationTypeOrBuilder> repeatedFieldBuilder = this.collectionrelationtypesBuilder_;
            if (repeatedFieldBuilder == null) {
                if ((this.bitField0_ & 1) != 0) {
                    this.collectionrelationtypes_ = Collections.unmodifiableList(this.collectionrelationtypes_);
                    this.bitField0_ &= -2;
                }
                collectionRelationTypeResult.collectionrelationtypes_ = this.collectionrelationtypes_;
                return;
            }
            collectionRelationTypeResult.collectionrelationtypes_ = repeatedFieldBuilder.build();
        }

        private void ensureCollectionrelationtypesIsMutable() {
            if ((this.bitField0_ & 1) == 0) {
                this.collectionrelationtypes_ = new ArrayList(this.collectionrelationtypes_);
                this.bitField0_ |= 1;
            }
        }

        @Override // proto.CollectionRelationTypeResultOrBuilder
        public List<CollectionRelationType> getCollectionrelationtypesList() {
            RepeatedFieldBuilder<CollectionRelationType, CollectionRelationType.Builder, CollectionRelationTypeOrBuilder> repeatedFieldBuilder = this.collectionrelationtypesBuilder_;
            if (repeatedFieldBuilder == null) {
                return Collections.unmodifiableList(this.collectionrelationtypes_);
            }
            return repeatedFieldBuilder.getMessageList();
        }

        @Override // proto.CollectionRelationTypeResultOrBuilder
        public int getCollectionrelationtypesCount() {
            RepeatedFieldBuilder<CollectionRelationType, CollectionRelationType.Builder, CollectionRelationTypeOrBuilder> repeatedFieldBuilder = this.collectionrelationtypesBuilder_;
            if (repeatedFieldBuilder == null) {
                return this.collectionrelationtypes_.size();
            }
            return repeatedFieldBuilder.getCount();
        }

        @Override // proto.CollectionRelationTypeResultOrBuilder
        public CollectionRelationType getCollectionrelationtypes(int i) {
            RepeatedFieldBuilder<CollectionRelationType, CollectionRelationType.Builder, CollectionRelationTypeOrBuilder> repeatedFieldBuilder = this.collectionrelationtypesBuilder_;
            if (repeatedFieldBuilder == null) {
                return this.collectionrelationtypes_.get(i);
            }
            return (CollectionRelationType) repeatedFieldBuilder.getMessage(i);
        }

        public Builder setCollectionrelationtypes(int i, CollectionRelationType collectionRelationType) {
            RepeatedFieldBuilder<CollectionRelationType, CollectionRelationType.Builder, CollectionRelationTypeOrBuilder> repeatedFieldBuilder = this.collectionrelationtypesBuilder_;
            if (repeatedFieldBuilder == null) {
                collectionRelationType.getClass();
                ensureCollectionrelationtypesIsMutable();
                this.collectionrelationtypes_.set(i, collectionRelationType);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.setMessage(i, collectionRelationType);
            return this;
        }

        public Builder setCollectionrelationtypes(int i, CollectionRelationType.Builder builder) {
            RepeatedFieldBuilder<CollectionRelationType, CollectionRelationType.Builder, CollectionRelationTypeOrBuilder> repeatedFieldBuilder = this.collectionrelationtypesBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureCollectionrelationtypesIsMutable();
                this.collectionrelationtypes_.set(i, builder.build());
                onChanged();
                return this;
            }
            repeatedFieldBuilder.setMessage(i, builder.build());
            return this;
        }

        public Builder addCollectionrelationtypes(CollectionRelationType collectionRelationType) {
            RepeatedFieldBuilder<CollectionRelationType, CollectionRelationType.Builder, CollectionRelationTypeOrBuilder> repeatedFieldBuilder = this.collectionrelationtypesBuilder_;
            if (repeatedFieldBuilder == null) {
                collectionRelationType.getClass();
                ensureCollectionrelationtypesIsMutable();
                this.collectionrelationtypes_.add(collectionRelationType);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(collectionRelationType);
            return this;
        }

        public Builder addCollectionrelationtypes(int i, CollectionRelationType collectionRelationType) {
            RepeatedFieldBuilder<CollectionRelationType, CollectionRelationType.Builder, CollectionRelationTypeOrBuilder> repeatedFieldBuilder = this.collectionrelationtypesBuilder_;
            if (repeatedFieldBuilder == null) {
                collectionRelationType.getClass();
                ensureCollectionrelationtypesIsMutable();
                this.collectionrelationtypes_.add(i, collectionRelationType);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(i, collectionRelationType);
            return this;
        }

        public Builder addCollectionrelationtypes(CollectionRelationType.Builder builder) {
            RepeatedFieldBuilder<CollectionRelationType, CollectionRelationType.Builder, CollectionRelationTypeOrBuilder> repeatedFieldBuilder = this.collectionrelationtypesBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureCollectionrelationtypesIsMutable();
                this.collectionrelationtypes_.add(builder.build());
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(builder.build());
            return this;
        }

        public Builder addCollectionrelationtypes(int i, CollectionRelationType.Builder builder) {
            RepeatedFieldBuilder<CollectionRelationType, CollectionRelationType.Builder, CollectionRelationTypeOrBuilder> repeatedFieldBuilder = this.collectionrelationtypesBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureCollectionrelationtypesIsMutable();
                this.collectionrelationtypes_.add(i, builder.build());
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(i, builder.build());
            return this;
        }

        public Builder addAllCollectionrelationtypes(Iterable<? extends CollectionRelationType> iterable) {
            RepeatedFieldBuilder<CollectionRelationType, CollectionRelationType.Builder, CollectionRelationTypeOrBuilder> repeatedFieldBuilder = this.collectionrelationtypesBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureCollectionrelationtypesIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) iterable, (List) this.collectionrelationtypes_);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addAllMessages(iterable);
            return this;
        }

        public Builder clearCollectionrelationtypes() {
            RepeatedFieldBuilder<CollectionRelationType, CollectionRelationType.Builder, CollectionRelationTypeOrBuilder> repeatedFieldBuilder = this.collectionrelationtypesBuilder_;
            if (repeatedFieldBuilder == null) {
                this.collectionrelationtypes_ = Collections.emptyList();
                this.bitField0_ &= -2;
                onChanged();
                return this;
            }
            repeatedFieldBuilder.clear();
            return this;
        }

        public Builder removeCollectionrelationtypes(int i) {
            RepeatedFieldBuilder<CollectionRelationType, CollectionRelationType.Builder, CollectionRelationTypeOrBuilder> repeatedFieldBuilder = this.collectionrelationtypesBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureCollectionrelationtypesIsMutable();
                this.collectionrelationtypes_.remove(i);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.remove(i);
            return this;
        }

        public CollectionRelationType.Builder getCollectionrelationtypesBuilder(int i) {
            return (CollectionRelationType.Builder) getCollectionrelationtypesFieldBuilder().getBuilder(i);
        }

        @Override // proto.CollectionRelationTypeResultOrBuilder
        public CollectionRelationTypeOrBuilder getCollectionrelationtypesOrBuilder(int i) {
            RepeatedFieldBuilder<CollectionRelationType, CollectionRelationType.Builder, CollectionRelationTypeOrBuilder> repeatedFieldBuilder = this.collectionrelationtypesBuilder_;
            if (repeatedFieldBuilder == null) {
                return this.collectionrelationtypes_.get(i);
            }
            return (CollectionRelationTypeOrBuilder) repeatedFieldBuilder.getMessageOrBuilder(i);
        }

        @Override // proto.CollectionRelationTypeResultOrBuilder
        public List<? extends CollectionRelationTypeOrBuilder> getCollectionrelationtypesOrBuilderList() {
            RepeatedFieldBuilder<CollectionRelationType, CollectionRelationType.Builder, CollectionRelationTypeOrBuilder> repeatedFieldBuilder = this.collectionrelationtypesBuilder_;
            if (repeatedFieldBuilder != null) {
                return repeatedFieldBuilder.getMessageOrBuilderList();
            }
            return Collections.unmodifiableList(this.collectionrelationtypes_);
        }

        public CollectionRelationType.Builder addCollectionrelationtypesBuilder() {
            return (CollectionRelationType.Builder) getCollectionrelationtypesFieldBuilder().addBuilder(CollectionRelationType.getDefaultInstance());
        }

        public CollectionRelationType.Builder addCollectionrelationtypesBuilder(int i) {
            return (CollectionRelationType.Builder) getCollectionrelationtypesFieldBuilder().addBuilder(i, CollectionRelationType.getDefaultInstance());
        }

        public List<CollectionRelationType.Builder> getCollectionrelationtypesBuilderList() {
            return getCollectionrelationtypesFieldBuilder().getBuilderList();
        }

        private RepeatedFieldBuilder<CollectionRelationType, CollectionRelationType.Builder, CollectionRelationTypeOrBuilder> getCollectionrelationtypesFieldBuilder() {
            if (this.collectionrelationtypesBuilder_ == null) {
                this.collectionrelationtypesBuilder_ = new RepeatedFieldBuilder<>(this.collectionrelationtypes_, (this.bitField0_ & 1) != 0, getParentForChildren(), isClean());
                this.collectionrelationtypes_ = null;
            }
            return this.collectionrelationtypesBuilder_;
        }
    }

    public static CollectionRelationTypeResult getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* INFO: renamed from: proto.CollectionRelationTypeResult$1, reason: invalid class name */
    class AnonymousClass1 extends AbstractParser<CollectionRelationTypeResult> {
        AnonymousClass1() {
        }

        @Override // com.google.protobuf.Parser
        public CollectionRelationTypeResult parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            Builder builderNewBuilder = CollectionRelationTypeResult.newBuilder();
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

    public static Parser<CollectionRelationTypeResult> parser() {
        return PARSER;
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Parser<CollectionRelationTypeResult> getParserForType() {
        return PARSER;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
    public CollectionRelationTypeResult getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }
}
