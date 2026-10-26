package com.magneticchen.daijishou.dialog_fragments;

import android.app.Dialog;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.imageview.ShapeableImageView;
import com.google.android.material.progressindicator.LinearProgressIndicator;
import com.magneticchen.daijishou.R;
import com.magneticchen.daijishou.application_data.BooleanPreference;
import com.magneticchen.daijishou.daijishou_library_db.portables.PlatformWallpapersPackIndexJson;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlinx.coroutines.CoroutineScope;

/* INFO: compiled from: DownloadPlatformWallpapersPackDialogFragment.kt */
/* INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.magneticchen.daijishou.dialog_fragments.DownloadPlatformWallpapersPackDialogFragment$onStart$1$1$1", f = "DownloadPlatformWallpapersPackDialogFragment.kt", i = {}, l = {}, m = "invokeSuspendImpl", n = {}, s = {})
final class DownloadPlatformWallpapersPackDialogFragment$onStart$1$1$1 extends com.magneticchen.daijishou.support.DaijishouSuspendLambda implements Function2<CoroutineScope, Continuation<?>, Object> {
    final /* synthetic */ Dialog $dialog;
    final /* synthetic */ PlatformWallpapersPackIndexJson $it;
    final /* synthetic */ String $platformWallpaperPackUrlString;
    int label;
    final /* synthetic */ DownloadPlatformWallpapersPackDialogFragment this$0;

    /* WARN: 'super' call moved to the top of the method (can break code semantics) */
    DownloadPlatformWallpapersPackDialogFragment$onStart$1$1$1(PlatformWallpapersPackIndexJson platformWallpapersPackIndexJson, DownloadPlatformWallpapersPackDialogFragment downloadPlatformWallpapersPackDialogFragment, Dialog dialog, String str, Continuation<?> continuation) {
        super(2, continuation);
        this.$it = platformWallpapersPackIndexJson;
        this.this$0 = downloadPlatformWallpapersPackDialogFragment;
        this.$dialog = dialog;
        this.$platformWallpaperPackUrlString = str;
    }


    public final Continuation create(Object obj, Continuation<?> continuation) {
        return new DownloadPlatformWallpapersPackDialogFragment$onStart$1$1$1(this.$it, this.this$0, this.$dialog, this.$platformWallpaperPackUrlString, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<?> continuation) {
        try {
            return ((DownloadPlatformWallpapersPackDialogFragment$onStart$1$1$1) create(coroutineScope, continuation)).invokeSuspendImpl(Unit.INSTANCE);
        } catch (Throwable th) {
            throw com.magneticchen.daijishou.support.DaijishouSupport.sneakyThrow(th);
        }
    }

    public final Object invokeSuspendImpl(Object obj) throws Throwable {
        String string;
        StringBuilder sb;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        if (!this.$it.isNSFW() || this.this$0.getDefaultSharedPreferences().getBoolean(BooleanPreference.USE_NSFW.getKey(), BooleanPreference.USE_NSFW.getDefaultValue())) {
            TextView textView = this.this$0.title;
            MaterialButton materialButton = null;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("title");
                textView = null;
            }
            textView.setText(this.$it.getName());
            TextView textView2 = this.this$0.subtitle;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("subtitle");
                textView2 = null;
            }
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String string2 = this.this$0.getString(R.string.authors_format);
            Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
            String str = String.format(string2, Arrays.copyOf(new Object[]{CollectionsKt.joinToString$default(this.$it.getAuthors(), ", ", null, null, 0, null, null, 62, null)}, 1));
            Intrinsics.checkNotNullExpressionValue(str, "format(...)");
            if (this.$it.getHasDefaultWallpaper()) {
                string = this.this$0.getString(R.string.default_wallpaper_included);
                sb = new StringBuilder("\n");
            } else {
                string = this.this$0.getString(R.string.default_wallpaper_not_included);
                sb = new StringBuilder("\n");
            }
            textView2.setText(str + sb.append(string).toString());
            TextView textView3 = this.this$0.description;
            if (textView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("description");
                textView3 = null;
            }
            textView3.setText(this.$it.getDescription());
            TextView textView4 = this.this$0.sources;
            if (textView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("sources");
                textView4 = null;
            }
            textView4.setText(CollectionsKt.joinToString$default(this.$it.getSources(), "\n", null, null, 0, null, null, 62, null));
            RequestBuilder<Drawable> requestBuilderLoad = Glide.with(this.this$0).load((Object) this.$platformWallpaperPackUrlString + this.$it.getPreviewThumbnailFilename());
            ShapeableImageView shapeableImageView = this.this$0.imageView;
            if (shapeableImageView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("imageView");
                shapeableImageView = null;
            }
            requestBuilderLoad.into(shapeableImageView);
            LinearProgressIndicator linearProgressIndicator = this.this$0.linearProgressIndicator;
            if (linearProgressIndicator == null) {
                Intrinsics.throwUninitializedPropertyAccessException("linearProgressIndicator");
                linearProgressIndicator = null;
            }
            linearProgressIndicator.setVisibility(8);
            MaterialButton materialButton2 = this.this$0.downloadButton;
            if (materialButton2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("downloadButton");
                materialButton2 = null;
            }
            materialButton2.setOnClickListener(new DownloadPlatformWallpapersPackDialogFragment$onStart$1$1$1$$ExternalSyntheticLambda0(this.this$0, this.$platformWallpaperPackUrlString));
            MaterialButton materialButton3 = this.this$0.downloadButton;
            if (materialButton3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("downloadButton");
            } else {
                materialButton = materialButton3;
            }
            materialButton.setEnabled(true);
            this.this$0.requireView().requestLayout();
            return Unit.INSTANCE;
        }
        Toast.makeText(this.this$0.requireContext(), this.this$0.getString(R.string.aborted_period), 0).show();
        this.$dialog.dismiss();
        return Unit.INSTANCE;
    }

    /* INFO: Access modifiers changed from: private */
    public static final void invokeSuspendImpl$lambda$0(DownloadPlatformWallpapersPackDialogFragment downloadPlatformWallpapersPackDialogFragment, String str, View view) {
        AcknowledgementDialogFragment.Companion.newInstance$default(AcknowledgementDialogFragment.INSTANCE, downloadPlatformWallpapersPackDialogFragment.getString(R.string.are_you_sure), downloadPlatformWallpapersPackDialogFragment.getString(R.string.replace_wallpaper_warning), null, null, null, 28, null).setOnAcknowledgedListener(new DownloadPlatformWallpapersPackDialogFragment$onStart$1$1$1$1$1(downloadPlatformWallpapersPackDialogFragment, str)).setOnCanceledListener(DownloadPlatformWallpapersPackDialogFragment$onStart$1$1$1$1$2.INSTANCE).show(downloadPlatformWallpapersPackDialogFragment.getParentFragmentManager(), AcknowledgementDialogFragment.class.getName());
    }
}
