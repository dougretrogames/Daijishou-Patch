package com.magneticchen.daijishou.dialog_fragments;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.google.android.material.imageview.ShapeableImageView;
import com.magneticchen.daijishou.R;
import com.magneticchen.daijishou.daijishou_library_db.portables.PlatformThumbnailsPacksIndexJson;
import com.magneticchen.daijishou.daijishou_library_db.portables.PlatformThumbnailsPacksIndexPlatformThumbnailPackListItemJson;
import com.magneticchen.daijishou.daijishou_recycler_view.DaijishouRecyclerView;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* INFO: compiled from: DownloadPlatformThumbnailsPackListDialogFragment.kt */
/* INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003*\u0002\u0000\u0004\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\nJ!\u0010\u0003\u001a\u00060\u0004R\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016¢\u0006\u0002\u0010\t¨\u0006\u000b"}, d2 = {"com/magneticchen/daijishou/dialog_fragments/DownloadPlatformThumbnailsPackListDialogFragment$onCreateDialog$adapter$1", "Lcom/magneticchen/daijishou/daijishou_recycler_view/DaijishouRecyclerView$Adapter;", "Lcom/magneticchen/daijishou/daijishou_library_db/portables/PlatformThumbnailsPacksIndexPlatformThumbnailPackListItemJson;", "onCreateViewHolder", "com/magneticchen/daijishou/dialog_fragments/DownloadPlatformThumbnailsPackListDialogFragment$onCreateDialog$adapter$1.ViewHolder", "viewGroup", "Landroid/view/ViewGroup;", "viewType", "", "(Landroid/view/ViewGroup;I)Lcom/magneticchen/daijishou/dialog_fragments/DownloadPlatformThumbnailsPackListDialogFragment$onCreateDialog$adapter$1$ViewHolder;", "ViewHolder", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class DownloadPlatformThumbnailsPackListDialogFragment$onCreateDialog$adapter$1 extends DaijishouRecyclerView.Adapter<PlatformThumbnailsPacksIndexPlatformThumbnailPackListItemJson> {
    final /* synthetic */ DownloadPlatformThumbnailsPackListDialogFragment this$0;

    /* INFO: compiled from: DownloadPlatformThumbnailsPackListDialogFragment.kt */
    @Metadata(d1 = {"\u00009\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\u008a\u0004\u0018\u00002\f0\u0001R\b\u0012\u0004\u0012\u00020\u00030\u0002B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0003H\u0016R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u000f\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000e¨\u0006\u0016"}, d2 = {"com/magneticchen/daijishou/dialog_fragments/DownloadPlatformThumbnailsPackListDialogFragment$onCreateDialog$adapter$1.ViewHolder", "Lcom/magneticchen/daijishou/daijishou_recycler_view/DaijishouRecyclerView$Adapter$ViewHolder;", "Lcom/magneticchen/daijishou/daijishou_recycler_view/DaijishouRecyclerView$Adapter;", "Lcom/magneticchen/daijishou/daijishou_library_db/portables/PlatformThumbnailsPacksIndexPlatformThumbnailPackListItemJson;", "itemView", "Landroid/view/View;", "(Lcom/magneticchen/daijishou/dialog_fragments/DownloadPlatformThumbnailsPackListDialogFragment$onCreateDialog$adapter$1;Landroid/view/View;)V", "imageView", "Lcom/google/android/material/imageview/ShapeableImageView;", "getImageView", "()Lcom/google/android/material/imageview/ShapeableImageView;", "text1", "Landroid/widget/TextView;", "getText1", "()Landroid/widget/TextView;", "text2", "getText2", "onBind", "", "position", "", "item", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public final class ViewHolder extends DaijishouRecyclerView.Adapter<PlatformThumbnailsPacksIndexPlatformThumbnailPackListItemJson>.ViewHolder {
        private final ShapeableImageView imageView;
        private final TextView text1;
        private final TextView text2;
        final /* synthetic */ DownloadPlatformThumbnailsPackListDialogFragment$onCreateDialog$adapter$1 this$0;

        /* WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(DownloadPlatformThumbnailsPackListDialogFragment$onCreateDialog$adapter$1 downloadPlatformThumbnailsPackListDialogFragment$onCreateDialog$adapter$1, View itemView) {
            super(downloadPlatformThumbnailsPackListDialogFragment$onCreateDialog$adapter$1, itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            this.this$0 = downloadPlatformThumbnailsPackListDialogFragment$onCreateDialog$adapter$1;
            View viewFindViewById = itemView.findViewById(R.id.list_item_theme_pack_choice_title);
            Intrinsics.checkNotNull(viewFindViewById, "null cannot be cast to non-null type android.widget.TextView");
            this.text1 = (TextView) viewFindViewById;
            View viewFindViewById2 = itemView.findViewById(R.id.list_item_theme_pack_choice_subtitle);
            Intrinsics.checkNotNull(viewFindViewById2, "null cannot be cast to non-null type android.widget.TextView");
            this.text2 = (TextView) viewFindViewById2;
            View viewFindViewById3 = itemView.findViewById(R.id.list_item_theme_pack_choice_image_view);
            Intrinsics.checkNotNull(viewFindViewById3, "null cannot be cast to non-null type com.google.android.material.imageview.ShapeableImageView");
            this.imageView = (ShapeableImageView) viewFindViewById3;
        }

        public final TextView getText1() {
            return this.text1;
        }

        public final TextView getText2() {
            return this.text2;
        }

        public final ShapeableImageView getImageView() {
            return this.imageView;
        }

        @Override // com.magneticchen.daijishou.daijishou_recycler_view.DaijishouRecyclerView.Adapter.ViewHolder
        public void onBind(int position, PlatformThumbnailsPacksIndexPlatformThumbnailPackListItemJson item) {
            Intrinsics.checkNotNullParameter(item, "item");
            PlatformThumbnailsPacksIndexJson platformThumbnailsPacksIndexJson = this.this$0.this$0.platformThumbnailsPacksIndexJson;
            Intrinsics.checkNotNull(platformThumbnailsPacksIndexJson);
            Glide.with(this.this$0.this$0).load((Object) platformThumbnailsPacksIndexJson.getBaseUri() + item.getPlatformThumbnailsPackPreviewThumbnailPath()).transition(DrawableTransitionOptions.withCrossFade()).into(this.imageView);
            this.text1.setText(item.getPlatformThumbnailsPackName());
            TextView textView = this.text2;
            String string = this.this$0.this$0.getString(R.string.authors_format);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            String str = String.format(string, Arrays.copyOf(new Object[]{CollectionsKt.joinToString$default(item.getPlatformThumbnailsPackAuthors(), ", ", null, null, 0, null, null, 62, null)}, 1));
            Intrinsics.checkNotNullExpressionValue(str, "format(...)");
            textView.setText(str);
            this.text2.setAlpha(0.75f);
        }
    }

    /* WARN: 'super' call moved to the top of the method (can break code semantics) */
    DownloadPlatformThumbnailsPackListDialogFragment$onCreateDialog$adapter$1(DownloadPlatformThumbnailsPackListDialogFragment downloadPlatformThumbnailsPackListDialogFragment, List<PlatformThumbnailsPacksIndexPlatformThumbnailPackListItemJson> list) {
        super(list, false, false, 6, null);
        this.this$0 = downloadPlatformThumbnailsPackListDialogFragment;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        Intrinsics.checkNotNullParameter(viewGroup, "viewGroup");
        View viewInflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item_theme_pack_choice, viewGroup, false);
        Intrinsics.checkNotNull(viewInflate);
        return new ViewHolder(this, viewInflate);
    }
}
