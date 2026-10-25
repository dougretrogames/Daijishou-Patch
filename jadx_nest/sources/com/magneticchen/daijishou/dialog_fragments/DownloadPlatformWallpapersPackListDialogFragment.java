package com.magneticchen.daijishou.dialog_fragments;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.recyclerview.widget.DividerItemDecoration;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.util.ViewPreloadSizeProvider;
import com.google.android.material.imageview.ShapeableImageView;
import com.magneticchen.daijishou.R;
import com.magneticchen.daijishou.abstract_fragment_classes.DaijishouDialogFragment;
import com.magneticchen.daijishou.application_data.BooleanPreference;
import com.magneticchen.daijishou.application_data.Constants;
import com.magneticchen.daijishou.daijishou_library_db.portables.PlatformWallpapersPacksIndexJson;
import com.magneticchen.daijishou.daijishou_library_db.portables.PlatformWallpapersPacksIndexPlatformWallpaperPackListItemJson;
import com.magneticchen.daijishou.daijishou_recycler_view.DaijishouLinearLayoutManager;
import com.magneticchen.daijishou.daijishou_recycler_view.DaijishouRecyclerView;
import com.magneticchen.daijishou.utils.Utils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;
import net.lingala.zip4j.util.InternalZipConstants;

/* JADX INFO: compiled from: DownloadPlatformWallpapersPackListDialogFragment.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\b\u0010\u0018\u001a\u00020\u0019H\u0016R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006\u001b"}, d2 = {"Lcom/magneticchen/daijishou/dialog_fragments/DownloadPlatformWallpapersPackListDialogFragment;", "Lcom/magneticchen/daijishou/abstract_fragment_classes/DaijishouDialogFragment;", "()V", "platformWallpapersPacksIndexJson", "Lcom/magneticchen/daijishou/daijishou_library_db/portables/PlatformWallpapersPacksIndexJson;", "progressBar", "Landroid/widget/ProgressBar;", "recyclerView", "Lcom/magneticchen/daijishou/daijishou_recycler_view/DaijishouRecyclerView;", "recyclerViewAdapter", "Lcom/magneticchen/daijishou/daijishou_recycler_view/DaijishouRecyclerView$Adapter;", "Lcom/magneticchen/daijishou/daijishou_library_db/portables/PlatformWallpapersPacksIndexPlatformWallpaperPackListItemJson;", "recyclerViewItems", "", "scrollingOnBackPressed", "", "getScrollingOnBackPressed", "()Z", "setScrollingOnBackPressed", "(Z)V", "onCreateDialog", "Landroid/app/Dialog;", "savedInstanceState", "Landroid/os/Bundle;", "onStart", "", "Companion", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class DownloadPlatformWallpapersPackListDialogFragment extends DaijishouDialogFragment {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public PlatformWallpapersPacksIndexJson platformWallpapersPacksIndexJson;
    public ProgressBar progressBar;
    public DaijishouRecyclerView recyclerView;
    public DaijishouRecyclerView.Adapter<PlatformWallpapersPacksIndexPlatformWallpaperPackListItemJson> recyclerViewAdapter;
    private final List<PlatformWallpapersPacksIndexPlatformWallpaperPackListItemJson> recyclerViewItems = new ArrayList();
    private boolean scrollingOnBackPressed;

    /* JADX INFO: compiled from: DownloadPlatformWallpapersPackListDialogFragment.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"}, d2 = {"Lcom/magneticchen/daijishou/dialog_fragments/DownloadPlatformWallpapersPackListDialogFragment$Companion;", "", "()V", "newInstance", "Lcom/magneticchen/daijishou/dialog_fragments/DownloadPlatformWallpapersPackListDialogFragment;", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final DownloadPlatformWallpapersPackListDialogFragment newInstance() {
            return new DownloadPlatformWallpapersPackListDialogFragment();
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
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), Dispatchers.getIO(), null, new C02221(null), 2, null);
    }

    /* JADX INFO: renamed from: com.magneticchen.daijishou.dialog_fragments.DownloadPlatformWallpapersPackListDialogFragment$onStart$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: DownloadPlatformWallpapersPackListDialogFragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.magneticchen.daijishou.dialog_fragments.DownloadPlatformWallpapersPackListDialogFragment$onStart$1", f = "DownloadPlatformWallpapersPackListDialogFragment.kt", i = {0}, l = {87}, m = "invokeSuspendImpl", n = {"$this$launch"}, s = {"L$0"})
    final class C02221 extends com.magneticchen.daijishou.support.DaijishouSuspendLambda implements Function2<CoroutineScope, Continuation<?>, Object> {
        private /* synthetic */ Object L$0;
        int label;

        C02221(Continuation<?> continuation) {
            super(2, continuation);
        }


        public final Continuation create(Object obj, Continuation<?> continuation) {
            C02221 c02221 = DownloadPlatformWallpapersPackListDialogFragment.this.new C02221(continuation);
            c02221.L$0 = obj;
            return c02221;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<?> continuation) {
            try {
                try {
                    return ((C02221) create(coroutineScope, continuation)).invokeSuspendImpl(Unit.INSTANCE);
                } catch (Throwable th) {
                    throw com.magneticchen.daijishou.support.DaijishouSupport.sneakyThrow(th);
                }
            } catch (Throwable th) {
                throw com.magneticchen.daijishou.support.DaijishouSupport.sneakyThrow(th);
            }
        }

        public final Object invokeSuspendImpl(Object obj) throws Throwable {
            CoroutineScope coroutineScope;
            Exception e;
            List<PlatformWallpapersPacksIndexPlatformWallpaperPackListItemJson> platformWallpapersPackList;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i != 0) {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                coroutineScope = (CoroutineScope) this.L$0;
                try {
                    ResultKt.throwOnFailure(obj);
                } catch (Exception e2) {
                    e = e2;
                    DownloadPlatformWallpapersPackListDialogFragment.this.getLogger().error(coroutineScope, ExceptionsKt.stackTraceToString(e));
                }
            } else {
                ResultKt.throwOnFailure(obj);
                CoroutineScope coroutineScope2 = (CoroutineScope) this.L$0;
                try {
                    DownloadPlatformWallpapersPackListDialogFragment downloadPlatformWallpapersPackListDialogFragment = DownloadPlatformWallpapersPackListDialogFragment.this;
                    downloadPlatformWallpapersPackListDialogFragment.platformWallpapersPacksIndexJson = (PlatformWallpapersPacksIndexJson) downloadPlatformWallpapersPackListDialogFragment.getWeakJson().decodeFromString(PlatformWallpapersPacksIndexJson.INSTANCE.serializer(), Utils.INSTANCE.readEntireTextFromURL(Constants.platformWallpapersPacksIndexUri));
                    DownloadPlatformWallpapersPackListDialogFragment.this.getLogger().debug(coroutineScope2, "platformWallpapersPacksIndexJson: " + DownloadPlatformWallpapersPackListDialogFragment.this.platformWallpapersPacksIndexJson);
                    PlatformWallpapersPacksIndexJson platformWallpapersPacksIndexJson = DownloadPlatformWallpapersPackListDialogFragment.this.platformWallpapersPacksIndexJson;
                    if (platformWallpapersPacksIndexJson != null) {
                        DownloadPlatformWallpapersPackListDialogFragment downloadPlatformWallpapersPackListDialogFragment2 = DownloadPlatformWallpapersPackListDialogFragment.this;
                        downloadPlatformWallpapersPackListDialogFragment2.recyclerViewItems.clear();
                        List list = downloadPlatformWallpapersPackListDialogFragment2.recyclerViewItems;
                        if (downloadPlatformWallpapersPackListDialogFragment2.getDefaultSharedPreferences().getBoolean(BooleanPreference.USE_NSFW.getKey(), BooleanPreference.USE_NSFW.getDefaultValue())) {
                            platformWallpapersPackList = platformWallpapersPacksIndexJson.getPlatformWallpapersPackList();
                        } else {
                            List<PlatformWallpapersPacksIndexPlatformWallpaperPackListItemJson> platformWallpapersPackList2 = platformWallpapersPacksIndexJson.getPlatformWallpapersPackList();
                            ArrayList arrayList = new ArrayList();
                            for (Object obj2 : platformWallpapersPackList2) {
                                if (!((PlatformWallpapersPacksIndexPlatformWallpaperPackListItemJson) obj2).getPlatformWallpapersPackIsNSFW()) {
                                    arrayList.add(obj2);
                                }
                            }
                            platformWallpapersPackList = arrayList;
                        }
                        list.addAll(platformWallpapersPackList);
                        MainCoroutineDispatcher main = Dispatchers.getMain();
                        DownloadPlatformWallpapersPackListDialogFragment$onStart$1$1$2 downloadPlatformWallpapersPackListDialogFragment$onStart$1$1$2 = new DownloadPlatformWallpapersPackListDialogFragment$onStart$1$1$2(downloadPlatformWallpapersPackListDialogFragment2, null);
                        this.L$0 = coroutineScope2;
                        this.label = 1;
                        if (BuildersKt.withContext(main, downloadPlatformWallpapersPackListDialogFragment$onStart$1$1$2, this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    }
                } catch (Exception e3) {
                    coroutineScope = coroutineScope2;
                    e = e3;
                    DownloadPlatformWallpapersPackListDialogFragment.this.getLogger().error(coroutineScope, ExceptionsKt.stackTraceToString(e));
                }
            }
            return Unit.INSTANCE;
        }
    }

    public final boolean getScrollingOnBackPressed() {
        return this.scrollingOnBackPressed;
    }

    public final void setScrollingOnBackPressed(boolean z) {
        this.scrollingOnBackPressed = z;
    }

    @Override // com.magneticchen.daijishou.abstract_fragment_classes.DaijishouDialogFragment, androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        DaijishouRecyclerView.Adapter<PlatformWallpapersPacksIndexPlatformWallpaperPackListItemJson> adapter = null;
        View viewInflate = requireActivity().getLayoutInflater().inflate(R.layout.fragment_recycler_view_with_progress_bar_dialog, (ViewGroup) null);
        View viewFindViewById = viewInflate.findViewById(R.id.fragment_recycler_view_with_progress_bar_dialog_progress_bar);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        this.progressBar = (ProgressBar) viewFindViewById;
        View viewFindViewById2 = viewInflate.findViewById(R.id.fragment_recycler_view_with_progress_bar_dialog_recycler_view);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
        this.recyclerView = (DaijishouRecyclerView) viewFindViewById2;
        this.recyclerViewAdapter = new AnonymousClass1(this.recyclerViewItems);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(requireContext(), 1);
        DaijishouRecyclerView daijishouRecyclerView = this.recyclerView;
        if (daijishouRecyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            daijishouRecyclerView = null;
        }
        daijishouRecyclerView.addItemDecoration(dividerItemDecoration);
        DaijishouRecyclerView daijishouRecyclerView2 = this.recyclerView;
        if (daijishouRecyclerView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            daijishouRecyclerView2 = null;
        }
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        daijishouRecyclerView2.setLayoutManager(new DaijishouLinearLayoutManager(contextRequireContext, 1, false));
        DaijishouRecyclerView daijishouRecyclerView3 = this.recyclerView;
        if (daijishouRecyclerView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            daijishouRecyclerView3 = null;
        }
        DaijishouRecyclerView.Adapter<PlatformWallpapersPacksIndexPlatformWallpaperPackListItemJson> adapter2 = this.recyclerViewAdapter;
        if (adapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerViewAdapter");
            adapter2 = null;
        }
        daijishouRecyclerView3.setAdapter(adapter2);
        ProgressBar progressBar = this.progressBar;
        if (progressBar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("progressBar");
            progressBar = null;
        }
        progressBar.setIndeterminate(true);
        AlertDialog alertDialogCreate = new AlertDialog.Builder(getContext()).setView(viewInflate).setTitle(getString(R.string.platform_wallpapers_packs)).setNegativeButton(getString(R.string.cancel), new DownloadPlatformWallpapersPackListDialogFragment$$ExternalSyntheticLambda0()).create();
        DaijishouRecyclerView.Adapter<PlatformWallpapersPacksIndexPlatformWallpaperPackListItemJson> adapter3 = this.recyclerViewAdapter;
        if (adapter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerViewAdapter");
        } else {
            adapter = adapter3;
        }
        adapter.setOnItemClickListener(new AnonymousClass2());
        Intrinsics.checkNotNull(alertDialogCreate);
        AlertDialog alertDialog = alertDialogCreate;
        setupDaijishouDialog(alertDialog);
        return alertDialog;
    }

    /* JADX INFO: renamed from: com.magneticchen.daijishou.dialog_fragments.DownloadPlatformWallpapersPackListDialogFragment$onCreateDialog$1, reason: invalid class name */
    /* JADX INFO: compiled from: DownloadPlatformWallpapersPackListDialogFragment.kt */
    @Metadata(d1 = {"\u00008\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003*\u0002\u0000\u000b\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0011J!\u0010\n\u001a\u00060\u000bR\u00020\u00002\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016¢\u0006\u0002\u0010\u0010R(\u0010\u0003\u001a\u001c\u0012\u0004\u0012\u00020\u0002\u0012\u0012\u0012\u0010\u0012\f\u0012\n \u0007*\u0004\u0018\u00010\u00060\u00060\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"com/magneticchen/daijishou/dialog_fragments/DownloadPlatformWallpapersPackListDialogFragment$onCreateDialog$1", "Lcom/magneticchen/daijishou/daijishou_recycler_view/DaijishouRecyclerView$Adapter;", "Lcom/magneticchen/daijishou/daijishou_library_db/portables/PlatformWallpapersPacksIndexPlatformWallpaperPackListItemJson;", "glideBuilderCreator", "Lkotlin/Function1;", "Lcom/bumptech/glide/RequestBuilder;", "Landroid/graphics/drawable/Drawable;", "kotlin.jvm.PlatformType", "glideViewPreloadSizeProvider", "Lcom/bumptech/glide/util/ViewPreloadSizeProvider;", "onCreateViewHolder", "com/magneticchen/daijishou/dialog_fragments/DownloadPlatformWallpapersPackListDialogFragment$onCreateDialog$1.ViewHolder", "viewGroup", "Landroid/view/ViewGroup;", "viewType", "", "(Landroid/view/ViewGroup;I)Lcom/magneticchen/daijishou/dialog_fragments/DownloadPlatformWallpapersPackListDialogFragment$onCreateDialog$1$ViewHolder;", "ViewHolder", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public final class AnonymousClass1 extends DaijishouRecyclerView.Adapter<PlatformWallpapersPacksIndexPlatformWallpaperPackListItemJson> {
        private final Function1<PlatformWallpapersPacksIndexPlatformWallpaperPackListItemJson, RequestBuilder<Drawable>> glideBuilderCreator;
        private final ViewPreloadSizeProvider<PlatformWallpapersPacksIndexPlatformWallpaperPackListItemJson> glideViewPreloadSizeProvider;

        AnonymousClass1(List<PlatformWallpapersPacksIndexPlatformWallpaperPackListItemJson> list) {
            super(list, false, false, 6, null);
            DownloadPlatformWallpapersPackListDialogFragment$onCreateDialog$1$glideBuilderCreator$1 downloadPlatformWallpapersPackListDialogFragment$onCreateDialog$1$glideBuilderCreator$1 = new DownloadPlatformWallpapersPackListDialogFragment$onCreateDialog$1$glideBuilderCreator$1(DownloadPlatformWallpapersPackListDialogFragment.this);
            this.glideBuilderCreator = downloadPlatformWallpapersPackListDialogFragment$onCreateDialog$1$glideBuilderCreator$1;
            this.glideViewPreloadSizeProvider = DaijishouRecyclerView.Adapter.addGlidePreloaderBuilderCreator$default(this, downloadPlatformWallpapersPackListDialogFragment$onCreateDialog$1$glideBuilderCreator$1, 0, 2, null);
        }

        /* JADX INFO: renamed from: com.magneticchen.daijishou.dialog_fragments.DownloadPlatformWallpapersPackListDialogFragment$onCreateDialog$1$ViewHolder */
        /* JADX INFO: compiled from: DownloadPlatformWallpapersPackListDialogFragment.kt */
        @Metadata(d1 = {"\u00007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\u008a\u0004\u0018\u00002\f0\u0001R\b\u0012\u0004\u0012\u00020\u00030\u0002B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0003H\u0016R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"com/magneticchen/daijishou/dialog_fragments/DownloadPlatformWallpapersPackListDialogFragment$onCreateDialog$1.ViewHolder", "Lcom/magneticchen/daijishou/daijishou_recycler_view/DaijishouRecyclerView$Adapter$ViewHolder;", "Lcom/magneticchen/daijishou/daijishou_recycler_view/DaijishouRecyclerView$Adapter;", "Lcom/magneticchen/daijishou/daijishou_library_db/portables/PlatformWallpapersPacksIndexPlatformWallpaperPackListItemJson;", "itemView", "Landroid/view/View;", "(Lcom/magneticchen/daijishou/dialog_fragments/DownloadPlatformWallpapersPackListDialogFragment$onCreateDialog$1;Landroid/view/View;)V", "imageView", "Lcom/google/android/material/imageview/ShapeableImageView;", "text1", "Landroid/widget/TextView;", "text2", "onBind", "", "position", "", "item", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public final class ViewHolder extends DaijishouRecyclerView.Adapter<PlatformWallpapersPacksIndexPlatformWallpaperPackListItemJson>.ViewHolder {
            private final ShapeableImageView imageView;
            private final TextView text1;
            private final TextView text2;
            final /* synthetic */ AnonymousClass1 this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public ViewHolder(AnonymousClass1 anonymousClass1, View itemView) {
                super(anonymousClass1, itemView);
                Intrinsics.checkNotNullParameter(itemView, "itemView");
                this.this$0 = anonymousClass1;
                View viewFindViewById = itemView.findViewById(R.id.list_item_theme_pack_choice_title);
                Intrinsics.checkNotNull(viewFindViewById, "null cannot be cast to non-null type android.widget.TextView");
                this.text1 = (TextView) viewFindViewById;
                View viewFindViewById2 = itemView.findViewById(R.id.list_item_theme_pack_choice_subtitle);
                Intrinsics.checkNotNull(viewFindViewById2, "null cannot be cast to non-null type android.widget.TextView");
                this.text2 = (TextView) viewFindViewById2;
                View viewFindViewById3 = itemView.findViewById(R.id.list_item_theme_pack_choice_image_view);
                Intrinsics.checkNotNull(viewFindViewById3, "null cannot be cast to non-null type com.google.android.material.imageview.ShapeableImageView");
                ShapeableImageView shapeableImageView = (ShapeableImageView) viewFindViewById3;
                this.imageView = shapeableImageView;
                anonymousClass1.glideViewPreloadSizeProvider.setView(shapeableImageView);
            }

            @Override // com.magneticchen.daijishou.daijishou_recycler_view.DaijishouRecyclerView.Adapter.ViewHolder
            public void onBind(int position, PlatformWallpapersPacksIndexPlatformWallpaperPackListItemJson item) {
                Intrinsics.checkNotNullParameter(item, "item");
                DownloadPlatformWallpapersPackListDialogFragment.this.getLogger().debug(this, "position: " + position + ". item: " + PlatformWallpapersPacksIndexPlatformWallpaperPackListItemJson.INSTANCE);
                ((RequestBuilder) this.this$0.glideBuilderCreator.invoke(item)).into(this.imageView);
                this.text1.setText(item.getPlatformWallpapersPackName());
                TextView textView = this.text2;
                String string = DownloadPlatformWallpapersPackListDialogFragment.this.getString(R.string.authors_format);
                Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                String str = String.format(string, Arrays.copyOf(new Object[]{CollectionsKt.joinToString$default(item.getPlatformWallpapersPackAuthors(), ", ", null, null, 0, null, null, 62, null)}, 1));
                Intrinsics.checkNotNullExpressionValue(str, "format(...)");
                textView.setText(str);
                this.text2.setAlpha(0.75f);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
            Intrinsics.checkNotNullParameter(viewGroup, "viewGroup");
            DownloadPlatformWallpapersPackListDialogFragment.this.getLogger().debug(this, "onCreateViewHolder");
            View viewInflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item_theme_pack_choice, viewGroup, false);
            Intrinsics.checkNotNull(viewInflate);
            return new ViewHolder(this, viewInflate);
        }
    }

    /* JADX INFO: renamed from: com.magneticchen.daijishou.dialog_fragments.DownloadPlatformWallpapersPackListDialogFragment$onCreateDialog$2, reason: invalid class name */
    /* JADX INFO: compiled from: DownloadPlatformWallpapersPackListDialogFragment.kt */
    @Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\n¢\u0006\u0002\b\n"}, d2 = {"<anonymous>", "", "<anonymous parameter 0>", "Landroid/view/View;", "<anonymous parameter 1>", "", "<anonymous parameter 2>", "", "it", "Lcom/magneticchen/daijishou/daijishou_library_db/portables/PlatformWallpapersPacksIndexPlatformWallpaperPackListItemJson;", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
    final class AnonymousClass2 extends Lambda<Unit> implements Function4<View, Integer, Long, PlatformWallpapersPacksIndexPlatformWallpaperPackListItemJson, Unit> {
        AnonymousClass2() {
            super(4);
        }

        @Override // kotlin.jvm.functions.Function4
        public /* bridge */ /* synthetic */ Unit invoke(View view, Integer num, Long l, PlatformWallpapersPacksIndexPlatformWallpaperPackListItemJson platformWallpapersPacksIndexPlatformWallpaperPackListItemJson) {
            invoke(view, num.intValue(), l.longValue(), platformWallpapersPacksIndexPlatformWallpaperPackListItemJson);
            return Unit.INSTANCE;
        }

        public final void invoke(View view, int i, long j, PlatformWallpapersPacksIndexPlatformWallpaperPackListItemJson it) {
            Intrinsics.checkNotNullParameter(view, "<anonymous parameter 0>");
            Intrinsics.checkNotNullParameter(it, "it");
            PlatformWallpapersPacksIndexJson platformWallpapersPacksIndexJson = DownloadPlatformWallpapersPackListDialogFragment.this.platformWallpapersPacksIndexJson;
            if (platformWallpapersPacksIndexJson != null) {
                DownloadPlatformWallpapersPackListDialogFragment downloadPlatformWallpapersPackListDialogFragment = DownloadPlatformWallpapersPackListDialogFragment.this;
                DownloadPlatformWallpapersPackDialogFragment.INSTANCE.newInstance(platformWallpapersPacksIndexJson.getBaseUri() + it.getPlatformWallpapersPackRootPath() + InternalZipConstants.ZIP_FILE_SEPARATOR).show(downloadPlatformWallpapersPackListDialogFragment.getParentFragmentManager(), DownloadPlatformWallpapersPackDialogFragment.class.getName());
            }
        }
    }
}
