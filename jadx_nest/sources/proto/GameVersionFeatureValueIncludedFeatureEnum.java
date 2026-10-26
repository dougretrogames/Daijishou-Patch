package proto;

import com.google.protobuf.Descriptors;
import com.google.protobuf.Internal;
import com.google.protobuf.ProtocolMessageEnum;
import com.google.protobuf.RuntimeVersion;

/* INFO: loaded from: classes6.dex */
public enum GameVersionFeatureValueIncludedFeatureEnum implements ProtocolMessageEnum {
    NOT_INCLUDED(0),
    INCLUDED(1),
    PRE_ORDER_ONLY(2),
    UNRECOGNIZED(-1);

    public static final int INCLUDED_VALUE = 1;
    public static final int NOT_INCLUDED_VALUE = 0;
    public static final int PRE_ORDER_ONLY_VALUE = 2;
    private static final GameVersionFeatureValueIncludedFeatureEnum[] VALUES;
    private static final Internal.EnumLiteMap<GameVersionFeatureValueIncludedFeatureEnum> internalValueMap;
    private final int value;

    static {
        RuntimeVersion.validateProtobufGencodeVersion(RuntimeVersion.RuntimeDomain.PUBLIC, 4, 27, 2, "", GameVersionFeatureValueIncludedFeatureEnum.class.getName());
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
    public static GameVersionFeatureValueIncludedFeatureEnum valueOf(int i) {
        return forNumber(i);
    }

    public static GameVersionFeatureValueIncludedFeatureEnum forNumber(int i) {
        if (i == 0) {
            return NOT_INCLUDED;
        }
        if (i == 1) {
            return INCLUDED;
        }
        if (i != 2) {
            return null;
        }
        return PRE_ORDER_ONLY;
    }

    public static Internal.EnumLiteMap<GameVersionFeatureValueIncludedFeatureEnum> internalGetValueMap() {
        return internalValueMap;
    }

    /* INFO: renamed from: proto.GameVersionFeatureValueIncludedFeatureEnum$1, reason: invalid class name */
    class AnonymousClass1 implements Internal.EnumLiteMap<GameVersionFeatureValueIncludedFeatureEnum> {
        AnonymousClass1() {
        }

        @Override // com.google.protobuf.Internal.EnumLiteMap
        public GameVersionFeatureValueIncludedFeatureEnum findValueByNumber(int i) {
            return GameVersionFeatureValueIncludedFeatureEnum.forNumber(i);
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
        return Igdbproto.getDescriptor().getEnumTypes().get(12);
    }

    public static GameVersionFeatureValueIncludedFeatureEnum valueOf(Descriptors.EnumValueDescriptor enumValueDescriptor) {
        if (enumValueDescriptor.getType() != getDescriptor()) {
            throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
        }
        if (enumValueDescriptor.getIndex() == -1) {
            return UNRECOGNIZED;
        }
        return VALUES[enumValueDescriptor.getIndex()];
    }

    GameVersionFeatureValueIncludedFeatureEnum(int i) {
        this.value = i;
    }
}
