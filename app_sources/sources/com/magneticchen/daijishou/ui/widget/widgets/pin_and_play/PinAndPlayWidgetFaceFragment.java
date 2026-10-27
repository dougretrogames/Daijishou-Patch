package com.magneticchen.daijishou.ui.widget.widgets.pin_and_play;

import android.app.Activity;
import android.app.Application;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import com.magneticchen.daijishou.DaijishouApplication;
import com.magneticchen.daijishou.R;
import com.magneticchen.daijishou.cache.CachedBitmapLoader;
import com.magneticchen.daijishou.data.BooleanPreference;
import com.magneticchen.daijishou.data.Constants;
import com.magneticchen.daijishou.data.db.entity.PinAndPlayWidgetInstanceEntity;
import com.magneticchen.daijishou.data.db.entity.PlayableItemEntity;
import com.magneticchen.daijishou.data.db.repositories.DaijishouWidgetRepository;
import com.magneticchen.daijishou.ui.fragments.dialog.PlayableItemDetailDialogFragment;
import com.magneticchen.daijishou.ui.model.DaijishouLibraryModel;
import com.magneticchen.daijishou.ui.widget.abstract_widget_classes.WidgetFaceFragment;
import com.magneticchen.daijishou.ui.widget.widgets.activity.ActivityWidgetGridFaceFragment;
import com.magneticchen.daijishou.utils.ScraperUtilsKt;
import com.magneticchen.daijishou.utils.Utils;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Date;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;

