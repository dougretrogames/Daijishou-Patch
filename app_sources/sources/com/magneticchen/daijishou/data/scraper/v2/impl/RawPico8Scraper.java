package com.magneticchen.daijishou.data.scraper.v2.impl;

import android.graphics.BitmapFactory;
import android.net.Uri;
import com.magneticchen.daijishou.DaijishouApplication;
import com.magneticchen.daijishou.data.PlayableItemPreviewMediaIndex;
import com.magneticchen.daijishou.data.scraper.v2.AbstractScraper;
import com.magneticchen.daijishou.data.scraper.v2.ScraperConfig;
import java.io.FileOutputStream;
import java.io.InputStream;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: RawPico8Scraper.kt */
/* JADX INFO: loaded from: C:\Users\dfukuoka\Downloads\Daijishou\Daijishou\build_tmp\dex181_classes4.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u001e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r¨\u0006\u000e"}, d2 = {"Lcom/magneticchen/daijishou/data/scraper/v2/impl/RawPico8Scraper;", "Lcom/magneticchen/daijishou/data/scraper/v2/AbstractScraper;", "application", "Lcom/magneticchen/daijishou/DaijishouApplication;", "config", "Lcom/magneticchen/daijishou/data/scraper/v2/ScraperConfig;", "(Lcom/magneticchen/daijishou/DaijishouApplication;Lcom/magneticchen/daijishou/data/scraper/v2/ScraperConfig;)V", "scrapePreviewMediaByFileUri", "Lcom/magneticchen/daijishou/data/PlayableItemPreviewMediaIndex;", "playableItemPreviewMediaIndex", "fileUri", "Landroid/net/Uri;", "outputPath", "", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class RawPico8Scraper extends AbstractScraper {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                try {
                    throw th;
                } catch (Throwable th2) {
                    CloseableKt.closeFinally(inputStreamOpenInputStream, th);
                    throw th2;
                }
            }
        } catch (Exception e) {
            getLogger().warn(this, ExceptionsKt.stackTraceToString(e));
            return playableItemPreviewMediaIndex;
        }
    }
}
