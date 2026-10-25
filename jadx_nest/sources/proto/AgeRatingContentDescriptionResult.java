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
public final class AgeRatingContentDescriptionResult extends GeneratedMessage implements AgeRatingContentDescriptionResultOrBuilder {
    public static final int AGERATINGCONTENTDESCRIPTIONS_FIELD_NUMBER = 1;
    private static final AgeRatingContentDescriptionResult DEFAULT_INSTANCE;
    private static final Parser<AgeRatingContentDescriptionResult> PARSER;
    private static final long serialVersionUID = 0;
    private List<AgeRatingContentDescription> ageratingcontentdescriptions_;

    /* synthetic */ AgeRatingContentDescriptionResult(GeneratedMessage.Builder builder, AgeRatingContentDescriptionResultIA ageRatingContentDescriptionResultIA) {
        this(builder);
    }

    static {
        RuntimeVersion.validateProtobufGencodeVersion(RuntimeVersion.RuntimeDomain.PUBLIC, 4, 27, 2, "", AgeRatingContentDescriptionResult.class.getName());
        DEFAULT_INSTANCE = new AgeRatingContentDescriptionResult();
        PARSER = new AnonymousClass1();
    }

    private AgeRatingContentDescriptionResult(GeneratedMessage.Builder<?> builder) {
        super(builder);
    }

    private AgeRatingContentDescriptionResult() {
        this.ageratingcontentdescriptions_ = Collections.emptyList();
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return Igdbproto.internal_static_proto_AgeRatingContentDescriptionResult_descriptor;
    }

