package com.magneticchen.daijishou.dialog_fragments;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.lifecycle.LifecycleOwnerKt;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.imageview.ShapeableImageView;
import com.google.android.material.progressindicator.LinearProgressIndicator;
import com.magneticchen.daijishou.R;
import com.magneticchen.daijishou.abstract_fragment_classes.DaijishouDialogFragment;
import com.magneticchen.daijishou.daijishou_library_db.portables.PlatformWallpapersPackIndexJson;
import com.magneticchen.daijishou.utils.Utils;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* INFO: compiled from: DownloadPlatformWallpapersPackDialogFragment.kt */
/* INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J&\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\b\u0010\u001d\u001a\u00020\u0014H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/magneticchen/daijishou/dialog_fragments/DownloadPlatformWallpapersPackDialogFragment;", "Lcom/magneticchen/daijishou/abstract_fragment_classes/DaijishouDialogFragment;", "()V", "description", "Landroid/widget/TextView;", "downloadButton", "Lcom/google/android/material/button/MaterialButton;", "downloadedString", "", "imageView", "Lcom/google/android/material/imageview/ShapeableImageView;", "linearProgressIndicator", "Lcom/google/android/material/progressindicator/LinearProgressIndicator;", "platformWallpapersPackIndexJson", "Lcom/magneticchen/daijishou/daijishou_library_db/portables/PlatformWallpapersPackIndexJson;", "sources", "sourcesTitle", "subtitle", "title", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onStart", "Companion", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class DownloadPlatformWallpapersPackDialogFragment extends DaijishouDialogFragment {

    /* INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public TextView description;
    public MaterialButton downloadButton;
    public String downloadedString;
    public ShapeableImageView imageView;
    public LinearProgressIndicator linearProgressIndicator;
    private PlatformWallpapersPackIndexJson platformWallpapersPackIndexJson;
    public TextView sources;
    private TextView sourcesTitle;
    public TextView subtitle;
    public TextView title;

    /* INFO: compiled from: DownloadPlatformWallpapersPackDialogFragment.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/magneticchen/daijishou/dialog_fragments/DownloadPlatformWallpapersPackDialogFragment$Companion;", "", "()V", "newInstance", "Lcom/magneticchen/daijishou/dialog_fragments/DownloadPlatformWallpapersPackDialogFragment;", "platformWallpaperPackUrlString", "", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final DownloadPlatformWallpapersPackDialogFragment newInstance(String platformWallpaperPackUrlString) {
            Intrinsics.checkNotNullParameter(platformWallpaperPackUrlString, "platformWallpaperPackUrlString");
            DownloadPlatformWallpapersPackDialogFragment downloadPlatformWallpapersPackDialogFragment = new DownloadPlatformWallpapersPackDialogFragment();
            Bundle bundle = new Bundle();
            bundle.putString("platformWallpaperPackUrlString", platformWallpaperPackUrlString);
            downloadPlatformWallpapersPackDialogFragment.setArguments(bundle);
            return downloadPlatformWallpapersPackDialogFragment;
        }
    }

    @Override // com.magneticchen.daijishou.abstract_fragment_classes.DaijishouDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String string = getString(R.string.downloaded);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        this.downloadedString = string;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        String string = requireArguments().getString("platformWallpaperPackUrlString");
        Intrinsics.checkNotNull(string);
        Dialog dialogRequireDialog = requireDialog();
        Intrinsics.checkNotNullExpressionValue(dialogRequireDialog, "requireDialog(...)");
        Intrinsics.checkNotNullExpressionValue(requireActivity(), "requireActivity(...)");
        Window window = dialogRequireDialog.getWindow();
        if (window != null) {
            window.setLayout(-2, -2);
        }
        Window window2 = dialogRequireDialog.getWindow();
        if (window2 != null) {
            window2.setFlags(1024, 1024);
        }
        Window window3 = dialogRequireDialog.getWindow();
        if (window3 != null) {
            window3.setBackgroundDrawable(AppCompatResources.getDrawable(requireContext(), R.drawable.dialog_background));
        }
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), Dispatchers.getIO(), null, new AnonymousClass1(string, dialogRequireDialog, null), 2, null);
    }

    /* INFO: renamed from: com.magneticchen.daijishou.dialog_fragments.DownloadPlatformWallpapersPackDialogFragment$onStart$1, reason: invalid class name */
    /* INFO: compiled from: DownloadPlatformWallpapersPackDialogFragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.magneticchen.daijishou.dialog_fragments.DownloadPlatformWallpapersPackDialogFragment$onStart$1", f = "DownloadPlatformWallpapersPackDialogFragment.kt", i = {}, l = {92, 149}, m = "invokeSuspendImpl", n = {}, s = {})
    final class AnonymousClass1 extends com.magneticchen.daijishou.support.DaijishouSuspendLambda implements Function2<CoroutineScope, Continuation<?>, Object> {
        final /* synthetic */ Dialog $dialog;
        final /* synthetic */ String $platformWallpaperPackUrlString;
        int label;

        /* WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(String str, Dialog dialog, Continuation<?> continuation) {
            super(2, continuation);
            this.$platformWallpaperPackUrlString = str;
            this.$dialog = dialog;
        }


        public final Continuation create(Object obj, Continuation<?> continuation) {
            return DownloadPlatformWallpapersPackDialogFragment.this.new AnonymousClass1(this.$platformWallpaperPackUrlString, this.$dialog, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<?> continuation) {
            try {
                try {
                    return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspendImpl(Unit.INSTANCE);
                } catch (Throwable th) {
                    throw com.magneticchen.daijishou.support.DaijishouSupport.sneakyThrow(th);
                }
            } catch (Throwable th) {
                throw com.magneticchen.daijishou.support.DaijishouSupport.sneakyThrow(th);
            }
        }

        public final Object invokeSuspendImpl(Object obj) throws Throwable {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                try {
                    DownloadPlatformWallpapersPackDialogFragment fragment = DownloadPlatformWallpapersPackDialogFragment.this;
                    PlatformWallpapersPackIndexJson packIndex = (PlatformWallpapersPackIndexJson) fragment.getWeakJson().decodeFromString(
                        PlatformWallpapersPackIndexJson.INSTANCE.serializer(),
                        Utils.INSTANCE.readEntireTextFromURL(this.$platformWallpaperPackUrlString + "index.json")
                    );
                    fragment.platformWallpapersPackIndexJson = packIndex;
                    if (packIndex != null) {
                        DownloadPlatformWallpapersPackDialogFragment$onStart$1$1$1 callback = new DownloadPlatformWallpapersPackDialogFragment$onStart$1$1$1(
                            packIndex, fragment, this.$dialog, this.$platformWallpaperPackUrlString, null
                        );
                        this.label = 1;
                        if (BuildersKt.withContext(Dispatchers.getMain(), callback, this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    }
                } catch (Exception e) {
                    AnonymousClass2 errorCallback = new AnonymousClass2(DownloadPlatformWallpapersPackDialogFragment.this, e, null);
                    this.label = 2;
                    if (BuildersKt.withContext(Dispatchers.getMain(), errorCallback, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
            } else if (i == 1) {
                try {
                    ResultKt.throwOnFailure(obj);
                } catch (Exception e) {
                    AnonymousClass2 errorCallback = new AnonymousClass2(DownloadPlatformWallpapersPackDialogFragment.this, e, null);
                    this.label = 2;
                    if (BuildersKt.withContext(Dispatchers.getMain(), errorCallback, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
            } else if (i == 2) {
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return Unit.INSTANCE;
        }

        /* INFO: renamed from: com.magneticchen.daijishou.dialog_fragments.DownloadPlatformWallpapersPackDialogFragment$onStart$1$2, reason: invalid class name */
        /* INFO: compiled from: DownloadPlatformWallpapersPackDialogFragment.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
        @DebugMetadata(c = "com.magneticchen.daijishou.dialog_fragments.DownloadPlatformWallpapersPackDialogFragment$onStart$1$2", f = "DownloadPlatformWallpapersPackDialogFragment.kt", i = {}, l = {}, m = "invokeSuspendImpl", n = {}, s = {})
        final class AnonymousClass2 extends com.magneticchen.daijishou.support.DaijishouSuspendLambda implements Function2<CoroutineScope, Continuation<?>, Object> {
            final /* synthetic */ Exception $e;
            int label;
            final /* synthetic */ DownloadPlatformWallpapersPackDialogFragment this$0;

            /* WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass2(DownloadPlatformWallpapersPackDialogFragment downloadPlatformWallpapersPackDialogFragment, Exception exc, Continuation<?> continuation) {
                super(2, continuation);
                this.this$0 = downloadPlatformWallpapersPackDialogFragment;
                this.$e = exc;
            }


            public final Continuation create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass2(this.this$0, this.$e, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<?> continuation) {
                try {
                    try {
                        return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspendImpl(Unit.INSTANCE);
                    } catch (Throwable th) {
                        throw com.magneticchen.daijishou.support.DaijishouSupport.sneakyThrow(th);
                    }
                } catch (Throwable th) {
                    throw com.magneticchen.daijishou.support.DaijishouSupport.sneakyThrow(th);
                }
            }

            public final Object invokeSuspendImpl(Object obj) throws Throwable {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                Toast.makeText(this.this$0.getContext(), this.$e.toString(), 0).show();
                return Unit.INSTANCE;
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        View viewInflate = inflater.inflate(R.layout.fragment_download_platform_wallpaper_pack_dialog, container, false);
        View viewFindViewById = viewInflate.findViewById(R.id.fragment_download_platform_wallpaper_pack_dialog_image_view);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        this.imageView = (ShapeableImageView) viewFindViewById;
        View viewFindViewById2 = viewInflate.findViewById(R.id.fragment_download_platform_wallpaper_pack_dialog_title);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
        this.title = (TextView) viewFindViewById2;
        View viewFindViewById3 = viewInflate.findViewById(R.id.fragment_download_platform_wallpaper_pack_dialog_subtitle);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById3, "findViewById(...)");
        this.subtitle = (TextView) viewFindViewById3;
        View viewFindViewById4 = viewInflate.findViewById(R.id.fragment_download_platform_wallpaper_pack_dialog_description);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById4, "findViewById(...)");
        this.description = (TextView) viewFindViewById4;
        View viewFindViewById5 = viewInflate.findViewById(R.id.fragment_download_platform_wallpaper_pack_dialog_sources_title);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById5, "findViewById(...)");
        this.sourcesTitle = (TextView) viewFindViewById5;
        View viewFindViewById6 = viewInflate.findViewById(R.id.fragment_download_platform_wallpaper_pack_dialog_sources);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById6, "findViewById(...)");
        this.sources = (TextView) viewFindViewById6;
        View viewFindViewById7 = viewInflate.findViewById(R.id.fragment_download_platform_wallpaper_pack_dialog_progress_bar);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById7, "findViewById(...)");
        this.linearProgressIndicator = (LinearProgressIndicator) viewFindViewById7;
        View viewFindViewById8 = viewInflate.findViewById(R.id.fragment_download_platform_wallpaper_pack_dialog_download_button);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById8, "findViewById(...)");
        MaterialButton materialButton = (MaterialButton) viewFindViewById8;
        this.downloadButton = materialButton;
        if (materialButton == null) {
            Intrinsics.throwUninitializedPropertyAccessException("downloadButton");
            materialButton = null;
        }
        materialButton.setEnabled(false);
        return viewInflate;
    }
}
