package com.magneticchen.daijishou.utils;

import android.content.Context;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: AutoCompleteAdapter.kt */
/* JADX INFO: loaded from: C:\Users\dfukuoka\Downloads\Daijishou\Daijishou\build_tmp\dex181_classes4.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\t\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B#\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\b¢\u0006\u0002\u0010\tJ\b\u0010\u0015\u001a\u00020\u000bH\u0016R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R \u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00020\rX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R \u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00020\rX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u000f\"\u0004\b\u0014\u0010\u0011¨\u0006\u0016"}, d2 = {"Lcom/magneticchen/daijishou/utils/AutoCompleteAdapter;", "Landroid/widget/ArrayAdapter;", "", "context", "Landroid/content/Context;", "resource", "", "items", "", "(Landroid/content/Context;ILjava/util/List;)V", "filter", "Landroid/widget/Filter;", "suggestions", "", "getSuggestions$app_release", "()Ljava/util/List;", "setSuggestions$app_release", "(Ljava/util/List;)V", "tempItems", "getTempItems$app_release", "setTempItems$app_release", "getFilter", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class AutoCompleteAdapter extends ArrayAdapter<Object> {
    private Filter filter;
    private List<Object> suggestions;
    private List<Object> tempItems;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AutoCompleteAdapter(Context context, int i, List<? extends Object> items) {
        super(context, i, CollectionsKt.toMutableList((Collection) items));
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(items, "items");
        this.tempItems = new ArrayList();
        this.suggestions = new ArrayList();
        this.filter = new Filter() { // from class: com.magneticchen.daijishou.utils.AutoCompleteAdapter$filter$1
            @Override // android.widget.Filter
            protected Filter.FilterResults performFiltering(CharSequence charSequence) {
                if (charSequence != null) {
                    this.this$0.getSuggestions$app_release().clear();
                    List<Object> tempItems$app_release = this.this$0.getTempItems$app_release();
                    AutoCompleteAdapter autoCompleteAdapter = this.this$0;
                    for (Object obj : tempItems$app_release) {
                        String string = obj.toString();
                        Locale locale = Locale.getDefault();
                        Intrinsics.checkNotNullExpressionValue(locale, "getDefault(...)");
                        String lowerCase = string.toLowerCase(locale);
                        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                        String string2 = charSequence.toString();
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
            protected void publishResults(CharSequence charSequence, Filter.FilterResults results) {
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
        };
        this.tempItems = CollectionsKt.toMutableList((Collection) CollectionsKt.toList(items));
        this.suggestions = new ArrayList();
    }

    public final List<Object> getTempItems$app_release() {
        return this.tempItems;
    }

    public final void setTempItems$app_release(List<Object> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.tempItems = list;
    }

    public final List<Object> getSuggestions$app_release() {
        return this.suggestions;
    }

    public final void setSuggestions$app_release(List<Object> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.suggestions = list;
    }

    @Override // android.widget.ArrayAdapter, android.widget.Filterable
    public Filter getFilter() {
        return this.filter;
    }
}
