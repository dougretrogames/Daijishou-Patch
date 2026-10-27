package com.magneticchen.daijishou.ui.fragments.dialog;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.bumptech.glide.util.ViewPreloadSizeProvider;
import com.google.android.material.imageview.ShapeableImageView;
import com.magneticchen.daijishou.R;
import com.magneticchen.daijishou.data.BooleanPreference;
import com.magneticchen.daijishou.data.Constants;
import com.magneticchen.daijishou.data.StringPreference;
import com.magneticchen.daijishou.data.portables.PlatformWallpapersPacksIndexJson;
import com.magneticchen.daijishou.data.portables.PlatformWallpapersPacksIndexPlatformWallpaperPackListItemJson;
import com.magneticchen.daijishou.ui.daijishou_recycler_view.DaijishouLinearLayoutManager;
import com.magneticchen.daijishou.ui.daijishou_recycler_view.DaijishouRecyclerView;
import com.magneticchen.daijishou.ui.fragments.p000abstract.DaijishouDialogFragment;
import com.magneticchen.daijishou.ui.widget.widgets.category.CategoryWidgetViewModel;
import com.magneticchen.daijishou.utils.Utils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: compiled from: DownloadPlatformWallpapersPackListDialogFragment.kt */
/* JADX INFO: loaded from: C:\Users\dfukuoka\Downloads\Daijishou\Daijishou\build_tmp\dex181_classes4.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u000bH\u0002J\u0012\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\b\u0010\u001a\u001a\u00020\u001bH\u0016R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006\u001d"}, d2 = {"Lcom/magneticchen/daijishou/ui/fragments/dialog/DownloadPlatformWallpapersPackListDialogFragment;", "Lcom/magneticchen/daijishou/ui/fragments/abstract/DaijishouDialogFragment;", "()V", "platformWallpapersPacksIndexJson", "Lcom/magneticchen/daijishou/data/portables/PlatformWallpapersPacksIndexJson;", "progressBar", "Landroid/widget/ProgressBar;", "recyclerView", "Lcom/magneticchen/daijishou/ui/daijishou_recycler_view/DaijishouRecyclerView;", "recyclerViewAdapter", "Lcom/magneticchen/daijishou/ui/daijishou_recycler_view/DaijishouRecyclerView$Adapter;", "Lcom/magneticchen/daijishou/data/portables/PlatformWallpapersPacksIndexPlatformWallpaperPackListItemJson;", "recyclerViewItems", "", "scrollingOnBackPressed", "", "getScrollingOnBackPressed", "()Z", "setScrollingOnBackPressed", "(Z)V", "isActive", "item", "onCreateDialog", "Landroid/app/Dialog;", "savedInstanceState", "Landroid/os/Bundle;", "onStart", "", "Companion", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class DownloadPlatformWallpapersPackListDialogFragment extends DaijishouDialogFragment {
    public static final Companion Companion = new Companion(null);
    private PlatformWallpapersPacksIndexJson platformWallpapersPacksIndexJson;
    private ProgressBar progressBar;
    private DaijishouRecyclerView recyclerView;
    private DaijishouRecyclerView.Adapter<PlatformWallpapersPacksIndexPlatformWallpaperPackListItemJson> recyclerViewAdapter;
    private final List<PlatformWallpapersPacksIndexPlatformWallpaperPackListItemJson> recyclerViewItems = new ArrayList();
    private boolean scrollingOnBackPressed;

    /* JADX INFO: compiled from: DownloadPlatformWallpapersPackListDialogFragment.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"}, d2 = {"Lcom/magneticchen/daijishou/ui/fragments/dialog/DownloadPlatformWallpapersPackListDialogFragment$Companion;", "", "()V", "newInstance", "Lcom/magneticchen/daijishou/ui/fragments/dialog/DownloadPlatformWallpapersPackListDialogFragment;", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
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
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) this), Dispatchers.getIO(), (CoroutineStart) null, new C01091(null), 2, (Object) null);
    }

    /* JADX INFO: renamed from: com.magneticchen.daijishou.ui.fragments.dialog.DownloadPlatformWallpapersPackListDialogFragment$onStart$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: DownloadPlatformWallpapersPackListDialogFragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.magneticchen.daijishou.ui.fragments.dialog.DownloadPlatformWallpapersPackListDialogFragment$onStart$1", f = "DownloadPlatformWallpapersPackListDialogFragment.kt", i = {0}, l = {93}, m = "invokeSuspend", n = {"$this$launch"}, s = {"L$0"})
    static final class C01091 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        int label;

        C01091(Continuation<? super C01091> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C01091 c01091 = DownloadPlatformWallpapersPackListDialogFragment.this.new C01091(continuation);
            c01091.L$0 = obj;
            return c01091;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C01091) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineScope coroutineScope;
            Exception e;
            ArrayList platformWallpapersPackList;
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
                    downloadPlatformWallpapersPackListDialogFragment.platformWallpapersPacksIndexJson = (PlatformWallpapersPacksIndexJson) downloadPlatformWallpapersPackListDialogFragment.getWeakJson().decodeFromString(PlatformWallpapersPacksIndexJson.Companion.serializer(), Utils.INSTANCE.readEntireTextFromURL(Constants.platformWallpapersPacksIndexUri));
                    DownloadPlatformWallpapersPackListDialogFragment.this.getLogger().debug(coroutineScope2, "platformWallpapersPacksIndexJson: " + DownloadPlatformWallpapersPackListDialogFragment.this.platformWallpapersPacksIndexJson);
                    PlatformWallpapersPacksIndexJson platformWallpapersPacksIndexJson = DownloadPlatformWallpapersPackListDialogFragment.this.platformWallpapersPacksIndexJson;
                    if (platformWallpapersPacksIndexJson != null) {
                        final DownloadPlatformWallpapersPackListDialogFragment downloadPlatformWallpapersPackListDialogFragment2 = DownloadPlatformWallpapersPackListDialogFragment.this;
                        downloadPlatformWallpapersPackListDialogFragment2.recyclerViewItems.clear();
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
                        downloadPlatformWallpapersPackListDialogFragment2.recyclerViewItems.addAll(CollectionsKt.sortedWith(platformWallpapersPackList, new Comparator() { // from class: com.magneticchen.daijishou.ui.fragments.dialog.DownloadPlatformWallpapersPackListDialogFragment$onStart$1$invokeSuspend$lambda$2$$inlined$sortedByDescending$1
                            /* JADX WARN: Multi-variable type inference failed */
                            @Override // java.util.Comparator
                            public final int compare(T t, T t2) {
                                return ComparisonsKt.compareValues(Boolean.valueOf(downloadPlatformWallpapersPackListDialogFragment2.isActive((PlatformWallpapersPacksIndexPlatformWallpaperPackListItemJson) t2)), Boolean.valueOf(downloadPlatformWallpapersPackListDialogFragment2.isActive((PlatformWallpapersPacksIndexPlatformWallpaperPackListItemJson) t)));
                            }
                        }));
                        CoroutineContext main = Dispatchers.getMain();
                        DownloadPlatformWallpapersPackListDialogFragment$onStart$1$1$1 downloadPlatformWallpapersPackListDialogFragment$onStart$1$1$1 = new DownloadPlatformWallpapersPackListDialogFragment$onStart$1$1$1(downloadPlatformWallpapersPackListDialogFragment2, null);
                        this.L$0 = coroutineScope2;
                        this.label = 1;
                        if (BuildersKt.withContext(main, downloadPlatformWallpapersPackListDialogFragment$onStart$1$1$1, this) == coroutine_suspended) {
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

    @Override // com.magneticchen.daijishou.ui.fragments.p000abstract.DaijishouDialogFragment
    public Dialog onCreateDialog(Bundle bundle) {
        DaijishouRecyclerView.Adapter<PlatformWallpapersPacksIndexPlatformWallpaperPackListItemJson> adapter = null;
        View viewInflate = requireActivity().getLayoutInflater().inflate(R.layout.fragment_recycler_view_with_progress_bar_dialog, (ViewGroup) null);
        View viewFindViewById = viewInflate.findViewById(R.id.fragment_recycler_view_with_progress_bar_dialog_progress_bar);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        this.progressBar = (ProgressBar) viewFindViewById;
        Object objFindViewById = viewInflate.findViewById(R.id.fragment_recycler_view_with_progress_bar_dialog_recycler_view);
        Intrinsics.checkNotNullExpressionValue(objFindViewById, "findViewById(...)");
        this.recyclerView = (DaijishouRecyclerView) objFindViewById;
        this.recyclerViewAdapter = new DaijishouRecyclerView.Adapter<PlatformWallpapersPacksIndexPlatformWallpaperPackListItemJson>(this.recyclerViewItems) { // from class: com.magneticchen.daijishou.ui.fragments.dialog.DownloadPlatformWallpapersPackListDialogFragment.onCreateDialog.1
            private final Function1<PlatformWallpapersPacksIndexPlatformWallpaperPackListItemJson, RequestBuilder<Drawable>> glideBuilderCreator;
            private final ViewPreloadSizeProvider<PlatformWallpapersPacksIndexPlatformWallpaperPackListItemJson> glideViewPreloadSizeProvider;

            {
                Function1<PlatformWallpapersPacksIndexPlatformWallpaperPackListItemJson, RequestBuilder<Drawable>> function1 = new Function1<PlatformWallpapersPacksIndexPlatformWallpaperPackListItemJson, RequestBuilder<Drawable>>() { // from class: com.magneticchen.daijishou.ui.fragments.dialog.DownloadPlatformWallpapersPackListDialogFragment$onCreateDialog$1$glideBuilderCreator$1
                    

                    @Override // kotlin.jvm.functions.Function1
                    public final RequestBuilder<Drawable> invoke(PlatformWallpapersPacksIndexPlatformWallpaperPackListItemJson item) {
                        Intrinsics.checkNotNullParameter(item, "item");
                        PlatformWallpapersPacksIndexJson platformWallpapersPacksIndexJson = downloadPlatformWallpapersPackListDialogFragment.platformWallpapersPacksIndexJson;
                        Intrinsics.checkNotNull(platformWallpapersPacksIndexJson);
                        return Glide.with(downloadPlatformWallpapersPackListDialogFragment).load(platformWallpapersPacksIndexJson.getBaseUri() + item.getPlatformWallpapersPackPreviewThumbnailPath()).transition(DrawableTransitionOptions.withCrossFade());
                    }
                };
                this.glideBuilderCreator = function1;
                this.glideViewPreloadSizeProvider = DaijishouRecyclerView.Adapter.addGlidePreloaderBuilderCreator$default(this, function1, 0, 2, null);
            }

            /* JADX INFO: renamed from: com.magneticchen.daijishou.ui.fragments.dialog.DownloadPlatformWallpapersPackListDialogFragment$onCreateDialog$1$ViewHolder */
            /* JADX INFO: compiled from: DownloadPlatformWallpapersPackListDialogFragment.kt */
            @Metadata(d1 = {"\u00007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\u008a\u0004\u0018\u00002\f0\u0001R\b\u0012\u0004\u0012\u00020\u00030\u0002B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0003H\u0016R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"com/magneticchen/daijishou/ui/fragments/dialog/DownloadPlatformWallpapersPackListDialogFragment$onCreateDialog$1.ViewHolder", "Lcom/magneticchen/daijishou/ui/daijishou_recycler_view/DaijishouRecyclerView$Adapter$ViewHolder;", "Lcom/magneticchen/daijishou/ui/daijishou_recycler_view/DaijishouRecyclerView$Adapter;", "Lcom/magneticchen/daijishou/data/portables/PlatformWallpapersPacksIndexPlatformWallpaperPackListItemJson;", "itemView", "Landroid/view/View;", "(Lcom/magneticchen/daijishou/ui/fragments/dialog/DownloadPlatformWallpapersPackListDialogFragment$onCreateDialog$1;Landroid/view/View;)V", "imageView", "Lcom/google/android/material/imageview/ShapeableImageView;", "text1", "Landroid/widget/TextView;", "text2", "onBind", "", "position", "", "item", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
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
                    View view = (ShapeableImageView) viewFindViewById3;
                    this.imageView = view;
                    anonymousClass1.glideViewPreloadSizeProvider.setView(view);
                }

                @Override // com.magneticchen.daijishou.ui.daijishou_recycler_view.DaijishouRecyclerView.Adapter.ViewHolder
                public void onBind(int i, PlatformWallpapersPacksIndexPlatformWallpaperPackListItemJson item) {
                    Intrinsics.checkNotNullParameter(item, "item");
                    DownloadPlatformWallpapersPackListDialogFragment.this.getLogger().debug(this, "position: " + i + ". item: " + item);
                    ((RequestBuilder) this.this$0.glideBuilderCreator.invoke(item)).into(this.imageView);
                    if (DownloadPlatformWallpapersPackListDialogFragment.this.isActive(item)) {
                        this.text1.setText(item.getPlatformWallpapersPackName() + " (𝗖𝘂𝗿𝗿𝗲𝗻𝘁𝗹𝘆 𝗔𝗰𝘁𝗶𝘃𝗲)");
                    } else {
                        this.text1.setText(item.getPlatformWallpapersPackName());
                    }
                    TextView textView = this.text2;
                    String string = DownloadPlatformWallpapersPackListDialogFragment.this.getString(R.string.authors_format);
                    Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                    String str = String.format(string, Arrays.copyOf(new Object[]{CollectionsKt.joinToString$default(item.getPlatformWallpapersPackAuthors(), ", ", null, null, 0, null, null, 62, null)}, 1));
                    Intrinsics.checkNotNullExpressionValue(str, "format(...)");
                    textView.setText(str);
                    this.text2.setAlpha(0.75f);
                }
            }

            public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
                Intrinsics.checkNotNullParameter(viewGroup, "viewGroup");
                DownloadPlatformWallpapersPackListDialogFragment.this.getLogger().debug(this, "onCreateViewHolder");
                View viewInflate2 = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item_theme_pack_choice, viewGroup, false);
                Intrinsics.checkNotNull(viewInflate2);
                return new ViewHolder(this, viewInflate2);
            }
        };
        RecyclerView.ItemDecoration dividerItemDecoration = new DividerItemDecoration(requireContext(), 1);
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
        daijishouRecyclerView2.setLayoutManager((RecyclerView.LayoutManager) new DaijishouLinearLayoutManager(contextRequireContext, 1, false));
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
        AlertDialog alertDialogCreate = new AlertDialog.Builder(getContext()).setView(viewInflate).setTitle(getString(R.string.platform_wallpapers_packs)).setNegativeButton(getString(R.string.cancel), new DialogInterface.OnClickListener() { // from class: com.magneticchen.daijishou.ui.fragments.dialog.DownloadPlatformWallpapersPackListDialogFragment$$ExternalSyntheticLambda0
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        }).create();
        DaijishouRecyclerView.Adapter<PlatformWallpapersPacksIndexPlatformWallpaperPackListItemJson> adapter3 = this.recyclerViewAdapter;
        if (adapter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerViewAdapter");
        } else {
            adapter = adapter3;
        }
        adapter.setOnItemClickListener(new Function4<View, Integer, Long, PlatformWallpapersPacksIndexPlatformWallpaperPackListItemJson, Unit>() { // from class: com.magneticchen.daijishou.ui.fragments.dialog.DownloadPlatformWallpapersPackListDialogFragment.onCreateDialog.2
            

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
                    DownloadPlatformWallpapersPackDialogFragment.Companion.newInstance(platformWallpapersPacksIndexJson.getBaseUri() + it.getPlatformWallpapersPackRootPath() + "/").show(downloadPlatformWallpapersPackListDialogFragment.getParentFragmentManager(), DownloadPlatformWallpapersPackDialogFragment.class.getName());
                }
            }
        });
        Intrinsics.checkNotNull(alertDialogCreate);
        AlertDialog alertDialog = alertDialogCreate;
        setupDaijishouDialog(alertDialog);
        return alertDialog;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean isActive(PlatformWallpapersPacksIndexPlatformWallpaperPackListItemJson platformWallpapersPacksIndexPlatformWallpaperPackListItemJson) {
        String string = getDefaultSharedPreferences().getString(StringPreference.SELECTED_PLATFORM_WALLPAPERS_PACK_URL_STRING.getKey(), null);
        if (string != null) {
            if (StringsKt.endsWith$default(string, "/" + platformWallpapersPacksIndexPlatformWallpaperPackListItemJson.getPlatformWallpapersPackRootPath() + "/", false, 2, (Object) null)) {
                return true;
            }
        }
        return false;
    }
}
