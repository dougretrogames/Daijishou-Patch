package com.magneticchen.daijishou.application_data;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: compiled from: Constants.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b(\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0017\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001fj\u0002\b j\u0002\b!j\u0002\b\"j\u0002\b#j\u0002\b$j\u0002\b%j\u0002\b&j\u0002\b'j\u0002\b(j\u0002\b)j\u0002\b*j\u0002\b+j\u0002\b,¨\u0006-"}, d2 = {"Lcom/magneticchen/daijishou/application_data/BooleanPreference;", "", "key", "", "defaultValue", "", "(Ljava/lang/String;ILjava/lang/String;Z)V", "getDefaultValue", "()Z", "getKey", "()Ljava/lang/String;", "MERGE_PLAYABLE_ITEMS", "USE_DEBUG_MODE", "KIOSK_MODE", "PRETTIFY_TITLES", "UNLOCK_EXPERIMENTAL", "DISABLE_B_BUTTON_SOUND", "FORCE_SET_WALLPAPER_FOR_ALL", "USE_AUTO_THEME_COLOR", "USE_WIDGET_PAGE", "ALWAYS_SHOW_SYNC_ICON", "USE_NSFW", "HAS_STORE_REVIEWED", "EXIT_APP", "DETAIL_VIEW_ON_CLICK", "CLEAR_DISJOINTED_ITEMS_ON_SYNC", "UPDATE_PLATFORMS_AUTOMATICALLY", "SHOW_SIMILAR_ITEMS", "SYNC_ENTIRELY_ON_START", "UPDATE_EVERY_PLATFORM_ON_START", "PLAY_PREVIEW_VIDEO", "ENFORCE_PLATFORM_CARD_ASPECT_RATIO", "SHOW_GENRES_IN_PLATFORM_GRID_VIEW", "USE_AGGRESSIVE_SCRAPING", "AUTOMATICALLY_BACKUP_TO_GOOGLE_DRIVE", "USE_LIGHTWEIGHT_BACKUP", "DO_NOT_SCRAP_PREVIEW_MEDIA", "MAKE_PREVIEW_VIDEO_SOUNDS", "SHOW_RECENT_INDICATORS", "DISPLAY_SHORTNAME_IN_PLATFORMS_PAGE_SUBTITLE", "DISABLE_PLAYER_KILL_PACKAGE_PROCESSES_WARNING", "USE_PURE_DARK_THEME", "HIDE_GAME_TITLES", "SQUARE_PLAYABLE_ITEM_ART", "ENABLE_NON_HOME_ACTIVITY", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public enum BooleanPreference {
    MERGE_PLAYABLE_ITEMS("merge_playable_items", true),
    USE_DEBUG_MODE("use_debug_mode", false),
    KIOSK_MODE("kiosk_mode", false),
    PRETTIFY_TITLES("prettify_titles", true),
    UNLOCK_EXPERIMENTAL("unlock_experimental", false),
    DISABLE_B_BUTTON_SOUND("disable_b_button_sound", true),
    FORCE_SET_WALLPAPER_FOR_ALL("force_set_wallpaper_for_all", false),
    USE_AUTO_THEME_COLOR("use_auto_theme_color", true),
    USE_WIDGET_PAGE("use_widgets_page", true),
    ALWAYS_SHOW_SYNC_ICON("always_show_sync_icon", false),
    USE_NSFW("use_nsfw", false),
    HAS_STORE_REVIEWED("has_store_reviewed", false),
    EXIT_APP("exit_app", false),
    DETAIL_VIEW_ON_CLICK("detail_view_on_click", true),
    CLEAR_DISJOINTED_ITEMS_ON_SYNC("clear_disjointed_items_on_sync", false),
    UPDATE_PLATFORMS_AUTOMATICALLY("update_platforms_automatically", true),
    SHOW_SIMILAR_ITEMS("show_similar_items", true),
    SYNC_ENTIRELY_ON_START("sync_entirely_on_start", false),
    UPDATE_EVERY_PLATFORM_ON_START("update_every_platform_on_start", false),
    PLAY_PREVIEW_VIDEO("play_preview_video", true),
    ENFORCE_PLATFORM_CARD_ASPECT_RATIO("enforce_platform_card_aspect_ratio", true),
    SHOW_GENRES_IN_PLATFORM_GRID_VIEW("show_genres_in_platform_grid_view", true),
    USE_AGGRESSIVE_SCRAPING("use_aggressive_scraping", false),
    AUTOMATICALLY_BACKUP_TO_GOOGLE_DRIVE("automatically_backup_to_google_drive", false),
    USE_LIGHTWEIGHT_BACKUP("use_lightweight_backup", false),
    DO_NOT_SCRAP_PREVIEW_MEDIA("do_not_scrap_preview_media", false),
    MAKE_PREVIEW_VIDEO_SOUNDS("make_preview_video_sounds", true),
    SHOW_RECENT_INDICATORS("show_recent_indicators", true),
    DISPLAY_SHORTNAME_IN_PLATFORMS_PAGE_SUBTITLE("display_shortname_in_platforms_page_subtitle", false),
    DISABLE_PLAYER_KILL_PACKAGE_PROCESSES_WARNING("disable_player_kill_package_processes_warning", false),
    USE_PURE_DARK_THEME("use_pure_dark_theme", false),
    HIDE_GAME_TITLES("hide_game_titles", false),
    SQUARE_PLAYABLE_ITEM_ART("square_playable_item_art", false),
    ENABLE_NON_HOME_ACTIVITY("enable_non_home_activity", false);

    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());
    private final boolean defaultValue;
    private final String key;

    public static EnumEntries<BooleanPreference> getEntries() {
        return $ENTRIES;
    }

    BooleanPreference(String str, boolean z) {
        this.key = str;
        this.defaultValue = z;
    }

    public final boolean getDefaultValue() {
        return this.defaultValue;
    }

    public final String getKey() {
        return this.key;
    }
}
