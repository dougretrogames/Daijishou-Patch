package com.magneticchen.daijishou.ui.fragments.nav;

import androidx.navigation.ActionOnlyNavDirections;
import androidx.navigation.NavDirections;
import com.magneticchen.daijishou.R;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: LibraryCollectionWebViewViewNavFragmentDirections.kt */
/* JADX INFO: loaded from: C:\Users\dfukuoka\Downloads\Daijishou\Daijishou\build_tmp\dex181_classes4.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/magneticchen/daijishou/ui/fragments/nav/LibraryCollectionWebViewViewNavFragmentDirections;", "", "()V", "Companion", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class LibraryCollectionWebViewViewNavFragmentDirections {
    public static final Companion Companion = new Companion(null);

    /* JADX INFO: compiled from: LibraryCollectionWebViewViewNavFragmentDirections.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004J\u0006\u0010\u0005\u001a\u00020\u0004J\u0006\u0010\u0006\u001a\u00020\u0004J\u0006\u0010\u0007\u001a\u00020\u0004J\u0006\u0010\b\u001a\u00020\u0004¨\u0006\t"}, d2 = {"Lcom/magneticchen/daijishou/ui/fragments/nav/LibraryCollectionWebViewViewNavFragmentDirections$Companion;", "", "()V", "libraryCollectionWebViewViewToLibraryCollectionThumbnailsViewAction", "Landroidx/navigation/NavDirections;", "libraryCollectionWebViewViewToLibraryCollectionWallpaperViewAction", "libraryCollectionWebViewViewToPlatformEmptyAction", "libraryCollectionWebViewViewToPlatformLibraryGridViewAction", "libraryCollectionWebViewViewToPlatformLibraryListViewAction", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final NavDirections libraryCollectionWebViewViewToLibraryCollectionWallpaperViewAction() {
            return new ActionOnlyNavDirections(R.id.libraryCollectionWebViewViewToLibraryCollectionWallpaperViewAction);
        }

        public final NavDirections libraryCollectionWebViewViewToLibraryCollectionThumbnailsViewAction() {
            return new ActionOnlyNavDirections(R.id.libraryCollectionWebViewViewToLibraryCollectionThumbnailsViewAction);
        }

        public final NavDirections libraryCollectionWebViewViewToPlatformEmptyAction() {
            return new ActionOnlyNavDirections(R.id.libraryCollectionWebViewViewToPlatformEmptyAction);
        }

        public final NavDirections libraryCollectionWebViewViewToPlatformLibraryGridViewAction() {
            return new ActionOnlyNavDirections(R.id.libraryCollectionWebViewViewToPlatformLibraryGridViewAction);
        }

        public final NavDirections libraryCollectionWebViewViewToPlatformLibraryListViewAction() {
            return new ActionOnlyNavDirections(R.id.libraryCollectionWebViewViewToPlatformLibraryListViewAction);
        }
    }

    private LibraryCollectionWebViewViewNavFragmentDirections() {
    }
}
