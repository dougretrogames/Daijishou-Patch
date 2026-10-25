package com.magneticchen.daijishou.settings_nav_fragments;

import com.magneticchen.daijishou.R;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: compiled from: BackupAndRestoreSettingsNavFragment.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
final class BackupAndRestoreSettingsNavFragment$googleDriveOperationLockedCanceledString$2 extends Lambda<String> implements Function0<String> {
    final /* synthetic */ BackupAndRestoreSettingsNavFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    BackupAndRestoreSettingsNavFragment$googleDriveOperationLockedCanceledString$2(BackupAndRestoreSettingsNavFragment backupAndRestoreSettingsNavFragment) {
        super(0);
        this.this$0 = backupAndRestoreSettingsNavFragment;
    }

    @Override // kotlin.jvm.functions.Function0
    public final String invoke() {
        return this.this$0.requireActivity().getString(R.string.google_drive_operation_locked_canceled);
    }
}
