package proto;

import com.google.protobuf.Descriptors;
import com.google.protobuf.Internal;
import com.google.protobuf.ProtocolMessageEnum;
import com.google.protobuf.RuntimeVersion;

/* JADX INFO: loaded from: classes6.dex */
public enum PlatformCategoryEnum implements ProtocolMessageEnum {
    PLATFORM_CATEGORY_NULL(0),
    CONSOLE(1),
    ARCADE(2),
    PLATFORM(3),
    OPERATING_SYSTEM(4),
    PORTABLE_CONSOLE(5),
    COMPUTER(6),
    UNRECOGNIZED(-1);

    public static final int ARCADE_VALUE = 2;
    public static final int COMPUTER_VALUE = 6;
    public static final int CONSOLE_VALUE = 1;
    public static final int OPERATING_SYSTEM_VALUE = 4;
    public static final int PLATFORM_CATEGORY_NULL_VALUE = 0;
    public static final int PLATFORM_VALUE = 3;
    public static final int PORTABLE_CONSOLE_VALUE = 5;
    private static final PlatformCategoryEnum[] VALUES;
    private static final Internal.EnumLiteMap<PlatformCategoryEnum> internalValueMap;
    private final int value;

    static {
        RuntimeVersion.validateProtobufGencodeVersion(RuntimeVersion.RuntimeDomain.PUBLIC, 4, 27, 2, "", PlatformCategoryEnum.class.getName());
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
    public static PlatformCategoryEnum valueOf(int i) {
        return forNumber(i);
    }

    public static PlatformCategoryEnum forNumber(int i) {
        switch (i) {
            case 0:
                return PLATFORM_CATEGORY_NULL;
            case 1:
                return CONSOLE;
            case 2:
                return ARCADE;
            case 3:
                return PLATFORM;
            case 4:
                return OPERATING_SYSTEM;
            case 5:
                return PORTABLE_CONSOLE;
            case 6:
                return COMPUTER;
            default:
                return null;
        }
    }

    public static Internal.EnumLiteMap<PlatformCategoryEnum> internalGetValueMap() {
        return internalValueMap;
    }

    /* JADX INFO: renamed from: proto.PlatformCategoryEnum$1, reason: invalid class name */
    class AnonymousClass1 implements Internal.EnumLiteMap<PlatformCategoryEnum> {
        AnonymousClass1() {
        }

        @Override // com.google.protobuf.Internal.EnumLiteMap
        public PlatformCategoryEnum findValueByNumber(int i) {
            return PlatformCategoryEnum.forNumber(i);
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
        return Igdbproto.getDescriptor().getEnumTypes().get(13);
    }

    public static PlatformCategoryEnum valueOf(Descriptors.EnumValueDescriptor enumValueDescriptor) {
        if (enumValueDescriptor.getType() != getDescriptor()) {
            throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
        }
        if (enumValueDescriptor.getIndex() == -1) {
            return UNRECOGNIZED;
        }
        return VALUES[enumValueDescriptor.getIndex()];
    }

    PlatformCategoryEnum(int i) {
        this.value = i;
    }
}
