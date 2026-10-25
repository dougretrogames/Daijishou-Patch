package proto;

import com.google.protobuf.Descriptors;
import com.google.protobuf.Internal;
import com.google.protobuf.ProtocolMessageEnum;
import com.google.protobuf.RuntimeVersion;

/* JADX INFO: loaded from: classes6.dex */
public enum AgeRatingCategoryEnum implements ProtocolMessageEnum {
    AGERATING_CATEGORY_NULL(0),
    ESRB(1),
    PEGI(2),
    CERO(3),
    USK(4),
    GRAC(5),
    CLASS_IND(6),
    ACB(7),
    UNRECOGNIZED(-1);

    public static final int ACB_VALUE = 7;
    public static final int AGERATING_CATEGORY_NULL_VALUE = 0;
    public static final int CERO_VALUE = 3;
    public static final int CLASS_IND_VALUE = 6;
    public static final int ESRB_VALUE = 1;
    public static final int GRAC_VALUE = 5;
    public static final int PEGI_VALUE = 2;
    public static final int USK_VALUE = 4;
    private static final AgeRatingCategoryEnum[] VALUES;
    private static final Internal.EnumLiteMap<AgeRatingCategoryEnum> internalValueMap;
    private final int value;

    static {
        RuntimeVersion.validateProtobufGencodeVersion(RuntimeVersion.RuntimeDomain.PUBLIC, 4, 27, 2, "", AgeRatingCategoryEnum.class.getName());
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
    public static AgeRatingCategoryEnum valueOf(int i) {
        return forNumber(i);
    }

    public static AgeRatingCategoryEnum forNumber(int i) {
        switch (i) {
            case 0:
                return AGERATING_CATEGORY_NULL;
            case 1:
                return ESRB;
            case 2:
                return PEGI;
            case 3:
                return CERO;
            case 4:
                return USK;
            case 5:
                return GRAC;
            case 6:
                return CLASS_IND;
            case 7:
                return ACB;
            default:
                return null;
        }
    }

    public static Internal.EnumLiteMap<AgeRatingCategoryEnum> internalGetValueMap() {
        return internalValueMap;
    }

    /* JADX INFO: renamed from: proto.AgeRatingCategoryEnum$1, reason: invalid class name */
    class AnonymousClass1 implements Internal.EnumLiteMap<AgeRatingCategoryEnum> {
        AnonymousClass1() {
        }

        @Override // com.google.protobuf.Internal.EnumLiteMap
        public AgeRatingCategoryEnum findValueByNumber(int i) {
            return AgeRatingCategoryEnum.forNumber(i);
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
        return Igdbproto.getDescriptor().getEnumTypes().get(0);
    }

    public static AgeRatingCategoryEnum valueOf(Descriptors.EnumValueDescriptor enumValueDescriptor) {
        if (enumValueDescriptor.getType() != getDescriptor()) {
            throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
        }
        if (enumValueDescriptor.getIndex() == -1) {
            return UNRECOGNIZED;
        }
        return VALUES[enumValueDescriptor.getIndex()];
    }

    AgeRatingCategoryEnum(int i) {
        this.value = i;
    }
}
