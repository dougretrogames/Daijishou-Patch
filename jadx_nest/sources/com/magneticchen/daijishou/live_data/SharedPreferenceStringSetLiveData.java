package com.magneticchen.daijishou.live_data;

import android.content.SharedPreferences;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SharedPreferenceLiveData.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001B#\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0002\u0010\bJ&\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002H\u0016¨\u0006\n"}, d2 = {"Lcom/magneticchen/daijishou/live_data/SharedPreferenceStringSetLiveData;", "Lcom/magneticchen/daijishou/live_data/SharedPreferenceLiveData;", "", "", "sharedPrefs", "Landroid/content/SharedPreferences;", "key", "defValue", "(Landroid/content/SharedPreferences;Ljava/lang/String;Ljava/util/Set;)V", "getValueFromPreferences", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class SharedPreferenceStringSetLiveData extends SharedPreferenceLiveData<Set<? extends String>> {
    @Override // com.magneticchen.daijishou.live_data.SharedPreferenceLiveData
    public /* bridge */ /* synthetic */ Set<? extends String> getValueFromPreferences(String str, Set<? extends String> set) {
        return getValueFromPreferences2(str, (Set<String>) set);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SharedPreferenceStringSetLiveData(SharedPreferences sharedPrefs, String key, Set<String> defValue) {
        super(sharedPrefs, key, defValue);
        Intrinsics.checkNotNullParameter(sharedPrefs, "sharedPrefs");
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(defValue, "defValue");
    }

    /* JADX INFO: renamed from: getValueFromPreferences, reason: avoid collision after fix types in other method */
    public Set<String> getValueFromPreferences2(String key, Set<String> defValue) {
        Intrinsics.checkNotNullParameter(key, "key");
        Set<String> stringSet = getSharedPrefs().getStringSet(key, defValue);
        Intrinsics.checkNotNull(stringSet, "null cannot be cast to non-null type kotlin.collections.Set<kotlin.String>");
        return stringSet;
    }
}
