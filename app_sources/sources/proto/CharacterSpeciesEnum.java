package proto;

import com.google.protobuf.Descriptors;
import com.google.protobuf.Internal;
import com.google.protobuf.ProtocolMessageEnum;
import com.google.protobuf.RuntimeVersion;

/* INFO: loaded from: classes6.dex */
public enum CharacterSpeciesEnum implements ProtocolMessageEnum {
    CHARACTER_SPECIES_NULL(0),
    HUMAN(1),
    ALIEN(2),
    ANIMAL(3),
    ANDROID(4),
    UNKNOWN(5),
    UNRECOGNIZED(-1);

    public static final int ALIEN_VALUE = 2;
    public static final int ANDROID_VALUE = 4;
    public static final int ANIMAL_VALUE = 3;
    public static final int CHARACTER_SPECIES_NULL_VALUE = 0;
    public static final int HUMAN_VALUE = 1;
    public static final int UNKNOWN_VALUE = 5;
    private static final CharacterSpeciesEnum[] VALUES;
    private static final Internal.EnumLiteMap<CharacterSpeciesEnum> internalValueMap;
    private final int value;

    static {
        RuntimeVersion.validateProtobufGencodeVersion(RuntimeVersion.RuntimeDomain.PUBLIC, 4, 27, 2, "", CharacterSpeciesEnum.class.getName());
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
    public static CharacterSpeciesEnum valueOf(int i) {
        return forNumber(i);
    }

    public static CharacterSpeciesEnum forNumber(int i) {
        if (i == 0) {
            return CHARACTER_SPECIES_NULL;
        }
        if (i == 1) {
            return HUMAN;
        }
        if (i == 2) {
            return ALIEN;
        }
        if (i == 3) {
            return ANIMAL;
        }
        if (i == 4) {
            return ANDROID;
        }
        if (i != 5) {
            return null;
        }
        return UNKNOWN;
    }

    public static Internal.EnumLiteMap<CharacterSpeciesEnum> internalGetValueMap() {
        return internalValueMap;
    }

    /* INFO: renamed from: proto.CharacterSpeciesEnum$1, reason: invalid class name */
    class AnonymousClass1 implements Internal.EnumLiteMap<CharacterSpeciesEnum> {
        AnonymousClass1() {
        }

        @Override // com.google.protobuf.Internal.EnumLiteMap
        public CharacterSpeciesEnum findValueByNumber(int i) {
            return CharacterSpeciesEnum.forNumber(i);
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
        return Igdbproto.getDescriptor().getEnumTypes().get(4);
    }

    public static CharacterSpeciesEnum valueOf(Descriptors.EnumValueDescriptor enumValueDescriptor) {
        if (enumValueDescriptor.getType() != getDescriptor()) {
            throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
        }
        if (enumValueDescriptor.getIndex() == -1) {
            return UNRECOGNIZED;
        }
        return VALUES[enumValueDescriptor.getIndex()];
    }

    CharacterSpeciesEnum(int i) {
        this.value = i;
    }
}
