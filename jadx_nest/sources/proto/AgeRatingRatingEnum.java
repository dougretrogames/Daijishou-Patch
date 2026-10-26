package proto;

import com.google.protobuf.Descriptors;
import com.google.protobuf.Internal;
import com.google.protobuf.ProtocolMessageEnum;
import com.google.protobuf.RuntimeVersion;

/* INFO: loaded from: classes6.dex */
public enum AgeRatingRatingEnum implements ProtocolMessageEnum {
    AGERATING_RATING_NULL(0),
    THREE(1),
    SEVEN(2),
    TWELVE(3),
    SIXTEEN(4),
    EIGHTEEN(5),
    RP(6),
    EC(7),
    E(8),
    E10(9),
    T(10),
    M(11),
    AO(12),
    CERO_A(13),
    CERO_B(14),
    CERO_C(15),
    CERO_D(16),
    CERO_Z(17),
    USK_0(18),
    USK_6(19),
    USK_12(20),
    USK_16(21),
    USK_18(22),
    GRAC_ALL(23),
    GRAC_TWELVE(24),
    GRAC_FIFTEEN(25),
    GRAC_EIGHTEEN(26),
    GRAC_TESTING(27),
    CLASS_IND_L(28),
    CLASS_IND_TEN(29),
    CLASS_IND_TWELVE(30),
    CLASS_IND_FOURTEEN(31),
    CLASS_IND_SIXTEEN(32),
    CLASS_IND_EIGHTEEN(33),
    ACB_G(34),
    ACB_PG(35),
    ACB_M(36),
    ACB_MA15(37),
    ACB_R18(38),
    ACB_RC(39),
    UNRECOGNIZED(-1);

    public static final int ACB_G_VALUE = 34;
    public static final int ACB_MA15_VALUE = 37;
    public static final int ACB_M_VALUE = 36;
    public static final int ACB_PG_VALUE = 35;
    public static final int ACB_R18_VALUE = 38;
    public static final int ACB_RC_VALUE = 39;
    public static final int AGERATING_RATING_NULL_VALUE = 0;
    public static final int AO_VALUE = 12;
    public static final int CERO_A_VALUE = 13;
    public static final int CERO_B_VALUE = 14;
    public static final int CERO_C_VALUE = 15;
    public static final int CERO_D_VALUE = 16;
    public static final int CERO_Z_VALUE = 17;
    public static final int CLASS_IND_EIGHTEEN_VALUE = 33;
    public static final int CLASS_IND_FOURTEEN_VALUE = 31;
    public static final int CLASS_IND_L_VALUE = 28;
    public static final int CLASS_IND_SIXTEEN_VALUE = 32;
    public static final int CLASS_IND_TEN_VALUE = 29;
    public static final int CLASS_IND_TWELVE_VALUE = 30;
    public static final int E10_VALUE = 9;
    public static final int EC_VALUE = 7;
    public static final int EIGHTEEN_VALUE = 5;
    public static final int E_VALUE = 8;
    public static final int GRAC_ALL_VALUE = 23;
    public static final int GRAC_EIGHTEEN_VALUE = 26;
    public static final int GRAC_FIFTEEN_VALUE = 25;
    public static final int GRAC_TESTING_VALUE = 27;
    public static final int GRAC_TWELVE_VALUE = 24;
    public static final int M_VALUE = 11;
    public static final int RP_VALUE = 6;
    public static final int SEVEN_VALUE = 2;
    public static final int SIXTEEN_VALUE = 4;
    public static final int THREE_VALUE = 1;
    public static final int TWELVE_VALUE = 3;
    public static final int T_VALUE = 10;
    public static final int USK_0_VALUE = 18;
    public static final int USK_12_VALUE = 20;
    public static final int USK_16_VALUE = 21;
    public static final int USK_18_VALUE = 22;
    public static final int USK_6_VALUE = 19;
    private static final AgeRatingRatingEnum[] VALUES;
    private static final Internal.EnumLiteMap<AgeRatingRatingEnum> internalValueMap;
    private final int value;

    static {
        RuntimeVersion.validateProtobufGencodeVersion(RuntimeVersion.RuntimeDomain.PUBLIC, 4, 27, 2, "", AgeRatingRatingEnum.class.getName());
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
    public static AgeRatingRatingEnum valueOf(int i) {
        return forNumber(i);
    }

    public static AgeRatingRatingEnum forNumber(int i) {
        switch (i) {
            case 0:
                return AGERATING_RATING_NULL;
            case 1:
                return THREE;
            case 2:
                return SEVEN;
            case 3:
                return TWELVE;
            case 4:
                return SIXTEEN;
            case 5:
                return EIGHTEEN;
            case 6:
                return RP;
            case 7:
                return EC;
            case 8:
                return E;
            case 9:
                return E10;
            case 10:
                return T;
            case 11:
                return M;
            case 12:
                return AO;
            case 13:
                return CERO_A;
            case 14:
                return CERO_B;
            case 15:
                return CERO_C;
            case 16:
                return CERO_D;
            case 17:
                return CERO_Z;
            case 18:
                return USK_0;
            case 19:
                return USK_6;
            case 20:
                return USK_12;
            case 21:
                return USK_16;
            case 22:
                return USK_18;
            case 23:
                return GRAC_ALL;
            case 24:
                return GRAC_TWELVE;
            case 25:
                return GRAC_FIFTEEN;
            case 26:
                return GRAC_EIGHTEEN;
            case 27:
                return GRAC_TESTING;
            case 28:
                return CLASS_IND_L;
            case 29:
                return CLASS_IND_TEN;
            case 30:
                return CLASS_IND_TWELVE;
            case 31:
                return CLASS_IND_FOURTEEN;
            case 32:
                return CLASS_IND_SIXTEEN;
            case 33:
                return CLASS_IND_EIGHTEEN;
            case 34:
                return ACB_G;
            case 35:
                return ACB_PG;
            case 36:
                return ACB_M;
            case 37:
                return ACB_MA15;
            case 38:
                return ACB_R18;
            case 39:
                return ACB_RC;
            default:
                return null;
        }
    }

    public static Internal.EnumLiteMap<AgeRatingRatingEnum> internalGetValueMap() {
        return internalValueMap;
    }

    /* INFO: renamed from: proto.AgeRatingRatingEnum$1, reason: invalid class name */
    class AnonymousClass1 implements Internal.EnumLiteMap<AgeRatingRatingEnum> {
        AnonymousClass1() {
        }

        @Override // com.google.protobuf.Internal.EnumLiteMap
        public AgeRatingRatingEnum findValueByNumber(int i) {
            return AgeRatingRatingEnum.forNumber(i);
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
        return Igdbproto.getDescriptor().getEnumTypes().get(1);
    }

    public static AgeRatingRatingEnum valueOf(Descriptors.EnumValueDescriptor enumValueDescriptor) {
        if (enumValueDescriptor.getType() != getDescriptor()) {
            throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
        }
        if (enumValueDescriptor.getIndex() == -1) {
            return UNRECOGNIZED;
        }
        return VALUES[enumValueDescriptor.getIndex()];
    }

    AgeRatingRatingEnum(int i) {
        this.value = i;
    }
}