/* JADX INFO: compiled from: PinAndPlayWidgetFaceFragment.kt */
/* JADX INFO: loaded from: C:\Users\dfukuoka\Downloads\Daijishou\Daijishou\build_tmp\dex181_classes4.dex */
@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u0000 02\u00020\u0001:\u00010B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u001f\u001a\u00020 H\u0002J\b\u0010!\u001a\u00020 H\u0016J\u0012\u0010\"\u001a\u00020 2\b\u0010#\u001a\u0004\u0018\u00010$H\u0016J&\u0010%\u001a\u0004\u0018\u00010&2\u0006\u0010'\u001a\u00020(2\b\u0010)\u001a\u0004\u0018\u00010*2\b\u0010#\u001a\u0004\u0018\u00010$H\u0016J\b\u0010+\u001a\u00020 H\u0016J\u0018\u0010,\u001a\u00020 2\b\b\u0002\u0010-\u001a\u00020.H\u0082@¢\u0006\u0002\u0010/R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0006X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0010\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0011R\u0018\u0010\u0012\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0018\u0010\u0014\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u001f\u0010\u0016\u001a\u0010\u0012\f\u0012\n \u0019*\u0004\u0018\u00010\u00180\u00180\u0017¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u000e\u0010\u001c\u001a\u00020\u001dX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001dX\u0082.¢\u0006\u0002\n\u0000¨\u00061"}, d2 = {"Lcom/magneticchen/daijishou/ui/widget/widgets/pin_and_play/PinAndPlayWidgetFaceFragment;", "Lcom/magneticchen/daijishou/ui/widget/abstract_widget_classes/WidgetFaceFragment;", "()V", "cachedBitmap", "Landroid/graphics/Bitmap;", "imageView", "Landroid/widget/ImageView;", "lastUpdateTimestamp", "", "pinAndPlayWidgetInstanceEntity", "Lcom/magneticchen/daijishou/data/db/entity/PinAndPlayWidgetInstanceEntity;", "pinAndPlayWidgetMutex", "Lkotlinx/coroutines/sync/Mutex;", "placeholder", "playableItemEntity", "Lcom/magneticchen/daijishou/data/db/entity/PlayableItemEntity;", "playableItemId", "Ljava/lang/Long;", "playableItemLiveData", "Landroidx/lifecycle/LiveData;", "playableItemObserver", "Landroidx/lifecycle/Observer;", "selectImageActivity", "Landroidx/activity/result/ActivityResultLauncher;", "", "kotlin.jvm.PlatformType", "getSelectImageActivity", "()Landroidx/activity/result/ActivityResultLauncher;", "subtitle", "Landroid/widget/TextView;", "title", "ensureWallpaperDirectory", "", "onClick", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onPreload", "updateFace", "updateView", "", "(ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class PinAndPlayWidgetFaceFragment extends WidgetFaceFragment {
    public static final Companion Companion = new Companion(null);
    private Bitmap cachedBitmap;
    private ImageView imageView;
    private long lastUpdateTimestamp;
    private PinAndPlayWidgetInstanceEntity pinAndPlayWidgetInstanceEntity;
    private Mutex pinAndPlayWidgetMutex = MutexKt.Mutex$default(false, 1, (Object) null);
    private ImageView placeholder;
    private PlayableItemEntity playableItemEntity;
    private Long playableItemId;
    private LiveData<PlayableItemEntity> playableItemLiveData;
    private Observer<PlayableItemEntity> playableItemObserver;
    private final ActivityResultLauncher<String> selectImageActivity;
    private TextView subtitle;
    private TextView title;

    /* JADX INFO: renamed from: com.magneticchen.daijishou.ui.widget.widgets.pin_and_play.PinAndPlayWidgetFaceFragment$updateFace$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: PinAndPlayWidgetFaceFragment.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.magneticchen.daijishou.ui.widget.widgets.pin_and_play.PinAndPlayWidgetFaceFragment", f = "PinAndPlayWidgetFaceFragment.kt", i = {0, 0, 0, 1, 1, 2, 2, 2, 2, 3, 4, 4}, l = {347, 168, ActivityWidgetGridFaceFragment.BASE_ALPHA, 188, 266}, m = "updateFace", n = {"this", "$this$withLock_u24default$iv", "updateView", "this", "$this$withLock_u24default$iv", "this", "$this$withLock_u24default$iv", "playableItemEntity", "updateView", "$this$withLock_u24default$iv", "this", "$this$withLock_u24default$iv"}, s = {"L$0", "L$1", "Z$0", "L$0", "L$1", "L$0", "L$1", "L$2", "Z$0", "L$0", "L$0", "L$1"})
    static final class C01461 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        boolean Z$0;
        int label;
        /* synthetic */ Object result;

        C01461(Continuation<? super C01461> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return PinAndPlayWidgetFaceFragment.this.updateFace(false, this);
        }
    }

    public PinAndPlayWidgetFaceFragment() {
        ActivityResultLauncher<String> activityResultLauncherRegisterForActivityResult = registerForActivityResult((ActivityResultContract) new ActivityResultContracts.GetContent(), new ActivityResultCallback() { // from class: com.magneticchen.daijishou.ui.widget.widgets.pin_and_play.PinAndPlayWidgetFaceFragment$$ExternalSyntheticLambda0
            public final void onActivityResult(Object obj) {
                PinAndPlayWidgetFaceFragment.selectImageActivity$lambda$1(this.f$0, (Uri) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(activityResultLauncherRegisterForActivityResult, "registerForActivityResult(...)");
        this.selectImageActivity = activityResultLauncherRegisterForActivityResult;
    }

    public static final /* synthetic */ ImageView access$getPlaceholder$p(PinAndPlayWidgetFaceFragment pinAndPlayWidgetFaceFragment) {
        return pinAndPlayWidgetFaceFragment.placeholder;
    }

    public static final /* synthetic */ TextView access$getTitle$p(PinAndPlayWidgetFaceFragment pinAndPlayWidgetFaceFragment) {
        return pinAndPlayWidgetFaceFragment.title;
    }

    /* JADX INFO: compiled from: PinAndPlayWidgetFaceFragment.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/magneticchen/daijishou/ui/widget/widgets/pin_and_play/PinAndPlayWidgetFaceFragment$Companion;", "", "()V", "newInstance", "Lcom/magneticchen/daijishou/ui/widget/widgets/pin_and_play/PinAndPlayWidgetFaceFragment;", "widgetInstanceId", "", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final PinAndPlayWidgetFaceFragment newInstance(long j) {
            PinAndPlayWidgetFaceFragment pinAndPlayWidgetFaceFragment = new PinAndPlayWidgetFaceFragment();
            Bundle bundle = new Bundle();
            bundle.putLong("widgetInstanceId", j);
            pinAndPlayWidgetFaceFragment.setArguments(bundle);
            return pinAndPlayWidgetFaceFragment;
        }
    }

    public final ActivityResultLauncher<String> getSelectImageActivity() {
        return this.selectImageActivity;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void selectImageActivity$lambda$1(PinAndPlayWidgetFaceFragment this$0, Uri uri) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        long j = this$0.requireArguments().getLong("widgetInstanceId");
        if (uri == null) {
            return;
        }
        Application application = this$0.requireActivity().getApplication();
        Intrinsics.checkNotNull(application, "null cannot be cast to non-null type com.magneticchen.daijishou.DaijishouApplication");
        DaijishouWidgetRepository daijishouWidgetRepository = ((DaijishouApplication) application).getDaijishouWidgetRepository();
        this$0.ensureWallpaperDirectory();
        PinAndPlayWidgetInstanceEntity pinAndPlayWidgetInstanceByIdStatically = daijishouWidgetRepository.getPinAndPlayWidgetInstanceByIdStatically(j);
        if (pinAndPlayWidgetInstanceByIdStatically != null) {
            Bitmap bitmapDecodeStream = BitmapFactory.decodeStream(this$0.requireActivity().getContentResolver().openInputStream(uri));
            Intrinsics.checkNotNull(bitmapDecodeStream);
            Bitmap resizedBitmap = ScraperUtilsKt.getResizedBitmap(bitmapDecodeStream, 256);
            Intrinsics.checkNotNull(resizedBitmap);
            String str = this$0.requireContext().getFilesDir() + "/pin_and_play_widget_images/" + j + ".png";
            resizedBitmap.compress(Constants.INSTANCE.getWidgetThumbnailFormat(), 100, new FileOutputStream(str));
            pinAndPlayWidgetInstanceByIdStatically.setAlternativeImagePath(str);
            daijishouWidgetRepository.updatePinAndPlayWidgetInstance(pinAndPlayWidgetInstanceByIdStatically);
        }
    }

    @Override // com.magneticchen.daijishou.ui.widget.abstract_widget_classes.WidgetFaceFragment
    public void onPreload() {
        super.onPreload();
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) this), Dispatchers.getIO(), (CoroutineStart) null, new AnonymousClass1(null), 2, (Object) null);
    }

    /* JADX INFO: renamed from: com.magneticchen.daijishou.ui.widget.widgets.pin_and_play.PinAndPlayWidgetFaceFragment$onPreload$1, reason: invalid class name */
    /* JADX INFO: compiled from: PinAndPlayWidgetFaceFragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.magneticchen.daijishou.ui.widget.widgets.pin_and_play.PinAndPlayWidgetFaceFragment$onPreload$1", f = "PinAndPlayWidgetFaceFragment.kt", i = {0}, l = {347}, m = "invokeSuspend", n = {"$this$withLock_u24default$iv"}, s = {"L$0"})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        Object L$0;
        Object L$1;
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return PinAndPlayWidgetFaceFragment.this.new AnonymousClass1(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Mutex mutex;
            final PinAndPlayWidgetFaceFragment pinAndPlayWidgetFaceFragment;
            Long playableItemId;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                mutex = PinAndPlayWidgetFaceFragment.this.pinAndPlayWidgetMutex;
                PinAndPlayWidgetFaceFragment pinAndPlayWidgetFaceFragment2 = PinAndPlayWidgetFaceFragment.this;
                this.L$0 = mutex;
                this.L$1 = pinAndPlayWidgetFaceFragment2;
                this.label = 1;
                if (mutex.lock((Object) null, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                pinAndPlayWidgetFaceFragment = pinAndPlayWidgetFaceFragment2;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                pinAndPlayWidgetFaceFragment = (PinAndPlayWidgetFaceFragment) this.L$1;
                mutex = (Mutex) this.L$0;
                ResultKt.throwOnFailure(obj);
            }
            try {
                try {
                    PinAndPlayWidgetInstanceEntity pinAndPlayWidgetInstanceByIdStatically = pinAndPlayWidgetFaceFragment.getDaijishouWidgetRepository().getPinAndPlayWidgetInstanceByIdStatically(pinAndPlayWidgetFaceFragment.requireArguments().getLong("widgetInstanceId"));
                    if (pinAndPlayWidgetInstanceByIdStatically != null && (playableItemId = pinAndPlayWidgetInstanceByIdStatically.getPlayableItemId()) != null) {
                        PlayableItemEntity playableItemByIdStatically = pinAndPlayWidgetFaceFragment.getDaijishouLibraryRepository().getPlayableItemByIdStatically(playableItemId.longValue());
                        if (playableItemByIdStatically != null) {
                            String boxArtPath = Utils.INSTANCE.getBoxArtPath(playableItemByIdStatically);
                            PinAndPlayWidgetInstanceEntity pinAndPlayWidgetInstanceEntity = pinAndPlayWidgetFaceFragment.pinAndPlayWidgetInstanceEntity;
                            String alternativeImagePath = pinAndPlayWidgetInstanceEntity != null ? pinAndPlayWidgetInstanceEntity.getAlternativeImagePath() : null;
                            if (boxArtPath == null && alternativeImagePath == null) {
                                return Unit.INSTANCE;
                            }
                            if (alternativeImagePath != null) {
                                CachedBitmapLoader.CachedBitmapLoaderTask.load$default(pinAndPlayWidgetFaceFragment.getApplication().getCachedBoxArtBitmapLoader().with(pinAndPlayWidgetFaceFragment), alternativeImagePath, false, 2, null).setOnFailedListener(new Function1<Exception, Unit>() { // from class: com.magneticchen.daijishou.ui.widget.widgets.pin_and_play.PinAndPlayWidgetFaceFragment$onPreload$1$1$1$1$1$1
                                    

                                    @Override // kotlin.jvm.functions.Function1
                                    public /* bridge */ /* synthetic */ Unit invoke(Exception exc) {
                                        invoke2(exc);
                                        return Unit.INSTANCE;
                                    }

                                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                    public final void invoke2(Exception it) {
                                        Intrinsics.checkNotNullParameter(it, "it");
                                        pinAndPlayWidgetFaceFragment.cachedBitmap = null;
                                    }
                                }).setOnSucceedListener(new Function2<Bitmap, Boolean, Unit>() { // from class: com.magneticchen.daijishou.ui.widget.widgets.pin_and_play.PinAndPlayWidgetFaceFragment$onPreload$1$1$1$1$1$2
                                    

                                    @Override // kotlin.jvm.functions.Function2
                                    public /* bridge */ /* synthetic */ Unit invoke(Bitmap bitmap, Boolean bool) {
                                        invoke(bitmap, bool.booleanValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(Bitmap bitmap, boolean z) {
                                        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
                                        if (Intrinsics.areEqual(pinAndPlayWidgetFaceFragment.cachedBitmap, bitmap)) {
                                            return;
                                        }
                                        pinAndPlayWidgetFaceFragment.cachedBitmap = bitmap;
                                    }
                                }).intoNothing();
                            } else if (boxArtPath != null) {
                                CachedBitmapLoader.CachedBitmapLoaderTask.load$default(pinAndPlayWidgetFaceFragment.getApplication().getCachedBoxArtBitmapLoader().with(pinAndPlayWidgetFaceFragment), boxArtPath, false, 2, null).setOnFailedListener(new Function1<Exception, Unit>() { // from class: com.magneticchen.daijishou.ui.widget.widgets.pin_and_play.PinAndPlayWidgetFaceFragment$onPreload$1$1$1$1$1$3
                                    

                                    @Override // kotlin.jvm.functions.Function1
                                    public /* bridge */ /* synthetic */ Unit invoke(Exception exc) {
                                        invoke2(exc);
                                        return Unit.INSTANCE;
                                    }

                                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                    public final void invoke2(Exception it) {
                                        Intrinsics.checkNotNullParameter(it, "it");
                                        pinAndPlayWidgetFaceFragment.cachedBitmap = null;
                                    }
                                }).setOnSucceedListener(new Function2<Bitmap, Boolean, Unit>() { // from class: com.magneticchen.daijishou.ui.widget.widgets.pin_and_play.PinAndPlayWidgetFaceFragment$onPreload$1$1$1$1$1$4
                                    

                                    @Override // kotlin.jvm.functions.Function2
                                    public /* bridge */ /* synthetic */ Unit invoke(Bitmap bitmap, Boolean bool) {
                                        invoke(bitmap, bool.booleanValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(Bitmap bitmap, boolean z) {
                                        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
                                        if (Intrinsics.areEqual(pinAndPlayWidgetFaceFragment.cachedBitmap, bitmap)) {
                                            return;
                                        }
                                        pinAndPlayWidgetFaceFragment.cachedBitmap = bitmap;
                                    }
                                }).intoNothing();
                            }
                        }
                    }
                } catch (Exception e) {
                    pinAndPlayWidgetFaceFragment.getLogger().error(pinAndPlayWidgetFaceFragment, ExceptionsKt.stackTraceToString(e));
                }
                Unit unit = Unit.INSTANCE;
                return Unit.INSTANCE;
            } finally {
                mutex.unlock((Object) null);
            }
        }
    }

    @Override // com.magneticchen.daijishou.ui.widget.abstract_widget_classes.WidgetFaceFragment
    public void onClick() {
        super.onClick();
        PlayableItemEntity playableItemEntity = this.playableItemEntity;
        if (playableItemEntity != null) {
            if (getDefaultSharedPreferences().getBoolean(BooleanPreference.DETAIL_VIEW_ON_CLICK.getKey(), BooleanPreference.DETAIL_VIEW_ON_CLICK.getDefaultValue())) {
                PlayableItemDetailDialogFragment.Companion.newInstance(playableItemEntity).show(getParentFragmentManager(), PlayableItemDetailDialogFragment.class.getName());
                return;
            }
            DaijishouLibraryModel daijishouLibrary = getDaijishouLibrary();
            Activity activityRequireActivity = requireActivity();
            Intrinsics.checkNotNullExpressionValue(activityRequireActivity, "requireActivity(...)");
            DaijishouLibraryModel.play$default(daijishouLibrary, activityRequireActivity, playableItemEntity, null, 4, null);
        }
    }

    private final void ensureWallpaperDirectory() {
        File file = new File(requireContext().getFilesDir() + "/pin_and_play_widget_images/");
        if (file.exists()) {
            return;
        }
        file.mkdirs();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:46:0x00d9  */
    /* JADX WARN: Code duplicated, block: B:47:0x00da  */
    /* JADX WARN: Code duplicated, block: B:57:0x0113 A[Catch: all -> 0x0064, TryCatch #0 {all -> 0x0064, blocks: (B:24:0x005f, B:55:0x0109, B:57:0x0113, B:61:0x011d, B:63:0x0121, B:68:0x0141, B:70:0x016e, B:71:0x0172, B:73:0x017a, B:75:0x01a8, B:76:0x01ac), top: B:83:0x005f }] */
    /* JADX WARN: Code duplicated, block: B:58:0x0118  */
    /* JADX WARN: Code duplicated, block: B:66:0x013d  */
    /* JADX WARN: Code duplicated, block: B:68:0x0141 A[Catch: all -> 0x0064, TRY_ENTER, TryCatch #0 {all -> 0x0064, blocks: (B:24:0x005f, B:55:0x0109, B:57:0x0113, B:61:0x011d, B:63:0x0121, B:68:0x0141, B:70:0x016e, B:71:0x0172, B:73:0x017a, B:75:0x01a8, B:76:0x01ac), top: B:83:0x005f }] */
    /* JADX WARN: Code duplicated, block: B:70:0x016e A[Catch: all -> 0x0064, TryCatch #0 {all -> 0x0064, blocks: (B:24:0x005f, B:55:0x0109, B:57:0x0113, B:61:0x011d, B:63:0x0121, B:68:0x0141, B:70:0x016e, B:71:0x0172, B:73:0x017a, B:75:0x01a8, B:76:0x01ac), top: B:83:0x005f }] */
    /* JADX WARN: Code duplicated, block: B:72:0x0178 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:73:0x017a A[Catch: all -> 0x0064, TryCatch #0 {all -> 0x0064, blocks: (B:24:0x005f, B:55:0x0109, B:57:0x0113, B:61:0x011d, B:63:0x0121, B:68:0x0141, B:70:0x016e, B:71:0x0172, B:73:0x017a, B:75:0x01a8, B:76:0x01ac), top: B:83:0x005f }] */
    /* JADX WARN: Code duplicated, block: B:75:0x01a8 A[Catch: all -> 0x0064, TryCatch #0 {all -> 0x0064, blocks: (B:24:0x005f, B:55:0x0109, B:57:0x0113, B:61:0x011d, B:63:0x0121, B:68:0x0141, B:70:0x016e, B:71:0x0172, B:73:0x017a, B:75:0x01a8, B:76:0x01ac), top: B:83:0x005f }] */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x013a, code lost:
    
        if (kotlinx.coroutines.BuildersKt.withContext(r12, r13, r0) == r1) goto L65;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v21 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object updateFace(boolean r12, kotlin.coroutines.Continuation<? super kotlin.Unit> r13) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 444
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.magneticchen.daijishou.ui.widget.widgets.pin_and_play.PinAndPlayWidgetFaceFragment.updateFace(boolean, kotlin.coroutines.Continuation):java.lang.Object");
    }

    static /* synthetic */ Object updateFace$default(PinAndPlayWidgetFaceFragment pinAndPlayWidgetFaceFragment, boolean z, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        return pinAndPlayWidgetFaceFragment.updateFace(z, continuation);
    }

    @Override // com.magneticchen.daijishou.ui.widget.abstract_widget_classes.WidgetFaceFragment, com.magneticchen.daijishou.ui.fragments.p000abstract.DaijishouFragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        long j = requireArguments().getLong("widgetInstanceId");
        View viewInflate = inflater.inflate(R.layout.widget_face_pin_and_play, viewGroup, false);
        View viewFindViewById = viewInflate.findViewById(R.id.widget_face_pin_and_play_image_view);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        this.imageView = (ImageView) viewFindViewById;
        View viewFindViewById2 = viewInflate.findViewById(R.id.widget_face_pin_and_play_placeholder);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
        this.placeholder = (ImageView) viewFindViewById2;
        View viewFindViewById3 = viewInflate.findViewById(R.id.widget_face_pin_and_play_title);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById3, "findViewById(...)");
        this.title = (TextView) viewFindViewById3;
        View viewFindViewById4 = viewInflate.findViewById(R.id.widget_face_pin_and_play_subtitle);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById4, "findViewById(...)");
        TextView textView = (TextView) viewFindViewById4;
        this.subtitle = textView;
        PlayableItemEntity playableItemEntity = this.playableItemEntity;
        ImageView imageView = null;
        if (playableItemEntity != null) {
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("subtitle");
                textView = null;
            }
            textView.setText(getDaijishouLibrary().prettifyTitle(playableItemEntity.getName(), false));
        }
        if (this.cachedBitmap != null) {
            TextView textView2 = this.title;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("title");
                textView2 = null;
            }
            if (textView2.getVisibility() != 8) {
                TextView textView3 = this.title;
                if (textView3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("title");
                    textView3 = null;
                }
                textView3.setVisibility(8);
            }
            TextView textView4 = this.subtitle;
            if (textView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("subtitle");
                textView4 = null;
            }
            if (textView4.getVisibility() != 8) {
                TextView textView5 = this.subtitle;
                if (textView5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("subtitle");
                    textView5 = null;
                }
                textView5.setVisibility(8);
            }
            ImageView imageView2 = this.placeholder;
            if (imageView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("placeholder");
                imageView2 = null;
            }
            if (imageView2.getVisibility() != 8) {
                ImageView imageView3 = this.placeholder;
                if (imageView3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("placeholder");
                    imageView3 = null;
                }
                imageView3.setVisibility(8);
            }
            ImageView imageView4 = this.imageView;
            if (imageView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("imageView");
            } else {
                imageView = imageView4;
            }
            imageView.setImageBitmap(this.cachedBitmap);
        }
        Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        booleanRef.element = true;
        getDaijishouWidgetRepository().getPinAndPlayWidgetInstanceById(j).observe(getViewLifecycleOwner(), new PinAndPlayWidgetFaceFragment$sam$androidx_lifecycle_Observer$0(new AnonymousClass3(booleanRef)));
        return viewInflate;
    }

    /* JADX INFO: renamed from: com.magneticchen.daijishou.ui.widget.widgets.pin_and_play.PinAndPlayWidgetFaceFragment$onCreateView$3, reason: invalid class name */
    /* JADX INFO: compiled from: PinAndPlayWidgetFaceFragment.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lcom/magneticchen/daijishou/data/db/entity/PinAndPlayWidgetInstanceEntity;", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
    static final class AnonymousClass3 extends Lambda implements Function1<PinAndPlayWidgetInstanceEntity, Unit> {
        final /* synthetic */ Ref.BooleanRef $firstTime;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass3(Ref.BooleanRef booleanRef) {
            super(1);
            this.$firstTime = booleanRef;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(PinAndPlayWidgetInstanceEntity pinAndPlayWidgetInstanceEntity) {
            invoke2(pinAndPlayWidgetInstanceEntity);
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(PinAndPlayWidgetInstanceEntity pinAndPlayWidgetInstanceEntity) {
            LiveData liveData;
            Date lastUpdateTimestamp;
            PinAndPlayWidgetFaceFragment.this.pinAndPlayWidgetInstanceEntity = pinAndPlayWidgetInstanceEntity;
            long time = (pinAndPlayWidgetInstanceEntity == null || (lastUpdateTimestamp = pinAndPlayWidgetInstanceEntity.getLastUpdateTimestamp()) == null) ? 0L : lastUpdateTimestamp.getTime();
            if (PinAndPlayWidgetFaceFragment.this.lastUpdateTimestamp == time) {
                return;
            }
            PinAndPlayWidgetFaceFragment.this.lastUpdateTimestamp = time;
            PinAndPlayWidgetFaceFragment.this.playableItemId = pinAndPlayWidgetInstanceEntity != null ? pinAndPlayWidgetInstanceEntity.getPlayableItemId() : null;
            if (!this.$firstTime.element) {
                ImageView imageView = PinAndPlayWidgetFaceFragment.this.imageView;
                if (imageView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("imageView");
                    imageView = null;
                }
                imageView.setImageBitmap(null);
                PinAndPlayWidgetFaceFragment.this.cachedBitmap = null;
            }
            this.$firstTime.element = false;
            Observer observer = PinAndPlayWidgetFaceFragment.this.playableItemObserver;
            if (observer != null && (liveData = PinAndPlayWidgetFaceFragment.this.playableItemLiveData) != null) {
                liveData.removeObserver(observer);
            }
            PinAndPlayWidgetFaceFragment.this.playableItemObserver = null;
            PinAndPlayWidgetFaceFragment.this.playableItemLiveData = null;
            PinAndPlayWidgetFaceFragment.this.playableItemEntity = null;
            Long l = PinAndPlayWidgetFaceFragment.this.playableItemId;
            if (l != null) {
                final PinAndPlayWidgetFaceFragment pinAndPlayWidgetFaceFragment = PinAndPlayWidgetFaceFragment.this;
                long jLongValue = l.longValue();
                pinAndPlayWidgetFaceFragment.playableItemObserver = new Observer() { // from class: com.magneticchen.daijishou.ui.widget.widgets.pin_and_play.PinAndPlayWidgetFaceFragment$onCreateView$3$$ExternalSyntheticLambda0
                    public final void onChanged(Object obj) {
                        PinAndPlayWidgetFaceFragment.AnonymousClass3.invoke$lambda$2$lambda$1(pinAndPlayWidgetFaceFragment, (PlayableItemEntity) obj);
                    }
                };
                pinAndPlayWidgetFaceFragment.playableItemLiveData = pinAndPlayWidgetFaceFragment.getDaijishouLibrary().getPlayableItemById(jLongValue);
                LiveData liveData2 = pinAndPlayWidgetFaceFragment.playableItemLiveData;
                Intrinsics.checkNotNull(liveData2);
                LifecycleOwner viewLifecycleOwner = pinAndPlayWidgetFaceFragment.getViewLifecycleOwner();
                Observer observer2 = pinAndPlayWidgetFaceFragment.playableItemObserver;
                Intrinsics.checkNotNull(observer2);
                liveData2.observe(viewLifecycleOwner, observer2);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void invoke$lambda$2$lambda$1(PinAndPlayWidgetFaceFragment this$0, PlayableItemEntity playableItemEntity) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.playableItemEntity = playableItemEntity;
            BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) this$0), Dispatchers.getIO(), (CoroutineStart) null, new PinAndPlayWidgetFaceFragment$onCreateView$3$2$1$1(this$0, null), 2, (Object) null);
        }
    }
}
