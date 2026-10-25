package com.api.igdb.apicalypse;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: compiled from: Sort.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/api/igdb/apicalypse/Sort;", "", "apiName", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getApiName", "()Ljava/lang/String;", "ASCENDING", "DESCENDING", "igdb-api-jvm"}, k = 1, mv = {1, 9, 0}, xi = 48)
public enum Sort {
    ASCENDING("asc"),
    DESCENDING("desc");

    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());
    private final String apiName;

    public static EnumEntries<Sort> getEntries() {
        return $ENTRIES;
    }

    Sort(String str) {
        this.apiName = str;
    }

    public final String getApiName() {
        return this.apiName;
    }
}
