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
public final class AgeRatingResult extends GeneratedMessage implements AgeRatingResultOrBuilder {
    public static final int AGERATINGS_FIELD_NUMBER = 1;
    private static final AgeRatingResult DEFAULT_INSTANCE;
    private static final Parser<AgeRatingResult> PARSER;
    private static final long serialVersionUID = 0;
    private List<AgeRating> ageratings_;

    /* synthetic */ AgeRatingResult(GeneratedMessage.Builder builder, AgeRatingResultIA ageRatingResultIA) {
        this(builder);
    }

    static {
        RuntimeVersion.validateProtobufGencodeVersion(RuntimeVersion.RuntimeDomain.PUBLIC, 4, 27, 2, "", AgeRatingResult.class.getName());
        DEFAULT_INSTANCE = new AgeRatingResult();
        PARSER = new AnonymousClass1();
    }

    private AgeRatingResult(GeneratedMessage.Builder<?> builder) {
        super(builder);
    }

    private AgeRatingResult() {
        this.ageratings_ = Collections.emptyList();
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return Igdbproto.internal_static_proto_AgeRatingResult_descriptor;
    }

    @Override // com.google.protobuf.GeneratedMessage
    protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
        return Igdbproto.internal_static_proto_AgeRatingResult_fieldAccessorTable.ensureFieldAccessorsInitialized(AgeRatingResult.class, Builder.class);
    }

    @Override // proto.AgeRatingResultOrBuilder
    public List<AgeRating> getAgeratingsList() {
        return this.ageratings_;
    }

    @Override // proto.AgeRatingResultOrBuilder
    public List<? extends AgeRatingOrBuilder> getAgeratingsOrBuilderList() {
        return this.ageratings_;
    }

    @Override // proto.AgeRatingResultOrBuilder
    public int getAgeratingsCount() {
        return this.ageratings_.size();
    }

    @Override // proto.AgeRatingResultOrBuilder
    public AgeRating getAgeratings(int i) {
        return this.ageratings_.get(i);
    }

    @Override // proto.AgeRatingResultOrBuilder
    public AgeRatingOrBuilder getAgeratingsOrBuilder(int i) {
        return this.ageratings_.get(i);
    }

    public static AgeRatingResult parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer);
    }

    public static AgeRatingResult parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    public static AgeRatingResult parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString);
    }

    public static AgeRatingResult parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static AgeRatingResult parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr);
    }

    public static AgeRatingResult parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr, extensionRegistryLite);
    }

    public static AgeRatingResult parseFrom(InputStream inputStream) throws IOException {
        return (AgeRatingResult) GeneratedMessage.parseWithIOException(PARSER, inputStream);
    }

    public static AgeRatingResult parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (AgeRatingResult) GeneratedMessage.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static AgeRatingResult parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (AgeRatingResult) GeneratedMessage.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static AgeRatingResult parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (AgeRatingResult) GeneratedMessage.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static AgeRatingResult parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (AgeRatingResult) GeneratedMessage.parseWithIOException(PARSER, codedInputStream);
    }

    public static AgeRatingResult parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (AgeRatingResult) GeneratedMessage.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder newBuilderForType() {
        return newBuilder();
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    /* WARN: Multi-variable type inference failed */
    public static Builder newBuilder(AgeRatingResult ageRatingResult) {
        return (Builder) DEFAULT_INSTANCE.toBuilder().mergeFrom((Message) ageRatingResult);
    }

    /* WARN: Multi-variable type inference failed */
    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder toBuilder() {
        return this == DEFAULT_INSTANCE ? new Builder((AgeRatingResultIA) null) : (Builder) new Builder((AgeRatingResultIA) null).mergeFrom((Message) this);
    }

    /* INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.AbstractMessage
    public Builder newBuilderForType(AbstractMessage.BuilderParent builderParent) {
        return new Builder(builderParent, null);
    }

    public static final class Builder extends GeneratedMessage.Builder<Builder> implements AgeRatingResultOrBuilder {
        private RepeatedFieldBuilder<AgeRating, AgeRating.Builder, AgeRatingOrBuilder> ageratingsBuilder_;
        private List<AgeRating> ageratings_;
        private int bitField0_;

        /* synthetic */ Builder(AbstractMessage.BuilderParent builderParent, AgeRatingResultIA ageRatingResultIA) {
            this(builderParent);
        }

        /* synthetic */ Builder(AgeRatingResultIA ageRatingResultIA) {
            this();
        }

        private void buildPartial0(AgeRatingResult ageRatingResult) {
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return Igdbproto.internal_static_proto_AgeRatingResult_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder
        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return Igdbproto.internal_static_proto_AgeRatingResult_fieldAccessorTable.ensureFieldAccessorsInitialized(AgeRatingResult.class, Builder.class);
        }

        private Builder() {
            this.ageratings_ = Collections.emptyList();
        }

        private Builder(AbstractMessage.BuilderParent builderParent) {
            super(builderParent);
            this.ageratings_ = Collections.emptyList();
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder clear() {
            super.clear();
            this.bitField0_ = 0;
            RepeatedFieldBuilder<AgeRating, AgeRating.Builder, AgeRatingOrBuilder> repeatedFieldBuilder = this.ageratingsBuilder_;
            if (repeatedFieldBuilder == null) {
                this.ageratings_ = Collections.emptyList();
            } else {
                this.ageratings_ = null;
                repeatedFieldBuilder.clear();
            }
            this.bitField0_ &= -2;
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
        public Descriptors.Descriptor getDescriptorForType() {
            return Igdbproto.internal_static_proto_AgeRatingResult_descriptor;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public AgeRatingResult getDefaultInstanceForType() {
            return AgeRatingResult.getDefaultInstance();
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public AgeRatingResult build() {
            AgeRatingResult ageRatingResultBuildPartial = buildPartial();
            if (ageRatingResultBuildPartial.isInitialized()) {
                return ageRatingResultBuildPartial;
            }
            throw newUninitializedMessageException((Message) ageRatingResultBuildPartial);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public AgeRatingResult buildPartial() {
            AgeRatingResult ageRatingResult = new AgeRatingResult(this, null);
            buildPartialRepeatedFields(ageRatingResult);
            if (this.bitField0_ != 0) {
                buildPartial0(ageRatingResult);
            }
            onBuilt();
            return ageRatingResult;
        }

        private void buildPartialRepeatedFields(AgeRatingResult ageRatingResult) {
            RepeatedFieldBuilder<AgeRating, AgeRating.Builder, AgeRatingOrBuilder> repeatedFieldBuilder = this.ageratingsBuilder_;
            if (repeatedFieldBuilder == null) {
                if ((this.bitField0_ & 1) != 0) {
                    this.ageratings_ = Collections.unmodifiableList(this.ageratings_);
                    this.bitField0_ &= -2;
                }
                ageRatingResult.ageratings_ = this.ageratings_;
                return;
            }
            ageRatingResult.ageratings_ = repeatedFieldBuilder.build();
        }

        private void ensureAgeratingsIsMutable() {
            if ((this.bitField0_ & 1) == 0) {
                this.ageratings_ = new ArrayList(this.ageratings_);
                this.bitField0_ |= 1;
            }
        }

        @Override // proto.AgeRatingResultOrBuilder
        public List<AgeRating> getAgeratingsList() {
            RepeatedFieldBuilder<AgeRating, AgeRating.Builder, AgeRatingOrBuilder> repeatedFieldBuilder = this.ageratingsBuilder_;
            if (repeatedFieldBuilder == null) {
                return Collections.unmodifiableList(this.ageratings_);
            }
            return repeatedFieldBuilder.getMessageList();
        }

        @Override // proto.AgeRatingResultOrBuilder
        public int getAgeratingsCount() {
            RepeatedFieldBuilder<AgeRating, AgeRating.Builder, AgeRatingOrBuilder> repeatedFieldBuilder = this.ageratingsBuilder_;
            if (repeatedFieldBuilder == null) {
                return this.ageratings_.size();
            }
            return repeatedFieldBuilder.getCount();
        }

        @Override // proto.AgeRatingResultOrBuilder
        public AgeRating getAgeratings(int i) {
            RepeatedFieldBuilder<AgeRating, AgeRating.Builder, AgeRatingOrBuilder> repeatedFieldBuilder = this.ageratingsBuilder_;
            if (repeatedFieldBuilder == null) {
                return this.ageratings_.get(i);
            }
            return (AgeRating) repeatedFieldBuilder.getMessage(i);
        }

        public Builder setAgeratings(int i, AgeRating ageRating) {
            RepeatedFieldBuilder<AgeRating, AgeRating.Builder, AgeRatingOrBuilder> repeatedFieldBuilder = this.ageratingsBuilder_;
            if (repeatedFieldBuilder == null) {
                ageRating.getClass();
                ensureAgeratingsIsMutable();
                this.ageratings_.set(i, ageRating);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.setMessage(i, ageRating);
            return this;
        }

        public Builder setAgeratings(int i, AgeRating.Builder builder) {
            RepeatedFieldBuilder<AgeRating, AgeRating.Builder, AgeRatingOrBuilder> repeatedFieldBuilder = this.ageratingsBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureAgeratingsIsMutable();
                this.ageratings_.set(i, builder.build());
                onChanged();
                return this;
            }
            repeatedFieldBuilder.setMessage(i, builder.build());
            return this;
        }

        public Builder addAgeratings(AgeRating ageRating) {
            RepeatedFieldBuilder<AgeRating, AgeRating.Builder, AgeRatingOrBuilder> repeatedFieldBuilder = this.ageratingsBuilder_;
            if (repeatedFieldBuilder == null) {
                ageRating.getClass();
                ensureAgeratingsIsMutable();
                this.ageratings_.add(ageRating);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(ageRating);
            return this;
        }

        public Builder addAgeratings(int i, AgeRating ageRating) {
            RepeatedFieldBuilder<AgeRating, AgeRating.Builder, AgeRatingOrBuilder> repeatedFieldBuilder = this.ageratingsBuilder_;
            if (repeatedFieldBuilder == null) {
                ageRating.getClass();
                ensureAgeratingsIsMutable();
                this.ageratings_.add(i, ageRating);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(i, ageRating);
            return this;
        }

        public Builder addAgeratings(AgeRating.Builder builder) {
            RepeatedFieldBuilder<AgeRating, AgeRating.Builder, AgeRatingOrBuilder> repeatedFieldBuilder = this.ageratingsBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureAgeratingsIsMutable();
                this.ageratings_.add(builder.build());
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(builder.build());
            return this;
        }

        public Builder addAgeratings(int i, AgeRating.Builder builder) {
            RepeatedFieldBuilder<AgeRating, AgeRating.Builder, AgeRatingOrBuilder> repeatedFieldBuilder = this.ageratingsBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureAgeratingsIsMutable();
                this.ageratings_.add(i, builder.build());
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(i, builder.build());
            return this;
        }

        public Builder addAllAgeratings(Iterable<? extends AgeRating> iterable) {
            RepeatedFieldBuilder<AgeRating, AgeRating.Builder, AgeRatingOrBuilder> repeatedFieldBuilder = this.ageratingsBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureAgeratingsIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) iterable, (List) this.ageratings_);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addAllMessages(iterable);
            return this;
        }

        public Builder clearAgeratings() {
            RepeatedFieldBuilder<AgeRating, AgeRating.Builder, AgeRatingOrBuilder> repeatedFieldBuilder = this.ageratingsBuilder_;
            if (repeatedFieldBuilder == null) {
                this.ageratings_ = Collections.emptyList();
                this.bitField0_ &= -2;
                onChanged();
                return this;
            }
            repeatedFieldBuilder.clear();
            return this;
        }

        public Builder removeAgeratings(int i) {
            RepeatedFieldBuilder<AgeRating, AgeRating.Builder, AgeRatingOrBuilder> repeatedFieldBuilder = this.ageratingsBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureAgeratingsIsMutable();
                this.ageratings_.remove(i);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.remove(i);
            return this;
        }

        public AgeRating.Builder getAgeratingsBuilder(int i) {
            return (AgeRating.Builder) getAgeratingsFieldBuilder().getBuilder(i);
        }

        @Override // proto.AgeRatingResultOrBuilder
        public AgeRatingOrBuilder getAgeratingsOrBuilder(int i) {
            RepeatedFieldBuilder<AgeRating, AgeRating.Builder, AgeRatingOrBuilder> repeatedFieldBuilder = this.ageratingsBuilder_;
            if (repeatedFieldBuilder == null) {
                return this.ageratings_.get(i);
            }
            return (AgeRatingOrBuilder) repeatedFieldBuilder.getMessageOrBuilder(i);
        }

        @Override // proto.AgeRatingResultOrBuilder
        public List<? extends AgeRatingOrBuilder> getAgeratingsOrBuilderList() {
            RepeatedFieldBuilder<AgeRating, AgeRating.Builder, AgeRatingOrBuilder> repeatedFieldBuilder = this.ageratingsBuilder_;
            if (repeatedFieldBuilder != null) {
                return repeatedFieldBuilder.getMessageOrBuilderList();
            }
            return Collections.unmodifiableList(this.ageratings_);
        }

        public AgeRating.Builder addAgeratingsBuilder() {
            return (AgeRating.Builder) getAgeratingsFieldBuilder().addBuilder(AgeRating.getDefaultInstance());
        }

        public AgeRating.Builder addAgeratingsBuilder(int i) {
            return (AgeRating.Builder) getAgeratingsFieldBuilder().addBuilder(i, AgeRating.getDefaultInstance());
        }

        public List<AgeRating.Builder> getAgeratingsBuilderList() {
            return getAgeratingsFieldBuilder().getBuilderList();
        }

        private RepeatedFieldBuilder<AgeRating, AgeRating.Builder, AgeRatingOrBuilder> getAgeratingsFieldBuilder() {
            if (this.ageratingsBuilder_ == null) {
                this.ageratingsBuilder_ = new RepeatedFieldBuilder<>(this.ageratings_, (this.bitField0_ & 1) != 0, getParentForChildren(), isClean());
                this.ageratings_ = null;
            }
            return this.ageratingsBuilder_;
        }
    }

    public static AgeRatingResult getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* INFO: renamed from: proto.AgeRatingResult$1, reason: invalid class name */
    class AnonymousClass1 extends AbstractParser<AgeRatingResult> {
        AnonymousClass1() {
        }

        @Override // com.google.protobuf.Parser
        public AgeRatingResult parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            Builder builderNewBuilder = AgeRatingResult.newBuilder();
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

    public static Parser<AgeRatingResult> parser() {
        return PARSER;
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Parser<AgeRatingResult> getParserForType() {
        return PARSER;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
    public AgeRatingResult getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }
}
