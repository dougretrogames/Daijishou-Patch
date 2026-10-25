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
public final class InvolvedCompanyResult extends GeneratedMessage implements InvolvedCompanyResultOrBuilder {
    private static final InvolvedCompanyResult DEFAULT_INSTANCE;
    public static final int INVOLVEDCOMPANIES_FIELD_NUMBER = 1;
    private static final Parser<InvolvedCompanyResult> PARSER;
    private static final long serialVersionUID = 0;
    private List<InvolvedCompany> involvedcompanies_;

    /* synthetic */ InvolvedCompanyResult(GeneratedMessage.Builder builder, InvolvedCompanyResultIA involvedCompanyResultIA) {
        this(builder);
    }

    static {
        RuntimeVersion.validateProtobufGencodeVersion(RuntimeVersion.RuntimeDomain.PUBLIC, 4, 27, 2, "", InvolvedCompanyResult.class.getName());
        DEFAULT_INSTANCE = new InvolvedCompanyResult();
        PARSER = new AnonymousClass1();
    }

    private InvolvedCompanyResult(GeneratedMessage.Builder<?> builder) {
        super(builder);
    }

    private InvolvedCompanyResult() {
        this.involvedcompanies_ = Collections.emptyList();
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return Igdbproto.internal_static_proto_InvolvedCompanyResult_descriptor;
    }

