package com.magneticchen.daijishou.abstract_fragment_classes;

import android.graphics.Bitmap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: compiled from: PlayableItemCollectionDialogFragment.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "bitmap", "Landroid/graphics/Bitmap;", "isCached", "", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
final class PlayableItemCollectionDialogFragment$GridRecyclerViewAdapter$ViewHolder$onBind$2 extends Lambda<Unit> implements Function2<Bitmap, Boolean, Unit> {
    final /* synthetic */ PlayableItemCollectionDialogFragment.GridRecyclerViewAdapter.ViewHolder this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    PlayableItemCollectionDialogFragment$GridRecyclerViewAdapter$ViewHolder$onBind$2(PlayableItemCollectionDialogFragment.GridRecyclerViewAdapter.ViewHolder viewHolder) {
        super(2);
        this.this$0 = viewHolder;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(Bitmap bitmap, Boolean bool) {
        invoke(bitmap, bool.booleanValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Bitmap bitmap, boolean z) {
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        this.this$0.placeholder.setVisibility(8);
        this.this$0.platformTextView.setVisibility(8);
        this.this$0.imageView.setImageBitmap(bitmap);
    }
}
