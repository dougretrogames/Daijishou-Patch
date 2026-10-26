package com.magneticchen.daijishou.dialog_fragments;

import com.magneticchen.daijishou.R;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* INFO: compiled from: PlayableItemDetailDialogFragment.kt */
/* INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
final class PlayableItemDetailDialogFragment$retroAchievementsGameMoreThen64PlayersString$2 extends Lambda<String> implements Function0<String> {
    final /* synthetic */ PlayableItemDetailDialogFragment this$0;

    /* WARN: 'super' call moved to the top of the method (can break code semantics) */
    PlayableItemDetailDialogFragment$retroAchievementsGameMoreThen64PlayersString$2(PlayableItemDetailDialogFragment playableItemDetailDialogFragment) {
        super(0);
        this.this$0 = playableItemDetailDialogFragment;
    }

    @Override // kotlin.jvm.functions.Function0
    public final String invoke() {
        return this.this$0.getString(R.string.retro_achievements_game_more_than_64_distinct_players);
    }
}
