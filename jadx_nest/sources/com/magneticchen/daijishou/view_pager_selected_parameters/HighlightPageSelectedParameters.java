package com.magneticchen.daijishou.view_pager_selected_parameters;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.eclipse.jgit.lib.ConfigConstants;

/* JADX INFO: compiled from: HighlightPageSelectedParameters.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f¨\u0006\u0015"}, d2 = {"Lcom/magneticchen/daijishou/view_pager_selected_parameters/HighlightPageSelectedParameters;", "", "mode", "", "genreId", "", "(ILjava/lang/String;)V", "getGenreId", "()Ljava/lang/String;", "getMode", "()I", "setMode", "(I)V", "component1", "component2", ConfigConstants.CONFIG_RENAMELIMIT_COPY, "equals", "", "other", "hashCode", "toString", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final /* data */ class HighlightPageSelectedParameters {
    private final String genreId;
    private int mode;

    public static /* synthetic */ HighlightPageSelectedParameters copy$default(HighlightPageSelectedParameters highlightPageSelectedParameters, int i, String str, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = highlightPageSelectedParameters.mode;
        }
        if ((i2 & 2) != 0) {
            str = highlightPageSelectedParameters.genreId;
        }
        return highlightPageSelectedParameters.copy(i, str);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getMode() {
        return this.mode;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getGenreId() {
        return this.genreId;
    }

    public final HighlightPageSelectedParameters copy(int mode, String genreId) {
        Intrinsics.checkNotNullParameter(genreId, "genreId");
        return new HighlightPageSelectedParameters(mode, genreId);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof HighlightPageSelectedParameters)) {
            return false;
        }
        HighlightPageSelectedParameters highlightPageSelectedParameters = (HighlightPageSelectedParameters) other;
        return this.mode == highlightPageSelectedParameters.mode && Intrinsics.areEqual(this.genreId, highlightPageSelectedParameters.genreId);
    }

    public int hashCode() {
        return (Integer.hashCode(this.mode) * 31) + this.genreId.hashCode();
    }

    public String toString() {
        return "HighlightPageSelectedParameters(mode=" + this.mode + ", genreId=" + this.genreId + ")";
    }

    public HighlightPageSelectedParameters(int i, String genreId) {
        Intrinsics.checkNotNullParameter(genreId, "genreId");
        this.mode = i;
        this.genreId = genreId;
    }

    public /* synthetic */ HighlightPageSelectedParameters(int i, String str, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 0 : i, str);
    }


    public final void setMode(int i) {
        this.mode = i;
    }

}
