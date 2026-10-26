package proto;

import com.google.protobuf.Descriptors;
import com.google.protobuf.Internal;
import com.google.protobuf.ProtocolMessageEnum;
import com.google.protobuf.RuntimeVersion;

/* INFO: loaded from: classes6.dex */
public enum GameStatusEnum implements ProtocolMessageEnum {
    RELEASED(0),
    ALPHA(2),
    BETA(3),
    EARLY_ACCESS(4),
    OFFLINE(5),
    CANCELLED(6),
    RUMORED(7),
    DELISTED(8),
    UNRECOGNIZED(-1);

    public static final int ALPHA_VALUE = 2;
    public static final int BETA_VALUE = 3;
    public static final int CANCELLED_VALUE = 6;
    public static final int DELISTED_VALUE = 8;
    public static final int EARLY_ACCESS_VALUE = 4;
    public static final int OFFLINE_VALUE = 5;
    public static final int RELEASED_VALUE = 0;
    public static final int RUMORED_VALUE = 7;
    private static final GameStatusEnum[] VALUES;
    private static final Internal.EnumLiteMap<GameStatusEnum> internalValueMap;
    private final int value;

    static {
        RuntimeVersion.validateProtobufGencodeVersion(RuntimeVersion.RuntimeDomain.PUBLIC, 4, 27, 2, "", GameStatusEnum.class.getName());
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
    public static GameStatusEnum valueOf(int i) {
        return forNumber(i);
    }

    public static GameStatusEnum forNumber(int i) {
        if (i == 0) {
            return RELEASED;
        }
        switch (i) {
            case 2:
                return ALPHA;
            case 3:
                return BETA;
            case 4:
                return EARLY_ACCESS;
            case 5:
                return OFFLINE;
            case 6:
                return CANCELLED;
            case 7:
                return RUMORED;
            case 8:
                return DELISTED;
            default:
                return null;
        }
    }

    public static Internal.EnumLiteMap<GameStatusEnum> internalGetValueMap() {
        return internalValueMap;
    }

    /* INFO: renamed from: proto.GameStatusEnum$1, reason: invalid class name */
    class AnonymousClass1 implements Internal.EnumLiteMap<GameStatusEnum> {
        AnonymousClass1() {
        }

        @Override // com.google.protobuf.Internal.EnumLiteMap
        public GameStatusEnum findValueByNumber(int i) {
            return GameStatusEnum.forNumber(i);
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
        return Igdbproto.getDescriptor().getEnumTypes().get(10);
    }

    public static GameStatusEnum valueOf(Descriptors.EnumValueDescriptor enumValueDescriptor) {
        if (enumValueDescriptor.getType() != getDescriptor()) {
            throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
        }
        if (enumValueDescriptor.getIndex() == -1) {
            return UNRECOGNIZED;
        }
        return VALUES[enumValueDescriptor.getIndex()];
    }

    GameStatusEnum(int i) {
        this.value = i;
    }
}
