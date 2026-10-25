package defpackage;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;

/* JADX INFO: renamed from: ReentrantMutexKt, reason: from Kotlin metadata */
/* JADX INFO: compiled from: ReentrantMutex.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\u001a\u000e\u0010\u0004\u001a\u00020\u0005H\u0086@¢\u0006\u0002\u0010\u0006\u001a\u000e\u0010\u0007\u001a\u00020\u0005H\u0086@¢\u0006\u0002\u0010\u0006\u001a\u000e\u0010\b\u001a\u00020\u0005H\u0086@¢\u0006\u0002\u0010\u0006\u001a6\u0010\t\u001a\u0002H\n\"\u0004\b\u0000\u0010\n*\u00020\u00012\u001c\u0010\u000b\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\n0\r\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\fH\u0086@¢\u0006\u0002\u0010\u000f\"\u0011\u0010\u0000\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003¨\u0006\u0010"}, d2 = {"mutex", "Lkotlinx/coroutines/sync/Mutex;", "getMutex", "()Lkotlinx/coroutines/sync/Mutex;", "doSomeWork", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "foo", "main", "withReentrantLock", ExifInterface.GPS_DIRECTION_TRUE, "block", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "", "(Lkotlinx/coroutines/sync/Mutex;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
public final class mutex {
    private static final Mutex mutex = MutexKt.Mutex$default(false, 1, null);

    /* JADX INFO: renamed from: ReentrantMutexKt$main$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ReentrantMutex.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    /* synthetic */ class C00932 extends Lambda implements Function1<Object> {
        public static final C00932 INSTANCE = new C00932();

        C00932() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<Object> continuation) {
            return mutex.main((Continuation<? super Unit>) continuation);
        }
    }

    public static final Mutex getMutex() {
        return mutex;
    }

    /* JADX INFO: renamed from: ReentrantMutexKt$foo$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ReentrantMutex.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", ""}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "ReentrantMutexKt$foo$2", f = "ReentrantMutex.kt", i = {}, l = {36}, m = "invokeSuspend", n = {}, s = {})
    static final class C00922 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        int label;

        C00922(Continuation<? super C00922> continuation) {
            super(1, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return new C00922(continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Unit> continuation) {
            return ((C00922) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (mutex.doSomeWork(this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    public static final Object foo(Continuation<? super Unit> continuation) {
        Object objWithReentrantLock = withReentrantLock(mutex, new C00922(null), continuation);
        return objWithReentrantLock == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objWithReentrantLock : Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: ReentrantMutexKt$doSomeWork$2, reason: invalid class name */
    /* JADX INFO: compiled from: ReentrantMutex.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", ""}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "ReentrantMutexKt$doSomeWork$2", f = "ReentrantMutex.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass2 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass2(Continuation<? super AnonymousClass2> continuation) {
            super(1, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return new AnonymousClass2(continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            System.out.println((Object) "Working!");
            return Unit.INSTANCE;
        }
    }

    public static final Object doSomeWork(Continuation<? super Unit> continuation) {
        Object objWithReentrantLock = withReentrantLock(mutex, new AnonymousClass2(null), continuation);
        return objWithReentrantLock == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objWithReentrantLock : Unit.INSTANCE;
    }

    public static final Object main(Continuation<? super Unit> continuation) {
        Object objFoo = foo(continuation);
        return objFoo == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objFoo : Unit.INSTANCE;
    }

    public static final <T> Object withReentrantLock(Mutex mutex2, Function1<? super Continuation<? super T>, ? extends Object> function1, Continuation<? super T> continuation) {
        ReentrantMutexContextKey reentrantMutexContextKey = new ReentrantMutexContextKey(mutex2);
        return continuation.getContext().get(reentrantMutexContextKey) != null ? function1.invoke(continuation) : BuildersKt.withContext(new ReentrantMutexContextElement(reentrantMutexContextKey), new C00942(mutex2, function1, null), continuation);
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: renamed from: ReentrantMutexKt$withReentrantLock$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ReentrantMutex.kt */
    @Metadata(d1 = {"\u0000\b\n\u0002\b\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "ReentrantMutexKt$withReentrantLock$2", f = "ReentrantMutex.kt", i = {0, 1}, l = {72, 56}, m = "invokeSuspend", n = {"$this$withLock_u24default$iv", "$this$withLock_u24default$iv"}, s = {"L$0", "L$0"})
    static final class C00942<T> extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super T>, Object> {
        final /* synthetic */ Function1<Continuation<? super T>, Object> $block;
        final /* synthetic */ Mutex $this_withReentrantLock;
        Object L$0;
        Object L$1;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C00942(Mutex mutex, Function1<? super Continuation<? super T>, ? extends Object> function1, Continuation<? super C00942> continuation) {
            super(2, continuation);
            this.$this_withReentrantLock = mutex;
            this.$block = function1;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C00942(this.$this_withReentrantLock, this.$block, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super T> continuation) {
            return ((C00942) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Mutex mutex;
            Function1<Continuation<? super T>, Object> function1;
            Mutex mutex2;
            Throwable th;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    mutex = this.$this_withReentrantLock;
                    function1 = this.$block;
                    this.L$0 = mutex;
                    this.L$1 = function1;
                    this.label = 1;
                    if (mutex.lock(null, this) != coroutine_suspended) {
                    }
                    return coroutine_suspended;
                }
                if (i != 1) {
                    if (i != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    mutex2 = (Mutex) this.L$0;
                    try {
                        ResultKt.throwOnFailure(obj);
                        mutex2.unlock(null);
                        return obj;
                    } catch (Throwable th2) {
                        th = th2;
                        mutex2.unlock(null);
                        throw th;
                    }
                }
                function1 = (Function1) this.L$1;
                Mutex mutex3 = (Mutex) this.L$0;
                ResultKt.throwOnFailure(obj);
                mutex = mutex3;
                this.L$0 = mutex;
                this.L$1 = null;
                this.label = 2;
                Object objInvoke = function1.invoke(this);
                if (objInvoke != coroutine_suspended) {
                    mutex2 = mutex;
                    obj = objInvoke;
                    mutex2.unlock(null);
                    return obj;
                }
                return coroutine_suspended;
            } catch (Throwable th3) {
                mutex2 = mutex;
                th = th3;
                mutex2.unlock(null);
                throw th;
            }
        }
    }
}
