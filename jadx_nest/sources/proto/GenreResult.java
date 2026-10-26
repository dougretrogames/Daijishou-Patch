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
public final class GenreResult extends GeneratedMessage implements GenreResultOrBuilder {
    private static final GenreResult DEFAULT_INSTANCE;
    public static final int GENRES_FIELD_NUMBER = 1;
    private static final Parser<GenreResult> PARSER;
    private static final long serialVersionUID = 0;
    private List<Genre> genres_;

    /* synthetic */ GenreResult(GeneratedMessage.Builder builder, GenreResultIA genreResultIA) {
        this(builder);
    }

    static {
        RuntimeVersion.validateProtobufGencodeVersion(RuntimeVersion.RuntimeDomain.PUBLIC, 4, 27, 2, "", GenreResult.class.getName());
        DEFAULT_INSTANCE = new GenreResult();
        PARSER = new AnonymousClass1();
    }

    private GenreResult(GeneratedMessage.Builder<?> builder) {
        super(builder);
    }

    private GenreResult() {
        this.genres_ = Collections.emptyList();
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return Igdbproto.internal_static_proto_GenreResult_descriptor;
    }

    @Override // com.google.protobuf.GeneratedMessage
    protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
        return Igdbproto.internal_static_proto_GenreResult_fieldAccessorTable.ensureFieldAccessorsInitialized(GenreResult.class, Builder.class);
    }

    @Override // proto.GenreResultOrBuilder
    public List<Genre> getGenresList() {
        return this.genres_;
    }

    @Override // proto.GenreResultOrBuilder
    public List<? extends GenreOrBuilder> getGenresOrBuilderList() {
        return this.genres_;
    }

    @Override // proto.GenreResultOrBuilder
    public int getGenresCount() {
        return this.genres_.size();
    }

    @Override // proto.GenreResultOrBuilder
    public Genre getGenres(int i) {
        return this.genres_.get(i);
    }

    @Override // proto.GenreResultOrBuilder
    public GenreOrBuilder getGenresOrBuilder(int i) {
        return this.genres_.get(i);
    }

    public static GenreResult parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer);
    }

    public static GenreResult parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    public static GenreResult parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString);
    }

    public static GenreResult parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static GenreResult parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr);
    }

    public static GenreResult parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr, extensionRegistryLite);
    }

    public static GenreResult parseFrom(InputStream inputStream) throws IOException {
        return (GenreResult) GeneratedMessage.parseWithIOException(PARSER, inputStream);
    }

    public static GenreResult parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (GenreResult) GeneratedMessage.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static GenreResult parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (GenreResult) GeneratedMessage.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static GenreResult parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (GenreResult) GeneratedMessage.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static GenreResult parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (GenreResult) GeneratedMessage.parseWithIOException(PARSER, codedInputStream);
    }

    public static GenreResult parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (GenreResult) GeneratedMessage.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder newBuilderForType() {
        return newBuilder();
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    /* WARN: Multi-variable type inference failed */
    public static Builder newBuilder(GenreResult genreResult) {
        return (Builder) DEFAULT_INSTANCE.toBuilder().mergeFrom((Message) genreResult);
    }

    /* WARN: Multi-variable type inference failed */
    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder toBuilder() {
        return this == DEFAULT_INSTANCE ? new Builder((GenreResultIA) null) : (Builder) new Builder((GenreResultIA) null).mergeFrom((Message) this);
    }

    /* INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.AbstractMessage
    public Builder newBuilderForType(AbstractMessage.BuilderParent builderParent) {
        return new Builder(builderParent, null);
    }

    public static final class Builder extends GeneratedMessage.Builder<Builder> implements GenreResultOrBuilder {
        private int bitField0_;
        private RepeatedFieldBuilder<Genre, Genre.Builder, GenreOrBuilder> genresBuilder_;
        private List<Genre> genres_;

        /* synthetic */ Builder(AbstractMessage.BuilderParent builderParent, GenreResultIA genreResultIA) {
            this(builderParent);
        }

        /* synthetic */ Builder(GenreResultIA genreResultIA) {
            this();
        }

        private void buildPartial0(GenreResult genreResult) {
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return Igdbproto.internal_static_proto_GenreResult_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder
        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return Igdbproto.internal_static_proto_GenreResult_fieldAccessorTable.ensureFieldAccessorsInitialized(GenreResult.class, Builder.class);
        }

        private Builder() {
            this.genres_ = Collections.emptyList();
        }

        private Builder(AbstractMessage.BuilderParent builderParent) {
            super(builderParent);
            this.genres_ = Collections.emptyList();
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder clear() {
            super.clear();
            this.bitField0_ = 0;
            RepeatedFieldBuilder<Genre, Genre.Builder, GenreOrBuilder> repeatedFieldBuilder = this.genresBuilder_;
            if (repeatedFieldBuilder == null) {
                this.genres_ = Collections.emptyList();
            } else {
                this.genres_ = null;
                repeatedFieldBuilder.clear();
            }
            this.bitField0_ &= -2;
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
        public Descriptors.Descriptor getDescriptorForType() {
            return Igdbproto.internal_static_proto_GenreResult_descriptor;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public GenreResult getDefaultInstanceForType() {
            return GenreResult.getDefaultInstance();
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public GenreResult build() {
            GenreResult genreResultBuildPartial = buildPartial();
            if (genreResultBuildPartial.isInitialized()) {
                return genreResultBuildPartial;
            }
            throw newUninitializedMessageException((Message) genreResultBuildPartial);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public GenreResult buildPartial() {
            GenreResult genreResult = new GenreResult(this, null);
            buildPartialRepeatedFields(genreResult);
            if (this.bitField0_ != 0) {
                buildPartial0(genreResult);
            }
            onBuilt();
            return genreResult;
        }

        private void buildPartialRepeatedFields(GenreResult genreResult) {
            RepeatedFieldBuilder<Genre, Genre.Builder, GenreOrBuilder> repeatedFieldBuilder = this.genresBuilder_;
            if (repeatedFieldBuilder == null) {
                if ((this.bitField0_ & 1) != 0) {
                    this.genres_ = Collections.unmodifiableList(this.genres_);
                    this.bitField0_ &= -2;
                }
                genreResult.genres_ = this.genres_;
                return;
            }
            genreResult.genres_ = repeatedFieldBuilder.build();
        }

        private void ensureGenresIsMutable() {
            if ((this.bitField0_ & 1) == 0) {
                this.genres_ = new ArrayList(this.genres_);
                this.bitField0_ |= 1;
            }
        }

        @Override // proto.GenreResultOrBuilder
        public List<Genre> getGenresList() {
            RepeatedFieldBuilder<Genre, Genre.Builder, GenreOrBuilder> repeatedFieldBuilder = this.genresBuilder_;
            if (repeatedFieldBuilder == null) {
                return Collections.unmodifiableList(this.genres_);
            }
            return repeatedFieldBuilder.getMessageList();
        }

        @Override // proto.GenreResultOrBuilder
        public int getGenresCount() {
            RepeatedFieldBuilder<Genre, Genre.Builder, GenreOrBuilder> repeatedFieldBuilder = this.genresBuilder_;
            if (repeatedFieldBuilder == null) {
                return this.genres_.size();
            }
            return repeatedFieldBuilder.getCount();
        }

        @Override // proto.GenreResultOrBuilder
        public Genre getGenres(int i) {
            RepeatedFieldBuilder<Genre, Genre.Builder, GenreOrBuilder> repeatedFieldBuilder = this.genresBuilder_;
            if (repeatedFieldBuilder == null) {
                return this.genres_.get(i);
            }
            return (Genre) repeatedFieldBuilder.getMessage(i);
        }

        public Builder setGenres(int i, Genre genre) {
            RepeatedFieldBuilder<Genre, Genre.Builder, GenreOrBuilder> repeatedFieldBuilder = this.genresBuilder_;
            if (repeatedFieldBuilder == null) {
                genre.getClass();
                ensureGenresIsMutable();
                this.genres_.set(i, genre);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.setMessage(i, genre);
            return this;
        }

        public Builder setGenres(int i, Genre.Builder builder) {
            RepeatedFieldBuilder<Genre, Genre.Builder, GenreOrBuilder> repeatedFieldBuilder = this.genresBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureGenresIsMutable();
                this.genres_.set(i, builder.build());
                onChanged();
                return this;
            }
            repeatedFieldBuilder.setMessage(i, builder.build());
            return this;
        }

        public Builder addGenres(Genre genre) {
            RepeatedFieldBuilder<Genre, Genre.Builder, GenreOrBuilder> repeatedFieldBuilder = this.genresBuilder_;
            if (repeatedFieldBuilder == null) {
                genre.getClass();
                ensureGenresIsMutable();
                this.genres_.add(genre);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(genre);
            return this;
        }

        public Builder addGenres(int i, Genre genre) {
            RepeatedFieldBuilder<Genre, Genre.Builder, GenreOrBuilder> repeatedFieldBuilder = this.genresBuilder_;
            if (repeatedFieldBuilder == null) {
                genre.getClass();
                ensureGenresIsMutable();
                this.genres_.add(i, genre);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(i, genre);
            return this;
        }

        public Builder addGenres(Genre.Builder builder) {
            RepeatedFieldBuilder<Genre, Genre.Builder, GenreOrBuilder> repeatedFieldBuilder = this.genresBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureGenresIsMutable();
                this.genres_.add(builder.build());
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(builder.build());
            return this;
        }

        public Builder addGenres(int i, Genre.Builder builder) {
            RepeatedFieldBuilder<Genre, Genre.Builder, GenreOrBuilder> repeatedFieldBuilder = this.genresBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureGenresIsMutable();
                this.genres_.add(i, builder.build());
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(i, builder.build());
            return this;
        }

        public Builder addAllGenres(Iterable<? extends Genre> iterable) {
            RepeatedFieldBuilder<Genre, Genre.Builder, GenreOrBuilder> repeatedFieldBuilder = this.genresBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureGenresIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) iterable, (List) this.genres_);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addAllMessages(iterable);
            return this;
        }

        public Builder clearGenres() {
            RepeatedFieldBuilder<Genre, Genre.Builder, GenreOrBuilder> repeatedFieldBuilder = this.genresBuilder_;
            if (repeatedFieldBuilder == null) {
                this.genres_ = Collections.emptyList();
                this.bitField0_ &= -2;
                onChanged();
                return this;
            }
            repeatedFieldBuilder.clear();
            return this;
        }

        public Builder removeGenres(int i) {
            RepeatedFieldBuilder<Genre, Genre.Builder, GenreOrBuilder> repeatedFieldBuilder = this.genresBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureGenresIsMutable();
                this.genres_.remove(i);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.remove(i);
            return this;
        }

        public Genre.Builder getGenresBuilder(int i) {
            return (Genre.Builder) getGenresFieldBuilder().getBuilder(i);
        }

        @Override // proto.GenreResultOrBuilder
        public GenreOrBuilder getGenresOrBuilder(int i) {
            RepeatedFieldBuilder<Genre, Genre.Builder, GenreOrBuilder> repeatedFieldBuilder = this.genresBuilder_;
            if (repeatedFieldBuilder == null) {
                return this.genres_.get(i);
            }
            return (GenreOrBuilder) repeatedFieldBuilder.getMessageOrBuilder(i);
        }

        @Override // proto.GenreResultOrBuilder
        public List<? extends GenreOrBuilder> getGenresOrBuilderList() {
            RepeatedFieldBuilder<Genre, Genre.Builder, GenreOrBuilder> repeatedFieldBuilder = this.genresBuilder_;
            if (repeatedFieldBuilder != null) {
                return repeatedFieldBuilder.getMessageOrBuilderList();
            }
            return Collections.unmodifiableList(this.genres_);
        }

        public Genre.Builder addGenresBuilder() {
            return (Genre.Builder) getGenresFieldBuilder().addBuilder(Genre.getDefaultInstance());
        }

        public Genre.Builder addGenresBuilder(int i) {
            return (Genre.Builder) getGenresFieldBuilder().addBuilder(i, Genre.getDefaultInstance());
        }

        public List<Genre.Builder> getGenresBuilderList() {
            return getGenresFieldBuilder().getBuilderList();
        }

        private RepeatedFieldBuilder<Genre, Genre.Builder, GenreOrBuilder> getGenresFieldBuilder() {
            if (this.genresBuilder_ == null) {
                this.genresBuilder_ = new RepeatedFieldBuilder<>(this.genres_, (this.bitField0_ & 1) != 0, getParentForChildren(), isClean());
                this.genres_ = null;
            }
            return this.genresBuilder_;
        }
    }

    public static GenreResult getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* INFO: renamed from: proto.GenreResult$1, reason: invalid class name */
    class AnonymousClass1 extends AbstractParser<GenreResult> {
        AnonymousClass1() {
        }

        @Override // com.google.protobuf.Parser
        public GenreResult parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            Builder builderNewBuilder = GenreResult.newBuilder();
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

    public static Parser<GenreResult> parser() {
        return PARSER;
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Parser<GenreResult> getParserForType() {
        return PARSER;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
    public GenreResult getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }
}
