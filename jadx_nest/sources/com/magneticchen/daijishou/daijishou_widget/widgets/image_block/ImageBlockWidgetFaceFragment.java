package com.magneticchen.daijishou.daijishou_widget.widgets.image_block;

import android.app.Application;
import android.content.ContentResolver;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.MimeTypeMap;
import android.widget.ImageView;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.bumptech.glide.signature.ObjectKey;
import com.magneticchen.daijishou.DaijishouApplication;
import com.magneticchen.daijishou.R;
import com.magneticchen.daijishou.application_data.Constants;
import com.magneticchen.daijishou.daijishou_widget.abstract_widget_classes.WidgetFaceFragment;
import com.magneticchen.daijishou.daijishou_widget.widget_db.ImageBlockWidgetInstanceEntity;
import com.magneticchen.daijishou.repositories.DaijishouWidgetRepository;
import com.magneticchen.daijishou.scraper.ScraperUtilsKt;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.Date;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.io.ByteStreamsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.eclipse.jgit.lib.BranchConfig;

/* JADX INFO: compiled from: ImageBlockWidgetFaceFragment.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u000f\u001a\u00020\u0010H\u0002J&\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J\b\u0010\u0019\u001a\u00020\u0010H\u0016R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001f\u0010\t\u001a\u0010\u0012\f\u0012\n \f*\u0004\u0018\u00010\u000b0\u000b0\n¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u001b"}, d2 = {"Lcom/magneticchen/daijishou/daijishou_widget/widgets/image_block/ImageBlockWidgetFaceFragment;", "Lcom/magneticchen/daijishou/daijishou_widget/abstract_widget_classes/WidgetFaceFragment;", "()V", "cachedImageFile", "Ljava/io/File;", "imageCounter", "", "lastUpdateTimestamp", "Ljava/util/Date;", "selectImageActivity", "Landroidx/activity/result/ActivityResultLauncher;", "", "kotlin.jvm.PlatformType", "getSelectImageActivity", "()Landroidx/activity/result/ActivityResultLauncher;", "ensureWallpaperDirectory", "", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onPreload", "Companion", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class ImageBlockWidgetFaceFragment extends WidgetFaceFragment {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private File cachedImageFile;
    private int imageCounter;
    private final Date lastUpdateTimestamp = null;
    private final ActivityResultLauncher<String> selectImageActivity;

    public ImageBlockWidgetFaceFragment() {
        ActivityResultLauncher<String> activityResultLauncherRegisterForActivityResult = registerForActivityResult(new ActivityResultContracts.GetContent(), new ImageBlockWidgetFaceFragment$$ExternalSyntheticLambda0(this));
        Intrinsics.checkNotNullExpressionValue(activityResultLauncherRegisterForActivityResult, "registerForActivityResult(...)");
        this.selectImageActivity = activityResultLauncherRegisterForActivityResult;
    }

    /* JADX INFO: compiled from: ImageBlockWidgetFaceFragment.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/magneticchen/daijishou/daijishou_widget/widgets/image_block/ImageBlockWidgetFaceFragment$Companion;", "", "()V", "newInstance", "Lcom/magneticchen/daijishou/daijishou_widget/widgets/image_block/ImageBlockWidgetFaceFragment;", "widgetInstanceId", "", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final ImageBlockWidgetFaceFragment newInstance(long widgetInstanceId) {
            ImageBlockWidgetFaceFragment imageBlockWidgetFaceFragment = new ImageBlockWidgetFaceFragment();
            Bundle bundle = new Bundle();
            bundle.putLong("widgetInstanceId", widgetInstanceId);
            imageBlockWidgetFaceFragment.setArguments(bundle);
            return imageBlockWidgetFaceFragment;
        }
    }

    public final ActivityResultLauncher<String> getSelectImageActivity() {
        return this.selectImageActivity;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void selectImageActivity$lambda$2(ImageBlockWidgetFaceFragment this$0, Uri uri) throws FileNotFoundException {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        long j = this$0.requireArguments().getLong("widgetInstanceId");
        if (uri == null) {
            return;
        }
        ContentResolver contentResolver = this$0.requireActivity().getContentResolver();
        Application application = this$0.requireActivity().getApplication();
        Intrinsics.checkNotNull(application, "null cannot be cast to non-null type com.magneticchen.daijishou.DaijishouApplication");
        DaijishouWidgetRepository daijishouWidgetRepository = ((DaijishouApplication) application).getDaijishouWidgetRepository();
        this$0.ensureWallpaperDirectory();
        ImageBlockWidgetInstanceEntity imageBlockWidgetInstanceByIdStatically = daijishouWidgetRepository.getImageBlockWidgetInstanceByIdStatically(j);
        if (imageBlockWidgetInstanceByIdStatically != null) {
            String extensionFromMimeType = MimeTypeMap.getSingleton().getExtensionFromMimeType(contentResolver.getType(uri));
            DaijishouApplication.WrappedLogger logger = this$0.getLogger();
            String string = uri.toString();
            Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
            logger.debug(this$0, string);
            InputStream inputStreamOpenInputStream = contentResolver.openInputStream(uri);
            String str = this$0.requireContext().getFilesDir() + "/image_block_widget_images/" + j + BranchConfig.LOCAL_REPOSITORY + (Intrinsics.areEqual(extensionFromMimeType, "gif") ? "gif" : Constants.INSTANCE.getWidgetThumbnailFormatExtension());
            FileOutputStream fileOutputStream = new FileOutputStream(str);
            if (!Intrinsics.areEqual(extensionFromMimeType, "gif")) {
                Bitmap bitmapDecodeStream = BitmapFactory.decodeStream(inputStreamOpenInputStream);
                Intrinsics.checkNotNull(bitmapDecodeStream);
                Bitmap resizedBitmap = ScraperUtilsKt.getResizedBitmap(bitmapDecodeStream, 256);
                Intrinsics.checkNotNull(resizedBitmap);
                resizedBitmap.compress(Constants.INSTANCE.getWidgetThumbnailFormat(), 100, fileOutputStream);
            } else if (inputStreamOpenInputStream != null) {
                InputStream inputStream = inputStreamOpenInputStream;
                try {
                    Long.valueOf(ByteStreamsKt.copyTo$default(inputStream, fileOutputStream, 0, 2, null));
                    CloseableKt.closeFinally(inputStream, null);
                } catch (Throwable th) {
                                            CloseableKt.closeFinally(inputStream, th);
                        throw com.magneticchen.daijishou.support.DaijishouSupport.sneakyThrow(th);
                }
            }
            imageBlockWidgetInstanceByIdStatically.setImagePath(str);
            this$0.imageCounter++;
            daijishouWidgetRepository.updateImageBlockWidgetInstance(imageBlockWidgetInstanceByIdStatically);
        }
    }

    @Override // com.magneticchen.daijishou.daijishou_widget.abstract_widget_classes.WidgetFaceFragment
    public void onPreload() {
        String imagePath;
        super.onPreload();
        ImageBlockWidgetInstanceEntity imageBlockWidgetInstanceByIdStatically = getDaijishouWidgetRepository().getImageBlockWidgetInstanceByIdStatically(requireArguments().getLong("widgetInstanceId"));
        if (imageBlockWidgetInstanceByIdStatically == null || (imagePath = imageBlockWidgetInstanceByIdStatically.getImagePath()) == null) {
            return;
        }
        this.cachedImageFile = new File(imagePath);
    }

    private final void ensureWallpaperDirectory() {
        File file = new File(requireContext().getFilesDir() + "/image_block_widget_images/");
        if (file.exists()) {
            return;
        }
        file.mkdirs();
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        long j = requireArguments().getLong("widgetInstanceId");
        View viewInflate = inflater.inflate(R.layout.widget_face_image_block, container, false);
        ImageView imageView = (ImageView) viewInflate.findViewById(R.id.widget_face_image_block_image_view);
        Application application = requireActivity().getApplication();
        Intrinsics.checkNotNull(application, "null cannot be cast to non-null type com.magneticchen.daijishou.DaijishouApplication");
        DaijishouWidgetRepository daijishouWidgetRepository = ((DaijishouApplication) application).getDaijishouWidgetRepository();
        File file = this.cachedImageFile;
        if (file != null) {
            Glide.with(this).load((Object) file).signature(new ObjectKey(String.valueOf(this.imageCounter))).transition(DrawableTransitionOptions.withCrossFade()).into(imageView);
        }
        daijishouWidgetRepository.getImageBlockWidgetInstanceById(j).observe(getViewLifecycleOwner(), new ImageBlockWidgetFaceFragment$sam$androidx_lifecycle_Observer$0(new AnonymousClass2(imageView)));
        return viewInflate;
    }

    /* JADX INFO: renamed from: com.magneticchen.daijishou.daijishou_widget.widgets.image_block.ImageBlockWidgetFaceFragment$onCreateView$2, reason: invalid class name */
    /* JADX INFO: compiled from: ImageBlockWidgetFaceFragment.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lcom/magneticchen/daijishou/daijishou_widget/widget_db/ImageBlockWidgetInstanceEntity;", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
    final class AnonymousClass2 extends Lambda<Unit> implements Function1<ImageBlockWidgetInstanceEntity, Unit> {
        final /* synthetic */ ImageView $imageView;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(ImageView imageView) {
            super(1);
            this.$imageView = imageView;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ImageBlockWidgetInstanceEntity imageBlockWidgetInstanceEntity) {
            invoke2(imageBlockWidgetInstanceEntity);
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ImageBlockWidgetInstanceEntity imageBlockWidgetInstanceEntity) {
            String imagePath;
            if (imageBlockWidgetInstanceEntity != null) {
                ImageBlockWidgetFaceFragment imageBlockWidgetFaceFragment = ImageBlockWidgetFaceFragment.this;
                ImageView imageView = this.$imageView;
                if (Intrinsics.areEqual(imageBlockWidgetInstanceEntity.getLastUpdateTimestamp(), imageBlockWidgetFaceFragment.lastUpdateTimestamp) || (imagePath = imageBlockWidgetInstanceEntity.getImagePath()) == null) {
                    return;
                }
                imageBlockWidgetFaceFragment.cachedImageFile = new File(imagePath);
                imageBlockWidgetFaceFragment.getLogger().debug(imageBlockWidgetFaceFragment, "imagePath: " + imagePath + "\n" + imageBlockWidgetFaceFragment.cachedImageFile);
                try {
                    Glide.with(imageBlockWidgetFaceFragment).load((Object) imageBlockWidgetFaceFragment.cachedImageFile).signature(new ObjectKey(String.valueOf(imageBlockWidgetFaceFragment.imageCounter))).transition(DrawableTransitionOptions.withCrossFade()).into(imageView);
                } catch (Exception e) {
                    imageBlockWidgetFaceFragment.getLogger().error(imageBlockWidgetFaceFragment, ExceptionsKt.stackTraceToString(e));
                }
            }
        }
    }
}
