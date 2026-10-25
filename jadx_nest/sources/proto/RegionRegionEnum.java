package proto;

import com.google.protobuf.Descriptors;
import com.google.protobuf.Internal;
import com.google.protobuf.ProtocolMessageEnum;
import com.google.protobuf.RuntimeVersion;

/* JADX INFO: loaded from: classes6.dex */
public enum RegionRegionEnum implements ProtocolMessageEnum {
    REGION_REGION_NULL(0),
    EUROPE(1),
    NORTH_AMERICA(2),
    AUSTRALIA(3),
    NEW_ZEALAND(4),
    JAPAN(5),
    CHINA(6),
    ASIA(7),
    WORLDWIDE(8),
    KOREA(9),
    BRAZIL(10),
    UNRECOGNIZED(-1);

    public static final int ASIA_VALUE = 7;
    public static final int AUSTRALIA_VALUE = 3;
    public static final int BRAZIL_VALUE = 10;
    public static final int CHINA_VALUE = 6;
    public static final int EUROPE_VALUE = 1;
    public static final int JAPAN_VALUE = 5;
    public static final int KOREA_VALUE = 9;
    public static final int NEW_ZEALAND_VALUE = 4;
    public static final int NORTH_AMERICA_VALUE = 2;
    public static final int REGION_REGION_NULL_VALUE = 0;
    private static final RegionRegionEnum[] VALUES;
    public static final int WORLDWIDE_VALUE = 8;
    private static final Internal.EnumLiteMap<RegionRegionEnum> internalValueMap;
    private final int value;

    static {
        RuntimeVersion.validateProtobufGencodeVersion(RuntimeVersion.RuntimeDomain.PUBLIC, 4, 27, 2, "", RegionRegionEnum.class.getName());
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
    public static RegionRegionEnum valueOf(int i) {
        return forNumber(i);
    }

    public static RegionRegionEnum forNumber(int i) {
        switch (i) {
            case 0:
                return REGION_REGION_NULL;
            case 1:
                return EUROPE;
            case 2:
                return NORTH_AMERICA;
            case 3:
                return AUSTRALIA;
            case 4:
                return NEW_ZEALAND;
            case 5:
                return JAPAN;
            case 6:
                return CHINA;
            case 7:
                return ASIA;
            case 8:
                return WORLDWIDE;
            case 9:
                return KOREA;
            case 10:
                return BRAZIL;
            default:
                return null;
        }
    }

    public static Internal.EnumLiteMap<RegionRegionEnum> internalGetValueMap() {
        return internalValueMap;
    }

    /* JADX INFO: renamed from: proto.RegionRegionEnum$1, reason: invalid class name */
    class AnonymousClass1 implements Internal.EnumLiteMap<RegionRegionEnum> {
        AnonymousClass1() {
        }

        @Override // com.google.protobuf.Internal.EnumLiteMap
        public RegionRegionEnum findValueByNumber(int i) {
            return RegionRegionEnum.forNumber(i);
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
        return Igdbproto.getDescriptor().getEnumTypes().get(14);
    }

    public static RegionRegionEnum valueOf(Descriptors.EnumValueDescriptor enumValueDescriptor) {
        if (enumValueDescriptor.getType() != getDescriptor()) {
            throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
        }
        if (enumValueDescriptor.getIndex() == -1) {
            return UNRECOGNIZED;
        }
        return VALUES[enumValueDescriptor.getIndex()];
    }

    RegionRegionEnum(int i) {
        this.value = i;
    }
}
