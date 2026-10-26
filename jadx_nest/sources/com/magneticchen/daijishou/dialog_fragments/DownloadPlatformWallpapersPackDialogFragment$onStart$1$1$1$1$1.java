package com.magneticchen.daijishou.dialog_fragments;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.progressindicator.LinearProgressIndicator;
import com.magneticchen.daijishou.R;
import com.magneticchen.daijishou.application_data.StringPreference;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* INFO: compiled from: DownloadPlatformWallpapersPackDialogFragment.kt */
/* INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
final class DownloadPlatformWallpapersPackDialogFragment$onStart$1$1$1$1$1 extends Lambda<Unit> implements Function0<Unit> {
    final /* synthetic */ String $platformWallpaperPackUrlString;
    final /* synthetic */ DownloadPlatformWallpapersPackDialogFragment this$0;

    /* WARN: 'super' call moved to the top of the method (can break code semantics) */
    DownloadPlatformWallpapersPackDialogFragment$onStart$1$1$1$1$1(DownloadPlatformWallpapersPackDialogFragment downloadPlatformWallpapersPackDialogFragment, String str) {
        super(0);
        this.this$0 = downloadPlatformWallpapersPackDialogFragment;
        this.$platformWallpaperPackUrlString = str;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }

    /* INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        this.this$0.getDefaultSharedPreferences().edit().putString(StringPreference.SELECTED_PLATFORM_WALLPAPERS_PACK_URL_STRING.getKey(), this.$platformWallpaperPackUrlString).apply();
        this.this$0.setCancelable(false);
        LinearProgressIndicator linearProgressIndicator = this.this$0.linearProgressIndicator;
        MaterialButton materialButton = null;
        if (linearProgressIndicator == null) {
            Intrinsics.throwUninitializedPropertyAccessException("linearProgressIndicator");
            linearProgressIndicator = null;
        }
        linearProgressIndicator.setVisibility(0);
        LinearProgressIndicator linearProgressIndicator2 = this.this$0.linearProgressIndicator;
        if (linearProgressIndicator2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("linearProgressIndicator");
            linearProgressIndicator2 = null;
        }
        linearProgressIndicator2.setIndeterminate(false);
        LinearProgressIndicator linearProgressIndicator3 = this.this$0.linearProgressIndicator;
        if (linearProgressIndicator3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("linearProgressIndicator");
            linearProgressIndicator3 = null;
        }
        linearProgressIndicator3.setProgress(1);
        MaterialButton materialButton2 = this.this$0.downloadButton;
        if (materialButton2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("downloadButton");
            materialButton2 = null;
        }
        materialButton2.setEnabled(false);
        MaterialButton materialButton3 = this.this$0.downloadButton;
        if (materialButton3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("downloadButton");
        } else {
            materialButton = materialButton3;
        }
        materialButton.setText(this.this$0.getString(R.string.downloading));
        this.this$0.getDaijishouLibrary().applyPlatformPreviewMediaPackIndexJsonToAllPlatforms(this.$platformWallpaperPackUrlString, 0, new AnonymousClass1(this.this$0));
    }

    /* INFO: renamed from: com.magneticchen.daijishou.dialog_fragments.DownloadPlatformWallpapersPackDialogFragment$onStart$1$1$1$1$1$1, reason: invalid class name */
    /* INFO: compiled from: DownloadPlatformWallpapersPackDialogFragment.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "finished", "", "progress", "", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
    static final class AnonymousClass1 extends Lambda<Unit> implements Function2<Boolean, Integer, Unit> {
        final /* synthetic */ DownloadPlatformWallpapersPackDialogFragment this$0;

        /* WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(DownloadPlatformWallpapersPackDialogFragment downloadPlatformWallpapersPackDialogFragment) {
            super(2);
            this.this$0 = downloadPlatformWallpapersPackDialogFragment;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Boolean bool, Integer num) {
            invoke(bool.booleanValue(), num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(boolean z, int i) {
            LinearProgressIndicator linearProgressIndicator = null;
            String str = null;
            if (!z) {
                if (i != -1) {
                    LinearProgressIndicator linearProgressIndicator2 = this.this$0.linearProgressIndicator;
                    if (linearProgressIndicator2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("linearProgressIndicator");
                    } else {
                        linearProgressIndicator = linearProgressIndicator2;
                    }
                    linearProgressIndicator.setProgress(i);
                    return;
                }
                return;
            }
            this.this$0.setCancelable(true);
            LinearProgressIndicator linearProgressIndicator3 = this.this$0.linearProgressIndicator;
            if (linearProgressIndicator3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("linearProgressIndicator");
                linearProgressIndicator3 = null;
            }
            linearProgressIndicator3.setVisibility(8);
            LinearProgressIndicator linearProgressIndicator4 = this.this$0.linearProgressIndicator;
            if (linearProgressIndicator4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("linearProgressIndicator");
                linearProgressIndicator4 = null;
            }
            linearProgressIndicator4.setProgress(100);
            MaterialButton materialButton = this.this$0.downloadButton;
            if (materialButton == null) {
                Intrinsics.throwUninitializedPropertyAccessException("downloadButton");
                materialButton = null;
            }
            materialButton.setEnabled(false);
            MaterialButton materialButton2 = this.this$0.downloadButton;
            if (materialButton2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("downloadButton");
                materialButton2 = null;
            }
            String str2 = this.this$0.downloadedString;
            if (str2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("downloadedString");
            } else {
                str = str2;
            }
            materialButton2.setText(str);
        }
    }
}
