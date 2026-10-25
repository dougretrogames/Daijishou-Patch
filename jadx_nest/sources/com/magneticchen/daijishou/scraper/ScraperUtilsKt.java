package com.magneticchen.daijishou.scraper;

import android.graphics.Bitmap;
import com.magneticchen.daijishou.daijishou_library_db.PlayableItemPreviewMediaIndex;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ScraperUtils.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0018\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004\u001a\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b\u001a\u000e\u0010\t\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b¨\u0006\n"}, d2 = {"getResizedBitmap", "Landroid/graphics/Bitmap;", "image", "shortEdgeSize", "", "hasAllMedia", "", "playableItemPreviewMediaIndex", "Lcom/magneticchen/daijishou/daijishou_library_db/PlayableItemPreviewMediaIndex;", "hasAnyMedia", "app_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
public final class ScraperUtilsKt {
    public static final boolean hasAllMedia(PlayableItemPreviewMediaIndex playableItemPreviewMediaIndex) {
        Intrinsics.checkNotNullParameter(playableItemPreviewMediaIndex, "playableItemPreviewMediaIndex");
        return (playableItemPreviewMediaIndex.getBoxArtPath() == null || playableItemPreviewMediaIndex.getSnapshotPath() == null || playableItemPreviewMediaIndex.getBoxArtPath() == null) ? false : true;
    }

    public static final boolean hasAnyMedia(PlayableItemPreviewMediaIndex playableItemPreviewMediaIndex) {
        Intrinsics.checkNotNullParameter(playableItemPreviewMediaIndex, "playableItemPreviewMediaIndex");
        return (playableItemPreviewMediaIndex.getBoxArtPath() == null && playableItemPreviewMediaIndex.getSnapshotPath() == null && playableItemPreviewMediaIndex.getBoxArtPath() == null) ? false : true;
    }

    public static final Bitmap getResizedBitmap(Bitmap image, int i) {
        int i2;
        Intrinsics.checkNotNullParameter(image, "image");
        float height = image.getHeight() / image.getWidth();
        if (height > 1.0f) {
            i2 = i;
            i = (int) (i * height);
        } else {
            i2 = (int) (i / height);
        }
        return (i > image.getHeight() || i2 > image.getWidth()) ? image : Bitmap.createScaledBitmap(image, i2, i, true);
    }
}
