package com.magneticchen.daijishou.application_data;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* INFO: compiled from: Constants.kt */
/* INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0017\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/magneticchen/daijishou/application_data/LongPreference;", "", "key", "", "defaultValue", "", "(Ljava/lang/String;ILjava/lang/String;J)V", "getDefaultValue", "()J", "getKey", "()Ljava/lang/String;", "LIBRARY_SELECTED_PLATFORM_ID", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public enum LongPreference {
    LIBRARY_SELECTED_PLATFORM_ID("selected_platform_id", -2);

    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());
    private final long defaultValue;
    private final String key;

    public static EnumEntries<LongPreference> getEntries() {
        return $ENTRIES;
    }

    LongPreference(String str, long j) {
        this.key = str;
        this.defaultValue = j;
    }

    public final long getDefaultValue() {
        return this.defaultValue;
    }

    public final String getKey() {
        return this.key;
    }
}
