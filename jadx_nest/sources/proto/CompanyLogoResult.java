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
public final class CompanyLogoResult extends GeneratedMessage implements CompanyLogoResultOrBuilder {
    public static final int COMPANYLOGOS_FIELD_NUMBER = 1;
    private static final CompanyLogoResult DEFAULT_INSTANCE;
    private static final Parser<CompanyLogoResult> PARSER;
    private static final long serialVersionUID = 0;
    private List<CompanyLogo> companylogos_;

    /* synthetic */ CompanyLogoResult(GeneratedMessage.Builder builder, CompanyLogoResultIA companyLogoResultIA) {
        this(builder);
    }

    static {
        RuntimeVersion.validateProtobufGencodeVersion(RuntimeVersion.RuntimeDomain.PUBLIC, 4, 27, 2, "", CompanyLogoResult.class.getName());
        DEFAULT_INSTANCE = new CompanyLogoResult();
        PARSER = new AnonymousClass1();
    }

    private CompanyLogoResult(GeneratedMessage.Builder<?> builder) {
        super(builder);
    }

    private CompanyLogoResult() {
        this.companylogos_ = Collections.emptyList();
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return Igdbproto.internal_static_proto_CompanyLogoResult_descriptor;
    }

    @Override // com.google.protobuf.GeneratedMessage
    protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
        return Igdbproto.internal_static_proto_CompanyLogoResult_fieldAccessorTable.ensureFieldAccessorsInitialized(CompanyLogoResult.class, Builder.class);
    }

    @Override // proto.CompanyLogoResultOrBuilder
    public List<CompanyLogo> getCompanylogosList() {
        return this.companylogos_;
    }

    @Override // proto.CompanyLogoResultOrBuilder
    public List<? extends CompanyLogoOrBuilder> getCompanylogosOrBuilderList() {
        return this.companylogos_;
    }

    @Override // proto.CompanyLogoResultOrBuilder
    public int getCompanylogosCount() {
        return this.companylogos_.size();
    }

    @Override // proto.CompanyLogoResultOrBuilder
    public CompanyLogo getCompanylogos(int i) {
        return this.companylogos_.get(i);
    }

    @Override // proto.CompanyLogoResultOrBuilder
    public CompanyLogoOrBuilder getCompanylogosOrBuilder(int i) {
        return this.companylogos_.get(i);
    }

    public static CompanyLogoResult parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer);
    }

    public static CompanyLogoResult parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    public static CompanyLogoResult parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString);
    }

    public static CompanyLogoResult parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static CompanyLogoResult parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr);
    }

    public static CompanyLogoResult parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr, extensionRegistryLite);
    }

    public static CompanyLogoResult parseFrom(InputStream inputStream) throws IOException {
        return (CompanyLogoResult) GeneratedMessage.parseWithIOException(PARSER, inputStream);
    }

    public static CompanyLogoResult parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (CompanyLogoResult) GeneratedMessage.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static CompanyLogoResult parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (CompanyLogoResult) GeneratedMessage.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static CompanyLogoResult parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (CompanyLogoResult) GeneratedMessage.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static CompanyLogoResult parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (CompanyLogoResult) GeneratedMessage.parseWithIOException(PARSER, codedInputStream);
    }

    public static CompanyLogoResult parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (CompanyLogoResult) GeneratedMessage.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder newBuilderForType() {
        return newBuilder();
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static Builder newBuilder(CompanyLogoResult companyLogoResult) {
        return (Builder) DEFAULT_INSTANCE.toBuilder().mergeFrom((Message) companyLogoResult);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder toBuilder() {
        return this == DEFAULT_INSTANCE ? new Builder((CompanyLogoResultIA) null) : (Builder) new Builder((CompanyLogoResultIA) null).mergeFrom((Message) this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.AbstractMessage
    public Builder newBuilderForType(AbstractMessage.BuilderParent builderParent) {
        return new Builder(builderParent, null);
    }

    public static final class Builder extends GeneratedMessage.Builder<Builder> implements CompanyLogoResultOrBuilder {
        private int bitField0_;
        private RepeatedFieldBuilder<CompanyLogo, CompanyLogo.Builder, CompanyLogoOrBuilder> companylogosBuilder_;
        private List<CompanyLogo> companylogos_;

        /* synthetic */ Builder(AbstractMessage.BuilderParent builderParent, CompanyLogoResultIA companyLogoResultIA) {
            this(builderParent);
        }

        /* synthetic */ Builder(CompanyLogoResultIA companyLogoResultIA) {
            this();
        }

        private void buildPartial0(CompanyLogoResult companyLogoResult) {
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return Igdbproto.internal_static_proto_CompanyLogoResult_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder
        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return Igdbproto.internal_static_proto_CompanyLogoResult_fieldAccessorTable.ensureFieldAccessorsInitialized(CompanyLogoResult.class, Builder.class);
        }

        private Builder() {
            this.companylogos_ = Collections.emptyList();
        }

        private Builder(AbstractMessage.BuilderParent builderParent) {
            super(builderParent);
            this.companylogos_ = Collections.emptyList();
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder clear() {
            super.clear();
            this.bitField0_ = 0;
            RepeatedFieldBuilder<CompanyLogo, CompanyLogo.Builder, CompanyLogoOrBuilder> repeatedFieldBuilder = this.companylogosBuilder_;
            if (repeatedFieldBuilder == null) {
                this.companylogos_ = Collections.emptyList();
            } else {
                this.companylogos_ = null;
                repeatedFieldBuilder.clear();
            }
            this.bitField0_ &= -2;
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
        public Descriptors.Descriptor getDescriptorForType() {
            return Igdbproto.internal_static_proto_CompanyLogoResult_descriptor;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public CompanyLogoResult getDefaultInstanceForType() {
            return CompanyLogoResult.getDefaultInstance();
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public CompanyLogoResult build() {
            CompanyLogoResult companyLogoResultBuildPartial = buildPartial();
            if (companyLogoResultBuildPartial.isInitialized()) {
                return companyLogoResultBuildPartial;
            }
            throw newUninitializedMessageException((Message) companyLogoResultBuildPartial);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public CompanyLogoResult buildPartial() {
            CompanyLogoResult companyLogoResult = new CompanyLogoResult(this, null);
            buildPartialRepeatedFields(companyLogoResult);
            if (this.bitField0_ != 0) {
                buildPartial0(companyLogoResult);
            }
            onBuilt();
            return companyLogoResult;
        }

        private void buildPartialRepeatedFields(CompanyLogoResult companyLogoResult) {
            RepeatedFieldBuilder<CompanyLogo, CompanyLogo.Builder, CompanyLogoOrBuilder> repeatedFieldBuilder = this.companylogosBuilder_;
            if (repeatedFieldBuilder == null) {
                if ((this.bitField0_ & 1) != 0) {
                    this.companylogos_ = Collections.unmodifiableList(this.companylogos_);
                    this.bitField0_ &= -2;
                }
                companyLogoResult.companylogos_ = this.companylogos_;
                return;
            }
            companyLogoResult.companylogos_ = repeatedFieldBuilder.build();
        }

        private void ensureCompanylogosIsMutable() {
            if ((this.bitField0_ & 1) == 0) {
                this.companylogos_ = new ArrayList(this.companylogos_);
                this.bitField0_ |= 1;
            }
        }

        @Override // proto.CompanyLogoResultOrBuilder
        public List<CompanyLogo> getCompanylogosList() {
            RepeatedFieldBuilder<CompanyLogo, CompanyLogo.Builder, CompanyLogoOrBuilder> repeatedFieldBuilder = this.companylogosBuilder_;
            if (repeatedFieldBuilder == null) {
                return Collections.unmodifiableList(this.companylogos_);
            }
            return repeatedFieldBuilder.getMessageList();
        }

        @Override // proto.CompanyLogoResultOrBuilder
        public int getCompanylogosCount() {
            RepeatedFieldBuilder<CompanyLogo, CompanyLogo.Builder, CompanyLogoOrBuilder> repeatedFieldBuilder = this.companylogosBuilder_;
            if (repeatedFieldBuilder == null) {
                return this.companylogos_.size();
            }
            return repeatedFieldBuilder.getCount();
        }

        @Override // proto.CompanyLogoResultOrBuilder
        public CompanyLogo getCompanylogos(int i) {
            RepeatedFieldBuilder<CompanyLogo, CompanyLogo.Builder, CompanyLogoOrBuilder> repeatedFieldBuilder = this.companylogosBuilder_;
            if (repeatedFieldBuilder == null) {
                return this.companylogos_.get(i);
            }
            return (CompanyLogo) repeatedFieldBuilder.getMessage(i);
        }

        public Builder setCompanylogos(int i, CompanyLogo companyLogo) {
            RepeatedFieldBuilder<CompanyLogo, CompanyLogo.Builder, CompanyLogoOrBuilder> repeatedFieldBuilder = this.companylogosBuilder_;
            if (repeatedFieldBuilder == null) {
                companyLogo.getClass();
                ensureCompanylogosIsMutable();
                this.companylogos_.set(i, companyLogo);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.setMessage(i, companyLogo);
            return this;
        }

        public Builder setCompanylogos(int i, CompanyLogo.Builder builder) {
            RepeatedFieldBuilder<CompanyLogo, CompanyLogo.Builder, CompanyLogoOrBuilder> repeatedFieldBuilder = this.companylogosBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureCompanylogosIsMutable();
                this.companylogos_.set(i, builder.build());
                onChanged();
                return this;
            }
            repeatedFieldBuilder.setMessage(i, builder.build());
            return this;
        }

        public Builder addCompanylogos(CompanyLogo companyLogo) {
            RepeatedFieldBuilder<CompanyLogo, CompanyLogo.Builder, CompanyLogoOrBuilder> repeatedFieldBuilder = this.companylogosBuilder_;
            if (repeatedFieldBuilder == null) {
                companyLogo.getClass();
                ensureCompanylogosIsMutable();
                this.companylogos_.add(companyLogo);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(companyLogo);
            return this;
        }

        public Builder addCompanylogos(int i, CompanyLogo companyLogo) {
            RepeatedFieldBuilder<CompanyLogo, CompanyLogo.Builder, CompanyLogoOrBuilder> repeatedFieldBuilder = this.companylogosBuilder_;
            if (repeatedFieldBuilder == null) {
                companyLogo.getClass();
                ensureCompanylogosIsMutable();
                this.companylogos_.add(i, companyLogo);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(i, companyLogo);
            return this;
        }

        public Builder addCompanylogos(CompanyLogo.Builder builder) {
            RepeatedFieldBuilder<CompanyLogo, CompanyLogo.Builder, CompanyLogoOrBuilder> repeatedFieldBuilder = this.companylogosBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureCompanylogosIsMutable();
                this.companylogos_.add(builder.build());
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(builder.build());
            return this;
        }

        public Builder addCompanylogos(int i, CompanyLogo.Builder builder) {
            RepeatedFieldBuilder<CompanyLogo, CompanyLogo.Builder, CompanyLogoOrBuilder> repeatedFieldBuilder = this.companylogosBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureCompanylogosIsMutable();
                this.companylogos_.add(i, builder.build());
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(i, builder.build());
            return this;
        }

        public Builder addAllCompanylogos(Iterable<? extends CompanyLogo> iterable) {
            RepeatedFieldBuilder<CompanyLogo, CompanyLogo.Builder, CompanyLogoOrBuilder> repeatedFieldBuilder = this.companylogosBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureCompanylogosIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) iterable, (List) this.companylogos_);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addAllMessages(iterable);
            return this;
        }

        public Builder clearCompanylogos() {
            RepeatedFieldBuilder<CompanyLogo, CompanyLogo.Builder, CompanyLogoOrBuilder> repeatedFieldBuilder = this.companylogosBuilder_;
            if (repeatedFieldBuilder == null) {
                this.companylogos_ = Collections.emptyList();
                this.bitField0_ &= -2;
                onChanged();
                return this;
            }
            repeatedFieldBuilder.clear();
            return this;
        }

        public Builder removeCompanylogos(int i) {
            RepeatedFieldBuilder<CompanyLogo, CompanyLogo.Builder, CompanyLogoOrBuilder> repeatedFieldBuilder = this.companylogosBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureCompanylogosIsMutable();
                this.companylogos_.remove(i);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.remove(i);
            return this;
        }

        public CompanyLogo.Builder getCompanylogosBuilder(int i) {
            return (CompanyLogo.Builder) getCompanylogosFieldBuilder().getBuilder(i);
        }

        @Override // proto.CompanyLogoResultOrBuilder
        public CompanyLogoOrBuilder getCompanylogosOrBuilder(int i) {
            RepeatedFieldBuilder<CompanyLogo, CompanyLogo.Builder, CompanyLogoOrBuilder> repeatedFieldBuilder = this.companylogosBuilder_;
            if (repeatedFieldBuilder == null) {
                return this.companylogos_.get(i);
            }
            return (CompanyLogoOrBuilder) repeatedFieldBuilder.getMessageOrBuilder(i);
        }

        @Override // proto.CompanyLogoResultOrBuilder
        public List<? extends CompanyLogoOrBuilder> getCompanylogosOrBuilderList() {
            RepeatedFieldBuilder<CompanyLogo, CompanyLogo.Builder, CompanyLogoOrBuilder> repeatedFieldBuilder = this.companylogosBuilder_;
            if (repeatedFieldBuilder != null) {
                return repeatedFieldBuilder.getMessageOrBuilderList();
            }
            return Collections.unmodifiableList(this.companylogos_);
        }

        public CompanyLogo.Builder addCompanylogosBuilder() {
            return (CompanyLogo.Builder) getCompanylogosFieldBuilder().addBuilder(CompanyLogo.getDefaultInstance());
        }

        public CompanyLogo.Builder addCompanylogosBuilder(int i) {
            return (CompanyLogo.Builder) getCompanylogosFieldBuilder().addBuilder(i, CompanyLogo.getDefaultInstance());
        }

        public List<CompanyLogo.Builder> getCompanylogosBuilderList() {
            return getCompanylogosFieldBuilder().getBuilderList();
        }

        private RepeatedFieldBuilder<CompanyLogo, CompanyLogo.Builder, CompanyLogoOrBuilder> getCompanylogosFieldBuilder() {
            if (this.companylogosBuilder_ == null) {
                this.companylogosBuilder_ = new RepeatedFieldBuilder<>(this.companylogos_, (this.bitField0_ & 1) != 0, getParentForChildren(), isClean());
                this.companylogos_ = null;
            }
            return this.companylogosBuilder_;
        }
    }

    public static CompanyLogoResult getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* JADX INFO: renamed from: proto.CompanyLogoResult$1, reason: invalid class name */
    class AnonymousClass1 extends AbstractParser<CompanyLogoResult> {
        AnonymousClass1() {
        }

        @Override // com.google.protobuf.Parser
        public CompanyLogoResult parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            Builder builderNewBuilder = CompanyLogoResult.newBuilder();
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

    public static Parser<CompanyLogoResult> parser() {
        return PARSER;
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Parser<CompanyLogoResult> getParserForType() {
        return PARSER;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
    public CompanyLogoResult getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }
}
