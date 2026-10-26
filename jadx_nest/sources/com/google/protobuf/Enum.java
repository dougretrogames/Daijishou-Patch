package com.google.protobuf;

import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* INFO: loaded from: classes4.dex */
public final class Enum extends GeneratedMessage implements EnumOrBuilder {
    private static final Enum DEFAULT_INSTANCE;
    public static final int EDITION_FIELD_NUMBER = 6;
    public static final int ENUMVALUE_FIELD_NUMBER = 2;
    public static final int NAME_FIELD_NUMBER = 1;
    public static final int OPTIONS_FIELD_NUMBER = 3;
    private static final Parser<Enum> PARSER;
    public static final int SOURCE_CONTEXT_FIELD_NUMBER = 4;
    public static final int SYNTAX_FIELD_NUMBER = 5;
    private static final long serialVersionUID = 0;
    private int bitField0_;
    private volatile Object edition_;
    private List<EnumValue> enumvalue_;
    private byte memoizedIsInitialized;
    private volatile Object name_;
    private List<Option> options_;
    private SourceContext sourceContext_;
    private int syntax_;

    /* synthetic */ Enum(GeneratedMessage.Builder builder, AnonymousClass1 anonymousClass1) {
        this(builder);
    }

    static /* synthetic */ int access$976(Enum r1, int i) {
        int i2 = i | r1.bitField0_;
        r1.bitField0_ = i2;
        return i2;
    }

    static {
        RuntimeVersion.validateProtobufGencodeVersion(RuntimeVersion.RuntimeDomain.PUBLIC, 4, 27, 2, "", Enum.class.getName());
        DEFAULT_INSTANCE = new Enum();
        PARSER = new AnonymousClass1();
    }

    private Enum(GeneratedMessage.Builder<?> builder) {
        super(builder);
        this.name_ = "";
        this.syntax_ = 0;
        this.edition_ = "";
        this.memoizedIsInitialized = (byte) -1;
    }

    private Enum() {
        this.name_ = "";
        this.syntax_ = 0;
        this.edition_ = "";
        this.memoizedIsInitialized = (byte) -1;
        this.name_ = "";
        this.enumvalue_ = Collections.emptyList();
        this.options_ = Collections.emptyList();
        this.syntax_ = 0;
        this.edition_ = "";
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return TypeProto.internal_static_google_protobuf_Enum_descriptor;
    }

