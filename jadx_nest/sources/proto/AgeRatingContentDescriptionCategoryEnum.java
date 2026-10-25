package proto;

import com.google.protobuf.Descriptors;
import com.google.protobuf.Internal;
import com.google.protobuf.ProtocolMessageEnum;
import com.google.protobuf.RuntimeVersion;

/* JADX INFO: loaded from: classes6.dex */
public enum AgeRatingContentDescriptionCategoryEnum implements ProtocolMessageEnum {
    AGERATINGCONTENTDESCRIPTION_CATEGORY_NULL(0),
    ESRB_ALCOHOL_REFERENCE(1),
    ESRB_ANIMATED_BLOOD(2),
    ESRB_BLOOD(3),
    ESRB_BLOOD_AND_GORE(4),
    ESRB_CARTOON_VIOLENCE(5),
    ESRB_COMIC_MISCHIEF(6),
    ESRB_CRUDE_HUMOR(7),
    ESRB_DRUG_REFERENCE(8),
    ESRB_FANTASY_VIOLENCE(9),
    ESRB_INTENSE_VIOLENCE(10),
    ESRB_LANGUAGE(11),
    ESRB_LYRICS(12),
    ESRB_MATURE_HUMOR(13),
    ESRB_NUDITY(14),
    ESRB_PARTIAL_NUDITY(15),
    ESRB_REAL_GAMBLING(16),
    ESRB_SEXUAL_CONTENT(17),
    ESRB_SEXUAL_THEMES(18),
    ESRB_SEXUAL_VIOLENCE(19),
    ESRB_SIMULATED_GAMBLING(20),
    ESRB_STRONG_LANGUAGE(21),
    ESRB_STRONG_LYRICS(22),
    ESRB_STRONG_SEXUAL_CONTENT(23),
    ESRB_SUGGESTIVE_THEMES(24),
    ESRB_TOBACCO_REFERENCE(25),
    ESRB_USE_OF_ALCOHOL(26),
    ESRB_USE_OF_DRUGS(27),
    ESRB_USE_OF_TOBACCO(28),
    ESRB_VIOLENCE(29),
    ESRB_VIOLENT_REFERENCES(30),
    ESRB_ANIMATED_VIOLENCE(31),
    ESRB_MILD_LANGUAGE(32),
    ESRB_MILD_VIOLENCE(33),
    ESRB_USE_OF_DRUGS_AND_ALCOHOL(34),
    ESRB_DRUG_AND_ALCOHOL_REFERENCE(35),
    ESRB_MILD_SUGGESTIVE_THEMES(36),
    ESRB_MILD_CARTOON_VIOLENCE(37),
    ESRB_MILD_BLOOD(38),
    ESRB_REALISTIC_BLOOD_AND_GORE(39),
    ESRB_REALISTIC_VIOLENCE(40),
    ESRB_ALCOHOL_AND_TOBACCO_REFERENCE(41),
    ESRB_MATURE_SEXUAL_THEMES(42),
    ESRB_MILD_ANIMATED_VIOLENCE(43),
    ESRB_MILD_SEXUAL_THEMES(44),
    ESRB_USE_OF_ALCOHOL_AND_TOBACCO(45),
    ESRB_ANIMATED_BLOOD_AND_GORE(46),
    ESRB_MILD_FANTASY_VIOLENCE(47),
    ESRB_MILD_LYRICS(48),
    ESRB_REALISTIC_BLOOD(49),
    PEGI_VIOLENCE(50),
    PEGI_SEX(51),
    PEGI_DRUGS(52),
    PEGI_FEAR(53),
    PEGI_DISCRIMINATION(54),
    PEGI_BAD_LANGUAGE(55),
    PEGI_GAMBLING(56),
    PEGI_ONLINE_GAMEPLAY(57),
    PEGI_IN_GAME_PURCHASES(58),
    CERO_LOVE(59),
    CERO_SEXUAL_CONTENT(60),
    CERO_VIOLENCE(61),
    CERO_HORROR(62),
    CERO_DRINKING_SMOKING(63),
    CERO_GAMBLING(64),
    CERO_CRIME(65),
    CERO_CONTROLLED_SUBSTANCES(66),
    CERO_LANGUAGES_AND_OTHERS(67),
    GRAC_SEXUALITY(68),
    GRAC_VIOLENCE(69),
    GRAC_FEAR_HORROR_THREATENING(70),
    GRAC_LANGUAGE(71),
    GRAC_ALCOHOL_TOBACCO_DRUG(72),
    GRAC_CRIME_ANTI_SOCIAL(73),
    GRAC_GAMBLING(74),
    CLASS_IND_VIOLENCIA(75),
    CLASS_IND_VIOLENCIA_EXTREMA(76),
    CLASS_IND_CONTEUDO_SEXUAL(77),
    CLASS_IND_NUDEZ(78),
    CLASS_IND_SEXO(79),
    CLASS_IND_SEXO_EXPLICITO(80),
    CLASS_IND_DROGAS(81),
    CLASS_IND_DROGAS_LICITAS(82),
    CLASS_IND_DROGAS_ILICITAS(83),
    CLASS_IND_LINGUAGEM_IMPROPRIA(84),
    CLASS_IND_ATOS_CRIMINOSOS(85),
    UNRECOGNIZED(-1);

