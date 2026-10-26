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
public final class ThemeResult extends GeneratedMessage implements ThemeResultOrBuilder {
    private static final ThemeResult DEFAULT_INSTANCE;
    private static final Parser<ThemeResult> PARSER;
    public static final int THEMES_FIELD_NUMBER = 1;
    private static final long serialVersionUID = 0;
    private List<Theme> themes_;

    /* synthetic */ ThemeResult(GeneratedMessage.Builder builder, ThemeResultIA themeResultIA) {
        this(builder);
    }

    static {
        RuntimeVersion.validateProtobufGencodeVersion(RuntimeVersion.RuntimeDomain.PUBLIC, 4, 27, 2, "", ThemeResult.class.getName());
        DEFAULT_INSTANCE = new ThemeResult();
        PARSER = new AnonymousClass1();
    }

    private ThemeResult(GeneratedMessage.Builder<?> builder) {
        super(builder);
    }

    private ThemeResult() {
        this.themes_ = Collections.emptyList();
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return Igdbproto.internal_static_proto_ThemeResult_descriptor;
    }

    @Override // com.google.protobuf.GeneratedMessage
    protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
        return Igdbproto.internal_static_proto_ThemeResult_fieldAccessorTable.ensureFieldAccessorsInitialized(ThemeResult.class, Builder.class);
    }

    @Override // proto.ThemeResultOrBuilder
    public List<Theme> getThemesList() {
        return this.themes_;
    }

    @Override // proto.ThemeResultOrBuilder
    public List<? extends ThemeOrBuilder> getThemesOrBuilderList() {
        return this.themes_;
    }

    @Override // proto.ThemeResultOrBuilder
    public int getThemesCount() {
        return this.themes_.size();
    }

    @Override // proto.ThemeResultOrBuilder
    public Theme getThemes(int i) {
        return this.themes_.get(i);
    }

    @Override // proto.ThemeResultOrBuilder
    public ThemeOrBuilder getThemesOrBuilder(int i) {
        return this.themes_.get(i);
    }

    public static ThemeResult parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer);
    }

    public static ThemeResult parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    public static ThemeResult parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString);
    }

    public static ThemeResult parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static ThemeResult parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr);
    }

    public static ThemeResult parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr, extensionRegistryLite);
    }

    public static ThemeResult parseFrom(InputStream inputStream) throws IOException {
        return (ThemeResult) GeneratedMessage.parseWithIOException(PARSER, inputStream);
    }

    public static ThemeResult parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (ThemeResult) GeneratedMessage.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static ThemeResult parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (ThemeResult) GeneratedMessage.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static ThemeResult parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (ThemeResult) GeneratedMessage.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static ThemeResult parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (ThemeResult) GeneratedMessage.parseWithIOException(PARSER, codedInputStream);
    }

    public static ThemeResult parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (ThemeResult) GeneratedMessage.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder newBuilderForType() {
        return newBuilder();
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    /* WARN: Multi-variable type inference failed */
    public static Builder newBuilder(ThemeResult themeResult) {
        return (Builder) DEFAULT_INSTANCE.toBuilder().mergeFrom((Message) themeResult);
    }

    /* WARN: Multi-variable type inference failed */
    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder toBuilder() {
        return this == DEFAULT_INSTANCE ? new Builder((ThemeResultIA) null) : (Builder) new Builder((ThemeResultIA) null).mergeFrom((Message) this);
    }

    /* INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.AbstractMessage
    public Builder newBuilderForType(AbstractMessage.BuilderParent builderParent) {
        return new Builder(builderParent, null);
    }

    public static final class Builder extends GeneratedMessage.Builder<Builder> implements ThemeResultOrBuilder {
        private int bitField0_;
        private RepeatedFieldBuilder<Theme, Theme.Builder, ThemeOrBuilder> themesBuilder_;
        private List<Theme> themes_;

        /* synthetic */ Builder(AbstractMessage.BuilderParent builderParent, ThemeResultIA themeResultIA) {
            this(builderParent);
        }

        /* synthetic */ Builder(ThemeResultIA themeResultIA) {
            this();
        }

        private void buildPartial0(ThemeResult themeResult) {
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return Igdbproto.internal_static_proto_ThemeResult_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder
        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return Igdbproto.internal_static_proto_ThemeResult_fieldAccessorTable.ensureFieldAccessorsInitialized(ThemeResult.class, Builder.class);
        }

        private Builder() {
            this.themes_ = Collections.emptyList();
        }

        private Builder(AbstractMessage.BuilderParent builderParent) {
            super(builderParent);
            this.themes_ = Collections.emptyList();
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder clear() {
            super.clear();
            this.bitField0_ = 0;
            RepeatedFieldBuilder<Theme, Theme.Builder, ThemeOrBuilder> repeatedFieldBuilder = this.themesBuilder_;
            if (repeatedFieldBuilder == null) {
                this.themes_ = Collections.emptyList();
            } else {
                this.themes_ = null;
                repeatedFieldBuilder.clear();
            }
            this.bitField0_ &= -2;
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
        public Descriptors.Descriptor getDescriptorForType() {
            return Igdbproto.internal_static_proto_ThemeResult_descriptor;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public ThemeResult getDefaultInstanceForType() {
            return ThemeResult.getDefaultInstance();
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public ThemeResult build() {
            ThemeResult themeResultBuildPartial = buildPartial();
            if (themeResultBuildPartial.isInitialized()) {
                return themeResultBuildPartial;
            }
            throw newUninitializedMessageException((Message) themeResultBuildPartial);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public ThemeResult buildPartial() {
            ThemeResult themeResult = new ThemeResult(this, null);
            buildPartialRepeatedFields(themeResult);
            if (this.bitField0_ != 0) {
                buildPartial0(themeResult);
            }
            onBuilt();
            return themeResult;
        }

        private void buildPartialRepeatedFields(ThemeResult themeResult) {
            RepeatedFieldBuilder<Theme, Theme.Builder, ThemeOrBuilder> repeatedFieldBuilder = this.themesBuilder_;
            if (repeatedFieldBuilder == null) {
                if ((this.bitField0_ & 1) != 0) {
                    this.themes_ = Collections.unmodifiableList(this.themes_);
                    this.bitField0_ &= -2;
                }
                themeResult.themes_ = this.themes_;
                return;
            }
            themeResult.themes_ = repeatedFieldBuilder.build();
        }

        private void ensureThemesIsMutable() {
            if ((this.bitField0_ & 1) == 0) {
                this.themes_ = new ArrayList(this.themes_);
                this.bitField0_ |= 1;
            }
        }

        @Override // proto.ThemeResultOrBuilder
        public List<Theme> getThemesList() {
            RepeatedFieldBuilder<Theme, Theme.Builder, ThemeOrBuilder> repeatedFieldBuilder = this.themesBuilder_;
            if (repeatedFieldBuilder == null) {
                return Collections.unmodifiableList(this.themes_);
            }
            return repeatedFieldBuilder.getMessageList();
        }

        @Override // proto.ThemeResultOrBuilder
        public int getThemesCount() {
            RepeatedFieldBuilder<Theme, Theme.Builder, ThemeOrBuilder> repeatedFieldBuilder = this.themesBuilder_;
            if (repeatedFieldBuilder == null) {
                return this.themes_.size();
            }
            return repeatedFieldBuilder.getCount();
        }

        @Override // proto.ThemeResultOrBuilder
        public Theme getThemes(int i) {
            RepeatedFieldBuilder<Theme, Theme.Builder, ThemeOrBuilder> repeatedFieldBuilder = this.themesBuilder_;
            if (repeatedFieldBuilder == null) {
                return this.themes_.get(i);
            }
            return (Theme) repeatedFieldBuilder.getMessage(i);
        }

        public Builder setThemes(int i, Theme theme) {
            RepeatedFieldBuilder<Theme, Theme.Builder, ThemeOrBuilder> repeatedFieldBuilder = this.themesBuilder_;
            if (repeatedFieldBuilder == null) {
                theme.getClass();
                ensureThemesIsMutable();
                this.themes_.set(i, theme);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.setMessage(i, theme);
            return this;
        }

        public Builder setThemes(int i, Theme.Builder builder) {
            RepeatedFieldBuilder<Theme, Theme.Builder, ThemeOrBuilder> repeatedFieldBuilder = this.themesBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureThemesIsMutable();
                this.themes_.set(i, builder.build());
                onChanged();
                return this;
            }
            repeatedFieldBuilder.setMessage(i, builder.build());
            return this;
        }

        public Builder addThemes(Theme theme) {
            RepeatedFieldBuilder<Theme, Theme.Builder, ThemeOrBuilder> repeatedFieldBuilder = this.themesBuilder_;
            if (repeatedFieldBuilder == null) {
                theme.getClass();
                ensureThemesIsMutable();
                this.themes_.add(theme);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(theme);
            return this;
        }

        public Builder addThemes(int i, Theme theme) {
            RepeatedFieldBuilder<Theme, Theme.Builder, ThemeOrBuilder> repeatedFieldBuilder = this.themesBuilder_;
            if (repeatedFieldBuilder == null) {
                theme.getClass();
                ensureThemesIsMutable();
                this.themes_.add(i, theme);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(i, theme);
            return this;
        }

        public Builder addThemes(Theme.Builder builder) {
            RepeatedFieldBuilder<Theme, Theme.Builder, ThemeOrBuilder> repeatedFieldBuilder = this.themesBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureThemesIsMutable();
                this.themes_.add(builder.build());
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(builder.build());
            return this;
        }

        public Builder addThemes(int i, Theme.Builder builder) {
            RepeatedFieldBuilder<Theme, Theme.Builder, ThemeOrBuilder> repeatedFieldBuilder = this.themesBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureThemesIsMutable();
                this.themes_.add(i, builder.build());
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(i, builder.build());
            return this;
        }

        public Builder addAllThemes(Iterable<? extends Theme> iterable) {
            RepeatedFieldBuilder<Theme, Theme.Builder, ThemeOrBuilder> repeatedFieldBuilder = this.themesBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureThemesIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) iterable, (List) this.themes_);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addAllMessages(iterable);
            return this;
        }

        public Builder clearThemes() {
            RepeatedFieldBuilder<Theme, Theme.Builder, ThemeOrBuilder> repeatedFieldBuilder = this.themesBuilder_;
            if (repeatedFieldBuilder == null) {
                this.themes_ = Collections.emptyList();
                this.bitField0_ &= -2;
                onChanged();
                return this;
            }
            repeatedFieldBuilder.clear();
            return this;
        }

        public Builder removeThemes(int i) {
            RepeatedFieldBuilder<Theme, Theme.Builder, ThemeOrBuilder> repeatedFieldBuilder = this.themesBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureThemesIsMutable();
                this.themes_.remove(i);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.remove(i);
            return this;
        }

        public Theme.Builder getThemesBuilder(int i) {
            return (Theme.Builder) getThemesFieldBuilder().getBuilder(i);
        }

        @Override // proto.ThemeResultOrBuilder
        public ThemeOrBuilder getThemesOrBuilder(int i) {
            RepeatedFieldBuilder<Theme, Theme.Builder, ThemeOrBuilder> repeatedFieldBuilder = this.themesBuilder_;
            if (repeatedFieldBuilder == null) {
                return this.themes_.get(i);
            }
            return (ThemeOrBuilder) repeatedFieldBuilder.getMessageOrBuilder(i);
        }

        @Override // proto.ThemeResultOrBuilder
        public List<? extends ThemeOrBuilder> getThemesOrBuilderList() {
            RepeatedFieldBuilder<Theme, Theme.Builder, ThemeOrBuilder> repeatedFieldBuilder = this.themesBuilder_;
            if (repeatedFieldBuilder != null) {
                return repeatedFieldBuilder.getMessageOrBuilderList();
            }
            return Collections.unmodifiableList(this.themes_);
        }

        public Theme.Builder addThemesBuilder() {
            return (Theme.Builder) getThemesFieldBuilder().addBuilder(Theme.getDefaultInstance());
        }

        public Theme.Builder addThemesBuilder(int i) {
            return (Theme.Builder) getThemesFieldBuilder().addBuilder(i, Theme.getDefaultInstance());
        }

        public List<Theme.Builder> getThemesBuilderList() {
            return getThemesFieldBuilder().getBuilderList();
        }

        private RepeatedFieldBuilder<Theme, Theme.Builder, ThemeOrBuilder> getThemesFieldBuilder() {
            if (this.themesBuilder_ == null) {
                this.themesBuilder_ = new RepeatedFieldBuilder<>(this.themes_, (this.bitField0_ & 1) != 0, getParentForChildren(), isClean());
                this.themes_ = null;
            }
            return this.themesBuilder_;
        }
    }

    public static ThemeResult getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* INFO: renamed from: proto.ThemeResult$1, reason: invalid class name */
    class AnonymousClass1 extends AbstractParser<ThemeResult> {
        AnonymousClass1() {
        }

        @Override // com.google.protobuf.Parser
        public ThemeResult parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            Builder builderNewBuilder = ThemeResult.newBuilder();
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

    public static Parser<ThemeResult> parser() {
        return PARSER;
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Parser<ThemeResult> getParserForType() {
        return PARSER;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
    public ThemeResult getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }
}
