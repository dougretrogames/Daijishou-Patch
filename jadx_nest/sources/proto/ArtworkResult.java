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
public final class ArtworkResult extends GeneratedMessage implements ArtworkResultOrBuilder {
    public static final int ARTWORKS_FIELD_NUMBER = 1;
    private static final ArtworkResult DEFAULT_INSTANCE;
    private static final Parser<ArtworkResult> PARSER;
    private static final long serialVersionUID = 0;
    private List<Artwork> artworks_;

    /* synthetic */ ArtworkResult(GeneratedMessage.Builder builder, ArtworkResultIA artworkResultIA) {
        this(builder);
    }

    static {
        RuntimeVersion.validateProtobufGencodeVersion(RuntimeVersion.RuntimeDomain.PUBLIC, 4, 27, 2, "", ArtworkResult.class.getName());
        DEFAULT_INSTANCE = new ArtworkResult();
        PARSER = new AnonymousClass1();
    }

    private ArtworkResult(GeneratedMessage.Builder<?> builder) {
        super(builder);
    }

    private ArtworkResult() {
        this.artworks_ = Collections.emptyList();
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return Igdbproto.internal_static_proto_ArtworkResult_descriptor;
    }

    @Override // com.google.protobuf.GeneratedMessage
    protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
        return Igdbproto.internal_static_proto_ArtworkResult_fieldAccessorTable.ensureFieldAccessorsInitialized(ArtworkResult.class, Builder.class);
    }

    @Override // proto.ArtworkResultOrBuilder
    public List<Artwork> getArtworksList() {
        return this.artworks_;
    }

    @Override // proto.ArtworkResultOrBuilder
    public List<? extends ArtworkOrBuilder> getArtworksOrBuilderList() {
        return this.artworks_;
    }

    @Override // proto.ArtworkResultOrBuilder
    public int getArtworksCount() {
        return this.artworks_.size();
    }

    @Override // proto.ArtworkResultOrBuilder
    public Artwork getArtworks(int i) {
        return this.artworks_.get(i);
    }

    @Override // proto.ArtworkResultOrBuilder
    public ArtworkOrBuilder getArtworksOrBuilder(int i) {
        return this.artworks_.get(i);
    }

    public static ArtworkResult parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer);
    }

    public static ArtworkResult parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    public static ArtworkResult parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString);
    }

    public static ArtworkResult parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static ArtworkResult parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr);
    }

    public static ArtworkResult parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr, extensionRegistryLite);
    }

    public static ArtworkResult parseFrom(InputStream inputStream) throws IOException {
        return (ArtworkResult) GeneratedMessage.parseWithIOException(PARSER, inputStream);
    }

    public static ArtworkResult parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (ArtworkResult) GeneratedMessage.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static ArtworkResult parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (ArtworkResult) GeneratedMessage.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static ArtworkResult parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (ArtworkResult) GeneratedMessage.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static ArtworkResult parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (ArtworkResult) GeneratedMessage.parseWithIOException(PARSER, codedInputStream);
    }

    public static ArtworkResult parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (ArtworkResult) GeneratedMessage.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder newBuilderForType() {
        return newBuilder();
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static Builder newBuilder(ArtworkResult artworkResult) {
        return (Builder) DEFAULT_INSTANCE.toBuilder().mergeFrom((Message) artworkResult);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder toBuilder() {
        return this == DEFAULT_INSTANCE ? new Builder((ArtworkResultIA) null) : (Builder) new Builder((ArtworkResultIA) null).mergeFrom((Message) this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.AbstractMessage
    public Builder newBuilderForType(AbstractMessage.BuilderParent builderParent) {
        return new Builder(builderParent, null);
    }

    public static final class Builder extends GeneratedMessage.Builder<Builder> implements ArtworkResultOrBuilder {
        private RepeatedFieldBuilder<Artwork, Artwork.Builder, ArtworkOrBuilder> artworksBuilder_;
        private List<Artwork> artworks_;
        private int bitField0_;

        /* synthetic */ Builder(AbstractMessage.BuilderParent builderParent, ArtworkResultIA artworkResultIA) {
            this(builderParent);
        }

        /* synthetic */ Builder(ArtworkResultIA artworkResultIA) {
            this();
        }

        private void buildPartial0(ArtworkResult artworkResult) {
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return Igdbproto.internal_static_proto_ArtworkResult_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder
        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return Igdbproto.internal_static_proto_ArtworkResult_fieldAccessorTable.ensureFieldAccessorsInitialized(ArtworkResult.class, Builder.class);
        }

        private Builder() {
            this.artworks_ = Collections.emptyList();
        }

        private Builder(AbstractMessage.BuilderParent builderParent) {
            super(builderParent);
            this.artworks_ = Collections.emptyList();
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder clear() {
            super.clear();
            this.bitField0_ = 0;
            RepeatedFieldBuilder<Artwork, Artwork.Builder, ArtworkOrBuilder> repeatedFieldBuilder = this.artworksBuilder_;
            if (repeatedFieldBuilder == null) {
                this.artworks_ = Collections.emptyList();
            } else {
                this.artworks_ = null;
                repeatedFieldBuilder.clear();
            }
            this.bitField0_ &= -2;
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
        public Descriptors.Descriptor getDescriptorForType() {
            return Igdbproto.internal_static_proto_ArtworkResult_descriptor;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public ArtworkResult getDefaultInstanceForType() {
            return ArtworkResult.getDefaultInstance();
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public ArtworkResult build() {
            ArtworkResult artworkResultBuildPartial = buildPartial();
            if (artworkResultBuildPartial.isInitialized()) {
                return artworkResultBuildPartial;
            }
            throw newUninitializedMessageException((Message) artworkResultBuildPartial);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public ArtworkResult buildPartial() {
            ArtworkResult artworkResult = new ArtworkResult(this, null);
            buildPartialRepeatedFields(artworkResult);
            if (this.bitField0_ != 0) {
                buildPartial0(artworkResult);
            }
            onBuilt();
            return artworkResult;
        }

        private void buildPartialRepeatedFields(ArtworkResult artworkResult) {
            RepeatedFieldBuilder<Artwork, Artwork.Builder, ArtworkOrBuilder> repeatedFieldBuilder = this.artworksBuilder_;
            if (repeatedFieldBuilder == null) {
                if ((this.bitField0_ & 1) != 0) {
                    this.artworks_ = Collections.unmodifiableList(this.artworks_);
                    this.bitField0_ &= -2;
                }
                artworkResult.artworks_ = this.artworks_;
                return;
            }
            artworkResult.artworks_ = repeatedFieldBuilder.build();
        }

        private void ensureArtworksIsMutable() {
            if ((this.bitField0_ & 1) == 0) {
                this.artworks_ = new ArrayList(this.artworks_);
                this.bitField0_ |= 1;
            }
        }

        @Override // proto.ArtworkResultOrBuilder
        public List<Artwork> getArtworksList() {
            RepeatedFieldBuilder<Artwork, Artwork.Builder, ArtworkOrBuilder> repeatedFieldBuilder = this.artworksBuilder_;
            if (repeatedFieldBuilder == null) {
                return Collections.unmodifiableList(this.artworks_);
            }
            return repeatedFieldBuilder.getMessageList();
        }

        @Override // proto.ArtworkResultOrBuilder
        public int getArtworksCount() {
            RepeatedFieldBuilder<Artwork, Artwork.Builder, ArtworkOrBuilder> repeatedFieldBuilder = this.artworksBuilder_;
            if (repeatedFieldBuilder == null) {
                return this.artworks_.size();
            }
            return repeatedFieldBuilder.getCount();
        }

        @Override // proto.ArtworkResultOrBuilder
        public Artwork getArtworks(int i) {
            RepeatedFieldBuilder<Artwork, Artwork.Builder, ArtworkOrBuilder> repeatedFieldBuilder = this.artworksBuilder_;
            if (repeatedFieldBuilder == null) {
                return this.artworks_.get(i);
            }
            return (Artwork) repeatedFieldBuilder.getMessage(i);
        }

        public Builder setArtworks(int i, Artwork artwork) {
            RepeatedFieldBuilder<Artwork, Artwork.Builder, ArtworkOrBuilder> repeatedFieldBuilder = this.artworksBuilder_;
            if (repeatedFieldBuilder == null) {
                artwork.getClass();
                ensureArtworksIsMutable();
                this.artworks_.set(i, artwork);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.setMessage(i, artwork);
            return this;
        }

        public Builder setArtworks(int i, Artwork.Builder builder) {
            RepeatedFieldBuilder<Artwork, Artwork.Builder, ArtworkOrBuilder> repeatedFieldBuilder = this.artworksBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureArtworksIsMutable();
                this.artworks_.set(i, builder.build());
                onChanged();
                return this;
            }
            repeatedFieldBuilder.setMessage(i, builder.build());
            return this;
        }

        public Builder addArtworks(Artwork artwork) {
            RepeatedFieldBuilder<Artwork, Artwork.Builder, ArtworkOrBuilder> repeatedFieldBuilder = this.artworksBuilder_;
            if (repeatedFieldBuilder == null) {
                artwork.getClass();
                ensureArtworksIsMutable();
                this.artworks_.add(artwork);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(artwork);
            return this;
        }

        public Builder addArtworks(int i, Artwork artwork) {
            RepeatedFieldBuilder<Artwork, Artwork.Builder, ArtworkOrBuilder> repeatedFieldBuilder = this.artworksBuilder_;
            if (repeatedFieldBuilder == null) {
                artwork.getClass();
                ensureArtworksIsMutable();
                this.artworks_.add(i, artwork);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(i, artwork);
            return this;
        }

        public Builder addArtworks(Artwork.Builder builder) {
            RepeatedFieldBuilder<Artwork, Artwork.Builder, ArtworkOrBuilder> repeatedFieldBuilder = this.artworksBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureArtworksIsMutable();
                this.artworks_.add(builder.build());
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(builder.build());
            return this;
        }

        public Builder addArtworks(int i, Artwork.Builder builder) {
            RepeatedFieldBuilder<Artwork, Artwork.Builder, ArtworkOrBuilder> repeatedFieldBuilder = this.artworksBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureArtworksIsMutable();
                this.artworks_.add(i, builder.build());
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(i, builder.build());
            return this;
        }

        public Builder addAllArtworks(Iterable<? extends Artwork> iterable) {
            RepeatedFieldBuilder<Artwork, Artwork.Builder, ArtworkOrBuilder> repeatedFieldBuilder = this.artworksBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureArtworksIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) iterable, (List) this.artworks_);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addAllMessages(iterable);
            return this;
        }

        public Builder clearArtworks() {
            RepeatedFieldBuilder<Artwork, Artwork.Builder, ArtworkOrBuilder> repeatedFieldBuilder = this.artworksBuilder_;
            if (repeatedFieldBuilder == null) {
                this.artworks_ = Collections.emptyList();
                this.bitField0_ &= -2;
                onChanged();
                return this;
            }
            repeatedFieldBuilder.clear();
            return this;
        }

        public Builder removeArtworks(int i) {
            RepeatedFieldBuilder<Artwork, Artwork.Builder, ArtworkOrBuilder> repeatedFieldBuilder = this.artworksBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureArtworksIsMutable();
                this.artworks_.remove(i);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.remove(i);
            return this;
        }

        public Artwork.Builder getArtworksBuilder(int i) {
            return (Artwork.Builder) getArtworksFieldBuilder().getBuilder(i);
        }

        @Override // proto.ArtworkResultOrBuilder
        public ArtworkOrBuilder getArtworksOrBuilder(int i) {
            RepeatedFieldBuilder<Artwork, Artwork.Builder, ArtworkOrBuilder> repeatedFieldBuilder = this.artworksBuilder_;
            if (repeatedFieldBuilder == null) {
                return this.artworks_.get(i);
            }
            return (ArtworkOrBuilder) repeatedFieldBuilder.getMessageOrBuilder(i);
        }

        @Override // proto.ArtworkResultOrBuilder
        public List<? extends ArtworkOrBuilder> getArtworksOrBuilderList() {
            RepeatedFieldBuilder<Artwork, Artwork.Builder, ArtworkOrBuilder> repeatedFieldBuilder = this.artworksBuilder_;
            if (repeatedFieldBuilder != null) {
                return repeatedFieldBuilder.getMessageOrBuilderList();
            }
            return Collections.unmodifiableList(this.artworks_);
        }

        public Artwork.Builder addArtworksBuilder() {
            return (Artwork.Builder) getArtworksFieldBuilder().addBuilder(Artwork.getDefaultInstance());
        }

        public Artwork.Builder addArtworksBuilder(int i) {
            return (Artwork.Builder) getArtworksFieldBuilder().addBuilder(i, Artwork.getDefaultInstance());
        }

        public List<Artwork.Builder> getArtworksBuilderList() {
            return getArtworksFieldBuilder().getBuilderList();
        }

        private RepeatedFieldBuilder<Artwork, Artwork.Builder, ArtworkOrBuilder> getArtworksFieldBuilder() {
            if (this.artworksBuilder_ == null) {
                this.artworksBuilder_ = new RepeatedFieldBuilder<>(this.artworks_, (this.bitField0_ & 1) != 0, getParentForChildren(), isClean());
                this.artworks_ = null;
            }
            return this.artworksBuilder_;
        }
    }

    public static ArtworkResult getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* JADX INFO: renamed from: proto.ArtworkResult$1, reason: invalid class name */
    class AnonymousClass1 extends AbstractParser<ArtworkResult> {
        AnonymousClass1() {
        }

        @Override // com.google.protobuf.Parser
        public ArtworkResult parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            Builder builderNewBuilder = ArtworkResult.newBuilder();
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

    public static Parser<ArtworkResult> parser() {
        return PARSER;
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Parser<ArtworkResult> getParserForType() {
        return PARSER;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
    public ArtworkResult getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }
}
