package proto;

import com.google.protobuf.Descriptors;
import com.google.protobuf.Internal;
import com.google.protobuf.ProtocolMessageEnum;
import com.google.protobuf.RuntimeVersion;

/* INFO: loaded from: classes6.dex */
public enum ExternalGameMediaEnum implements ProtocolMessageEnum {
    EXTERNALGAME_MEDIA_NULL(0),
    EXTERNALGAME_DIGITAL(1),
    EXTERNALGAME_PHYSICAL(2),
    UNRECOGNIZED(-1);

    public static final int EXTERNALGAME_DIGITAL_VALUE = 1;
    public static final int EXTERNALGAME_MEDIA_NULL_VALUE = 0;
    public static final int EXTERNALGAME_PHYSICAL_VALUE = 2;
    private static final ExternalGameMediaEnum[] VALUES;
    private static final Internal.EnumLiteMap<ExternalGameMediaEnum> internalValueMap;
    private final int value;

    static {
        RuntimeVersion.validateProtobufGencodeVersion(RuntimeVersion.RuntimeDomain.PUBLIC, 4, 27, 2, "", ExternalGameMediaEnum.class.getName());
        internalValueMap = new AnonymousClass1();
        VALUES = values();
    }

    @Override // com.google.protobuf.ProtocolMessageEnum, com.google.protobuf.Internal.EnumLite
    public final int getNumber() {
        if (this == UNRECOGNIZED) {
            throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
        }
        return this.value;
    }

    @Deprecated
    public static ExternalGameMediaEnum valueOf(int i) {
        return forNumber(i);
    }

    public static ExternalGameMediaEnum forNumber(int i) {
        if (i == 0) {
            return EXTERNALGAME_MEDIA_NULL;
        }
        if (i == 1) {
            return EXTERNALGAME_DIGITAL;
        }
        if (i != 2) {
            return null;
        }
        return EXTERNALGAME_PHYSICAL;
    }

    public static Internal.EnumLiteMap<ExternalGameMediaEnum> internalGetValueMap() {
        return internalValueMap;
    }

    /* INFO: renamed from: proto.ExternalGameMediaEnum$1, reason: invalid class name */
    class AnonymousClass1 implements Internal.EnumLiteMap<ExternalGameMediaEnum> {
        AnonymousClass1() {
        }

        @Override // com.google.protobuf.Internal.EnumLiteMap
        public ExternalGameMediaEnum findValueByNumber(int i) {
            return ExternalGameMediaEnum.forNumber(i);
        }
    }

    @Override // com.google.protobuf.ProtocolMessageEnum
    public final Descriptors.EnumValueDescriptor getValueDescriptor() {
        if (this == UNRECOGNIZED) {
            throw new IllegalStateException("Can't get the descriptor of an unrecognized enum value.");
        }
        return getDescriptor().getValues().get(ordinal());
    }

    @Override // com.google.protobuf.ProtocolMessageEnum
    public final Descriptors.EnumDescriptor getDescriptorForType() {
        return getDescriptor();
    }

    public static final Descriptors.EnumDescriptor getDescriptor() {
        return Igdbproto.getDescriptor().getEnumTypes().get(8);
    }

    public static ExternalGameMediaEnum valueOf(Descriptors.EnumValueDescriptor enumValueDescriptor) {
        if (enumValueDescriptor.getType() != getDescriptor()) {
            throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
        }
        if (enumValueDescriptor.getIndex() == -1) {
            return UNRECOGNIZED;
        }
        return VALUES[enumValueDescriptor.getIndex()];
    }

    ExternalGameMediaEnum(int i) {
        this.value = i;
    }
}
