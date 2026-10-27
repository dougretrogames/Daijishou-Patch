package com.magneticchen.daijishou.ui.fragments.dialog;

import android.app.Dialog;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.imageview.ShapeableImageView;
import com.google.android.material.progressindicator.LinearProgressIndicator;
import com.magneticchen.daijishou.R;
import com.magneticchen.daijishou.data.BooleanPreference;
import com.magneticchen.daijishou.data.StringPreference;
import com.magneticchen.daijishou.data.portables.PlatformThumbnailsPackIndexJson;
import com.magneticchen.daijishou.ui.model.DaijishouLibraryModel;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: DownloadPlatformThumbnailsPackDialogFragment.kt */
/* JADX INFO: loaded from: C:\Users\dfukuoka\Downloads\Daijishou\Daijishou\build_tmp\dex181_classes4.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.magneticchen.daijishou.ui.fragments.dialog.DownloadPlatformThumbnailsPackDialogFragment$onStart$1$1$1", f = "DownloadPlatformThumbnailsPackDialogFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class DownloadPlatformThumbnailsPackDialogFragment$onStart$1$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Dialog $dialog;
    final /* synthetic */ PlatformThumbnailsPackIndexJson $it;
    final /* synthetic */ String $platformThumbnailPackUrlString;
    int label;
    final /* synthetic */ DownloadPlatformThumbnailsPackDialogFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    DownloadPlatformThumbnailsPackDialogFragment$onStart$1$1$1(PlatformThumbnailsPackIndexJson platformThumbnailsPackIndexJson, DownloadPlatformThumbnailsPackDialogFragment downloadPlatformThumbnailsPackDialogFragment, Dialog dialog, String str, Continuation<? super DownloadPlatformThumbnailsPackDialogFragment$onStart$1$1$1> continuation) {
        super(2, continuation);
        this.$it = platformThumbnailsPackIndexJson;
        this.this$0 = downloadPlatformThumbnailsPackDialogFragment;
        this.$dialog = dialog;
        this.$platformThumbnailPackUrlString = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DownloadPlatformThumbnailsPackDialogFragment$onStart$1$1$1(this.$it, this.this$0, this.$dialog, this.$platformThumbnailPackUrlString, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((DownloadPlatformThumbnailsPackDialogFragment$onStart$1$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
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
            String string = this.this$0.getString(R.string.authors_format);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            String str = String.format(string, Arrays.copyOf(new Object[]{CollectionsKt.joinToString$default(this.$it.getAuthors(), ", ", null, null, 0, null, null, 62, null)}, 1));
            Intrinsics.checkNotNullExpressionValue(str, "format(...)");
            textView2.setText(str + (this.$it.getHasDefaultThumbnail() ? "\nDefault thumbnails is included." : "\nDefault thumbnails is not included."));
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
            RequestBuilder requestBuilderLoad = Glide.with(this.this$0).load(this.$platformThumbnailPackUrlString + this.$it.getPreviewThumbnailFilename());
            ShapeableImageView shapeableImageView = this.this$0.imageView;
            if (shapeableImageView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("imageView");
                shapeableImageView = null;
            }
            requestBuilderLoad.into((ImageView) shapeableImageView);
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
            final DownloadPlatformThumbnailsPackDialogFragment downloadPlatformThumbnailsPackDialogFragment = this.this$0;
            final String str2 = this.$platformThumbnailPackUrlString;
            materialButton2.setOnClickListener(new View.OnClickListener() { // from class: com.magneticchen.daijishou.ui.fragments.dialog.DownloadPlatformThumbnailsPackDialogFragment$onStart$1$1$1$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    DownloadPlatformThumbnailsPackDialogFragment$onStart$1$1$1.invokeSuspend$lambda$0(downloadPlatformThumbnailsPackDialogFragment, str2, view);
                }
            });
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

    /* JADX INFO: Access modifiers changed from: private */
    public static final void invokeSuspend$lambda$0(final DownloadPlatformThumbnailsPackDialogFragment downloadPlatformThumbnailsPackDialogFragment, final String str, View view) {
        AcknowledgementDialogFragment.Companion.newInstance$default(AcknowledgementDialogFragment.Companion, downloadPlatformThumbnailsPackDialogFragment.getString(R.string.are_you_sure), "This will replace your all of your thumbnails.", null, null, null, 28, null).setOnAcknowledgedListener(new Function0<Unit>() { // from class: com.magneticchen.daijishou.ui.fragments.dialog.DownloadPlatformThumbnailsPackDialogFragment$onStart$1$1$1$1$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                downloadPlatformThumbnailsPackDialogFragment.getDefaultSharedPreferences().edit().putString(StringPreference.SELECTED_PLATFORM_THUMBNAILS_PACK_URL_STRING.getKey(), str).apply();
                downloadPlatformThumbnailsPackDialogFragment.setCancelable(false);
                LinearProgressIndicator linearProgressIndicator = downloadPlatformThumbnailsPackDialogFragment.linearProgressIndicator;
                MaterialButton materialButton = null;
                if (linearProgressIndicator == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("linearProgressIndicator");
                    linearProgressIndicator = null;
                }
                linearProgressIndicator.setVisibility(0);
                LinearProgressIndicator linearProgressIndicator2 = downloadPlatformThumbnailsPackDialogFragment.linearProgressIndicator;
                if (linearProgressIndicator2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("linearProgressIndicator");
                    linearProgressIndicator2 = null;
                }
                linearProgressIndicator2.setIndeterminate(false);
                LinearProgressIndicator linearProgressIndicator3 = downloadPlatformThumbnailsPackDialogFragment.linearProgressIndicator;
                if (linearProgressIndicator3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("linearProgressIndicator");
                    linearProgressIndicator3 = null;
                }
                linearProgressIndicator3.setProgress(1);
                MaterialButton materialButton2 = downloadPlatformThumbnailsPackDialogFragment.downloadButton;
                if (materialButton2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("downloadButton");
                    materialButton2 = null;
                }
                materialButton2.setEnabled(false);
                MaterialButton materialButton3 = downloadPlatformThumbnailsPackDialogFragment.downloadButton;
                if (materialButton3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("downloadButton");
                } else {
                    materialButton = materialButton3;
                }
                materialButton.setText(downloadPlatformThumbnailsPackDialogFragment.getString(R.string.downloading));
                DaijishouLibraryModel daijishouLibrary = downloadPlatformThumbnailsPackDialogFragment.getDaijishouLibrary();
                String str2 = str;
                final DownloadPlatformThumbnailsPackDialogFragment downloadPlatformThumbnailsPackDialogFragment2 = downloadPlatformThumbnailsPackDialogFragment;
                daijishouLibrary.applyPlatformPreviewMediaPackIndexJsonToAllPlatforms(str2, 1, new Function2<Boolean, Integer, Unit>() { // from class: com.magneticchen.daijishou.ui.fragments.dialog.DownloadPlatformThumbnailsPackDialogFragment$onStart$1$1$1$1$1.1
                    

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Boolean bool, Integer num) {
                        invoke(bool.booleanValue(), num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(boolean z, int i) {
                        CharSequence charSequence = null;
                        if (!z) {
                            if (i != -1) {
                                CharSequence charSequence2 = downloadPlatformThumbnailsPackDialogFragment2.linearProgressIndicator;
                                if (charSequence2 == null) {
                                    Intrinsics.throwUninitializedPropertyAccessException("linearProgressIndicator");
                                } else {
                                    charSequence = charSequence2;
                                }
                                charSequence.setProgress(i);
                                return;
                            }
                            return;
                        }
                        downloadPlatformThumbnailsPackDialogFragment2.setCancelable(true);
                        LinearProgressIndicator linearProgressIndicator4 = downloadPlatformThumbnailsPackDialogFragment2.linearProgressIndicator;
                        if (linearProgressIndicator4 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("linearProgressIndicator");
                            linearProgressIndicator4 = null;
                        }
                        linearProgressIndicator4.setVisibility(8);
                        LinearProgressIndicator linearProgressIndicator5 = downloadPlatformThumbnailsPackDialogFragment2.linearProgressIndicator;
                        if (linearProgressIndicator5 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("linearProgressIndicator");
                            linearProgressIndicator5 = null;
                        }
                        linearProgressIndicator5.setProgress(100);
                        MaterialButton materialButton4 = downloadPlatformThumbnailsPackDialogFragment2.downloadButton;
                        if (materialButton4 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("downloadButton");
                            materialButton4 = null;
                        }
                        materialButton4.setEnabled(false);
                        MaterialButton materialButton5 = downloadPlatformThumbnailsPackDialogFragment2.downloadButton;
                        if (materialButton5 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("downloadButton");
                            materialButton5 = null;
                        }
                        CharSequence charSequence3 = downloadPlatformThumbnailsPackDialogFragment2.downloadedString;
                        if (charSequence3 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("downloadedString");
                        } else {
                            charSequence = charSequence3;
                        }
                        materialButton5.setText(charSequence);
                    }
                });
            }
        }).setOnCanceledListener(new Function0<Unit>() { // from class: com.magneticchen.daijishou.ui.fragments.dialog.DownloadPlatformThumbnailsPackDialogFragment$onStart$1$1$1$1$2
            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }
        }).show(downloadPlatformThumbnailsPackDialogFragment.getParentFragmentManager(), AcknowledgementDialogFragment.class.getName());
    }
}