    @Override // com.google.protobuf.GeneratedMessage
    protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
        return Igdbproto.internal_static_proto_InvolvedCompanyResult_fieldAccessorTable.ensureFieldAccessorsInitialized(InvolvedCompanyResult.class, Builder.class);
    }

    @Override // proto.InvolvedCompanyResultOrBuilder
    public List<InvolvedCompany> getInvolvedcompaniesList() {
        return this.involvedcompanies_;
    }

    @Override // proto.InvolvedCompanyResultOrBuilder
    public List<? extends InvolvedCompanyOrBuilder> getInvolvedcompaniesOrBuilderList() {
        return this.involvedcompanies_;
    }

    @Override // proto.InvolvedCompanyResultOrBuilder
    public int getInvolvedcompaniesCount() {
        return this.involvedcompanies_.size();
    }

    @Override // proto.InvolvedCompanyResultOrBuilder
    public InvolvedCompany getInvolvedcompanies(int i) {
        return this.involvedcompanies_.get(i);
    }

    @Override // proto.InvolvedCompanyResultOrBuilder
    public InvolvedCompanyOrBuilder getInvolvedcompaniesOrBuilder(int i) {
        return this.involvedcompanies_.get(i);
    }

    public static InvolvedCompanyResult parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer);
    }

    public static InvolvedCompanyResult parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    public static InvolvedCompanyResult parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString);
    }

    public static InvolvedCompanyResult parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static InvolvedCompanyResult parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr);
    }

    public static InvolvedCompanyResult parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr, extensionRegistryLite);
    }

    public static InvolvedCompanyResult parseFrom(InputStream inputStream) throws IOException {
        return (InvolvedCompanyResult) GeneratedMessage.parseWithIOException(PARSER, inputStream);
    }

    public static InvolvedCompanyResult parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (InvolvedCompanyResult) GeneratedMessage.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static InvolvedCompanyResult parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (InvolvedCompanyResult) GeneratedMessage.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static InvolvedCompanyResult parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (InvolvedCompanyResult) GeneratedMessage.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static InvolvedCompanyResult parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (InvolvedCompanyResult) GeneratedMessage.parseWithIOException(PARSER, codedInputStream);
    }

    public static InvolvedCompanyResult parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (InvolvedCompanyResult) GeneratedMessage.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder newBuilderForType() {
        return newBuilder();
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static Builder newBuilder(InvolvedCompanyResult involvedCompanyResult) {
        return (Builder) DEFAULT_INSTANCE.toBuilder().mergeFrom((Message) involvedCompanyResult);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder toBuilder() {
        return this == DEFAULT_INSTANCE ? new Builder((InvolvedCompanyResultIA) null) : (Builder) new Builder((InvolvedCompanyResultIA) null).mergeFrom((Message) this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.AbstractMessage
    public Builder newBuilderForType(AbstractMessage.BuilderParent builderParent) {
        return new Builder(builderParent, null);
    }

    public static final class Builder extends GeneratedMessage.Builder<Builder> implements InvolvedCompanyResultOrBuilder {
        private int bitField0_;
        private RepeatedFieldBuilder<InvolvedCompany, InvolvedCompany.Builder, InvolvedCompanyOrBuilder> involvedcompaniesBuilder_;
        private List<InvolvedCompany> involvedcompanies_;

        /* synthetic */ Builder(AbstractMessage.BuilderParent builderParent, InvolvedCompanyResultIA involvedCompanyResultIA) {
            this(builderParent);
        }

        /* synthetic */ Builder(InvolvedCompanyResultIA involvedCompanyResultIA) {
            this();
        }

        private void buildPartial0(InvolvedCompanyResult involvedCompanyResult) {
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return Igdbproto.internal_static_proto_InvolvedCompanyResult_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder
        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return Igdbproto.internal_static_proto_InvolvedCompanyResult_fieldAccessorTable.ensureFieldAccessorsInitialized(InvolvedCompanyResult.class, Builder.class);
        }

        private Builder() {
            this.involvedcompanies_ = Collections.emptyList();
        }

        private Builder(AbstractMessage.BuilderParent builderParent) {
            super(builderParent);
            this.involvedcompanies_ = Collections.emptyList();
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder clear() {
            super.clear();
            this.bitField0_ = 0;
            RepeatedFieldBuilder<InvolvedCompany, InvolvedCompany.Builder, InvolvedCompanyOrBuilder> repeatedFieldBuilder = this.involvedcompaniesBuilder_;
            if (repeatedFieldBuilder == null) {
                this.involvedcompanies_ = Collections.emptyList();
            } else {
                this.involvedcompanies_ = null;
                repeatedFieldBuilder.clear();
            }
            this.bitField0_ &= -2;
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
        public Descriptors.Descriptor getDescriptorForType() {
            return Igdbproto.internal_static_proto_InvolvedCompanyResult_descriptor;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public InvolvedCompanyResult getDefaultInstanceForType() {
            return InvolvedCompanyResult.getDefaultInstance();
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public InvolvedCompanyResult build() {
            InvolvedCompanyResult involvedCompanyResultBuildPartial = buildPartial();
            if (involvedCompanyResultBuildPartial.isInitialized()) {
                return involvedCompanyResultBuildPartial;
            }
            throw newUninitializedMessageException((Message) involvedCompanyResultBuildPartial);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public InvolvedCompanyResult buildPartial() {
            InvolvedCompanyResult involvedCompanyResult = new InvolvedCompanyResult(this, null);
            buildPartialRepeatedFields(involvedCompanyResult);
            if (this.bitField0_ != 0) {
                buildPartial0(involvedCompanyResult);
            }
            onBuilt();
            return involvedCompanyResult;
        }

        private void buildPartialRepeatedFields(InvolvedCompanyResult involvedCompanyResult) {
            RepeatedFieldBuilder<InvolvedCompany, InvolvedCompany.Builder, InvolvedCompanyOrBuilder> repeatedFieldBuilder = this.involvedcompaniesBuilder_;
            if (repeatedFieldBuilder == null) {
                if ((this.bitField0_ & 1) != 0) {
                    this.involvedcompanies_ = Collections.unmodifiableList(this.involvedcompanies_);
                    this.bitField0_ &= -2;
                }
                involvedCompanyResult.involvedcompanies_ = this.involvedcompanies_;
                return;
            }
            involvedCompanyResult.involvedcompanies_ = repeatedFieldBuilder.build();
        }

        private void ensureInvolvedcompaniesIsMutable() {
            if ((this.bitField0_ & 1) == 0) {
                this.involvedcompanies_ = new ArrayList(this.involvedcompanies_);
                this.bitField0_ |= 1;
            }
        }

        @Override // proto.InvolvedCompanyResultOrBuilder
        public List<InvolvedCompany> getInvolvedcompaniesList() {
            RepeatedFieldBuilder<InvolvedCompany, InvolvedCompany.Builder, InvolvedCompanyOrBuilder> repeatedFieldBuilder = this.involvedcompaniesBuilder_;
            if (repeatedFieldBuilder == null) {
                return Collections.unmodifiableList(this.involvedcompanies_);
            }
            return repeatedFieldBuilder.getMessageList();
        }

        @Override // proto.InvolvedCompanyResultOrBuilder
        public int getInvolvedcompaniesCount() {
            RepeatedFieldBuilder<InvolvedCompany, InvolvedCompany.Builder, InvolvedCompanyOrBuilder> repeatedFieldBuilder = this.involvedcompaniesBuilder_;
            if (repeatedFieldBuilder == null) {
                return this.involvedcompanies_.size();
            }
            return repeatedFieldBuilder.getCount();
        }

        @Override // proto.InvolvedCompanyResultOrBuilder
        public InvolvedCompany getInvolvedcompanies(int i) {
            RepeatedFieldBuilder<InvolvedCompany, InvolvedCompany.Builder, InvolvedCompanyOrBuilder> repeatedFieldBuilder = this.involvedcompaniesBuilder_;
            if (repeatedFieldBuilder == null) {
                return this.involvedcompanies_.get(i);
            }
            return (InvolvedCompany) repeatedFieldBuilder.getMessage(i);
        }

        public Builder setInvolvedcompanies(int i, InvolvedCompany involvedCompany) {
            RepeatedFieldBuilder<InvolvedCompany, InvolvedCompany.Builder, InvolvedCompanyOrBuilder> repeatedFieldBuilder = this.involvedcompaniesBuilder_;
            if (repeatedFieldBuilder == null) {
                involvedCompany.getClass();
                ensureInvolvedcompaniesIsMutable();
                this.involvedcompanies_.set(i, involvedCompany);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.setMessage(i, involvedCompany);
            return this;
        }

        public Builder setInvolvedcompanies(int i, InvolvedCompany.Builder builder) {
            RepeatedFieldBuilder<InvolvedCompany, InvolvedCompany.Builder, InvolvedCompanyOrBuilder> repeatedFieldBuilder = this.involvedcompaniesBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureInvolvedcompaniesIsMutable();
                this.involvedcompanies_.set(i, builder.build());
                onChanged();
                return this;
            }
            repeatedFieldBuilder.setMessage(i, builder.build());
            return this;
        }

        public Builder addInvolvedcompanies(InvolvedCompany involvedCompany) {
            RepeatedFieldBuilder<InvolvedCompany, InvolvedCompany.Builder, InvolvedCompanyOrBuilder> repeatedFieldBuilder = this.involvedcompaniesBuilder_;
            if (repeatedFieldBuilder == null) {
                involvedCompany.getClass();
                ensureInvolvedcompaniesIsMutable();
                this.involvedcompanies_.add(involvedCompany);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(involvedCompany);
            return this;
        }

        public Builder addInvolvedcompanies(int i, InvolvedCompany involvedCompany) {
            RepeatedFieldBuilder<InvolvedCompany, InvolvedCompany.Builder, InvolvedCompanyOrBuilder> repeatedFieldBuilder = this.involvedcompaniesBuilder_;
            if (repeatedFieldBuilder == null) {
                involvedCompany.getClass();
                ensureInvolvedcompaniesIsMutable();
                this.involvedcompanies_.add(i, involvedCompany);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(i, involvedCompany);
            return this;
        }

        public Builder addInvolvedcompanies(InvolvedCompany.Builder builder) {
            RepeatedFieldBuilder<InvolvedCompany, InvolvedCompany.Builder, InvolvedCompanyOrBuilder> repeatedFieldBuilder = this.involvedcompaniesBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureInvolvedcompaniesIsMutable();
                this.involvedcompanies_.add(builder.build());
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(builder.build());
            return this;
        }

        public Builder addInvolvedcompanies(int i, InvolvedCompany.Builder builder) {
            RepeatedFieldBuilder<InvolvedCompany, InvolvedCompany.Builder, InvolvedCompanyOrBuilder> repeatedFieldBuilder = this.involvedcompaniesBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureInvolvedcompaniesIsMutable();
                this.involvedcompanies_.add(i, builder.build());
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(i, builder.build());
            return this;
        }

        public Builder addAllInvolvedcompanies(Iterable<? extends InvolvedCompany> iterable) {
            RepeatedFieldBuilder<InvolvedCompany, InvolvedCompany.Builder, InvolvedCompanyOrBuilder> repeatedFieldBuilder = this.involvedcompaniesBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureInvolvedcompaniesIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) iterable, (List) this.involvedcompanies_);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addAllMessages(iterable);
            return this;
        }

        public Builder clearInvolvedcompanies() {
            RepeatedFieldBuilder<InvolvedCompany, InvolvedCompany.Builder, InvolvedCompanyOrBuilder> repeatedFieldBuilder = this.involvedcompaniesBuilder_;
            if (repeatedFieldBuilder == null) {
                this.involvedcompanies_ = Collections.emptyList();
                this.bitField0_ &= -2;
                onChanged();
                return this;
            }
            repeatedFieldBuilder.clear();
            return this;
        }

        public Builder removeInvolvedcompanies(int i) {
            RepeatedFieldBuilder<InvolvedCompany, InvolvedCompany.Builder, InvolvedCompanyOrBuilder> repeatedFieldBuilder = this.involvedcompaniesBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureInvolvedcompaniesIsMutable();
                this.involvedcompanies_.remove(i);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.remove(i);
            return this;
        }

        public InvolvedCompany.Builder getInvolvedcompaniesBuilder(int i) {
            return (InvolvedCompany.Builder) getInvolvedcompaniesFieldBuilder().getBuilder(i);
        }

        @Override // proto.InvolvedCompanyResultOrBuilder
        public InvolvedCompanyOrBuilder getInvolvedcompaniesOrBuilder(int i) {
            RepeatedFieldBuilder<InvolvedCompany, InvolvedCompany.Builder, InvolvedCompanyOrBuilder> repeatedFieldBuilder = this.involvedcompaniesBuilder_;
            if (repeatedFieldBuilder == null) {
                return this.involvedcompanies_.get(i);
            }
            return (InvolvedCompanyOrBuilder) repeatedFieldBuilder.getMessageOrBuilder(i);
        }

        @Override // proto.InvolvedCompanyResultOrBuilder
        public List<? extends InvolvedCompanyOrBuilder> getInvolvedcompaniesOrBuilderList() {
            RepeatedFieldBuilder<InvolvedCompany, InvolvedCompany.Builder, InvolvedCompanyOrBuilder> repeatedFieldBuilder = this.involvedcompaniesBuilder_;
            if (repeatedFieldBuilder != null) {
                return repeatedFieldBuilder.getMessageOrBuilderList();
            }
            return Collections.unmodifiableList(this.involvedcompanies_);
        }

        public InvolvedCompany.Builder addInvolvedcompaniesBuilder() {
            return (InvolvedCompany.Builder) getInvolvedcompaniesFieldBuilder().addBuilder(InvolvedCompany.getDefaultInstance());
        }

        public InvolvedCompany.Builder addInvolvedcompaniesBuilder(int i) {
            return (InvolvedCompany.Builder) getInvolvedcompaniesFieldBuilder().addBuilder(i, InvolvedCompany.getDefaultInstance());
        }

        public List<InvolvedCompany.Builder> getInvolvedcompaniesBuilderList() {
            return getInvolvedcompaniesFieldBuilder().getBuilderList();
        }

        private RepeatedFieldBuilder<InvolvedCompany, InvolvedCompany.Builder, InvolvedCompanyOrBuilder> getInvolvedcompaniesFieldBuilder() {
            if (this.involvedcompaniesBuilder_ == null) {
                this.involvedcompaniesBuilder_ = new RepeatedFieldBuilder<>(this.involvedcompanies_, (this.bitField0_ & 1) != 0, getParentForChildren(), isClean());
                this.involvedcompanies_ = null;
            }
            return this.involvedcompaniesBuilder_;
        }
    }

    public static InvolvedCompanyResult getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* JADX INFO: renamed from: proto.InvolvedCompanyResult$1, reason: invalid class name */
    class AnonymousClass1 extends AbstractParser<InvolvedCompanyResult> {
        AnonymousClass1() {
        }

        @Override // com.google.protobuf.Parser
        public InvolvedCompanyResult parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            Builder builderNewBuilder = InvolvedCompanyResult.newBuilder();
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

    public static Parser<InvolvedCompanyResult> parser() {
        return PARSER;
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Parser<InvolvedCompanyResult> getParserForType() {
        return PARSER;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
    public InvolvedCompanyResult getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }
}
