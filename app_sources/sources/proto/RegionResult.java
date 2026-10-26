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
public final class RegionResult extends GeneratedMessage implements RegionResultOrBuilder {
    private static final RegionResult DEFAULT_INSTANCE;
    private static final Parser<RegionResult> PARSER;
    public static final int REGIONS_FIELD_NUMBER = 1;
    private static final long serialVersionUID = 0;
    private List<Region> regions_;

    /* synthetic */ RegionResult(GeneratedMessage.Builder builder, RegionResultIA regionResultIA) {
        this(builder);
    }

    static {
        RuntimeVersion.validateProtobufGencodeVersion(RuntimeVersion.RuntimeDomain.PUBLIC, 4, 27, 2, "", RegionResult.class.getName());
        DEFAULT_INSTANCE = new RegionResult();
        PARSER = new AnonymousClass1();
    }

    private RegionResult(GeneratedMessage.Builder<?> builder) {
        super(builder);
    }

    private RegionResult() {
        this.regions_ = Collections.emptyList();
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return Igdbproto.internal_static_proto_RegionResult_descriptor;
    }

    @Override // com.google.protobuf.GeneratedMessage
    protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
        return Igdbproto.internal_static_proto_RegionResult_fieldAccessorTable.ensureFieldAccessorsInitialized(RegionResult.class, Builder.class);
    }

    @Override // proto.RegionResultOrBuilder
    public List<Region> getRegionsList() {
        return this.regions_;
    }

    @Override // proto.RegionResultOrBuilder
    public List<? extends RegionOrBuilder> getRegionsOrBuilderList() {
        return this.regions_;
    }

    @Override // proto.RegionResultOrBuilder
    public int getRegionsCount() {
        return this.regions_.size();
    }

    @Override // proto.RegionResultOrBuilder
    public Region getRegions(int i) {
        return this.regions_.get(i);
    }

    @Override // proto.RegionResultOrBuilder
    public RegionOrBuilder getRegionsOrBuilder(int i) {
        return this.regions_.get(i);
    }

    public static RegionResult parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer);
    }

    public static RegionResult parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    public static RegionResult parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString);
    }

    public static RegionResult parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static RegionResult parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr);
    }

    public static RegionResult parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr, extensionRegistryLite);
    }

    public static RegionResult parseFrom(InputStream inputStream) throws IOException {
        return (RegionResult) GeneratedMessage.parseWithIOException(PARSER, inputStream);
    }

    public static RegionResult parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (RegionResult) GeneratedMessage.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static RegionResult parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (RegionResult) GeneratedMessage.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static RegionResult parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (RegionResult) GeneratedMessage.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static RegionResult parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (RegionResult) GeneratedMessage.parseWithIOException(PARSER, codedInputStream);
    }

    public static RegionResult parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (RegionResult) GeneratedMessage.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder newBuilderForType() {
        return newBuilder();
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    /* WARN: Multi-variable type inference failed */
    public static Builder newBuilder(RegionResult regionResult) {
        return (Builder) DEFAULT_INSTANCE.toBuilder().mergeFrom((Message) regionResult);
    }

    /* WARN: Multi-variable type inference failed */
    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder toBuilder() {
        return this == DEFAULT_INSTANCE ? new Builder((RegionResultIA) null) : (Builder) new Builder((RegionResultIA) null).mergeFrom((Message) this);
    }

    /* INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.AbstractMessage
    public Builder newBuilderForType(AbstractMessage.BuilderParent builderParent) {
        return new Builder(builderParent, null);
    }

    public static final class Builder extends GeneratedMessage.Builder<Builder> implements RegionResultOrBuilder {
        private int bitField0_;
        private RepeatedFieldBuilder<Region, Region.Builder, RegionOrBuilder> regionsBuilder_;
        private List<Region> regions_;

        /* synthetic */ Builder(AbstractMessage.BuilderParent builderParent, RegionResultIA regionResultIA) {
            this(builderParent);
        }

        /* synthetic */ Builder(RegionResultIA regionResultIA) {
            this();
        }

        private void buildPartial0(RegionResult regionResult) {
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return Igdbproto.internal_static_proto_RegionResult_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder
        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return Igdbproto.internal_static_proto_RegionResult_fieldAccessorTable.ensureFieldAccessorsInitialized(RegionResult.class, Builder.class);
        }

        private Builder() {
            this.regions_ = Collections.emptyList();
        }

        private Builder(AbstractMessage.BuilderParent builderParent) {
            super(builderParent);
            this.regions_ = Collections.emptyList();
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder clear() {
            super.clear();
            this.bitField0_ = 0;
            RepeatedFieldBuilder<Region, Region.Builder, RegionOrBuilder> repeatedFieldBuilder = this.regionsBuilder_;
            if (repeatedFieldBuilder == null) {
                this.regions_ = Collections.emptyList();
            } else {
                this.regions_ = null;
                repeatedFieldBuilder.clear();
            }
            this.bitField0_ &= -2;
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
        public Descriptors.Descriptor getDescriptorForType() {
            return Igdbproto.internal_static_proto_RegionResult_descriptor;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public RegionResult getDefaultInstanceForType() {
            return RegionResult.getDefaultInstance();
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public RegionResult build() {
            RegionResult regionResultBuildPartial = buildPartial();
            if (regionResultBuildPartial.isInitialized()) {
                return regionResultBuildPartial;
            }
            throw newUninitializedMessageException((Message) regionResultBuildPartial);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public RegionResult buildPartial() {
            RegionResult regionResult = new RegionResult(this, null);
            buildPartialRepeatedFields(regionResult);
            if (this.bitField0_ != 0) {
                buildPartial0(regionResult);
            }
            onBuilt();
            return regionResult;
        }

        private void buildPartialRepeatedFields(RegionResult regionResult) {
            RepeatedFieldBuilder<Region, Region.Builder, RegionOrBuilder> repeatedFieldBuilder = this.regionsBuilder_;
            if (repeatedFieldBuilder == null) {
                if ((this.bitField0_ & 1) != 0) {
                    this.regions_ = Collections.unmodifiableList(this.regions_);
                    this.bitField0_ &= -2;
                }
                regionResult.regions_ = this.regions_;
                return;
            }
            regionResult.regions_ = repeatedFieldBuilder.build();
        }

        private void ensureRegionsIsMutable() {
            if ((this.bitField0_ & 1) == 0) {
                this.regions_ = new ArrayList(this.regions_);
                this.bitField0_ |= 1;
            }
        }

        @Override // proto.RegionResultOrBuilder
        public List<Region> getRegionsList() {
            RepeatedFieldBuilder<Region, Region.Builder, RegionOrBuilder> repeatedFieldBuilder = this.regionsBuilder_;
            if (repeatedFieldBuilder == null) {
                return Collections.unmodifiableList(this.regions_);
            }
            return repeatedFieldBuilder.getMessageList();
        }

        @Override // proto.RegionResultOrBuilder
        public int getRegionsCount() {
            RepeatedFieldBuilder<Region, Region.Builder, RegionOrBuilder> repeatedFieldBuilder = this.regionsBuilder_;
            if (repeatedFieldBuilder == null) {
                return this.regions_.size();
            }
            return repeatedFieldBuilder.getCount();
        }

        @Override // proto.RegionResultOrBuilder
        public Region getRegions(int i) {
            RepeatedFieldBuilder<Region, Region.Builder, RegionOrBuilder> repeatedFieldBuilder = this.regionsBuilder_;
            if (repeatedFieldBuilder == null) {
                return this.regions_.get(i);
            }
            return (Region) repeatedFieldBuilder.getMessage(i);
        }

        public Builder setRegions(int i, Region region) {
            RepeatedFieldBuilder<Region, Region.Builder, RegionOrBuilder> repeatedFieldBuilder = this.regionsBuilder_;
            if (repeatedFieldBuilder == null) {
                region.getClass();
                ensureRegionsIsMutable();
                this.regions_.set(i, region);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.setMessage(i, region);
            return this;
        }

        public Builder setRegions(int i, Region.Builder builder) {
            RepeatedFieldBuilder<Region, Region.Builder, RegionOrBuilder> repeatedFieldBuilder = this.regionsBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureRegionsIsMutable();
                this.regions_.set(i, builder.build());
                onChanged();
                return this;
            }
            repeatedFieldBuilder.setMessage(i, builder.build());
            return this;
        }

        public Builder addRegions(Region region) {
            RepeatedFieldBuilder<Region, Region.Builder, RegionOrBuilder> repeatedFieldBuilder = this.regionsBuilder_;
            if (repeatedFieldBuilder == null) {
                region.getClass();
                ensureRegionsIsMutable();
                this.regions_.add(region);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(region);
            return this;
        }

        public Builder addRegions(int i, Region region) {
            RepeatedFieldBuilder<Region, Region.Builder, RegionOrBuilder> repeatedFieldBuilder = this.regionsBuilder_;
            if (repeatedFieldBuilder == null) {
                region.getClass();
                ensureRegionsIsMutable();
                this.regions_.add(i, region);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(i, region);
            return this;
        }

        public Builder addRegions(Region.Builder builder) {
            RepeatedFieldBuilder<Region, Region.Builder, RegionOrBuilder> repeatedFieldBuilder = this.regionsBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureRegionsIsMutable();
                this.regions_.add(builder.build());
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(builder.build());
            return this;
        }

        public Builder addRegions(int i, Region.Builder builder) {
            RepeatedFieldBuilder<Region, Region.Builder, RegionOrBuilder> repeatedFieldBuilder = this.regionsBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureRegionsIsMutable();
                this.regions_.add(i, builder.build());
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(i, builder.build());
            return this;
        }

        public Builder addAllRegions(Iterable<? extends Region> iterable) {
            RepeatedFieldBuilder<Region, Region.Builder, RegionOrBuilder> repeatedFieldBuilder = this.regionsBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureRegionsIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) iterable, (List) this.regions_);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addAllMessages(iterable);
            return this;
        }

        public Builder clearRegions() {
            RepeatedFieldBuilder<Region, Region.Builder, RegionOrBuilder> repeatedFieldBuilder = this.regionsBuilder_;
            if (repeatedFieldBuilder == null) {
                this.regions_ = Collections.emptyList();
                this.bitField0_ &= -2;
                onChanged();
                return this;
            }
            repeatedFieldBuilder.clear();
            return this;
        }

        public Builder removeRegions(int i) {
            RepeatedFieldBuilder<Region, Region.Builder, RegionOrBuilder> repeatedFieldBuilder = this.regionsBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureRegionsIsMutable();
                this.regions_.remove(i);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.remove(i);
            return this;
        }

        public Region.Builder getRegionsBuilder(int i) {
            return (Region.Builder) getRegionsFieldBuilder().getBuilder(i);
        }

        @Override // proto.RegionResultOrBuilder
        public RegionOrBuilder getRegionsOrBuilder(int i) {
            RepeatedFieldBuilder<Region, Region.Builder, RegionOrBuilder> repeatedFieldBuilder = this.regionsBuilder_;
            if (repeatedFieldBuilder == null) {
                return this.regions_.get(i);
            }
            return (RegionOrBuilder) repeatedFieldBuilder.getMessageOrBuilder(i);
        }

        @Override // proto.RegionResultOrBuilder
        public List<? extends RegionOrBuilder> getRegionsOrBuilderList() {
            RepeatedFieldBuilder<Region, Region.Builder, RegionOrBuilder> repeatedFieldBuilder = this.regionsBuilder_;
            if (repeatedFieldBuilder != null) {
                return repeatedFieldBuilder.getMessageOrBuilderList();
            }
            return Collections.unmodifiableList(this.regions_);
        }

        public Region.Builder addRegionsBuilder() {
            return (Region.Builder) getRegionsFieldBuilder().addBuilder(Region.getDefaultInstance());
        }

        public Region.Builder addRegionsBuilder(int i) {
            return (Region.Builder) getRegionsFieldBuilder().addBuilder(i, Region.getDefaultInstance());
        }

        public List<Region.Builder> getRegionsBuilderList() {
            return getRegionsFieldBuilder().getBuilderList();
        }

        private RepeatedFieldBuilder<Region, Region.Builder, RegionOrBuilder> getRegionsFieldBuilder() {
            if (this.regionsBuilder_ == null) {
                this.regionsBuilder_ = new RepeatedFieldBuilder<>(this.regions_, (this.bitField0_ & 1) != 0, getParentForChildren(), isClean());
                this.regions_ = null;
            }
            return this.regionsBuilder_;
        }
    }

    public static RegionResult getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* INFO: renamed from: proto.RegionResult$1, reason: invalid class name */
    class AnonymousClass1 extends AbstractParser<RegionResult> {
        AnonymousClass1() {
        }

        @Override // com.google.protobuf.Parser
        public RegionResult parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            Builder builderNewBuilder = RegionResult.newBuilder();
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

    public static Parser<RegionResult> parser() {
        return PARSER;
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Parser<RegionResult> getParserForType() {
        return PARSER;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
    public RegionResult getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }
}
