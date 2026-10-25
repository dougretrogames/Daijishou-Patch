package com.api.igdb.utils;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.lingala.zip4j.util.InternalZipConstants;
import org.eclipse.jgit.lib.BranchConfig;

/* JADX INFO: compiled from: ImageBuilder.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a \u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"IGDB_IMAGE_URL", "", "imageBuilder", "imageID", "size", "Lcom/api/igdb/utils/ImageSize;", "imageType", "Lcom/api/igdb/utils/ImageType;", "igdb-api-jvm"}, k = 2, mv = {1, 9, 0}, xi = 48)
public final class ImageBuilderKt {
    private static final String IGDB_IMAGE_URL = "https://images.igdb.com/igdb/image/upload/";

    public static /* synthetic */ String imageBuilder$default(String str, ImageSize imageSize, ImageType imageType, int i, Object obj) {
        if ((i & 4) != 0) {
            imageType = ImageType.PNG;
        }
        return imageBuilder(str, imageSize, imageType);
    }

    public static final String imageBuilder(String imageID, ImageSize size, ImageType imageType) {
        Intrinsics.checkNotNullParameter(imageID, "imageID");
        Intrinsics.checkNotNullParameter(size, "size");
        Intrinsics.checkNotNullParameter(imageType, "imageType");
        return IGDB_IMAGE_URL + size.getTSize() + InternalZipConstants.ZIP_FILE_SEPARATOR + imageID + BranchConfig.LOCAL_REPOSITORY + imageType.getType();
    }
}
