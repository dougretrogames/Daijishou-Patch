package com.magneticchen.daijishou.settings_nav_fragments;

import androidx.preference.Preference;
import com.magneticchen.daijishou.DaijishouApplication;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class BackupAndRestoreSettingsNavFragment$$ExternalSyntheticLambda4 implements Preference.OnPreferenceClickListener {
    public final /* synthetic */ BackupAndRestoreSettingsNavFragment f$0;
    public final /* synthetic */ DaijishouApplication.WrappedLogger f$1;

    public /* synthetic */ BackupAndRestoreSettingsNavFragment$$ExternalSyntheticLambda4(BackupAndRestoreSettingsNavFragment backupAndRestoreSettingsNavFragment, DaijishouApplication.WrappedLogger wrappedLogger) {
        this.f$0 = backupAndRestoreSettingsNavFragment;
        this.f$1 = wrappedLogger;
    }

    @Override // androidx.preference.Preference.OnPreferenceClickListener
    public final boolean onPreferenceClick(Preference preference) {
        return BackupAndRestoreSettingsNavFragment.onCreateView$lambda$4(this.f$0, this.f$1, preference);
    }
}
