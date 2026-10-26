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
public final class FranchiseResult extends GeneratedMessage implements FranchiseResultOrBuilder {
    private static final FranchiseResult DEFAULT_INSTANCE;
    public static final int FRANCHISES_FIELD_NUMBER = 1;
    private static final Parser<FranchiseResult> PARSER;
    private static final long serialVersionUID = 0;
    private List<Franchise> franchises_;

    /* synthetic */ FranchiseResult(GeneratedMessage.Builder builder, FranchiseResultIA franchiseResultIA) {
        this(builder);
    }

    static {
        RuntimeVersion.validateProtobufGencodeVersion(RuntimeVersion.RuntimeDomain.PUBLIC, 4, 27, 2, "", FranchiseResult.class.getName());
        DEFAULT_INSTANCE = new FranchiseResult();
        PARSER = new AnonymousClass1();
    }

    private FranchiseResult(GeneratedMessage.Builder<?> builder) {
        super(builder);
    }

    private FranchiseResult() {
        this.franchises_ = Collections.emptyList();
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return Igdbproto.internal_static_proto_FranchiseResult_descriptor;
    }

    @Override // com.google.protobuf.GeneratedMessage
    protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
        return Igdbproto.internal_static_proto_FranchiseResult_fieldAccessorTable.ensureFieldAccessorsInitialized(FranchiseResult.class, Builder.class);
    }

    @Override // proto.FranchiseResultOrBuilder
    public List<Franchise> getFranchisesList() {
        return this.franchises_;
    }

    @Override // proto.FranchiseResultOrBuilder
    public List<? extends FranchiseOrBuilder> getFranchisesOrBuilderList() {
        return this.franchises_;
    }

    @Override // proto.FranchiseResultOrBuilder
    public int getFranchisesCount() {
        return this.franchises_.size();
    }

    @Override // proto.FranchiseResultOrBuilder
    public Franchise getFranchises(int i) {
        return this.franchises_.get(i);
    }

    @Override // proto.FranchiseResultOrBuilder
    public FranchiseOrBuilder getFranchisesOrBuilder(int i) {
        return this.franchises_.get(i);
    }

    public static FranchiseResult parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer);
    }

    public static FranchiseResult parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    public static FranchiseResult parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString);
    }

    public static FranchiseResult parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static FranchiseResult parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr);
    }

    public static FranchiseResult parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr, extensionRegistryLite);
    }

    public static FranchiseResult parseFrom(InputStream inputStream) throws IOException {
        return (FranchiseResult) GeneratedMessage.parseWithIOException(PARSER, inputStream);
    }

    public static FranchiseResult parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (FranchiseResult) GeneratedMessage.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static FranchiseResult parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (FranchiseResult) GeneratedMessage.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static FranchiseResult parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (FranchiseResult) GeneratedMessage.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static FranchiseResult parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (FranchiseResult) GeneratedMessage.parseWithIOException(PARSER, codedInputStream);
    }

    public static FranchiseResult parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (FranchiseResult) GeneratedMessage.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder newBuilderForType() {
        return newBuilder();
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    /* WARN: Multi-variable type inference failed */
    public static Builder newBuilder(FranchiseResult franchiseResult) {
        return (Builder) DEFAULT_INSTANCE.toBuilder().mergeFrom((Message) franchiseResult);
    }

    /* WARN: Multi-variable type inference failed */
    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder toBuilder() {
        return this == DEFAULT_INSTANCE ? new Builder((FranchiseResultIA) null) : (Builder) new Builder((FranchiseResultIA) null).mergeFrom((Message) this);
    }

    /* INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.AbstractMessage
    public Builder newBuilderForType(AbstractMessage.BuilderParent builderParent) {
        return new Builder(builderParent, null);
    }

    public static final class Builder extends GeneratedMessage.Builder<Builder> implements FranchiseResultOrBuilder {
        private int bitField0_;
        private RepeatedFieldBuilder<Franchise, Franchise.Builder, FranchiseOrBuilder> franchisesBuilder_;
        private List<Franchise> franchises_;

        /* synthetic */ Builder(AbstractMessage.BuilderParent builderParent, FranchiseResultIA franchiseResultIA) {
            this(builderParent);
        }

        /* synthetic */ Builder(FranchiseResultIA franchiseResultIA) {
            this();
        }

        private void buildPartial0(FranchiseResult franchiseResult) {
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return Igdbproto.internal_static_proto_FranchiseResult_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder
        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return Igdbproto.internal_static_proto_FranchiseResult_fieldAccessorTable.ensureFieldAccessorsInitialized(FranchiseResult.class, Builder.class);
        }

        private Builder() {
            this.franchises_ = Collections.emptyList();
        }

        private Builder(AbstractMessage.BuilderParent builderParent) {
            super(builderParent);
            this.franchises_ = Collections.emptyList();
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder clear() {
            super.clear();
            this.bitField0_ = 0;
            RepeatedFieldBuilder<Franchise, Franchise.Builder, FranchiseOrBuilder> repeatedFieldBuilder = this.franchisesBuilder_;
            if (repeatedFieldBuilder == null) {
                this.franchises_ = Collections.emptyList();
            } else {
                this.franchises_ = null;
                repeatedFieldBuilder.clear();
            }
            this.bitField0_ &= -2;
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
        public Descriptors.Descriptor getDescriptorForType() {
            return Igdbproto.internal_static_proto_FranchiseResult_descriptor;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public FranchiseResult getDefaultInstanceForType() {
            return FranchiseResult.getDefaultInstance();
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public FranchiseResult build() {
            FranchiseResult franchiseResultBuildPartial = buildPartial();
            if (franchiseResultBuildPartial.isInitialized()) {
                return franchiseResultBuildPartial;
            }
            throw newUninitializedMessageException((Message) franchiseResultBuildPartial);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public FranchiseResult buildPartial() {
            FranchiseResult franchiseResult = new FranchiseResult(this, null);
            buildPartialRepeatedFields(franchiseResult);
            if (this.bitField0_ != 0) {
                buildPartial0(franchiseResult);
            }
            onBuilt();
            return franchiseResult;
        }

        private void buildPartialRepeatedFields(FranchiseResult franchiseResult) {
            RepeatedFieldBuilder<Franchise, Franchise.Builder, FranchiseOrBuilder> repeatedFieldBuilder = this.franchisesBuilder_;
            if (repeatedFieldBuilder == null) {
                if ((this.bitField0_ & 1) != 0) {
                    this.franchises_ = Collections.unmodifiableList(this.franchises_);
                    this.bitField0_ &= -2;
                }
                franchiseResult.franchises_ = this.franchises_;
                return;
            }
            franchiseResult.franchises_ = repeatedFieldBuilder.build();
        }

        private void ensureFranchisesIsMutable() {
            if ((this.bitField0_ & 1) == 0) {
                this.franchises_ = new ArrayList(this.franchises_);
                this.bitField0_ |= 1;
            }
        }

        @Override // proto.FranchiseResultOrBuilder
        public List<Franchise> getFranchisesList() {
            RepeatedFieldBuilder<Franchise, Franchise.Builder, FranchiseOrBuilder> repeatedFieldBuilder = this.franchisesBuilder_;
            if (repeatedFieldBuilder == null) {
                return Collections.unmodifiableList(this.franchises_);
            }
            return repeatedFieldBuilder.getMessageList();
        }

        @Override // proto.FranchiseResultOrBuilder
        public int getFranchisesCount() {
            RepeatedFieldBuilder<Franchise, Franchise.Builder, FranchiseOrBuilder> repeatedFieldBuilder = this.franchisesBuilder_;
            if (repeatedFieldBuilder == null) {
                return this.franchises_.size();
            }
            return repeatedFieldBuilder.getCount();
        }

        @Override // proto.FranchiseResultOrBuilder
        public Franchise getFranchises(int i) {
            RepeatedFieldBuilder<Franchise, Franchise.Builder, FranchiseOrBuilder> repeatedFieldBuilder = this.franchisesBuilder_;
            if (repeatedFieldBuilder == null) {
                return this.franchises_.get(i);
            }
            return (Franchise) repeatedFieldBuilder.getMessage(i);
        }

        public Builder setFranchises(int i, Franchise franchise) {
            RepeatedFieldBuilder<Franchise, Franchise.Builder, FranchiseOrBuilder> repeatedFieldBuilder = this.franchisesBuilder_;
            if (repeatedFieldBuilder == null) {
                franchise.getClass();
                ensureFranchisesIsMutable();
                this.franchises_.set(i, franchise);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.setMessage(i, franchise);
            return this;
        }

        public Builder setFranchises(int i, Franchise.Builder builder) {
            RepeatedFieldBuilder<Franchise, Franchise.Builder, FranchiseOrBuilder> repeatedFieldBuilder = this.franchisesBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureFranchisesIsMutable();
                this.franchises_.set(i, builder.build());
                onChanged();
                return this;
            }
            repeatedFieldBuilder.setMessage(i, builder.build());
            return this;
        }

        public Builder addFranchises(Franchise franchise) {
            RepeatedFieldBuilder<Franchise, Franchise.Builder, FranchiseOrBuilder> repeatedFieldBuilder = this.franchisesBuilder_;
            if (repeatedFieldBuilder == null) {
                franchise.getClass();
                ensureFranchisesIsMutable();
                this.franchises_.add(franchise);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(franchise);
            return this;
        }

        public Builder addFranchises(int i, Franchise franchise) {
            RepeatedFieldBuilder<Franchise, Franchise.Builder, FranchiseOrBuilder> repeatedFieldBuilder = this.franchisesBuilder_;
            if (repeatedFieldBuilder == null) {
                franchise.getClass();
                ensureFranchisesIsMutable();
                this.franchises_.add(i, franchise);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(i, franchise);
            return this;
        }

        public Builder addFranchises(Franchise.Builder builder) {
            RepeatedFieldBuilder<Franchise, Franchise.Builder, FranchiseOrBuilder> repeatedFieldBuilder = this.franchisesBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureFranchisesIsMutable();
                this.franchises_.add(builder.build());
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(builder.build());
            return this;
        }

        public Builder addFranchises(int i, Franchise.Builder builder) {
            RepeatedFieldBuilder<Franchise, Franchise.Builder, FranchiseOrBuilder> repeatedFieldBuilder = this.franchisesBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureFranchisesIsMutable();
                this.franchises_.add(i, builder.build());
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(i, builder.build());
            return this;
        }

        public Builder addAllFranchises(Iterable<? extends Franchise> iterable) {
            RepeatedFieldBuilder<Franchise, Franchise.Builder, FranchiseOrBuilder> repeatedFieldBuilder = this.franchisesBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureFranchisesIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) iterable, (List) this.franchises_);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addAllMessages(iterable);
            return this;
        }

        public Builder clearFranchises() {
            RepeatedFieldBuilder<Franchise, Franchise.Builder, FranchiseOrBuilder> repeatedFieldBuilder = this.franchisesBuilder_;
            if (repeatedFieldBuilder == null) {
                this.franchises_ = Collections.emptyList();
                this.bitField0_ &= -2;
                onChanged();
                return this;
            }
            repeatedFieldBuilder.clear();
            return this;
        }

        public Builder removeFranchises(int i) {
            RepeatedFieldBuilder<Franchise, Franchise.Builder, FranchiseOrBuilder> repeatedFieldBuilder = this.franchisesBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureFranchisesIsMutable();
                this.franchises_.remove(i);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.remove(i);
            return this;
        }

        public Franchise.Builder getFranchisesBuilder(int i) {
            return (Franchise.Builder) getFranchisesFieldBuilder().getBuilder(i);
        }

        @Override // proto.FranchiseResultOrBuilder
        public FranchiseOrBuilder getFranchisesOrBuilder(int i) {
            RepeatedFieldBuilder<Franchise, Franchise.Builder, FranchiseOrBuilder> repeatedFieldBuilder = this.franchisesBuilder_;
            if (repeatedFieldBuilder == null) {
                return this.franchises_.get(i);
            }
            return (FranchiseOrBuilder) repeatedFieldBuilder.getMessageOrBuilder(i);
        }

        @Override // proto.FranchiseResultOrBuilder
        public List<? extends FranchiseOrBuilder> getFranchisesOrBuilderList() {
            RepeatedFieldBuilder<Franchise, Franchise.Builder, FranchiseOrBuilder> repeatedFieldBuilder = this.franchisesBuilder_;
            if (repeatedFieldBuilder != null) {
                return repeatedFieldBuilder.getMessageOrBuilderList();
            }
            return Collections.unmodifiableList(this.franchises_);
        }

        public Franchise.Builder addFranchisesBuilder() {
            return (Franchise.Builder) getFranchisesFieldBuilder().addBuilder(Franchise.getDefaultInstance());
        }

        public Franchise.Builder addFranchisesBuilder(int i) {
            return (Franchise.Builder) getFranchisesFieldBuilder().addBuilder(i, Franchise.getDefaultInstance());
        }

        public List<Franchise.Builder> getFranchisesBuilderList() {
            return getFranchisesFieldBuilder().getBuilderList();
        }

        private RepeatedFieldBuilder<Franchise, Franchise.Builder, FranchiseOrBuilder> getFranchisesFieldBuilder() {
            if (this.franchisesBuilder_ == null) {
                this.franchisesBuilder_ = new RepeatedFieldBuilder<>(this.franchises_, (this.bitField0_ & 1) != 0, getParentForChildren(), isClean());
                this.franchises_ = null;
            }
            return this.franchisesBuilder_;
        }
    }

    public static FranchiseResult getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* INFO: renamed from: proto.FranchiseResult$1, reason: invalid class name */
    class AnonymousClass1 extends AbstractParser<FranchiseResult> {
        AnonymousClass1() {
        }

        @Override // com.google.protobuf.Parser
        public FranchiseResult parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            Builder builderNewBuilder = FranchiseResult.newBuilder();
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

    public static Parser<FranchiseResult> parser() {
        return PARSER;
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Parser<FranchiseResult> getParserForType() {
        return PARSER;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
    public FranchiseResult getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }
}
