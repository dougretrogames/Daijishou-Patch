package com.magneticchen.daijishou.nav_fragments;

import androidx.navigation.ActionOnlyNavDirections;
import androidx.navigation.NavDirections;
import com.magneticchen.daijishou.R;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* INFO: compiled from: LibraryCollectionWallpaperViewNavFragmentDirections.kt */
/* INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/magneticchen/daijishou/nav_fragments/LibraryCollectionWallpaperViewNavFragmentDirections;", "", "()V", "Companion", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class LibraryCollectionWallpaperViewNavFragmentDirections {

    /* INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* INFO: compiled from: LibraryCollectionWallpaperViewNavFragmentDirections.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004J\u0006\u0010\u0005\u001a\u00020\u0004J\u0006\u0010\u0006\u001a\u00020\u0004J\u0006\u0010\u0007\u001a\u00020\u0004J\u0006\u0010\b\u001a\u00020\u0004¨\u0006\t"}, d2 = {"Lcom/magneticchen/daijishou/nav_fragments/LibraryCollectionWallpaperViewNavFragmentDirections$Companion;", "", "()V", "libraryCollectionWallpaperViewToLibraryCollectionThumbnailsViewAction", "Landroidx/navigation/NavDirections;", "libraryCollectionWallpaperViewToLibraryCollectionWebViewViewAction", "libraryCollectionWallpaperViewToPlatformEmptyAction", "libraryCollectionWallpaperViewToPlatformLibraryGridViewAction", "libraryCollectionWallpaperViewToPlatformLibraryListViewAction", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final NavDirections libraryCollectionWallpaperViewToPlatformEmptyAction() {
            return new ActionOnlyNavDirections(R.id.libraryCollectionWallpaperViewToPlatformEmptyAction);
        }

        public final NavDirections libraryCollectionWallpaperViewToPlatformLibraryListViewAction() {
            return new ActionOnlyNavDirections(R.id.libraryCollectionWallpaperViewToPlatformLibraryListViewAction);
        }

        public final NavDirections libraryCollectionWallpaperViewToPlatformLibraryGridViewAction() {
            return new ActionOnlyNavDirections(R.id.libraryCollectionWallpaperViewToPlatformLibraryGridViewAction);
        }

        public final NavDirections libraryCollectionWallpaperViewToLibraryCollectionThumbnailsViewAction() {
            return new ActionOnlyNavDirections(R.id.libraryCollectionWallpaperViewToLibraryCollectionThumbnailsViewAction);
        }

        public final NavDirections libraryCollectionWallpaperViewToLibraryCollectionWebViewViewAction() {
            return new ActionOnlyNavDirections(R.id.libraryCollectionWallpaperViewToLibraryCollectionWebViewViewAction);
        }
    }

    private LibraryCollectionWallpaperViewNavFragmentDirections() {
    }
}
