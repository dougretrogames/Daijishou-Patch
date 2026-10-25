package com.google.protobuf;

import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes4.dex */
public final class Value extends GeneratedMessage implements ValueOrBuilder {
    public static final int BOOL_VALUE_FIELD_NUMBER = 4;
    private static final Value DEFAULT_INSTANCE;
    public static final int LIST_VALUE_FIELD_NUMBER = 6;
    public static final int NULL_VALUE_FIELD_NUMBER = 1;
    public static final int NUMBER_VALUE_FIELD_NUMBER = 2;
    private static final Parser<Value> PARSER;
    public static final int STRING_VALUE_FIELD_NUMBER = 3;
    public static final int STRUCT_VALUE_FIELD_NUMBER = 5;
    private static final long serialVersionUID = 0;
    private int kindCase_;
    private Object kind_;
    private byte memoizedIsInitialized;

    /* synthetic */ Value(GeneratedMessage.Builder builder, AnonymousClass1 anonymousClass1) {
        this(builder);
    }

    static {
        RuntimeVersion.validateProtobufGencodeVersion(RuntimeVersion.RuntimeDomain.PUBLIC, 4, 27, 2, "", Value.class.getName());
        DEFAULT_INSTANCE = new Value();
        PARSER = new AnonymousClass1();
    }

    private Value(GeneratedMessage.Builder<?> builder) {
        super(builder);
        this.kindCase_ = 0;
        this.memoizedIsInitialized = (byte) -1;
    }

    private Value() {
        this.kindCase_ = 0;
        this.memoizedIsInitialized = (byte) -1;
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return StructProto.internal_static_google_protobuf_Value_descriptor;
    }

