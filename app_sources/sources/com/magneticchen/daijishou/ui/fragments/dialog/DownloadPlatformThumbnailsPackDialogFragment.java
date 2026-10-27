package com.magneticchen.daijishou.ui.fragments.dialog;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.imageview.ShapeableImageView;
import com.google.android.material.progressindicator.LinearProgressIndicator;
import com.magneticchen.daijishou.R;
import com.magneticchen.daijishou.data.portables.PlatformThumbnailsPackIndexJson;
import com.magneticchen.daijishou.ui.fragments.p000abstract.DaijishouDialogFragment;
import com.magneticchen.daijishou.ui.widget.widgets.category.CategoryWidgetViewModel;
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
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: compiled from: DownloadPlatformThumbnailsPackDialogFragment.kt */
/* JADX INFO: loaded from: C:\Users\dfukuoka\Downloads\Daijishou\Daijishou\build_tmp\dex181_classes4.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J&\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\b\u0010\u001d\u001a\u00020\u0014H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/magneticchen/daijishou/ui/fragments/dialog/DownloadPlatformThumbnailsPackDialogFragment;", "Lcom/magneticchen/daijishou/ui/fragments/abstract/DaijishouDialogFragment;", "()V", "description", "Landroid/widget/TextView;", "downloadButton", "Lcom/google/android/material/button/MaterialButton;", "downloadedString", "", "imageView", "Lcom/google/android/material/imageview/ShapeableImageView;", "linearProgressIndicator", "Lcom/google/android/material/progressindicator/LinearProgressIndicator;", "platformThumbnailsPackIndexJson", "Lcom/magneticchen/daijishou/data/portables/PlatformThumbnailsPackIndexJson;", "sources", "sourcesTitle", "subtitle", "title", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onStart", "Companion", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class DownloadPlatformThumbnailsPackDialogFragment extends DaijishouDialogFragment {
    public static final Companion Companion = new Companion(null);
    private TextView description;
    private MaterialButton downloadButton;
    private String downloadedString;
    private ShapeableImageView imageView;
    private LinearProgressIndicator linearProgressIndicator;
    private PlatformThumbnailsPackIndexJson platformThumbnailsPackIndexJson;
    private TextView sources;
    private TextView sourcesTitle;
    private TextView subtitle;
    private TextView title;

    /* JADX INFO: compiled from: DownloadPlatformThumbnailsPackDialogFragment.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/magneticchen/daijishou/ui/fragments/dialog/DownloadPlatformThumbnailsPackDialogFragment$Companion;", "", "()V", "newInstance", "Lcom/magneticchen/daijishou/ui/fragments/dialog/DownloadPlatformThumbnailsPackDialogFragment;", "platformThumbnailPackUrlString", "", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final DownloadPlatformThumbnailsPackDialogFragment newInstance(String platformThumbnailPackUrlString) {
            Intrinsics.checkNotNullParameter(platformThumbnailPackUrlString, "platformThumbnailPackUrlString");
            DownloadPlatformThumbnailsPackDialogFragment downloadPlatformThumbnailsPackDialogFragment = new DownloadPlatformThumbnailsPackDialogFragment();
            Bundle bundle = new Bundle();
            bundle.putString("platformThumbnailPackUrlString", platformThumbnailPackUrlString);
            downloadPlatformThumbnailsPackDialogFragment.setArguments(bundle);
            return downloadPlatformThumbnailsPackDialogFragment;
        }
    }

    @Override // com.magneticchen.daijishou.ui.fragments.p000abstract.DaijishouDialogFragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        String string = getString(R.string.downloaded);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        this.downloadedString = string;
    }

    public void onStart() {
        super.onStart();
        String string = requireArguments().getString("platformThumbnailPackUrlString");
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
            window2.setFlags(CategoryWidgetViewModel.LIMIT, CategoryWidgetViewModel.LIMIT);
        }
        Window window3 = dialogRequireDialog.getWindow();
        if (window3 != null) {
            window3.setBackgroundDrawable(AppCompatResources.getDrawable(requireContext(), R.drawable.dialog_background));
        }
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) this), Dispatchers.getIO(), (CoroutineStart) null, new AnonymousClass1(string, dialogRequireDialog, null), 2, (Object) null);
    }

    /* JADX INFO: renamed from: com.magneticchen.daijishou.ui.fragments.dialog.DownloadPlatformThumbnailsPackDialogFragment$onStart$1, reason: invalid class name */
    /* JADX INFO: compiled from: DownloadPlatformThumbnailsPackDialogFragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.magneticchen.daijishou.ui.fragments.dialog.DownloadPlatformThumbnailsPackDialogFragment$onStart$1", f = "DownloadPlatformThumbnailsPackDialogFragment.kt", i = {}, l = {92, 149}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Dialog $dialog;
        final /* synthetic */ String $platformThumbnailPackUrlString;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(String str, Dialog dialog, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$platformThumbnailPackUrlString = str;
            this.$dialog = dialog;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return DownloadPlatformThumbnailsPackDialogFragment.this.new AnonymousClass1(this.$platformThumbnailPackUrlString, this.$dialog, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:15:0x0077, code lost:
        
            if (kotlinx.coroutines.BuildersKt.withContext(r11, r4, r10) == r1) goto L20;
         */
        /* JADX WARN: Code restructure failed: missing block: B:19:0x0095, code lost:
        
            if (kotlinx.coroutines.BuildersKt.withContext(kotlinx.coroutines.Dispatchers.getMain(), new com.magneticchen.daijishou.ui.fragments.dialog.DownloadPlatformThumbnailsPackDialogFragment.AnonymousClass1.AnonymousClass2(r10.this$0, r0, null), r10) == r1) goto L20;
         */
        /* JADX WARN: Code restructure failed: missing block: B:20:0x0097, code lost:
        
            return r1;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r11) {
            /*
                r10 = this;
                java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r0 = r10.label
                r2 = 2
                r3 = 1
                if (r0 == 0) goto L20
                if (r0 == r3) goto L1b
                if (r0 != r2) goto L13
                kotlin.ResultKt.throwOnFailure(r11)
                goto L98
            L13:
                java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r11.<init>(r0)
                throw r11
            L1b:
                kotlin.ResultKt.throwOnFailure(r11)     // Catch: java.lang.Exception -> L7a
                goto L98
            L20:
                kotlin.ResultKt.throwOnFailure(r11)
                com.magneticchen.daijishou.ui.fragments.dialog.DownloadPlatformThumbnailsPackDialogFragment r11 = com.magneticchen.daijishou.ui.fragments.dialog.DownloadPlatformThumbnailsPackDialogFragment.this     // Catch: java.lang.Exception -> L7a
                kotlinx.serialization.json.Json r0 = com.magneticchen.daijishou.ui.fragments.dialog.DownloadPlatformThumbnailsPackDialogFragment.access$getWeakJson(r11)     // Catch: java.lang.Exception -> L7a
                com.magneticchen.daijishou.data.portables.PlatformThumbnailsPackIndexJson$Companion r4 = com.magneticchen.daijishou.data.portables.PlatformThumbnailsPackIndexJson.Companion     // Catch: java.lang.Exception -> L7a
                kotlinx.serialization.KSerializer r4 = r4.serializer()     // Catch: java.lang.Exception -> L7a
                kotlinx.serialization.DeserializationStrategy r4 = (kotlinx.serialization.DeserializationStrategy) r4     // Catch: java.lang.Exception -> L7a
                com.magneticchen.daijishou.utils.Utils r5 = com.magneticchen.daijishou.utils.Utils.INSTANCE     // Catch: java.lang.Exception -> L7a
                java.lang.String r6 = r10.$platformThumbnailPackUrlString     // Catch: java.lang.Exception -> L7a
                java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L7a
                r7.<init>()     // Catch: java.lang.Exception -> L7a
                java.lang.StringBuilder r6 = r7.append(r6)     // Catch: java.lang.Exception -> L7a
                java.lang.String r7 = "index.json"
                java.lang.StringBuilder r6 = r6.append(r7)     // Catch: java.lang.Exception -> L7a
                java.lang.String r6 = r6.toString()     // Catch: java.lang.Exception -> L7a
                java.lang.String r5 = r5.readEntireTextFromURL(r6)     // Catch: java.lang.Exception -> L7a
                java.lang.Object r0 = r0.decodeFromString(r4, r5)     // Catch: java.lang.Exception -> L7a
                com.magneticchen.daijishou.data.portables.PlatformThumbnailsPackIndexJson r0 = (com.magneticchen.daijishou.data.portables.PlatformThumbnailsPackIndexJson) r0     // Catch: java.lang.Exception -> L7a
                com.magneticchen.daijishou.ui.fragments.dialog.DownloadPlatformThumbnailsPackDialogFragment.access$setPlatformThumbnailsPackIndexJson$p(r11, r0)     // Catch: java.lang.Exception -> L7a
                com.magneticchen.daijishou.ui.fragments.dialog.DownloadPlatformThumbnailsPackDialogFragment r11 = com.magneticchen.daijishou.ui.fragments.dialog.DownloadPlatformThumbnailsPackDialogFragment.this     // Catch: java.lang.Exception -> L7a
                com.magneticchen.daijishou.data.portables.PlatformThumbnailsPackIndexJson r5 = com.magneticchen.daijishou.ui.fragments.dialog.DownloadPlatformThumbnailsPackDialogFragment.access$getPlatformThumbnailsPackIndexJson$p(r11)     // Catch: java.lang.Exception -> L7a
                if (r5 == 0) goto L98
                com.magneticchen.daijishou.ui.fragments.dialog.DownloadPlatformThumbnailsPackDialogFragment r6 = com.magneticchen.daijishou.ui.fragments.dialog.DownloadPlatformThumbnailsPackDialogFragment.this     // Catch: java.lang.Exception -> L7a
                android.app.Dialog r7 = r10.$dialog     // Catch: java.lang.Exception -> L7a
                java.lang.String r8 = r10.$platformThumbnailPackUrlString     // Catch: java.lang.Exception -> L7a
                kotlinx.coroutines.MainCoroutineDispatcher r11 = kotlinx.coroutines.Dispatchers.getMain()     // Catch: java.lang.Exception -> L7a
                kotlin.coroutines.CoroutineContext r11 = (kotlin.coroutines.CoroutineContext) r11     // Catch: java.lang.Exception -> L7a
                com.magneticchen.daijishou.ui.fragments.dialog.DownloadPlatformThumbnailsPackDialogFragment$onStart$1$1$1 r4 = new com.magneticchen.daijishou.ui.fragments.dialog.DownloadPlatformThumbnailsPackDialogFragment$onStart$1$1$1     // Catch: java.lang.Exception -> L7a
                r9 = 0
                r4.<init>(r5, r6, r7, r8, r9)     // Catch: java.lang.Exception -> L7a
                kotlin.jvm.functions.Function2 r4 = (kotlin.jvm.functions.Function2) r4     // Catch: java.lang.Exception -> L7a
                r10.label = r3     // Catch: java.lang.Exception -> L7a
                java.lang.Object r11 = kotlinx.coroutines.BuildersKt.withContext(r11, r4, r10)     // Catch: java.lang.Exception -> L7a
                if (r11 != r1) goto L98
                goto L97
            L7a:
                r0 = move-exception
                r11 = r0
                kotlinx.coroutines.MainCoroutineDispatcher r0 = kotlinx.coroutines.Dispatchers.getMain()
                kotlin.coroutines.CoroutineContext r0 = (kotlin.coroutines.CoroutineContext) r0
                com.magneticchen.daijishou.ui.fragments.dialog.DownloadPlatformThumbnailsPackDialogFragment$onStart$1$2 r3 = new com.magneticchen.daijishou.ui.fragments.dialog.DownloadPlatformThumbnailsPackDialogFragment$onStart$1$2
                com.magneticchen.daijishou.ui.fragments.dialog.DownloadPlatformThumbnailsPackDialogFragment r4 = com.magneticchen.daijishou.ui.fragments.dialog.DownloadPlatformThumbnailsPackDialogFragment.this
                r5 = 0
                r3.<init>(r4, r11, r5)
                kotlin.jvm.functions.Function2 r3 = (kotlin.jvm.functions.Function2) r3
                r11 = r10
                kotlin.coroutines.Continuation r11 = (kotlin.coroutines.Continuation) r11
                r10.label = r2
                java.lang.Object r11 = kotlinx.coroutines.BuildersKt.withContext(r0, r3, r11)
                if (r11 != r1) goto L98
            L97:
                return r1
            L98:
                kotlin.Unit r11 = kotlin.Unit.INSTANCE
                return r11
            */
            throw new UnsupportedOperationException("Method not decompiled: com.magneticchen.daijishou.ui.fragments.dialog.DownloadPlatformThumbnailsPackDialogFragment.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        /* JADX INFO: renamed from: com.magneticchen.daijishou.ui.fragments.dialog.DownloadPlatformThumbnailsPackDialogFragment$onStart$1$2, reason: invalid class name */
        /* JADX INFO: compiled from: DownloadPlatformThumbnailsPackDialogFragment.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
        @DebugMetadata(c = "com.magneticchen.daijishou.ui.fragments.dialog.DownloadPlatformThumbnailsPackDialogFragment$onStart$1$2", f = "DownloadPlatformThumbnailsPackDialogFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ Exception $e;
            int label;
            final /* synthetic */ DownloadPlatformThumbnailsPackDialogFragment this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass2(DownloadPlatformThumbnailsPackDialogFragment downloadPlatformThumbnailsPackDialogFragment, Exception exc, Continuation<? super AnonymousClass2> continuation) {
                super(2, continuation);
                this.this$0 = downloadPlatformThumbnailsPackDialogFragment;
                this.$e = exc;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass2(this.this$0, this.$e, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
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

    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        View viewInflate = inflater.inflate(R.layout.fragment_download_platform_wallpaper_pack_dialog, viewGroup, false);
        ShapeableImageView shapeableImageViewFindViewById = viewInflate.findViewById(R.id.fragment_download_platform_wallpaper_pack_dialog_image_view);
        Intrinsics.checkNotNullExpressionValue(shapeableImageViewFindViewById, "findViewById(...)");
        this.imageView = shapeableImageViewFindViewById;
        View viewFindViewById = viewInflate.findViewById(R.id.fragment_download_platform_wallpaper_pack_dialog_title);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        this.title = (TextView) viewFindViewById;
        View viewFindViewById2 = viewInflate.findViewById(R.id.fragment_download_platform_wallpaper_pack_dialog_subtitle);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
        this.subtitle = (TextView) viewFindViewById2;
        View viewFindViewById3 = viewInflate.findViewById(R.id.fragment_download_platform_wallpaper_pack_dialog_description);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById3, "findViewById(...)");
        this.description = (TextView) viewFindViewById3;
        View viewFindViewById4 = viewInflate.findViewById(R.id.fragment_download_platform_wallpaper_pack_dialog_sources_title);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById4, "findViewById(...)");
        this.sourcesTitle = (TextView) viewFindViewById4;
        View viewFindViewById5 = viewInflate.findViewById(R.id.fragment_download_platform_wallpaper_pack_dialog_sources);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById5, "findViewById(...)");
        this.sources = (TextView) viewFindViewById5;
        LinearProgressIndicator linearProgressIndicatorFindViewById = viewInflate.findViewById(R.id.fragment_download_platform_wallpaper_pack_dialog_progress_bar);
        Intrinsics.checkNotNullExpressionValue(linearProgressIndicatorFindViewById, "findViewById(...)");
        this.linearProgressIndicator = linearProgressIndicatorFindViewById;
        MaterialButton materialButtonFindViewById = viewInflate.findViewById(R.id.fragment_download_platform_wallpaper_pack_dialog_download_button);
        Intrinsics.checkNotNullExpressionValue(materialButtonFindViewById, "findViewById(...)");
        MaterialButton materialButton = materialButtonFindViewById;
        this.downloadButton = materialButton;
        if (materialButton == null) {
            Intrinsics.throwUninitializedPropertyAccessException("downloadButton");
            materialButton = null;
        }
        materialButton.setEnabled(false);
        return viewInflate;
    }
}
