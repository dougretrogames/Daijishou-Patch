package com.magneticchen.daijishou.cache;

import android.graphics.Bitmap;
import android.util.Patterns;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwnerKt;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.ExecutorCoroutineDispatcher;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;
import net.jodah.expiringmap.ExpirationPolicy;
import net.jodah.expiringmap.ExpiringMap;

/* JADX INFO: compiled from: CachedBitmapLoader.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000  2\u00020\u0001:\u0002\u001f B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tJ\u0006\u0010\u0017\u001a\u00020\u0018J\u000e\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\fJ\u0012\u0010\u001b\u001a\u00060\u001cR\u00020\u00002\u0006\u0010\u001d\u001a\u00020\u001eR\u001d\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R*\u0010\u0012\u001a\u001e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00150\u0013j\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u0015`\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lcom/magneticchen/daijishou/cache/CachedBitmapLoader;", "", "cacheSize", "", "maxShortEdgeLength", "expirationInMinutes", "", "dispatcher", "Lkotlinx/coroutines/ExecutorCoroutineDispatcher;", "(IIJLkotlinx/coroutines/ExecutorCoroutineDispatcher;)V", "cache", "Lnet/jodah/expiringmap/ExpiringMap;", "", "Landroid/graphics/Bitmap;", "getCache", "()Lnet/jodah/expiringmap/ExpiringMap;", "getDispatcher", "()Lkotlinx/coroutines/ExecutorCoroutineDispatcher;", "jobs", "Ljava/util/HashMap;", "Landroid/view/View;", "Lkotlinx/coroutines/Job;", "Lkotlin/collections/HashMap;", "clear", "", "remove", "pathOrURL", "with", "Lcom/magneticchen/daijishou/cache/CachedBitmapLoader$CachedBitmapLoaderTask;", "fragment", "Landroidx/fragment/app/Fragment;", "CachedBitmapLoaderTask", "Companion", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class CachedBitmapLoader {
    private final ExpiringMap<String, Bitmap> cache;
    private final ExecutorCoroutineDispatcher dispatcher;
    public final HashMap<View, Job> jobs;
    final int maxShortEdgeLength;

    public CachedBitmapLoader(int i, int i2, long j, ExecutorCoroutineDispatcher executorCoroutineDispatcher) {
        this.maxShortEdgeLength = i2;
        if (executorCoroutineDispatcher == null) {
            CoroutineDispatcher io2 = Dispatchers.getIO();
            Intrinsics.checkNotNull(io2, "null cannot be cast to non-null type kotlinx.coroutines.ExecutorCoroutineDispatcher");
            executorCoroutineDispatcher = (ExecutorCoroutineDispatcher) io2;
        }
        this.dispatcher = executorCoroutineDispatcher;
        ExpiringMap expiringMapBuild = ExpiringMap.builder().maxSize(i).expiration(j, TimeUnit.MINUTES).expirationPolicy(ExpirationPolicy.ACCESSED).build();
        Intrinsics.checkNotNullExpressionValue(expiringMapBuild, "build(...)");
        this.cache = expiringMapBuild;
        this.jobs = new HashMap<>();
    }

    public /* synthetic */ CachedBitmapLoader(int i, int i2, long j, ExecutorCoroutineDispatcher executorCoroutineDispatcher, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, i2, j, (i3 & 8) != 0 ? null : executorCoroutineDispatcher);
    }

    public final ExecutorCoroutineDispatcher getDispatcher() {
        return this.dispatcher;
    }

    public final ExpiringMap<String, Bitmap> getCache() {
        return this.cache;
    }

    /* JADX INFO: compiled from: CachedBitmapLoader.kt */
    @Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J0\u0010\u001f\u001a\u00020\u00122\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#2\u0006\u0010\u0016\u001a\u00020\u00152\b\b\u0002\u0010\u0018\u001a\u00020\u0017H\u0082@¢\u0006\u0002\u0010$J \u0010%\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u00152\b\b\u0002\u0010\u0018\u001a\u00020\u0017H\u0082@¢\u0006\u0002\u0010&J\u000e\u0010'\u001a\u00020\u00122\u0006\u0010\"\u001a\u00020#J\u0006\u0010(\u001a\u00020\u0012J\u0014\u0010)\u001a\u00020\u00122\n\u0010\u0011\u001a\u00060\rj\u0002`\u000eH\u0002J*\u0010*\u001a\u00020\u00122\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#2\n\u0010\u0011\u001a\u00060\rj\u0002`\u000eH\u0082@¢\u0006\u0002\u0010+J\u001a\u0010,\u001a\u00020\u00122\n\u0010\u0011\u001a\u00060\rj\u0002`\u000eH\u0082@¢\u0006\u0002\u0010-J\u001a\u0010.\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u00152\b\b\u0002\u0010\u0018\u001a\u00020\u0017H\u0002J\u0012\u0010/\u001a\u00060\u0000R\u0002002\u0006\u00101\u001a\u00020\u001aJ1\u00102\u001a\u00060\u0000R\u0002002%\u0010\u000b\u001a!\u0012\u0017\u0012\u00150\rj\u0002`\u000e¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u00120\fJB\u00103\u001a\u00060\u0000R\u00020026\u0010\u0013\u001a2\u0012\u0013\u0012\u00110\u0015¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0016\u0012\u0013\u0012\u00110\u0017¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0018\u0012\u0004\u0012\u00020\u00120\u0014R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR/\u0010\u000b\u001a#\u0012\u0017\u0012\u00150\rj\u0002`\u000e¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u0012\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R@\u0010\u0013\u001a4\u0012\u0013\u0012\u00110\u0015¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0016\u0012\u0013\u0012\u00110\u0017¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0018\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0019\u001a\u00020\u001aX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001e¨\u00064"}, d2 = {"Lcom/magneticchen/daijishou/cache/CachedBitmapLoader$CachedBitmapLoaderTask;", "", "fragment", "Landroidx/fragment/app/Fragment;", "(Lcom/magneticchen/daijishou/cache/CachedBitmapLoader;Landroidx/fragment/app/Fragment;)V", "mode", "", "getMode", "()I", "setMode", "(I)V", "onFailedListener", "Lkotlin/Function1;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "Lkotlin/ParameterName;", "name", "e", "", "onSucceedListener", "Lkotlin/Function2;", "Landroid/graphics/Bitmap;", "bitmap", "", "isCached", "path", "", "getPath", "()Ljava/lang/String;", "setPath", "(Ljava/lang/String;)V", "finishAndInvokeCorrectListenerWithJob", "job", "Lkotlinx/coroutines/Job;", "view", "Landroid/view/View;", "(Lkotlinx/coroutines/Job;Landroid/view/View;Landroid/graphics/Bitmap;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "finishAndInvokeCorrectListenerWithoutJob", "(Landroid/graphics/Bitmap;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "into", "intoNothing", "invokeOnFailedListener", "invokeOnFailedListenerWithJob", "(Lkotlinx/coroutines/Job;Landroid/view/View;Ljava/lang/Exception;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "invokeOnFailedListenerWithoutJob", "(Ljava/lang/Exception;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "invokeOnSucceedListener", "load", "Lcom/magneticchen/daijishou/cache/CachedBitmapLoader;", "pathOrURL", "setOnFailedListener", "setOnSucceedListener", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public final class CachedBitmapLoaderTask {
        private final Fragment fragment;
        private int mode;
        private Function1<? super Exception, Unit> onFailedListener;
        private Function2<? super Bitmap, ? super Boolean, Unit> onSucceedListener;
        private String path;
        final /* synthetic */ CachedBitmapLoader this$0;

        public CachedBitmapLoaderTask(CachedBitmapLoader cachedBitmapLoader, Fragment fragment) {
            Intrinsics.checkNotNullParameter(fragment, "fragment");
            this.this$0 = cachedBitmapLoader;
            this.fragment = fragment;
            this.path = "";
        }

        public final String getPath() {
            return this.path;
        }

        public final void setPath(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.path = str;
        }

        public final int getMode() {
            return this.mode;
        }

        public final void setMode(int i) {
            this.mode = i;
        }

        public final CachedBitmapLoaderTask setOnFailedListener(Function1<? super Exception, Unit> onFailedListener) {
            Intrinsics.checkNotNullParameter(onFailedListener, "onFailedListener");
            this.onFailedListener = onFailedListener;
            return this;
        }

        public final CachedBitmapLoaderTask setOnSucceedListener(Function2<? super Bitmap, ? super Boolean, Unit> onSucceedListener) {
            Intrinsics.checkNotNullParameter(onSucceedListener, "onSucceedListener");
            this.onSucceedListener = onSucceedListener;
            return this;
        }

        public final CachedBitmapLoaderTask load(String pathOrURL) {
            Intrinsics.checkNotNullParameter(pathOrURL, "pathOrURL");
            if (Patterns.WEB_URL.matcher(pathOrURL).matches()) {
                this.mode = 1;
                return this;
            }
            this.mode = 0;
            this.path = pathOrURL;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: private */
        final Object invokeOnFailedListenerWithoutJob(Exception exc, Continuation<?> continuation) {
            Object objWithContext = BuildersKt.withContext(LifecycleOwnerKt.getLifecycleScope(this.fragment).getCoroutineContext().plus(Dispatchers.getMain()), new CachedBitmapLoader$CachedBitmapLoaderTask$invokeOnFailedListenerWithoutJob$2(this, exc, null), continuation);
            return objWithContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objWithContext : Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        final Object invokeOnFailedListenerWithJob(Job job, View view, Exception exc, Continuation<?> continuation) {
            if (Intrinsics.areEqual(this.this$0.jobs.get(view), job)) {
                this.this$0.jobs.remove(view);
            }
            Object objWithContext = BuildersKt.withContext(LifecycleOwnerKt.getLifecycleScope(this.fragment).getCoroutineContext().plus(Dispatchers.getMain()), new CachedBitmapLoader$CachedBitmapLoaderTask$invokeOnFailedListenerWithJob$2(this, exc, null), continuation);
            return objWithContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objWithContext : Unit.INSTANCE;
        }

        /* synthetic */ Object finishAndInvokeCorrectListenerWithoutJob$default(CachedBitmapLoaderTask cachedBitmapLoaderTask, Bitmap bitmap, boolean z, Continuation continuation, int i, Object obj) {
            if ((i & 2) != 0) {
                z = false;
            }
            return cachedBitmapLoaderTask.finishAndInvokeCorrectListenerWithoutJob(bitmap, z, continuation);
        }

        /* JADX INFO: Access modifiers changed from: private */
        final Object finishAndInvokeCorrectListenerWithoutJob(Bitmap bitmap, boolean z, Continuation<?> continuation) {
            Object objWithContext = BuildersKt.withContext(LifecycleOwnerKt.getLifecycleScope(this.fragment).getCoroutineContext().plus(Dispatchers.getMain()), new CachedBitmapLoader$CachedBitmapLoaderTask$finishAndInvokeCorrectListenerWithoutJob$2(this, bitmap, z, null), continuation);
            return objWithContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objWithContext : Unit.INSTANCE;
        }

        /* synthetic */ Object finishAndInvokeCorrectListenerWithJob$default(CachedBitmapLoaderTask cachedBitmapLoaderTask, Job job, View view, Bitmap bitmap, boolean z, Continuation continuation, int i, Object obj) {
            if ((i & 8) != 0) {
                z = false;
            }
            return cachedBitmapLoaderTask.finishAndInvokeCorrectListenerWithJob(job, view, bitmap, z, continuation);
        }

        /* JADX INFO: Access modifiers changed from: private */
        final Object finishAndInvokeCorrectListenerWithJob(Job job, View view, Bitmap bitmap, boolean z, Continuation<?> continuation) {
            if (Intrinsics.areEqual(this.this$0.jobs.get(view), job)) {
                this.this$0.jobs.remove(view);
                Object objWithContext = BuildersKt.withContext(LifecycleOwnerKt.getLifecycleScope(this.fragment).getCoroutineContext().plus(Dispatchers.getMain()), new CachedBitmapLoader$CachedBitmapLoaderTask$finishAndInvokeCorrectListenerWithJob$2(this, bitmap, z, null), continuation);
                return objWithContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objWithContext : Unit.INSTANCE;
            }
            Object objWithContext2 = BuildersKt.withContext(LifecycleOwnerKt.getLifecycleScope(this.fragment).getCoroutineContext().plus(Dispatchers.getMain()), new CachedBitmapLoader$CachedBitmapLoaderTask$finishAndInvokeCorrectListenerWithJob$3(this, null), continuation);
            return objWithContext2 == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objWithContext2 : Unit.INSTANCE;
        }

        /* synthetic */ void invokeOnSucceedListener$default(CachedBitmapLoaderTask cachedBitmapLoaderTask, Bitmap bitmap, boolean z, int i, Object obj) {
            if ((i & 2) != 0) {
                z = false;
            }
            cachedBitmapLoaderTask.invokeOnSucceedListener(bitmap, z);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void invokeOnSucceedListener(Bitmap bitmap, boolean isCached) {
            Function2<? super Bitmap, ? super Boolean, Unit> function2 = this.onSucceedListener;
            if (function2 != null) {
                function2.invoke(bitmap, Boolean.valueOf(isCached));
            }
            this.onFailedListener = null;
            this.onSucceedListener = null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void invokeOnFailedListener(Exception e) {
            Function1<? super Exception, Unit> function1 = this.onFailedListener;
            if (function1 != null) {
                function1.invoke(e);
            }
            this.onFailedListener = null;
            this.onSucceedListener = null;
        }

        public final void intoNothing() {
            if (!this.this$0.getCache().containsKey(this.path)) {
                CompletableJob completableJobJob$default = JobKt.Job$default((Job) null, 1, (Object) null);
                BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this.fragment), completableJobJob$default.plus(this.this$0.getDispatcher()).plus(new CachedBitmapLoader$CachedBitmapLoaderTask$intoNothing$$inlined$CoroutineExceptionHandler$1(CoroutineExceptionHandler.Key, this)), null, new CachedBitmapLoader$CachedBitmapLoaderTask$intoNothing$1(this, this.this$0, null), 2, null);
            } else {
                Bitmap bitmap = this.this$0.getCache().get(this.path);
                if (bitmap == null) {
                    invokeOnFailedListener(new Exception("Bitmap is null."));
                } else {
                    invokeOnSucceedListener(bitmap, true);
                }
            }
        }

        public final void into(View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            if (!this.this$0.getCache().containsKey(this.path)) {
                CompletableJob completableJobJob$default = JobKt.Job$default((Job) null, 1, (Object) null);
                this.this$0.jobs.put(view, BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this.fragment), completableJobJob$default.plus(this.this$0.getDispatcher()).plus(new CachedBitmapLoader$CachedBitmapLoaderTask$into$$inlined$CoroutineExceptionHandler$1(CoroutineExceptionHandler.Key, this.this$0, view, completableJobJob$default, this)), null, new CachedBitmapLoader$CachedBitmapLoaderTask$into$1(this, this.this$0, view, null), 2, null));
                return;
            }
            this.this$0.jobs.remove(view);
            Bitmap bitmap = this.this$0.getCache().get(this.path);
            if (bitmap == null) {
                invokeOnFailedListener(new Exception("Bitmap is null. Path: " + this.path));
            } else {
                invokeOnSucceedListener(bitmap, true);
            }
        }
    }

    public final void remove(String pathOrURL) {
        Intrinsics.checkNotNullParameter(pathOrURL, "pathOrURL");
        this.cache.remove(pathOrURL);
    }

    public final void clear() {
        this.cache.clear();
    }

    public final CachedBitmapLoaderTask with(Fragment fragment) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        return new CachedBitmapLoaderTask(this, fragment);
    }

    /* JADX INFO: Companion + nested exception were dropped from the decompiled output. */
    public static final class Companion {
        public Companion() {
        }

        public Companion(kotlin.jvm.internal.DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static final class NewerBitmapLoadingException extends Exception {
            public NewerBitmapLoadingException(String message) {
                super(message);
            }
        }
    }
}