    @Override // com.google.protobuf.GeneratedMessage
    protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
        return StructProto.internal_static_google_protobuf_Value_fieldAccessorTable.ensureFieldAccessorsInitialized(Value.class, Builder.class);
    }

    public enum KindCase implements Internal.EnumLite, AbstractMessageLite.InternalOneOfEnum {
        NULL_VALUE(1),
        NUMBER_VALUE(2),
        STRING_VALUE(3),
        BOOL_VALUE(4),
        STRUCT_VALUE(5),
        LIST_VALUE(6),
        KIND_NOT_SET(0);

        private final int value;

        KindCase(int value) {
            this.value = value;
        }

        @Deprecated
        public static KindCase valueOf(int value) {
            return forNumber(value);
        }

        public static KindCase forNumber(int value) {
            switch (value) {
                case 0:
                    return KIND_NOT_SET;
                case 1:
                    return NULL_VALUE;
                case 2:
                    return NUMBER_VALUE;
                case 3:
                    return STRING_VALUE;
                case 4:
                    return BOOL_VALUE;
                case 5:
                    return STRUCT_VALUE;
                case 6:
                    return LIST_VALUE;
                default:
                    return null;
            }
        }

        @Override // com.google.protobuf.Internal.EnumLite
        public int getNumber() {
            return this.value;
        }
    }

    @Override // com.google.protobuf.ValueOrBuilder
    public KindCase getKindCase() {
        return KindCase.forNumber(this.kindCase_);
    }

    @Override // com.google.protobuf.ValueOrBuilder
    public boolean hasNullValue() {
        return this.kindCase_ == 1;
    }

    @Override // com.google.protobuf.ValueOrBuilder
    public int getNullValueValue() {
        if (this.kindCase_ == 1) {
            return ((Integer) this.kind_).intValue();
        }
        return 0;
    }

    @Override // com.google.protobuf.ValueOrBuilder
    public NullValue getNullValue() {
        if (this.kindCase_ == 1) {
            NullValue nullValueForNumber = NullValue.forNumber(((Integer) this.kind_).intValue());
            return nullValueForNumber == null ? NullValue.UNRECOGNIZED : nullValueForNumber;
        }
        return NullValue.NULL_VALUE;
    }

    @Override // com.google.protobuf.ValueOrBuilder
    public boolean hasNumberValue() {
        return this.kindCase_ == 2;
    }

    @Override // com.google.protobuf.ValueOrBuilder
    public double getNumberValue() {
        if (this.kindCase_ == 2) {
            return ((Double) this.kind_).doubleValue();
        }
        return 0.0d;
    }

    @Override // com.google.protobuf.ValueOrBuilder
    public boolean hasStringValue() {
        return this.kindCase_ == 3;
    }

    @Override // com.google.protobuf.ValueOrBuilder
    public String getStringValue() {
        Object obj;
        if (this.kindCase_ != 3) {
            obj = "";
        } else {
            obj = this.kind_;
        }
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        if (this.kindCase_ == 3) {
            this.kind_ = stringUtf8;
        }
        return stringUtf8;
    }

    @Override // com.google.protobuf.ValueOrBuilder
    public ByteString getStringValueBytes() {
        Object obj;
        if (this.kindCase_ != 3) {
            obj = "";
        } else {
            obj = this.kind_;
        }
        if (obj instanceof String) {
            ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            if (this.kindCase_ == 3) {
                this.kind_ = byteStringCopyFromUtf8;
            }
            return byteStringCopyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // com.google.protobuf.ValueOrBuilder
    public boolean hasBoolValue() {
        return this.kindCase_ == 4;
    }

    @Override // com.google.protobuf.ValueOrBuilder
    public boolean getBoolValue() {
        if (this.kindCase_ == 4) {
            return ((Boolean) this.kind_).booleanValue();
        }
        return false;
    }

    @Override // com.google.protobuf.ValueOrBuilder
    public boolean hasStructValue() {
        return this.kindCase_ == 5;
    }

    @Override // com.google.protobuf.ValueOrBuilder
    public Struct getStructValue() {
        if (this.kindCase_ == 5) {
            return (Struct) this.kind_;
        }
        return Struct.getDefaultInstance();
    }

    @Override // com.google.protobuf.ValueOrBuilder
    public StructOrBuilder getStructValueOrBuilder() {
        if (this.kindCase_ == 5) {
            return (Struct) this.kind_;
        }
        return Struct.getDefaultInstance();
    }

    @Override // com.google.protobuf.ValueOrBuilder
    public boolean hasListValue() {
        return this.kindCase_ == 6;
    }

    @Override // com.google.protobuf.ValueOrBuilder
    public ListValue getListValue() {
        if (this.kindCase_ == 6) {
            return (ListValue) this.kind_;
        }
        return ListValue.getDefaultInstance();
    }

    @Override // com.google.protobuf.ValueOrBuilder
    public ListValueOrBuilder getListValueOrBuilder() {
        if (this.kindCase_ == 6) {
            return (ListValue) this.kind_;
        }
        return ListValue.getDefaultInstance();
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
        if (this.kindCase_ == 1) {
            output.writeEnum(1, ((Integer) this.kind_).intValue());
        }
        if (this.kindCase_ == 2) {
            output.writeDouble(2, ((Double) this.kind_).doubleValue());
        }
        if (this.kindCase_ == 3) {
            GeneratedMessage.writeString(output, 3, this.kind_);
        }
        if (this.kindCase_ == 4) {
            output.writeBool(4, ((Boolean) this.kind_).booleanValue());
        }
        if (this.kindCase_ == 5) {
            output.writeMessage(5, (Struct) this.kind_);
        }
        if (this.kindCase_ == 6) {
            output.writeMessage(6, (ListValue) this.kind_);
        }
        getUnknownFields().writeTo(output);
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int i = this.memoizedSize;
        if (i != -1) {
            return i;
        }
        int iComputeEnumSize = this.kindCase_ == 1 ? CodedOutputStream.computeEnumSize(1, ((Integer) this.kind_).intValue()) : 0;
        if (this.kindCase_ == 2) {
            iComputeEnumSize += CodedOutputStream.computeDoubleSize(2, ((Double) this.kind_).doubleValue());
        }
        if (this.kindCase_ == 3) {
            iComputeEnumSize += GeneratedMessage.computeStringSize(3, this.kind_);
        }
        if (this.kindCase_ == 4) {
            iComputeEnumSize += CodedOutputStream.computeBoolSize(4, ((Boolean) this.kind_).booleanValue());
        }
        if (this.kindCase_ == 5) {
            iComputeEnumSize += CodedOutputStream.computeMessageSize(5, (Struct) this.kind_);
        }
        if (this.kindCase_ == 6) {
            iComputeEnumSize += CodedOutputStream.computeMessageSize(6, (ListValue) this.kind_);
        }
        int serializedSize = iComputeEnumSize + getUnknownFields().getSerializedSize();
        this.memoizedSize = serializedSize;
        return serializedSize;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public boolean equals(final Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Value)) {
            return super.equals(obj);
        }
        Value value = (Value) obj;
        if (!getKindCase().equals(value.getKindCase())) {
            return false;
        }
        switch (this.kindCase_) {
            case 1:
                if (getNullValueValue() != value.getNullValueValue()) {
                    return false;
                }
                break;
            case 2:
                if (Double.doubleToLongBits(getNumberValue()) != Double.doubleToLongBits(value.getNumberValue())) {
                    return false;
                }
                break;
            case 3:
                if (!getStringValue().equals(value.getStringValue())) {
                    return false;
                }
                break;
            case 4:
                if (getBoolValue() != value.getBoolValue()) {
                    return false;
                }
                break;
            case 5:
                if (!getStructValue().equals(value.getStructValue())) {
                    return false;
                }
                break;
            case 6:
                if (!getListValue().equals(value.getListValue())) {
                    return false;
                }
                break;
        }
        return getUnknownFields().equals(value.getUnknownFields());
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public int hashCode() {
        int i;
        int nullValueValue;
        if (this.memoizedHashCode != 0) {
            return this.memoizedHashCode;
        }
        int iHashCode = 779 + getDescriptor().hashCode();
        switch (this.kindCase_) {
            case 1:
                i = ((iHashCode * 37) + 1) * 53;
                nullValueValue = getNullValueValue();
                break;
            case 2:
                i = ((iHashCode * 37) + 2) * 53;
                nullValueValue = Internal.hashLong(Double.doubleToLongBits(getNumberValue()));
                break;
            case 3:
                i = ((iHashCode * 37) + 3) * 53;
                nullValueValue = getStringValue().hashCode();
                break;
            case 4:
                i = ((iHashCode * 37) + 4) * 53;
                nullValueValue = Internal.hashBoolean(getBoolValue());
                break;
            case 5:
                i = ((iHashCode * 37) + 5) * 53;
                nullValueValue = getStructValue().hashCode();
                break;
            case 6:
                i = ((iHashCode * 37) + 6) * 53;
                nullValueValue = getListValue().hashCode();
                break;
            default:
                int iHashCode2 = (iHashCode * 29) + getUnknownFields().hashCode();
                this.memoizedHashCode = iHashCode2;
                return iHashCode2;
        }
        iHashCode = i + nullValueValue;
        int iHashCode3 = (iHashCode * 29) + getUnknownFields().hashCode();
        this.memoizedHashCode = iHashCode3;
        return iHashCode3;
    }

    public static Value parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(data);
    }

    public static Value parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(data, extensionRegistry);
    }

    public static Value parseFrom(ByteString data) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(data);
    }

    public static Value parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(data, extensionRegistry);
    }

    public static Value parseFrom(byte[] data) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(data);
    }

    public static Value parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(data, extensionRegistry);
    }

    public static Value parseFrom(InputStream input) throws IOException {
        return (Value) GeneratedMessage.parseWithIOException(PARSER, input);
    }

    public static Value parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (Value) GeneratedMessage.parseWithIOException(PARSER, input, extensionRegistry);
    }

    public static Value parseDelimitedFrom(InputStream input) throws IOException {
        return (Value) GeneratedMessage.parseDelimitedWithIOException(PARSER, input);
    }

    public static Value parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (Value) GeneratedMessage.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
    }

    public static Value parseFrom(CodedInputStream input) throws IOException {
        return (Value) GeneratedMessage.parseWithIOException(PARSER, input);
    }

    public static Value parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (Value) GeneratedMessage.parseWithIOException(PARSER, input, extensionRegistry);
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder newBuilderForType() {
        return newBuilder();
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(Value prototype) {
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

    public static final class Builder extends GeneratedMessage.Builder<Builder> implements ValueOrBuilder {
        private int bitField0_;
        private int kindCase_;
        private Object kind_;
        private SingleFieldBuilder<ListValue, ListValue.Builder, ListValueOrBuilder> listValueBuilder_;
        private SingleFieldBuilder<Struct, Struct.Builder, StructOrBuilder> structValueBuilder_;

        private void buildPartial0(Value result) {
        }

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
            return StructProto.internal_static_google_protobuf_Value_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder
        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return StructProto.internal_static_google_protobuf_Value_fieldAccessorTable.ensureFieldAccessorsInitialized(Value.class, Builder.class);
        }

        private Builder() {
            this.kindCase_ = 0;
        }

        private Builder(AbstractMessage.BuilderParent parent) {
            super(parent);
            this.kindCase_ = 0;
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder clear() {
            super.clear();
            this.bitField0_ = 0;
            SingleFieldBuilder<Struct, Struct.Builder, StructOrBuilder> singleFieldBuilder = this.structValueBuilder_;
            if (singleFieldBuilder != null) {
                singleFieldBuilder.clear();
            }
            SingleFieldBuilder<ListValue, ListValue.Builder, ListValueOrBuilder> singleFieldBuilder2 = this.listValueBuilder_;
            if (singleFieldBuilder2 != null) {
                singleFieldBuilder2.clear();
            }
            this.kindCase_ = 0;
            this.kind_ = null;
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
        public Descriptors.Descriptor getDescriptorForType() {
            return StructProto.internal_static_google_protobuf_Value_descriptor;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public Value getDefaultInstanceForType() {
            return Value.getDefaultInstance();
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Value build() {
            Value valueBuildPartial = buildPartial();
            if (valueBuildPartial.isInitialized()) {
                return valueBuildPartial;
            }
            throw newUninitializedMessageException((Message) valueBuildPartial);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Value buildPartial() {
            Value value = new Value(this, null);
            if (this.bitField0_ != 0) {
                buildPartial0(value);
            }
            buildPartialOneofs(value);
            onBuilt();
            return value;
        }

        private void buildPartialOneofs(Value result) {
            SingleFieldBuilder<ListValue, ListValue.Builder, ListValueOrBuilder> singleFieldBuilder;
            SingleFieldBuilder<Struct, Struct.Builder, StructOrBuilder> singleFieldBuilder2;
            result.kindCase_ = this.kindCase_;
            result.kind_ = this.kind_;
            if (this.kindCase_ == 5 && (singleFieldBuilder2 = this.structValueBuilder_) != null) {
                result.kind_ = singleFieldBuilder2.build();
            }
            if (this.kindCase_ != 6 || (singleFieldBuilder = this.listValueBuilder_) == null) {
                return;
            }
            result.kind_ = singleFieldBuilder.build();
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public Builder mergeFrom(Message other) {
            if (other instanceof Value) {
                return mergeFrom((Value) other);
            }
            super.mergeFrom(other);
            return this;
        }

        public Builder mergeFrom(Value other) {
            if (other == Value.getDefaultInstance()) {
                return this;
            }
            switch (AnonymousClass2.$SwitchMap$com$google$protobuf$Value$KindCase[other.getKindCase().ordinal()]) {
                case 1:
                    setNullValueValue(other.getNullValueValue());
                    break;
                case 2:
                    setNumberValue(other.getNumberValue());
                    break;
                case 3:
                    this.kindCase_ = 3;
                    this.kind_ = other.kind_;
                    onChanged();
                    break;
                case 4:
                    setBoolValue(other.getBoolValue());
                    break;
                case 5:
                    mergeStructValue(other.getStructValue());
                    break;
                case 6:
                    mergeListValue(other.getListValue());
                    break;
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
                            if (tag == 8) {
                                int i = input.readEnum();
                                this.kindCase_ = 1;
                                this.kind_ = Integer.valueOf(i);
                            } else if (tag == 17) {
                                this.kind_ = Double.valueOf(input.readDouble());
                                this.kindCase_ = 2;
                            } else if (tag == 26) {
                                String stringRequireUtf8 = input.readStringRequireUtf8();
                                this.kindCase_ = 3;
                                this.kind_ = stringRequireUtf8;
                            } else if (tag == 32) {
                                this.kind_ = Boolean.valueOf(input.readBool());
                                this.kindCase_ = 4;
                            } else if (tag == 42) {
                                input.readMessage(getStructValueFieldBuilder().getBuilder(), extensionRegistry);
                                this.kindCase_ = 5;
                            } else if (tag == 50) {
                                input.readMessage(getListValueFieldBuilder().getBuilder(), extensionRegistry);
                                this.kindCase_ = 6;
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

        @Override // com.google.protobuf.ValueOrBuilder
        public KindCase getKindCase() {
            return KindCase.forNumber(this.kindCase_);
        }

        public Builder clearKind() {
            this.kindCase_ = 0;
            this.kind_ = null;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.ValueOrBuilder
        public boolean hasNullValue() {
            return this.kindCase_ == 1;
        }

        @Override // com.google.protobuf.ValueOrBuilder
        public int getNullValueValue() {
            if (this.kindCase_ == 1) {
                return ((Integer) this.kind_).intValue();
            }
            return 0;
        }

        public Builder setNullValueValue(int value) {
            this.kindCase_ = 1;
            this.kind_ = Integer.valueOf(value);
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.ValueOrBuilder
        public NullValue getNullValue() {
            if (this.kindCase_ == 1) {
                NullValue nullValueForNumber = NullValue.forNumber(((Integer) this.kind_).intValue());
                return nullValueForNumber == null ? NullValue.UNRECOGNIZED : nullValueForNumber;
            }
            return NullValue.NULL_VALUE;
        }

        public Builder setNullValue(NullValue value) {
            value.getClass();
            this.kindCase_ = 1;
            this.kind_ = Integer.valueOf(value.getNumber());
            onChanged();
            return this;
        }

        public Builder clearNullValue() {
            if (this.kindCase_ == 1) {
                this.kindCase_ = 0;
                this.kind_ = null;
                onChanged();
            }
            return this;
        }

        @Override // com.google.protobuf.ValueOrBuilder
        public boolean hasNumberValue() {
            return this.kindCase_ == 2;
        }

        @Override // com.google.protobuf.ValueOrBuilder
        public double getNumberValue() {
            if (this.kindCase_ == 2) {
                return ((Double) this.kind_).doubleValue();
            }
            return 0.0d;
        }

        public Builder setNumberValue(double value) {
            this.kindCase_ = 2;
            this.kind_ = Double.valueOf(value);
            onChanged();
            return this;
        }

        public Builder clearNumberValue() {
            if (this.kindCase_ == 2) {
                this.kindCase_ = 0;
                this.kind_ = null;
                onChanged();
            }
            return this;
        }

        @Override // com.google.protobuf.ValueOrBuilder
        public boolean hasStringValue() {
            return this.kindCase_ == 3;
        }

        @Override // com.google.protobuf.ValueOrBuilder
        public String getStringValue() {
            Object obj;
            if (this.kindCase_ != 3) {
                obj = "";
            } else {
                obj = this.kind_;
            }
            if (!(obj instanceof String)) {
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                if (this.kindCase_ == 3) {
                    this.kind_ = stringUtf8;
                }
                return stringUtf8;
            }
            return (String) obj;
        }

        @Override // com.google.protobuf.ValueOrBuilder
        public ByteString getStringValueBytes() {
            Object obj;
            if (this.kindCase_ != 3) {
                obj = "";
            } else {
                obj = this.kind_;
            }
            if (obj instanceof String) {
                ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                if (this.kindCase_ == 3) {
                    this.kind_ = byteStringCopyFromUtf8;
                }
                return byteStringCopyFromUtf8;
            }
            return (ByteString) obj;
        }

        public Builder setStringValue(String value) {
            value.getClass();
            this.kindCase_ = 3;
            this.kind_ = value;
            onChanged();
            return this;
        }

        public Builder clearStringValue() {
            if (this.kindCase_ == 3) {
                this.kindCase_ = 0;
                this.kind_ = null;
                onChanged();
            }
            return this;
        }

        public Builder setStringValueBytes(ByteString value) {
            value.getClass();
            AbstractMessageLite.checkByteStringIsUtf8(value);
            this.kindCase_ = 3;
            this.kind_ = value;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.ValueOrBuilder
        public boolean hasBoolValue() {
            return this.kindCase_ == 4;
        }

        @Override // com.google.protobuf.ValueOrBuilder
        public boolean getBoolValue() {
            if (this.kindCase_ == 4) {
                return ((Boolean) this.kind_).booleanValue();
            }
            return false;
        }

        public Builder setBoolValue(boolean value) {
            this.kindCase_ = 4;
            this.kind_ = Boolean.valueOf(value);
            onChanged();
            return this;
        }

        public Builder clearBoolValue() {
            if (this.kindCase_ == 4) {
                this.kindCase_ = 0;
                this.kind_ = null;
                onChanged();
            }
            return this;
        }

        @Override // com.google.protobuf.ValueOrBuilder
        public boolean hasStructValue() {
            return this.kindCase_ == 5;
        }

        @Override // com.google.protobuf.ValueOrBuilder
        public Struct getStructValue() {
            SingleFieldBuilder<Struct, Struct.Builder, StructOrBuilder> singleFieldBuilder = this.structValueBuilder_;
            if (singleFieldBuilder == null) {
                if (this.kindCase_ == 5) {
                    return (Struct) this.kind_;
                }
                return Struct.getDefaultInstance();
            }
            if (this.kindCase_ == 5) {
                return (Struct) singleFieldBuilder.getMessage();
            }
            return Struct.getDefaultInstance();
        }

        public Builder setStructValue(Struct value) {
            SingleFieldBuilder<Struct, Struct.Builder, StructOrBuilder> singleFieldBuilder = this.structValueBuilder_;
            if (singleFieldBuilder == null) {
                value.getClass();
                this.kind_ = value;
                onChanged();
            } else {
                singleFieldBuilder.setMessage(value);
            }
            this.kindCase_ = 5;
            return this;
        }

        public Builder setStructValue(Struct.Builder builderForValue) {
            SingleFieldBuilder<Struct, Struct.Builder, StructOrBuilder> singleFieldBuilder = this.structValueBuilder_;
            if (singleFieldBuilder == null) {
                this.kind_ = builderForValue.build();
                onChanged();
            } else {
                singleFieldBuilder.setMessage(builderForValue.build());
            }
            this.kindCase_ = 5;
            return this;
        }

        public Builder mergeStructValue(Struct value) {
            SingleFieldBuilder<Struct, Struct.Builder, StructOrBuilder> singleFieldBuilder = this.structValueBuilder_;
            if (singleFieldBuilder == null) {
                if (this.kindCase_ == 5 && this.kind_ != Struct.getDefaultInstance()) {
                    this.kind_ = Struct.newBuilder((Struct) this.kind_).mergeFrom(value).buildPartial();
                } else {
                    this.kind_ = value;
                }
                onChanged();
            } else if (this.kindCase_ == 5) {
                singleFieldBuilder.mergeFrom(value);
            } else {
                singleFieldBuilder.setMessage(value);
            }
            this.kindCase_ = 5;
            return this;
        }

        public Builder clearStructValue() {
            SingleFieldBuilder<Struct, Struct.Builder, StructOrBuilder> singleFieldBuilder = this.structValueBuilder_;
            if (singleFieldBuilder == null) {
                if (this.kindCase_ == 5) {
                    this.kindCase_ = 0;
                    this.kind_ = null;
                    onChanged();
                }
                return this;
            }
            if (this.kindCase_ == 5) {
                this.kindCase_ = 0;
                this.kind_ = null;
            }
            singleFieldBuilder.clear();
            return this;
        }

        public Struct.Builder getStructValueBuilder() {
            return (Struct.Builder) getStructValueFieldBuilder().getBuilder();
        }

        @Override // com.google.protobuf.ValueOrBuilder
        public StructOrBuilder getStructValueOrBuilder() {
            SingleFieldBuilder<Struct, Struct.Builder, StructOrBuilder> singleFieldBuilder;
            int i = this.kindCase_;
            if (i == 5 && (singleFieldBuilder = this.structValueBuilder_) != null) {
                return (StructOrBuilder) singleFieldBuilder.getMessageOrBuilder();
            }
            if (i == 5) {
                return (Struct) this.kind_;
            }
            return Struct.getDefaultInstance();
        }

        private SingleFieldBuilder<Struct, Struct.Builder, StructOrBuilder> getStructValueFieldBuilder() {
            if (this.structValueBuilder_ == null) {
                if (this.kindCase_ != 5) {
                    this.kind_ = Struct.getDefaultInstance();
                }
                this.structValueBuilder_ = new SingleFieldBuilder<>((Struct) this.kind_, getParentForChildren(), isClean());
                this.kind_ = null;
            }
            this.kindCase_ = 5;
            onChanged();
            return this.structValueBuilder_;
        }

        @Override // com.google.protobuf.ValueOrBuilder
        public boolean hasListValue() {
            return this.kindCase_ == 6;
        }

        @Override // com.google.protobuf.ValueOrBuilder
        public ListValue getListValue() {
            SingleFieldBuilder<ListValue, ListValue.Builder, ListValueOrBuilder> singleFieldBuilder = this.listValueBuilder_;
            if (singleFieldBuilder == null) {
                if (this.kindCase_ == 6) {
                    return (ListValue) this.kind_;
                }
                return ListValue.getDefaultInstance();
            }
            if (this.kindCase_ == 6) {
                return (ListValue) singleFieldBuilder.getMessage();
            }
            return ListValue.getDefaultInstance();
        }

        public Builder setListValue(ListValue value) {
            SingleFieldBuilder<ListValue, ListValue.Builder, ListValueOrBuilder> singleFieldBuilder = this.listValueBuilder_;
            if (singleFieldBuilder == null) {
                value.getClass();
                this.kind_ = value;
                onChanged();
            } else {
                singleFieldBuilder.setMessage(value);
            }
            this.kindCase_ = 6;
            return this;
        }

        public Builder setListValue(ListValue.Builder builderForValue) {
            SingleFieldBuilder<ListValue, ListValue.Builder, ListValueOrBuilder> singleFieldBuilder = this.listValueBuilder_;
            if (singleFieldBuilder == null) {
                this.kind_ = builderForValue.build();
                onChanged();
            } else {
                singleFieldBuilder.setMessage(builderForValue.build());
            }
            this.kindCase_ = 6;
            return this;
        }

        public Builder mergeListValue(ListValue value) {
            SingleFieldBuilder<ListValue, ListValue.Builder, ListValueOrBuilder> singleFieldBuilder = this.listValueBuilder_;
            if (singleFieldBuilder == null) {
                if (this.kindCase_ == 6 && this.kind_ != ListValue.getDefaultInstance()) {
                    this.kind_ = ListValue.newBuilder((ListValue) this.kind_).mergeFrom(value).buildPartial();
                } else {
                    this.kind_ = value;
                }
                onChanged();
            } else if (this.kindCase_ == 6) {
                singleFieldBuilder.mergeFrom(value);
            } else {
                singleFieldBuilder.setMessage(value);
            }
            this.kindCase_ = 6;
            return this;
        }

        public Builder clearListValue() {
            SingleFieldBuilder<ListValue, ListValue.Builder, ListValueOrBuilder> singleFieldBuilder = this.listValueBuilder_;
            if (singleFieldBuilder == null) {
                if (this.kindCase_ == 6) {
                    this.kindCase_ = 0;
                    this.kind_ = null;
                    onChanged();
                }
                return this;
            }
            if (this.kindCase_ == 6) {
                this.kindCase_ = 0;
                this.kind_ = null;
            }
            singleFieldBuilder.clear();
            return this;
        }

        public ListValue.Builder getListValueBuilder() {
            return (ListValue.Builder) getListValueFieldBuilder().getBuilder();
        }

        @Override // com.google.protobuf.ValueOrBuilder
        public ListValueOrBuilder getListValueOrBuilder() {
            SingleFieldBuilder<ListValue, ListValue.Builder, ListValueOrBuilder> singleFieldBuilder;
            int i = this.kindCase_;
            if (i == 6 && (singleFieldBuilder = this.listValueBuilder_) != null) {
                return (ListValueOrBuilder) singleFieldBuilder.getMessageOrBuilder();
            }
            if (i == 6) {
                return (ListValue) this.kind_;
            }
            return ListValue.getDefaultInstance();
        }

        private SingleFieldBuilder<ListValue, ListValue.Builder, ListValueOrBuilder> getListValueFieldBuilder() {
            if (this.listValueBuilder_ == null) {
                if (this.kindCase_ != 6) {
                    this.kind_ = ListValue.getDefaultInstance();
                }
                this.listValueBuilder_ = new SingleFieldBuilder<>((ListValue) this.kind_, getParentForChildren(), isClean());
                this.kind_ = null;
            }
            this.kindCase_ = 6;
            onChanged();
            return this.listValueBuilder_;
        }
    }

    /* JADX INFO: renamed from: com.google.protobuf.Value$2, reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$com$google$protobuf$Value$KindCase;

        static {
            int[] iArr = new int[KindCase.values().length];
            $SwitchMap$com$google$protobuf$Value$KindCase = iArr;
            try {
                iArr[KindCase.NULL_VALUE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$google$protobuf$Value$KindCase[KindCase.NUMBER_VALUE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$google$protobuf$Value$KindCase[KindCase.STRING_VALUE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$google$protobuf$Value$KindCase[KindCase.BOOL_VALUE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$google$protobuf$Value$KindCase[KindCase.STRUCT_VALUE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$google$protobuf$Value$KindCase[KindCase.LIST_VALUE.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$google$protobuf$Value$KindCase[KindCase.KIND_NOT_SET.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    public static Value getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* JADX INFO: renamed from: com.google.protobuf.Value$1, reason: invalid class name */
    class AnonymousClass1 extends AbstractParser<Value> {
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
        public Value parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            Builder builderNewBuilder = Value.newBuilder();
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

    public static Parser<Value> parser() {
        return PARSER;
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Parser<Value> getParserForType() {
        return PARSER;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
    public Value getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }
}