    public static final int AGERATINGCONTENTDESCRIPTION_CATEGORY_NULL_VALUE = 0;
    public static final int CERO_CONTROLLED_SUBSTANCES_VALUE = 66;
    public static final int CERO_CRIME_VALUE = 65;
    public static final int CERO_DRINKING_SMOKING_VALUE = 63;
    public static final int CERO_GAMBLING_VALUE = 64;
    public static final int CERO_HORROR_VALUE = 62;
    public static final int CERO_LANGUAGES_AND_OTHERS_VALUE = 67;
    public static final int CERO_LOVE_VALUE = 59;
    public static final int CERO_SEXUAL_CONTENT_VALUE = 60;
    public static final int CERO_VIOLENCE_VALUE = 61;
    public static final int CLASS_IND_ATOS_CRIMINOSOS_VALUE = 85;
    public static final int CLASS_IND_CONTEUDO_SEXUAL_VALUE = 77;
    public static final int CLASS_IND_DROGAS_ILICITAS_VALUE = 83;
    public static final int CLASS_IND_DROGAS_LICITAS_VALUE = 82;
    public static final int CLASS_IND_DROGAS_VALUE = 81;
    public static final int CLASS_IND_LINGUAGEM_IMPROPRIA_VALUE = 84;
    public static final int CLASS_IND_NUDEZ_VALUE = 78;
    public static final int CLASS_IND_SEXO_EXPLICITO_VALUE = 80;
    public static final int CLASS_IND_SEXO_VALUE = 79;
    public static final int CLASS_IND_VIOLENCIA_EXTREMA_VALUE = 76;
    public static final int CLASS_IND_VIOLENCIA_VALUE = 75;
    public static final int ESRB_ALCOHOL_AND_TOBACCO_REFERENCE_VALUE = 41;
    public static final int ESRB_ALCOHOL_REFERENCE_VALUE = 1;
    public static final int ESRB_ANIMATED_BLOOD_AND_GORE_VALUE = 46;
    public static final int ESRB_ANIMATED_BLOOD_VALUE = 2;
    public static final int ESRB_ANIMATED_VIOLENCE_VALUE = 31;
    public static final int ESRB_BLOOD_AND_GORE_VALUE = 4;
    public static final int ESRB_BLOOD_VALUE = 3;
    public static final int ESRB_CARTOON_VIOLENCE_VALUE = 5;
    public static final int ESRB_COMIC_MISCHIEF_VALUE = 6;
    public static final int ESRB_CRUDE_HUMOR_VALUE = 7;
    public static final int ESRB_DRUG_AND_ALCOHOL_REFERENCE_VALUE = 35;
    public static final int ESRB_DRUG_REFERENCE_VALUE = 8;
    public static final int ESRB_FANTASY_VIOLENCE_VALUE = 9;
    public static final int ESRB_INTENSE_VIOLENCE_VALUE = 10;
    public static final int ESRB_LANGUAGE_VALUE = 11;
    public static final int ESRB_LYRICS_VALUE = 12;
    public static final int ESRB_MATURE_HUMOR_VALUE = 13;
    public static final int ESRB_MATURE_SEXUAL_THEMES_VALUE = 42;
    public static final int ESRB_MILD_ANIMATED_VIOLENCE_VALUE = 43;
    public static final int ESRB_MILD_BLOOD_VALUE = 38;
    public static final int ESRB_MILD_CARTOON_VIOLENCE_VALUE = 37;
    public static final int ESRB_MILD_FANTASY_VIOLENCE_VALUE = 47;
    public static final int ESRB_MILD_LANGUAGE_VALUE = 32;
    public static final int ESRB_MILD_LYRICS_VALUE = 48;
    public static final int ESRB_MILD_SEXUAL_THEMES_VALUE = 44;
    public static final int ESRB_MILD_SUGGESTIVE_THEMES_VALUE = 36;
    public static final int ESRB_MILD_VIOLENCE_VALUE = 33;
    public static final int ESRB_NUDITY_VALUE = 14;
    public static final int ESRB_PARTIAL_NUDITY_VALUE = 15;
    public static final int ESRB_REALISTIC_BLOOD_AND_GORE_VALUE = 39;
    public static final int ESRB_REALISTIC_BLOOD_VALUE = 49;
    public static final int ESRB_REALISTIC_VIOLENCE_VALUE = 40;
    public static final int ESRB_REAL_GAMBLING_VALUE = 16;
    public static final int ESRB_SEXUAL_CONTENT_VALUE = 17;
    public static final int ESRB_SEXUAL_THEMES_VALUE = 18;
    public static final int ESRB_SEXUAL_VIOLENCE_VALUE = 19;
    public static final int ESRB_SIMULATED_GAMBLING_VALUE = 20;
    public static final int ESRB_STRONG_LANGUAGE_VALUE = 21;
    public static final int ESRB_STRONG_LYRICS_VALUE = 22;
    public static final int ESRB_STRONG_SEXUAL_CONTENT_VALUE = 23;
    public static final int ESRB_SUGGESTIVE_THEMES_VALUE = 24;
    public static final int ESRB_TOBACCO_REFERENCE_VALUE = 25;
    public static final int ESRB_USE_OF_ALCOHOL_AND_TOBACCO_VALUE = 45;
    public static final int ESRB_USE_OF_ALCOHOL_VALUE = 26;
    public static final int ESRB_USE_OF_DRUGS_AND_ALCOHOL_VALUE = 34;
    public static final int ESRB_USE_OF_DRUGS_VALUE = 27;
    public static final int ESRB_USE_OF_TOBACCO_VALUE = 28;
    public static final int ESRB_VIOLENCE_VALUE = 29;
    public static final int ESRB_VIOLENT_REFERENCES_VALUE = 30;
    public static final int GRAC_ALCOHOL_TOBACCO_DRUG_VALUE = 72;
    public static final int GRAC_CRIME_ANTI_SOCIAL_VALUE = 73;
    public static final int GRAC_FEAR_HORROR_THREATENING_VALUE = 70;
    public static final int GRAC_GAMBLING_VALUE = 74;
    public static final int GRAC_LANGUAGE_VALUE = 71;
    public static final int GRAC_SEXUALITY_VALUE = 68;
    public static final int GRAC_VIOLENCE_VALUE = 69;
    public static final int PEGI_BAD_LANGUAGE_VALUE = 55;
    public static final int PEGI_DISCRIMINATION_VALUE = 54;
    public static final int PEGI_DRUGS_VALUE = 52;
    public static final int PEGI_FEAR_VALUE = 53;
    public static final int PEGI_GAMBLING_VALUE = 56;
    public static final int PEGI_IN_GAME_PURCHASES_VALUE = 58;
    public static final int PEGI_ONLINE_GAMEPLAY_VALUE = 57;
    public static final int PEGI_SEX_VALUE = 51;
    public static final int PEGI_VIOLENCE_VALUE = 50;
    private static final AgeRatingContentDescriptionCategoryEnum[] VALUES;
    private static final Internal.EnumLiteMap<AgeRatingContentDescriptionCategoryEnum> internalValueMap;
    private final int value;

