package proto;

import com.google.protobuf.Descriptors;
import com.google.protobuf.Internal;
import com.google.protobuf.ProtocolMessageEnum;
import com.google.protobuf.RuntimeVersion;

/* INFO: loaded from: classes6.dex */
public enum DateFormatChangeDateCategoryEnum implements ProtocolMessageEnum {
    YYYYMMMMDD(0),
    YYYYMMMM(1),
    YYYY(2),
    YYYYQ1(3),
    YYYYQ2(4),
    YYYYQ3(5),
    YYYYQ4(6),
    TBD(7),
    UNRECOGNIZED(-1);

    public static final int TBD_VALUE = 7;
    private static final DateFormatChangeDateCategoryEnum[] VALUES;
    public static final int YYYYMMMMDD_VALUE = 0;
    public static final int YYYYMMMM_VALUE = 1;
    public static final int YYYYQ1_VALUE = 3;
    public static final int YYYYQ2_VALUE = 4;
    public static final int YYYYQ3_VALUE = 5;
    public static final int YYYYQ4_VALUE = 6;
    public static final int YYYY_VALUE = 2;
    private static final Internal.EnumLiteMap<DateFormatChangeDateCategoryEnum> internalValueMap;
    private final int value;

    static {
        RuntimeVersion.validateProtobufGencodeVersion(RuntimeVersion.RuntimeDomain.PUBLIC, 4, 27, 2, "", DateFormatChangeDateCategoryEnum.class.getName());
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
    public static DateFormatChangeDateCategoryEnum valueOf(int i) {
        return forNumber(i);
    }

    public static DateFormatChangeDateCategoryEnum forNumber(int i) {
        switch (i) {
            case 0:
                return YYYYMMMMDD;
            case 1:
                return YYYYMMMM;
            case 2:
                return YYYY;
            case 3:
                return YYYYQ1;
            case 4:
                return YYYYQ2;
            case 5:
                return YYYYQ3;
            case 6:
                return YYYYQ4;
            case 7:
                return TBD;
            default:
                return null;
        }
    }

    public static Internal.EnumLiteMap<DateFormatChangeDateCategoryEnum> internalGetValueMap() {
        return internalValueMap;
    }

    /* INFO: renamed from: proto.DateFormatChangeDateCategoryEnum$1, reason: invalid class name */
    class AnonymousClass1 implements Internal.EnumLiteMap<DateFormatChangeDateCategoryEnum> {
        AnonymousClass1() {
        }

        @Override // com.google.protobuf.Internal.EnumLiteMap
        public DateFormatChangeDateCategoryEnum findValueByNumber(int i) {
            return DateFormatChangeDateCategoryEnum.forNumber(i);
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
        return Igdbproto.getDescriptor().getEnumTypes().get(5);
    }

    public static DateFormatChangeDateCategoryEnum valueOf(Descriptors.EnumValueDescriptor enumValueDescriptor) {
        if (enumValueDescriptor.getType() != getDescriptor()) {
            throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
        }
        if (enumValueDescriptor.getIndex() == -1) {
            return UNRECOGNIZED;
        }
        return VALUES[enumValueDescriptor.getIndex()];
    }

    DateFormatChangeDateCategoryEnum(int i) {
        this.value = i;
    }
}
