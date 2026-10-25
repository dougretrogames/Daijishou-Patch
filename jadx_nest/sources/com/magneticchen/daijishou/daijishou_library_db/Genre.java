package com.magneticchen.daijishou.daijishou_library_db;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.eclipse.jgit.lib.ConfigConstants;

/* JADX INFO: compiled from: Genres.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0007HÆ\u0003J-\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0007HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0018"}, d2 = {"Lcom/magneticchen/daijishou/daijishou_library_db/Genre;", "", "id", "", "alias", "", "nameStringId", "", "(Ljava/lang/String;Ljava/util/List;I)V", "getAlias", "()Ljava/util/List;", "getId", "()Ljava/lang/String;", "getNameStringId", "()I", "component1", "component2", "component3", ConfigConstants.CONFIG_RENAMELIMIT_COPY, "equals", "", "other", "hashCode", "toString", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final /* data */ class Genre {
    private final List<String> alias;
    private final String id;
    private final int nameStringId;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Genre copy$default(Genre genre, String str, List list, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = genre.id;
        }
        if ((i2 & 2) != 0) {
            list = genre.alias;
        }
        if ((i2 & 4) != 0) {
            i = genre.nameStringId;
        }
        return genre.copy(str, list, i);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    public final List<String> component2() {
        return this.alias;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getNameStringId() {
        return this.nameStringId;
    }

    public final Genre copy(String id2, List<String> alias, int nameStringId) {
        Intrinsics.checkNotNullParameter(id2, "id");
        Intrinsics.checkNotNullParameter(alias, "alias");
        return new Genre(id2, alias, nameStringId);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Genre)) {
            return false;
        }
        Genre genre = (Genre) other;
        return Intrinsics.areEqual(this.id, genre.id) && Intrinsics.areEqual(this.alias, genre.alias) && this.nameStringId == genre.nameStringId;
    }

    public int hashCode() {
        return (((this.id.hashCode() * 31) + this.alias.hashCode()) * 31) + Integer.hashCode(this.nameStringId);
    }

    public String toString() {
        return "Genre(id=" + this.id + ", alias=" + this.alias + ", nameStringId=" + this.nameStringId + ")";
    }

    public Genre(String id2, List<String> alias, int i) {
        Intrinsics.checkNotNullParameter(id2, "id");
        Intrinsics.checkNotNullParameter(alias, "alias");
        this.id = id2;
        this.alias = alias;
        this.nameStringId = i;
    }


    public final List<String> getAlias() {
        return this.alias;
    }

}
