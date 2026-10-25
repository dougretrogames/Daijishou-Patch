package com.google.protobuf;

import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public final class Api extends GeneratedMessage implements ApiOrBuilder {
    private static final Api DEFAULT_INSTANCE;
    public static final int METHODS_FIELD_NUMBER = 2;
    public static final int MIXINS_FIELD_NUMBER = 6;
    public static final int NAME_FIELD_NUMBER = 1;
    public static final int OPTIONS_FIELD_NUMBER = 3;
    private static final Parser<Api> PARSER;
    public static final int SOURCE_CONTEXT_FIELD_NUMBER = 5;
    public static final int SYNTAX_FIELD_NUMBER = 7;
    public static final int VERSION_FIELD_NUMBER = 4;
    private static final long serialVersionUID = 0;
    private int bitField0_;
    private byte memoizedIsInitialized;
    private List<Method> methods_;
    private List<Mixin> mixins_;
    private volatile Object name_;
    private List<Option> options_;
    private SourceContext sourceContext_;
    private int syntax_;
    private volatile Object version_;

    /* synthetic */ Api(GeneratedMessage.Builder builder, AnonymousClass1 anonymousClass1) {
        this(builder);
    }

    static /* synthetic */ int access$1076(Api api, int i) {
        int i2 = i | api.bitField0_;
        api.bitField0_ = i2;
        return i2;
    }

    static {
        RuntimeVersion.validateProtobufGencodeVersion(RuntimeVersion.RuntimeDomain.PUBLIC, 4, 27, 2, "", Api.class.getName());
        DEFAULT_INSTANCE = new Api();
        PARSER = new AnonymousClass1();
    }

    private Api(GeneratedMessage.Builder<?> builder) {
        super(builder);
        this.name_ = "";
        this.version_ = "";
        this.syntax_ = 0;
        this.memoizedIsInitialized = (byte) -1;
    }

    private Api() {
        this.name_ = "";
        this.version_ = "";
        this.syntax_ = 0;
        this.memoizedIsInitialized = (byte) -1;
        this.name_ = "";
        this.methods_ = Collections.emptyList();
        this.options_ = Collections.emptyList();
        this.version_ = "";
        this.mixins_ = Collections.emptyList();
        this.syntax_ = 0;
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return ApiProto.internal_static_google_protobuf_Api_descriptor;
    }

    @Override // com.google.protobuf.GeneratedMessage
    protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
        return ApiProto.internal_static_google_protobuf_Api_fieldAccessorTable.ensureFieldAccessorsInitialized(Api.class, Builder.class);
    }

    @Override // com.google.protobuf.ApiOrBuilder
    public String getName() {
        Object obj = this.name_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.name_ = stringUtf8;
        return stringUtf8;
    }

    @Override // com.google.protobuf.ApiOrBuilder
    public ByteString getNameBytes() {
        Object obj = this.name_;
        if (obj instanceof String) {
            ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.name_ = byteStringCopyFromUtf8;
            return byteStringCopyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // com.google.protobuf.ApiOrBuilder
    public List<Method> getMethodsList() {
        return this.methods_;
    }

    @Override // com.google.protobuf.ApiOrBuilder
    public List<? extends MethodOrBuilder> getMethodsOrBuilderList() {
        return this.methods_;
    }

    @Override // com.google.protobuf.ApiOrBuilder
    public int getMethodsCount() {
        return this.methods_.size();
    }

    @Override // com.google.protobuf.ApiOrBuilder
    public Method getMethods(int index) {
        return this.methods_.get(index);
    }

    @Override // com.google.protobuf.ApiOrBuilder
    public MethodOrBuilder getMethodsOrBuilder(int index) {
        return this.methods_.get(index);
    }

    @Override // com.google.protobuf.ApiOrBuilder
    public List<Option> getOptionsList() {
        return this.options_;
    }

    @Override // com.google.protobuf.ApiOrBuilder
    public List<? extends OptionOrBuilder> getOptionsOrBuilderList() {
        return this.options_;
    }

    @Override // com.google.protobuf.ApiOrBuilder
    public int getOptionsCount() {
        return this.options_.size();
    }

    @Override // com.google.protobuf.ApiOrBuilder
    public Option getOptions(int index) {
        return this.options_.get(index);
    }

    @Override // com.google.protobuf.ApiOrBuilder
    public OptionOrBuilder getOptionsOrBuilder(int index) {
        return this.options_.get(index);
    }

    @Override // com.google.protobuf.ApiOrBuilder
    public String getVersion() {
        Object obj = this.version_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.version_ = stringUtf8;
        return stringUtf8;
    }

    @Override // com.google.protobuf.ApiOrBuilder
    public ByteString getVersionBytes() {
        Object obj = this.version_;
        if (obj instanceof String) {
            ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.version_ = byteStringCopyFromUtf8;
            return byteStringCopyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // com.google.protobuf.ApiOrBuilder
    public boolean hasSourceContext() {
        return (this.bitField0_ & 1) != 0;
    }

    @Override // com.google.protobuf.ApiOrBuilder
    public SourceContext getSourceContext() {
        SourceContext sourceContext = this.sourceContext_;
        return sourceContext == null ? SourceContext.getDefaultInstance() : sourceContext;
    }

    @Override // com.google.protobuf.ApiOrBuilder
    public SourceContextOrBuilder getSourceContextOrBuilder() {
        SourceContext sourceContext = this.sourceContext_;
        return sourceContext == null ? SourceContext.getDefaultInstance() : sourceContext;
    }

    @Override // com.google.protobuf.ApiOrBuilder
    public List<Mixin> getMixinsList() {
        return this.mixins_;
    }

    @Override // com.google.protobuf.ApiOrBuilder
    public List<? extends MixinOrBuilder> getMixinsOrBuilderList() {
        return this.mixins_;
    }

    @Override // com.google.protobuf.ApiOrBuilder
    public int getMixinsCount() {
        return this.mixins_.size();
    }

    @Override // com.google.protobuf.ApiOrBuilder
    public Mixin getMixins(int index) {
        return this.mixins_.get(index);
    }

    @Override // com.google.protobuf.ApiOrBuilder
    public MixinOrBuilder getMixinsOrBuilder(int index) {
        return this.mixins_.get(index);
    }

    @Override // com.google.protobuf.ApiOrBuilder
    public int getSyntaxValue() {
        return this.syntax_;
    }

    @Override // com.google.protobuf.ApiOrBuilder
    public Syntax getSyntax() {
        Syntax syntaxForNumber = Syntax.forNumber(this.syntax_);
        return syntaxForNumber == null ? Syntax.UNRECOGNIZED : syntaxForNumber;
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
        for (int i = 0; i < this.methods_.size(); i++) {
            output.writeMessage(2, this.methods_.get(i));
        }
        for (int i2 = 0; i2 < this.options_.size(); i2++) {
            output.writeMessage(3, this.options_.get(i2));
        }
        if (!GeneratedMessage.isStringEmpty(this.version_)) {
            GeneratedMessage.writeString(output, 4, this.version_);
        }
        if ((1 & this.bitField0_) != 0) {
            output.writeMessage(5, getSourceContext());
        }
        for (int i3 = 0; i3 < this.mixins_.size(); i3++) {
            output.writeMessage(6, this.mixins_.get(i3));
        }
        if (this.syntax_ != Syntax.SYNTAX_PROTO2.getNumber()) {
            output.writeEnum(7, this.syntax_);
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
        for (int i2 = 0; i2 < this.methods_.size(); i2++) {
            iComputeStringSize += CodedOutputStream.computeMessageSize(2, this.methods_.get(i2));
        }
        for (int i3 = 0; i3 < this.options_.size(); i3++) {
            iComputeStringSize += CodedOutputStream.computeMessageSize(3, this.options_.get(i3));
        }
        if (!GeneratedMessage.isStringEmpty(this.version_)) {
            iComputeStringSize += GeneratedMessage.computeStringSize(4, this.version_);
        }
        if ((1 & this.bitField0_) != 0) {
            iComputeStringSize += CodedOutputStream.computeMessageSize(5, getSourceContext());
        }
        for (int i4 = 0; i4 < this.mixins_.size(); i4++) {
            iComputeStringSize += CodedOutputStream.computeMessageSize(6, this.mixins_.get(i4));
        }
        if (this.syntax_ != Syntax.SYNTAX_PROTO2.getNumber()) {
            iComputeStringSize += CodedOutputStream.computeEnumSize(7, this.syntax_);
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
        if (!(obj instanceof Api)) {
            return super.equals(obj);
        }
        Api api = (Api) obj;
        if (getName().equals(api.getName()) && getMethodsList().equals(api.getMethodsList()) && getOptionsList().equals(api.getOptionsList()) && getVersion().equals(api.getVersion()) && hasSourceContext() == api.hasSourceContext()) {
            return (!hasSourceContext() || getSourceContext().equals(api.getSourceContext())) && getMixinsList().equals(api.getMixinsList()) && this.syntax_ == api.syntax_ && getUnknownFields().equals(api.getUnknownFields());
        }
        return false;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public int hashCode() {
        if (this.memoizedHashCode != 0) {
            return this.memoizedHashCode;
        }
        int iHashCode = ((((779 + getDescriptor().hashCode()) * 37) + 1) * 53) + getName().hashCode();
        if (getMethodsCount() > 0) {
            iHashCode = (((iHashCode * 37) + 2) * 53) + getMethodsList().hashCode();
        }
        if (getOptionsCount() > 0) {
            iHashCode = (((iHashCode * 37) + 3) * 53) + getOptionsList().hashCode();
        }
        int iHashCode2 = (((iHashCode * 37) + 4) * 53) + getVersion().hashCode();
        if (hasSourceContext()) {
            iHashCode2 = (((iHashCode2 * 37) + 5) * 53) + getSourceContext().hashCode();
        }
        if (getMixinsCount() > 0) {
            iHashCode2 = (((iHashCode2 * 37) + 6) * 53) + getMixinsList().hashCode();
        }
        int iHashCode3 = (((((iHashCode2 * 37) + 7) * 53) + this.syntax_) * 29) + getUnknownFields().hashCode();
        this.memoizedHashCode = iHashCode3;
        return iHashCode3;
    }

    public static Api parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(data);
    }

    public static Api parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(data, extensionRegistry);
    }

    public static Api parseFrom(ByteString data) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(data);
    }

    public static Api parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(data, extensionRegistry);
    }

    public static Api parseFrom(byte[] data) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(data);
    }

    public static Api parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(data, extensionRegistry);
    }

    public static Api parseFrom(InputStream input) throws IOException {
        return (Api) GeneratedMessage.parseWithIOException(PARSER, input);
    }

    public static Api parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (Api) GeneratedMessage.parseWithIOException(PARSER, input, extensionRegistry);
    }

    public static Api parseDelimitedFrom(InputStream input) throws IOException {
        return (Api) GeneratedMessage.parseDelimitedWithIOException(PARSER, input);
    }

    public static Api parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (Api) GeneratedMessage.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
    }

    public static Api parseFrom(CodedInputStream input) throws IOException {
        return (Api) GeneratedMessage.parseWithIOException(PARSER, input);
    }

    public static Api parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (Api) GeneratedMessage.parseWithIOException(PARSER, input, extensionRegistry);
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder newBuilderForType() {
        return newBuilder();
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(Api prototype) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder toBuilder() {
        return this == DEFAULT_INSTANCE ? new Builder((AnonymousClass1) null) : new Builder((AnonymousClass1) null).mergeFrom(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.AbstractMessage
    public Builder newBuilderForType(AbstractMessage.BuilderParent parent) {
        return new Builder(parent, null);
    }

    public static final class Builder extends GeneratedMessage.Builder<Builder> implements ApiOrBuilder {
        private int bitField0_;
        private RepeatedFieldBuilder<Method, Method.Builder, MethodOrBuilder> methodsBuilder_;
        private List<Method> methods_;
        private RepeatedFieldBuilder<Mixin, Mixin.Builder, MixinOrBuilder> mixinsBuilder_;
        private List<Mixin> mixins_;
        private Object name_;
        private RepeatedFieldBuilder<Option, Option.Builder, OptionOrBuilder> optionsBuilder_;
        private List<Option> options_;
        private SingleFieldBuilder<SourceContext, SourceContext.Builder, SourceContextOrBuilder> sourceContextBuilder_;
        private SourceContext sourceContext_;
        private int syntax_;
        private Object version_;

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
            return ApiProto.internal_static_google_protobuf_Api_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder
        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return ApiProto.internal_static_google_protobuf_Api_fieldAccessorTable.ensureFieldAccessorsInitialized(Api.class, Builder.class);
        }

        private Builder() {
            this.name_ = "";
            this.methods_ = Collections.emptyList();
            this.options_ = Collections.emptyList();
            this.version_ = "";
            this.mixins_ = Collections.emptyList();
            this.syntax_ = 0;
            maybeForceBuilderInitialization();
        }

        private Builder(AbstractMessage.BuilderParent parent) {
            super(parent);
            this.name_ = "";
            this.methods_ = Collections.emptyList();
            this.options_ = Collections.emptyList();
            this.version_ = "";
            this.mixins_ = Collections.emptyList();
            this.syntax_ = 0;
            maybeForceBuilderInitialization();
        }

        private void maybeForceBuilderInitialization() {
            if (GeneratedMessage.alwaysUseFieldBuilders) {
                getMethodsFieldBuilder();
                getOptionsFieldBuilder();
                getSourceContextFieldBuilder();
                getMixinsFieldBuilder();
            }
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder clear() {
            super.clear();
            this.bitField0_ = 0;
            this.name_ = "";
            RepeatedFieldBuilder<Method, Method.Builder, MethodOrBuilder> repeatedFieldBuilder = this.methodsBuilder_;
            if (repeatedFieldBuilder == null) {
                this.methods_ = Collections.emptyList();
            } else {
                this.methods_ = null;
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
            this.version_ = "";
            this.sourceContext_ = null;
            SingleFieldBuilder<SourceContext, SourceContext.Builder, SourceContextOrBuilder> singleFieldBuilder = this.sourceContextBuilder_;
            if (singleFieldBuilder != null) {
                singleFieldBuilder.dispose();
                this.sourceContextBuilder_ = null;
            }
            RepeatedFieldBuilder<Mixin, Mixin.Builder, MixinOrBuilder> repeatedFieldBuilder3 = this.mixinsBuilder_;
            if (repeatedFieldBuilder3 == null) {
                this.mixins_ = Collections.emptyList();
            } else {
                this.mixins_ = null;
                repeatedFieldBuilder3.clear();
            }
            this.bitField0_ &= -33;
            this.syntax_ = 0;
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
        public Descriptors.Descriptor getDescriptorForType() {
            return ApiProto.internal_static_google_protobuf_Api_descriptor;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public Api getDefaultInstanceForType() {
            return Api.getDefaultInstance();
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Api build() {
            Api apiBuildPartial = buildPartial();
            if (apiBuildPartial.isInitialized()) {
                return apiBuildPartial;
            }
            throw newUninitializedMessageException((Message) apiBuildPartial);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Api buildPartial() {
            Api api = new Api(this, null);
            buildPartialRepeatedFields(api);
            if (this.bitField0_ != 0) {
                buildPartial0(api);
            }
            onBuilt();
            return api;
        }

        private void buildPartialRepeatedFields(Api result) {
            RepeatedFieldBuilder<Method, Method.Builder, MethodOrBuilder> repeatedFieldBuilder = this.methodsBuilder_;
            if (repeatedFieldBuilder != null) {
                result.methods_ = repeatedFieldBuilder.build();
            } else {
                if ((this.bitField0_ & 2) != 0) {
                    this.methods_ = Collections.unmodifiableList(this.methods_);
                    this.bitField0_ &= -3;
                }
                result.methods_ = this.methods_;
            }
            RepeatedFieldBuilder<Option, Option.Builder, OptionOrBuilder> repeatedFieldBuilder2 = this.optionsBuilder_;
            if (repeatedFieldBuilder2 != null) {
                result.options_ = repeatedFieldBuilder2.build();
            } else {
                if ((this.bitField0_ & 4) != 0) {
                    this.options_ = Collections.unmodifiableList(this.options_);
                    this.bitField0_ &= -5;
                }
                result.options_ = this.options_;
            }
            RepeatedFieldBuilder<Mixin, Mixin.Builder, MixinOrBuilder> repeatedFieldBuilder3 = this.mixinsBuilder_;
            if (repeatedFieldBuilder3 != null) {
                result.mixins_ = repeatedFieldBuilder3.build();
                return;
            }
            if ((this.bitField0_ & 32) != 0) {
                this.mixins_ = Collections.unmodifiableList(this.mixins_);
                this.bitField0_ &= -33;
            }
            result.mixins_ = this.mixins_;
        }

        private void buildPartial0(Api result) {
            int i;
            SourceContext sourceContext;
            int i2 = this.bitField0_;
            if ((i2 & 1) != 0) {
                result.name_ = this.name_;
            }
            if ((i2 & 8) != 0) {
                result.version_ = this.version_;
            }
            if ((i2 & 16) != 0) {
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
            if ((i2 & 64) != 0) {
                result.syntax_ = this.syntax_;
            }
            Api.access$1076(result, i);
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public Builder mergeFrom(Message other) {
            if (other instanceof Api) {
                return mergeFrom((Api) other);
            }
            super.mergeFrom(other);
            return this;
        }

        public Builder mergeFrom(Api other) {
            if (other == Api.getDefaultInstance()) {
                return this;
            }
            if (!other.getName().isEmpty()) {
                this.name_ = other.name_;
                this.bitField0_ |= 1;
                onChanged();
            }
            if (this.methodsBuilder_ == null) {
                if (!other.methods_.isEmpty()) {
                    if (this.methods_.isEmpty()) {
                        this.methods_ = other.methods_;
                        this.bitField0_ &= -3;
                    } else {
                        ensureMethodsIsMutable();
                        this.methods_.addAll(other.methods_);
                    }
                    onChanged();
                }
            } else if (!other.methods_.isEmpty()) {
                if (!this.methodsBuilder_.isEmpty()) {
                    this.methodsBuilder_.addAllMessages(other.methods_);
                } else {
                    this.methodsBuilder_.dispose();
                    this.methodsBuilder_ = null;
                    this.methods_ = other.methods_;
                    this.bitField0_ &= -3;
                    this.methodsBuilder_ = GeneratedMessage.alwaysUseFieldBuilders ? getMethodsFieldBuilder() : null;
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
            if (!other.getVersion().isEmpty()) {
                this.version_ = other.version_;
                this.bitField0_ |= 8;
                onChanged();
            }
            if (other.hasSourceContext()) {
                mergeSourceContext(other.getSourceContext());
            }
            if (this.mixinsBuilder_ == null) {
                if (!other.mixins_.isEmpty()) {
                    if (this.mixins_.isEmpty()) {
                        this.mixins_ = other.mixins_;
                        this.bitField0_ &= -33;
                    } else {
                        ensureMixinsIsMutable();
                        this.mixins_.addAll(other.mixins_);
                    }
                    onChanged();
                }
            } else if (!other.mixins_.isEmpty()) {
                if (!this.mixinsBuilder_.isEmpty()) {
                    this.mixinsBuilder_.addAllMessages(other.mixins_);
                } else {
                    this.mixinsBuilder_.dispose();
                    this.mixinsBuilder_ = null;
                    this.mixins_ = other.mixins_;
                    this.bitField0_ &= -33;
                    this.mixinsBuilder_ = GeneratedMessage.alwaysUseFieldBuilders ? getMixinsFieldBuilder() : null;
                }
            }
            if (other.syntax_ != 0) {
                setSyntaxValue(other.getSyntaxValue());
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
                                Method method = (Method) input.readMessage(Method.parser(), extensionRegistry);
                                RepeatedFieldBuilder<Method, Method.Builder, MethodOrBuilder> repeatedFieldBuilder = this.methodsBuilder_;
                                if (repeatedFieldBuilder == null) {
                                    ensureMethodsIsMutable();
                                    this.methods_.add(method);
                                } else {
                                    repeatedFieldBuilder.addMessage(method);
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
                                this.version_ = input.readStringRequireUtf8();
                                this.bitField0_ |= 8;
                            } else if (tag == 42) {
                                input.readMessage(getSourceContextFieldBuilder().getBuilder(), extensionRegistry);
                                this.bitField0_ |= 16;
                            } else if (tag == 50) {
                                Mixin mixin = (Mixin) input.readMessage(Mixin.parser(), extensionRegistry);
                                RepeatedFieldBuilder<Mixin, Mixin.Builder, MixinOrBuilder> repeatedFieldBuilder3 = this.mixinsBuilder_;
                                if (repeatedFieldBuilder3 == null) {
                                    ensureMixinsIsMutable();
                                    this.mixins_.add(mixin);
                                } else {
                                    repeatedFieldBuilder3.addMessage(mixin);
                                }
                            } else if (tag == 56) {
                                this.syntax_ = input.readEnum();
                                this.bitField0_ |= 64;
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

        @Override // com.google.protobuf.ApiOrBuilder
        public String getName() {
            Object obj = this.name_;
            if (!(obj instanceof String)) {
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.name_ = stringUtf8;
                return stringUtf8;
            }
            return (String) obj;
        }

        @Override // com.google.protobuf.ApiOrBuilder
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
            this.name_ = Api.getDefaultInstance().getName();
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

        private void ensureMethodsIsMutable() {
            if ((this.bitField0_ & 2) == 0) {
                this.methods_ = new ArrayList(this.methods_);
                this.bitField0_ |= 2;
            }
        }

        @Override // com.google.protobuf.ApiOrBuilder
        public List<Method> getMethodsList() {
            RepeatedFieldBuilder<Method, Method.Builder, MethodOrBuilder> repeatedFieldBuilder = this.methodsBuilder_;
            if (repeatedFieldBuilder == null) {
                return Collections.unmodifiableList(this.methods_);
            }
            return repeatedFieldBuilder.getMessageList();
        }

        @Override // com.google.protobuf.ApiOrBuilder
        public int getMethodsCount() {
            RepeatedFieldBuilder<Method, Method.Builder, MethodOrBuilder> repeatedFieldBuilder = this.methodsBuilder_;
            if (repeatedFieldBuilder == null) {
                return this.methods_.size();
            }
            return repeatedFieldBuilder.getCount();
        }

        @Override // com.google.protobuf.ApiOrBuilder
        public Method getMethods(int index) {
            RepeatedFieldBuilder<Method, Method.Builder, MethodOrBuilder> repeatedFieldBuilder = this.methodsBuilder_;
            if (repeatedFieldBuilder == null) {
                return this.methods_.get(index);
            }
            return (Method) repeatedFieldBuilder.getMessage(index);
        }

        public Builder setMethods(int index, Method value) {
            RepeatedFieldBuilder<Method, Method.Builder, MethodOrBuilder> repeatedFieldBuilder = this.methodsBuilder_;
            if (repeatedFieldBuilder == null) {
                value.getClass();
                ensureMethodsIsMutable();
                this.methods_.set(index, value);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.setMessage(index, value);
            return this;
        }

        public Builder setMethods(int index, Method.Builder builderForValue) {
            RepeatedFieldBuilder<Method, Method.Builder, MethodOrBuilder> repeatedFieldBuilder = this.methodsBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureMethodsIsMutable();
                this.methods_.set(index, builderForValue.build());
                onChanged();
                return this;
            }
            repeatedFieldBuilder.setMessage(index, builderForValue.build());
            return this;
        }

        public Builder addMethods(Method value) {
            RepeatedFieldBuilder<Method, Method.Builder, MethodOrBuilder> repeatedFieldBuilder = this.methodsBuilder_;
            if (repeatedFieldBuilder == null) {
                value.getClass();
                ensureMethodsIsMutable();
                this.methods_.add(value);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(value);
            return this;
        }

        public Builder addMethods(int index, Method value) {
            RepeatedFieldBuilder<Method, Method.Builder, MethodOrBuilder> repeatedFieldBuilder = this.methodsBuilder_;
            if (repeatedFieldBuilder == null) {
                value.getClass();
                ensureMethodsIsMutable();
                this.methods_.add(index, value);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(index, value);
            return this;
        }

        public Builder addMethods(Method.Builder builderForValue) {
            RepeatedFieldBuilder<Method, Method.Builder, MethodOrBuilder> repeatedFieldBuilder = this.methodsBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureMethodsIsMutable();
                this.methods_.add(builderForValue.build());
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(builderForValue.build());
            return this;
        }

        public Builder addMethods(int index, Method.Builder builderForValue) {
            RepeatedFieldBuilder<Method, Method.Builder, MethodOrBuilder> repeatedFieldBuilder = this.methodsBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureMethodsIsMutable();
                this.methods_.add(index, builderForValue.build());
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(index, builderForValue.build());
            return this;
        }

        public Builder addAllMethods(Iterable<? extends Method> values) {
            RepeatedFieldBuilder<Method, Method.Builder, MethodOrBuilder> repeatedFieldBuilder = this.methodsBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureMethodsIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.methods_);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addAllMessages(values);
            return this;
        }

        public Builder clearMethods() {
            RepeatedFieldBuilder<Method, Method.Builder, MethodOrBuilder> repeatedFieldBuilder = this.methodsBuilder_;
            if (repeatedFieldBuilder == null) {
                this.methods_ = Collections.emptyList();
                this.bitField0_ &= -3;
                onChanged();
                return this;
            }
            repeatedFieldBuilder.clear();
            return this;
        }

        public Builder removeMethods(int index) {
            RepeatedFieldBuilder<Method, Method.Builder, MethodOrBuilder> repeatedFieldBuilder = this.methodsBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureMethodsIsMutable();
                this.methods_.remove(index);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.remove(index);
            return this;
        }

        public Method.Builder getMethodsBuilder(int index) {
            return (Method.Builder) getMethodsFieldBuilder().getBuilder(index);
        }

        @Override // com.google.protobuf.ApiOrBuilder
        public MethodOrBuilder getMethodsOrBuilder(int index) {
            RepeatedFieldBuilder<Method, Method.Builder, MethodOrBuilder> repeatedFieldBuilder = this.methodsBuilder_;
            if (repeatedFieldBuilder == null) {
                return this.methods_.get(index);
            }
            return (MethodOrBuilder) repeatedFieldBuilder.getMessageOrBuilder(index);
        }

        @Override // com.google.protobuf.ApiOrBuilder
        public List<? extends MethodOrBuilder> getMethodsOrBuilderList() {
            RepeatedFieldBuilder<Method, Method.Builder, MethodOrBuilder> repeatedFieldBuilder = this.methodsBuilder_;
            if (repeatedFieldBuilder != null) {
                return repeatedFieldBuilder.getMessageOrBuilderList();
            }
            return Collections.unmodifiableList(this.methods_);
        }

        public Method.Builder addMethodsBuilder() {
            return (Method.Builder) getMethodsFieldBuilder().addBuilder(Method.getDefaultInstance());
        }

        public Method.Builder addMethodsBuilder(int index) {
            return (Method.Builder) getMethodsFieldBuilder().addBuilder(index, Method.getDefaultInstance());
        }

        public List<Method.Builder> getMethodsBuilderList() {
            return getMethodsFieldBuilder().getBuilderList();
        }

        private RepeatedFieldBuilder<Method, Method.Builder, MethodOrBuilder> getMethodsFieldBuilder() {
            if (this.methodsBuilder_ == null) {
                this.methodsBuilder_ = new RepeatedFieldBuilder<>(this.methods_, (this.bitField0_ & 2) != 0, getParentForChildren(), isClean());
                this.methods_ = null;
            }
            return this.methodsBuilder_;
        }

        private void ensureOptionsIsMutable() {
            if ((this.bitField0_ & 4) == 0) {
                this.options_ = new ArrayList(this.options_);
                this.bitField0_ |= 4;
            }
        }

        @Override // com.google.protobuf.ApiOrBuilder
        public List<Option> getOptionsList() {
            RepeatedFieldBuilder<Option, Option.Builder, OptionOrBuilder> repeatedFieldBuilder = this.optionsBuilder_;
            if (repeatedFieldBuilder == null) {
                return Collections.unmodifiableList(this.options_);
            }
            return repeatedFieldBuilder.getMessageList();
        }

        @Override // com.google.protobuf.ApiOrBuilder
        public int getOptionsCount() {
            RepeatedFieldBuilder<Option, Option.Builder, OptionOrBuilder> repeatedFieldBuilder = this.optionsBuilder_;
            if (repeatedFieldBuilder == null) {
                return this.options_.size();
            }
            return repeatedFieldBuilder.getCount();
        }

        @Override // com.google.protobuf.ApiOrBuilder
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

        @Override // com.google.protobuf.ApiOrBuilder
        public OptionOrBuilder getOptionsOrBuilder(int index) {
            RepeatedFieldBuilder<Option, Option.Builder, OptionOrBuilder> repeatedFieldBuilder = this.optionsBuilder_;
            if (repeatedFieldBuilder == null) {
                return this.options_.get(index);
            }
            return (OptionOrBuilder) repeatedFieldBuilder.getMessageOrBuilder(index);
        }

        @Override // com.google.protobuf.ApiOrBuilder
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

        @Override // com.google.protobuf.ApiOrBuilder
        public String getVersion() {
            Object obj = this.version_;
            if (!(obj instanceof String)) {
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.version_ = stringUtf8;
                return stringUtf8;
            }
            return (String) obj;
        }

        @Override // com.google.protobuf.ApiOrBuilder
        public ByteString getVersionBytes() {
            Object obj = this.version_;
            if (obj instanceof String) {
                ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.version_ = byteStringCopyFromUtf8;
                return byteStringCopyFromUtf8;
            }
            return (ByteString) obj;
        }

        public Builder setVersion(String value) {
            value.getClass();
            this.version_ = value;
            this.bitField0_ |= 8;
            onChanged();
            return this;
        }

        public Builder clearVersion() {
            this.version_ = Api.getDefaultInstance().getVersion();
            this.bitField0_ &= -9;
            onChanged();
            return this;
        }

        public Builder setVersionBytes(ByteString value) {
            value.getClass();
            AbstractMessageLite.checkByteStringIsUtf8(value);
            this.version_ = value;
            this.bitField0_ |= 8;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.ApiOrBuilder
        public boolean hasSourceContext() {
            return (this.bitField0_ & 16) != 0;
        }

        @Override // com.google.protobuf.ApiOrBuilder
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
            this.bitField0_ |= 16;
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
            this.bitField0_ |= 16;
            onChanged();
            return this;
        }

        public Builder mergeSourceContext(SourceContext value) {
            SourceContext sourceContext;
            SingleFieldBuilder<SourceContext, SourceContext.Builder, SourceContextOrBuilder> singleFieldBuilder = this.sourceContextBuilder_;
            if (singleFieldBuilder == null) {
                if ((this.bitField0_ & 16) != 0 && (sourceContext = this.sourceContext_) != null && sourceContext != SourceContext.getDefaultInstance()) {
                    getSourceContextBuilder().mergeFrom(value);
                } else {
                    this.sourceContext_ = value;
                }
            } else {
                singleFieldBuilder.mergeFrom(value);
            }
            if (this.sourceContext_ != null) {
                this.bitField0_ |= 16;
                onChanged();
            }
            return this;
        }

        public Builder clearSourceContext() {
            this.bitField0_ &= -17;
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
            this.bitField0_ |= 16;
            onChanged();
            return (SourceContext.Builder) getSourceContextFieldBuilder().getBuilder();
        }

        @Override // com.google.protobuf.ApiOrBuilder
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

        private void ensureMixinsIsMutable() {
            if ((this.bitField0_ & 32) == 0) {
                this.mixins_ = new ArrayList(this.mixins_);
                this.bitField0_ |= 32;
            }
        }

        @Override // com.google.protobuf.ApiOrBuilder
        public List<Mixin> getMixinsList() {
            RepeatedFieldBuilder<Mixin, Mixin.Builder, MixinOrBuilder> repeatedFieldBuilder = this.mixinsBuilder_;
            if (repeatedFieldBuilder == null) {
                return Collections.unmodifiableList(this.mixins_);
            }
            return repeatedFieldBuilder.getMessageList();
        }

        @Override // com.google.protobuf.ApiOrBuilder
        public int getMixinsCount() {
            RepeatedFieldBuilder<Mixin, Mixin.Builder, MixinOrBuilder> repeatedFieldBuilder = this.mixinsBuilder_;
            if (repeatedFieldBuilder == null) {
                return this.mixins_.size();
            }
            return repeatedFieldBuilder.getCount();
        }

        @Override // com.google.protobuf.ApiOrBuilder
        public Mixin getMixins(int index) {
            RepeatedFieldBuilder<Mixin, Mixin.Builder, MixinOrBuilder> repeatedFieldBuilder = this.mixinsBuilder_;
            if (repeatedFieldBuilder == null) {
                return this.mixins_.get(index);
            }
            return (Mixin) repeatedFieldBuilder.getMessage(index);
        }

        public Builder setMixins(int index, Mixin value) {
            RepeatedFieldBuilder<Mixin, Mixin.Builder, MixinOrBuilder> repeatedFieldBuilder = this.mixinsBuilder_;
            if (repeatedFieldBuilder == null) {
                value.getClass();
                ensureMixinsIsMutable();
                this.mixins_.set(index, value);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.setMessage(index, value);
            return this;
        }

        public Builder setMixins(int index, Mixin.Builder builderForValue) {
            RepeatedFieldBuilder<Mixin, Mixin.Builder, MixinOrBuilder> repeatedFieldBuilder = this.mixinsBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureMixinsIsMutable();
                this.mixins_.set(index, builderForValue.build());
                onChanged();
                return this;
            }
            repeatedFieldBuilder.setMessage(index, builderForValue.build());
            return this;
        }

        public Builder addMixins(Mixin value) {
            RepeatedFieldBuilder<Mixin, Mixin.Builder, MixinOrBuilder> repeatedFieldBuilder = this.mixinsBuilder_;
            if (repeatedFieldBuilder == null) {
                value.getClass();
                ensureMixinsIsMutable();
                this.mixins_.add(value);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(value);
            return this;
        }

        public Builder addMixins(int index, Mixin value) {
            RepeatedFieldBuilder<Mixin, Mixin.Builder, MixinOrBuilder> repeatedFieldBuilder = this.mixinsBuilder_;
            if (repeatedFieldBuilder == null) {
                value.getClass();
                ensureMixinsIsMutable();
                this.mixins_.add(index, value);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(index, value);
            return this;
        }

        public Builder addMixins(Mixin.Builder builderForValue) {
            RepeatedFieldBuilder<Mixin, Mixin.Builder, MixinOrBuilder> repeatedFieldBuilder = this.mixinsBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureMixinsIsMutable();
                this.mixins_.add(builderForValue.build());
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(builderForValue.build());
            return this;
        }

        public Builder addMixins(int index, Mixin.Builder builderForValue) {
            RepeatedFieldBuilder<Mixin, Mixin.Builder, MixinOrBuilder> repeatedFieldBuilder = this.mixinsBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureMixinsIsMutable();
                this.mixins_.add(index, builderForValue.build());
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(index, builderForValue.build());
            return this;
        }

        public Builder addAllMixins(Iterable<? extends Mixin> values) {
            RepeatedFieldBuilder<Mixin, Mixin.Builder, MixinOrBuilder> repeatedFieldBuilder = this.mixinsBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureMixinsIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.mixins_);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addAllMessages(values);
            return this;
        }

        public Builder clearMixins() {
            RepeatedFieldBuilder<Mixin, Mixin.Builder, MixinOrBuilder> repeatedFieldBuilder = this.mixinsBuilder_;
            if (repeatedFieldBuilder == null) {
                this.mixins_ = Collections.emptyList();
                this.bitField0_ &= -33;
                onChanged();
                return this;
            }
            repeatedFieldBuilder.clear();
            return this;
        }

        public Builder removeMixins(int index) {
            RepeatedFieldBuilder<Mixin, Mixin.Builder, MixinOrBuilder> repeatedFieldBuilder = this.mixinsBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureMixinsIsMutable();
                this.mixins_.remove(index);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.remove(index);
            return this;
        }

        public Mixin.Builder getMixinsBuilder(int index) {
            return (Mixin.Builder) getMixinsFieldBuilder().getBuilder(index);
        }

        @Override // com.google.protobuf.ApiOrBuilder
        public MixinOrBuilder getMixinsOrBuilder(int index) {
            RepeatedFieldBuilder<Mixin, Mixin.Builder, MixinOrBuilder> repeatedFieldBuilder = this.mixinsBuilder_;
            if (repeatedFieldBuilder == null) {
                return this.mixins_.get(index);
            }
            return (MixinOrBuilder) repeatedFieldBuilder.getMessageOrBuilder(index);
        }

        @Override // com.google.protobuf.ApiOrBuilder
        public List<? extends MixinOrBuilder> getMixinsOrBuilderList() {
            RepeatedFieldBuilder<Mixin, Mixin.Builder, MixinOrBuilder> repeatedFieldBuilder = this.mixinsBuilder_;
            if (repeatedFieldBuilder != null) {
                return repeatedFieldBuilder.getMessageOrBuilderList();
            }
            return Collections.unmodifiableList(this.mixins_);
        }

        public Mixin.Builder addMixinsBuilder() {
            return (Mixin.Builder) getMixinsFieldBuilder().addBuilder(Mixin.getDefaultInstance());
        }

        public Mixin.Builder addMixinsBuilder(int index) {
            return (Mixin.Builder) getMixinsFieldBuilder().addBuilder(index, Mixin.getDefaultInstance());
        }

        public List<Mixin.Builder> getMixinsBuilderList() {
            return getMixinsFieldBuilder().getBuilderList();
        }

        private RepeatedFieldBuilder<Mixin, Mixin.Builder, MixinOrBuilder> getMixinsFieldBuilder() {
            if (this.mixinsBuilder_ == null) {
                this.mixinsBuilder_ = new RepeatedFieldBuilder<>(this.mixins_, (this.bitField0_ & 32) != 0, getParentForChildren(), isClean());
                this.mixins_ = null;
            }
            return this.mixinsBuilder_;
        }

        @Override // com.google.protobuf.ApiOrBuilder
        public int getSyntaxValue() {
            return this.syntax_;
        }

        public Builder setSyntaxValue(int value) {
            this.syntax_ = value;
            this.bitField0_ |= 64;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.ApiOrBuilder
        public Syntax getSyntax() {
            Syntax syntaxForNumber = Syntax.forNumber(this.syntax_);
            return syntaxForNumber == null ? Syntax.UNRECOGNIZED : syntaxForNumber;
        }

        public Builder setSyntax(Syntax value) {
            value.getClass();
            this.bitField0_ |= 64;
            this.syntax_ = value.getNumber();
            onChanged();
            return this;
        }

        public Builder clearSyntax() {
            this.bitField0_ &= -65;
            this.syntax_ = 0;
            onChanged();
            return this;
        }
    }

    public static Api getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* JADX INFO: renamed from: com.google.protobuf.Api$1, reason: invalid class name */
    class AnonymousClass1 extends AbstractParser<Api> {
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
        public Api parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            Builder builderNewBuilder = Api.newBuilder();
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

    public static Parser<Api> parser() {
        return PARSER;
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Parser<Api> getParserForType() {
        return PARSER;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
    public Api getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }
}
