package proto;

import com.google.protobuf.Descriptors;
import com.google.protobuf.Internal;
import com.google.protobuf.ProtocolMessageEnum;
import com.google.protobuf.RuntimeVersion;

/* INFO: loaded from: classes6.dex */
public enum GenderGenderEnum implements ProtocolMessageEnum {
    MALE(0),
    FEMALE(1),
    OTHER(2),
    UNRECOGNIZED(-1);

    public static final int FEMALE_VALUE = 1;
    public static final int MALE_VALUE = 0;
    public static final int OTHER_VALUE = 2;
    private static final GenderGenderEnum[] VALUES;
    private static final Internal.EnumLiteMap<GenderGenderEnum> internalValueMap;
    private final int value;

    static {
        RuntimeVersion.validateProtobufGencodeVersion(RuntimeVersion.RuntimeDomain.PUBLIC, 4, 27, 2, "", GenderGenderEnum.class.getName());
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
    public static GenderGenderEnum valueOf(int i) {
        return forNumber(i);
    }

    public static GenderGenderEnum forNumber(int i) {
        if (i == 0) {
            return MALE;
        }
        if (i == 1) {
            return FEMALE;
        }
        if (i != 2) {
            return null;
        }
        return OTHER;
    }

    public static Internal.EnumLiteMap<GenderGenderEnum> internalGetValueMap() {
        return internalValueMap;
    }

    /* INFO: renamed from: proto.GenderGenderEnum$1, reason: invalid class name */
    class AnonymousClass1 implements Internal.EnumLiteMap<GenderGenderEnum> {
        AnonymousClass1() {
        }

        @Override // com.google.protobuf.Internal.EnumLiteMap
        public GenderGenderEnum findValueByNumber(int i) {
            return GenderGenderEnum.forNumber(i);
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
        return Igdbproto.getDescriptor().getEnumTypes().get(3);
    }

    public static GenderGenderEnum valueOf(Descriptors.EnumValueDescriptor enumValueDescriptor) {
        if (enumValueDescriptor.getType() != getDescriptor()) {
            throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
        }
        if (enumValueDescriptor.getIndex() == -1) {
            return UNRECOGNIZED;
        }
        return VALUES[enumValueDescriptor.getIndex()];
    }

    GenderGenderEnum(int i) {
        this.value = i;
    }
}
