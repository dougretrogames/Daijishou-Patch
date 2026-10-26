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
public final class CoverResult extends GeneratedMessage implements CoverResultOrBuilder {
    public static final int COVERS_FIELD_NUMBER = 1;
    private static final CoverResult DEFAULT_INSTANCE;
    private static final Parser<CoverResult> PARSER;
    private static final long serialVersionUID = 0;
    private List<Cover> covers_;

    /* synthetic */ CoverResult(GeneratedMessage.Builder builder, CoverResultIA coverResultIA) {
        this(builder);
    }

    static {
        RuntimeVersion.validateProtobufGencodeVersion(RuntimeVersion.RuntimeDomain.PUBLIC, 4, 27, 2, "", CoverResult.class.getName());
        DEFAULT_INSTANCE = new CoverResult();
        PARSER = new AnonymousClass1();
    }

    private CoverResult(GeneratedMessage.Builder<?> builder) {
        super(builder);
    }

    private CoverResult() {
        this.covers_ = Collections.emptyList();
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return Igdbproto.internal_static_proto_CoverResult_descriptor;
    }

    @Override // com.google.protobuf.GeneratedMessage
    protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
        return Igdbproto.internal_static_proto_CoverResult_fieldAccessorTable.ensureFieldAccessorsInitialized(CoverResult.class, Builder.class);
    }

    @Override // proto.CoverResultOrBuilder
    public List<Cover> getCoversList() {
        return this.covers_;
    }

    @Override // proto.CoverResultOrBuilder
    public List<? extends CoverOrBuilder> getCoversOrBuilderList() {
        return this.covers_;
    }

    @Override // proto.CoverResultOrBuilder
    public int getCoversCount() {
        return this.covers_.size();
    }

    @Override // proto.CoverResultOrBuilder
    public Cover getCovers(int i) {
        return this.covers_.get(i);
    }

    @Override // proto.CoverResultOrBuilder
    public CoverOrBuilder getCoversOrBuilder(int i) {
        return this.covers_.get(i);
    }

    public static CoverResult parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer);
    }

    public static CoverResult parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    public static CoverResult parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString);
    }

    public static CoverResult parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static CoverResult parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr);
    }

    public static CoverResult parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr, extensionRegistryLite);
    }

    public static CoverResult parseFrom(InputStream inputStream) throws IOException {
        return (CoverResult) GeneratedMessage.parseWithIOException(PARSER, inputStream);
    }

    public static CoverResult parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (CoverResult) GeneratedMessage.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static CoverResult parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (CoverResult) GeneratedMessage.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static CoverResult parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (CoverResult) GeneratedMessage.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static CoverResult parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (CoverResult) GeneratedMessage.parseWithIOException(PARSER, codedInputStream);
    }

    public static CoverResult parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (CoverResult) GeneratedMessage.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder newBuilderForType() {
        return newBuilder();
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    /* WARN: Multi-variable type inference failed */
    public static Builder newBuilder(CoverResult coverResult) {
        return (Builder) DEFAULT_INSTANCE.toBuilder().mergeFrom((Message) coverResult);
    }

    /* WARN: Multi-variable type inference failed */
    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder toBuilder() {
        return this == DEFAULT_INSTANCE ? new Builder((CoverResultIA) null) : (Builder) new Builder((CoverResultIA) null).mergeFrom((Message) this);
    }

    /* INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.AbstractMessage
    public Builder newBuilderForType(AbstractMessage.BuilderParent builderParent) {
        return new Builder(builderParent, null);
    }

    public static final class Builder extends GeneratedMessage.Builder<Builder> implements CoverResultOrBuilder {
        private int bitField0_;
        private RepeatedFieldBuilder<Cover, Cover.Builder, CoverOrBuilder> coversBuilder_;
        private List<Cover> covers_;

        /* synthetic */ Builder(AbstractMessage.BuilderParent builderParent, CoverResultIA coverResultIA) {
            this(builderParent);
        }

        /* synthetic */ Builder(CoverResultIA coverResultIA) {
            this();
        }

        private void buildPartial0(CoverResult coverResult) {
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return Igdbproto.internal_static_proto_CoverResult_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder
        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return Igdbproto.internal_static_proto_CoverResult_fieldAccessorTable.ensureFieldAccessorsInitialized(CoverResult.class, Builder.class);
        }

        private Builder() {
            this.covers_ = Collections.emptyList();
        }

        private Builder(AbstractMessage.BuilderParent builderParent) {
            super(builderParent);
            this.covers_ = Collections.emptyList();
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder clear() {
            super.clear();
            this.bitField0_ = 0;
            RepeatedFieldBuilder<Cover, Cover.Builder, CoverOrBuilder> repeatedFieldBuilder = this.coversBuilder_;
            if (repeatedFieldBuilder == null) {
                this.covers_ = Collections.emptyList();
            } else {
                this.covers_ = null;
                repeatedFieldBuilder.clear();
            }
            this.bitField0_ &= -2;
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
        public Descriptors.Descriptor getDescriptorForType() {
            return Igdbproto.internal_static_proto_CoverResult_descriptor;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public CoverResult getDefaultInstanceForType() {
            return CoverResult.getDefaultInstance();
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public CoverResult build() {
            CoverResult coverResultBuildPartial = buildPartial();
            if (coverResultBuildPartial.isInitialized()) {
                return coverResultBuildPartial;
            }
            throw newUninitializedMessageException((Message) coverResultBuildPartial);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public CoverResult buildPartial() {
            CoverResult coverResult = new CoverResult(this, null);
            buildPartialRepeatedFields(coverResult);
            if (this.bitField0_ != 0) {
                buildPartial0(coverResult);
            }
            onBuilt();
            return coverResult;
        }

        private void buildPartialRepeatedFields(CoverResult coverResult) {
            RepeatedFieldBuilder<Cover, Cover.Builder, CoverOrBuilder> repeatedFieldBuilder = this.coversBuilder_;
            if (repeatedFieldBuilder == null) {
                if ((this.bitField0_ & 1) != 0) {
                    this.covers_ = Collections.unmodifiableList(this.covers_);
                    this.bitField0_ &= -2;
                }
                coverResult.covers_ = this.covers_;
                return;
            }
            coverResult.covers_ = repeatedFieldBuilder.build();
        }

        private void ensureCoversIsMutable() {
            if ((this.bitField0_ & 1) == 0) {
                this.covers_ = new ArrayList(this.covers_);
                this.bitField0_ |= 1;
            }
        }

        @Override // proto.CoverResultOrBuilder
        public List<Cover> getCoversList() {
            RepeatedFieldBuilder<Cover, Cover.Builder, CoverOrBuilder> repeatedFieldBuilder = this.coversBuilder_;
            if (repeatedFieldBuilder == null) {
                return Collections.unmodifiableList(this.covers_);
            }
            return repeatedFieldBuilder.getMessageList();
        }

        @Override // proto.CoverResultOrBuilder
        public int getCoversCount() {
            RepeatedFieldBuilder<Cover, Cover.Builder, CoverOrBuilder> repeatedFieldBuilder = this.coversBuilder_;
            if (repeatedFieldBuilder == null) {
                return this.covers_.size();
            }
            return repeatedFieldBuilder.getCount();
        }

        @Override // proto.CoverResultOrBuilder
        public Cover getCovers(int i) {
            RepeatedFieldBuilder<Cover, Cover.Builder, CoverOrBuilder> repeatedFieldBuilder = this.coversBuilder_;
            if (repeatedFieldBuilder == null) {
                return this.covers_.get(i);
            }
            return (Cover) repeatedFieldBuilder.getMessage(i);
        }

        public Builder setCovers(int i, Cover cover) {
            RepeatedFieldBuilder<Cover, Cover.Builder, CoverOrBuilder> repeatedFieldBuilder = this.coversBuilder_;
            if (repeatedFieldBuilder == null) {
                cover.getClass();
                ensureCoversIsMutable();
                this.covers_.set(i, cover);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.setMessage(i, cover);
            return this;
        }

        public Builder setCovers(int i, Cover.Builder builder) {
            RepeatedFieldBuilder<Cover, Cover.Builder, CoverOrBuilder> repeatedFieldBuilder = this.coversBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureCoversIsMutable();
                this.covers_.set(i, builder.build());
                onChanged();
                return this;
            }
            repeatedFieldBuilder.setMessage(i, builder.build());
            return this;
        }

        public Builder addCovers(Cover cover) {
            RepeatedFieldBuilder<Cover, Cover.Builder, CoverOrBuilder> repeatedFieldBuilder = this.coversBuilder_;
            if (repeatedFieldBuilder == null) {
                cover.getClass();
                ensureCoversIsMutable();
                this.covers_.add(cover);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(cover);
            return this;
        }

        public Builder addCovers(int i, Cover cover) {
            RepeatedFieldBuilder<Cover, Cover.Builder, CoverOrBuilder> repeatedFieldBuilder = this.coversBuilder_;
            if (repeatedFieldBuilder == null) {
                cover.getClass();
                ensureCoversIsMutable();
                this.covers_.add(i, cover);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(i, cover);
            return this;
        }

        public Builder addCovers(Cover.Builder builder) {
            RepeatedFieldBuilder<Cover, Cover.Builder, CoverOrBuilder> repeatedFieldBuilder = this.coversBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureCoversIsMutable();
                this.covers_.add(builder.build());
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(builder.build());
            return this;
        }

        public Builder addCovers(int i, Cover.Builder builder) {
            RepeatedFieldBuilder<Cover, Cover.Builder, CoverOrBuilder> repeatedFieldBuilder = this.coversBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureCoversIsMutable();
                this.covers_.add(i, builder.build());
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(i, builder.build());
            return this;
        }

        public Builder addAllCovers(Iterable<? extends Cover> iterable) {
            RepeatedFieldBuilder<Cover, Cover.Builder, CoverOrBuilder> repeatedFieldBuilder = this.coversBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureCoversIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) iterable, (List) this.covers_);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addAllMessages(iterable);
            return this;
        }

        public Builder clearCovers() {
            RepeatedFieldBuilder<Cover, Cover.Builder, CoverOrBuilder> repeatedFieldBuilder = this.coversBuilder_;
            if (repeatedFieldBuilder == null) {
                this.covers_ = Collections.emptyList();
                this.bitField0_ &= -2;
                onChanged();
                return this;
            }
            repeatedFieldBuilder.clear();
            return this;
        }

        public Builder removeCovers(int i) {
            RepeatedFieldBuilder<Cover, Cover.Builder, CoverOrBuilder> repeatedFieldBuilder = this.coversBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureCoversIsMutable();
                this.covers_.remove(i);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.remove(i);
            return this;
        }

        public Cover.Builder getCoversBuilder(int i) {
            return (Cover.Builder) getCoversFieldBuilder().getBuilder(i);
        }

        @Override // proto.CoverResultOrBuilder
        public CoverOrBuilder getCoversOrBuilder(int i) {
            RepeatedFieldBuilder<Cover, Cover.Builder, CoverOrBuilder> repeatedFieldBuilder = this.coversBuilder_;
            if (repeatedFieldBuilder == null) {
                return this.covers_.get(i);
            }
            return (CoverOrBuilder) repeatedFieldBuilder.getMessageOrBuilder(i);
        }

        @Override // proto.CoverResultOrBuilder
        public List<? extends CoverOrBuilder> getCoversOrBuilderList() {
            RepeatedFieldBuilder<Cover, Cover.Builder, CoverOrBuilder> repeatedFieldBuilder = this.coversBuilder_;
            if (repeatedFieldBuilder != null) {
                return repeatedFieldBuilder.getMessageOrBuilderList();
            }
            return Collections.unmodifiableList(this.covers_);
        }

        public Cover.Builder addCoversBuilder() {
            return (Cover.Builder) getCoversFieldBuilder().addBuilder(Cover.getDefaultInstance());
        }

        public Cover.Builder addCoversBuilder(int i) {
            return (Cover.Builder) getCoversFieldBuilder().addBuilder(i, Cover.getDefaultInstance());
        }

        public List<Cover.Builder> getCoversBuilderList() {
            return getCoversFieldBuilder().getBuilderList();
        }

        private RepeatedFieldBuilder<Cover, Cover.Builder, CoverOrBuilder> getCoversFieldBuilder() {
            if (this.coversBuilder_ == null) {
                this.coversBuilder_ = new RepeatedFieldBuilder<>(this.covers_, (this.bitField0_ & 1) != 0, getParentForChildren(), isClean());
                this.covers_ = null;
            }
            return this.coversBuilder_;
        }
    }

    public static CoverResult getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* INFO: renamed from: proto.CoverResult$1, reason: invalid class name */
    class AnonymousClass1 extends AbstractParser<CoverResult> {
        AnonymousClass1() {
        }

        @Override // com.google.protobuf.Parser
        public CoverResult parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            Builder builderNewBuilder = CoverResult.newBuilder();
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

    public static Parser<CoverResult> parser() {
        return PARSER;
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Parser<CoverResult> getParserForType() {
        return PARSER;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
    public CoverResult getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }
}
