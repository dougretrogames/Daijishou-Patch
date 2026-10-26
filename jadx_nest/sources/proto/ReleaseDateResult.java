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
public final class ReleaseDateResult extends GeneratedMessage implements ReleaseDateResultOrBuilder {
    private static final ReleaseDateResult DEFAULT_INSTANCE;
    private static final Parser<ReleaseDateResult> PARSER;
    public static final int RELEASEDATES_FIELD_NUMBER = 1;
    private static final long serialVersionUID = 0;
    private List<ReleaseDate> releasedates_;

    /* synthetic */ ReleaseDateResult(GeneratedMessage.Builder builder, ReleaseDateResultIA releaseDateResultIA) {
        this(builder);
    }

    static {
        RuntimeVersion.validateProtobufGencodeVersion(RuntimeVersion.RuntimeDomain.PUBLIC, 4, 27, 2, "", ReleaseDateResult.class.getName());
        DEFAULT_INSTANCE = new ReleaseDateResult();
        PARSER = new AnonymousClass1();
    }

    private ReleaseDateResult(GeneratedMessage.Builder<?> builder) {
        super(builder);
    }

    private ReleaseDateResult() {
        this.releasedates_ = Collections.emptyList();
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return Igdbproto.internal_static_proto_ReleaseDateResult_descriptor;
    }

