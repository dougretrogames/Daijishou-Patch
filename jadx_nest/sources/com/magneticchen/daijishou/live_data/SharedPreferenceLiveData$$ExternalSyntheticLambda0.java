package com.magneticchen.daijishou.live_data;

import android.content.SharedPreferences;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class SharedPreferenceLiveData$$ExternalSyntheticLambda0 implements SharedPreferences.OnSharedPreferenceChangeListener {
    public final /* synthetic */ SharedPreferenceLiveData f$0;

    public /* synthetic */ SharedPreferenceLiveData$$ExternalSyntheticLambda0(SharedPreferenceLiveData sharedPreferenceLiveData) {
        this.f$0 = sharedPreferenceLiveData;
    }

    @Override // android.content.SharedPreferences.OnSharedPreferenceChangeListener
    public final void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
        try {
            SharedPreferenceLiveData.preferenceChangeListener$lambda$0(this.f$0, sharedPreferences, str);
        } catch (Throwable th) {
            throw com.magneticchen.daijishou.support.DaijishouSupport.sneakyThrow(th);
        }
    }
}
