package com.api.igdb.apicalypse;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: APICalypse.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u000b\u001a\u00020\u0004J\u000e\u0010\u0003\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u0010\u0005\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u0010\u0006\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\fJ\u000e\u0010\u0007\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\fJ\u000e\u0010\b\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\u0004J\u0016\u0010\t\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u0010J\u000e\u0010\n\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/api/igdb/apicalypse/APICalypse;", "", "()V", "exclude", "", "fields", "limit", TypedValues.CycleType.S_WAVE_OFFSET, "search", "sort", "where", "buildQuery", "", "searchQuery", "field", "order", "Lcom/api/igdb/apicalypse/Sort;", "igdb-api-jvm"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class APICalypse {
    private String search = "";
    private String fields = "";
    private String exclude = "";
    private String limit = "";
    private String offset = "";
    private String sort = "";
    private String where = "";

    public final APICalypse sort(String field, Sort order) {
        Intrinsics.checkNotNullParameter(field, "field");
        Intrinsics.checkNotNullParameter(order, "order");
        this.sort = "s " + field + " " + order.getApiName() + ";";
        return this;
    }

    public final APICalypse fields(String fields) {
        Intrinsics.checkNotNullParameter(fields, "fields");
        this.fields = "f " + fields + ";";
        return this;
    }

    public final APICalypse exclude(String fields) {
        Intrinsics.checkNotNullParameter(fields, "fields");
        this.exclude = "x " + fields + ";";
        return this;
    }

    public final APICalypse limit(int limit) {
        this.limit = "l " + limit + ";";
        return this;
    }

    public final APICalypse offset(int offset) {
        this.offset = "o " + offset + ";";
        return this;
    }

    public final APICalypse search(String searchQuery) {
        Intrinsics.checkNotNullParameter(searchQuery, "searchQuery");
        this.search = "search \"" + searchQuery + "\";";
        return this;
    }

    public final APICalypse where(String where) {
        Intrinsics.checkNotNullParameter(where, "where");
        String str = where;
        if (StringsKt.contains$default((CharSequence) str, (CharSequence) "where ", false, 2, (Object) null) || StringsKt.contains$default((CharSequence) str, (CharSequence) "w ", false, 2, (Object) null)) {
            this.where = where;
            return this;
        }
        if (!StringsKt.contains$default((CharSequence) str, (CharSequence) ";", false, 2, (Object) null)) {
            this.where = "w " + where + ";";
            return this;
        }
        this.where = "w " + where;
        return this;
    }

    public final String buildQuery() {
        String str = "";
        if (!StringsKt.isBlank(this.search)) {
            str = "" + this.search;
        }
        if (!StringsKt.isBlank(this.fields)) {
            str = str + this.fields;
        }
        if (!StringsKt.isBlank(this.exclude)) {
            str = str + this.exclude;
        }
        if (!StringsKt.isBlank(this.limit)) {
            str = str + this.limit;
        }
        if (!StringsKt.isBlank(this.offset)) {
            str = str + this.offset;
        }
        if (!StringsKt.isBlank(this.sort)) {
            str = str + this.sort;
        }
        if (StringsKt.isBlank(this.where)) {
            return str;
        }
        return str + this.where;
    }
}
