package com.magneticchen.daijishou.live_data;

import android.content.SharedPreferences;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* INFO: compiled from: SharedPreferenceLiveData.kt */
/* INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\"\n\u0000\u001a \u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0002\u001a \u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0001*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\b\u001a \u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0001*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\n\u001a \u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0001*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\f\u001a \u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00050\u0001*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005\u001a,\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u000f0\u0001*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u000f¨\u0006\u0010"}, d2 = {"booleanLiveData", "Lcom/magneticchen/daijishou/live_data/SharedPreferenceLiveData;", "", "Landroid/content/SharedPreferences;", "key", "", "defValue", "floatLiveData", "", "intLiveData", "", "longLiveData", "", "stringLiveData", "stringSetLiveData", "", "app_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
public final class SharedPreferenceLiveDataKt {
    public static final SharedPreferenceLiveData<Integer> intLiveData(SharedPreferences sharedPreferences, String key, int i) {
        Intrinsics.checkNotNullParameter(sharedPreferences, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        return new SharedPreferenceIntLiveData(sharedPreferences, key, i);
    }

    public static final SharedPreferenceLiveData<String> stringLiveData(SharedPreferences sharedPreferences, String key, String defValue) {
        Intrinsics.checkNotNullParameter(sharedPreferences, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(defValue, "defValue");
        return new SharedPreferenceStringLiveData(sharedPreferences, key, defValue);
    }

    public static final SharedPreferenceLiveData<Boolean> booleanLiveData(SharedPreferences sharedPreferences, String key, boolean z) {
        Intrinsics.checkNotNullParameter(sharedPreferences, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        return new SharedPreferenceBooleanLiveData(sharedPreferences, key, z);
    }

    public static final SharedPreferenceLiveData<Float> floatLiveData(SharedPreferences sharedPreferences, String key, float f) {
        Intrinsics.checkNotNullParameter(sharedPreferences, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        return new SharedPreferenceFloatLiveData(sharedPreferences, key, f);
    }

    public static final SharedPreferenceLiveData<Long> longLiveData(SharedPreferences sharedPreferences, String key, long j) {
        Intrinsics.checkNotNullParameter(sharedPreferences, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        return new SharedPreferenceLongLiveData(sharedPreferences, key, j);
    }

    public static final SharedPreferenceLiveData<Set<String>> stringSetLiveData(SharedPreferences sharedPreferences, String key, Set<String> defValue) {
        Intrinsics.checkNotNullParameter(sharedPreferences, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(defValue, "defValue");
        return (SharedPreferenceLiveData<Set<String>>) (SharedPreferenceLiveData) new SharedPreferenceStringSetLiveData(sharedPreferences, key, defValue);
    }
}
