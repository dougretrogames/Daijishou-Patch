package com.magneticchen.daijishou.view_pager_selected_parameters;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.eclipse.jgit.lib.ConfigConstants;

/* JADX INFO: compiled from: LibraryPageSelectedParameters.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0016"}, d2 = {"Lcom/magneticchen/daijishou/view_pager_selected_parameters/LibraryPageSelectedParameters;", "", "filterMode", "", "platformId", "", "(IJ)V", "getFilterMode", "()I", "setFilterMode", "(I)V", "getPlatformId", "()J", "component1", "component2", ConfigConstants.CONFIG_RENAMELIMIT_COPY, "equals", "", "other", "hashCode", "toString", "", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final /* data */ class LibraryPageSelectedParameters {
    private int filterMode;
    private final long platformId;

    public static /* synthetic */ LibraryPageSelectedParameters copy$default(LibraryPageSelectedParameters libraryPageSelectedParameters, int i, long j, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = libraryPageSelectedParameters.filterMode;
        }
        if ((i2 & 2) != 0) {
            j = libraryPageSelectedParameters.platformId;
        }
        return libraryPageSelectedParameters.copy(i, j);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getFilterMode() {
        return this.filterMode;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final long getPlatformId() {
        return this.platformId;
    }

    public final LibraryPageSelectedParameters copy(int filterMode, long platformId) {
        return new LibraryPageSelectedParameters(filterMode, platformId);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LibraryPageSelectedParameters)) {
            return false;
        }
        LibraryPageSelectedParameters libraryPageSelectedParameters = (LibraryPageSelectedParameters) other;
        return this.filterMode == libraryPageSelectedParameters.filterMode && this.platformId == libraryPageSelectedParameters.platformId;
    }

    public int hashCode() {
        return (Integer.hashCode(this.filterMode) * 31) + Long.hashCode(this.platformId);
    }

    public String toString() {
        return "LibraryPageSelectedParameters(filterMode=" + this.filterMode + ", platformId=" + this.platformId + ")";
    }

    public LibraryPageSelectedParameters(int i, long j) {
        this.filterMode = i;
        this.platformId = j;
    }

    public /* synthetic */ LibraryPageSelectedParameters(int i, long j, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? -1 : i, j);
    }


    public final void setFilterMode(int i) {
        this.filterMode = i;
    }

}
