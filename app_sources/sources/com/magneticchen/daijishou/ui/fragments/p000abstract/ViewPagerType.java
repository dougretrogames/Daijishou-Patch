package com.magneticchen.daijishou.ui.fragments.p000abstract;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: compiled from: ViewPagerFragment.kt */
/* JADX INFO: loaded from: C:\Users\dfukuoka\Downloads\Daijishou\Daijishou\build_tmp\dex181_classes4.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/magneticchen/daijishou/ui/fragments/abstract/ViewPagerType;", "", "id", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getId", "()Ljava/lang/String;", "LIBRARY", "WIDGETS", "APPS", "SETTINGS", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public enum ViewPagerType {
    LIBRARY("library"),
    WIDGETS("widgets"),
    APPS("apps"),
    SETTINGS("settings");

    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private final String f48id;

    public static EnumEntries<ViewPagerType> getEntries() {
        return $ENTRIES;
    }

    ViewPagerType(String str) {
        this.f48id = str;
    }

    public final String getId() {
        return this.f48id;
    }
}
