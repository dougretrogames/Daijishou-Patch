package com.magneticchen.daijishou.dialog_fragments;

import com.magneticchen.daijishou.repositories.RetroAchievementsRepository;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: compiled from: RetroAchievementsGameDialogFragment.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/magneticchen/daijishou/repositories/RetroAchievementsRepository;", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
final class RetroAchievementsGameDialogFragment$retroAchievementsRepository$2 extends Lambda<RetroAchievementsRepository> implements Function0<RetroAchievementsRepository> {
    final /* synthetic */ RetroAchievementsGameDialogFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    RetroAchievementsGameDialogFragment$retroAchievementsRepository$2(RetroAchievementsGameDialogFragment retroAchievementsGameDialogFragment) {
        super(0);
        this.this$0 = retroAchievementsGameDialogFragment;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final RetroAchievementsRepository invoke() {
        return this.this$0.getRetroAchievementsManager().getRetroAchievementsRepository();
    }
}