    @Override // com.google.protobuf.GeneratedMessage
    protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
        return Igdbproto.internal_static_proto_ReleaseDateResult_fieldAccessorTable.ensureFieldAccessorsInitialized(ReleaseDateResult.class, Builder.class);
    }

    @Override // proto.ReleaseDateResultOrBuilder
    public List<ReleaseDate> getReleasedatesList() {
        return this.releasedates_;
    }

    @Override // proto.ReleaseDateResultOrBuilder
    public List<? extends ReleaseDateOrBuilder> getReleasedatesOrBuilderList() {
        return this.releasedates_;
    }

    @Override // proto.ReleaseDateResultOrBuilder
    public int getReleasedatesCount() {
        return this.releasedates_.size();
    }

    @Override // proto.ReleaseDateResultOrBuilder
    public ReleaseDate getReleasedates(int i) {
        return this.releasedates_.get(i);
    }

    @Override // proto.ReleaseDateResultOrBuilder
    public ReleaseDateOrBuilder getReleasedatesOrBuilder(int i) {
        return this.releasedates_.get(i);
    }

    public static ReleaseDateResult parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer);
    }

    public static ReleaseDateResult parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    public static ReleaseDateResult parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString);
    }

    public static ReleaseDateResult parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static ReleaseDateResult parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr);
    }

    public static ReleaseDateResult parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr, extensionRegistryLite);
    }

    public static ReleaseDateResult parseFrom(InputStream inputStream) throws IOException {
        return (ReleaseDateResult) GeneratedMessage.parseWithIOException(PARSER, inputStream);
    }

    public static ReleaseDateResult parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (ReleaseDateResult) GeneratedMessage.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static ReleaseDateResult parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (ReleaseDateResult) GeneratedMessage.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static ReleaseDateResult parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (ReleaseDateResult) GeneratedMessage.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static ReleaseDateResult parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (ReleaseDateResult) GeneratedMessage.parseWithIOException(PARSER, codedInputStream);
    }

    public static ReleaseDateResult parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (ReleaseDateResult) GeneratedMessage.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder newBuilderForType() {
        return newBuilder();
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    /* WARN: Multi-variable type inference failed */
    public static Builder newBuilder(ReleaseDateResult releaseDateResult) {
        return (Builder) DEFAULT_INSTANCE.toBuilder().mergeFrom((Message) releaseDateResult);
    }

    /* WARN: Multi-variable type inference failed */
    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder toBuilder() {
        return this == DEFAULT_INSTANCE ? new Builder((ReleaseDateResultIA) null) : (Builder) new Builder((ReleaseDateResultIA) null).mergeFrom((Message) this);
    }

    /* INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.AbstractMessage
    public Builder newBuilderForType(AbstractMessage.BuilderParent builderParent) {
        return new Builder(builderParent, null);
    }

    public static final class Builder extends GeneratedMessage.Builder<Builder> implements ReleaseDateResultOrBuilder {
        private int bitField0_;
        private RepeatedFieldBuilder<ReleaseDate, ReleaseDate.Builder, ReleaseDateOrBuilder> releasedatesBuilder_;
        private List<ReleaseDate> releasedates_;

        /* synthetic */ Builder(AbstractMessage.BuilderParent builderParent, ReleaseDateResultIA releaseDateResultIA) {
            this(builderParent);
        }

        /* synthetic */ Builder(ReleaseDateResultIA releaseDateResultIA) {
            this();
        }

        private void buildPartial0(ReleaseDateResult releaseDateResult) {
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return Igdbproto.internal_static_proto_ReleaseDateResult_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder
        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return Igdbproto.internal_static_proto_ReleaseDateResult_fieldAccessorTable.ensureFieldAccessorsInitialized(ReleaseDateResult.class, Builder.class);
        }

        private Builder() {
            this.releasedates_ = Collections.emptyList();
        }

        private Builder(AbstractMessage.BuilderParent builderParent) {
            super(builderParent);
            this.releasedates_ = Collections.emptyList();
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder clear() {
            super.clear();
            this.bitField0_ = 0;
            RepeatedFieldBuilder<ReleaseDate, ReleaseDate.Builder, ReleaseDateOrBuilder> repeatedFieldBuilder = this.releasedatesBuilder_;
            if (repeatedFieldBuilder == null) {
                this.releasedates_ = Collections.emptyList();
            } else {
                this.releasedates_ = null;
                repeatedFieldBuilder.clear();
            }
            this.bitField0_ &= -2;
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
        public Descriptors.Descriptor getDescriptorForType() {
            return Igdbproto.internal_static_proto_ReleaseDateResult_descriptor;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public ReleaseDateResult getDefaultInstanceForType() {
            return ReleaseDateResult.getDefaultInstance();
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public ReleaseDateResult build() {
            ReleaseDateResult releaseDateResultBuildPartial = buildPartial();
            if (releaseDateResultBuildPartial.isInitialized()) {
                return releaseDateResultBuildPartial;
            }
            throw newUninitializedMessageException((Message) releaseDateResultBuildPartial);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public ReleaseDateResult buildPartial() {
            ReleaseDateResult releaseDateResult = new ReleaseDateResult(this, null);
            buildPartialRepeatedFields(releaseDateResult);
            if (this.bitField0_ != 0) {
                buildPartial0(releaseDateResult);
            }
            onBuilt();
            return releaseDateResult;
        }

        private void buildPartialRepeatedFields(ReleaseDateResult releaseDateResult) {
            RepeatedFieldBuilder<ReleaseDate, ReleaseDate.Builder, ReleaseDateOrBuilder> repeatedFieldBuilder = this.releasedatesBuilder_;
            if (repeatedFieldBuilder == null) {
                if ((this.bitField0_ & 1) != 0) {
                    this.releasedates_ = Collections.unmodifiableList(this.releasedates_);
                    this.bitField0_ &= -2;
                }
                releaseDateResult.releasedates_ = this.releasedates_;
                return;
            }
            releaseDateResult.releasedates_ = repeatedFieldBuilder.build();
        }

        private void ensureReleasedatesIsMutable() {
            if ((this.bitField0_ & 1) == 0) {
                this.releasedates_ = new ArrayList(this.releasedates_);
                this.bitField0_ |= 1;
            }
        }

        @Override // proto.ReleaseDateResultOrBuilder
        public List<ReleaseDate> getReleasedatesList() {
            RepeatedFieldBuilder<ReleaseDate, ReleaseDate.Builder, ReleaseDateOrBuilder> repeatedFieldBuilder = this.releasedatesBuilder_;
            if (repeatedFieldBuilder == null) {
                return Collections.unmodifiableList(this.releasedates_);
            }
            return repeatedFieldBuilder.getMessageList();
        }

        @Override // proto.ReleaseDateResultOrBuilder
        public int getReleasedatesCount() {
            RepeatedFieldBuilder<ReleaseDate, ReleaseDate.Builder, ReleaseDateOrBuilder> repeatedFieldBuilder = this.releasedatesBuilder_;
            if (repeatedFieldBuilder == null) {
                return this.releasedates_.size();
            }
            return repeatedFieldBuilder.getCount();
        }

        @Override // proto.ReleaseDateResultOrBuilder
        public ReleaseDate getReleasedates(int i) {
            RepeatedFieldBuilder<ReleaseDate, ReleaseDate.Builder, ReleaseDateOrBuilder> repeatedFieldBuilder = this.releasedatesBuilder_;
            if (repeatedFieldBuilder == null) {
                return this.releasedates_.get(i);
            }
            return (ReleaseDate) repeatedFieldBuilder.getMessage(i);
        }

        public Builder setReleasedates(int i, ReleaseDate releaseDate) {
            RepeatedFieldBuilder<ReleaseDate, ReleaseDate.Builder, ReleaseDateOrBuilder> repeatedFieldBuilder = this.releasedatesBuilder_;
            if (repeatedFieldBuilder == null) {
                releaseDate.getClass();
                ensureReleasedatesIsMutable();
                this.releasedates_.set(i, releaseDate);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.setMessage(i, releaseDate);
            return this;
        }

        public Builder setReleasedates(int i, ReleaseDate.Builder builder) {
            RepeatedFieldBuilder<ReleaseDate, ReleaseDate.Builder, ReleaseDateOrBuilder> repeatedFieldBuilder = this.releasedatesBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureReleasedatesIsMutable();
                this.releasedates_.set(i, builder.build());
                onChanged();
                return this;
            }
            repeatedFieldBuilder.setMessage(i, builder.build());
            return this;
        }

        public Builder addReleasedates(ReleaseDate releaseDate) {
            RepeatedFieldBuilder<ReleaseDate, ReleaseDate.Builder, ReleaseDateOrBuilder> repeatedFieldBuilder = this.releasedatesBuilder_;
            if (repeatedFieldBuilder == null) {
                releaseDate.getClass();
                ensureReleasedatesIsMutable();
                this.releasedates_.add(releaseDate);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(releaseDate);
            return this;
        }

        public Builder addReleasedates(int i, ReleaseDate releaseDate) {
            RepeatedFieldBuilder<ReleaseDate, ReleaseDate.Builder, ReleaseDateOrBuilder> repeatedFieldBuilder = this.releasedatesBuilder_;
            if (repeatedFieldBuilder == null) {
                releaseDate.getClass();
                ensureReleasedatesIsMutable();
                this.releasedates_.add(i, releaseDate);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(i, releaseDate);
            return this;
        }

        public Builder addReleasedates(ReleaseDate.Builder builder) {
            RepeatedFieldBuilder<ReleaseDate, ReleaseDate.Builder, ReleaseDateOrBuilder> repeatedFieldBuilder = this.releasedatesBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureReleasedatesIsMutable();
                this.releasedates_.add(builder.build());
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(builder.build());
            return this;
        }

        public Builder addReleasedates(int i, ReleaseDate.Builder builder) {
            RepeatedFieldBuilder<ReleaseDate, ReleaseDate.Builder, ReleaseDateOrBuilder> repeatedFieldBuilder = this.releasedatesBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureReleasedatesIsMutable();
                this.releasedates_.add(i, builder.build());
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(i, builder.build());
            return this;
        }

        public Builder addAllReleasedates(Iterable<? extends ReleaseDate> iterable) {
            RepeatedFieldBuilder<ReleaseDate, ReleaseDate.Builder, ReleaseDateOrBuilder> repeatedFieldBuilder = this.releasedatesBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureReleasedatesIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) iterable, (List) this.releasedates_);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addAllMessages(iterable);
            return this;
        }

        public Builder clearReleasedates() {
            RepeatedFieldBuilder<ReleaseDate, ReleaseDate.Builder, ReleaseDateOrBuilder> repeatedFieldBuilder = this.releasedatesBuilder_;
            if (repeatedFieldBuilder == null) {
                this.releasedates_ = Collections.emptyList();
                this.bitField0_ &= -2;
                onChanged();
                return this;
            }
            repeatedFieldBuilder.clear();
            return this;
        }

        public Builder removeReleasedates(int i) {
            RepeatedFieldBuilder<ReleaseDate, ReleaseDate.Builder, ReleaseDateOrBuilder> repeatedFieldBuilder = this.releasedatesBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureReleasedatesIsMutable();
                this.releasedates_.remove(i);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.remove(i);
            return this;
        }

        public ReleaseDate.Builder getReleasedatesBuilder(int i) {
            return (ReleaseDate.Builder) getReleasedatesFieldBuilder().getBuilder(i);
        }

        @Override // proto.ReleaseDateResultOrBuilder
        public ReleaseDateOrBuilder getReleasedatesOrBuilder(int i) {
            RepeatedFieldBuilder<ReleaseDate, ReleaseDate.Builder, ReleaseDateOrBuilder> repeatedFieldBuilder = this.releasedatesBuilder_;
            if (repeatedFieldBuilder == null) {
                return this.releasedates_.get(i);
            }
            return (ReleaseDateOrBuilder) repeatedFieldBuilder.getMessageOrBuilder(i);
        }

        @Override // proto.ReleaseDateResultOrBuilder
        public List<? extends ReleaseDateOrBuilder> getReleasedatesOrBuilderList() {
            RepeatedFieldBuilder<ReleaseDate, ReleaseDate.Builder, ReleaseDateOrBuilder> repeatedFieldBuilder = this.releasedatesBuilder_;
            if (repeatedFieldBuilder != null) {
                return repeatedFieldBuilder.getMessageOrBuilderList();
            }
            return Collections.unmodifiableList(this.releasedates_);
        }

        public ReleaseDate.Builder addReleasedatesBuilder() {
            return (ReleaseDate.Builder) getReleasedatesFieldBuilder().addBuilder(ReleaseDate.getDefaultInstance());
        }

        public ReleaseDate.Builder addReleasedatesBuilder(int i) {
            return (ReleaseDate.Builder) getReleasedatesFieldBuilder().addBuilder(i, ReleaseDate.getDefaultInstance());
        }

        public List<ReleaseDate.Builder> getReleasedatesBuilderList() {
            return getReleasedatesFieldBuilder().getBuilderList();
        }

        private RepeatedFieldBuilder<ReleaseDate, ReleaseDate.Builder, ReleaseDateOrBuilder> getReleasedatesFieldBuilder() {
            if (this.releasedatesBuilder_ == null) {
                this.releasedatesBuilder_ = new RepeatedFieldBuilder<>(this.releasedates_, (this.bitField0_ & 1) != 0, getParentForChildren(), isClean());
                this.releasedates_ = null;
            }
            return this.releasedatesBuilder_;
        }
    }

    public static ReleaseDateResult getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* INFO: renamed from: proto.ReleaseDateResult$1, reason: invalid class name */
    class AnonymousClass1 extends AbstractParser<ReleaseDateResult> {
        AnonymousClass1() {
        }

        @Override // com.google.protobuf.Parser
        public ReleaseDateResult parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            Builder builderNewBuilder = ReleaseDateResult.newBuilder();
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

    public static Parser<ReleaseDateResult> parser() {
        return PARSER;
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Parser<ReleaseDateResult> getParserForType() {
        return PARSER;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
    public ReleaseDateResult getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }
}
