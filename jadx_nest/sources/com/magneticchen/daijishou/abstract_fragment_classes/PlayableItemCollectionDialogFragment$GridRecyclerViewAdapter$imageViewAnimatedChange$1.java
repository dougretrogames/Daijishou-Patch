package com.magneticchen.daijishou.abstract_fragment_classes;

import android.graphics.Bitmap;
import android.view.animation.Animation;
import android.widget.ImageView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* INFO: compiled from: PlayableItemCollectionDialogFragment.kt */
/* INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\b"}, d2 = {"com/magneticchen/daijishou/abstract_fragment_classes/PlayableItemCollectionDialogFragment$GridRecyclerViewAdapter$imageViewAnimatedChange$1", "Landroid/view/animation/Animation$AnimationListener;", "onAnimationEnd", "", "animation", "Landroid/view/animation/Animation;", "onAnimationRepeat", "onAnimationStart", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class PlayableItemCollectionDialogFragment$GridRecyclerViewAdapter$imageViewAnimatedChange$1 implements Animation.AnimationListener {
    final /* synthetic */ Animation $animIn;
    final /* synthetic */ Bitmap $bitmap;
    final /* synthetic */ ImageView $v;

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
        Intrinsics.checkNotNullParameter(animation, "animation");
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
        Intrinsics.checkNotNullParameter(animation, "animation");
    }

    PlayableItemCollectionDialogFragment$GridRecyclerViewAdapter$imageViewAnimatedChange$1(ImageView imageView, Bitmap bitmap, Animation animation) {
        this.$v = imageView;
        this.$bitmap = bitmap;
        this.$animIn = animation;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        Intrinsics.checkNotNullParameter(animation, "animation");
        this.$v.setImageBitmap(this.$bitmap);
        this.$animIn.setAnimationListener(new PlayableItemCollectionDialogFragment$GridRecyclerViewAdapter$imageViewAnimatedChange$1$onAnimationEnd$1());
        this.$v.startAnimation(this.$animIn);
    }
}
