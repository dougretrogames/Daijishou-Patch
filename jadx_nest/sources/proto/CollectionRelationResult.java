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
public final class CollectionRelationResult extends GeneratedMessage implements CollectionRelationResultOrBuilder {
    public static final int COLLECTIONRELATIONS_FIELD_NUMBER = 1;
    private static final CollectionRelationResult DEFAULT_INSTANCE;
    private static final Parser<CollectionRelationResult> PARSER;
    private static final long serialVersionUID = 0;
    private List<CollectionRelation> collectionrelations_;

    /* synthetic */ CollectionRelationResult(GeneratedMessage.Builder builder, CollectionRelationResultIA collectionRelationResultIA) {
        this(builder);
    }

    static {
        RuntimeVersion.validateProtobufGencodeVersion(RuntimeVersion.RuntimeDomain.PUBLIC, 4, 27, 2, "", CollectionRelationResult.class.getName());
        DEFAULT_INSTANCE = new CollectionRelationResult();
        PARSER = new AnonymousClass1();
    }

    private CollectionRelationResult(GeneratedMessage.Builder<?> builder) {
        super(builder);
    }

    private CollectionRelationResult() {
        this.collectionrelations_ = Collections.emptyList();
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return Igdbproto.internal_static_proto_CollectionRelationResult_descriptor;
    }

