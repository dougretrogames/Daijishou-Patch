package com.magneticchen.daijishou.ui.fragments.dialog;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.google.android.material.imageview.ShapeableImageView;
import com.magneticchen.daijishou.R;
import com.magneticchen.daijishou.data.portables.PlatformThumbnailsPacksIndexJson;
import com.magneticchen.daijishou.data.portables.PlatformThumbnailsPacksIndexPlatformThumbnailPackListItemJson;
import com.magneticchen.daijishou.ui.daijishou_recycler_view.DaijishouRecyclerView;
import com.magneticchen.daijishou.ui.fragments.p000abstract.DaijishouDialogFragment;
import com.magneticchen.daijishou.ui.widget.widgets.category.CategoryWidgetViewModel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: compiled from: DownloadPlatformThumbnailsPackListDialogFragment.kt */
/* JADX INFO: loaded from: C:\Users\dfukuoka\Downloads\Daijishou\Daijishou\build_tmp\dex181_classes4.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\b\u0010\u0010\u001a\u00020\u0011H\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082.¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/magneticchen/daijishou/ui/fragments/dialog/DownloadPlatformThumbnailsPackListDialogFragment;", "Lcom/magneticchen/daijishou/ui/fragments/abstract/DaijishouDialogFragment;", "()V", "listViewItems", "", "Lcom/magneticchen/daijishou/data/portables/PlatformThumbnailsPacksIndexPlatformThumbnailPackListItemJson;", "platformThumbnailsPacksIndexJson", "Lcom/magneticchen/daijishou/data/portables/PlatformThumbnailsPacksIndexJson;", "progressBar", "Landroid/widget/ProgressBar;", "recyclerView", "Lcom/magneticchen/daijishou/ui/daijishou_recycler_view/DaijishouRecyclerView;", "onCreateDialog", "Landroid/app/Dialog;", "savedInstanceState", "Landroid/os/Bundle;", "onStart", "", "Companion", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class DownloadPlatformThumbnailsPackListDialogFragment extends DaijishouDialogFragment {
    public static final Companion Companion = new Companion(null);
    private final List<PlatformThumbnailsPacksIndexPlatformThumbnailPackListItemJson> listViewItems = new ArrayList();
    private PlatformThumbnailsPacksIndexJson platformThumbnailsPacksIndexJson;
    private ProgressBar progressBar;
    private DaijishouRecyclerView recyclerView;

    /* JADX INFO: compiled from: DownloadPlatformThumbnailsPackListDialogFragment.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"}, d2 = {"Lcom/magneticchen/daijishou/ui/fragments/dialog/DownloadPlatformThumbnailsPackListDialogFragment$Companion;", "", "()V", "newInstance", "Lcom/magneticchen/daijishou/ui/fragments/dialog/DownloadPlatformThumbnailsPackListDialogFragment;", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final DownloadPlatformThumbnailsPackListDialogFragment newInstance() {
            return new DownloadPlatformThumbnailsPackListDialogFragment();
        }
    }

    public void onStart() {
        super.onStart();
        Dialog dialogRequireDialog = requireDialog();
        Intrinsics.checkNotNullExpressionValue(dialogRequireDialog, "requireDialog(...)");
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
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) this), Dispatchers.getIO(), (CoroutineStart) null, new C01071(dialogRequireDialog, null), 2, (Object) null);
    }

    /* JADX INFO: renamed from: com.magneticchen.daijishou.ui.fragments.dialog.DownloadPlatformThumbnailsPackListDialogFragment$onStart$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: DownloadPlatformThumbnailsPackListDialogFragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.magneticchen.daijishou.ui.fragments.dialog.DownloadPlatformThumbnailsPackListDialogFragment$onStart$1", f = "DownloadPlatformThumbnailsPackListDialogFragment.kt", i = {}, l = {75, 89}, m = "invokeSuspend", n = {}, s = {})
    static final class C01071 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Dialog $dialog;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C01071(Dialog dialog, Continuation<? super C01071> continuation) {
            super(2, continuation);
            this.$dialog = dialog;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return DownloadPlatformThumbnailsPackListDialogFragment.this.new C01071(this.$dialog, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C01071) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:21:0x007f, code lost:
        
            if (kotlinx.coroutines.BuildersKt.withContext(kotlinx.coroutines.Dispatchers.getMain(), new com.magneticchen.daijishou.ui.fragments.dialog.DownloadPlatformThumbnailsPackListDialogFragment.C01071.AnonymousClass2(r8.this$0, r9, null), r8) == r0) goto L22;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r9) {
            /*
                r8 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r1 = r8.label
                r2 = 0
                r3 = 2
                r4 = 1
                if (r1 == 0) goto L1f
                if (r1 == r4) goto L1b
                if (r1 != r3) goto L13
                kotlin.ResultKt.throwOnFailure(r9)
                goto L82
            L13:
                java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r9.<init>(r0)
                throw r9
            L1b:
                kotlin.ResultKt.throwOnFailure(r9)     // Catch: java.lang.Exception -> L66
                goto L63
            L1f:
                kotlin.ResultKt.throwOnFailure(r9)
                com.magneticchen.daijishou.ui.fragments.dialog.DownloadPlatformThumbnailsPackListDialogFragment r9 = com.magneticchen.daijishou.ui.fragments.dialog.DownloadPlatformThumbnailsPackListDialogFragment.this     // Catch: java.lang.Exception -> L66
                kotlinx.serialization.json.Json r1 = com.magneticchen.daijishou.ui.fragments.dialog.DownloadPlatformThumbnailsPackListDialogFragment.access$getWeakJson(r9)     // Catch: java.lang.Exception -> L66
                com.magneticchen.daijishou.data.portables.PlatformThumbnailsPacksIndexJson$Companion r5 = com.magneticchen.daijishou.data.portables.PlatformThumbnailsPacksIndexJson.Companion     // Catch: java.lang.Exception -> L66
                kotlinx.serialization.KSerializer r5 = r5.serializer()     // Catch: java.lang.Exception -> L66
                kotlinx.serialization.DeserializationStrategy r5 = (kotlinx.serialization.DeserializationStrategy) r5     // Catch: java.lang.Exception -> L66
                com.magneticchen.daijishou.utils.Utils r6 = com.magneticchen.daijishou.utils.Utils.INSTANCE     // Catch: java.lang.Exception -> L66
                java.lang.String r7 = "https://raw.githubusercontent.com/TapiocaFox/Daijishou/main/themes/platform_thumbnails_packs/index.json"
                java.lang.String r6 = r6.readEntireTextFromURL(r7)     // Catch: java.lang.Exception -> L66
                java.lang.Object r1 = r1.decodeFromString(r5, r6)     // Catch: java.lang.Exception -> L66
                com.magneticchen.daijishou.data.portables.PlatformThumbnailsPacksIndexJson r1 = (com.magneticchen.daijishou.data.portables.PlatformThumbnailsPacksIndexJson) r1     // Catch: java.lang.Exception -> L66
                com.magneticchen.daijishou.ui.fragments.dialog.DownloadPlatformThumbnailsPackListDialogFragment.access$setPlatformThumbnailsPacksIndexJson$p(r9, r1)     // Catch: java.lang.Exception -> L66
                com.magneticchen.daijishou.ui.fragments.dialog.DownloadPlatformThumbnailsPackListDialogFragment r9 = com.magneticchen.daijishou.ui.fragments.dialog.DownloadPlatformThumbnailsPackListDialogFragment.this     // Catch: java.lang.Exception -> L66
                com.magneticchen.daijishou.data.portables.PlatformThumbnailsPacksIndexJson r9 = com.magneticchen.daijishou.ui.fragments.dialog.DownloadPlatformThumbnailsPackListDialogFragment.access$getPlatformThumbnailsPacksIndexJson$p(r9)     // Catch: java.lang.Exception -> L66
                if (r9 == 0) goto L82
                com.magneticchen.daijishou.ui.fragments.dialog.DownloadPlatformThumbnailsPackListDialogFragment r1 = com.magneticchen.daijishou.ui.fragments.dialog.DownloadPlatformThumbnailsPackListDialogFragment.this     // Catch: java.lang.Exception -> L66
                android.app.Dialog r5 = r8.$dialog     // Catch: java.lang.Exception -> L66
                kotlinx.coroutines.MainCoroutineDispatcher r6 = kotlinx.coroutines.Dispatchers.getMain()     // Catch: java.lang.Exception -> L66
                kotlin.coroutines.CoroutineContext r6 = (kotlin.coroutines.CoroutineContext) r6     // Catch: java.lang.Exception -> L66
                com.magneticchen.daijishou.ui.fragments.dialog.DownloadPlatformThumbnailsPackListDialogFragment$onStart$1$1$1 r7 = new com.magneticchen.daijishou.ui.fragments.dialog.DownloadPlatformThumbnailsPackListDialogFragment$onStart$1$1$1     // Catch: java.lang.Exception -> L66
                r7.<init>(r1, r5, r9, r2)     // Catch: java.lang.Exception -> L66
                kotlin.jvm.functions.Function2 r7 = (kotlin.jvm.functions.Function2) r7     // Catch: java.lang.Exception -> L66
                r8.label = r4     // Catch: java.lang.Exception -> L66
                java.lang.Object r9 = kotlinx.coroutines.BuildersKt.withContext(r6, r7, r8)     // Catch: java.lang.Exception -> L66
                if (r9 != r0) goto L63
                goto L81
            L63:
                kotlin.Unit r9 = (kotlin.Unit) r9     // Catch: java.lang.Exception -> L66
                goto L82
            L66:
                r9 = move-exception
                kotlinx.coroutines.MainCoroutineDispatcher r1 = kotlinx.coroutines.Dispatchers.getMain()
                kotlin.coroutines.CoroutineContext r1 = (kotlin.coroutines.CoroutineContext) r1
                com.magneticchen.daijishou.ui.fragments.dialog.DownloadPlatformThumbnailsPackListDialogFragment$onStart$1$2 r4 = new com.magneticchen.daijishou.ui.fragments.dialog.DownloadPlatformThumbnailsPackListDialogFragment$onStart$1$2
                com.magneticchen.daijishou.ui.fragments.dialog.DownloadPlatformThumbnailsPackListDialogFragment r5 = com.magneticchen.daijishou.ui.fragments.dialog.DownloadPlatformThumbnailsPackListDialogFragment.this
                r4.<init>(r5, r9, r2)
                kotlin.jvm.functions.Function2 r4 = (kotlin.jvm.functions.Function2) r4
                r9 = r8
                kotlin.coroutines.Continuation r9 = (kotlin.coroutines.Continuation) r9
                r8.label = r3
                java.lang.Object r9 = kotlinx.coroutines.BuildersKt.withContext(r1, r4, r9)
                if (r9 != r0) goto L82
            L81:
                return r0
            L82:
                kotlin.Unit r9 = kotlin.Unit.INSTANCE
                return r9
            */
            throw new UnsupportedOperationException("Method not decompiled: com.magneticchen.daijishou.ui.fragments.dialog.DownloadPlatformThumbnailsPackListDialogFragment.C01071.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        /* JADX INFO: renamed from: com.magneticchen.daijishou.ui.fragments.dialog.DownloadPlatformThumbnailsPackListDialogFragment$onStart$1$2, reason: invalid class name */
        /* JADX INFO: compiled from: DownloadPlatformThumbnailsPackListDialogFragment.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
        @DebugMetadata(c = "com.magneticchen.daijishou.ui.fragments.dialog.DownloadPlatformThumbnailsPackListDialogFragment$onStart$1$2", f = "DownloadPlatformThumbnailsPackListDialogFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ Exception $e;
            int label;
            final /* synthetic */ DownloadPlatformThumbnailsPackListDialogFragment this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass2(DownloadPlatformThumbnailsPackListDialogFragment downloadPlatformThumbnailsPackListDialogFragment, Exception exc, Continuation<? super AnonymousClass2> continuation) {
                super(2, continuation);
                this.this$0 = downloadPlatformThumbnailsPackListDialogFragment;
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

    @Override // com.magneticchen.daijishou.ui.fragments.p000abstract.DaijishouDialogFragment
    public Dialog onCreateDialog(Bundle bundle) {
        ProgressBar progressBar = null;
        View viewInflate = requireActivity().getLayoutInflater().inflate(R.layout.fragment_recycler_view_with_progress_bar_dialog, (ViewGroup) null);
        View viewFindViewById = viewInflate.findViewById(R.id.fragment_recycler_view_with_progress_bar_dialog_progress_bar);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        this.progressBar = (ProgressBar) viewFindViewById;
        Object objFindViewById = viewInflate.findViewById(R.id.fragment_recycler_view_with_progress_bar_dialog_recycler_view);
        Intrinsics.checkNotNullExpressionValue(objFindViewById, "findViewById(...)");
        this.recyclerView = (DaijishouRecyclerView) objFindViewById;
        final List<PlatformThumbnailsPacksIndexPlatformThumbnailPackListItemJson> list = this.listViewItems;
        DaijishouRecyclerView.Adapter<PlatformThumbnailsPacksIndexPlatformThumbnailPackListItemJson> adapter = new DaijishouRecyclerView.Adapter<PlatformThumbnailsPacksIndexPlatformThumbnailPackListItemJson>(list) { // from class: com.magneticchen.daijishou.ui.fragments.dialog.DownloadPlatformThumbnailsPackListDialogFragment$onCreateDialog$adapter$1

            /* JADX INFO: compiled from: DownloadPlatformThumbnailsPackListDialogFragment.kt */
            @Metadata(d1 = {"\u00009\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\u008a\u0004\u0018\u00002\f0\u0001R\b\u0012\u0004\u0012\u00020\u00030\u0002B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0003H\u0016R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u000f\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000e¨\u0006\u0016"}, d2 = {"com/magneticchen/daijishou/ui/fragments/dialog/DownloadPlatformThumbnailsPackListDialogFragment$onCreateDialog$adapter$1.ViewHolder", "Lcom/magneticchen/daijishou/ui/daijishou_recycler_view/DaijishouRecyclerView$Adapter$ViewHolder;", "Lcom/magneticchen/daijishou/ui/daijishou_recycler_view/DaijishouRecyclerView$Adapter;", "Lcom/magneticchen/daijishou/data/portables/PlatformThumbnailsPacksIndexPlatformThumbnailPackListItemJson;", "itemView", "Landroid/view/View;", "(Lcom/magneticchen/daijishou/ui/fragments/dialog/DownloadPlatformThumbnailsPackListDialogFragment$onCreateDialog$adapter$1;Landroid/view/View;)V", "imageView", "Lcom/google/android/material/imageview/ShapeableImageView;", "getImageView", "()Lcom/google/android/material/imageview/ShapeableImageView;", "text1", "Landroid/widget/TextView;", "getText1", "()Landroid/widget/TextView;", "text2", "getText2", "onBind", "", "position", "", "item", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
            public final class ViewHolder extends DaijishouRecyclerView.Adapter<PlatformThumbnailsPacksIndexPlatformThumbnailPackListItemJson>.ViewHolder {
                private final ShapeableImageView imageView;
                private final TextView text1;
                private final TextView text2;
                final /* synthetic */ DownloadPlatformThumbnailsPackListDialogFragment$onCreateDialog$adapter$1 this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public ViewHolder(DownloadPlatformThumbnailsPackListDialogFragment$onCreateDialog$adapter$1 downloadPlatformThumbnailsPackListDialogFragment$onCreateDialog$adapter$1, View itemView) {
                    super(downloadPlatformThumbnailsPackListDialogFragment$onCreateDialog$adapter$1, itemView);
                    Intrinsics.checkNotNullParameter(itemView, "itemView");
                    this.this$0 = downloadPlatformThumbnailsPackListDialogFragment$onCreateDialog$adapter$1;
                    View viewFindViewById = itemView.findViewById(R.id.list_item_theme_pack_choice_title);
                    Intrinsics.checkNotNull(viewFindViewById, "null cannot be cast to non-null type android.widget.TextView");
                    this.text1 = (TextView) viewFindViewById;
                    View viewFindViewById2 = itemView.findViewById(R.id.list_item_theme_pack_choice_subtitle);
                    Intrinsics.checkNotNull(viewFindViewById2, "null cannot be cast to non-null type android.widget.TextView");
                    this.text2 = (TextView) viewFindViewById2;
                    ShapeableImageView shapeableImageViewFindViewById = itemView.findViewById(R.id.list_item_theme_pack_choice_image_view);
                    Intrinsics.checkNotNull(shapeableImageViewFindViewById, "null cannot be cast to non-null type com.google.android.material.imageview.ShapeableImageView");
                    this.imageView = shapeableImageViewFindViewById;
                }

                public final TextView getText1() {
                    return this.text1;
                }

                public final TextView getText2() {
                    return this.text2;
                }

                public final ShapeableImageView getImageView() {
                    return this.imageView;
                }

                @Override // com.magneticchen.daijishou.ui.daijishou_recycler_view.DaijishouRecyclerView.Adapter.ViewHolder
                public void onBind(int i, PlatformThumbnailsPacksIndexPlatformThumbnailPackListItemJson item) {
                    Intrinsics.checkNotNullParameter(item, "item");
                    PlatformThumbnailsPacksIndexJson platformThumbnailsPacksIndexJson = this.this$0.this$0.platformThumbnailsPacksIndexJson;
                    Intrinsics.checkNotNull(platformThumbnailsPacksIndexJson);
                    Glide.with(this.this$0.this$0).load(platformThumbnailsPacksIndexJson.getBaseUri() + item.getPlatformThumbnailsPackPreviewThumbnailPath()).transition(DrawableTransitionOptions.withCrossFade()).into(this.imageView);
                    this.text1.setText(item.getPlatformThumbnailsPackName());
                    TextView textView = this.text2;
                    String string = this.this$0.this$0.getString(R.string.authors_format);
                    Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                    String str = String.format(string, Arrays.copyOf(new Object[]{CollectionsKt.joinToString$default(item.getPlatformThumbnailsPackAuthors(), ", ", null, null, 0, null, null, 62, null)}, 1));
                    Intrinsics.checkNotNullExpressionValue(str, "format(...)");
                    textView.setText(str);
                    this.text2.setAlpha(0.75f);
                }
            }

            public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
                Intrinsics.checkNotNullParameter(viewGroup, "viewGroup");
                View viewInflate2 = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item_theme_pack_choice, viewGroup, false);
                Intrinsics.checkNotNull(viewInflate2);
                return new ViewHolder(this, viewInflate2);
            }
        };
        DaijishouRecyclerView daijishouRecyclerView = this.recyclerView;
        if (daijishouRecyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            daijishouRecyclerView = null;
        }
        daijishouRecyclerView.setAdapter(adapter);
        ProgressBar progressBar2 = this.progressBar;
        if (progressBar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("progressBar");
        } else {
            progressBar = progressBar2;
        }
        progressBar.setIndeterminate(true);
        AlertDialog alertDialogCreate = new AlertDialog.Builder(getContext()).setView(viewInflate).setTitle("Platform thumbnails packs").setNegativeButton(getString(R.string.cancel), new DialogInterface.OnClickListener() { // from class: com.magneticchen.daijishou.ui.fragments.dialog.DownloadPlatformThumbnailsPackListDialogFragment$$ExternalSyntheticLambda0
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        }).create();
        adapter.setOnItemClickListener(new Function4<View, Integer, Long, PlatformThumbnailsPacksIndexPlatformThumbnailPackListItemJson, Unit>() { // from class: com.magneticchen.daijishou.ui.fragments.dialog.DownloadPlatformThumbnailsPackListDialogFragment.onCreateDialog.1
            

            @Override // kotlin.jvm.functions.Function4
            public /* bridge */ /* synthetic */ Unit invoke(View view, Integer num, Long l, PlatformThumbnailsPacksIndexPlatformThumbnailPackListItemJson platformThumbnailsPacksIndexPlatformThumbnailPackListItemJson) {
                invoke(view, num.intValue(), l.longValue(), platformThumbnailsPacksIndexPlatformThumbnailPackListItemJson);
                return Unit.INSTANCE;
            }

            public final void invoke(View view, int i, long j, PlatformThumbnailsPacksIndexPlatformThumbnailPackListItemJson it) {
                Intrinsics.checkNotNullParameter(view, "<anonymous parameter 0>");
                Intrinsics.checkNotNullParameter(it, "it");
                PlatformThumbnailsPacksIndexJson platformThumbnailsPacksIndexJson = DownloadPlatformThumbnailsPackListDialogFragment.this.platformThumbnailsPacksIndexJson;
                if (platformThumbnailsPacksIndexJson != null) {
                    DownloadPlatformThumbnailsPackListDialogFragment downloadPlatformThumbnailsPackListDialogFragment = DownloadPlatformThumbnailsPackListDialogFragment.this;
                    DownloadPlatformThumbnailsPackDialogFragment.Companion.newInstance(platformThumbnailsPacksIndexJson.getBaseUri() + it.getPlatformThumbnailsPackRootPath() + "/").show(downloadPlatformThumbnailsPackListDialogFragment.getParentFragmentManager(), DownloadPlatformThumbnailsPackDialogFragment.class.getName());
                }
            }
        });
        Intrinsics.checkNotNull(alertDialogCreate);
        AlertDialog alertDialog = alertDialogCreate;
        setupDaijishouDialog(alertDialog);
        return alertDialog;
    }
}
