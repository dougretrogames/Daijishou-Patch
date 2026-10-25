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
public final class CharacterResult extends GeneratedMessage implements CharacterResultOrBuilder {
    public static final int CHARACTERS_FIELD_NUMBER = 1;
    private static final CharacterResult DEFAULT_INSTANCE;
    private static final Parser<CharacterResult> PARSER;
    private static final long serialVersionUID = 0;
    private List<Character> characters_;

    /* synthetic */ CharacterResult(GeneratedMessage.Builder builder, CharacterResultIA characterResultIA) {
        this(builder);
    }

    static {
        RuntimeVersion.validateProtobufGencodeVersion(RuntimeVersion.RuntimeDomain.PUBLIC, 4, 27, 2, "", CharacterResult.class.getName());
        DEFAULT_INSTANCE = new CharacterResult();
        PARSER = new AnonymousClass1();
    }

    private CharacterResult(GeneratedMessage.Builder<?> builder) {
        super(builder);
    }

    private CharacterResult() {
        this.characters_ = Collections.emptyList();
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return Igdbproto.internal_static_proto_CharacterResult_descriptor;
    }

    @Override // com.google.protobuf.GeneratedMessage
    protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
        return Igdbproto.internal_static_proto_CharacterResult_fieldAccessorTable.ensureFieldAccessorsInitialized(CharacterResult.class, Builder.class);
    }

    @Override // proto.CharacterResultOrBuilder
    public List<Character> getCharactersList() {
        return this.characters_;
    }

    @Override // proto.CharacterResultOrBuilder
    public List<? extends CharacterOrBuilder> getCharactersOrBuilderList() {
        return this.characters_;
    }

    @Override // proto.CharacterResultOrBuilder
    public int getCharactersCount() {
        return this.characters_.size();
    }

    @Override // proto.CharacterResultOrBuilder
    public Character getCharacters(int i) {
        return this.characters_.get(i);
    }

    @Override // proto.CharacterResultOrBuilder
    public CharacterOrBuilder getCharactersOrBuilder(int i) {
        return this.characters_.get(i);
    }

    public static CharacterResult parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer);
    }

    public static CharacterResult parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    public static CharacterResult parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString);
    }

    public static CharacterResult parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static CharacterResult parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr);
    }

    public static CharacterResult parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr, extensionRegistryLite);
    }

    public static CharacterResult parseFrom(InputStream inputStream) throws IOException {
        return (CharacterResult) GeneratedMessage.parseWithIOException(PARSER, inputStream);
    }

    public static CharacterResult parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (CharacterResult) GeneratedMessage.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static CharacterResult parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (CharacterResult) GeneratedMessage.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static CharacterResult parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (CharacterResult) GeneratedMessage.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static CharacterResult parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (CharacterResult) GeneratedMessage.parseWithIOException(PARSER, codedInputStream);
    }

    public static CharacterResult parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (CharacterResult) GeneratedMessage.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder newBuilderForType() {
        return newBuilder();
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static Builder newBuilder(CharacterResult characterResult) {
        return (Builder) DEFAULT_INSTANCE.toBuilder().mergeFrom((Message) characterResult);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder toBuilder() {
        return this == DEFAULT_INSTANCE ? new Builder((CharacterResultIA) null) : (Builder) new Builder((CharacterResultIA) null).mergeFrom((Message) this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.AbstractMessage
    public Builder newBuilderForType(AbstractMessage.BuilderParent builderParent) {
        return new Builder(builderParent, null);
    }

    public static final class Builder extends GeneratedMessage.Builder<Builder> implements CharacterResultOrBuilder {
        private int bitField0_;
        private RepeatedFieldBuilder<Character, Character.Builder, CharacterOrBuilder> charactersBuilder_;
        private List<Character> characters_;

        /* synthetic */ Builder(AbstractMessage.BuilderParent builderParent, CharacterResultIA characterResultIA) {
            this(builderParent);
        }

        /* synthetic */ Builder(CharacterResultIA characterResultIA) {
            this();
        }

        private void buildPartial0(CharacterResult characterResult) {
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return Igdbproto.internal_static_proto_CharacterResult_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder
        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return Igdbproto.internal_static_proto_CharacterResult_fieldAccessorTable.ensureFieldAccessorsInitialized(CharacterResult.class, Builder.class);
        }

        private Builder() {
            this.characters_ = Collections.emptyList();
        }

        private Builder(AbstractMessage.BuilderParent builderParent) {
            super(builderParent);
            this.characters_ = Collections.emptyList();
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder clear() {
            super.clear();
            this.bitField0_ = 0;
            RepeatedFieldBuilder<Character, Character.Builder, CharacterOrBuilder> repeatedFieldBuilder = this.charactersBuilder_;
            if (repeatedFieldBuilder == null) {
                this.characters_ = Collections.emptyList();
            } else {
                this.characters_ = null;
                repeatedFieldBuilder.clear();
            }
            this.bitField0_ &= -2;
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
        public Descriptors.Descriptor getDescriptorForType() {
            return Igdbproto.internal_static_proto_CharacterResult_descriptor;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public CharacterResult getDefaultInstanceForType() {
            return CharacterResult.getDefaultInstance();
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public CharacterResult build() {
            CharacterResult characterResultBuildPartial = buildPartial();
            if (characterResultBuildPartial.isInitialized()) {
                return characterResultBuildPartial;
            }
            throw newUninitializedMessageException((Message) characterResultBuildPartial);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public CharacterResult buildPartial() {
            CharacterResult characterResult = new CharacterResult(this, null);
            buildPartialRepeatedFields(characterResult);
            if (this.bitField0_ != 0) {
                buildPartial0(characterResult);
            }
            onBuilt();
            return characterResult;
        }

        private void buildPartialRepeatedFields(CharacterResult characterResult) {
            RepeatedFieldBuilder<Character, Character.Builder, CharacterOrBuilder> repeatedFieldBuilder = this.charactersBuilder_;
            if (repeatedFieldBuilder == null) {
                if ((this.bitField0_ & 1) != 0) {
                    this.characters_ = Collections.unmodifiableList(this.characters_);
                    this.bitField0_ &= -2;
                }
                characterResult.characters_ = this.characters_;
                return;
            }
            characterResult.characters_ = repeatedFieldBuilder.build();
        }

        private void ensureCharactersIsMutable() {
            if ((this.bitField0_ & 1) == 0) {
                this.characters_ = new ArrayList(this.characters_);
                this.bitField0_ |= 1;
            }
        }

        @Override // proto.CharacterResultOrBuilder
        public List<Character> getCharactersList() {
            RepeatedFieldBuilder<Character, Character.Builder, CharacterOrBuilder> repeatedFieldBuilder = this.charactersBuilder_;
            if (repeatedFieldBuilder == null) {
                return Collections.unmodifiableList(this.characters_);
            }
            return repeatedFieldBuilder.getMessageList();
        }

        @Override // proto.CharacterResultOrBuilder
        public int getCharactersCount() {
            RepeatedFieldBuilder<Character, Character.Builder, CharacterOrBuilder> repeatedFieldBuilder = this.charactersBuilder_;
            if (repeatedFieldBuilder == null) {
                return this.characters_.size();
            }
            return repeatedFieldBuilder.getCount();
        }

        @Override // proto.CharacterResultOrBuilder
        public Character getCharacters(int i) {
            RepeatedFieldBuilder<Character, Character.Builder, CharacterOrBuilder> repeatedFieldBuilder = this.charactersBuilder_;
            if (repeatedFieldBuilder == null) {
                return this.characters_.get(i);
            }
            return (Character) repeatedFieldBuilder.getMessage(i);
        }

        public Builder setCharacters(int i, Character character) {
            RepeatedFieldBuilder<Character, Character.Builder, CharacterOrBuilder> repeatedFieldBuilder = this.charactersBuilder_;
            if (repeatedFieldBuilder == null) {
                character.getClass();
                ensureCharactersIsMutable();
                this.characters_.set(i, character);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.setMessage(i, character);
            return this;
        }

        public Builder setCharacters(int i, Character.Builder builder) {
            RepeatedFieldBuilder<Character, Character.Builder, CharacterOrBuilder> repeatedFieldBuilder = this.charactersBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureCharactersIsMutable();
                this.characters_.set(i, builder.build());
                onChanged();
                return this;
            }
            repeatedFieldBuilder.setMessage(i, builder.build());
            return this;
        }

        public Builder addCharacters(Character character) {
            RepeatedFieldBuilder<Character, Character.Builder, CharacterOrBuilder> repeatedFieldBuilder = this.charactersBuilder_;
            if (repeatedFieldBuilder == null) {
                character.getClass();
                ensureCharactersIsMutable();
                this.characters_.add(character);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(character);
            return this;
        }

        public Builder addCharacters(int i, Character character) {
            RepeatedFieldBuilder<Character, Character.Builder, CharacterOrBuilder> repeatedFieldBuilder = this.charactersBuilder_;
            if (repeatedFieldBuilder == null) {
                character.getClass();
                ensureCharactersIsMutable();
                this.characters_.add(i, character);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(i, character);
            return this;
        }

        public Builder addCharacters(Character.Builder builder) {
            RepeatedFieldBuilder<Character, Character.Builder, CharacterOrBuilder> repeatedFieldBuilder = this.charactersBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureCharactersIsMutable();
                this.characters_.add(builder.build());
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(builder.build());
            return this;
        }

        public Builder addCharacters(int i, Character.Builder builder) {
            RepeatedFieldBuilder<Character, Character.Builder, CharacterOrBuilder> repeatedFieldBuilder = this.charactersBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureCharactersIsMutable();
                this.characters_.add(i, builder.build());
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(i, builder.build());
            return this;
        }

        public Builder addAllCharacters(Iterable<? extends Character> iterable) {
            RepeatedFieldBuilder<Character, Character.Builder, CharacterOrBuilder> repeatedFieldBuilder = this.charactersBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureCharactersIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) iterable, (List) this.characters_);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addAllMessages(iterable);
            return this;
        }

        public Builder clearCharacters() {
            RepeatedFieldBuilder<Character, Character.Builder, CharacterOrBuilder> repeatedFieldBuilder = this.charactersBuilder_;
            if (repeatedFieldBuilder == null) {
                this.characters_ = Collections.emptyList();
                this.bitField0_ &= -2;
                onChanged();
                return this;
            }
            repeatedFieldBuilder.clear();
            return this;
        }

        public Builder removeCharacters(int i) {
            RepeatedFieldBuilder<Character, Character.Builder, CharacterOrBuilder> repeatedFieldBuilder = this.charactersBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureCharactersIsMutable();
                this.characters_.remove(i);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.remove(i);
            return this;
        }

        public Character.Builder getCharactersBuilder(int i) {
            return (Character.Builder) getCharactersFieldBuilder().getBuilder(i);
        }

        @Override // proto.CharacterResultOrBuilder
        public CharacterOrBuilder getCharactersOrBuilder(int i) {
            RepeatedFieldBuilder<Character, Character.Builder, CharacterOrBuilder> repeatedFieldBuilder = this.charactersBuilder_;
            if (repeatedFieldBuilder == null) {
                return this.characters_.get(i);
            }
            return (CharacterOrBuilder) repeatedFieldBuilder.getMessageOrBuilder(i);
        }

        @Override // proto.CharacterResultOrBuilder
        public List<? extends CharacterOrBuilder> getCharactersOrBuilderList() {
            RepeatedFieldBuilder<Character, Character.Builder, CharacterOrBuilder> repeatedFieldBuilder = this.charactersBuilder_;
            if (repeatedFieldBuilder != null) {
                return repeatedFieldBuilder.getMessageOrBuilderList();
            }
            return Collections.unmodifiableList(this.characters_);
        }

        public Character.Builder addCharactersBuilder() {
            return (Character.Builder) getCharactersFieldBuilder().addBuilder(Character.getDefaultInstance());
        }

        public Character.Builder addCharactersBuilder(int i) {
            return (Character.Builder) getCharactersFieldBuilder().addBuilder(i, Character.getDefaultInstance());
        }

        public List<Character.Builder> getCharactersBuilderList() {
            return getCharactersFieldBuilder().getBuilderList();
        }

        private RepeatedFieldBuilder<Character, Character.Builder, CharacterOrBuilder> getCharactersFieldBuilder() {
            if (this.charactersBuilder_ == null) {
                this.charactersBuilder_ = new RepeatedFieldBuilder<>(this.characters_, (this.bitField0_ & 1) != 0, getParentForChildren(), isClean());
                this.characters_ = null;
            }
            return this.charactersBuilder_;
        }
    }

    public static CharacterResult getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* JADX INFO: renamed from: proto.CharacterResult$1, reason: invalid class name */
    class AnonymousClass1 extends AbstractParser<CharacterResult> {
        AnonymousClass1() {
        }

        @Override // com.google.protobuf.Parser
        public CharacterResult parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            Builder builderNewBuilder = CharacterResult.newBuilder();
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

    public static Parser<CharacterResult> parser() {
        return PARSER;
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Parser<CharacterResult> getParserForType() {
        return PARSER;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
    public CharacterResult getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }
}
