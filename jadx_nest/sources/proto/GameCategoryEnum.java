package proto;

import com.google.protobuf.Descriptors;
import com.google.protobuf.Internal;
import com.google.protobuf.ProtocolMessageEnum;
import com.google.protobuf.RuntimeVersion;

/* JADX INFO: loaded from: classes6.dex */
public enum GameCategoryEnum implements ProtocolMessageEnum {
    MAIN_GAME(0),
    DLC_ADDON(1),
    EXPANSION(2),
    BUNDLE(3),
    STANDALONE_EXPANSION(4),
    MOD(5),
    EPISODE(6),
    SEASON(7),
    REMAKE(8),
    REMASTER(9),
    EXPANDED_GAME(10),
    PORT(11),
    FORK(12),
    PACK(13),
    UPDATE(14),
    UNRECOGNIZED(-1);

    public static final int BUNDLE_VALUE = 3;
    public static final int DLC_ADDON_VALUE = 1;
    public static final int EPISODE_VALUE = 6;
    public static final int EXPANDED_GAME_VALUE = 10;
    public static final int EXPANSION_VALUE = 2;
    public static final int FORK_VALUE = 12;
    public static final int MAIN_GAME_VALUE = 0;
    public static final int MOD_VALUE = 5;
    public static final int PACK_VALUE = 13;
    public static final int PORT_VALUE = 11;
    public static final int REMAKE_VALUE = 8;
    public static final int REMASTER_VALUE = 9;
    public static final int SEASON_VALUE = 7;
    public static final int STANDALONE_EXPANSION_VALUE = 4;
    public static final int UPDATE_VALUE = 14;
    private static final GameCategoryEnum[] VALUES;
    private static final Internal.EnumLiteMap<GameCategoryEnum> internalValueMap;
    private final int value;

    static {
        RuntimeVersion.validateProtobufGencodeVersion(RuntimeVersion.RuntimeDomain.PUBLIC, 4, 27, 2, "", GameCategoryEnum.class.getName());
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
    public static GameCategoryEnum valueOf(int i) {
        return forNumber(i);
    }

    public static GameCategoryEnum forNumber(int i) {
        switch (i) {
            case 0:
                return MAIN_GAME;
            case 1:
                return DLC_ADDON;
            case 2:
                return EXPANSION;
            case 3:
                return BUNDLE;
            case 4:
                return STANDALONE_EXPANSION;
            case 5:
                return MOD;
            case 6:
                return EPISODE;
            case 7:
                return SEASON;
            case 8:
                return REMAKE;
            case 9:
                return REMASTER;
            case 10:
                return EXPANDED_GAME;
            case 11:
                return PORT;
            case 12:
                return FORK;
            case 13:
                return PACK;
            case 14:
                return UPDATE;
            default:
                return null;
        }
    }

    public static Internal.EnumLiteMap<GameCategoryEnum> internalGetValueMap() {
        return internalValueMap;
    }

    /* JADX INFO: renamed from: proto.GameCategoryEnum$1, reason: invalid class name */
    class AnonymousClass1 implements Internal.EnumLiteMap<GameCategoryEnum> {
        AnonymousClass1() {
        }

        @Override // com.google.protobuf.Internal.EnumLiteMap
        public GameCategoryEnum findValueByNumber(int i) {
            return GameCategoryEnum.forNumber(i);
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
        return Igdbproto.getDescriptor().getEnumTypes().get(9);
    }

    public static GameCategoryEnum valueOf(Descriptors.EnumValueDescriptor enumValueDescriptor) {
        if (enumValueDescriptor.getType() != getDescriptor()) {
            throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
        }
        if (enumValueDescriptor.getIndex() == -1) {
            return UNRECOGNIZED;
        }
        return VALUES[enumValueDescriptor.getIndex()];
    }

    GameCategoryEnum(int i) {
        this.value = i;
    }
}
