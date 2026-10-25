package proto;

import com.google.protobuf.Descriptors;
import com.google.protobuf.Internal;
import com.google.protobuf.ProtocolMessageEnum;
import com.google.protobuf.RuntimeVersion;

/* JADX INFO: loaded from: classes6.dex */
public enum GameVersionFeatureCategoryEnum implements ProtocolMessageEnum {
    BOOLEAN(0),
    DESCRIPTION(1),
    UNRECOGNIZED(-1);

    public static final int BOOLEAN_VALUE = 0;
    public static final int DESCRIPTION_VALUE = 1;
    private static final GameVersionFeatureCategoryEnum[] VALUES;
    private static final Internal.EnumLiteMap<GameVersionFeatureCategoryEnum> internalValueMap;
    private final int value;

    static {
        RuntimeVersion.validateProtobufGencodeVersion(RuntimeVersion.RuntimeDomain.PUBLIC, 4, 27, 2, "", GameVersionFeatureCategoryEnum.class.getName());
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
    public static GameVersionFeatureCategoryEnum valueOf(int i) {
        return forNumber(i);
    }

    public static GameVersionFeatureCategoryEnum forNumber(int i) {
        if (i == 0) {
            return BOOLEAN;
        }
        if (i != 1) {
            return null;
        }
        return DESCRIPTION;
    }

    public static Internal.EnumLiteMap<GameVersionFeatureCategoryEnum> internalGetValueMap() {
        return internalValueMap;
    }

    /* JADX INFO: renamed from: proto.GameVersionFeatureCategoryEnum$1, reason: invalid class name */
    class AnonymousClass1 implements Internal.EnumLiteMap<GameVersionFeatureCategoryEnum> {
        AnonymousClass1() {
        }

        @Override // com.google.protobuf.Internal.EnumLiteMap
        public GameVersionFeatureCategoryEnum findValueByNumber(int i) {
            return GameVersionFeatureCategoryEnum.forNumber(i);
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
        return Igdbproto.getDescriptor().getEnumTypes().get(11);
    }

    public static GameVersionFeatureCategoryEnum valueOf(Descriptors.EnumValueDescriptor enumValueDescriptor) {
        if (enumValueDescriptor.getType() != getDescriptor()) {
            throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
        }
        if (enumValueDescriptor.getIndex() == -1) {
            return UNRECOGNIZED;
        }
        return VALUES[enumValueDescriptor.getIndex()];
    }

    GameVersionFeatureCategoryEnum(int i) {
        this.value = i;
    }
}
