package com.magneticchen.daijishou.application_data;

import com.magneticchen.daijishou.dialog_fragments.LoggerDialogFragment;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* INFO: compiled from: Constants.kt */
/* INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u001a\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0017\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001e¨\u0006\u001f"}, d2 = {"Lcom/magneticchen/daijishou/application_data/IntPreference;", "", "key", "", "defaultValue", "", "(Ljava/lang/String;ILjava/lang/String;I)V", "getDefaultValue", "()I", "getKey", "()Ljava/lang/String;", "BACKGROUND_MUSIC_HASH_CODE", "WALLPAPER_HASH_CODE", "WALLPAPER_COLOR_THEME", "WALLPAPER_COLOR_ICON_THEME", "WALLPAPER_COLOR_ON_THEME", "LOGGER_DIALOG_FILTER_STATUS", "APPS_ITEMS_MODE", "APPS_SORTING_MODE", "SEARCH_HOTKEY", "SWITCHING_PREVIOUS_HOTKEY", "SWITCHING_NEXT_HOTKEY", "FIRST_ADDITIONAL_HOTKEY", "SECOND_ADDITIONAL_HOTKEY", "LEFT_TAB_HOTKEY", "RIGHT_TAB_HOTKEY", "UPGRADED_VERSION", "PREVIOUS_VERSION", "CURRENT_VERSION", "RETRO_ACHIEVEMENTS_USER_PROFILE_VIEW_MODE", "WIDGET_GRID_LAST_FOCUSED_POSITION", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public enum IntPreference {
    BACKGROUND_MUSIC_HASH_CODE("background_music_hash_code", -1),
    WALLPAPER_HASH_CODE("wallpaper_hash_code", -1),
    WALLPAPER_COLOR_THEME("wallpaper_color_theme", -1),
    WALLPAPER_COLOR_ICON_THEME("wallpaper_color_icon_theme", -1),
    WALLPAPER_COLOR_ON_THEME("wallpaper_color_on_theme", -1),
    LOGGER_DIALOG_FILTER_STATUS("logger_dialog_filter_status", LoggerDialogFragment.INSTANCE.getNO_FILTER()),
    APPS_ITEMS_MODE("apps_items_mode", 0),
    APPS_SORTING_MODE("apps_sorting_mode", 0),
    SEARCH_HOTKEY("search_hotkey", 99),
    SWITCHING_PREVIOUS_HOTKEY("switching_previous_hotkey", 104),
    SWITCHING_NEXT_HOTKEY("switching_next_hotkey", 105),
    FIRST_ADDITIONAL_HOTKEY("first_additional_hotkey", 100),
    SECOND_ADDITIONAL_HOTKEY("second_additional_hotkey", -1),
    LEFT_TAB_HOTKEY("left_tab_hotkey", 102),
    RIGHT_TAB_HOTKEY("right_tab_hotkey", 103),
    UPGRADED_VERSION("upgraded_version", 416),
    PREVIOUS_VERSION("previous_version", 0),
    CURRENT_VERSION("current_version", 416),
    RETRO_ACHIEVEMENTS_USER_PROFILE_VIEW_MODE("retro_achievements_user_profile_view_mode", 0),
    WIDGET_GRID_LAST_FOCUSED_POSITION("widget_grid_last_focused_position", 0);

    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());
    private final int defaultValue;
    private final String key;

    public static EnumEntries<IntPreference> getEntries() {
        return $ENTRIES;
    }

    IntPreference(String str, int i) {
        this.key = str;
        this.defaultValue = i;
    }

    public final int getDefaultValue() {
        return this.defaultValue;
    }

    public final String getKey() {
        return this.key;
    }
}
