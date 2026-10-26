package com.magneticchen.daijishou.nav_fragments;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.magneticchen.daijishou.R;
import com.magneticchen.daijishou.daijishou_library_db.PlatformEntity;
import com.magneticchen.daijishou.daijishou_recycler_view.DaijishouRecyclerView;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* INFO: compiled from: LibraryCollectionWallpaperViewNavFragment.kt */
/* INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001dB\u001b\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0010H\u0016J\u001c\u0010\u0018\u001a\u00060\u0019R\u00020\u00002\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0010H\u0016R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0015\u0010\n\u001a\u00060\u000bR\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u000f\u001a\u00020\u00108\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/magneticchen/daijishou/nav_fragments/LibraryCollectionWallpaperViewRecyclerViewAdapter;", "Lcom/magneticchen/daijishou/daijishou_recycler_view/DaijishouRecyclerView$Adapter;", "Lcom/magneticchen/daijishou/daijishou_library_db/PlatformEntity;", "context", "Landroid/content/Context;", "itemList", "", "(Landroid/content/Context;Ljava/util/List;)V", "getContext", "()Landroid/content/Context;", "theme", "Landroid/content/res/Resources$Theme;", "Landroid/content/res/Resources;", "getTheme", "()Landroid/content/res/Resources$Theme;", "themeTextColor", "", "getThemeTextColor", "()I", "typedValue", "Landroid/util/TypedValue;", "getItemId", "", "position", "onCreateViewHolder", "Lcom/magneticchen/daijishou/nav_fragments/LibraryCollectionWallpaperViewRecyclerViewAdapter$ViewHolder;", "viewGroup", "Landroid/view/ViewGroup;", "viewType", "ViewHolder", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class LibraryCollectionWallpaperViewRecyclerViewAdapter extends DaijishouRecyclerView.Adapter<PlatformEntity> {
    private final Context context;
    private final Resources.Theme theme;
    private final int themeTextColor;
    private final TypedValue typedValue;

    public final Context getContext() {
        return this.context;
    }

    /* WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LibraryCollectionWallpaperViewRecyclerViewAdapter(Context context, List<PlatformEntity> itemList) {
        super(itemList, true, false, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(itemList, "itemList");
        this.context = context;
        setKeepSelectedItemFocusedInSelectableMode(false);
        TypedValue typedValue = new TypedValue();
        this.typedValue = typedValue;
        Resources.Theme theme = context.getTheme();
        Intrinsics.checkNotNullExpressionValue(theme, "getTheme(...)");
        this.theme = theme;
        theme.resolveAttribute(R.attr.themeTextColor, typedValue, true);
        this.themeTextColor = typedValue.data;
    }

    public final Resources.Theme getTheme() {
        return this.theme;
    }

    public final int getThemeTextColor() {
        return this.themeTextColor;
    }

    /* INFO: compiled from: LibraryCollectionWallpaperViewNavFragment.kt */
    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0086\u0004\u0018\u00002\f0\u0001R\b\u0012\u0004\u0012\u00020\u00030\u0002B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0003H\u0016J\b\u0010\u0016\u001a\u00020\u0012H\u0016J\b\u0010\u0017\u001a\u00020\u0012H\u0016R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0018"}, d2 = {"Lcom/magneticchen/daijishou/nav_fragments/LibraryCollectionWallpaperViewRecyclerViewAdapter$ViewHolder;", "Lcom/magneticchen/daijishou/daijishou_recycler_view/DaijishouRecyclerView$Adapter$ViewHolder;", "Lcom/magneticchen/daijishou/daijishou_recycler_view/DaijishouRecyclerView$Adapter;", "Lcom/magneticchen/daijishou/daijishou_library_db/PlatformEntity;", "itemView", "Landroid/view/View;", "(Lcom/magneticchen/daijishou/nav_fragments/LibraryCollectionWallpaperViewRecyclerViewAdapter;Landroid/view/View;)V", "layout", "Landroidx/constraintlayout/widget/ConstraintLayout;", "getLayout", "()Landroidx/constraintlayout/widget/ConstraintLayout;", "textColorsBackup", "Landroid/content/res/ColorStateList;", "textView", "Landroid/widget/TextView;", "getTextView", "()Landroid/widget/TextView;", "onBind", "", "position", "", "item", "onSelect", "onUnselect", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public final class ViewHolder extends DaijishouRecyclerView.Adapter<PlatformEntity>.ViewHolder {
        private final ConstraintLayout layout;
        private ColorStateList textColorsBackup;
        private final TextView textView;
        final /* synthetic */ LibraryCollectionWallpaperViewRecyclerViewAdapter this$0;

        /* WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(LibraryCollectionWallpaperViewRecyclerViewAdapter libraryCollectionWallpaperViewRecyclerViewAdapter, View itemView) {
            super(libraryCollectionWallpaperViewRecyclerViewAdapter, itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            this.this$0 = libraryCollectionWallpaperViewRecyclerViewAdapter;
            View viewFindViewById = itemView.findViewById(R.id.list_item_library_collection_wallpaper_view_text_view);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
            TextView textView = (TextView) viewFindViewById;
            this.textView = textView;
            View viewFindViewById2 = itemView.findViewById(R.id.list_item_library_collection_wallpaper_view_constraint_layout);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
            this.layout = (ConstraintLayout) viewFindViewById2;
            ColorStateList textColors = textView.getTextColors();
            Intrinsics.checkNotNullExpressionValue(textColors, "getTextColors(...)");
            this.textColorsBackup = textColors;
        }

        public final TextView getTextView() {
            return this.textView;
        }

        public final ConstraintLayout getLayout() {
            return this.layout;
        }

        @Override // com.magneticchen.daijishou.daijishou_recycler_view.DaijishouRecyclerView.Adapter.ViewHolder
        public void onBind(int position, PlatformEntity item) {
            Intrinsics.checkNotNullParameter(item, "item");
            this.textView.setText(item.getShortname());
        }

        @Override // com.magneticchen.daijishou.daijishou_recycler_view.DaijishouRecyclerView.Adapter.ViewHolder
        public void onSelect() {
            super.onSelect();
            this.textView.setTextColor(this.this$0.getThemeTextColor());
            this.textView.setSelected(true);
        }

        @Override // com.magneticchen.daijishou.daijishou_recycler_view.DaijishouRecyclerView.Adapter.ViewHolder
        public void onUnselect() {
            super.onUnselect();
            this.textView.setTextColor(this.textColorsBackup);
            this.textView.setSelected(false);
            this.itemView.setId(-1);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        Intrinsics.checkNotNullParameter(viewGroup, "viewGroup");
        View viewInflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item_library_collection_wallpaper_view_platform, viewGroup, false);
        Intrinsics.checkNotNull(viewInflate);
        return new ViewHolder(this, viewInflate);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int position) {
        return getItemList().get(position).getId();
    }
}
