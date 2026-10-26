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
public final class CharacterMugShotResult extends GeneratedMessage implements CharacterMugShotResultOrBuilder {
    public static final int CHARACTERMUGSHOTS_FIELD_NUMBER = 1;
    private static final CharacterMugShotResult DEFAULT_INSTANCE;
    private static final Parser<CharacterMugShotResult> PARSER;
    private static final long serialVersionUID = 0;
    private List<CharacterMugShot> charactermugshots_;

    /* synthetic */ CharacterMugShotResult(GeneratedMessage.Builder builder, CharacterMugShotResultIA characterMugShotResultIA) {
        this(builder);
    }

    static {
        RuntimeVersion.validateProtobufGencodeVersion(RuntimeVersion.RuntimeDomain.PUBLIC, 4, 27, 2, "", CharacterMugShotResult.class.getName());
        DEFAULT_INSTANCE = new CharacterMugShotResult();
        PARSER = new AnonymousClass1();
    }

    private CharacterMugShotResult(GeneratedMessage.Builder<?> builder) {
        super(builder);
    }

    private CharacterMugShotResult() {
        this.charactermugshots_ = Collections.emptyList();
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return Igdbproto.internal_static_proto_CharacterMugShotResult_descriptor;
    }

    @Override // com.google.protobuf.GeneratedMessage
    protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
        return Igdbproto.internal_static_proto_CharacterMugShotResult_fieldAccessorTable.ensureFieldAccessorsInitialized(CharacterMugShotResult.class, Builder.class);
    }

    @Override // proto.CharacterMugShotResultOrBuilder
    public List<CharacterMugShot> getCharactermugshotsList() {
        return this.charactermugshots_;
    }

    @Override // proto.CharacterMugShotResultOrBuilder
    public List<? extends CharacterMugShotOrBuilder> getCharactermugshotsOrBuilderList() {
        return this.charactermugshots_;
    }

    @Override // proto.CharacterMugShotResultOrBuilder
    public int getCharactermugshotsCount() {
        return this.charactermugshots_.size();
    }

    @Override // proto.CharacterMugShotResultOrBuilder
    public CharacterMugShot getCharactermugshots(int i) {
        return this.charactermugshots_.get(i);
    }

    @Override // proto.CharacterMugShotResultOrBuilder
    public CharacterMugShotOrBuilder getCharactermugshotsOrBuilder(int i) {
        return this.charactermugshots_.get(i);
    }

    public static CharacterMugShotResult parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer);
    }

    public static CharacterMugShotResult parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    public static CharacterMugShotResult parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString);
    }

    public static CharacterMugShotResult parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static CharacterMugShotResult parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr);
    }

    public static CharacterMugShotResult parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr, extensionRegistryLite);
    }

    public static CharacterMugShotResult parseFrom(InputStream inputStream) throws IOException {
        return (CharacterMugShotResult) GeneratedMessage.parseWithIOException(PARSER, inputStream);
    }

    public static CharacterMugShotResult parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (CharacterMugShotResult) GeneratedMessage.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static CharacterMugShotResult parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (CharacterMugShotResult) GeneratedMessage.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static CharacterMugShotResult parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (CharacterMugShotResult) GeneratedMessage.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static CharacterMugShotResult parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (CharacterMugShotResult) GeneratedMessage.parseWithIOException(PARSER, codedInputStream);
    }

    public static CharacterMugShotResult parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (CharacterMugShotResult) GeneratedMessage.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder newBuilderForType() {
        return newBuilder();
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    /* WARN: Multi-variable type inference failed */
    public static Builder newBuilder(CharacterMugShotResult characterMugShotResult) {
        return (Builder) DEFAULT_INSTANCE.toBuilder().mergeFrom((Message) characterMugShotResult);
    }

    /* WARN: Multi-variable type inference failed */
    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder toBuilder() {
        return this == DEFAULT_INSTANCE ? new Builder((CharacterMugShotResultIA) null) : (Builder) new Builder((CharacterMugShotResultIA) null).mergeFrom((Message) this);
    }

    /* INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.AbstractMessage
    public Builder newBuilderForType(AbstractMessage.BuilderParent builderParent) {
        return new Builder(builderParent, null);
    }

    public static final class Builder extends GeneratedMessage.Builder<Builder> implements CharacterMugShotResultOrBuilder {
        private int bitField0_;
        private RepeatedFieldBuilder<CharacterMugShot, CharacterMugShot.Builder, CharacterMugShotOrBuilder> charactermugshotsBuilder_;
        private List<CharacterMugShot> charactermugshots_;

        /* synthetic */ Builder(AbstractMessage.BuilderParent builderParent, CharacterMugShotResultIA characterMugShotResultIA) {
            this(builderParent);
        }

        /* synthetic */ Builder(CharacterMugShotResultIA characterMugShotResultIA) {
            this();
        }

        private void buildPartial0(CharacterMugShotResult characterMugShotResult) {
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return Igdbproto.internal_static_proto_CharacterMugShotResult_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder
        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return Igdbproto.internal_static_proto_CharacterMugShotResult_fieldAccessorTable.ensureFieldAccessorsInitialized(CharacterMugShotResult.class, Builder.class);
        }

        private Builder() {
            this.charactermugshots_ = Collections.emptyList();
        }

        private Builder(AbstractMessage.BuilderParent builderParent) {
            super(builderParent);
            this.charactermugshots_ = Collections.emptyList();
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder clear() {
            super.clear();
            this.bitField0_ = 0;
            RepeatedFieldBuilder<CharacterMugShot, CharacterMugShot.Builder, CharacterMugShotOrBuilder> repeatedFieldBuilder = this.charactermugshotsBuilder_;
            if (repeatedFieldBuilder == null) {
                this.charactermugshots_ = Collections.emptyList();
            } else {
                this.charactermugshots_ = null;
                repeatedFieldBuilder.clear();
            }
            this.bitField0_ &= -2;
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
        public Descriptors.Descriptor getDescriptorForType() {
            return Igdbproto.internal_static_proto_CharacterMugShotResult_descriptor;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public CharacterMugShotResult getDefaultInstanceForType() {
            return CharacterMugShotResult.getDefaultInstance();
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public CharacterMugShotResult build() {
            CharacterMugShotResult characterMugShotResultBuildPartial = buildPartial();
            if (characterMugShotResultBuildPartial.isInitialized()) {
                return characterMugShotResultBuildPartial;
            }
            throw newUninitializedMessageException((Message) characterMugShotResultBuildPartial);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public CharacterMugShotResult buildPartial() {
            CharacterMugShotResult characterMugShotResult = new CharacterMugShotResult(this, null);
            buildPartialRepeatedFields(characterMugShotResult);
            if (this.bitField0_ != 0) {
                buildPartial0(characterMugShotResult);
            }
            onBuilt();
            return characterMugShotResult;
        }

        private void buildPartialRepeatedFields(CharacterMugShotResult characterMugShotResult) {
            RepeatedFieldBuilder<CharacterMugShot, CharacterMugShot.Builder, CharacterMugShotOrBuilder> repeatedFieldBuilder = this.charactermugshotsBuilder_;
            if (repeatedFieldBuilder == null) {
                if ((this.bitField0_ & 1) != 0) {
                    this.charactermugshots_ = Collections.unmodifiableList(this.charactermugshots_);
                    this.bitField0_ &= -2;
                }
                characterMugShotResult.charactermugshots_ = this.charactermugshots_;
                return;
            }
            characterMugShotResult.charactermugshots_ = repeatedFieldBuilder.build();
        }

        private void ensureCharactermugshotsIsMutable() {
            if ((this.bitField0_ & 1) == 0) {
                this.charactermugshots_ = new ArrayList(this.charactermugshots_);
                this.bitField0_ |= 1;
            }
        }

        @Override // proto.CharacterMugShotResultOrBuilder
        public List<CharacterMugShot> getCharactermugshotsList() {
            RepeatedFieldBuilder<CharacterMugShot, CharacterMugShot.Builder, CharacterMugShotOrBuilder> repeatedFieldBuilder = this.charactermugshotsBuilder_;
            if (repeatedFieldBuilder == null) {
                return Collections.unmodifiableList(this.charactermugshots_);
            }
            return repeatedFieldBuilder.getMessageList();
        }

        @Override // proto.CharacterMugShotResultOrBuilder
        public int getCharactermugshotsCount() {
            RepeatedFieldBuilder<CharacterMugShot, CharacterMugShot.Builder, CharacterMugShotOrBuilder> repeatedFieldBuilder = this.charactermugshotsBuilder_;
            if (repeatedFieldBuilder == null) {
                return this.charactermugshots_.size();
            }
            return repeatedFieldBuilder.getCount();
        }

        @Override // proto.CharacterMugShotResultOrBuilder
        public CharacterMugShot getCharactermugshots(int i) {
            RepeatedFieldBuilder<CharacterMugShot, CharacterMugShot.Builder, CharacterMugShotOrBuilder> repeatedFieldBuilder = this.charactermugshotsBuilder_;
            if (repeatedFieldBuilder == null) {
                return this.charactermugshots_.get(i);
            }
            return (CharacterMugShot) repeatedFieldBuilder.getMessage(i);
        }

        public Builder setCharactermugshots(int i, CharacterMugShot characterMugShot) {
            RepeatedFieldBuilder<CharacterMugShot, CharacterMugShot.Builder, CharacterMugShotOrBuilder> repeatedFieldBuilder = this.charactermugshotsBuilder_;
            if (repeatedFieldBuilder == null) {
                characterMugShot.getClass();
                ensureCharactermugshotsIsMutable();
                this.charactermugshots_.set(i, characterMugShot);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.setMessage(i, characterMugShot);
            return this;
        }

        public Builder setCharactermugshots(int i, CharacterMugShot.Builder builder) {
            RepeatedFieldBuilder<CharacterMugShot, CharacterMugShot.Builder, CharacterMugShotOrBuilder> repeatedFieldBuilder = this.charactermugshotsBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureCharactermugshotsIsMutable();
                this.charactermugshots_.set(i, builder.build());
                onChanged();
                return this;
            }
            repeatedFieldBuilder.setMessage(i, builder.build());
            return this;
        }

        public Builder addCharactermugshots(CharacterMugShot characterMugShot) {
            RepeatedFieldBuilder<CharacterMugShot, CharacterMugShot.Builder, CharacterMugShotOrBuilder> repeatedFieldBuilder = this.charactermugshotsBuilder_;
            if (repeatedFieldBuilder == null) {
                characterMugShot.getClass();
                ensureCharactermugshotsIsMutable();
                this.charactermugshots_.add(characterMugShot);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(characterMugShot);
            return this;
        }

        public Builder addCharactermugshots(int i, CharacterMugShot characterMugShot) {
            RepeatedFieldBuilder<CharacterMugShot, CharacterMugShot.Builder, CharacterMugShotOrBuilder> repeatedFieldBuilder = this.charactermugshotsBuilder_;
            if (repeatedFieldBuilder == null) {
                characterMugShot.getClass();
                ensureCharactermugshotsIsMutable();
                this.charactermugshots_.add(i, characterMugShot);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(i, characterMugShot);
            return this;
        }

        public Builder addCharactermugshots(CharacterMugShot.Builder builder) {
            RepeatedFieldBuilder<CharacterMugShot, CharacterMugShot.Builder, CharacterMugShotOrBuilder> repeatedFieldBuilder = this.charactermugshotsBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureCharactermugshotsIsMutable();
                this.charactermugshots_.add(builder.build());
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(builder.build());
            return this;
        }

        public Builder addCharactermugshots(int i, CharacterMugShot.Builder builder) {
            RepeatedFieldBuilder<CharacterMugShot, CharacterMugShot.Builder, CharacterMugShotOrBuilder> repeatedFieldBuilder = this.charactermugshotsBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureCharactermugshotsIsMutable();
                this.charactermugshots_.add(i, builder.build());
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(i, builder.build());
            return this;
        }

        public Builder addAllCharactermugshots(Iterable<? extends CharacterMugShot> iterable) {
            RepeatedFieldBuilder<CharacterMugShot, CharacterMugShot.Builder, CharacterMugShotOrBuilder> repeatedFieldBuilder = this.charactermugshotsBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureCharactermugshotsIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) iterable, (List) this.charactermugshots_);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addAllMessages(iterable);
            return this;
        }

        public Builder clearCharactermugshots() {
            RepeatedFieldBuilder<CharacterMugShot, CharacterMugShot.Builder, CharacterMugShotOrBuilder> repeatedFieldBuilder = this.charactermugshotsBuilder_;
            if (repeatedFieldBuilder == null) {
                this.charactermugshots_ = Collections.emptyList();
                this.bitField0_ &= -2;
                onChanged();
                return this;
            }
            repeatedFieldBuilder.clear();
            return this;
        }

        public Builder removeCharactermugshots(int i) {
            RepeatedFieldBuilder<CharacterMugShot, CharacterMugShot.Builder, CharacterMugShotOrBuilder> repeatedFieldBuilder = this.charactermugshotsBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureCharactermugshotsIsMutable();
                this.charactermugshots_.remove(i);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.remove(i);
            return this;
        }

        public CharacterMugShot.Builder getCharactermugshotsBuilder(int i) {
            return (CharacterMugShot.Builder) getCharactermugshotsFieldBuilder().getBuilder(i);
        }

        @Override // proto.CharacterMugShotResultOrBuilder
        public CharacterMugShotOrBuilder getCharactermugshotsOrBuilder(int i) {
            RepeatedFieldBuilder<CharacterMugShot, CharacterMugShot.Builder, CharacterMugShotOrBuilder> repeatedFieldBuilder = this.charactermugshotsBuilder_;
            if (repeatedFieldBuilder == null) {
                return this.charactermugshots_.get(i);
            }
            return (CharacterMugShotOrBuilder) repeatedFieldBuilder.getMessageOrBuilder(i);
        }

        @Override // proto.CharacterMugShotResultOrBuilder
        public List<? extends CharacterMugShotOrBuilder> getCharactermugshotsOrBuilderList() {
            RepeatedFieldBuilder<CharacterMugShot, CharacterMugShot.Builder, CharacterMugShotOrBuilder> repeatedFieldBuilder = this.charactermugshotsBuilder_;
            if (repeatedFieldBuilder != null) {
                return repeatedFieldBuilder.getMessageOrBuilderList();
            }
            return Collections.unmodifiableList(this.charactermugshots_);
        }

        public CharacterMugShot.Builder addCharactermugshotsBuilder() {
            return (CharacterMugShot.Builder) getCharactermugshotsFieldBuilder().addBuilder(CharacterMugShot.getDefaultInstance());
        }

        public CharacterMugShot.Builder addCharactermugshotsBuilder(int i) {
            return (CharacterMugShot.Builder) getCharactermugshotsFieldBuilder().addBuilder(i, CharacterMugShot.getDefaultInstance());
        }

        public List<CharacterMugShot.Builder> getCharactermugshotsBuilderList() {
            return getCharactermugshotsFieldBuilder().getBuilderList();
        }

        private RepeatedFieldBuilder<CharacterMugShot, CharacterMugShot.Builder, CharacterMugShotOrBuilder> getCharactermugshotsFieldBuilder() {
            if (this.charactermugshotsBuilder_ == null) {
                this.charactermugshotsBuilder_ = new RepeatedFieldBuilder<>(this.charactermugshots_, (this.bitField0_ & 1) != 0, getParentForChildren(), isClean());
                this.charactermugshots_ = null;
            }
            return this.charactermugshotsBuilder_;
        }
    }

    public static CharacterMugShotResult getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* INFO: renamed from: proto.CharacterMugShotResult$1, reason: invalid class name */
    class AnonymousClass1 extends AbstractParser<CharacterMugShotResult> {
        AnonymousClass1() {
        }

        @Override // com.google.protobuf.Parser
        public CharacterMugShotResult parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            Builder builderNewBuilder = CharacterMugShotResult.newBuilder();
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

    public static Parser<CharacterMugShotResult> parser() {
        return PARSER;
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Parser<CharacterMugShotResult> getParserForType() {
        return PARSER;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
    public CharacterMugShotResult getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }
}
