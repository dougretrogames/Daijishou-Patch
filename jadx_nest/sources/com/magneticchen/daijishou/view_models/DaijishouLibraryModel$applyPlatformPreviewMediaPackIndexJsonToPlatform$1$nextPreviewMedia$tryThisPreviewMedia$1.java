package com.magneticchen.daijishou.view_models;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import com.bumptech.glide.request.target.CustomTarget;
import com.bumptech.glide.request.transition.Transition;
import com.magneticchen.daijishou.application_data.Constants;
import com.magneticchen.daijishou.daijishou_library_db.PlatformEntity;
import com.magneticchen.daijishou.scraper.ScraperUtilsKt;
import java.io.FileOutputStream;
import java.io.IOException;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* INFO: compiled from: DaijishouLibraryModel.kt */
/* INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0006H\u0016J\"\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00022\u0010\u0010\u000b\u001a\f\u0012\u0006\b\u0000\u0012\u00020\u0002\u0018\u00010\fH\u0016¨\u0006\r"}, d2 = {"com/magneticchen/daijishou/view_models/DaijishouLibraryModel$applyPlatformPreviewMediaPackIndexJsonToPlatform$1$nextPreviewMedia$tryThisPreviewMedia$1", "Lcom/bumptech/glide/request/target/CustomTarget;", "Landroid/graphics/Bitmap;", "onLoadCleared", "", "placeholder", "Landroid/graphics/drawable/Drawable;", "onLoadFailed", "errorDrawable", "onResourceReady", "bitmap", "transition", "Lcom/bumptech/glide/request/transition/Transition;", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class DaijishouLibraryModel$applyPlatformPreviewMediaPackIndexJsonToPlatform$1$nextPreviewMedia$tryThisPreviewMedia$1 extends CustomTarget<Bitmap> {
    final /* synthetic */ Function0<Unit> $onFailed;
    final /* synthetic */ Function0<Unit> $onSucceed;
    final /* synthetic */ PlatformEntity $platformEntity;
    final /* synthetic */ int $previewMediaType;
    final /* synthetic */ Ref.IntRef $triedCount;
    final /* synthetic */ String $urlString;
    final /* synthetic */ DaijishouLibraryModel this$0;

    @Override // com.bumptech.glide.request.target.Target
    public void onLoadCleared(Drawable placeholder) {
    }

    DaijishouLibraryModel$applyPlatformPreviewMediaPackIndexJsonToPlatform$1$nextPreviewMedia$tryThisPreviewMedia$1(int i, DaijishouLibraryModel daijishouLibraryModel, PlatformEntity platformEntity, Function0<Unit> function0, String str, Function0<Unit> function1, Ref.IntRef intRef) {
        this.$previewMediaType = i;
        this.this$0 = daijishouLibraryModel;
        this.$platformEntity = platformEntity;
        this.$onSucceed = function0;
        this.$urlString = str;
        this.$onFailed = function1;
        this.$triedCount = intRef;
    }


    public void onResourceReady(Bitmap bitmap, Transition<? super Bitmap> transition) {
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        try {
            int i = this.$previewMediaType;
            if (i == 0) {
                String str = this.this$0.getApplication().getFilesDir() + "/platform_wallpapers/" + this.$platformEntity.getId() + ".png";
                FileOutputStream fileOutputStream = new FileOutputStream(str);
                Bitmap resizedBitmap = ScraperUtilsKt.getResizedBitmap(bitmap, 720);
                Intrinsics.checkNotNull(resizedBitmap);
                resizedBitmap.compress(Constants.INSTANCE.getPlatformWallpaperFormat(), 100, fileOutputStream);
                this.$platformEntity.setWallpaperPath(str);
            } else if (i == 1) {
                String str2 = this.this$0.getApplication().getFilesDir() + "/platform_thumbnails/" + this.$platformEntity.getId() + ".png";
                FileOutputStream fileOutputStream2 = new FileOutputStream(str2);
                Bitmap resizedBitmap2 = ScraperUtilsKt.getResizedBitmap(bitmap, 240);
                Intrinsics.checkNotNull(resizedBitmap2);
                resizedBitmap2.compress(Constants.INSTANCE.getPlatformThumbnailFormat(), 100, fileOutputStream2);
                this.$platformEntity.setThumbnailPath(str2);
            }
            this.this$0.updatePlatform(this.$platformEntity);
        } catch (IOException e) {
            this.this$0.logger.warn(this, ExceptionsKt.stackTraceToString(e));
        }
        this.$onSucceed.invoke();
    }

    @Override // com.bumptech.glide.request.target.CustomTarget, com.bumptech.glide.request.target.Target
    public void onLoadFailed(Drawable errorDrawable) {
        super.onLoadFailed(errorDrawable);
        DaijishouLibraryModel.C02751.invokeSuspendImpl$nextPreviewMedia$tryThisPreviewMedia(this.$triedCount, this.this$0, this.$previewMediaType, this.$platformEntity, this.$urlString, this.$onSucceed, this.$onFailed);
    }
}
