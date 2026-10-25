package com.magneticchen.daijishou.live_data;

import android.content.SharedPreferences;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SharedPreferenceLiveData.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002¢\u0006\u0002\u0010\u0007J\u001c\u0010\b\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\t"}, d2 = {"Lcom/magneticchen/daijishou/live_data/SharedPreferenceStringLiveData;", "Lcom/magneticchen/daijishou/live_data/SharedPreferenceLiveData;", "", "sharedPrefs", "Landroid/content/SharedPreferences;", "key", "defValue", "(Landroid/content/SharedPreferences;Ljava/lang/String;Ljava/lang/String;)V", "getValueFromPreferences", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class SharedPreferenceStringLiveData extends SharedPreferenceLiveData<String> {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SharedPreferenceStringLiveData(SharedPreferences sharedPrefs, String key, String str) {
        super(sharedPrefs, key, str);
        Intrinsics.checkNotNullParameter(sharedPrefs, "sharedPrefs");
        Intrinsics.checkNotNullParameter(key, "key");
    }

    @Override // com.magneticchen.daijishou.live_data.SharedPreferenceLiveData
    public String getValueFromPreferences(String key, String defValue) {
        Intrinsics.checkNotNullParameter(key, "key");
        return getSharedPrefs().getString(key, defValue);
    }
}
