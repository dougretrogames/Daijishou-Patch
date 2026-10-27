package com.magneticchen.daijishou.ui.fragments.dialog;

import android.app.Dialog;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.imageview.ShapeableImageView;
import com.google.android.material.progressindicator.LinearProgressIndicator;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.magneticchen.daijishou.R;
import com.magneticchen.daijishou.data.BooleanPreference;
import com.magneticchen.daijishou.data.StringPreference;
import com.magneticchen.daijishou.data.portables.PlatformWallpapersPackIndexJson;
import com.magneticchen.daijishou.data.portables.PlatformWallpapersPackIndexWallpaperListItemJson;
import com.magneticchen.daijishou.ui.fragments.p000abstract.DaijishouDialogFragment;
import com.magneticchen.daijishou.ui.widget.widgets.category.CategoryWidgetViewModel;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
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
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: compiled from: DownloadPlatformWallpapersPackDialogFragment.kt */
/* JADX INFO: loaded from: C:\Users\dfukuoka\Downloads\Daijishou\Daijishou\build_tmp\dex181_classes4.dex */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 '2\u00020\u0001:\u0001'B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0015\u001a\u00020\n2\b\b\u0002\u0010\u0016\u001a\u00020\u0017H\u0002J\u0018\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\u000eH\u0002J\u0012\u0010\u001c\u001a\u00020\u00192\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J&\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010$2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J\u0010\u0010%\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\bH\u0002J\b\u0010&\u001a\u00020\u0019H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000¨\u0006("}, d2 = {"Lcom/magneticchen/daijishou/ui/fragments/dialog/DownloadPlatformWallpapersPackDialogFragment;", "Lcom/magneticchen/daijishou/ui/fragments/abstract/DaijishouDialogFragment;", "()V", "description", "Landroid/widget/TextView;", "downloadButton", "Lcom/google/android/material/button/MaterialButton;", "downloadedString", "", "imageView", "Lcom/google/android/material/imageview/ShapeableImageView;", "linearProgressIndicator", "Lcom/google/android/material/progressindicator/LinearProgressIndicator;", "platformWallpapersPackIndexJson", "Lcom/magneticchen/daijishou/data/portables/PlatformWallpapersPackIndexJson;", "previews", "Landroid/widget/LinearLayout;", "sources", "sourcesTitle", "subtitle", "title", "createPreviewItem", "first", "", "inflateDetails", "", "packUrl", "pack", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDownloadPack", "onStart", "Companion", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class DownloadPlatformWallpapersPackDialogFragment extends DaijishouDialogFragment {
    public static final Companion Companion = new Companion(null);
    private TextView description;
    private MaterialButton downloadButton;
    private String downloadedString;
    private ShapeableImageView imageView;
    private LinearProgressIndicator linearProgressIndicator;
    private PlatformWallpapersPackIndexJson platformWallpapersPackIndexJson;
    private LinearLayout previews;
    private TextView sources;
    private TextView sourcesTitle;
    private TextView subtitle;
    private TextView title;

    /* JADX INFO: compiled from: DownloadPlatformWallpapersPackDialogFragment.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/magneticchen/daijishou/ui/fragments/dialog/DownloadPlatformWallpapersPackDialogFragment$Companion;", "", "()V", "newInstance", "Lcom/magneticchen/daijishou/ui/fragments/dialog/DownloadPlatformWallpapersPackDialogFragment;", "platformWallpaperPackUrlString", "", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
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

    @Override // com.magneticchen.daijishou.ui.fragments.p000abstract.DaijishouDialogFragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        String string = getString(R.string.downloaded);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        this.downloadedString = string;
    }

    public void onStart() {
        super.onStart();
        String string = requireArguments().getString("platformWallpaperPackUrlString");
        Intrinsics.checkNotNull(string);
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
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) this), Dispatchers.getIO(), (CoroutineStart) null, new C01081(string, dialogRequireDialog, null), 2, (Object) null);
    }

    /* JADX INFO: renamed from: com.magneticchen.daijishou.ui.fragments.dialog.DownloadPlatformWallpapersPackDialogFragment$onStart$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: DownloadPlatformWallpapersPackDialogFragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.magneticchen.daijishou.ui.fragments.dialog.DownloadPlatformWallpapersPackDialogFragment$onStart$1", f = "DownloadPlatformWallpapersPackDialogFragment.kt", i = {}, l = {97, 122}, m = "invokeSuspend", n = {}, s = {})
    static final class C01081 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Dialog $dialog;
        final /* synthetic */ String $platformWallpaperPackUrlString;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C01081(String str, Dialog dialog, Continuation<? super C01081> continuation) {
            super(2, continuation);
            this.$platformWallpaperPackUrlString = str;
            this.$dialog = dialog;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return DownloadPlatformWallpapersPackDialogFragment.this.new C01081(this.$platformWallpaperPackUrlString, this.$dialog, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C01081) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:15:0x007b, code lost:
        
            if (kotlinx.coroutines.BuildersKt.withContext(kotlinx.coroutines.Dispatchers.getMain(), new com.magneticchen.daijishou.ui.fragments.dialog.DownloadPlatformWallpapersPackDialogFragment.C01081.C00121(r6, r11.this$0, r11.$dialog, r11.$platformWallpaperPackUrlString, null), r11) == r1) goto L19;
         */
        /* JADX WARN: Code restructure failed: missing block: B:18:0x0097, code lost:
        
            if (kotlinx.coroutines.BuildersKt.withContext(kotlinx.coroutines.Dispatchers.getMain(), new com.magneticchen.daijishou.ui.fragments.dialog.DownloadPlatformWallpapersPackDialogFragment.C01081.AnonymousClass2(r11.this$0, r0, null), r11) == r1) goto L19;
         */
        /* JADX WARN: Code restructure failed: missing block: B:19:0x0099, code lost:
        
            return r1;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r12) {
            /*
                r11 = this;
                java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r0 = r11.label
                r2 = 2
                r3 = 1
                if (r0 == 0) goto L23
                if (r0 == r3) goto L1b
                if (r0 != r2) goto L13
                kotlin.ResultKt.throwOnFailure(r12)
                goto L9a
            L13:
                java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r12.<init>(r0)
                throw r12
            L1b:
                kotlin.ResultKt.throwOnFailure(r12)     // Catch: java.lang.Exception -> L20
                goto L9a
            L20:
                r0 = move-exception
                r12 = r0
                goto L7e
            L23:
                kotlin.ResultKt.throwOnFailure(r12)
                com.magneticchen.daijishou.ui.fragments.dialog.DownloadPlatformWallpapersPackDialogFragment r12 = com.magneticchen.daijishou.ui.fragments.dialog.DownloadPlatformWallpapersPackDialogFragment.this     // Catch: java.lang.Exception -> L20
                kotlinx.serialization.json.Json r12 = com.magneticchen.daijishou.ui.fragments.dialog.DownloadPlatformWallpapersPackDialogFragment.access$getWeakJson(r12)     // Catch: java.lang.Exception -> L20
                com.magneticchen.daijishou.data.portables.PlatformWallpapersPackIndexJson$Companion r0 = com.magneticchen.daijishou.data.portables.PlatformWallpapersPackIndexJson.Companion     // Catch: java.lang.Exception -> L20
                kotlinx.serialization.KSerializer r0 = r0.serializer()     // Catch: java.lang.Exception -> L20
                kotlinx.serialization.DeserializationStrategy r0 = (kotlinx.serialization.DeserializationStrategy) r0     // Catch: java.lang.Exception -> L20
                com.magneticchen.daijishou.utils.Utils r4 = com.magneticchen.daijishou.utils.Utils.INSTANCE     // Catch: java.lang.Exception -> L20
                java.lang.String r5 = r11.$platformWallpaperPackUrlString     // Catch: java.lang.Exception -> L20
                java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L20
                r6.<init>()     // Catch: java.lang.Exception -> L20
                java.lang.StringBuilder r5 = r6.append(r5)     // Catch: java.lang.Exception -> L20
                java.lang.String r6 = "index.json"
                java.lang.StringBuilder r5 = r5.append(r6)     // Catch: java.lang.Exception -> L20
                java.lang.String r5 = r5.toString()     // Catch: java.lang.Exception -> L20
                java.lang.String r4 = r4.readEntireTextFromURL(r5)     // Catch: java.lang.Exception -> L20
                java.lang.Object r12 = r12.decodeFromString(r0, r4)     // Catch: java.lang.Exception -> L20
                com.magneticchen.daijishou.ui.fragments.dialog.DownloadPlatformWallpapersPackDialogFragment r0 = com.magneticchen.daijishou.ui.fragments.dialog.DownloadPlatformWallpapersPackDialogFragment.this     // Catch: java.lang.Exception -> L20
                r4 = r12
                com.magneticchen.daijishou.data.portables.PlatformWallpapersPackIndexJson r4 = (com.magneticchen.daijishou.data.portables.PlatformWallpapersPackIndexJson) r4     // Catch: java.lang.Exception -> L20
                com.magneticchen.daijishou.ui.fragments.dialog.DownloadPlatformWallpapersPackDialogFragment.access$setPlatformWallpapersPackIndexJson$p(r0, r4)     // Catch: java.lang.Exception -> L20
                r6 = r12
                com.magneticchen.daijishou.data.portables.PlatformWallpapersPackIndexJson r6 = (com.magneticchen.daijishou.data.portables.PlatformWallpapersPackIndexJson) r6     // Catch: java.lang.Exception -> L20
                kotlinx.coroutines.MainCoroutineDispatcher r12 = kotlinx.coroutines.Dispatchers.getMain()     // Catch: java.lang.Exception -> L20
                kotlin.coroutines.CoroutineContext r12 = (kotlin.coroutines.CoroutineContext) r12     // Catch: java.lang.Exception -> L20
                com.magneticchen.daijishou.ui.fragments.dialog.DownloadPlatformWallpapersPackDialogFragment$onStart$1$1 r5 = new com.magneticchen.daijishou.ui.fragments.dialog.DownloadPlatformWallpapersPackDialogFragment$onStart$1$1     // Catch: java.lang.Exception -> L20
                com.magneticchen.daijishou.ui.fragments.dialog.DownloadPlatformWallpapersPackDialogFragment r7 = com.magneticchen.daijishou.ui.fragments.dialog.DownloadPlatformWallpapersPackDialogFragment.this     // Catch: java.lang.Exception -> L20
                android.app.Dialog r8 = r11.$dialog     // Catch: java.lang.Exception -> L20
                java.lang.String r9 = r11.$platformWallpaperPackUrlString     // Catch: java.lang.Exception -> L20
                r10 = 0
                r5.<init>(r6, r7, r8, r9, r10)     // Catch: java.lang.Exception -> L20
                kotlin.jvm.functions.Function2 r5 = (kotlin.jvm.functions.Function2) r5     // Catch: java.lang.Exception -> L20
                r0 = r11
                kotlin.coroutines.Continuation r0 = (kotlin.coroutines.Continuation) r0     // Catch: java.lang.Exception -> L20
                r11.label = r3     // Catch: java.lang.Exception -> L20
                java.lang.Object r12 = kotlinx.coroutines.BuildersKt.withContext(r12, r5, r0)     // Catch: java.lang.Exception -> L20
                if (r12 != r1) goto L9a
                goto L99
            L7e:
                kotlinx.coroutines.MainCoroutineDispatcher r0 = kotlinx.coroutines.Dispatchers.getMain()
                kotlin.coroutines.CoroutineContext r0 = (kotlin.coroutines.CoroutineContext) r0
                com.magneticchen.daijishou.ui.fragments.dialog.DownloadPlatformWallpapersPackDialogFragment$onStart$1$2 r3 = new com.magneticchen.daijishou.ui.fragments.dialog.DownloadPlatformWallpapersPackDialogFragment$onStart$1$2
                com.magneticchen.daijishou.ui.fragments.dialog.DownloadPlatformWallpapersPackDialogFragment r4 = com.magneticchen.daijishou.ui.fragments.dialog.DownloadPlatformWallpapersPackDialogFragment.this
                r5 = 0
                r3.<init>(r4, r12, r5)
                kotlin.jvm.functions.Function2 r3 = (kotlin.jvm.functions.Function2) r3
                r12 = r11
                kotlin.coroutines.Continuation r12 = (kotlin.coroutines.Continuation) r12
                r11.label = r2
                java.lang.Object r12 = kotlinx.coroutines.BuildersKt.withContext(r0, r3, r12)
                if (r12 != r1) goto L9a
            L99:
                return r1
            L9a:
                kotlin.Unit r12 = kotlin.Unit.INSTANCE
                return r12
            */
            throw new UnsupportedOperationException("Method not decompiled: com.magneticchen.daijishou.ui.fragments.dialog.DownloadPlatformWallpapersPackDialogFragment.C01081.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        /* JADX INFO: renamed from: com.magneticchen.daijishou.ui.fragments.dialog.DownloadPlatformWallpapersPackDialogFragment$onStart$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: DownloadPlatformWallpapersPackDialogFragment.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
        @DebugMetadata(c = "com.magneticchen.daijishou.ui.fragments.dialog.DownloadPlatformWallpapersPackDialogFragment$onStart$1$1", f = "DownloadPlatformWallpapersPackDialogFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        static final class C00121 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ Dialog $dialog;
            final /* synthetic */ PlatformWallpapersPackIndexJson $pack;
            final /* synthetic */ String $platformWallpaperPackUrlString;
            int label;
            final /* synthetic */ DownloadPlatformWallpapersPackDialogFragment this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C00121(PlatformWallpapersPackIndexJson platformWallpapersPackIndexJson, DownloadPlatformWallpapersPackDialogFragment downloadPlatformWallpapersPackDialogFragment, Dialog dialog, String str, Continuation<? super C00121> continuation) {
                super(2, continuation);
                this.$pack = platformWallpapersPackIndexJson;
                this.this$0 = downloadPlatformWallpapersPackDialogFragment;
                this.$dialog = dialog;
                this.$platformWallpaperPackUrlString = str;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new C00121(this.$pack, this.this$0, this.$dialog, this.$platformWallpaperPackUrlString, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((C00121) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                if (!this.$pack.isNSFW() || this.this$0.getDefaultSharedPreferences().getBoolean(BooleanPreference.USE_NSFW.getKey(), BooleanPreference.USE_NSFW.getDefaultValue())) {
                    this.this$0.inflateDetails(this.$platformWallpaperPackUrlString, this.$pack);
                    MaterialButton materialButton = this.this$0.downloadButton;
                    MaterialButton materialButton2 = null;
                    if (materialButton == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("downloadButton");
                        materialButton = null;
                    }
                    final DownloadPlatformWallpapersPackDialogFragment downloadPlatformWallpapersPackDialogFragment = this.this$0;
                    final String str = this.$platformWallpaperPackUrlString;
                    materialButton.setOnClickListener(new View.OnClickListener() { // from class: com.magneticchen.daijishou.ui.fragments.dialog.DownloadPlatformWallpapersPackDialogFragment$onStart$1$1$$ExternalSyntheticLambda0
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            DownloadPlatformWallpapersPackDialogFragment.C01081.C00121.invokeSuspend$lambda$0(downloadPlatformWallpapersPackDialogFragment, str, view);
                        }
                    });
                    LinearProgressIndicator linearProgressIndicator = this.this$0.linearProgressIndicator;
                    if (linearProgressIndicator == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("linearProgressIndicator");
                        linearProgressIndicator = null;
                    }
                    linearProgressIndicator.setVisibility(8);
                    MaterialButton materialButton3 = this.this$0.downloadButton;
                    if (materialButton3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("downloadButton");
                    } else {
                        materialButton2 = materialButton3;
                    }
                    materialButton2.setEnabled(true);
                    this.this$0.requireView().requestLayout();
                    return Unit.INSTANCE;
                }
                Toast.makeText(this.this$0.requireContext(), this.this$0.getString(R.string.aborted_period), 0).show();
                this.$dialog.dismiss();
                return Unit.INSTANCE;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final void invokeSuspend$lambda$0(final DownloadPlatformWallpapersPackDialogFragment downloadPlatformWallpapersPackDialogFragment, final String str, View view) {
                AcknowledgementDialogFragment.Companion.newInstance$default(AcknowledgementDialogFragment.Companion, downloadPlatformWallpapersPackDialogFragment.getString(R.string.are_you_sure), downloadPlatformWallpapersPackDialogFragment.getString(R.string.replace_wallpaper_warning), null, null, null, 28, null).setOnAcknowledgedListener(new Function0<Unit>() { // from class: com.magneticchen.daijishou.ui.fragments.dialog.DownloadPlatformWallpapersPackDialogFragment$onStart$1$1$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        downloadPlatformWallpapersPackDialogFragment.onDownloadPack(str);
                    }
                }).show(downloadPlatformWallpapersPackDialogFragment.getParentFragmentManager(), AcknowledgementDialogFragment.class.getName());
            }
        }

        /* JADX INFO: renamed from: com.magneticchen.daijishou.ui.fragments.dialog.DownloadPlatformWallpapersPackDialogFragment$onStart$1$2, reason: invalid class name */
        /* JADX INFO: compiled from: DownloadPlatformWallpapersPackDialogFragment.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
        @DebugMetadata(c = "com.magneticchen.daijishou.ui.fragments.dialog.DownloadPlatformWallpapersPackDialogFragment$onStart$1$2", f = "DownloadPlatformWallpapersPackDialogFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ Exception $e;
            int label;
            final /* synthetic */ DownloadPlatformWallpapersPackDialogFragment this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass2(DownloadPlatformWallpapersPackDialogFragment downloadPlatformWallpapersPackDialogFragment, Exception exc, Continuation<? super AnonymousClass2> continuation) {
                super(2, continuation);
                this.this$0 = downloadPlatformWallpapersPackDialogFragment;
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
        View viewFindViewById = viewInflate.findViewById(R.id.fragment_download_platform_wallpaper_pack_dialog_previews);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        this.previews = (LinearLayout) viewFindViewById;
        ShapeableImageView shapeableImageViewFindViewById = viewInflate.findViewById(R.id.fragment_download_platform_wallpaper_pack_dialog_image_view);
        Intrinsics.checkNotNullExpressionValue(shapeableImageViewFindViewById, "findViewById(...)");
        this.imageView = shapeableImageViewFindViewById;
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

    /* JADX INFO: Access modifiers changed from: private */
    public final void onDownloadPack(String str) {
        getDefaultSharedPreferences().edit().putString(StringPreference.SELECTED_PLATFORM_WALLPAPERS_PACK_URL_STRING.getKey(), str).apply();
        setCancelable(false);
        LinearProgressIndicator linearProgressIndicator = this.linearProgressIndicator;
        MaterialButton materialButton = null;
        if (linearProgressIndicator == null) {
            Intrinsics.throwUninitializedPropertyAccessException("linearProgressIndicator");
            linearProgressIndicator = null;
        }
        linearProgressIndicator.setVisibility(0);
        LinearProgressIndicator linearProgressIndicator2 = this.linearProgressIndicator;
        if (linearProgressIndicator2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("linearProgressIndicator");
            linearProgressIndicator2 = null;
        }
        linearProgressIndicator2.setIndeterminate(false);
        LinearProgressIndicator linearProgressIndicator3 = this.linearProgressIndicator;
        if (linearProgressIndicator3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("linearProgressIndicator");
            linearProgressIndicator3 = null;
        }
        linearProgressIndicator3.setProgress(1);
        MaterialButton materialButton2 = this.downloadButton;
        if (materialButton2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("downloadButton");
            materialButton2 = null;
        }
        materialButton2.setEnabled(false);
        MaterialButton materialButton3 = this.downloadButton;
        if (materialButton3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("downloadButton");
        } else {
            materialButton = materialButton3;
        }
        materialButton.setText(getString(R.string.downloading));
        getDaijishouLibrary().applyPlatformPreviewMediaPackIndexJsonToAllPlatforms(str, 0, new Function2<Boolean, Integer, Unit>() { // from class: com.magneticchen.daijishou.ui.fragments.dialog.DownloadPlatformWallpapersPackDialogFragment.onDownloadPack.1
            

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool, Integer num) {
                invoke(bool.booleanValue(), num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z, int i) {
                CharSequence charSequence = null;
                if (!z) {
                    if (i != -1) {
                        CharSequence charSequence2 = DownloadPlatformWallpapersPackDialogFragment.this.linearProgressIndicator;
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
                DownloadPlatformWallpapersPackDialogFragment.this.setCancelable(true);
                LinearProgressIndicator linearProgressIndicator4 = DownloadPlatformWallpapersPackDialogFragment.this.linearProgressIndicator;
                if (linearProgressIndicator4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("linearProgressIndicator");
                    linearProgressIndicator4 = null;
                }
                linearProgressIndicator4.setVisibility(8);
                LinearProgressIndicator linearProgressIndicator5 = DownloadPlatformWallpapersPackDialogFragment.this.linearProgressIndicator;
                if (linearProgressIndicator5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("linearProgressIndicator");
                    linearProgressIndicator5 = null;
                }
                linearProgressIndicator5.setProgress(100);
                MaterialButton materialButton4 = DownloadPlatformWallpapersPackDialogFragment.this.downloadButton;
                if (materialButton4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("downloadButton");
                    materialButton4 = null;
                }
                materialButton4.setEnabled(false);
                MaterialButton materialButton5 = DownloadPlatformWallpapersPackDialogFragment.this.downloadButton;
                if (materialButton5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("downloadButton");
                    materialButton5 = null;
                }
                CharSequence charSequence3 = DownloadPlatformWallpapersPackDialogFragment.this.downloadedString;
                if (charSequence3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("downloadedString");
                } else {
                    charSequence = charSequence3;
                }
                materialButton5.setText(charSequence);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void inflateDetails(String str, PlatformWallpapersPackIndexJson platformWallpapersPackIndexJson) {
        String string;
        StringBuilder sb;
        Fragment fragment = (Fragment) this;
        RequestBuilder requestBuilderLoad = Glide.with(fragment).load(str + platformWallpapersPackIndexJson.getPreviewThumbnailFilename());
        ShapeableImageView shapeableImageView = this.imageView;
        TextView textView = null;
        if (shapeableImageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("imageView");
            shapeableImageView = null;
        }
        requestBuilderLoad.into((ImageView) shapeableImageView);
        List listTake = CollectionsKt.take(platformWallpapersPackIndexJson.getWallpaperList(), 4);
        LinearLayout linearLayout = this.previews;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("previews");
            linearLayout = null;
        }
        linearLayout.removeAllViews();
        Iterator it = listTake.iterator();
        int i = 0;
        while (true) {
            boolean z = true;
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            PlatformWallpapersPackIndexWallpaperListItemJson platformWallpapersPackIndexWallpaperListItemJson = (PlatformWallpapersPackIndexWallpaperListItemJson) next;
            LinearLayout linearLayout2 = this.previews;
            if (linearLayout2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("previews");
                linearLayout2 = null;
            }
            if (i != 0) {
                z = false;
            }
            ImageView imageViewCreatePreviewItem = createPreviewItem(z);
            Glide.with(fragment).load(str + platformWallpapersPackIndexWallpaperListItemJson.getFilename()).into(imageViewCreatePreviewItem);
            linearLayout2.addView(imageViewCreatePreviewItem);
            i = i2;
        }
        TextView textView2 = this.subtitle;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("subtitle");
            textView2 = null;
        }
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String string2 = getString(R.string.authors_format);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
        String str2 = String.format(string2, Arrays.copyOf(new Object[]{CollectionsKt.joinToString$default(platformWallpapersPackIndexJson.getAuthors(), ", ", null, null, 0, null, null, 62, null)}, 1));
        Intrinsics.checkNotNullExpressionValue(str2, "format(...)");
        if (platformWallpapersPackIndexJson.getHasDefaultWallpaper()) {
            string = getString(R.string.default_wallpaper_included);
            sb = new StringBuilder("\n");
        } else {
            string = getString(R.string.default_wallpaper_not_included);
            sb = new StringBuilder("\n");
        }
        textView2.setText(str2 + sb.append(string).toString());
        TextView textView3 = this.sources;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sources");
            textView3 = null;
        }
        textView3.setText(CollectionsKt.joinToString$default(platformWallpapersPackIndexJson.getSources(), "\n", null, null, 0, null, null, 62, null));
        TextView textView4 = this.description;
        if (textView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("description");
            textView4 = null;
        }
        textView4.setText(platformWallpapersPackIndexJson.getDescription());
        TextView textView5 = this.title;
        if (textView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("title");
        } else {
            textView = textView5;
        }
        textView.setText(platformWallpapersPackIndexJson.getName());
    }

    static /* synthetic */ ShapeableImageView createPreviewItem$default(DownloadPlatformWallpapersPackDialogFragment downloadPlatformWallpapersPackDialogFragment, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        return downloadPlatformWallpapersPackDialogFragment.createPreviewItem(z);
    }

    private final ShapeableImageView createPreviewItem(boolean z) {
        ShapeableImageView shapeableImageView = new ShapeableImageView(getContext());
        ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(createPreviewItem$lambda$3$dp(shapeableImageView, 128.0f), createPreviewItem$lambda$3$dp(shapeableImageView, 64.0f));
        if (!z) {
            marginLayoutParams.leftMargin = createPreviewItem$lambda$3$dp(shapeableImageView, 16.0f);
        }
        shapeableImageView.setLayoutParams(marginLayoutParams);
        int iApplyDimension = (int) TypedValue.applyDimension(1, 1.0f, shapeableImageView.getResources().getDisplayMetrics());
        shapeableImageView.setPadding(iApplyDimension, iApplyDimension, iApplyDimension, iApplyDimension);
        shapeableImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        shapeableImageView.setShapeAppearanceModel(ShapeAppearanceModel.builder(shapeableImageView.getContext(), 0, R.style.RounderCornersSm).build());
        shapeableImageView.setStrokeWidth(TypedValue.applyDimension(1, 2.0f, shapeableImageView.getResources().getDisplayMetrics()));
        return shapeableImageView;
    }

    private static final int createPreviewItem$lambda$3$dp(ShapeableImageView shapeableImageView, float f) {
        return (int) TypedValue.applyDimension(1, f, shapeableImageView.getResources().getDisplayMetrics());
    }
}
