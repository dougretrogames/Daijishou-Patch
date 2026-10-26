package com.magneticchen.daijishou.scraper.v2.impl;

import android.graphics.BitmapFactory;
import android.net.Uri;
import com.magneticchen.daijishou.DaijishouApplication;
import com.magneticchen.daijishou.daijishou_library_db.PlayableItemPreviewMediaIndex;
import com.magneticchen.daijishou.scraper.v2.AbstractScraper;
import com.magneticchen.daijishou.scraper.v2.ScraperConfig;
import java.io.FileOutputStream;
import java.io.InputStream;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;

/* INFO: compiled from: RawPico8Scraper.kt */
/* INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u001e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r¨\u0006\u000e"}, d2 = {"Lcom/magneticchen/daijishou/scraper/v2/impl/RawPico8Scraper;", "Lcom/magneticchen/daijishou/scraper/v2/AbstractScraper;", "application", "Lcom/magneticchen/daijishou/DaijishouApplication;", "config", "Lcom/magneticchen/daijishou/scraper/v2/ScraperConfig;", "(Lcom/magneticchen/daijishou/DaijishouApplication;Lcom/magneticchen/daijishou/scraper/v2/ScraperConfig;)V", "scrapePreviewMediaByFileUri", "Lcom/magneticchen/daijishou/daijishou_library_db/PlayableItemPreviewMediaIndex;", "playableItemPreviewMediaIndex", "fileUri", "Landroid/net/Uri;", "outputPath", "", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class RawPico8Scraper extends AbstractScraper {
    /* WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RawPico8Scraper(DaijishouApplication application, ScraperConfig config) {
        super(application, config);
        Intrinsics.checkNotNullParameter(application, "application");
        Intrinsics.checkNotNullParameter(config, "config");
    }

    public final PlayableItemPreviewMediaIndex scrapePreviewMediaByFileUri(PlayableItemPreviewMediaIndex playableItemPreviewMediaIndex, Uri fileUri, String outputPath) {
        Intrinsics.checkNotNullParameter(playableItemPreviewMediaIndex, "playableItemPreviewMediaIndex");
        Intrinsics.checkNotNullParameter(fileUri, "fileUri");
        Intrinsics.checkNotNullParameter(outputPath, "outputPath");
        if (hasAllMedia(playableItemPreviewMediaIndex)) {
            return playableItemPreviewMediaIndex;
        }
        try {
            InputStream inputStreamOpenInputStream = getApplication().getContentResolver().openInputStream(fileUri);
            try {
                BitmapFactory.decodeStream(inputStreamOpenInputStream).compress(getConfig().getScraperFormat(), getConfig().getScraperQuality(), new FileOutputStream(outputPath + getConfig().getBoxArtFilename()));
                playableItemPreviewMediaIndex.setBoxArtPath(getConfig().getBoxArtFilename());
                Unit unit = Unit.INSTANCE;
                CloseableKt.closeFinally(inputStreamOpenInputStream, null);
                return playableItemPreviewMediaIndex;
            } catch (Throwable th) {
                                    CloseableKt.closeFinally(inputStreamOpenInputStream, th);
                    throw com.magneticchen.daijishou.support.DaijishouSupport.sneakyThrow(th);
            }
        } catch (Exception e) {
            getLogger().warn(this, ExceptionsKt.stackTraceToString(e));
            return playableItemPreviewMediaIndex;
        }
    }
}
