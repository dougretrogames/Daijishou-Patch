package com.magneticchen.daijishou.data;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Genres.kt */
/* JADX INFO: loaded from: C:\Users\dfukuoka\Downloads\Daijishou\Daijishou\build_tmp\dex181_classes4.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0007HÆ\u0003J-\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0007HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0018"}, d2 = {"Lcom/magneticchen/daijishou/data/Genre;", "", "id", "", "alias", "", "nameStringId", "", "(Ljava/lang/String;Ljava/util/List;I)V", "getAlias", "()Ljava/util/List;", "getId", "()Ljava/lang/String;", "getNameStringId", "()I", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class Genre {
    private final List<String> alias;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private final String f8id;
    private final int nameStringId;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Genre copy$default(Genre genre, String str, List list, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = genre.f8id;
        }
        if ((i2 & 2) != 0) {
            list = genre.alias;
        }
        if ((i2 & 4) != 0) {
            i = genre.nameStringId;
        }
        return genre.copy(str, list, i);
    }

    public final String component1() {
        return this.f8id;
    }

    public final List<String> component2() {
        return this.alias;
    }

    public final int component3() {
        return this.nameStringId;
    }

    public final Genre copy(String id2, List<String> alias, int i) {
        Intrinsics.checkNotNullParameter(id2, "id");
        Intrinsics.checkNotNullParameter(alias, "alias");
        return new Genre(id2, alias, i);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Genre)) {
            return false;
        }
        Genre genre = (Genre) obj;
        return Intrinsics.areEqual(this.f8id, genre.f8id) && Intrinsics.areEqual(this.alias, genre.alias) && this.nameStringId == genre.nameStringId;
    }

    public int hashCode() {
        return (((this.f8id.hashCode() * 31) + this.alias.hashCode()) * 31) + Integer.hashCode(this.nameStringId);
    }

    public String toString() {
        return "Genre(id=" + this.f8id + ", alias=" + this.alias + ", nameStringId=" + this.nameStringId + ")";
    }

    public Genre(String id2, List<String> alias, int i) {
        Intrinsics.checkNotNullParameter(id2, "id");
        Intrinsics.checkNotNullParameter(alias, "alias");
        this.f8id = id2;
        this.alias = alias;
        this.nameStringId = i;
    }

    public final String getId() {
        return this.f8id;
    }

    public final List<String> getAlias() {
        return this.alias;
    }

    public final int getNameStringId() {
        return this.nameStringId;
    }
}
