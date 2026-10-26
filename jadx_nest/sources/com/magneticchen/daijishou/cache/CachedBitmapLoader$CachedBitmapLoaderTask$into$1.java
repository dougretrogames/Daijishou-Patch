package com.magneticchen.daijishou.cache;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.View;
import com.magneticchen.daijishou.utils.ScaledBitmapLoader;
import java.io.File;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;

/* INFO: compiled from: CachedBitmapLoader.kt */
/* INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.magneticchen.daijishou.cache.CachedBitmapLoader$CachedBitmapLoaderTask$into$1", f = "CachedBitmapLoader.kt", i = {0, 1, 2}, l = {192, 198, 202, 207, 211}, m = "invokeSuspendImpl", n = {"$this$launch", "$this$launch", "$this$launch"}, s = {"L$0", "L$0", "L$0"})
final class CachedBitmapLoader$CachedBitmapLoaderTask$into$1 extends com.magneticchen.daijishou.support.DaijishouSuspendLambda implements Function2<CoroutineScope, Continuation<?>, Object> {
    final /* synthetic */ View $view;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ CachedBitmapLoader.CachedBitmapLoaderTask this$0;
    final /* synthetic */ CachedBitmapLoader this$1;

    /* WARN: 'super' call moved to the top of the method (can break code semantics) */
    CachedBitmapLoader$CachedBitmapLoaderTask$into$1(CachedBitmapLoader.CachedBitmapLoaderTask cachedBitmapLoaderTask, CachedBitmapLoader cachedBitmapLoader, View view, Continuation<?> continuation) {
        super(2, continuation);
        this.this$0 = cachedBitmapLoaderTask;
        this.this$1 = cachedBitmapLoader;
        this.$view = view;
    }

    public final Continuation create(Object obj, Continuation<?> continuation) {
        CachedBitmapLoader$CachedBitmapLoaderTask$into$1 cachedBitmapLoader$CachedBitmapLoaderTask$into$1 = new CachedBitmapLoader$CachedBitmapLoaderTask$into$1(this.this$0, this.this$1, this.$view, continuation);
        cachedBitmapLoader$CachedBitmapLoaderTask$into$1.L$0 = obj;
        return cachedBitmapLoader$CachedBitmapLoaderTask$into$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<?> continuation) {
        try {
            return ((CachedBitmapLoader$CachedBitmapLoaderTask$into$1) create(coroutineScope, continuation)).invokeSuspendImpl(Unit.INSTANCE);
        } catch (Throwable th) {
            throw com.magneticchen.daijishou.support.DaijishouSupport.sneakyThrow(th);
        }
    }

    public final Object invokeSuspendImpl(Object obj) throws Throwable {
        CoroutineScope coroutineScope;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            coroutineScope = (CoroutineScope) this.L$0;
            if (this.this$0.getMode() == 0) {
                try {
                    File file = new File(this.this$0.getPath());
                    if (file.exists()) {
                        Bitmap bitmap;
                        if (this.this$1.maxShortEdgeLength > 0) {
                            bitmap = ScaledBitmapLoader.INSTANCE.decodeSampledBitmapFromFile(this.this$0.getPath(), this.this$1.maxShortEdgeLength, this.this$1.maxShortEdgeLength);
                        } else {
                            bitmap = BitmapFactory.decodeFile(this.this$0.getPath());
                        }
                        if (bitmap == null) {
                            Intrinsics.checkNotNull(coroutineScope, "null cannot be cast to non-null type kotlinx.coroutines.Job");
                            Job job = (Job) coroutineScope;
                            View view = this.$view;
                            Exception exc = new Exception("Bitmap is null. Path: " + this.this$0.getPath());
                            this.L$0 = coroutineScope;
                            this.label = 1;
                            if (this.this$0.invokeOnFailedListenerWithJob(job, view, exc, this) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        } else {
                            this.this$1.getCache().put(this.this$0.getPath(), bitmap);
                            Intrinsics.checkNotNull(coroutineScope, "null cannot be cast to non-null type kotlinx.coroutines.Job");
                            Job job2 = (Job) coroutineScope;
                            View view2 = this.$view;
                            this.L$0 = coroutineScope;
                            this.label = 2;
                            if (this.this$0.finishAndInvokeCorrectListenerWithJob(job2, view2, bitmap, false, this) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        }
                    } else {
                        this.this$1.getCache().put(this.this$0.getPath(), null);
                        Intrinsics.checkNotNull(coroutineScope, "null cannot be cast to non-null type kotlinx.coroutines.Job");
                        Job job3 = (Job) coroutineScope;
                        View view3 = this.$view;
                        Exception exc2 = new Exception("File not exists. Path: " + this.this$0.getPath());
                        this.L$0 = coroutineScope;
                        this.label = 3;
                        if (this.this$0.invokeOnFailedListenerWithJob(job3, view3, exc2, this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    }
                } catch (Exception e) {
                    Intrinsics.checkNotNull(coroutineScope, "null cannot be cast to non-null type kotlinx.coroutines.Job");
                    Job job4 = (Job) coroutineScope;
                    View view4 = this.$view;
                    this.L$0 = null;
                    this.label = 4;
                    if (this.this$0.invokeOnFailedListenerWithJob(job4, view4, e, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
            } else {
                Intrinsics.checkNotNull(coroutineScope, "null cannot be cast to non-null type kotlinx.coroutines.Job");
                Job job5 = (Job) coroutineScope;
                View view5 = this.$view;
                Exception exc3 = new Exception("Unsupported mode (" + this.this$0.getMode() + ").");
                this.label = 5;
                if (this.this$0.invokeOnFailedListenerWithJob(job5, view5, exc3, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
        } else if (i == 1 || i == 2 || i == 3) {
            coroutineScope = (CoroutineScope) this.L$0;
            try {
                ResultKt.throwOnFailure(obj);
            } catch (Exception e2) {
                Intrinsics.checkNotNull(coroutineScope, "null cannot be cast to non-null type kotlinx.coroutines.Job");
                Job job6 = (Job) coroutineScope;
                View view6 = this.$view;
                this.L$0 = null;
                this.label = 4;
                if (this.this$0.invokeOnFailedListenerWithJob(job6, view6, e2, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
        } else if (i == 4 || i == 5) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }
}
