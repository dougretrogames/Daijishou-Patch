package com.magneticchen.daijishou.data;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: compiled from: Constants.kt */
/* JADX INFO: loaded from: C:\Users\dfukuoka\Downloads\Daijishou\Daijishou\build_tmp\dex181_classes4.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0017\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0019\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007j\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019¨\u0006\u001a"}, d2 = {"Lcom/magneticchen/daijishou/data/StringPreference;", "", "key", "", "defaultValue", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V", "getDefaultValue", "()Ljava/lang/String;", "getKey", "SCALE_UI", "SELECTED_PAGE_ID", "HOME_PAGE_ID", "USE_DARK_THEME", "THEME_ID", "CATEGORY_WIDGET_NAV_ASPECT_RATIO", "INDEX_URI", "LOGGER_DIALOG_COMPONENT_FILTER_STATUS", "LIBRARY_COLLECTION_VIEW_MODE", "SELECTED_PLATFORM_WALLPAPERS_PACK_URL_STRING", "SELECTED_PLATFORM_THUMBNAILS_PACK_URL_STRING", "PREVIOUS_PLATFORMS_INDEX_JSON", "APP_STATE", "SYNC_ENTIRELY_ON_START_HINT", "SYNC_ENTIRELY_ON_START_CANCEL_HINT", "UPDATE_EVERY_PLATFORM_ON_START_HINT", "UPDATE_EVERY_PLATFORM_ON_START_CANCEL_HINT", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public enum StringPreference {
    SCALE_UI("scale_ui", "1"),
    SELECTED_PAGE_ID("selected_page_id", "widgets"),
    HOME_PAGE_ID("home_page_id", "widgets"),
    USE_DARK_THEME("use_dark_theme", "0"),
    THEME_ID("theme_id", Constants.defaultThemeId),
    CATEGORY_WIDGET_NAV_ASPECT_RATIO("category_widget_nav_aspect_ratio", Constants.defaultThumbnailDimensionRatio),
    INDEX_URI("index_uri", Constants.platformsIndexUri),
    LOGGER_DIALOG_COMPONENT_FILTER_STATUS("logger_dialog_component_filter_status", ""),
    LIBRARY_COLLECTION_VIEW_MODE("library_collection_view_mode", "0"),
    SELECTED_PLATFORM_WALLPAPERS_PACK_URL_STRING("selected_platform_wallpapers_pack_url_string", Constants.defaultPlatformWallpapersPackUrlString),
    SELECTED_PLATFORM_THUMBNAILS_PACK_URL_STRING("selected_platform_thumbnails_pack_url_string", ""),
    PREVIOUS_PLATFORMS_INDEX_JSON("previous_platforms_index_json", null),
    APP_STATE("apps_state", null),
    SYNC_ENTIRELY_ON_START_HINT("sync_entirely_on_start_hint", null),
    SYNC_ENTIRELY_ON_START_CANCEL_HINT("sync_entirely_on_start_cancel_hint", null),
    UPDATE_EVERY_PLATFORM_ON_START_HINT("update_every_platform_on_start_hint", null),
    UPDATE_EVERY_PLATFORM_ON_START_CANCEL_HINT("update_every_platform_on_start_cancel_hint", null);

    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());
    private final String defaultValue;
    private final String key;

    public static EnumEntries<StringPreference> getEntries() {
        return $ENTRIES;
    }

    StringPreference(String str, String str2) {
        this.key = str;
        this.defaultValue = str2;
    }

    public final String getDefaultValue() {
        return this.defaultValue;
    }

    public final String getKey() {
        return this.key;
    }
}
