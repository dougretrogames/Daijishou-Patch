package com.magneticchen.daijishou.cache;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.magneticchen.daijishou.utils.ScaledBitmapLoader;
import java.io.File;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* INFO: compiled from: CachedBitmapLoader.kt */
/* INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.magneticchen.daijishou.cache.CachedBitmapLoader$CachedBitmapLoaderTask$intoNothing$1", f = "CachedBitmapLoader.kt", i = {}, l = {149, 154, 158, 161}, m = "invokeSuspendImpl", n = {}, s = {})
final class CachedBitmapLoader$CachedBitmapLoaderTask$intoNothing$1 extends com.magneticchen.daijishou.support.DaijishouSuspendLambda implements Function2<CoroutineScope, Continuation<?>, Object> {
    int label;
    final /* synthetic */ CachedBitmapLoader.CachedBitmapLoaderTask this$0;
    final /* synthetic */ CachedBitmapLoader this$1;

    /* WARN: 'super' call moved to the top of the method (can break code semantics) */
    CachedBitmapLoader$CachedBitmapLoaderTask$intoNothing$1(CachedBitmapLoader.CachedBitmapLoaderTask cachedBitmapLoaderTask, CachedBitmapLoader cachedBitmapLoader, Continuation<?> continuation) {
        super(2, continuation);
        this.this$0 = cachedBitmapLoaderTask;
        this.this$1 = cachedBitmapLoader;
    }

    public final Continuation create(Object obj, Continuation<?> continuation) {
        return new CachedBitmapLoader$CachedBitmapLoaderTask$intoNothing$1(this.this$0, this.this$1, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<?> continuation) {
        try {
            return ((CachedBitmapLoader$CachedBitmapLoaderTask$intoNothing$1) create(coroutineScope, continuation)).invokeSuspendImpl(Unit.INSTANCE);
        } catch (Throwable th) {
            throw com.magneticchen.daijishou.support.DaijishouSupport.sneakyThrow(th);
        }
    }

    public final Object invokeSuspendImpl(Object obj) throws Throwable {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
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
                            this.label = 1;
                            if (this.this$0.invokeOnFailedListenerWithoutJob(new Exception("Bitmap is null."), this) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        } else {
                            this.this$1.getCache().put(this.this$0.getPath(), bitmap);
                            this.label = 2;
                            if (this.this$0.finishAndInvokeCorrectListenerWithoutJob(bitmap, false, this) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        }
                    } else {
                        this.this$1.getCache().put(this.this$0.getPath(), null);
                        this.label = 3;
                        if (this.this$0.invokeOnFailedListenerWithoutJob(new Exception("File not exists."), this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    }
                } catch (Exception e) {
                    this.label = 4;
                    if (this.this$0.invokeOnFailedListenerWithoutJob(e, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
            }
        } else if (i == 1 || i == 2 || i == 3) {
            try {
                ResultKt.throwOnFailure(obj);
            } catch (Exception e2) {
                this.label = 4;
                if (this.this$0.invokeOnFailedListenerWithoutJob(e2, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
        } else if (i == 4) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }
}
