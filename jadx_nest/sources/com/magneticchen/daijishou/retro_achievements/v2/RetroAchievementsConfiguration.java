package com.magneticchen.daijishou.retro_achievements.v2;

import com.magneticchen.daijishou.application_data.Constants;
import java.time.format.DateTimeFormatter;
import kotlin.Metadata;
import kotlin.text.Regex;

/* INFO: compiled from: RetroAchievementsConfiguration.kt */
/* INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u0019\u0010\u0012\u001a\n \u0014*\u0004\u0018\u00010\u00130\u0013¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0017\u001a\u00020\u0018¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001a¨\u0006\u001b"}, d2 = {"Lcom/magneticchen/daijishou/retro_achievements/v2/RetroAchievementsConfiguration;", "", "()V", "AWARD_EXPIRE_DURATION_MS", "", "BASE_URL", "", "CREDENTIALS_RETRIES_COOL_DOWN", "ENFORCE_CREDENTIALS", "", "GAME_RECORD_EXPIRE_DURATION_MS", "MAX_CREDENTIALS_RETRY_COUNT", "PLAYABLE_ITEM_ID_TO_GAME_ID_SURJECTION_EXPIRE_DURATION_MS", "USERNAME_PREFERENCE_STRING", "USER_ID_TRANSLATION_PREFERENCE_PREFIX", "USER_INDEPENDENT_GAME_RECORD_EXPIRE_DURATION_MS", "USER_PROFILE_EXPIRE_DURATION_MS", "WEB_API_KEY_PREFERENCE_STRING", "achievementEarnedTimestampFormatter", "Ljava/time/format/DateTimeFormatter;", "kotlin.jvm.PlatformType", "getAchievementEarnedTimestampFormatter", "()Ljava/time/format/DateTimeFormatter;", "genericNameRegex", "Lkotlin/text/Regex;", "getGenericNameRegex", "()Lkotlin/text/Regex;", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class RetroAchievementsConfiguration {
    public static final int AWARD_EXPIRE_DURATION_MS = 480000;
    public static final String BASE_URL = "https://retroachievements.org";
    public static final int CREDENTIALS_RETRIES_COOL_DOWN = 240000;
    public static final boolean ENFORCE_CREDENTIALS = true;
    public static final int GAME_RECORD_EXPIRE_DURATION_MS = 480000;
    public static final int MAX_CREDENTIALS_RETRY_COUNT = 3;
    public static final int PLAYABLE_ITEM_ID_TO_GAME_ID_SURJECTION_EXPIRE_DURATION_MS = 604800000;
    public static final String USERNAME_PREFERENCE_STRING = "username";
    public static final String USER_ID_TRANSLATION_PREFERENCE_PREFIX = "user_id_translation_";
    public static final int USER_INDEPENDENT_GAME_RECORD_EXPIRE_DURATION_MS = 691200000;
    public static final int USER_PROFILE_EXPIRE_DURATION_MS = 480000;
    public static final String WEB_API_KEY_PREFERENCE_STRING = "web_api_key";
    public static final RetroAchievementsConfiguration INSTANCE = new RetroAchievementsConfiguration();
    private static DateTimeFormatter achievementEarnedTimestampFormatter;
    private static final Regex genericNameRegex = Constants.INSTANCE.getToGenericNameRegex();

    private RetroAchievementsConfiguration() {
    }

    public final DateTimeFormatter getAchievementEarnedTimestampFormatter() {
        if (achievementEarnedTimestampFormatter == null && android.os.Build.VERSION.SDK_INT >= 26) {
            achievementEarnedTimestampFormatter = DateTimeFormatter.ofPattern("yyyy[-MM-dd[' 'HH:mm:ss]]");
        }
        return achievementEarnedTimestampFormatter;
    }

    public final Regex getGenericNameRegex() {
        return genericNameRegex;
    }
}
