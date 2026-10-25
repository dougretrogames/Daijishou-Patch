package com.magneticchen.daijishou.dialog_fragments;

import android.R;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ListSelectDialogFragment.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\"\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u00042\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"}, d2 = {"com/magneticchen/daijishou/dialog_fragments/ListSelectDialogFragment$onCreateDialog$1$1", "Landroid/widget/ArrayAdapter;", "", "getView", "Landroid/view/View;", "position", "", "convertView", "parent", "Landroid/view/ViewGroup;", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class ListSelectDialogFragment$onCreateDialog$1$1 extends ArrayAdapter<String> {
    final /* synthetic */ ArrayList<String> $descriptionList;
    final /* synthetic */ ArrayList<String> $titleList;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ListSelectDialogFragment$onCreateDialog$1$1(ArrayList<String> arrayList, ArrayList<String> arrayList2, Context context) {
        super(context, R.layout.simple_list_item_2, R.id.text1, arrayList);
        this.$descriptionList = arrayList;
        this.$titleList = arrayList2;
        Intrinsics.checkNotNull(arrayList, "null cannot be cast to non-null type kotlin.collections.List<kotlin.String>");
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public View getView(int position, View convertView, ViewGroup parent) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View view = super.getView(position, convertView, parent);
        Intrinsics.checkNotNullExpressionValue(view, "getView(...)");
        View viewFindViewById = view.findViewById(R.id.text1);
        Intrinsics.checkNotNull(viewFindViewById, "null cannot be cast to non-null type android.widget.TextView");
        View viewFindViewById2 = view.findViewById(R.id.text2);
        Intrinsics.checkNotNull(viewFindViewById2, "null cannot be cast to non-null type android.widget.TextView");
        TextView textView = (TextView) viewFindViewById2;
        ((TextView) viewFindViewById).setText(this.$titleList.get(position));
        textView.setText(this.$descriptionList.get(position));
        textView.setAlpha(0.75f);
        return view;
    }
}
