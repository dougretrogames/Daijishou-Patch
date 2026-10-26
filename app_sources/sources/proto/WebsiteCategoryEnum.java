package proto;

import com.google.protobuf.Descriptors;
import com.google.protobuf.Internal;
import com.google.protobuf.ProtocolMessageEnum;
import com.google.protobuf.RuntimeVersion;

/* INFO: loaded from: classes6.dex */
public enum WebsiteCategoryEnum implements ProtocolMessageEnum {
    WEBSITE_CATEGORY_NULL(0),
    WEBSITE_OFFICIAL(1),
    WEBSITE_WIKIA(2),
    WEBSITE_WIKIPEDIA(3),
    WEBSITE_FACEBOOK(4),
    WEBSITE_TWITTER(5),
    WEBSITE_TWITCH(6),
    WEBSITE_INSTAGRAM(8),
    WEBSITE_YOUTUBE(9),
    WEBSITE_IPHONE(10),
    WEBSITE_IPAD(11),
    WEBSITE_ANDROID(12),
    WEBSITE_STEAM(13),
    WEBSITE_REDDIT(14),
    WEBSITE_ITCH(15),
    WEBSITE_EPICGAMES(16),
    WEBSITE_GOG(17),
    WEBSITE_DISCORD(18),
    UNRECOGNIZED(-1);

    private static final WebsiteCategoryEnum[] VALUES;
    public static final int WEBSITE_ANDROID_VALUE = 12;
    public static final int WEBSITE_CATEGORY_NULL_VALUE = 0;
    public static final int WEBSITE_DISCORD_VALUE = 18;
    public static final int WEBSITE_EPICGAMES_VALUE = 16;
    public static final int WEBSITE_FACEBOOK_VALUE = 4;
    public static final int WEBSITE_GOG_VALUE = 17;
    public static final int WEBSITE_INSTAGRAM_VALUE = 8;
    public static final int WEBSITE_IPAD_VALUE = 11;
    public static final int WEBSITE_IPHONE_VALUE = 10;
    public static final int WEBSITE_ITCH_VALUE = 15;
    public static final int WEBSITE_OFFICIAL_VALUE = 1;
    public static final int WEBSITE_REDDIT_VALUE = 14;
    public static final int WEBSITE_STEAM_VALUE = 13;
    public static final int WEBSITE_TWITCH_VALUE = 6;
    public static final int WEBSITE_TWITTER_VALUE = 5;
    public static final int WEBSITE_WIKIA_VALUE = 2;
    public static final int WEBSITE_WIKIPEDIA_VALUE = 3;
    public static final int WEBSITE_YOUTUBE_VALUE = 9;
    private static final Internal.EnumLiteMap<WebsiteCategoryEnum> internalValueMap;
    private final int value;

    static {
        RuntimeVersion.validateProtobufGencodeVersion(RuntimeVersion.RuntimeDomain.PUBLIC, 4, 27, 2, "", WebsiteCategoryEnum.class.getName());
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
    public static WebsiteCategoryEnum valueOf(int i) {
        return forNumber(i);
    }

    public static WebsiteCategoryEnum forNumber(int i) {
        switch (i) {
            case 0:
                return WEBSITE_CATEGORY_NULL;
            case 1:
                return WEBSITE_OFFICIAL;
            case 2:
                return WEBSITE_WIKIA;
            case 3:
                return WEBSITE_WIKIPEDIA;
            case 4:
                return WEBSITE_FACEBOOK;
            case 5:
                return WEBSITE_TWITTER;
            case 6:
                return WEBSITE_TWITCH;
            case 7:
            default:
                return null;
            case 8:
                return WEBSITE_INSTAGRAM;
            case 9:
                return WEBSITE_YOUTUBE;
            case 10:
                return WEBSITE_IPHONE;
            case 11:
                return WEBSITE_IPAD;
            case 12:
                return WEBSITE_ANDROID;
            case 13:
                return WEBSITE_STEAM;
            case 14:
                return WEBSITE_REDDIT;
            case 15:
                return WEBSITE_ITCH;
            case 16:
                return WEBSITE_EPICGAMES;
            case 17:
                return WEBSITE_GOG;
            case 18:
                return WEBSITE_DISCORD;
        }
    }

    public static Internal.EnumLiteMap<WebsiteCategoryEnum> internalGetValueMap() {
        return internalValueMap;
    }

    /* INFO: renamed from: proto.WebsiteCategoryEnum$1, reason: invalid class name */
    class AnonymousClass1 implements Internal.EnumLiteMap<WebsiteCategoryEnum> {
        AnonymousClass1() {
        }

        @Override // com.google.protobuf.Internal.EnumLiteMap
        public WebsiteCategoryEnum findValueByNumber(int i) {
            return WebsiteCategoryEnum.forNumber(i);
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
        return Igdbproto.getDescriptor().getEnumTypes().get(6);
    }

    public static WebsiteCategoryEnum valueOf(Descriptors.EnumValueDescriptor enumValueDescriptor) {
        if (enumValueDescriptor.getType() != getDescriptor()) {
            throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
        }
        if (enumValueDescriptor.getIndex() == -1) {
            return UNRECOGNIZED;
        }
        return VALUES[enumValueDescriptor.getIndex()];
    }

    WebsiteCategoryEnum(int i) {
        this.value = i;
    }
}
