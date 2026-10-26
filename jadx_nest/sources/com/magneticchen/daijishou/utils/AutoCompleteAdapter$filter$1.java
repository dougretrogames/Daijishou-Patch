package com.magneticchen.daijishou.utils;

import android.widget.Filter;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* INFO: compiled from: AutoCompleteAdapter.kt */
/* INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0014J\u001a\u0010\u0006\u001a\u00020\u00072\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\b\u001a\u00020\u0003H\u0014¨\u0006\t"}, d2 = {"com/magneticchen/daijishou/utils/AutoCompleteAdapter$filter$1", "Landroid/widget/Filter;", "performFiltering", "Landroid/widget/Filter$FilterResults;", "constraint", "", "publishResults", "", "results", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class AutoCompleteAdapter$filter$1 extends Filter {
    final /* synthetic */ AutoCompleteAdapter this$0;

    AutoCompleteAdapter$filter$1(AutoCompleteAdapter autoCompleteAdapter) {
        this.this$0 = autoCompleteAdapter;
    }

    @Override // android.widget.Filter
    protected Filter.FilterResults performFiltering(CharSequence constraint) {
        if (constraint != null) {
            this.this$0.getSuggestions$app_release().clear();
            List<Object> tempItems$app_release = this.this$0.getTempItems$app_release();
            AutoCompleteAdapter autoCompleteAdapter = this.this$0;
            for (Object obj : tempItems$app_release) {
                String string = obj.toString();
                Locale locale = Locale.getDefault();
                Intrinsics.checkNotNullExpressionValue(locale, "getDefault(...)");
                String lowerCase = string.toLowerCase(locale);
                Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                String string2 = constraint.toString();
                Locale locale2 = Locale.getDefault();
                Intrinsics.checkNotNullExpressionValue(locale2, "getDefault(...)");
                String lowerCase2 = string2.toLowerCase(locale2);
                Intrinsics.checkNotNullExpressionValue(lowerCase2, "toLowerCase(...)");
                if (StringsKt.contains$default((CharSequence) lowerCase, (CharSequence) lowerCase2, false, 2, (Object) null)) {
                    autoCompleteAdapter.getSuggestions$app_release().add(obj);
                }
            }
            Filter.FilterResults filterResults = new Filter.FilterResults();
            filterResults.values = this.this$0.getSuggestions$app_release();
            filterResults.count = this.this$0.getSuggestions$app_release().size();
            return filterResults;
        }
        return new Filter.FilterResults();
    }

    @Override // android.widget.Filter
    protected void publishResults(CharSequence constraint, Filter.FilterResults results) {
        Intrinsics.checkNotNullParameter(results, "results");
        Object obj = results.values;
        List list = obj instanceof List ? (List) obj : null;
        if (results.count > 0) {
            this.this$0.clear();
            if (list != null) {
                AutoCompleteAdapter autoCompleteAdapter = this.this$0;
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    autoCompleteAdapter.add(it.next());
                }
                Unit unit = Unit.INSTANCE;
            }
            this.this$0.notifyDataSetChanged();
        }
    }
}
