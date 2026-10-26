package proto;

import com.google.protobuf.Descriptors;
import com.google.protobuf.Internal;
import com.google.protobuf.ProtocolMessageEnum;
import com.google.protobuf.RuntimeVersion;

/* INFO: loaded from: classes6.dex */
public enum ExternalGameCategoryEnum implements ProtocolMessageEnum {
    EXTERNALGAME_CATEGORY_NULL(0),
    EXTERNALGAME_STEAM(1),
    EXTERNALGAME_GOG(5),
    EXTERNALGAME_YOUTUBE(10),
    EXTERNALGAME_MICROSOFT(11),
    EXTERNALGAME_APPLE(13),
    EXTERNALGAME_TWITCH(14),
    EXTERNALGAME_ANDROID(15),
    EXTERNALGAME_AMAZON_ASIN(20),
    EXTERNALGAME_AMAZON_LUNA(22),
    EXTERNALGAME_AMAZON_ADG(23),
    EXTERNALGAME_EPIC_GAME_STORE(26),
    EXTERNALGAME_OCULUS(28),
    EXTERNALGAME_UTOMIK(29),
    EXTERNALGAME_ITCH_IO(30),
    EXTERNALGAME_XBOX_MARKETPLACE(31),
    EXTERNALGAME_KARTRIDGE(32),
    EXTERNALGAME_PLAYSTATION_STORE_US(36),
    EXTERNALGAME_FOCUS_ENTERTAINMENT(37),
    EXTERNALGAME_XBOX_GAME_PASS_ULTIMATE_CLOUD(54),
    EXTERNALGAME_GAMEJOLT(55),
    UNRECOGNIZED(-1);

    public static final int EXTERNALGAME_AMAZON_ADG_VALUE = 23;
    public static final int EXTERNALGAME_AMAZON_ASIN_VALUE = 20;
    public static final int EXTERNALGAME_AMAZON_LUNA_VALUE = 22;
    public static final int EXTERNALGAME_ANDROID_VALUE = 15;
    public static final int EXTERNALGAME_APPLE_VALUE = 13;
    public static final int EXTERNALGAME_CATEGORY_NULL_VALUE = 0;
    public static final int EXTERNALGAME_EPIC_GAME_STORE_VALUE = 26;
    public static final int EXTERNALGAME_FOCUS_ENTERTAINMENT_VALUE = 37;
    public static final int EXTERNALGAME_GAMEJOLT_VALUE = 55;
    public static final int EXTERNALGAME_GOG_VALUE = 5;
    public static final int EXTERNALGAME_ITCH_IO_VALUE = 30;
    public static final int EXTERNALGAME_KARTRIDGE_VALUE = 32;
    public static final int EXTERNALGAME_MICROSOFT_VALUE = 11;
    public static final int EXTERNALGAME_OCULUS_VALUE = 28;
    public static final int EXTERNALGAME_PLAYSTATION_STORE_US_VALUE = 36;
    public static final int EXTERNALGAME_STEAM_VALUE = 1;
    public static final int EXTERNALGAME_TWITCH_VALUE = 14;
    public static final int EXTERNALGAME_UTOMIK_VALUE = 29;
    public static final int EXTERNALGAME_XBOX_GAME_PASS_ULTIMATE_CLOUD_VALUE = 54;
    public static final int EXTERNALGAME_XBOX_MARKETPLACE_VALUE = 31;
    public static final int EXTERNALGAME_YOUTUBE_VALUE = 10;
    private static final ExternalGameCategoryEnum[] VALUES;
    private static final Internal.EnumLiteMap<ExternalGameCategoryEnum> internalValueMap;
    private final int value;

    static {
        RuntimeVersion.validateProtobufGencodeVersion(RuntimeVersion.RuntimeDomain.PUBLIC, 4, 27, 2, "", ExternalGameCategoryEnum.class.getName());
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
    public static ExternalGameCategoryEnum valueOf(int i) {
        return forNumber(i);
    }

    public static ExternalGameCategoryEnum forNumber(int i) {
        if (i == 0) {
            return EXTERNALGAME_CATEGORY_NULL;
        }
        if (i == 1) {
            return EXTERNALGAME_STEAM;
        }
        if (i == 5) {
            return EXTERNALGAME_GOG;
        }
        if (i == 20) {
            return EXTERNALGAME_AMAZON_ASIN;
        }
        if (i == 26) {
            return EXTERNALGAME_EPIC_GAME_STORE;
        }
        if (i == 10) {
            return EXTERNALGAME_YOUTUBE;
        }
        if (i == 11) {
            return EXTERNALGAME_MICROSOFT;
        }
        if (i == 22) {
            return EXTERNALGAME_AMAZON_LUNA;
        }
        if (i == 23) {
            return EXTERNALGAME_AMAZON_ADG;
        }
        if (i == 36) {
            return EXTERNALGAME_PLAYSTATION_STORE_US;
        }
        if (i == 37) {
            return EXTERNALGAME_FOCUS_ENTERTAINMENT;
        }
        if (i == 54) {
            return EXTERNALGAME_XBOX_GAME_PASS_ULTIMATE_CLOUD;
        }
        if (i != 55) {
            switch (i) {
                case 13:
                    return EXTERNALGAME_APPLE;
                case 14:
                    return EXTERNALGAME_TWITCH;
                case 15:
                    return EXTERNALGAME_ANDROID;
                default:
                    switch (i) {
                        case 28:
                            return EXTERNALGAME_OCULUS;
                        case 29:
                            return EXTERNALGAME_UTOMIK;
                        case 30:
                            return EXTERNALGAME_ITCH_IO;
                        case 31:
                            return EXTERNALGAME_XBOX_MARKETPLACE;
                        case 32:
                            return EXTERNALGAME_KARTRIDGE;
                        default:
                            return null;
                    }
            }
        }
        return EXTERNALGAME_GAMEJOLT;
    }

    public static Internal.EnumLiteMap<ExternalGameCategoryEnum> internalGetValueMap() {
        return internalValueMap;
    }

    /* INFO: renamed from: proto.ExternalGameCategoryEnum$1, reason: invalid class name */
    class AnonymousClass1 implements Internal.EnumLiteMap<ExternalGameCategoryEnum> {
        AnonymousClass1() {
        }

        @Override // com.google.protobuf.Internal.EnumLiteMap
        public ExternalGameCategoryEnum findValueByNumber(int i) {
            return ExternalGameCategoryEnum.forNumber(i);
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
        return Igdbproto.getDescriptor().getEnumTypes().get(7);
    }

    public static ExternalGameCategoryEnum valueOf(Descriptors.EnumValueDescriptor enumValueDescriptor) {
        if (enumValueDescriptor.getType() != getDescriptor()) {
            throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
        }
        if (enumValueDescriptor.getIndex() == -1) {
            return UNRECOGNIZED;
        }
        return VALUES[enumValueDescriptor.getIndex()];
    }

    ExternalGameCategoryEnum(int i) {
        this.value = i;
    }
}
