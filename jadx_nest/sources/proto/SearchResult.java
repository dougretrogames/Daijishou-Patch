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
public final class SearchResult extends GeneratedMessage implements SearchResultOrBuilder {
    private static final SearchResult DEFAULT_INSTANCE;
    private static final Parser<SearchResult> PARSER;
    public static final int SEARCHES_FIELD_NUMBER = 1;
    private static final long serialVersionUID = 0;
    private List<Search> searches_;

    /* synthetic */ SearchResult(GeneratedMessage.Builder builder, SearchResultIA searchResultIA) {
        this(builder);
    }

    static {
        RuntimeVersion.validateProtobufGencodeVersion(RuntimeVersion.RuntimeDomain.PUBLIC, 4, 27, 2, "", SearchResult.class.getName());
        DEFAULT_INSTANCE = new SearchResult();
        PARSER = new AnonymousClass1();
    }

    private SearchResult(GeneratedMessage.Builder<?> builder) {
        super(builder);
    }

    private SearchResult() {
        this.searches_ = Collections.emptyList();
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return Igdbproto.internal_static_proto_SearchResult_descriptor;
    }

    @Override // com.google.protobuf.GeneratedMessage
    protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
        return Igdbproto.internal_static_proto_SearchResult_fieldAccessorTable.ensureFieldAccessorsInitialized(SearchResult.class, Builder.class);
    }

    @Override // proto.SearchResultOrBuilder
    public List<Search> getSearchesList() {
        return this.searches_;
    }

    @Override // proto.SearchResultOrBuilder
    public List<? extends SearchOrBuilder> getSearchesOrBuilderList() {
        return this.searches_;
    }

    @Override // proto.SearchResultOrBuilder
    public int getSearchesCount() {
        return this.searches_.size();
    }

    @Override // proto.SearchResultOrBuilder
    public Search getSearches(int i) {
        return this.searches_.get(i);
    }

    @Override // proto.SearchResultOrBuilder
    public SearchOrBuilder getSearchesOrBuilder(int i) {
        return this.searches_.get(i);
    }

    public static SearchResult parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer);
    }

    public static SearchResult parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    public static SearchResult parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString);
    }

    public static SearchResult parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static SearchResult parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr);
    }

    public static SearchResult parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr, extensionRegistryLite);
    }

    public static SearchResult parseFrom(InputStream inputStream) throws IOException {
        return (SearchResult) GeneratedMessage.parseWithIOException(PARSER, inputStream);
    }

    public static SearchResult parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (SearchResult) GeneratedMessage.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static SearchResult parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (SearchResult) GeneratedMessage.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static SearchResult parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (SearchResult) GeneratedMessage.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static SearchResult parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (SearchResult) GeneratedMessage.parseWithIOException(PARSER, codedInputStream);
    }

    public static SearchResult parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (SearchResult) GeneratedMessage.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder newBuilderForType() {
        return newBuilder();
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static Builder newBuilder(SearchResult searchResult) {
        return (Builder) DEFAULT_INSTANCE.toBuilder().mergeFrom((Message) searchResult);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder toBuilder() {
        return this == DEFAULT_INSTANCE ? new Builder((SearchResultIA) null) : (Builder) new Builder((SearchResultIA) null).mergeFrom((Message) this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.AbstractMessage
    public Builder newBuilderForType(AbstractMessage.BuilderParent builderParent) {
        return new Builder(builderParent, null);
    }

    public static final class Builder extends GeneratedMessage.Builder<Builder> implements SearchResultOrBuilder {
        private int bitField0_;
        private RepeatedFieldBuilder<Search, Search.Builder, SearchOrBuilder> searchesBuilder_;
        private List<Search> searches_;

        /* synthetic */ Builder(AbstractMessage.BuilderParent builderParent, SearchResultIA searchResultIA) {
            this(builderParent);
        }

        /* synthetic */ Builder(SearchResultIA searchResultIA) {
            this();
        }

        private void buildPartial0(SearchResult searchResult) {
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return Igdbproto.internal_static_proto_SearchResult_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder
        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return Igdbproto.internal_static_proto_SearchResult_fieldAccessorTable.ensureFieldAccessorsInitialized(SearchResult.class, Builder.class);
        }

        private Builder() {
            this.searches_ = Collections.emptyList();
        }

        private Builder(AbstractMessage.BuilderParent builderParent) {
            super(builderParent);
            this.searches_ = Collections.emptyList();
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder clear() {
            super.clear();
            this.bitField0_ = 0;
            RepeatedFieldBuilder<Search, Search.Builder, SearchOrBuilder> repeatedFieldBuilder = this.searchesBuilder_;
            if (repeatedFieldBuilder == null) {
                this.searches_ = Collections.emptyList();
            } else {
                this.searches_ = null;
                repeatedFieldBuilder.clear();
            }
            this.bitField0_ &= -2;
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
        public Descriptors.Descriptor getDescriptorForType() {
            return Igdbproto.internal_static_proto_SearchResult_descriptor;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public SearchResult getDefaultInstanceForType() {
            return SearchResult.getDefaultInstance();
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public SearchResult build() {
            SearchResult searchResultBuildPartial = buildPartial();
            if (searchResultBuildPartial.isInitialized()) {
                return searchResultBuildPartial;
            }
            throw newUninitializedMessageException((Message) searchResultBuildPartial);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public SearchResult buildPartial() {
            SearchResult searchResult = new SearchResult(this, null);
            buildPartialRepeatedFields(searchResult);
            if (this.bitField0_ != 0) {
                buildPartial0(searchResult);
            }
            onBuilt();
            return searchResult;
        }

        private void buildPartialRepeatedFields(SearchResult searchResult) {
            RepeatedFieldBuilder<Search, Search.Builder, SearchOrBuilder> repeatedFieldBuilder = this.searchesBuilder_;
            if (repeatedFieldBuilder == null) {
                if ((this.bitField0_ & 1) != 0) {
                    this.searches_ = Collections.unmodifiableList(this.searches_);
                    this.bitField0_ &= -2;
                }
                searchResult.searches_ = this.searches_;
                return;
            }
            searchResult.searches_ = repeatedFieldBuilder.build();
        }

        private void ensureSearchesIsMutable() {
            if ((this.bitField0_ & 1) == 0) {
                this.searches_ = new ArrayList(this.searches_);
                this.bitField0_ |= 1;
            }
        }

        @Override // proto.SearchResultOrBuilder
        public List<Search> getSearchesList() {
            RepeatedFieldBuilder<Search, Search.Builder, SearchOrBuilder> repeatedFieldBuilder = this.searchesBuilder_;
            if (repeatedFieldBuilder == null) {
                return Collections.unmodifiableList(this.searches_);
            }
            return repeatedFieldBuilder.getMessageList();
        }

        @Override // proto.SearchResultOrBuilder
        public int getSearchesCount() {
            RepeatedFieldBuilder<Search, Search.Builder, SearchOrBuilder> repeatedFieldBuilder = this.searchesBuilder_;
            if (repeatedFieldBuilder == null) {
                return this.searches_.size();
            }
            return repeatedFieldBuilder.getCount();
        }

        @Override // proto.SearchResultOrBuilder
        public Search getSearches(int i) {
            RepeatedFieldBuilder<Search, Search.Builder, SearchOrBuilder> repeatedFieldBuilder = this.searchesBuilder_;
            if (repeatedFieldBuilder == null) {
                return this.searches_.get(i);
            }
            return (Search) repeatedFieldBuilder.getMessage(i);
        }

        public Builder setSearches(int i, Search search) {
            RepeatedFieldBuilder<Search, Search.Builder, SearchOrBuilder> repeatedFieldBuilder = this.searchesBuilder_;
            if (repeatedFieldBuilder == null) {
                search.getClass();
                ensureSearchesIsMutable();
                this.searches_.set(i, search);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.setMessage(i, search);
            return this;
        }

        public Builder setSearches(int i, Search.Builder builder) {
            RepeatedFieldBuilder<Search, Search.Builder, SearchOrBuilder> repeatedFieldBuilder = this.searchesBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureSearchesIsMutable();
                this.searches_.set(i, builder.build());
                onChanged();
                return this;
            }
            repeatedFieldBuilder.setMessage(i, builder.build());
            return this;
        }

        public Builder addSearches(Search search) {
            RepeatedFieldBuilder<Search, Search.Builder, SearchOrBuilder> repeatedFieldBuilder = this.searchesBuilder_;
            if (repeatedFieldBuilder == null) {
                search.getClass();
                ensureSearchesIsMutable();
                this.searches_.add(search);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(search);
            return this;
        }

        public Builder addSearches(int i, Search search) {
            RepeatedFieldBuilder<Search, Search.Builder, SearchOrBuilder> repeatedFieldBuilder = this.searchesBuilder_;
            if (repeatedFieldBuilder == null) {
                search.getClass();
                ensureSearchesIsMutable();
                this.searches_.add(i, search);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(i, search);
            return this;
        }

        public Builder addSearches(Search.Builder builder) {
            RepeatedFieldBuilder<Search, Search.Builder, SearchOrBuilder> repeatedFieldBuilder = this.searchesBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureSearchesIsMutable();
                this.searches_.add(builder.build());
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(builder.build());
            return this;
        }

        public Builder addSearches(int i, Search.Builder builder) {
            RepeatedFieldBuilder<Search, Search.Builder, SearchOrBuilder> repeatedFieldBuilder = this.searchesBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureSearchesIsMutable();
                this.searches_.add(i, builder.build());
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(i, builder.build());
            return this;
        }

        public Builder addAllSearches(Iterable<? extends Search> iterable) {
            RepeatedFieldBuilder<Search, Search.Builder, SearchOrBuilder> repeatedFieldBuilder = this.searchesBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureSearchesIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) iterable, (List) this.searches_);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addAllMessages(iterable);
            return this;
        }

        public Builder clearSearches() {
            RepeatedFieldBuilder<Search, Search.Builder, SearchOrBuilder> repeatedFieldBuilder = this.searchesBuilder_;
            if (repeatedFieldBuilder == null) {
                this.searches_ = Collections.emptyList();
                this.bitField0_ &= -2;
                onChanged();
                return this;
            }
            repeatedFieldBuilder.clear();
            return this;
        }

        public Builder removeSearches(int i) {
            RepeatedFieldBuilder<Search, Search.Builder, SearchOrBuilder> repeatedFieldBuilder = this.searchesBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureSearchesIsMutable();
                this.searches_.remove(i);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.remove(i);
            return this;
        }

        public Search.Builder getSearchesBuilder(int i) {
            return (Search.Builder) getSearchesFieldBuilder().getBuilder(i);
        }

        @Override // proto.SearchResultOrBuilder
        public SearchOrBuilder getSearchesOrBuilder(int i) {
            RepeatedFieldBuilder<Search, Search.Builder, SearchOrBuilder> repeatedFieldBuilder = this.searchesBuilder_;
            if (repeatedFieldBuilder == null) {
                return this.searches_.get(i);
            }
            return (SearchOrBuilder) repeatedFieldBuilder.getMessageOrBuilder(i);
        }

        @Override // proto.SearchResultOrBuilder
        public List<? extends SearchOrBuilder> getSearchesOrBuilderList() {
            RepeatedFieldBuilder<Search, Search.Builder, SearchOrBuilder> repeatedFieldBuilder = this.searchesBuilder_;
            if (repeatedFieldBuilder != null) {
                return repeatedFieldBuilder.getMessageOrBuilderList();
            }
            return Collections.unmodifiableList(this.searches_);
        }

        public Search.Builder addSearchesBuilder() {
            return (Search.Builder) getSearchesFieldBuilder().addBuilder(Search.getDefaultInstance());
        }

        public Search.Builder addSearchesBuilder(int i) {
            return (Search.Builder) getSearchesFieldBuilder().addBuilder(i, Search.getDefaultInstance());
        }

        public List<Search.Builder> getSearchesBuilderList() {
            return getSearchesFieldBuilder().getBuilderList();
        }

        private RepeatedFieldBuilder<Search, Search.Builder, SearchOrBuilder> getSearchesFieldBuilder() {
            if (this.searchesBuilder_ == null) {
                this.searchesBuilder_ = new RepeatedFieldBuilder<>(this.searches_, (this.bitField0_ & 1) != 0, getParentForChildren(), isClean());
                this.searches_ = null;
            }
            return this.searchesBuilder_;
        }
    }

    public static SearchResult getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* JADX INFO: renamed from: proto.SearchResult$1, reason: invalid class name */
    class AnonymousClass1 extends AbstractParser<SearchResult> {
        AnonymousClass1() {
        }

        @Override // com.google.protobuf.Parser
        public SearchResult parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            Builder builderNewBuilder = SearchResult.newBuilder();
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

    public static Parser<SearchResult> parser() {
        return PARSER;
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Parser<SearchResult> getParserForType() {
        return PARSER;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
    public SearchResult getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }
}