    static {
        RuntimeVersion.validateProtobufGencodeVersion(RuntimeVersion.RuntimeDomain.PUBLIC, 4, 27, 2, "", AgeRatingContentDescriptionCategoryEnum.class.getName());
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
    public static AgeRatingContentDescriptionCategoryEnum valueOf(int i) {
        return forNumber(i);
    }

    public static AgeRatingContentDescriptionCategoryEnum forNumber(int i) {
        switch (i) {
            case 0:
                return AGERATINGCONTENTDESCRIPTION_CATEGORY_NULL;
            case 1:
                return ESRB_ALCOHOL_REFERENCE;
            case 2:
                return ESRB_ANIMATED_BLOOD;
            case 3:
                return ESRB_BLOOD;
            case 4:
                return ESRB_BLOOD_AND_GORE;
            case 5:
                return ESRB_CARTOON_VIOLENCE;
            case 6:
                return ESRB_COMIC_MISCHIEF;
            case 7:
                return ESRB_CRUDE_HUMOR;
            case 8:
                return ESRB_DRUG_REFERENCE;
            case 9:
                return ESRB_FANTASY_VIOLENCE;
            case 10:
                return ESRB_INTENSE_VIOLENCE;
            case 11:
                return ESRB_LANGUAGE;
            case 12:
                return ESRB_LYRICS;
            case 13:
                return ESRB_MATURE_HUMOR;
            case 14:
                return ESRB_NUDITY;
            case 15:
                return ESRB_PARTIAL_NUDITY;
            case 16:
                return ESRB_REAL_GAMBLING;
            case 17:
                return ESRB_SEXUAL_CONTENT;
            case 18:
                return ESRB_SEXUAL_THEMES;
            case 19:
                return ESRB_SEXUAL_VIOLENCE;
            case 20:
                return ESRB_SIMULATED_GAMBLING;
            case 21:
                return ESRB_STRONG_LANGUAGE;
            case 22:
                return ESRB_STRONG_LYRICS;
            case 23:
                return ESRB_STRONG_SEXUAL_CONTENT;
            case 24:
                return ESRB_SUGGESTIVE_THEMES;
            case 25:
                return ESRB_TOBACCO_REFERENCE;
            case 26:
                return ESRB_USE_OF_ALCOHOL;
            case 27:
                return ESRB_USE_OF_DRUGS;
            case 28:
                return ESRB_USE_OF_TOBACCO;
            case 29:
                return ESRB_VIOLENCE;
            case 30:
                return ESRB_VIOLENT_REFERENCES;
            case 31:
                return ESRB_ANIMATED_VIOLENCE;
            case 32:
                return ESRB_MILD_LANGUAGE;
            case 33:
                return ESRB_MILD_VIOLENCE;
            case 34:
                return ESRB_USE_OF_DRUGS_AND_ALCOHOL;
            case 35:
                return ESRB_DRUG_AND_ALCOHOL_REFERENCE;
            case 36:
                return ESRB_MILD_SUGGESTIVE_THEMES;
            case 37:
                return ESRB_MILD_CARTOON_VIOLENCE;
            case 38:
                return ESRB_MILD_BLOOD;
            case 39:
                return ESRB_REALISTIC_BLOOD_AND_GORE;
            case 40:
                return ESRB_REALISTIC_VIOLENCE;
            case 41:
                return ESRB_ALCOHOL_AND_TOBACCO_REFERENCE;
            case 42:
                return ESRB_MATURE_SEXUAL_THEMES;
            case 43:
                return ESRB_MILD_ANIMATED_VIOLENCE;
            case 44:
                return ESRB_MILD_SEXUAL_THEMES;
            case 45:
                return ESRB_USE_OF_ALCOHOL_AND_TOBACCO;
            case 46:
                return ESRB_ANIMATED_BLOOD_AND_GORE;
            case 47:
                return ESRB_MILD_FANTASY_VIOLENCE;
            case 48:
                return ESRB_MILD_LYRICS;
            case 49:
                return ESRB_REALISTIC_BLOOD;
            case 50:
                return PEGI_VIOLENCE;
            case 51:
                return PEGI_SEX;
            case 52:
                return PEGI_DRUGS;
            case 53:
                return PEGI_FEAR;
            case 54:
                return PEGI_DISCRIMINATION;
            case 55:
                return PEGI_BAD_LANGUAGE;
            case 56:
                return PEGI_GAMBLING;
            case 57:
                return PEGI_ONLINE_GAMEPLAY;
            case 58:
                return PEGI_IN_GAME_PURCHASES;
            case 59:
                return CERO_LOVE;
            case 60:
                return CERO_SEXUAL_CONTENT;
            case 61:
                return CERO_VIOLENCE;
            case 62:
                return CERO_HORROR;
            case 63:
                return CERO_DRINKING_SMOKING;
            case 64:
                return CERO_GAMBLING;
            case 65:
                return CERO_CRIME;
            case 66:
                return CERO_CONTROLLED_SUBSTANCES;
            case 67:
                return CERO_LANGUAGES_AND_OTHERS;
            case 68:
                return GRAC_SEXUALITY;
            case 69:
                return GRAC_VIOLENCE;
            case 70:
                return GRAC_FEAR_HORROR_THREATENING;
            case 71:
                return GRAC_LANGUAGE;
            case 72:
                return GRAC_ALCOHOL_TOBACCO_DRUG;
            case 73:
                return GRAC_CRIME_ANTI_SOCIAL;
            case 74:
                return GRAC_GAMBLING;
            case 75:
                return CLASS_IND_VIOLENCIA;
            case 76:
                return CLASS_IND_VIOLENCIA_EXTREMA;
            case 77:
                return CLASS_IND_CONTEUDO_SEXUAL;
            case 78:
                return CLASS_IND_NUDEZ;
            case 79:
                return CLASS_IND_SEXO;
            case 80:
                return CLASS_IND_SEXO_EXPLICITO;
            case 81:
                return CLASS_IND_DROGAS;
            case 82:
                return CLASS_IND_DROGAS_LICITAS;
            case 83:
                return CLASS_IND_DROGAS_ILICITAS;
            case 84:
                return CLASS_IND_LINGUAGEM_IMPROPRIA;
            case 85:
                return CLASS_IND_ATOS_CRIMINOSOS;
            default:
                return null;
        }
    }

    public static Internal.EnumLiteMap<AgeRatingContentDescriptionCategoryEnum> internalGetValueMap() {
        return internalValueMap;
    }

    /* JADX INFO: renamed from: proto.AgeRatingContentDescriptionCategoryEnum$1, reason: invalid class name */
    class AnonymousClass1 implements Internal.EnumLiteMap<AgeRatingContentDescriptionCategoryEnum> {
        AnonymousClass1() {
        }

        @Override // com.google.protobuf.Internal.EnumLiteMap
        public AgeRatingContentDescriptionCategoryEnum findValueByNumber(int i) {
            return AgeRatingContentDescriptionCategoryEnum.forNumber(i);
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
        return Igdbproto.getDescriptor().getEnumTypes().get(2);
    }

    public static AgeRatingContentDescriptionCategoryEnum valueOf(Descriptors.EnumValueDescriptor enumValueDescriptor) {
        if (enumValueDescriptor.getType() != getDescriptor()) {
            throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
        }
        if (enumValueDescriptor.getIndex() == -1) {
            return UNRECOGNIZED;
        }
        return VALUES[enumValueDescriptor.getIndex()];
    }

    AgeRatingContentDescriptionCategoryEnum(int i) {
        this.value = i;
    }
}
