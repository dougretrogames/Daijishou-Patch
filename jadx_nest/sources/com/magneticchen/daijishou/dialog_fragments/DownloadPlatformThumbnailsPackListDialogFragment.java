package com.magneticchen.daijishou.dialog_fragments;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ProgressBar;
import android.widget.Toast;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.lifecycle.LifecycleOwnerKt;
import com.magneticchen.daijishou.R;
import com.magneticchen.daijishou.abstract_fragment_classes.DaijishouDialogFragment;
import com.magneticchen.daijishou.daijishou_library_db.portables.PlatformThumbnailsPacksIndexJson;
import com.magneticchen.daijishou.daijishou_library_db.portables.PlatformThumbnailsPacksIndexPlatformThumbnailPackListItemJson;
import com.magneticchen.daijishou.daijishou_recycler_view.DaijishouRecyclerView;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import net.lingala.zip4j.util.InternalZipConstants;

/* JADX INFO: compiled from: DownloadPlatformThumbnailsPackListDialogFragment.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\b\u0010\u0010\u001a\u00020\u0011H\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082.¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/magneticchen/daijishou/dialog_fragments/DownloadPlatformThumbnailsPackListDialogFragment;", "Lcom/magneticchen/daijishou/abstract_fragment_classes/DaijishouDialogFragment;", "()V", "listViewItems", "", "Lcom/magneticchen/daijishou/daijishou_library_db/portables/PlatformThumbnailsPacksIndexPlatformThumbnailPackListItemJson;", "platformThumbnailsPacksIndexJson", "Lcom/magneticchen/daijishou/daijishou_library_db/portables/PlatformThumbnailsPacksIndexJson;", "progressBar", "Landroid/widget/ProgressBar;", "recyclerView", "Lcom/magneticchen/daijishou/daijishou_recycler_view/DaijishouRecyclerView;", "onCreateDialog", "Landroid/app/Dialog;", "savedInstanceState", "Landroid/os/Bundle;", "onStart", "", "Companion", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class DownloadPlatformThumbnailsPackListDialogFragment extends DaijishouDialogFragment {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public final List<PlatformThumbnailsPacksIndexPlatformThumbnailPackListItemJson> listViewItems = new ArrayList();
    public PlatformThumbnailsPacksIndexJson platformThumbnailsPacksIndexJson;
    public ProgressBar progressBar;
    public DaijishouRecyclerView recyclerView;

    /* JADX INFO: compiled from: DownloadPlatformThumbnailsPackListDialogFragment.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"}, d2 = {"Lcom/magneticchen/daijishou/dialog_fragments/DownloadPlatformThumbnailsPackListDialogFragment$Companion;", "", "()V", "newInstance", "Lcom/magneticchen/daijishou/dialog_fragments/DownloadPlatformThumbnailsPackListDialogFragment;", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
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

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
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
            window2.setFlags(1024, 1024);
        }
        Window window3 = dialogRequireDialog.getWindow();
        if (window3 != null) {
            window3.setBackgroundDrawable(AppCompatResources.getDrawable(requireContext(), R.drawable.dialog_background));
        }
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), Dispatchers.getIO(), null, new C02211(dialogRequireDialog, null), 2, null);
    }

    /* JADX INFO: renamed from: com.magneticchen.daijishou.dialog_fragments.DownloadPlatformThumbnailsPackListDialogFragment$onStart$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: DownloadPlatformThumbnailsPackListDialogFragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.magneticchen.daijishou.dialog_fragments.DownloadPlatformThumbnailsPackListDialogFragment$onStart$1", f = "DownloadPlatformThumbnailsPackListDialogFragment.kt", i = {}, l = {78, 93}, m = "invokeSuspendImpl", n = {}, s = {})
    final class C02211 extends com.magneticchen.daijishou.support.DaijishouSuspendLambda implements Function2<CoroutineScope, Continuation<?>, Object> {
        final /* synthetic */ Dialog $dialog;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C02211(Dialog dialog, Continuation<?> continuation) {
            super(2, continuation);
            this.$dialog = dialog;
        }


        public final Continuation create(Object obj, Continuation<?> continuation) {
            return DownloadPlatformThumbnailsPackListDialogFragment.this.new C02211(this.$dialog, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<?> continuation) {
            try {
                try {
                    return ((C02211) create(coroutineScope, continuation)).invokeSuspendImpl(Unit.INSTANCE);
                } catch (Throwable th) {
                    throw com.magneticchen.daijishou.support.DaijishouSupport.sneakyThrow(th);
                }
            } catch (Throwable th) {
                throw com.magneticchen.daijishou.support.DaijishouSupport.sneakyThrow(th);
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:21:0x007f, code lost:
        
            if (kotlinx.coroutines.BuildersKt.withContext(kotlinx.coroutines.Dispatchers.getMain(), new com.magneticchen.daijishou.dialog_fragments.DownloadPlatformThumbnailsPackListDialogFragment.C02211.AnonymousClass2(r8.this$0, r9, null), r8) == r0) goto L22;
         */

        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspendImpl(java.lang.Object r9) throws java.lang.Throwable {
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
                com.magneticchen.daijishou.dialog_fragments.DownloadPlatformThumbnailsPackListDialogFragment r9 = com.magneticchen.daijishou.dialog_fragments.DownloadPlatformThumbnailsPackListDialogFragment.this     // Catch: java.lang.Exception -> L66
                kotlinx.serialization.json.Json r1 = com.magneticchen.daijishou.dialog_fragments.DownloadPlatformThumbnailsPackListDialogFragment.access$getWeakJson(r9)     // Catch: java.lang.Exception -> L66
                com.magneticchen.daijishou.daijishou_library_db.portables.PlatformThumbnailsPacksIndexJson$Companion r5 = com.magneticchen.daijishou.daijishou_library_db.portables.PlatformThumbnailsPacksIndexJson.INSTANCE     // Catch: java.lang.Exception -> L66
                kotlinx.serialization.KSerializer r5 = r5.serializer()     // Catch: java.lang.Exception -> L66
                kotlinx.serialization.DeserializationStrategy r5 = (kotlinx.serialization.DeserializationStrategy) r5     // Catch: java.lang.Exception -> L66
                com.magneticchen.daijishou.utils.Utils r6 = com.magneticchen.daijishou.utils.Utils.INSTANCE     // Catch: java.lang.Exception -> L66
                java.lang.String r7 = "https://raw.githubusercontent.com/TapiocaFox/Daijishou/main/themes/platform_thumbnails_packs/index.json"
                java.lang.String r6 = r6.readEntireTextFromURL(r7)     // Catch: java.lang.Exception -> L66
                java.lang.Object r1 = r1.decodeFromString(r5, r6)     // Catch: java.lang.Exception -> L66
                com.magneticchen.daijishou.daijishou_library_db.portables.PlatformThumbnailsPacksIndexJson r1 = (com.magneticchen.daijishou.daijishou_library_db.portables.PlatformThumbnailsPacksIndexJson) r1     // Catch: java.lang.Exception -> L66
                com.magneticchen.daijishou.dialog_fragments.DownloadPlatformThumbnailsPackListDialogFragment.access$setPlatformThumbnailsPacksIndexJson$p(r9, r1)     // Catch: java.lang.Exception -> L66
                com.magneticchen.daijishou.dialog_fragments.DownloadPlatformThumbnailsPackListDialogFragment r9 = com.magneticchen.daijishou.dialog_fragments.DownloadPlatformThumbnailsPackListDialogFragment.this     // Catch: java.lang.Exception -> L66
                com.magneticchen.daijishou.daijishou_library_db.portables.PlatformThumbnailsPacksIndexJson r9 = com.magneticchen.daijishou.dialog_fragments.DownloadPlatformThumbnailsPackListDialogFragment.access$getPlatformThumbnailsPacksIndexJson$p(r9)     // Catch: java.lang.Exception -> L66
                if (r9 == 0) goto L82
                com.magneticchen.daijishou.dialog_fragments.DownloadPlatformThumbnailsPackListDialogFragment r1 = com.magneticchen.daijishou.dialog_fragments.DownloadPlatformThumbnailsPackListDialogFragment.this     // Catch: java.lang.Exception -> L66
                android.app.Dialog r5 = r8.$dialog     // Catch: java.lang.Exception -> L66
                kotlinx.coroutines.MainCoroutineDispatcher r6 = kotlinx.coroutines.Dispatchers.getMain()     // Catch: java.lang.Exception -> L66
                kotlin.coroutines.CoroutineContext r6 = (kotlin.coroutines.CoroutineContext) r6     // Catch: java.lang.Exception -> L66
                com.magneticchen.daijishou.dialog_fragments.DownloadPlatformThumbnailsPackListDialogFragment$onStart$1$1$1 r7 = new com.magneticchen.daijishou.dialog_fragments.DownloadPlatformThumbnailsPackListDialogFragment$onStart$1$1$1     // Catch: java.lang.Exception -> L66
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
                com.magneticchen.daijishou.dialog_fragments.DownloadPlatformThumbnailsPackListDialogFragment$onStart$1$2 r4 = new com.magneticchen.daijishou.dialog_fragments.DownloadPlatformThumbnailsPackListDialogFragment$onStart$1$2
                com.magneticchen.daijishou.dialog_fragments.DownloadPlatformThumbnailsPackListDialogFragment r5 = com.magneticchen.daijishou.dialog_fragments.DownloadPlatformThumbnailsPackListDialogFragment.this
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
            throw new UnsupportedOperationException("Method not decompiled: com.magneticchen.daijishou.dialog_fragments.DownloadPlatformThumbnailsPackListDialogFragment.C02211.invokeSuspendImpl(java.lang.Object):java.lang.Object");
        }

        /* JADX INFO: renamed from: com.magneticchen.daijishou.dialog_fragments.DownloadPlatformThumbnailsPackListDialogFragment$onStart$1$2, reason: invalid class name */
        /* JADX INFO: compiled from: DownloadPlatformThumbnailsPackListDialogFragment.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
        @DebugMetadata(c = "com.magneticchen.daijishou.dialog_fragments.DownloadPlatformThumbnailsPackListDialogFragment$onStart$1$2", f = "DownloadPlatformThumbnailsPackListDialogFragment.kt", i = {}, l = {}, m = "invokeSuspendImpl", n = {}, s = {})
        final class AnonymousClass2 extends com.magneticchen.daijishou.support.DaijishouSuspendLambda implements Function2<CoroutineScope, Continuation<?>, Object> {
            final /* synthetic */ Exception $e;
            int label;
            final /* synthetic */ DownloadPlatformThumbnailsPackListDialogFragment this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass2(DownloadPlatformThumbnailsPackListDialogFragment downloadPlatformThumbnailsPackListDialogFragment, Exception exc, Continuation<?> continuation) {
                super(2, continuation);
                this.this$0 = downloadPlatformThumbnailsPackListDialogFragment;
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

    @Override // com.magneticchen.daijishou.abstract_fragment_classes.DaijishouDialogFragment, androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        ProgressBar progressBar = null;
        View viewInflate = requireActivity().getLayoutInflater().inflate(R.layout.fragment_recycler_view_with_progress_bar_dialog, (ViewGroup) null);
        View viewFindViewById = viewInflate.findViewById(R.id.fragment_recycler_view_with_progress_bar_dialog_progress_bar);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        this.progressBar = (ProgressBar) viewFindViewById;
        View viewFindViewById2 = viewInflate.findViewById(R.id.fragment_recycler_view_with_progress_bar_dialog_recycler_view);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
        this.recyclerView = (DaijishouRecyclerView) viewFindViewById2;
        DownloadPlatformThumbnailsPackListDialogFragment$onCreateDialog$adapter$1 downloadPlatformThumbnailsPackListDialogFragment$onCreateDialog$adapter$1 = new DownloadPlatformThumbnailsPackListDialogFragment$onCreateDialog$adapter$1(this, this.listViewItems);
        DaijishouRecyclerView daijishouRecyclerView = this.recyclerView;
        if (daijishouRecyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            daijishouRecyclerView = null;
        }
        daijishouRecyclerView.setAdapter(downloadPlatformThumbnailsPackListDialogFragment$onCreateDialog$adapter$1);
        ProgressBar progressBar2 = this.progressBar;
        if (progressBar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("progressBar");
        } else {
            progressBar = progressBar2;
        }
        progressBar.setIndeterminate(true);
        AlertDialog alertDialogCreate = new AlertDialog.Builder(getContext()).setView(viewInflate).setTitle("Platform thumbnails packs").setNegativeButton(getString(R.string.cancel), new DownloadPlatformThumbnailsPackListDialogFragment$$ExternalSyntheticLambda0()).create();
        downloadPlatformThumbnailsPackListDialogFragment$onCreateDialog$adapter$1.setOnItemClickListener(new AnonymousClass1());
        Intrinsics.checkNotNull(alertDialogCreate);
        AlertDialog alertDialog = alertDialogCreate;
        setupDaijishouDialog(alertDialog);
        return alertDialog;
    }

    /* JADX INFO: renamed from: com.magneticchen.daijishou.dialog_fragments.DownloadPlatformThumbnailsPackListDialogFragment$onCreateDialog$1, reason: invalid class name */
    /* JADX INFO: compiled from: DownloadPlatformThumbnailsPackListDialogFragment.kt */
    @Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\n¢\u0006\u0002\b\n"}, d2 = {"<anonymous>", "", "<anonymous parameter 0>", "Landroid/view/View;", "<anonymous parameter 1>", "", "<anonymous parameter 2>", "", "it", "Lcom/magneticchen/daijishou/daijishou_library_db/portables/PlatformThumbnailsPacksIndexPlatformThumbnailPackListItemJson;", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
    final class AnonymousClass1 extends Lambda<Unit> implements Function4<View, Integer, Long, PlatformThumbnailsPacksIndexPlatformThumbnailPackListItemJson, Unit> {
        AnonymousClass1() {
            super(4);
        }

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
                DownloadPlatformThumbnailsPackDialogFragment.INSTANCE.newInstance(platformThumbnailsPacksIndexJson.getBaseUri() + it.getPlatformThumbnailsPackRootPath() + InternalZipConstants.ZIP_FILE_SEPARATOR).show(downloadPlatformThumbnailsPackListDialogFragment.getParentFragmentManager(), DownloadPlatformThumbnailsPackDialogFragment.class.getName());
            }
        }
    }
}