    @Override // com.google.protobuf.GeneratedMessage
    protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
        return Igdbproto.internal_static_proto_AgeRatingContentDescriptionResult_fieldAccessorTable.ensureFieldAccessorsInitialized(AgeRatingContentDescriptionResult.class, Builder.class);
    }

    @Override // proto.AgeRatingContentDescriptionResultOrBuilder
    public List<AgeRatingContentDescription> getAgeratingcontentdescriptionsList() {
        return this.ageratingcontentdescriptions_;
    }

    @Override // proto.AgeRatingContentDescriptionResultOrBuilder
    public List<? extends AgeRatingContentDescriptionOrBuilder> getAgeratingcontentdescriptionsOrBuilderList() {
        return this.ageratingcontentdescriptions_;
    }

    @Override // proto.AgeRatingContentDescriptionResultOrBuilder
    public int getAgeratingcontentdescriptionsCount() {
        return this.ageratingcontentdescriptions_.size();
    }

    @Override // proto.AgeRatingContentDescriptionResultOrBuilder
    public AgeRatingContentDescription getAgeratingcontentdescriptions(int i) {
        return this.ageratingcontentdescriptions_.get(i);
    }

    @Override // proto.AgeRatingContentDescriptionResultOrBuilder
    public AgeRatingContentDescriptionOrBuilder getAgeratingcontentdescriptionsOrBuilder(int i) {
        return this.ageratingcontentdescriptions_.get(i);
    }

    public static AgeRatingContentDescriptionResult parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer);
    }

    public static AgeRatingContentDescriptionResult parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    public static AgeRatingContentDescriptionResult parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString);
    }

    public static AgeRatingContentDescriptionResult parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static AgeRatingContentDescriptionResult parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr);
    }

    public static AgeRatingContentDescriptionResult parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr, extensionRegistryLite);
    }

    public static AgeRatingContentDescriptionResult parseFrom(InputStream inputStream) throws IOException {
        return (AgeRatingContentDescriptionResult) GeneratedMessage.parseWithIOException(PARSER, inputStream);
    }

    public static AgeRatingContentDescriptionResult parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (AgeRatingContentDescriptionResult) GeneratedMessage.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static AgeRatingContentDescriptionResult parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (AgeRatingContentDescriptionResult) GeneratedMessage.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static AgeRatingContentDescriptionResult parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (AgeRatingContentDescriptionResult) GeneratedMessage.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static AgeRatingContentDescriptionResult parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (AgeRatingContentDescriptionResult) GeneratedMessage.parseWithIOException(PARSER, codedInputStream);
    }

    public static AgeRatingContentDescriptionResult parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (AgeRatingContentDescriptionResult) GeneratedMessage.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder newBuilderForType() {
        return newBuilder();
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static Builder newBuilder(AgeRatingContentDescriptionResult ageRatingContentDescriptionResult) {
        return (Builder) DEFAULT_INSTANCE.toBuilder().mergeFrom((Message) ageRatingContentDescriptionResult);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder toBuilder() {
        return this == DEFAULT_INSTANCE ? new Builder((AgeRatingContentDescriptionResultIA) null) : (Builder) new Builder((AgeRatingContentDescriptionResultIA) null).mergeFrom((Message) this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.AbstractMessage
    public Builder newBuilderForType(AbstractMessage.BuilderParent builderParent) {
        return new Builder(builderParent, null);
    }

    public static final class Builder extends GeneratedMessage.Builder<Builder> implements AgeRatingContentDescriptionResultOrBuilder {
        private RepeatedFieldBuilder<AgeRatingContentDescription, AgeRatingContentDescription.Builder, AgeRatingContentDescriptionOrBuilder> ageratingcontentdescriptionsBuilder_;
        private List<AgeRatingContentDescription> ageratingcontentdescriptions_;
        private int bitField0_;

        /* synthetic */ Builder(AbstractMessage.BuilderParent builderParent, AgeRatingContentDescriptionResultIA ageRatingContentDescriptionResultIA) {
            this(builderParent);
        }

        /* synthetic */ Builder(AgeRatingContentDescriptionResultIA ageRatingContentDescriptionResultIA) {
            this();
        }

        private void buildPartial0(AgeRatingContentDescriptionResult ageRatingContentDescriptionResult) {
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return Igdbproto.internal_static_proto_AgeRatingContentDescriptionResult_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder
        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return Igdbproto.internal_static_proto_AgeRatingContentDescriptionResult_fieldAccessorTable.ensureFieldAccessorsInitialized(AgeRatingContentDescriptionResult.class, Builder.class);
        }

        private Builder() {
            this.ageratingcontentdescriptions_ = Collections.emptyList();
        }

        private Builder(AbstractMessage.BuilderParent builderParent) {
            super(builderParent);
            this.ageratingcontentdescriptions_ = Collections.emptyList();
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder clear() {
            super.clear();
            this.bitField0_ = 0;
            RepeatedFieldBuilder<AgeRatingContentDescription, AgeRatingContentDescription.Builder, AgeRatingContentDescriptionOrBuilder> repeatedFieldBuilder = this.ageratingcontentdescriptionsBuilder_;
            if (repeatedFieldBuilder == null) {
                this.ageratingcontentdescriptions_ = Collections.emptyList();
            } else {
                this.ageratingcontentdescriptions_ = null;
                repeatedFieldBuilder.clear();
            }
            this.bitField0_ &= -2;
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
        public Descriptors.Descriptor getDescriptorForType() {
            return Igdbproto.internal_static_proto_AgeRatingContentDescriptionResult_descriptor;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public AgeRatingContentDescriptionResult getDefaultInstanceForType() {
            return AgeRatingContentDescriptionResult.getDefaultInstance();
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public AgeRatingContentDescriptionResult build() {
            AgeRatingContentDescriptionResult ageRatingContentDescriptionResultBuildPartial = buildPartial();
            if (ageRatingContentDescriptionResultBuildPartial.isInitialized()) {
                return ageRatingContentDescriptionResultBuildPartial;
            }
            throw newUninitializedMessageException((Message) ageRatingContentDescriptionResultBuildPartial);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public AgeRatingContentDescriptionResult buildPartial() {
            AgeRatingContentDescriptionResult ageRatingContentDescriptionResult = new AgeRatingContentDescriptionResult(this, null);
            buildPartialRepeatedFields(ageRatingContentDescriptionResult);
            if (this.bitField0_ != 0) {
                buildPartial0(ageRatingContentDescriptionResult);
            }
            onBuilt();
            return ageRatingContentDescriptionResult;
        }

        private void buildPartialRepeatedFields(AgeRatingContentDescriptionResult ageRatingContentDescriptionResult) {
            RepeatedFieldBuilder<AgeRatingContentDescription, AgeRatingContentDescription.Builder, AgeRatingContentDescriptionOrBuilder> repeatedFieldBuilder = this.ageratingcontentdescriptionsBuilder_;
            if (repeatedFieldBuilder == null) {
                if ((this.bitField0_ & 1) != 0) {
                    this.ageratingcontentdescriptions_ = Collections.unmodifiableList(this.ageratingcontentdescriptions_);
                    this.bitField0_ &= -2;
                }
                ageRatingContentDescriptionResult.ageratingcontentdescriptions_ = this.ageratingcontentdescriptions_;
                return;
            }
            ageRatingContentDescriptionResult.ageratingcontentdescriptions_ = repeatedFieldBuilder.build();
        }

        private void ensureAgeratingcontentdescriptionsIsMutable() {
            if ((this.bitField0_ & 1) == 0) {
                this.ageratingcontentdescriptions_ = new ArrayList(this.ageratingcontentdescriptions_);
                this.bitField0_ |= 1;
            }
        }

        @Override // proto.AgeRatingContentDescriptionResultOrBuilder
        public List<AgeRatingContentDescription> getAgeratingcontentdescriptionsList() {
            RepeatedFieldBuilder<AgeRatingContentDescription, AgeRatingContentDescription.Builder, AgeRatingContentDescriptionOrBuilder> repeatedFieldBuilder = this.ageratingcontentdescriptionsBuilder_;
            if (repeatedFieldBuilder == null) {
                return Collections.unmodifiableList(this.ageratingcontentdescriptions_);
            }
            return repeatedFieldBuilder.getMessageList();
        }

        @Override // proto.AgeRatingContentDescriptionResultOrBuilder
        public int getAgeratingcontentdescriptionsCount() {
            RepeatedFieldBuilder<AgeRatingContentDescription, AgeRatingContentDescription.Builder, AgeRatingContentDescriptionOrBuilder> repeatedFieldBuilder = this.ageratingcontentdescriptionsBuilder_;
            if (repeatedFieldBuilder == null) {
                return this.ageratingcontentdescriptions_.size();
            }
            return repeatedFieldBuilder.getCount();
        }

        @Override // proto.AgeRatingContentDescriptionResultOrBuilder
        public AgeRatingContentDescription getAgeratingcontentdescriptions(int i) {
            RepeatedFieldBuilder<AgeRatingContentDescription, AgeRatingContentDescription.Builder, AgeRatingContentDescriptionOrBuilder> repeatedFieldBuilder = this.ageratingcontentdescriptionsBuilder_;
            if (repeatedFieldBuilder == null) {
                return this.ageratingcontentdescriptions_.get(i);
            }
            return (AgeRatingContentDescription) repeatedFieldBuilder.getMessage(i);
        }

        public Builder setAgeratingcontentdescriptions(int i, AgeRatingContentDescription ageRatingContentDescription) {
            RepeatedFieldBuilder<AgeRatingContentDescription, AgeRatingContentDescription.Builder, AgeRatingContentDescriptionOrBuilder> repeatedFieldBuilder = this.ageratingcontentdescriptionsBuilder_;
            if (repeatedFieldBuilder == null) {
                ageRatingContentDescription.getClass();
                ensureAgeratingcontentdescriptionsIsMutable();
                this.ageratingcontentdescriptions_.set(i, ageRatingContentDescription);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.setMessage(i, ageRatingContentDescription);
            return this;
        }

        public Builder setAgeratingcontentdescriptions(int i, AgeRatingContentDescription.Builder builder) {
            RepeatedFieldBuilder<AgeRatingContentDescription, AgeRatingContentDescription.Builder, AgeRatingContentDescriptionOrBuilder> repeatedFieldBuilder = this.ageratingcontentdescriptionsBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureAgeratingcontentdescriptionsIsMutable();
                this.ageratingcontentdescriptions_.set(i, builder.build());
                onChanged();
                return this;
            }
            repeatedFieldBuilder.setMessage(i, builder.build());
            return this;
        }

        public Builder addAgeratingcontentdescriptions(AgeRatingContentDescription ageRatingContentDescription) {
            RepeatedFieldBuilder<AgeRatingContentDescription, AgeRatingContentDescription.Builder, AgeRatingContentDescriptionOrBuilder> repeatedFieldBuilder = this.ageratingcontentdescriptionsBuilder_;
            if (repeatedFieldBuilder == null) {
                ageRatingContentDescription.getClass();
                ensureAgeratingcontentdescriptionsIsMutable();
                this.ageratingcontentdescriptions_.add(ageRatingContentDescription);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(ageRatingContentDescription);
            return this;
        }

        public Builder addAgeratingcontentdescriptions(int i, AgeRatingContentDescription ageRatingContentDescription) {
            RepeatedFieldBuilder<AgeRatingContentDescription, AgeRatingContentDescription.Builder, AgeRatingContentDescriptionOrBuilder> repeatedFieldBuilder = this.ageratingcontentdescriptionsBuilder_;
            if (repeatedFieldBuilder == null) {
                ageRatingContentDescription.getClass();
                ensureAgeratingcontentdescriptionsIsMutable();
                this.ageratingcontentdescriptions_.add(i, ageRatingContentDescription);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(i, ageRatingContentDescription);
            return this;
        }

        public Builder addAgeratingcontentdescriptions(AgeRatingContentDescription.Builder builder) {
            RepeatedFieldBuilder<AgeRatingContentDescription, AgeRatingContentDescription.Builder, AgeRatingContentDescriptionOrBuilder> repeatedFieldBuilder = this.ageratingcontentdescriptionsBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureAgeratingcontentdescriptionsIsMutable();
                this.ageratingcontentdescriptions_.add(builder.build());
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(builder.build());
            return this;
        }

        public Builder addAgeratingcontentdescriptions(int i, AgeRatingContentDescription.Builder builder) {
            RepeatedFieldBuilder<AgeRatingContentDescription, AgeRatingContentDescription.Builder, AgeRatingContentDescriptionOrBuilder> repeatedFieldBuilder = this.ageratingcontentdescriptionsBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureAgeratingcontentdescriptionsIsMutable();
                this.ageratingcontentdescriptions_.add(i, builder.build());
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(i, builder.build());
            return this;
        }

        public Builder addAllAgeratingcontentdescriptions(Iterable<? extends AgeRatingContentDescription> iterable) {
            RepeatedFieldBuilder<AgeRatingContentDescription, AgeRatingContentDescription.Builder, AgeRatingContentDescriptionOrBuilder> repeatedFieldBuilder = this.ageratingcontentdescriptionsBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureAgeratingcontentdescriptionsIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) iterable, (List) this.ageratingcontentdescriptions_);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addAllMessages(iterable);
            return this;
        }

        public Builder clearAgeratingcontentdescriptions() {
            RepeatedFieldBuilder<AgeRatingContentDescription, AgeRatingContentDescription.Builder, AgeRatingContentDescriptionOrBuilder> repeatedFieldBuilder = this.ageratingcontentdescriptionsBuilder_;
            if (repeatedFieldBuilder == null) {
                this.ageratingcontentdescriptions_ = Collections.emptyList();
                this.bitField0_ &= -2;
                onChanged();
                return this;
            }
            repeatedFieldBuilder.clear();
            return this;
        }

        public Builder removeAgeratingcontentdescriptions(int i) {
            RepeatedFieldBuilder<AgeRatingContentDescription, AgeRatingContentDescription.Builder, AgeRatingContentDescriptionOrBuilder> repeatedFieldBuilder = this.ageratingcontentdescriptionsBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureAgeratingcontentdescriptionsIsMutable();
                this.ageratingcontentdescriptions_.remove(i);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.remove(i);
            return this;
        }

        public AgeRatingContentDescription.Builder getAgeratingcontentdescriptionsBuilder(int i) {
            return (AgeRatingContentDescription.Builder) getAgeratingcontentdescriptionsFieldBuilder().getBuilder(i);
        }

        @Override // proto.AgeRatingContentDescriptionResultOrBuilder
        public AgeRatingContentDescriptionOrBuilder getAgeratingcontentdescriptionsOrBuilder(int i) {
            RepeatedFieldBuilder<AgeRatingContentDescription, AgeRatingContentDescription.Builder, AgeRatingContentDescriptionOrBuilder> repeatedFieldBuilder = this.ageratingcontentdescriptionsBuilder_;
            if (repeatedFieldBuilder == null) {
                return this.ageratingcontentdescriptions_.get(i);
            }
            return (AgeRatingContentDescriptionOrBuilder) repeatedFieldBuilder.getMessageOrBuilder(i);
        }

        @Override // proto.AgeRatingContentDescriptionResultOrBuilder
        public List<? extends AgeRatingContentDescriptionOrBuilder> getAgeratingcontentdescriptionsOrBuilderList() {
            RepeatedFieldBuilder<AgeRatingContentDescription, AgeRatingContentDescription.Builder, AgeRatingContentDescriptionOrBuilder> repeatedFieldBuilder = this.ageratingcontentdescriptionsBuilder_;
            if (repeatedFieldBuilder != null) {
                return repeatedFieldBuilder.getMessageOrBuilderList();
            }
            return Collections.unmodifiableList(this.ageratingcontentdescriptions_);
        }

        public AgeRatingContentDescription.Builder addAgeratingcontentdescriptionsBuilder() {
            return (AgeRatingContentDescription.Builder) getAgeratingcontentdescriptionsFieldBuilder().addBuilder(AgeRatingContentDescription.getDefaultInstance());
        }

        public AgeRatingContentDescription.Builder addAgeratingcontentdescriptionsBuilder(int i) {
            return (AgeRatingContentDescription.Builder) getAgeratingcontentdescriptionsFieldBuilder().addBuilder(i, AgeRatingContentDescription.getDefaultInstance());
        }

        public List<AgeRatingContentDescription.Builder> getAgeratingcontentdescriptionsBuilderList() {
            return getAgeratingcontentdescriptionsFieldBuilder().getBuilderList();
        }

        private RepeatedFieldBuilder<AgeRatingContentDescription, AgeRatingContentDescription.Builder, AgeRatingContentDescriptionOrBuilder> getAgeratingcontentdescriptionsFieldBuilder() {
            if (this.ageratingcontentdescriptionsBuilder_ == null) {
                this.ageratingcontentdescriptionsBuilder_ = new RepeatedFieldBuilder<>(this.ageratingcontentdescriptions_, (this.bitField0_ & 1) != 0, getParentForChildren(), isClean());
                this.ageratingcontentdescriptions_ = null;
            }
            return this.ageratingcontentdescriptionsBuilder_;
        }
    }

    public static AgeRatingContentDescriptionResult getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* JADX INFO: renamed from: proto.AgeRatingContentDescriptionResult$1, reason: invalid class name */
    class AnonymousClass1 extends AbstractParser<AgeRatingContentDescriptionResult> {
        AnonymousClass1() {
        }

        @Override // com.google.protobuf.Parser
        public AgeRatingContentDescriptionResult parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            Builder builderNewBuilder = AgeRatingContentDescriptionResult.newBuilder();
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

    public static Parser<AgeRatingContentDescriptionResult> parser() {
        return PARSER;
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Parser<AgeRatingContentDescriptionResult> getParserForType() {
        return PARSER;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
    public AgeRatingContentDescriptionResult getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }
}
