package com.magneticchen.daijishou.live_data;

import android.content.SharedPreferences;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* INFO: compiled from: SharedPreferenceLiveData.kt */
/* INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0002\u0010\bJ\u001f\u0010\t\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0002\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/magneticchen/daijishou/live_data/SharedPreferenceBooleanLiveData;", "Lcom/magneticchen/daijishou/live_data/SharedPreferenceLiveData;", "", "sharedPrefs", "Landroid/content/SharedPreferences;", "key", "", "defValue", "(Landroid/content/SharedPreferences;Ljava/lang/String;Z)V", "getValueFromPreferences", "(Ljava/lang/String;Ljava/lang/Boolean;)Ljava/lang/Boolean;", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class SharedPreferenceBooleanLiveData extends SharedPreferenceLiveData<Boolean> {
    /* WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SharedPreferenceBooleanLiveData(SharedPreferences sharedPrefs, String key, boolean z) {
        super(sharedPrefs, key, Boolean.valueOf(z));
        Intrinsics.checkNotNullParameter(sharedPrefs, "sharedPrefs");
        Intrinsics.checkNotNullParameter(key, "key");
    }

    @Override // com.magneticchen.daijishou.live_data.SharedPreferenceLiveData
    public Boolean getValueFromPreferences(String key, Boolean defValue) {
        Intrinsics.checkNotNullParameter(key, "key");
        SharedPreferences sharedPrefs = getSharedPrefs();
        Intrinsics.checkNotNull(defValue);
        return Boolean.valueOf(sharedPrefs.getBoolean(key, defValue.booleanValue()));
    }
}
