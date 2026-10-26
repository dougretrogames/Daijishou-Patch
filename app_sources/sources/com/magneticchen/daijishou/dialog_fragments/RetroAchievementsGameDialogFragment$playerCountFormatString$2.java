package com.magneticchen.daijishou.dialog_fragments;

import com.magneticchen.daijishou.R;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* INFO: compiled from: RetroAchievementsGameDialogFragment.kt */
/* INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
final class RetroAchievementsGameDialogFragment$playerCountFormatString$2 extends Lambda<String> implements Function0<String> {
    final /* synthetic */ RetroAchievementsGameDialogFragment this$0;

    /* WARN: 'super' call moved to the top of the method (can break code semantics) */
    RetroAchievementsGameDialogFragment$playerCountFormatString$2(RetroAchievementsGameDialogFragment retroAchievementsGameDialogFragment) {
        super(0);
        this.this$0 = retroAchievementsGameDialogFragment;
    }

    @Override // kotlin.jvm.functions.Function0
    public final String invoke() {
        return this.this$0.getString(R.string.achievement_player_count_format);
    }
}
