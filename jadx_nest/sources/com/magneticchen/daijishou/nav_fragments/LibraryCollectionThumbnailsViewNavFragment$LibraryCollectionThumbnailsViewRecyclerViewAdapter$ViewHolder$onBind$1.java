package com.magneticchen.daijishou.nav_fragments;

import android.graphics.Bitmap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: compiled from: LibraryCollectionThumbnailsViewNavFragment.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "bitmap", "Landroid/graphics/Bitmap;", "<anonymous parameter 1>", "", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
final class LibraryCollectionThumbnailsViewNavFragment$LibraryCollectionThumbnailsViewRecyclerViewAdapter$ViewHolder$onBind$1 extends Lambda<Unit> implements Function2<Bitmap, Boolean, Unit> {
    final /* synthetic */ LibraryCollectionThumbnailsViewNavFragment.LibraryCollectionThumbnailsViewRecyclerViewAdapter.ViewHolder this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    LibraryCollectionThumbnailsViewNavFragment$LibraryCollectionThumbnailsViewRecyclerViewAdapter$ViewHolder$onBind$1(LibraryCollectionThumbnailsViewNavFragment.LibraryCollectionThumbnailsViewRecyclerViewAdapter.ViewHolder viewHolder) {
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
        this.this$0.imageView.setImageBitmap(bitmap);
        this.this$0.iconImageView.setVisibility(8);
    }
}
