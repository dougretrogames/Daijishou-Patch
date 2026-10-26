package com.magneticchen.daijishou.dialog_fragments;

import android.graphics.drawable.Drawable;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.magneticchen.daijishou.retro_achievements.retro_achievements_db.RetroAchievementsAchievementRecordEntity;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* INFO: compiled from: RetroAchievementsGameDialogFragment.kt */
/* INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0012\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u0002\u0018\u00010\u00012\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "Lcom/bumptech/glide/RequestBuilder;", "Landroid/graphics/drawable/Drawable;", "kotlin.jvm.PlatformType", "item", "Lcom/magneticchen/daijishou/retro_achievements/retro_achievements_db/RetroAchievementsAchievementRecordEntity;", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
final class RetroAchievementsGameDialogFragment$AchievementGridAdapter$getGlidePreloadRequestBuilder$1 extends Lambda<RequestBuilder<Drawable>> implements Function1<RetroAchievementsAchievementRecordEntity, RequestBuilder<Drawable>> {
    final /* synthetic */ RetroAchievementsGameDialogFragment this$0;

    /* WARN: 'super' call moved to the top of the method (can break code semantics) */
    RetroAchievementsGameDialogFragment$AchievementGridAdapter$getGlidePreloadRequestBuilder$1(RetroAchievementsGameDialogFragment retroAchievementsGameDialogFragment) {
        super(1);
        this.this$0 = retroAchievementsGameDialogFragment;
    }

    @Override // kotlin.jvm.functions.Function1
    public final RequestBuilder<Drawable> invoke(RetroAchievementsAchievementRecordEntity item) {
        Intrinsics.checkNotNullParameter(item, "item");
        if (item.getImageUrl() == null) {
            return null;
        }
        return Glide.with(this.this$0).load((Object) item.getImageUrl()).transition(DrawableTransitionOptions.withCrossFade());
    }
}
