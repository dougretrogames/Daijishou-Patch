package com.magneticchen.daijishou.daijishou_widget.widgets.activity;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.magneticchen.daijishou.daijishou_library_db.PlayableItemEntity;
import com.magneticchen.daijishou.daijishou_library_db.PlayableItemPreviewMediaIndex;
import com.magneticchen.daijishou.utils.ScaledBitmapLoader;
import com.magneticchen.daijishou.utils.Utils;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: compiled from: ActivityWidgetContinueFaceFragment.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.magneticchen.daijishou.daijishou_widget.widgets.activity.ActivityWidgetContinueFaceFragment$onCreateView$2$1$1", f = "ActivityWidgetContinueFaceFragment.kt", i = {}, l = {109, 115, 123}, m = "invokeSuspendImpl", n = {}, s = {})
final class ActivityWidgetContinueFaceFragment$onCreateView$2$1$1 extends com.magneticchen.daijishou.support.DaijishouSuspendLambda implements Function2<CoroutineScope, Continuation<?>, Object> {
    Object L$0;
    int label;
    final /* synthetic */ ActivityWidgetContinueFaceFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ActivityWidgetContinueFaceFragment$onCreateView$2$1$1(ActivityWidgetContinueFaceFragment activityWidgetContinueFaceFragment, Continuation<?> continuation) {
        super(2, continuation);
        this.this$0 = activityWidgetContinueFaceFragment;
    }


    public final Continuation create(Object obj, Continuation<?> continuation) {
        return new ActivityWidgetContinueFaceFragment$onCreateView$2$1$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<?> continuation) {
        try {
            return ((ActivityWidgetContinueFaceFragment$onCreateView$2$1$1) create(coroutineScope, continuation)).invokeSuspendImpl(Unit.INSTANCE);
        } catch (Throwable th) {
            throw com.magneticchen.daijishou.support.DaijishouSupport.sneakyThrow(th);
        }
    }

    public final Object invokeSuspendImpl(Object obj) throws Throwable {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            PlayableItemEntity playableItemEntity = this.this$0.playableItemEntity;
            Intrinsics.checkNotNull(playableItemEntity);
            String previewMediaPath = playableItemEntity.getPreviewMediaPath();
            PlayableItemPreviewMediaIndex mediaIndex = Utils.INSTANCE.getPlayableItemPreviewMediaIndex(playableItemEntity);
            String path = mediaIndex != null ? mediaIndex.getSnapshotPath() : null;
            if (path == null && mediaIndex != null) {
                path = mediaIndex.getBoxArtPath();
            }
            if (path == null && mediaIndex != null) {
                path = mediaIndex.getTitlePath();
            }
            if (path != null) {
                ActivityWidgetContinueFaceFragment fragment = this.this$0;
                try {
                    String fullPath = previewMediaPath + path;
                    ImageView bg = fragment.background;
                    if (bg == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("background");
                        bg = null;
                    }
                    int width = bg.getWidth();
                    Bitmap bitmap = ScaledBitmapLoader.INSTANCE.decodeSampledBitmapFromFile(fullPath, width, width);
                    fragment.cachedBitmap = bitmap;
                    this.L$0 = fragment;
                    this.label = 1;
                    if (BuildersKt.withContext(Dispatchers.getMain(), new ActivityWidgetContinueFaceFragment$onCreateView$2$1$1$1$1(fragment, null), this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } catch (Exception e) {
                    fragment.cachedBitmap = null;
                    this.L$0 = null;
                    this.label = 2;
                    if (BuildersKt.withContext(Dispatchers.getMain(), new ActivityWidgetContinueFaceFragment$onCreateView$2$1$1$1$2(fragment, e, null), this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
            } else {
                this.this$0.cachedBitmap = null;
                this.label = 3;
                if (BuildersKt.withContext(Dispatchers.getMain(), new AnonymousClass2(this.this$0, null), this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
        } else if (i == 1) {
            ActivityWidgetContinueFaceFragment fragment = (ActivityWidgetContinueFaceFragment) this.L$0;
            try {
                ResultKt.throwOnFailure(obj);
            } catch (Exception e) {
                fragment.cachedBitmap = null;
                this.L$0 = null;
                this.label = 2;
                if (BuildersKt.withContext(Dispatchers.getMain(), new ActivityWidgetContinueFaceFragment$onCreateView$2$1$1$1$2(fragment, e, null), this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
        } else if (i == 2 || i == 3) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: com.magneticchen.daijishou.daijishou_widget.widgets.activity.ActivityWidgetContinueFaceFragment$onCreateView$2$1$1$2, reason: invalid class name */
    /* JADX INFO: compiled from: ActivityWidgetContinueFaceFragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.magneticchen.daijishou.daijishou_widget.widgets.activity.ActivityWidgetContinueFaceFragment$onCreateView$2$1$1$2", f = "ActivityWidgetContinueFaceFragment.kt", i = {}, l = {}, m = "invokeSuspendImpl", n = {}, s = {})
    static final class AnonymousClass2 extends com.magneticchen.daijishou.support.DaijishouSuspendLambda implements Function2<CoroutineScope, Continuation<?>, Object> {
        int label;
        final /* synthetic */ ActivityWidgetContinueFaceFragment this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(ActivityWidgetContinueFaceFragment activityWidgetContinueFaceFragment, Continuation<?> continuation) {
            super(2, continuation);
            this.this$0 = activityWidgetContinueFaceFragment;
        }


        public final Continuation create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass2(this.this$0, continuation);
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
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                ImageView imageView = this.this$0.background;
                if (imageView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("background");
                    imageView = null;
                }
                imageView.setImageBitmap(null);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}
