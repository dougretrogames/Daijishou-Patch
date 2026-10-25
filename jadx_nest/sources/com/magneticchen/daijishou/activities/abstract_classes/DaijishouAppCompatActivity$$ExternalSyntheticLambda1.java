package com.magneticchen.daijishou.activities.abstract_classes;

import android.content.SharedPreferences;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class DaijishouAppCompatActivity$$ExternalSyntheticLambda1 implements SharedPreferences.OnSharedPreferenceChangeListener {
    public final /* synthetic */ DaijishouAppCompatActivity f$0;

    public /* synthetic */ DaijishouAppCompatActivity$$ExternalSyntheticLambda1(DaijishouAppCompatActivity daijishouAppCompatActivity) {
        this.f$0 = daijishouAppCompatActivity;
    }

    @Override // android.content.SharedPreferences.OnSharedPreferenceChangeListener
    public final void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
        try {
            DaijishouAppCompatActivity.changeDarkModeListener$lambda$0(this.f$0, sharedPreferences, str);
        } catch (Throwable th) {
            throw com.magneticchen.daijishou.support.DaijishouSupport.sneakyThrow(th);
        }
    }
}