    @Override // com.google.protobuf.GeneratedMessage
    protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
        return TypeProto.internal_static_google_protobuf_Enum_fieldAccessorTable.ensureFieldAccessorsInitialized(Enum.class, Builder.class);
    }

    @Override // com.google.protobuf.EnumOrBuilder
    public String getName() {
        Object obj = this.name_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.name_ = stringUtf8;
        return stringUtf8;
    }

    @Override // com.google.protobuf.EnumOrBuilder
    public ByteString getNameBytes() {
        Object obj = this.name_;
        if (obj instanceof String) {
            ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.name_ = byteStringCopyFromUtf8;
            return byteStringCopyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // com.google.protobuf.EnumOrBuilder
    public List<EnumValue> getEnumvalueList() {
        return this.enumvalue_;
    }

    @Override // com.google.protobuf.EnumOrBuilder
    public List<? extends EnumValueOrBuilder> getEnumvalueOrBuilderList() {
        return this.enumvalue_;
    }

    @Override // com.google.protobuf.EnumOrBuilder
    public int getEnumvalueCount() {
        return this.enumvalue_.size();
    }

    @Override // com.google.protobuf.EnumOrBuilder
    public EnumValue getEnumvalue(int index) {
        return this.enumvalue_.get(index);
    }

    @Override // com.google.protobuf.EnumOrBuilder
    public EnumValueOrBuilder getEnumvalueOrBuilder(int index) {
        return this.enumvalue_.get(index);
    }

    @Override // com.google.protobuf.EnumOrBuilder
    public List<Option> getOptionsList() {
        return this.options_;
    }

    @Override // com.google.protobuf.EnumOrBuilder
    public List<? extends OptionOrBuilder> getOptionsOrBuilderList() {
        return this.options_;
    }

    @Override // com.google.protobuf.EnumOrBuilder
    public int getOptionsCount() {
        return this.options_.size();
    }

    @Override // com.google.protobuf.EnumOrBuilder
    public Option getOptions(int index) {
        return this.options_.get(index);
    }

    @Override // com.google.protobuf.EnumOrBuilder
    public OptionOrBuilder getOptionsOrBuilder(int index) {
        return this.options_.get(index);
    }

    @Override // com.google.protobuf.EnumOrBuilder
    public boolean hasSourceContext() {
        return (this.bitField0_ & 1) != 0;
    }

    @Override // com.google.protobuf.EnumOrBuilder
    public SourceContext getSourceContext() {
        SourceContext sourceContext = this.sourceContext_;
        return sourceContext == null ? SourceContext.getDefaultInstance() : sourceContext;
    }

    @Override // com.google.protobuf.EnumOrBuilder
    public SourceContextOrBuilder getSourceContextOrBuilder() {
        SourceContext sourceContext = this.sourceContext_;
        return sourceContext == null ? SourceContext.getDefaultInstance() : sourceContext;
    }

    @Override // com.google.protobuf.EnumOrBuilder
    public int getSyntaxValue() {
        return this.syntax_;
    }

    @Override // com.google.protobuf.EnumOrBuilder
    public Syntax getSyntax() {
        Syntax syntaxForNumber = Syntax.forNumber(this.syntax_);
        return syntaxForNumber == null ? Syntax.UNRECOGNIZED : syntaxForNumber;
    }

    @Override // com.google.protobuf.EnumOrBuilder
    public String getEdition() {
        Object obj = this.edition_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.edition_ = stringUtf8;
        return stringUtf8;
    }

    @Override // com.google.protobuf.EnumOrBuilder
    public ByteString getEditionBytes() {
        Object obj = this.edition_;
        if (obj instanceof String) {
            ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.edition_ = byteStringCopyFromUtf8;
            return byteStringCopyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLiteOrBuilder
    public final boolean isInitialized() {
        byte b = this.memoizedIsInitialized;
        if (b == 1) {
            return true;
        }
        if (b == 0) {
            return false;
        }
        this.memoizedIsInitialized = (byte) 1;
        return true;
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream output) throws IOException {
        if (!GeneratedMessage.isStringEmpty(this.name_)) {
            GeneratedMessage.writeString(output, 1, this.name_);
        }
        for (int i = 0; i < this.enumvalue_.size(); i++) {
            output.writeMessage(2, this.enumvalue_.get(i));
        }
        for (int i2 = 0; i2 < this.options_.size(); i2++) {
            output.writeMessage(3, this.options_.get(i2));
        }
        if ((this.bitField0_ & 1) != 0) {
            output.writeMessage(4, getSourceContext());
        }
        if (this.syntax_ != Syntax.SYNTAX_PROTO2.getNumber()) {
            output.writeEnum(5, this.syntax_);
        }
        if (!GeneratedMessage.isStringEmpty(this.edition_)) {
            GeneratedMessage.writeString(output, 6, this.edition_);
        }
        getUnknownFields().writeTo(output);
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int i = this.memoizedSize;
        if (i != -1) {
            return i;
        }
        int iComputeStringSize = !GeneratedMessage.isStringEmpty(this.name_) ? GeneratedMessage.computeStringSize(1, this.name_) : 0;
        for (int i2 = 0; i2 < this.enumvalue_.size(); i2++) {
            iComputeStringSize += CodedOutputStream.computeMessageSize(2, this.enumvalue_.get(i2));
        }
        for (int i3 = 0; i3 < this.options_.size(); i3++) {
            iComputeStringSize += CodedOutputStream.computeMessageSize(3, this.options_.get(i3));
        }
        if ((this.bitField0_ & 1) != 0) {
            iComputeStringSize += CodedOutputStream.computeMessageSize(4, getSourceContext());
        }
        if (this.syntax_ != Syntax.SYNTAX_PROTO2.getNumber()) {
            iComputeStringSize += CodedOutputStream.computeEnumSize(5, this.syntax_);
        }
        if (!GeneratedMessage.isStringEmpty(this.edition_)) {
            iComputeStringSize += GeneratedMessage.computeStringSize(6, this.edition_);
        }
        int serializedSize = iComputeStringSize + getUnknownFields().getSerializedSize();
        this.memoizedSize = serializedSize;
        return serializedSize;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public boolean equals(final Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Enum)) {
            return super.equals(obj);
        }
        Enum r5 = (Enum) obj;
        if (getName().equals(r5.getName()) && getEnumvalueList().equals(r5.getEnumvalueList()) && getOptionsList().equals(r5.getOptionsList()) && hasSourceContext() == r5.hasSourceContext()) {
            return (!hasSourceContext() || getSourceContext().equals(r5.getSourceContext())) && this.syntax_ == r5.syntax_ && getEdition().equals(r5.getEdition()) && getUnknownFields().equals(r5.getUnknownFields());
        }
        return false;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public int hashCode() {
        if (this.memoizedHashCode != 0) {
            return this.memoizedHashCode;
        }
        int iHashCode = ((((779 + getDescriptor().hashCode()) * 37) + 1) * 53) + getName().hashCode();
        if (getEnumvalueCount() > 0) {
            iHashCode = (((iHashCode * 37) + 2) * 53) + getEnumvalueList().hashCode();
        }
        if (getOptionsCount() > 0) {
            iHashCode = (((iHashCode * 37) + 3) * 53) + getOptionsList().hashCode();
        }
        if (hasSourceContext()) {
            iHashCode = (((iHashCode * 37) + 4) * 53) + getSourceContext().hashCode();
        }
        int iHashCode2 = (((((((((iHashCode * 37) + 5) * 53) + this.syntax_) * 37) + 6) * 53) + getEdition().hashCode()) * 29) + getUnknownFields().hashCode();
        this.memoizedHashCode = iHashCode2;
        return iHashCode2;
    }

    public static Enum parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(data);
    }

    public static Enum parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(data, extensionRegistry);
    }

    public static Enum parseFrom(ByteString data) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(data);
    }

    public static Enum parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(data, extensionRegistry);
    }

    public static Enum parseFrom(byte[] data) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(data);
    }

    public static Enum parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(data, extensionRegistry);
    }

    public static Enum parseFrom(InputStream input) throws IOException {
        return (Enum) GeneratedMessage.parseWithIOException(PARSER, input);
    }

    public static Enum parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (Enum) GeneratedMessage.parseWithIOException(PARSER, input, extensionRegistry);
    }

    public static Enum parseDelimitedFrom(InputStream input) throws IOException {
        return (Enum) GeneratedMessage.parseDelimitedWithIOException(PARSER, input);
    }

    public static Enum parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (Enum) GeneratedMessage.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
    }

    public static Enum parseFrom(CodedInputStream input) throws IOException {
        return (Enum) GeneratedMessage.parseWithIOException(PARSER, input);
    }

    public static Enum parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (Enum) GeneratedMessage.parseWithIOException(PARSER, input, extensionRegistry);
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder newBuilderForType() {
        return newBuilder();
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(Enum prototype) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder toBuilder() {
        return this == DEFAULT_INSTANCE ? new Builder((AnonymousClass1) null) : new Builder((AnonymousClass1) null).mergeFrom(this);
    }

    /* INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.AbstractMessage
    public Builder newBuilderForType(AbstractMessage.BuilderParent parent) {
        return new Builder(parent, null);
    }

    public static final class Builder extends GeneratedMessage.Builder<Builder> implements EnumOrBuilder {
        private int bitField0_;
        private Object edition_;
        private RepeatedFieldBuilder<EnumValue, EnumValue.Builder, EnumValueOrBuilder> enumvalueBuilder_;
        private List<EnumValue> enumvalue_;
        private Object name_;
        private RepeatedFieldBuilder<Option, Option.Builder, OptionOrBuilder> optionsBuilder_;
        private List<Option> options_;
        private SingleFieldBuilder<SourceContext, SourceContext.Builder, SourceContextOrBuilder> sourceContextBuilder_;
        private SourceContext sourceContext_;
        private int syntax_;

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            return true;
        }

        /* synthetic */ Builder(AbstractMessage.BuilderParent builderParent, AnonymousClass1 anonymousClass1) {
            this(builderParent);
        }

        /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return TypeProto.internal_static_google_protobuf_Enum_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder
        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return TypeProto.internal_static_google_protobuf_Enum_fieldAccessorTable.ensureFieldAccessorsInitialized(Enum.class, Builder.class);
        }

        private Builder() {
            this.name_ = "";
            this.enumvalue_ = Collections.emptyList();
            this.options_ = Collections.emptyList();
            this.syntax_ = 0;
            this.edition_ = "";
            maybeForceBuilderInitialization();
        }

        private Builder(AbstractMessage.BuilderParent parent) {
            super(parent);
            this.name_ = "";
            this.enumvalue_ = Collections.emptyList();
            this.options_ = Collections.emptyList();
            this.syntax_ = 0;
            this.edition_ = "";
            maybeForceBuilderInitialization();
        }

        private void maybeForceBuilderInitialization() {
            if (GeneratedMessage.alwaysUseFieldBuilders) {
                getEnumvalueFieldBuilder();
                getOptionsFieldBuilder();
                getSourceContextFieldBuilder();
            }
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder clear() {
            super.clear();
            this.bitField0_ = 0;
            this.name_ = "";
            RepeatedFieldBuilder<EnumValue, EnumValue.Builder, EnumValueOrBuilder> repeatedFieldBuilder = this.enumvalueBuilder_;
            if (repeatedFieldBuilder == null) {
                this.enumvalue_ = Collections.emptyList();
            } else {
                this.enumvalue_ = null;
                repeatedFieldBuilder.clear();
            }
            this.bitField0_ &= -3;
            RepeatedFieldBuilder<Option, Option.Builder, OptionOrBuilder> repeatedFieldBuilder2 = this.optionsBuilder_;
            if (repeatedFieldBuilder2 == null) {
                this.options_ = Collections.emptyList();
            } else {
                this.options_ = null;
                repeatedFieldBuilder2.clear();
            }
            this.bitField0_ &= -5;
            this.sourceContext_ = null;
            SingleFieldBuilder<SourceContext, SourceContext.Builder, SourceContextOrBuilder> singleFieldBuilder = this.sourceContextBuilder_;
            if (singleFieldBuilder != null) {
                singleFieldBuilder.dispose();
                this.sourceContextBuilder_ = null;
            }
            this.syntax_ = 0;
            this.edition_ = "";
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
        public Descriptors.Descriptor getDescriptorForType() {
            return TypeProto.internal_static_google_protobuf_Enum_descriptor;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public Enum getDefaultInstanceForType() {
            return Enum.getDefaultInstance();
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Enum build() {
            Enum enumBuildPartial = buildPartial();
            if (enumBuildPartial.isInitialized()) {
                return enumBuildPartial;
            }
            throw newUninitializedMessageException((Message) enumBuildPartial);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Enum buildPartial() {
            Enum r0 = new Enum(this, null);
            buildPartialRepeatedFields(r0);
            if (this.bitField0_ != 0) {
                buildPartial0(r0);
            }
            onBuilt();
            return r0;
        }

        private void buildPartialRepeatedFields(Enum result) {
            RepeatedFieldBuilder<EnumValue, EnumValue.Builder, EnumValueOrBuilder> repeatedFieldBuilder = this.enumvalueBuilder_;
            if (repeatedFieldBuilder != null) {
                result.enumvalue_ = repeatedFieldBuilder.build();
            } else {
                if ((this.bitField0_ & 2) != 0) {
                    this.enumvalue_ = Collections.unmodifiableList(this.enumvalue_);
                    this.bitField0_ &= -3;
                }
                result.enumvalue_ = this.enumvalue_;
            }
            RepeatedFieldBuilder<Option, Option.Builder, OptionOrBuilder> repeatedFieldBuilder2 = this.optionsBuilder_;
            if (repeatedFieldBuilder2 != null) {
                result.options_ = repeatedFieldBuilder2.build();
                return;
            }
            if ((this.bitField0_ & 4) != 0) {
                this.options_ = Collections.unmodifiableList(this.options_);
                this.bitField0_ &= -5;
            }
            result.options_ = this.options_;
        }

        private void buildPartial0(Enum result) {
            int i;
            SourceContext sourceContext;
            int i2 = this.bitField0_;
            if ((i2 & 1) != 0) {
                result.name_ = this.name_;
            }
            if ((i2 & 8) != 0) {
                SingleFieldBuilder<SourceContext, SourceContext.Builder, SourceContextOrBuilder> singleFieldBuilder = this.sourceContextBuilder_;
                if (singleFieldBuilder == null) {
                    sourceContext = this.sourceContext_;
                } else {
                    sourceContext = (SourceContext) singleFieldBuilder.build();
                }
                result.sourceContext_ = sourceContext;
                i = 1;
            } else {
                i = 0;
            }
            if ((i2 & 16) != 0) {
                result.syntax_ = this.syntax_;
            }
            if ((i2 & 32) != 0) {
                result.edition_ = this.edition_;
            }
            Enum.access$976(result, i);
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public Builder mergeFrom(Message other) {
            if (other instanceof Enum) {
                return mergeFrom((Enum) other);
            }
            super.mergeFrom(other);
            return this;
        }

        public Builder mergeFrom(Enum other) {
            if (other == Enum.getDefaultInstance()) {
                return this;
            }
            if (!other.getName().isEmpty()) {
                this.name_ = other.name_;
                this.bitField0_ |= 1;
                onChanged();
            }
            if (this.enumvalueBuilder_ == null) {
                if (!other.enumvalue_.isEmpty()) {
                    if (this.enumvalue_.isEmpty()) {
                        this.enumvalue_ = other.enumvalue_;
                        this.bitField0_ &= -3;
                    } else {
                        ensureEnumvalueIsMutable();
                        this.enumvalue_.addAll(other.enumvalue_);
                    }
                    onChanged();
                }
            } else if (!other.enumvalue_.isEmpty()) {
                if (!this.enumvalueBuilder_.isEmpty()) {
                    this.enumvalueBuilder_.addAllMessages(other.enumvalue_);
                } else {
                    this.enumvalueBuilder_.dispose();
                    this.enumvalueBuilder_ = null;
                    this.enumvalue_ = other.enumvalue_;
                    this.bitField0_ &= -3;
                    this.enumvalueBuilder_ = GeneratedMessage.alwaysUseFieldBuilders ? getEnumvalueFieldBuilder() : null;
                }
            }
            if (this.optionsBuilder_ == null) {
                if (!other.options_.isEmpty()) {
                    if (this.options_.isEmpty()) {
                        this.options_ = other.options_;
                        this.bitField0_ &= -5;
                    } else {
                        ensureOptionsIsMutable();
                        this.options_.addAll(other.options_);
                    }
                    onChanged();
                }
            } else if (!other.options_.isEmpty()) {
                if (!this.optionsBuilder_.isEmpty()) {
                    this.optionsBuilder_.addAllMessages(other.options_);
                } else {
                    this.optionsBuilder_.dispose();
                    this.optionsBuilder_ = null;
                    this.options_ = other.options_;
                    this.bitField0_ &= -5;
                    this.optionsBuilder_ = GeneratedMessage.alwaysUseFieldBuilders ? getOptionsFieldBuilder() : null;
                }
            }
            if (other.hasSourceContext()) {
                mergeSourceContext(other.getSourceContext());
            }
            if (other.syntax_ != 0) {
                setSyntaxValue(other.getSyntaxValue());
            }
            if (!other.getEdition().isEmpty()) {
                this.edition_ = other.edition_;
                this.bitField0_ |= 32;
                onChanged();
            }
            mergeUnknownFields(other.getUnknownFields());
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            extensionRegistry.getClass();
            boolean z = false;
            while (!z) {
                try {
                    try {
                        int tag = input.readTag();
                        if (tag != 0) {
                            if (tag == 10) {
                                this.name_ = input.readStringRequireUtf8();
                                this.bitField0_ |= 1;
                            } else if (tag == 18) {
                                EnumValue enumValue = (EnumValue) input.readMessage(EnumValue.parser(), extensionRegistry);
                                RepeatedFieldBuilder<EnumValue, EnumValue.Builder, EnumValueOrBuilder> repeatedFieldBuilder = this.enumvalueBuilder_;
                                if (repeatedFieldBuilder == null) {
                                    ensureEnumvalueIsMutable();
                                    this.enumvalue_.add(enumValue);
                                } else {
                                    repeatedFieldBuilder.addMessage(enumValue);
                                }
                            } else if (tag == 26) {
                                Option option = (Option) input.readMessage(Option.parser(), extensionRegistry);
                                RepeatedFieldBuilder<Option, Option.Builder, OptionOrBuilder> repeatedFieldBuilder2 = this.optionsBuilder_;
                                if (repeatedFieldBuilder2 == null) {
                                    ensureOptionsIsMutable();
                                    this.options_.add(option);
                                } else {
                                    repeatedFieldBuilder2.addMessage(option);
                                }
                            } else if (tag == 34) {
                                input.readMessage(getSourceContextFieldBuilder().getBuilder(), extensionRegistry);
                                this.bitField0_ |= 8;
                            } else if (tag == 40) {
                                this.syntax_ = input.readEnum();
                                this.bitField0_ |= 16;
                            } else if (tag == 50) {
                                this.edition_ = input.readStringRequireUtf8();
                                this.bitField0_ |= 32;
                            } else if (!super.parseUnknownField(input, extensionRegistry, tag)) {
                            }
                        }
                        z = true;
                    } catch (InvalidProtocolBufferException e) {
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    onChanged();
                    throw th;
                }
            }
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.EnumOrBuilder
        public String getName() {
            Object obj = this.name_;
            if (!(obj instanceof String)) {
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.name_ = stringUtf8;
                return stringUtf8;
            }
            return (String) obj;
        }

        @Override // com.google.protobuf.EnumOrBuilder
        public ByteString getNameBytes() {
            Object obj = this.name_;
            if (obj instanceof String) {
                ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.name_ = byteStringCopyFromUtf8;
                return byteStringCopyFromUtf8;
            }
            return (ByteString) obj;
        }

        public Builder setName(String value) {
            value.getClass();
            this.name_ = value;
            this.bitField0_ |= 1;
            onChanged();
            return this;
        }

        public Builder clearName() {
            this.name_ = Enum.getDefaultInstance().getName();
            this.bitField0_ &= -2;
            onChanged();
            return this;
        }

        public Builder setNameBytes(ByteString value) {
            value.getClass();
            AbstractMessageLite.checkByteStringIsUtf8(value);
            this.name_ = value;
            this.bitField0_ |= 1;
            onChanged();
            return this;
        }

        private void ensureEnumvalueIsMutable() {
            if ((this.bitField0_ & 2) == 0) {
                this.enumvalue_ = new ArrayList(this.enumvalue_);
                this.bitField0_ |= 2;
            }
        }

        @Override // com.google.protobuf.EnumOrBuilder
        public List<EnumValue> getEnumvalueList() {
            RepeatedFieldBuilder<EnumValue, EnumValue.Builder, EnumValueOrBuilder> repeatedFieldBuilder = this.enumvalueBuilder_;
            if (repeatedFieldBuilder == null) {
                return Collections.unmodifiableList(this.enumvalue_);
            }
            return repeatedFieldBuilder.getMessageList();
        }

        @Override // com.google.protobuf.EnumOrBuilder
        public int getEnumvalueCount() {
            RepeatedFieldBuilder<EnumValue, EnumValue.Builder, EnumValueOrBuilder> repeatedFieldBuilder = this.enumvalueBuilder_;
            if (repeatedFieldBuilder == null) {
                return this.enumvalue_.size();
            }
            return repeatedFieldBuilder.getCount();
        }

        @Override // com.google.protobuf.EnumOrBuilder
        public EnumValue getEnumvalue(int index) {
            RepeatedFieldBuilder<EnumValue, EnumValue.Builder, EnumValueOrBuilder> repeatedFieldBuilder = this.enumvalueBuilder_;
            if (repeatedFieldBuilder == null) {
                return this.enumvalue_.get(index);
            }
            return (EnumValue) repeatedFieldBuilder.getMessage(index);
        }

        public Builder setEnumvalue(int index, EnumValue value) {
            RepeatedFieldBuilder<EnumValue, EnumValue.Builder, EnumValueOrBuilder> repeatedFieldBuilder = this.enumvalueBuilder_;
            if (repeatedFieldBuilder == null) {
                value.getClass();
                ensureEnumvalueIsMutable();
                this.enumvalue_.set(index, value);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.setMessage(index, value);
            return this;
        }

        public Builder setEnumvalue(int index, EnumValue.Builder builderForValue) {
            RepeatedFieldBuilder<EnumValue, EnumValue.Builder, EnumValueOrBuilder> repeatedFieldBuilder = this.enumvalueBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureEnumvalueIsMutable();
                this.enumvalue_.set(index, builderForValue.build());
                onChanged();
                return this;
            }
            repeatedFieldBuilder.setMessage(index, builderForValue.build());
            return this;
        }

        public Builder addEnumvalue(EnumValue value) {
            RepeatedFieldBuilder<EnumValue, EnumValue.Builder, EnumValueOrBuilder> repeatedFieldBuilder = this.enumvalueBuilder_;
            if (repeatedFieldBuilder == null) {
                value.getClass();
                ensureEnumvalueIsMutable();
                this.enumvalue_.add(value);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(value);
            return this;
        }

        public Builder addEnumvalue(int index, EnumValue value) {
            RepeatedFieldBuilder<EnumValue, EnumValue.Builder, EnumValueOrBuilder> repeatedFieldBuilder = this.enumvalueBuilder_;
            if (repeatedFieldBuilder == null) {
                value.getClass();
                ensureEnumvalueIsMutable();
                this.enumvalue_.add(index, value);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(index, value);
            return this;
        }

        public Builder addEnumvalue(EnumValue.Builder builderForValue) {
            RepeatedFieldBuilder<EnumValue, EnumValue.Builder, EnumValueOrBuilder> repeatedFieldBuilder = this.enumvalueBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureEnumvalueIsMutable();
                this.enumvalue_.add(builderForValue.build());
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(builderForValue.build());
            return this;
        }

        public Builder addEnumvalue(int index, EnumValue.Builder builderForValue) {
            RepeatedFieldBuilder<EnumValue, EnumValue.Builder, EnumValueOrBuilder> repeatedFieldBuilder = this.enumvalueBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureEnumvalueIsMutable();
                this.enumvalue_.add(index, builderForValue.build());
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(index, builderForValue.build());
            return this;
        }

        public Builder addAllEnumvalue(Iterable<? extends EnumValue> values) {
            RepeatedFieldBuilder<EnumValue, EnumValue.Builder, EnumValueOrBuilder> repeatedFieldBuilder = this.enumvalueBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureEnumvalueIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.enumvalue_);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addAllMessages(values);
            return this;
        }

        public Builder clearEnumvalue() {
            RepeatedFieldBuilder<EnumValue, EnumValue.Builder, EnumValueOrBuilder> repeatedFieldBuilder = this.enumvalueBuilder_;
            if (repeatedFieldBuilder == null) {
                this.enumvalue_ = Collections.emptyList();
                this.bitField0_ &= -3;
                onChanged();
                return this;
            }
            repeatedFieldBuilder.clear();
            return this;
        }

        public Builder removeEnumvalue(int index) {
            RepeatedFieldBuilder<EnumValue, EnumValue.Builder, EnumValueOrBuilder> repeatedFieldBuilder = this.enumvalueBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureEnumvalueIsMutable();
                this.enumvalue_.remove(index);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.remove(index);
            return this;
        }

        public EnumValue.Builder getEnumvalueBuilder(int index) {
            return (EnumValue.Builder) getEnumvalueFieldBuilder().getBuilder(index);
        }

        @Override // com.google.protobuf.EnumOrBuilder
        public EnumValueOrBuilder getEnumvalueOrBuilder(int index) {
            RepeatedFieldBuilder<EnumValue, EnumValue.Builder, EnumValueOrBuilder> repeatedFieldBuilder = this.enumvalueBuilder_;
            if (repeatedFieldBuilder == null) {
                return this.enumvalue_.get(index);
            }
            return (EnumValueOrBuilder) repeatedFieldBuilder.getMessageOrBuilder(index);
        }

        @Override // com.google.protobuf.EnumOrBuilder
        public List<? extends EnumValueOrBuilder> getEnumvalueOrBuilderList() {
            RepeatedFieldBuilder<EnumValue, EnumValue.Builder, EnumValueOrBuilder> repeatedFieldBuilder = this.enumvalueBuilder_;
            if (repeatedFieldBuilder != null) {
                return repeatedFieldBuilder.getMessageOrBuilderList();
            }
            return Collections.unmodifiableList(this.enumvalue_);
        }

        public EnumValue.Builder addEnumvalueBuilder() {
            return (EnumValue.Builder) getEnumvalueFieldBuilder().addBuilder(EnumValue.getDefaultInstance());
        }

        public EnumValue.Builder addEnumvalueBuilder(int index) {
            return (EnumValue.Builder) getEnumvalueFieldBuilder().addBuilder(index, EnumValue.getDefaultInstance());
        }

        public List<EnumValue.Builder> getEnumvalueBuilderList() {
            return getEnumvalueFieldBuilder().getBuilderList();
        }

        private RepeatedFieldBuilder<EnumValue, EnumValue.Builder, EnumValueOrBuilder> getEnumvalueFieldBuilder() {
            if (this.enumvalueBuilder_ == null) {
                this.enumvalueBuilder_ = new RepeatedFieldBuilder<>(this.enumvalue_, (this.bitField0_ & 2) != 0, getParentForChildren(), isClean());
                this.enumvalue_ = null;
            }
            return this.enumvalueBuilder_;
        }

        private void ensureOptionsIsMutable() {
            if ((this.bitField0_ & 4) == 0) {
                this.options_ = new ArrayList(this.options_);
                this.bitField0_ |= 4;
            }
        }

        @Override // com.google.protobuf.EnumOrBuilder
        public List<Option> getOptionsList() {
            RepeatedFieldBuilder<Option, Option.Builder, OptionOrBuilder> repeatedFieldBuilder = this.optionsBuilder_;
            if (repeatedFieldBuilder == null) {
                return Collections.unmodifiableList(this.options_);
            }
            return repeatedFieldBuilder.getMessageList();
        }

        @Override // com.google.protobuf.EnumOrBuilder
        public int getOptionsCount() {
            RepeatedFieldBuilder<Option, Option.Builder, OptionOrBuilder> repeatedFieldBuilder = this.optionsBuilder_;
            if (repeatedFieldBuilder == null) {
                return this.options_.size();
            }
            return repeatedFieldBuilder.getCount();
        }

        @Override // com.google.protobuf.EnumOrBuilder
        public Option getOptions(int index) {
            RepeatedFieldBuilder<Option, Option.Builder, OptionOrBuilder> repeatedFieldBuilder = this.optionsBuilder_;
            if (repeatedFieldBuilder == null) {
                return this.options_.get(index);
            }
            return (Option) repeatedFieldBuilder.getMessage(index);
        }

        public Builder setOptions(int index, Option value) {
            RepeatedFieldBuilder<Option, Option.Builder, OptionOrBuilder> repeatedFieldBuilder = this.optionsBuilder_;
            if (repeatedFieldBuilder == null) {
                value.getClass();
                ensureOptionsIsMutable();
                this.options_.set(index, value);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.setMessage(index, value);
            return this;
        }

        public Builder setOptions(int index, Option.Builder builderForValue) {
            RepeatedFieldBuilder<Option, Option.Builder, OptionOrBuilder> repeatedFieldBuilder = this.optionsBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureOptionsIsMutable();
                this.options_.set(index, builderForValue.build());
                onChanged();
                return this;
            }
            repeatedFieldBuilder.setMessage(index, builderForValue.build());
            return this;
        }

        public Builder addOptions(Option value) {
            RepeatedFieldBuilder<Option, Option.Builder, OptionOrBuilder> repeatedFieldBuilder = this.optionsBuilder_;
            if (repeatedFieldBuilder == null) {
                value.getClass();
                ensureOptionsIsMutable();
                this.options_.add(value);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(value);
            return this;
        }

        public Builder addOptions(int index, Option value) {
            RepeatedFieldBuilder<Option, Option.Builder, OptionOrBuilder> repeatedFieldBuilder = this.optionsBuilder_;
            if (repeatedFieldBuilder == null) {
                value.getClass();
                ensureOptionsIsMutable();
                this.options_.add(index, value);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(index, value);
            return this;
        }

        public Builder addOptions(Option.Builder builderForValue) {
            RepeatedFieldBuilder<Option, Option.Builder, OptionOrBuilder> repeatedFieldBuilder = this.optionsBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureOptionsIsMutable();
                this.options_.add(builderForValue.build());
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(builderForValue.build());
            return this;
        }

        public Builder addOptions(int index, Option.Builder builderForValue) {
            RepeatedFieldBuilder<Option, Option.Builder, OptionOrBuilder> repeatedFieldBuilder = this.optionsBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureOptionsIsMutable();
                this.options_.add(index, builderForValue.build());
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(index, builderForValue.build());
            return this;
        }

        public Builder addAllOptions(Iterable<? extends Option> values) {
            RepeatedFieldBuilder<Option, Option.Builder, OptionOrBuilder> repeatedFieldBuilder = this.optionsBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureOptionsIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.options_);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addAllMessages(values);
            return this;
        }

        public Builder clearOptions() {
            RepeatedFieldBuilder<Option, Option.Builder, OptionOrBuilder> repeatedFieldBuilder = this.optionsBuilder_;
            if (repeatedFieldBuilder == null) {
                this.options_ = Collections.emptyList();
                this.bitField0_ &= -5;
                onChanged();
                return this;
            }
            repeatedFieldBuilder.clear();
            return this;
        }

        public Builder removeOptions(int index) {
            RepeatedFieldBuilder<Option, Option.Builder, OptionOrBuilder> repeatedFieldBuilder = this.optionsBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureOptionsIsMutable();
                this.options_.remove(index);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.remove(index);
            return this;
        }

        public Option.Builder getOptionsBuilder(int index) {
            return (Option.Builder) getOptionsFieldBuilder().getBuilder(index);
        }

        @Override // com.google.protobuf.EnumOrBuilder
        public OptionOrBuilder getOptionsOrBuilder(int index) {
            RepeatedFieldBuilder<Option, Option.Builder, OptionOrBuilder> repeatedFieldBuilder = this.optionsBuilder_;
            if (repeatedFieldBuilder == null) {
                return this.options_.get(index);
            }
            return (OptionOrBuilder) repeatedFieldBuilder.getMessageOrBuilder(index);
        }

        @Override // com.google.protobuf.EnumOrBuilder
        public List<? extends OptionOrBuilder> getOptionsOrBuilderList() {
            RepeatedFieldBuilder<Option, Option.Builder, OptionOrBuilder> repeatedFieldBuilder = this.optionsBuilder_;
            if (repeatedFieldBuilder != null) {
                return repeatedFieldBuilder.getMessageOrBuilderList();
            }
            return Collections.unmodifiableList(this.options_);
        }

        public Option.Builder addOptionsBuilder() {
            return (Option.Builder) getOptionsFieldBuilder().addBuilder(Option.getDefaultInstance());
        }

        public Option.Builder addOptionsBuilder(int index) {
            return (Option.Builder) getOptionsFieldBuilder().addBuilder(index, Option.getDefaultInstance());
        }

        public List<Option.Builder> getOptionsBuilderList() {
            return getOptionsFieldBuilder().getBuilderList();
        }

        private RepeatedFieldBuilder<Option, Option.Builder, OptionOrBuilder> getOptionsFieldBuilder() {
            if (this.optionsBuilder_ == null) {
                this.optionsBuilder_ = new RepeatedFieldBuilder<>(this.options_, (this.bitField0_ & 4) != 0, getParentForChildren(), isClean());
                this.options_ = null;
            }
            return this.optionsBuilder_;
        }

        @Override // com.google.protobuf.EnumOrBuilder
        public boolean hasSourceContext() {
            return (this.bitField0_ & 8) != 0;
        }

        @Override // com.google.protobuf.EnumOrBuilder
        public SourceContext getSourceContext() {
            SingleFieldBuilder<SourceContext, SourceContext.Builder, SourceContextOrBuilder> singleFieldBuilder = this.sourceContextBuilder_;
            if (singleFieldBuilder == null) {
                SourceContext sourceContext = this.sourceContext_;
                return sourceContext == null ? SourceContext.getDefaultInstance() : sourceContext;
            }
            return (SourceContext) singleFieldBuilder.getMessage();
        }

        public Builder setSourceContext(SourceContext value) {
            SingleFieldBuilder<SourceContext, SourceContext.Builder, SourceContextOrBuilder> singleFieldBuilder = this.sourceContextBuilder_;
            if (singleFieldBuilder == null) {
                value.getClass();
                this.sourceContext_ = value;
            } else {
                singleFieldBuilder.setMessage(value);
            }
            this.bitField0_ |= 8;
            onChanged();
            return this;
        }

        public Builder setSourceContext(SourceContext.Builder builderForValue) {
            SingleFieldBuilder<SourceContext, SourceContext.Builder, SourceContextOrBuilder> singleFieldBuilder = this.sourceContextBuilder_;
            if (singleFieldBuilder == null) {
                this.sourceContext_ = builderForValue.build();
            } else {
                singleFieldBuilder.setMessage(builderForValue.build());
            }
            this.bitField0_ |= 8;
            onChanged();
            return this;
        }

        public Builder mergeSourceContext(SourceContext value) {
            SourceContext sourceContext;
            SingleFieldBuilder<SourceContext, SourceContext.Builder, SourceContextOrBuilder> singleFieldBuilder = this.sourceContextBuilder_;
            if (singleFieldBuilder == null) {
                if ((this.bitField0_ & 8) != 0 && (sourceContext = this.sourceContext_) != null && sourceContext != SourceContext.getDefaultInstance()) {
                    getSourceContextBuilder().mergeFrom(value);
                } else {
                    this.sourceContext_ = value;
                }
            } else {
                singleFieldBuilder.mergeFrom(value);
            }
            if (this.sourceContext_ != null) {
                this.bitField0_ |= 8;
                onChanged();
            }
            return this;
        }

        public Builder clearSourceContext() {
            this.bitField0_ &= -9;
            this.sourceContext_ = null;
            SingleFieldBuilder<SourceContext, SourceContext.Builder, SourceContextOrBuilder> singleFieldBuilder = this.sourceContextBuilder_;
            if (singleFieldBuilder != null) {
                singleFieldBuilder.dispose();
                this.sourceContextBuilder_ = null;
            }
            onChanged();
            return this;
        }

        public SourceContext.Builder getSourceContextBuilder() {
            this.bitField0_ |= 8;
            onChanged();
            return (SourceContext.Builder) getSourceContextFieldBuilder().getBuilder();
        }

        @Override // com.google.protobuf.EnumOrBuilder
        public SourceContextOrBuilder getSourceContextOrBuilder() {
            SingleFieldBuilder<SourceContext, SourceContext.Builder, SourceContextOrBuilder> singleFieldBuilder = this.sourceContextBuilder_;
            if (singleFieldBuilder != null) {
                return (SourceContextOrBuilder) singleFieldBuilder.getMessageOrBuilder();
            }
            SourceContext sourceContext = this.sourceContext_;
            return sourceContext == null ? SourceContext.getDefaultInstance() : sourceContext;
        }

        private SingleFieldBuilder<SourceContext, SourceContext.Builder, SourceContextOrBuilder> getSourceContextFieldBuilder() {
            if (this.sourceContextBuilder_ == null) {
                this.sourceContextBuilder_ = new SingleFieldBuilder<>(getSourceContext(), getParentForChildren(), isClean());
                this.sourceContext_ = null;
            }
            return this.sourceContextBuilder_;
        }

        @Override // com.google.protobuf.EnumOrBuilder
        public int getSyntaxValue() {
            return this.syntax_;
        }

        public Builder setSyntaxValue(int value) {
            this.syntax_ = value;
            this.bitField0_ |= 16;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.EnumOrBuilder
        public Syntax getSyntax() {
            Syntax syntaxForNumber = Syntax.forNumber(this.syntax_);
            return syntaxForNumber == null ? Syntax.UNRECOGNIZED : syntaxForNumber;
        }

        public Builder setSyntax(Syntax value) {
            value.getClass();
            this.bitField0_ |= 16;
            this.syntax_ = value.getNumber();
            onChanged();
            return this;
        }

        public Builder clearSyntax() {
            this.bitField0_ &= -17;
            this.syntax_ = 0;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.EnumOrBuilder
        public String getEdition() {
            Object obj = this.edition_;
            if (!(obj instanceof String)) {
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.edition_ = stringUtf8;
                return stringUtf8;
            }
            return (String) obj;
        }

        @Override // com.google.protobuf.EnumOrBuilder
        public ByteString getEditionBytes() {
            Object obj = this.edition_;
            if (obj instanceof String) {
                ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.edition_ = byteStringCopyFromUtf8;
                return byteStringCopyFromUtf8;
            }
            return (ByteString) obj;
        }

        public Builder setEdition(String value) {
            value.getClass();
            this.edition_ = value;
            this.bitField0_ |= 32;
            onChanged();
            return this;
        }

        public Builder clearEdition() {
            this.edition_ = Enum.getDefaultInstance().getEdition();
            this.bitField0_ &= -33;
            onChanged();
            return this;
        }

        public Builder setEditionBytes(ByteString value) {
            value.getClass();
            AbstractMessageLite.checkByteStringIsUtf8(value);
            this.edition_ = value;
            this.bitField0_ |= 32;
            onChanged();
            return this;
        }
    }

    public static Enum getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* INFO: renamed from: com.google.protobuf.Enum$1, reason: invalid class name */
    class AnonymousClass1 extends AbstractParser<Enum> {
        AnonymousClass1() {
        }

        @Override // com.google.protobuf.AbstractParser, com.google.protobuf.Parser
        public /* bridge */ /* synthetic */ Object parseDelimitedFrom(InputStream input) throws InvalidProtocolBufferException {
            return super.parseDelimitedFrom(input);
        }

        @Override // com.google.protobuf.AbstractParser, com.google.protobuf.Parser
        public /* bridge */ /* synthetic */ Object parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return super.parseDelimitedFrom(input, extensionRegistry);
        }

        @Override // com.google.protobuf.AbstractParser, com.google.protobuf.Parser
        public /* bridge */ /* synthetic */ Object parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return super.parseFrom(data);
        }

        @Override // com.google.protobuf.AbstractParser, com.google.protobuf.Parser
        public /* bridge */ /* synthetic */ Object parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return super.parseFrom(data, extensionRegistry);
        }

        @Override // com.google.protobuf.AbstractParser, com.google.protobuf.Parser
        public /* bridge */ /* synthetic */ Object parseFrom(CodedInputStream input) throws InvalidProtocolBufferException {
            return super.parseFrom(input);
        }

        @Override // com.google.protobuf.AbstractParser, com.google.protobuf.Parser
        public /* bridge */ /* synthetic */ Object parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return super.parseFrom(input, extensionRegistry);
        }

        @Override // com.google.protobuf.AbstractParser, com.google.protobuf.Parser
        public /* bridge */ /* synthetic */ Object parseFrom(InputStream input) throws InvalidProtocolBufferException {
            return super.parseFrom(input);
        }

        @Override // com.google.protobuf.AbstractParser, com.google.protobuf.Parser
        public /* bridge */ /* synthetic */ Object parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return super.parseFrom(input, extensionRegistry);
        }

        @Override // com.google.protobuf.AbstractParser, com.google.protobuf.Parser
        public /* bridge */ /* synthetic */ Object parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return super.parseFrom(data);
        }

        @Override // com.google.protobuf.AbstractParser, com.google.protobuf.Parser
        public /* bridge */ /* synthetic */ Object parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return super.parseFrom(data, extensionRegistry);
        }

        @Override // com.google.protobuf.AbstractParser, com.google.protobuf.Parser
        public /* bridge */ /* synthetic */ Object parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return super.parseFrom(data);
        }

        @Override // com.google.protobuf.AbstractParser, com.google.protobuf.Parser
        public /* bridge */ /* synthetic */ Object parseFrom(byte[] data, int off, int len) throws InvalidProtocolBufferException {
            return super.parseFrom(data, off, len);
        }

        @Override // com.google.protobuf.AbstractParser, com.google.protobuf.Parser
        public /* bridge */ /* synthetic */ Object parseFrom(byte[] data, int off, int len, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return super.parseFrom(data, off, len, extensionRegistry);
        }

        @Override // com.google.protobuf.AbstractParser, com.google.protobuf.Parser
        public /* bridge */ /* synthetic */ Object parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return super.parseFrom(data, extensionRegistry);
        }

        @Override // com.google.protobuf.AbstractParser, com.google.protobuf.Parser
        public /* bridge */ /* synthetic */ Object parsePartialDelimitedFrom(InputStream input) throws InvalidProtocolBufferException {
            return super.parsePartialDelimitedFrom(input);
        }

        @Override // com.google.protobuf.AbstractParser, com.google.protobuf.Parser
        public /* bridge */ /* synthetic */ Object parsePartialDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return super.parsePartialDelimitedFrom(input, extensionRegistry);
        }

        @Override // com.google.protobuf.AbstractParser, com.google.protobuf.Parser
        public /* bridge */ /* synthetic */ Object parsePartialFrom(ByteString data) throws InvalidProtocolBufferException {
            return super.parsePartialFrom(data);
        }

        @Override // com.google.protobuf.AbstractParser, com.google.protobuf.Parser
        public /* bridge */ /* synthetic */ Object parsePartialFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return super.parsePartialFrom(data, extensionRegistry);
        }

        @Override // com.google.protobuf.AbstractParser, com.google.protobuf.Parser
        public /* bridge */ /* synthetic */ Object parsePartialFrom(CodedInputStream input) throws InvalidProtocolBufferException {
            return super.parsePartialFrom(input);
        }

        @Override // com.google.protobuf.AbstractParser, com.google.protobuf.Parser
        public /* bridge */ /* synthetic */ Object parsePartialFrom(InputStream input) throws InvalidProtocolBufferException {
            return super.parsePartialFrom(input);
        }

        @Override // com.google.protobuf.AbstractParser, com.google.protobuf.Parser
        public /* bridge */ /* synthetic */ Object parsePartialFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return super.parsePartialFrom(input, extensionRegistry);
        }

        @Override // com.google.protobuf.AbstractParser, com.google.protobuf.Parser
        public /* bridge */ /* synthetic */ Object parsePartialFrom(byte[] data) throws InvalidProtocolBufferException {
            return super.parsePartialFrom(data);
        }

        @Override // com.google.protobuf.AbstractParser, com.google.protobuf.Parser
        public /* bridge */ /* synthetic */ Object parsePartialFrom(byte[] data, int off, int len) throws InvalidProtocolBufferException {
            return super.parsePartialFrom(data, off, len);
        }

        @Override // com.google.protobuf.AbstractParser, com.google.protobuf.Parser
        public /* bridge */ /* synthetic */ Object parsePartialFrom(byte[] data, int off, int len, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return super.parsePartialFrom(data, off, len, extensionRegistry);
        }

        @Override // com.google.protobuf.AbstractParser, com.google.protobuf.Parser
        public /* bridge */ /* synthetic */ Object parsePartialFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return super.parsePartialFrom(data, extensionRegistry);
        }

        @Override // com.google.protobuf.Parser
        public Enum parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            Builder builderNewBuilder = Enum.newBuilder();
            try {
                builderNewBuilder.mergeFrom(input, extensionRegistry);
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

    public static Parser<Enum> parser() {
        return PARSER;
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Parser<Enum> getParserForType() {
        return PARSER;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
    public Enum getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }
}
