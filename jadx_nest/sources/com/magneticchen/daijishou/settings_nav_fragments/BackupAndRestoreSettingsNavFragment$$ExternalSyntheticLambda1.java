package com.magneticchen.daijishou.settings_nav_fragments;

import androidx.preference.Preference;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class BackupAndRestoreSettingsNavFragment$$ExternalSyntheticLambda1 implements Preference.OnPreferenceClickListener {
    public final /* synthetic */ BackupAndRestoreSettingsNavFragment f$0;

    public /* synthetic */ BackupAndRestoreSettingsNavFragment$$ExternalSyntheticLambda1(BackupAndRestoreSettingsNavFragment backupAndRestoreSettingsNavFragment) {
        this.f$0 = backupAndRestoreSettingsNavFragment;
    }

    @Override // androidx.preference.Preference.OnPreferenceClickListener
    public final boolean onPreferenceClick(Preference preference) {
        return BackupAndRestoreSettingsNavFragment.onCreateView$lambda$1(this.f$0, preference);
    }
}
