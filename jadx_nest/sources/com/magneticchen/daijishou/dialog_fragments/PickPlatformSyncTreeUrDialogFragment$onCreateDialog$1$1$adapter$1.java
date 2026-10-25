package com.magneticchen.daijishou.dialog_fragments;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import com.magneticchen.daijishou.R;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PickPlatformSyncTreeUrDialogFragment.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\"\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u00042\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"}, d2 = {"com/magneticchen/daijishou/dialog_fragments/PickPlatformSyncTreeUrDialogFragment$onCreateDialog$1$1$adapter$1", "Landroid/widget/ArrayAdapter;", "Landroid/net/Uri;", "getView", "Landroid/view/View;", "position", "", "convertView", "parent", "Landroid/view/ViewGroup;", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class PickPlatformSyncTreeUrDialogFragment$onCreateDialog$1$1$adapter$1 extends ArrayAdapter<Uri> {
    final /* synthetic */ PickPlatformSyncTreeUrDialogFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    PickPlatformSyncTreeUrDialogFragment$onCreateDialog$1$1$adapter$1(Context context, PickPlatformSyncTreeUrDialogFragment pickPlatformSyncTreeUrDialogFragment, List<Uri> list) {
        super(context, R.layout.list_item_dense_item, R.id.list_item_theme_pack_choice_title, list);
        this.this$0 = pickPlatformSyncTreeUrDialogFragment;
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public View getView(int position, View convertView, ViewGroup parent) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View view = super.getView(position, convertView, parent);
        Intrinsics.checkNotNullExpressionValue(view, "getView(...)");
        View viewFindViewById = view.findViewById(R.id.list_item_theme_pack_choice_title);
        Intrinsics.checkNotNull(viewFindViewById, "null cannot be cast to non-null type android.widget.TextView");
        ((TextView) viewFindViewById).setText(String.valueOf(((Uri) this.this$0.arrayItems.get(position)).getPath()));
        return view;
    }
}