    @Override // com.google.protobuf.GeneratedMessage
    protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
        return Igdbproto.internal_static_proto_CollectionRelationResult_fieldAccessorTable.ensureFieldAccessorsInitialized(CollectionRelationResult.class, Builder.class);
    }

    @Override // proto.CollectionRelationResultOrBuilder
    public List<CollectionRelation> getCollectionrelationsList() {
        return this.collectionrelations_;
    }

    @Override // proto.CollectionRelationResultOrBuilder
    public List<? extends CollectionRelationOrBuilder> getCollectionrelationsOrBuilderList() {
        return this.collectionrelations_;
    }

    @Override // proto.CollectionRelationResultOrBuilder
    public int getCollectionrelationsCount() {
        return this.collectionrelations_.size();
    }

    @Override // proto.CollectionRelationResultOrBuilder
    public CollectionRelation getCollectionrelations(int i) {
        return this.collectionrelations_.get(i);
    }

    @Override // proto.CollectionRelationResultOrBuilder
    public CollectionRelationOrBuilder getCollectionrelationsOrBuilder(int i) {
        return this.collectionrelations_.get(i);
    }

    public static CollectionRelationResult parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer);
    }

    public static CollectionRelationResult parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    public static CollectionRelationResult parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString);
    }

    public static CollectionRelationResult parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static CollectionRelationResult parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr);
    }

    public static CollectionRelationResult parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr, extensionRegistryLite);
    }

    public static CollectionRelationResult parseFrom(InputStream inputStream) throws IOException {
        return (CollectionRelationResult) GeneratedMessage.parseWithIOException(PARSER, inputStream);
    }

    public static CollectionRelationResult parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (CollectionRelationResult) GeneratedMessage.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static CollectionRelationResult parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (CollectionRelationResult) GeneratedMessage.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static CollectionRelationResult parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (CollectionRelationResult) GeneratedMessage.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static CollectionRelationResult parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (CollectionRelationResult) GeneratedMessage.parseWithIOException(PARSER, codedInputStream);
    }

    public static CollectionRelationResult parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (CollectionRelationResult) GeneratedMessage.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder newBuilderForType() {
        return newBuilder();
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static Builder newBuilder(CollectionRelationResult collectionRelationResult) {
        return (Builder) DEFAULT_INSTANCE.toBuilder().mergeFrom((Message) collectionRelationResult);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder toBuilder() {
        return this == DEFAULT_INSTANCE ? new Builder((CollectionRelationResultIA) null) : (Builder) new Builder((CollectionRelationResultIA) null).mergeFrom((Message) this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.AbstractMessage
    public Builder newBuilderForType(AbstractMessage.BuilderParent builderParent) {
        return new Builder(builderParent, null);
    }

    public static final class Builder extends GeneratedMessage.Builder<Builder> implements CollectionRelationResultOrBuilder {
        private int bitField0_;
        private RepeatedFieldBuilder<CollectionRelation, CollectionRelation.Builder, CollectionRelationOrBuilder> collectionrelationsBuilder_;
        private List<CollectionRelation> collectionrelations_;

        /* synthetic */ Builder(AbstractMessage.BuilderParent builderParent, CollectionRelationResultIA collectionRelationResultIA) {
            this(builderParent);
        }

        /* synthetic */ Builder(CollectionRelationResultIA collectionRelationResultIA) {
            this();
        }

        private void buildPartial0(CollectionRelationResult collectionRelationResult) {
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return Igdbproto.internal_static_proto_CollectionRelationResult_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder
        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return Igdbproto.internal_static_proto_CollectionRelationResult_fieldAccessorTable.ensureFieldAccessorsInitialized(CollectionRelationResult.class, Builder.class);
        }

        private Builder() {
            this.collectionrelations_ = Collections.emptyList();
        }

        private Builder(AbstractMessage.BuilderParent builderParent) {
            super(builderParent);
            this.collectionrelations_ = Collections.emptyList();
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder clear() {
            super.clear();
            this.bitField0_ = 0;
            RepeatedFieldBuilder<CollectionRelation, CollectionRelation.Builder, CollectionRelationOrBuilder> repeatedFieldBuilder = this.collectionrelationsBuilder_;
            if (repeatedFieldBuilder == null) {
                this.collectionrelations_ = Collections.emptyList();
            } else {
                this.collectionrelations_ = null;
                repeatedFieldBuilder.clear();
            }
            this.bitField0_ &= -2;
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
        public Descriptors.Descriptor getDescriptorForType() {
            return Igdbproto.internal_static_proto_CollectionRelationResult_descriptor;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public CollectionRelationResult getDefaultInstanceForType() {
            return CollectionRelationResult.getDefaultInstance();
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public CollectionRelationResult build() {
            CollectionRelationResult collectionRelationResultBuildPartial = buildPartial();
            if (collectionRelationResultBuildPartial.isInitialized()) {
                return collectionRelationResultBuildPartial;
            }
            throw newUninitializedMessageException((Message) collectionRelationResultBuildPartial);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public CollectionRelationResult buildPartial() {
            CollectionRelationResult collectionRelationResult = new CollectionRelationResult(this, null);
            buildPartialRepeatedFields(collectionRelationResult);
            if (this.bitField0_ != 0) {
                buildPartial0(collectionRelationResult);
            }
            onBuilt();
            return collectionRelationResult;
        }

        private void buildPartialRepeatedFields(CollectionRelationResult collectionRelationResult) {
            RepeatedFieldBuilder<CollectionRelation, CollectionRelation.Builder, CollectionRelationOrBuilder> repeatedFieldBuilder = this.collectionrelationsBuilder_;
            if (repeatedFieldBuilder == null) {
                if ((this.bitField0_ & 1) != 0) {
                    this.collectionrelations_ = Collections.unmodifiableList(this.collectionrelations_);
                    this.bitField0_ &= -2;
                }
                collectionRelationResult.collectionrelations_ = this.collectionrelations_;
                return;
            }
            collectionRelationResult.collectionrelations_ = repeatedFieldBuilder.build();
        }

        private void ensureCollectionrelationsIsMutable() {
            if ((this.bitField0_ & 1) == 0) {
                this.collectionrelations_ = new ArrayList(this.collectionrelations_);
                this.bitField0_ |= 1;
            }
        }

        @Override // proto.CollectionRelationResultOrBuilder
        public List<CollectionRelation> getCollectionrelationsList() {
            RepeatedFieldBuilder<CollectionRelation, CollectionRelation.Builder, CollectionRelationOrBuilder> repeatedFieldBuilder = this.collectionrelationsBuilder_;
            if (repeatedFieldBuilder == null) {
                return Collections.unmodifiableList(this.collectionrelations_);
            }
            return repeatedFieldBuilder.getMessageList();
        }

        @Override // proto.CollectionRelationResultOrBuilder
        public int getCollectionrelationsCount() {
            RepeatedFieldBuilder<CollectionRelation, CollectionRelation.Builder, CollectionRelationOrBuilder> repeatedFieldBuilder = this.collectionrelationsBuilder_;
            if (repeatedFieldBuilder == null) {
                return this.collectionrelations_.size();
            }
            return repeatedFieldBuilder.getCount();
        }

        @Override // proto.CollectionRelationResultOrBuilder
        public CollectionRelation getCollectionrelations(int i) {
            RepeatedFieldBuilder<CollectionRelation, CollectionRelation.Builder, CollectionRelationOrBuilder> repeatedFieldBuilder = this.collectionrelationsBuilder_;
            if (repeatedFieldBuilder == null) {
                return this.collectionrelations_.get(i);
            }
            return (CollectionRelation) repeatedFieldBuilder.getMessage(i);
        }

        public Builder setCollectionrelations(int i, CollectionRelation collectionRelation) {
            RepeatedFieldBuilder<CollectionRelation, CollectionRelation.Builder, CollectionRelationOrBuilder> repeatedFieldBuilder = this.collectionrelationsBuilder_;
            if (repeatedFieldBuilder == null) {
                collectionRelation.getClass();
                ensureCollectionrelationsIsMutable();
                this.collectionrelations_.set(i, collectionRelation);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.setMessage(i, collectionRelation);
            return this;
        }

        public Builder setCollectionrelations(int i, CollectionRelation.Builder builder) {
            RepeatedFieldBuilder<CollectionRelation, CollectionRelation.Builder, CollectionRelationOrBuilder> repeatedFieldBuilder = this.collectionrelationsBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureCollectionrelationsIsMutable();
                this.collectionrelations_.set(i, builder.build());
                onChanged();
                return this;
            }
            repeatedFieldBuilder.setMessage(i, builder.build());
            return this;
        }

        public Builder addCollectionrelations(CollectionRelation collectionRelation) {
            RepeatedFieldBuilder<CollectionRelation, CollectionRelation.Builder, CollectionRelationOrBuilder> repeatedFieldBuilder = this.collectionrelationsBuilder_;
            if (repeatedFieldBuilder == null) {
                collectionRelation.getClass();
                ensureCollectionrelationsIsMutable();
                this.collectionrelations_.add(collectionRelation);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(collectionRelation);
            return this;
        }

        public Builder addCollectionrelations(int i, CollectionRelation collectionRelation) {
            RepeatedFieldBuilder<CollectionRelation, CollectionRelation.Builder, CollectionRelationOrBuilder> repeatedFieldBuilder = this.collectionrelationsBuilder_;
            if (repeatedFieldBuilder == null) {
                collectionRelation.getClass();
                ensureCollectionrelationsIsMutable();
                this.collectionrelations_.add(i, collectionRelation);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(i, collectionRelation);
            return this;
        }

        public Builder addCollectionrelations(CollectionRelation.Builder builder) {
            RepeatedFieldBuilder<CollectionRelation, CollectionRelation.Builder, CollectionRelationOrBuilder> repeatedFieldBuilder = this.collectionrelationsBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureCollectionrelationsIsMutable();
                this.collectionrelations_.add(builder.build());
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(builder.build());
            return this;
        }

        public Builder addCollectionrelations(int i, CollectionRelation.Builder builder) {
            RepeatedFieldBuilder<CollectionRelation, CollectionRelation.Builder, CollectionRelationOrBuilder> repeatedFieldBuilder = this.collectionrelationsBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureCollectionrelationsIsMutable();
                this.collectionrelations_.add(i, builder.build());
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(i, builder.build());
            return this;
        }

        public Builder addAllCollectionrelations(Iterable<? extends CollectionRelation> iterable) {
            RepeatedFieldBuilder<CollectionRelation, CollectionRelation.Builder, CollectionRelationOrBuilder> repeatedFieldBuilder = this.collectionrelationsBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureCollectionrelationsIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) iterable, (List) this.collectionrelations_);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addAllMessages(iterable);
            return this;
        }

        public Builder clearCollectionrelations() {
            RepeatedFieldBuilder<CollectionRelation, CollectionRelation.Builder, CollectionRelationOrBuilder> repeatedFieldBuilder = this.collectionrelationsBuilder_;
            if (repeatedFieldBuilder == null) {
                this.collectionrelations_ = Collections.emptyList();
                this.bitField0_ &= -2;
                onChanged();
                return this;
            }
            repeatedFieldBuilder.clear();
            return this;
        }

        public Builder removeCollectionrelations(int i) {
            RepeatedFieldBuilder<CollectionRelation, CollectionRelation.Builder, CollectionRelationOrBuilder> repeatedFieldBuilder = this.collectionrelationsBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureCollectionrelationsIsMutable();
                this.collectionrelations_.remove(i);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.remove(i);
            return this;
        }

        public CollectionRelation.Builder getCollectionrelationsBuilder(int i) {
            return (CollectionRelation.Builder) getCollectionrelationsFieldBuilder().getBuilder(i);
        }

        @Override // proto.CollectionRelationResultOrBuilder
        public CollectionRelationOrBuilder getCollectionrelationsOrBuilder(int i) {
            RepeatedFieldBuilder<CollectionRelation, CollectionRelation.Builder, CollectionRelationOrBuilder> repeatedFieldBuilder = this.collectionrelationsBuilder_;
            if (repeatedFieldBuilder == null) {
                return this.collectionrelations_.get(i);
            }
            return (CollectionRelationOrBuilder) repeatedFieldBuilder.getMessageOrBuilder(i);
        }

        @Override // proto.CollectionRelationResultOrBuilder
        public List<? extends CollectionRelationOrBuilder> getCollectionrelationsOrBuilderList() {
            RepeatedFieldBuilder<CollectionRelation, CollectionRelation.Builder, CollectionRelationOrBuilder> repeatedFieldBuilder = this.collectionrelationsBuilder_;
            if (repeatedFieldBuilder != null) {
                return repeatedFieldBuilder.getMessageOrBuilderList();
            }
            return Collections.unmodifiableList(this.collectionrelations_);
        }

        public CollectionRelation.Builder addCollectionrelationsBuilder() {
            return (CollectionRelation.Builder) getCollectionrelationsFieldBuilder().addBuilder(CollectionRelation.getDefaultInstance());
        }

        public CollectionRelation.Builder addCollectionrelationsBuilder(int i) {
            return (CollectionRelation.Builder) getCollectionrelationsFieldBuilder().addBuilder(i, CollectionRelation.getDefaultInstance());
        }

        public List<CollectionRelation.Builder> getCollectionrelationsBuilderList() {
            return getCollectionrelationsFieldBuilder().getBuilderList();
        }

        private RepeatedFieldBuilder<CollectionRelation, CollectionRelation.Builder, CollectionRelationOrBuilder> getCollectionrelationsFieldBuilder() {
            if (this.collectionrelationsBuilder_ == null) {
                this.collectionrelationsBuilder_ = new RepeatedFieldBuilder<>(this.collectionrelations_, (this.bitField0_ & 1) != 0, getParentForChildren(), isClean());
                this.collectionrelations_ = null;
            }
            return this.collectionrelationsBuilder_;
        }
    }

    public static CollectionRelationResult getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* JADX INFO: renamed from: proto.CollectionRelationResult$1, reason: invalid class name */
    class AnonymousClass1 extends AbstractParser<CollectionRelationResult> {
        AnonymousClass1() {
        }

        @Override // com.google.protobuf.Parser
        public CollectionRelationResult parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            Builder builderNewBuilder = CollectionRelationResult.newBuilder();
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

    public static Parser<CollectionRelationResult> parser() {
        return PARSER;
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Parser<CollectionRelationResult> getParserForType() {
        return PARSER;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
    public CollectionRelationResult getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }
}
