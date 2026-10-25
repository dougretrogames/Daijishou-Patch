package com.google.common.util.concurrent;

import androidx.compose.runtime.CompositionImpl$$ExternalSyntheticBackportWithForwarding0;
import com.google.common.base.Functions;
import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.google.common.collect.FluentIterable;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.google.errorprone.annotations.DoNotMock;
import java.io.Closeable;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicReference;
import java.util.logging.Level;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes4.dex */
@DoNotMock("Use ClosingFuture.from(Futures.immediate*Future)")
@ElementTypesAreNonnullByDefault
public final class ClosingFuture<V> {
    private static final LazyLogger logger = new LazyLogger(ClosingFuture.class);
    private final CloseableList closeables;
    private final FluentFuture<V> future;
    private final AtomicReference<State> state;

    public interface AsyncClosingCallable<V> {
        ClosingFuture<V> call(DeferredCloser closer) throws Exception;
    }

    public interface AsyncClosingFunction<T, U> {
        ClosingFuture<U> apply(DeferredCloser closer, @ParametricNullness T input) throws Exception;
    }

    public interface ClosingCallable<V> {
        @ParametricNullness
        V call(DeferredCloser closer) throws Exception;
    }

    public interface ClosingFunction<T, U> {
        @ParametricNullness
        U apply(DeferredCloser closer, @ParametricNullness T input) throws Exception;
    }

    enum State {
        OPEN,
        SUBSUMED,
        WILL_CLOSE,
        CLOSING,
        CLOSED,
        WILL_CREATE_VALUE_AND_CLOSER
    }

    public interface ValueAndCloserConsumer<V> {
        void accept(ValueAndCloser<V> valueAndCloser);
    }

    /* synthetic */ ClosingFuture(ListenableFuture listenableFuture, AnonymousClass1 anonymousClass1) {
        this(listenableFuture);
    }

    public static final class DeferredCloser {
        private final CloseableList list;

        DeferredCloser(CloseableList list) {
            this.list = list;
        }

        @ParametricNullness
        public <C extends Closeable> C eventuallyClose(@ParametricNullness C closeable, Executor closingExecutor) {
            Preconditions.checkNotNull(closingExecutor);
            if (closeable != null) {
                this.list.add(closeable, closingExecutor);
            }
            return closeable;
        }
    }

    public static final class ValueAndCloser<V> {
        private final ClosingFuture<? extends V> closingFuture;

        ValueAndCloser(ClosingFuture<? extends V> closingFuture) {
            this.closingFuture = (ClosingFuture) Preconditions.checkNotNull(closingFuture);
        }

        @ParametricNullness
        public V get() throws ExecutionException {
            return (V) Futures.getDone(((ClosingFuture) this.closingFuture).future);
        }

        public void closeAsync() {
            this.closingFuture.close();
        }
    }

    public static <V> ClosingFuture<V> submit(ClosingCallable<V> callable, Executor executor) {
        return new ClosingFuture<>(callable, executor);
    }

    public static <V> ClosingFuture<V> submitAsync(AsyncClosingCallable<V> callable, Executor executor) {
        return new ClosingFuture<>(callable, executor);
    }

    public static <V> ClosingFuture<V> from(ListenableFuture<V> future) {
        return new ClosingFuture<>(future);
    }

    @Deprecated
    public static <C extends Closeable> ClosingFuture<C> eventuallyClosing(ListenableFuture<C> future, final Executor closingExecutor) {
        Preconditions.checkNotNull(closingExecutor);
        ClosingFuture<C> closingFuture = new ClosingFuture<>(Futures.nonCancellationPropagating(future));
        Futures.addCallback(future, new AnonymousClass1(closingExecutor), MoreExecutors.directExecutor());
        return closingFuture;
    }

    /* JADX INFO: renamed from: com.google.common.util.concurrent.ClosingFuture$1, reason: invalid class name */
    class AnonymousClass1 implements FutureCallback<Closeable> {
        final /* synthetic */ Executor val$closingExecutor;

        @Override // com.google.common.util.concurrent.FutureCallback
        public void onFailure(Throwable t) {
        }

        AnonymousClass1(final Executor val$closingExecutor) {
            this.val$closingExecutor = val$closingExecutor;
        }

        @Override // com.google.common.util.concurrent.FutureCallback
        public void onSuccess(@CheckForNull Closeable result) {
            ClosingFuture.this.closeables.closer.eventuallyClose(result, this.val$closingExecutor);
        }
    }

    public static Combiner whenAllComplete(Iterable<? extends ClosingFuture<?>> futures) {
        return new Combiner(false, futures, null);
    }

    public static Combiner whenAllComplete(ClosingFuture<?> future1, ClosingFuture<?>... moreFutures) {
        return whenAllComplete(Lists.asList(future1, moreFutures));
    }

    public static Combiner whenAllSucceed(Iterable<? extends ClosingFuture<?>> futures) {
        return new Combiner(true, futures, null);
    }

    public static <V1, V2> Combiner2<V1, V2> whenAllSucceed(ClosingFuture<V1> future1, ClosingFuture<V2> future2) {
        return new Combiner2<>(future1, future2, null);
    }

    public static <V1, V2, V3> Combiner3<V1, V2, V3> whenAllSucceed(ClosingFuture<V1> future1, ClosingFuture<V2> future2, ClosingFuture<V3> future3) {
        return new Combiner3<>(future1, future2, future3, null);
    }

    public static <V1, V2, V3, V4> Combiner4<V1, V2, V3, V4> whenAllSucceed(ClosingFuture<V1> future1, ClosingFuture<V2> future2, ClosingFuture<V3> future3, ClosingFuture<V4> future4) {
        return new Combiner4<>(future1, future2, future3, future4, null);
    }

    public static <V1, V2, V3, V4, V5> Combiner5<V1, V2, V3, V4, V5> whenAllSucceed(ClosingFuture<V1> future1, ClosingFuture<V2> future2, ClosingFuture<V3> future3, ClosingFuture<V4> future4, ClosingFuture<V5> future5) {
        return new Combiner5<>(future1, future2, future3, future4, future5, null);
    }

    public static Combiner whenAllSucceed(ClosingFuture<?> future1, ClosingFuture<?> future2, ClosingFuture<?> future3, ClosingFuture<?> future4, ClosingFuture<?> future5, ClosingFuture<?> future6, ClosingFuture<?>... moreFutures) {
        return whenAllSucceed(FluentIterable.of(future1, future2, future3, future4, future5, future6).append(moreFutures));
    }

    private ClosingFuture(ListenableFuture<V> future) {
        this.state = new AtomicReference<>(State.OPEN);
        this.closeables = new CloseableList(null);
        this.future = FluentFuture.from(future);
    }

    private ClosingFuture(final ClosingCallable<V> callable, Executor executor) {
        this.state = new AtomicReference<>(State.OPEN);
        this.closeables = new CloseableList(null);
        Preconditions.checkNotNull(callable);
        TrustedListenableFutureTask trustedListenableFutureTaskCreate = TrustedListenableFutureTask.create(new AnonymousClass2(callable));
        executor.execute(trustedListenableFutureTaskCreate);
        this.future = trustedListenableFutureTaskCreate;
    }

    /* JADX INFO: renamed from: com.google.common.util.concurrent.ClosingFuture$2, reason: invalid class name */
    class AnonymousClass2 implements Callable<V> {
        final /* synthetic */ ClosingCallable val$callable;

        AnonymousClass2(final ClosingCallable val$callable) {
            this.val$callable = val$callable;
        }

        @Override // java.util.concurrent.Callable
        @ParametricNullness
        public V call() throws Exception {
            return (V) this.val$callable.call(ClosingFuture.this.closeables.closer);
        }

        public String toString() {
            return this.val$callable.toString();
        }
    }

    private ClosingFuture(final AsyncClosingCallable<V> callable, Executor executor) {
        this.state = new AtomicReference<>(State.OPEN);
        this.closeables = new CloseableList(null);
        Preconditions.checkNotNull(callable);
        TrustedListenableFutureTask trustedListenableFutureTaskCreate = TrustedListenableFutureTask.create(new AnonymousClass3(callable));
        executor.execute(trustedListenableFutureTaskCreate);
        this.future = trustedListenableFutureTaskCreate;
    }

    /* JADX INFO: renamed from: com.google.common.util.concurrent.ClosingFuture$3, reason: invalid class name */
    class AnonymousClass3 implements AsyncCallable<V> {
        final /* synthetic */ AsyncClosingCallable val$callable;

        AnonymousClass3(final AsyncClosingCallable val$callable) {
            this.val$callable = val$callable;
        }

        @Override // com.google.common.util.concurrent.AsyncCallable
        public ListenableFuture<V> call() throws Exception {
            CloseableList closeableList = new CloseableList(null);
            try {
                ClosingFuture<V> closingFutureCall = this.val$callable.call(closeableList.closer);
                closingFutureCall.becomeSubsumedInto(ClosingFuture.this.closeables);
                return ((ClosingFuture) closingFutureCall).future;
            } finally {
                ClosingFuture.this.closeables.add(closeableList, MoreExecutors.directExecutor());
            }
        }

        public String toString() {
            return this.val$callable.toString();
        }
    }

    public ListenableFuture<?> statusFuture() {
        return Futures.nonCancellationPropagating(this.future.transform(Functions.constant(null), MoreExecutors.directExecutor()));
    }

    public <U> ClosingFuture<U> transform(final ClosingFunction<? super V, U> function, Executor executor) {
        Preconditions.checkNotNull(function);
        return derive(this.future.transformAsync(new AnonymousClass4(function), executor));
    }

    /* JADX INFO: Add missing generic type declarations: [U] */
    /* JADX INFO: renamed from: com.google.common.util.concurrent.ClosingFuture$4, reason: invalid class name */
    class AnonymousClass4<U> implements AsyncFunction<V, U> {
        final /* synthetic */ ClosingFunction val$function;

        AnonymousClass4(final ClosingFunction val$function) {
            this.val$function = val$function;
        }

        @Override // com.google.common.util.concurrent.AsyncFunction
        public ListenableFuture<U> apply(V input) throws Exception {
            return ClosingFuture.this.closeables.applyClosingFunction(this.val$function, input);
        }

        public String toString() {
            return this.val$function.toString();
        }
    }

    public <U> ClosingFuture<U> transformAsync(final AsyncClosingFunction<? super V, U> function, Executor executor) {
        Preconditions.checkNotNull(function);
        return derive(this.future.transformAsync(new AnonymousClass5(function), executor));
    }

    /* JADX INFO: Add missing generic type declarations: [U] */
    /* JADX INFO: renamed from: com.google.common.util.concurrent.ClosingFuture$5, reason: invalid class name */
    class AnonymousClass5<U> implements AsyncFunction<V, U> {
        final /* synthetic */ AsyncClosingFunction val$function;

        AnonymousClass5(final AsyncClosingFunction val$function) {
            this.val$function = val$function;
        }

        @Override // com.google.common.util.concurrent.AsyncFunction
        public ListenableFuture<U> apply(V input) throws Exception {
            return ClosingFuture.this.closeables.applyAsyncClosingFunction(this.val$function, input);
        }

        public String toString() {
            return this.val$function.toString();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [U] */
    /* JADX INFO: renamed from: com.google.common.util.concurrent.ClosingFuture$6, reason: invalid class name */
    class AnonymousClass6<U> implements AsyncClosingFunction<V, U> {
        final /* synthetic */ AsyncFunction val$function;

        AnonymousClass6(final AsyncFunction val$function) {
            this.val$function = val$function;
        }

        @Override // com.google.common.util.concurrent.ClosingFuture.AsyncClosingFunction
        public ClosingFuture<U> apply(DeferredCloser closer, V input) throws Exception {
            return ClosingFuture.from(this.val$function.apply(input));
        }
    }

    public static <V, U> AsyncClosingFunction<V, U> withoutCloser(final AsyncFunction<V, U> function) {
        Preconditions.checkNotNull(function);
        return new AnonymousClass6(function);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <X extends Throwable> ClosingFuture<V> catching(Class<X> exceptionType, ClosingFunction<? super X, ? extends V> fallback, Executor executor) {
        return catchingMoreGeneric(exceptionType, fallback, executor);
    }

    private <X extends Throwable, W extends V> ClosingFuture<V> catchingMoreGeneric(Class<X> cls, ClosingFunction<? super X, W> closingFunction, Executor executor) {
        Preconditions.checkNotNull(closingFunction);
        return (ClosingFuture<V>) derive(this.future.catchingAsync(cls, new AnonymousClass7(closingFunction), executor));
    }

    /* JADX INFO: Add missing generic type declarations: [W, X] */
    /* JADX INFO: renamed from: com.google.common.util.concurrent.ClosingFuture$7, reason: invalid class name */
    class AnonymousClass7<W, X> implements AsyncFunction<X, W> {
        final /* synthetic */ ClosingFunction val$fallback;

        AnonymousClass7(final ClosingFunction val$fallback) {
            this.val$fallback = val$fallback;
        }

        /* JADX WARN: Incorrect types in method signature: (TX;)Lcom/google/common/util/concurrent/ListenableFuture<TW;>; */
        @Override // com.google.common.util.concurrent.AsyncFunction
        public ListenableFuture apply(Throwable exception) throws Exception {
            return ClosingFuture.this.closeables.applyClosingFunction(this.val$fallback, exception);
        }

        public String toString() {
            return this.val$fallback.toString();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <X extends Throwable> ClosingFuture<V> catchingAsync(Class<X> exceptionType, AsyncClosingFunction<? super X, ? extends V> fallback, Executor executor) {
        return catchingAsyncMoreGeneric(exceptionType, fallback, executor);
    }

    private <X extends Throwable, W extends V> ClosingFuture<V> catchingAsyncMoreGeneric(Class<X> cls, AsyncClosingFunction<? super X, W> asyncClosingFunction, Executor executor) {
        Preconditions.checkNotNull(asyncClosingFunction);
        return (ClosingFuture<V>) derive(this.future.catchingAsync(cls, new AnonymousClass8(asyncClosingFunction), executor));
    }

    /* JADX INFO: Add missing generic type declarations: [W, X] */
    /* JADX INFO: renamed from: com.google.common.util.concurrent.ClosingFuture$8, reason: invalid class name */
    class AnonymousClass8<W, X> implements AsyncFunction<X, W> {
        final /* synthetic */ AsyncClosingFunction val$fallback;

        AnonymousClass8(final AsyncClosingFunction val$fallback) {
            this.val$fallback = val$fallback;
        }

        /* JADX WARN: Incorrect types in method signature: (TX;)Lcom/google/common/util/concurrent/ListenableFuture<TW;>; */
        @Override // com.google.common.util.concurrent.AsyncFunction
        public ListenableFuture apply(Throwable exception) throws Exception {
            return ClosingFuture.this.closeables.applyAsyncClosingFunction(this.val$fallback, exception);
        }

        public String toString() {
            return this.val$fallback.toString();
        }
    }

    public FluentFuture<V> finishToFuture() {
        if (compareAndUpdateState(State.OPEN, State.WILL_CLOSE)) {
            logger.get().log(Level.FINER, "will close {0}", this);
            this.future.addListener(new AnonymousClass9(), MoreExecutors.directExecutor());
        } else {
            switch (AnonymousClass11.$SwitchMap$com$google$common$util$concurrent$ClosingFuture$State[this.state.get().ordinal()]) {
                case 1:
                    throw new IllegalStateException("Cannot call finishToFuture() after deriving another step");
                case 2:
                    throw new IllegalStateException("Cannot call finishToFuture() after calling finishToValueAndCloser()");
                case 3:
                case 4:
                case 5:
                    throw new IllegalStateException("Cannot call finishToFuture() twice");
                case 6:
                    throw new AssertionError();
            }
        }
        return this.future;
    }

    /* JADX INFO: renamed from: com.google.common.util.concurrent.ClosingFuture$9, reason: invalid class name */
    class AnonymousClass9 implements Runnable {
        AnonymousClass9() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ClosingFuture.this.checkAndUpdateState(State.WILL_CLOSE, State.CLOSING);
            ClosingFuture.this.close();
            ClosingFuture.this.checkAndUpdateState(State.CLOSING, State.CLOSED);
        }
    }

    /* JADX INFO: renamed from: com.google.common.util.concurrent.ClosingFuture$11, reason: invalid class name */
    static /* synthetic */ class AnonymousClass11 {
        static final /* synthetic */ int[] $SwitchMap$com$google$common$util$concurrent$ClosingFuture$State;

        static {
            int[] iArr = new int[State.values().length];
            $SwitchMap$com$google$common$util$concurrent$ClosingFuture$State = iArr;
            try {
                iArr[State.SUBSUMED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$google$common$util$concurrent$ClosingFuture$State[State.WILL_CREATE_VALUE_AND_CLOSER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$google$common$util$concurrent$ClosingFuture$State[State.WILL_CLOSE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$google$common$util$concurrent$ClosingFuture$State[State.CLOSING.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$google$common$util$concurrent$ClosingFuture$State[State.CLOSED.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$google$common$util$concurrent$ClosingFuture$State[State.OPEN.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    public void finishToValueAndCloser(final ValueAndCloserConsumer<? super V> consumer, Executor executor) {
        Preconditions.checkNotNull(consumer);
        if (!compareAndUpdateState(State.OPEN, State.WILL_CREATE_VALUE_AND_CLOSER)) {
            int i = AnonymousClass11.$SwitchMap$com$google$common$util$concurrent$ClosingFuture$State[this.state.get().ordinal()];
            if (i == 1) {
                throw new IllegalStateException("Cannot call finishToValueAndCloser() after deriving another step");
            }
            if (i == 2) {
                throw new IllegalStateException("Cannot call finishToValueAndCloser() twice");
            }
            if (i == 3 || i == 4 || i == 5) {
                throw new IllegalStateException("Cannot call finishToValueAndCloser() after calling finishToFuture()");
            }
            throw new AssertionError(this.state);
        }
        this.future.addListener(new AnonymousClass10(consumer), executor);
    }

    /* JADX INFO: renamed from: com.google.common.util.concurrent.ClosingFuture$10, reason: invalid class name */
    class AnonymousClass10 implements Runnable {
        final /* synthetic */ ValueAndCloserConsumer val$consumer;

        AnonymousClass10(final ValueAndCloserConsumer val$consumer) {
            this.val$consumer = val$consumer;
        }

        @Override // java.lang.Runnable
        public void run() {
            ClosingFuture.provideValueAndCloser(this.val$consumer, ClosingFuture.this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <C, V extends C> void provideValueAndCloser(ValueAndCloserConsumer<C> consumer, ClosingFuture<V> closingFuture) {
        consumer.accept(new ValueAndCloser<>(closingFuture));
    }

    public boolean cancel(boolean mayInterruptIfRunning) {
        logger.get().log(Level.FINER, "cancelling {0}", this);
        boolean zCancel = this.future.cancel(mayInterruptIfRunning);
        if (zCancel) {
            close();
        }
        return zCancel;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void close() {
        logger.get().log(Level.FINER, "closing {0}", this);
        this.closeables.close();
    }

    private <U> ClosingFuture<U> derive(FluentFuture<U> future) {
        ClosingFuture<U> closingFuture = new ClosingFuture<>(future);
        becomeSubsumedInto(closingFuture.closeables);
        return closingFuture;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void becomeSubsumedInto(CloseableList otherCloseables) {
        checkAndUpdateState(State.OPEN, State.SUBSUMED);
        otherCloseables.add(this.closeables, MoreExecutors.directExecutor());
    }

    public static final class Peeker {
        private volatile boolean beingCalled;
        private final ImmutableList<ClosingFuture<?>> futures;

        /* synthetic */ Peeker(ImmutableList immutableList, AnonymousClass1 anonymousClass1) {
            this(immutableList);
        }

        private Peeker(ImmutableList<ClosingFuture<?>> futures) {
            this.futures = (ImmutableList) Preconditions.checkNotNull(futures);
        }

        @ParametricNullness
        public final <D> D getDone(ClosingFuture<D> closingFuture) throws ExecutionException {
            Preconditions.checkState(this.beingCalled);
            Preconditions.checkArgument(this.futures.contains(closingFuture));
            return (D) Futures.getDone(((ClosingFuture) closingFuture).future);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @ParametricNullness
        public <V> V call(Combiner.CombiningCallable<V> combiner, CloseableList closeables) throws Exception {
            this.beingCalled = true;
            CloseableList closeableList = new CloseableList(null);
            try {
                return combiner.call(closeableList.closer, this);
            } finally {
                closeables.add(closeableList, MoreExecutors.directExecutor());
                this.beingCalled = false;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public <V> FluentFuture<V> callAsync(Combiner.AsyncCombiningCallable<V> combiner, CloseableList closeables) throws Exception {
            this.beingCalled = true;
            CloseableList closeableList = new CloseableList(null);
            try {
                ClosingFuture<V> closingFutureCall = combiner.call(closeableList.closer, this);
                closingFutureCall.becomeSubsumedInto(closeables);
                return ((ClosingFuture) closingFutureCall).future;
            } finally {
                closeables.add(closeableList, MoreExecutors.directExecutor());
                this.beingCalled = false;
            }
        }
    }

    @DoNotMock("Use ClosingFuture.whenAllSucceed() or .whenAllComplete() instead.")
    public static class Combiner {
        private final boolean allMustSucceed;
        private final CloseableList closeables;
        protected final ImmutableList<ClosingFuture<?>> inputs;

        public interface AsyncCombiningCallable<V> {
            ClosingFuture<V> call(DeferredCloser closer, Peeker peeker) throws Exception;
        }

        public interface CombiningCallable<V> {
            @ParametricNullness
            V call(DeferredCloser closer, Peeker peeker) throws Exception;
        }

        /* synthetic */ Combiner(boolean z, Iterable iterable, AnonymousClass1 anonymousClass1) {
            this(z, iterable);
        }

        private Combiner(boolean allMustSucceed, Iterable<? extends ClosingFuture<?>> inputs) {
            this.closeables = new CloseableList(null);
            this.allMustSucceed = allMustSucceed;
            this.inputs = ImmutableList.copyOf(inputs);
            Iterator<? extends ClosingFuture<?>> it = inputs.iterator();
            while (it.hasNext()) {
                it.next().becomeSubsumedInto(this.closeables);
            }
        }

        /* JADX INFO: renamed from: com.google.common.util.concurrent.ClosingFuture$Combiner$1, reason: invalid class name */
        class AnonymousClass1 implements Callable<V> {
            final /* synthetic */ CombiningCallable val$combiningCallable;

            AnonymousClass1(final CombiningCallable val$combiningCallable) {
                this.val$combiningCallable = val$combiningCallable;
            }

            @Override // java.util.concurrent.Callable
            @ParametricNullness
            public V call() throws Exception {
                return (V) new Peeker(Combiner.this.inputs, null).call(this.val$combiningCallable, Combiner.this.closeables);
            }

            public String toString() {
                return this.val$combiningCallable.toString();
            }
        }

        public <V> ClosingFuture<V> call(final CombiningCallable<V> combiningCallable, Executor executor) {
            ClosingFuture<V> closingFuture = new ClosingFuture<>(futureCombiner().call(new AnonymousClass1(combiningCallable), executor), (AnonymousClass1) null);
            ((ClosingFuture) closingFuture).closeables.add(this.closeables, MoreExecutors.directExecutor());
            return closingFuture;
        }

        /* JADX INFO: renamed from: com.google.common.util.concurrent.ClosingFuture$Combiner$2, reason: invalid class name */
        class AnonymousClass2 implements AsyncCallable<V> {
            final /* synthetic */ AsyncCombiningCallable val$combiningCallable;

            AnonymousClass2(final AsyncCombiningCallable val$combiningCallable) {
                this.val$combiningCallable = val$combiningCallable;
            }

            @Override // com.google.common.util.concurrent.AsyncCallable
            public ListenableFuture<V> call() throws Exception {
                return new Peeker(Combiner.this.inputs, null).callAsync(this.val$combiningCallable, Combiner.this.closeables);
            }

            public String toString() {
                return this.val$combiningCallable.toString();
            }
        }

        public <V> ClosingFuture<V> callAsync(final AsyncCombiningCallable<V> combiningCallable, Executor executor) {
            ClosingFuture<V> closingFuture = new ClosingFuture<>(futureCombiner().callAsync(new AnonymousClass2(combiningCallable), executor), (AnonymousClass1) null);
            ((ClosingFuture) closingFuture).closeables.add(this.closeables, MoreExecutors.directExecutor());
            return closingFuture;
        }

        private Futures.FutureCombiner<Object> futureCombiner() {
            if (this.allMustSucceed) {
                return Futures.whenAllSucceed(inputFutures());
            }
            return Futures.whenAllComplete(inputFutures());
        }

        private ImmutableList<FluentFuture<?>> inputFutures() {
            return FluentIterable.from(this.inputs).transform(new ClosingFuture$Combiner$$ExternalSyntheticLambda0()).toList();
        }
    }

    public static final class Combiner2<V1, V2> extends Combiner {
        private final ClosingFuture<V1> future1;
        private final ClosingFuture<V2> future2;

        public interface AsyncClosingFunction2<V1, V2, U> {
            ClosingFuture<U> apply(DeferredCloser closer, @ParametricNullness V1 value1, @ParametricNullness V2 value2) throws Exception;
        }

        public interface ClosingFunction2<V1, V2, U> {
            @ParametricNullness
            U apply(DeferredCloser closer, @ParametricNullness V1 value1, @ParametricNullness V2 value2) throws Exception;
        }

        /* synthetic */ Combiner2(ClosingFuture closingFuture, ClosingFuture closingFuture2, AnonymousClass1 anonymousClass1) {
            this(closingFuture, closingFuture2);
        }

        private Combiner2(ClosingFuture<V1> future1, ClosingFuture<V2> future2) {
            super(true, ImmutableList.of((ClosingFuture<V2>) future1, future2), null);
            this.future1 = future1;
            this.future2 = future2;
        }

        /* JADX INFO: Add missing generic type declarations: [U] */
        /* JADX INFO: renamed from: com.google.common.util.concurrent.ClosingFuture$Combiner2$1, reason: invalid class name */
        class AnonymousClass1<U> implements Combiner.CombiningCallable<U> {
            final /* synthetic */ ClosingFunction2 val$function;

            AnonymousClass1(final ClosingFunction2 val$function) {
                this.val$function = val$function;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.google.common.util.concurrent.ClosingFuture.Combiner.CombiningCallable
            @ParametricNullness
            public U call(DeferredCloser deferredCloser, Peeker peeker) throws Exception {
                return (U) this.val$function.apply(deferredCloser, peeker.getDone(Combiner2.this.future1), peeker.getDone(Combiner2.this.future2));
            }

            public String toString() {
                return this.val$function.toString();
            }
        }

        public <U> ClosingFuture<U> call(ClosingFunction2<V1, V2, U> closingFunction2, Executor executor) {
            return call(new AnonymousClass1(closingFunction2), executor);
        }

        /* JADX INFO: Add missing generic type declarations: [U] */
        /* JADX INFO: renamed from: com.google.common.util.concurrent.ClosingFuture$Combiner2$2, reason: invalid class name */
        class AnonymousClass2<U> implements Combiner.AsyncCombiningCallable<U> {
            final /* synthetic */ AsyncClosingFunction2 val$function;

            AnonymousClass2(final AsyncClosingFunction2 val$function) {
                this.val$function = val$function;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.google.common.util.concurrent.ClosingFuture.Combiner.AsyncCombiningCallable
            public ClosingFuture<U> call(DeferredCloser closer, Peeker peeker) throws Exception {
                return this.val$function.apply(closer, peeker.getDone(Combiner2.this.future1), peeker.getDone(Combiner2.this.future2));
            }

            public String toString() {
                return this.val$function.toString();
            }
        }

        public <U> ClosingFuture<U> callAsync(AsyncClosingFunction2<V1, V2, U> asyncClosingFunction2, Executor executor) {
            return callAsync(new AnonymousClass2(asyncClosingFunction2), executor);
        }
    }

    public static final class Combiner3<V1, V2, V3> extends Combiner {
        private final ClosingFuture<V1> future1;
        private final ClosingFuture<V2> future2;
        private final ClosingFuture<V3> future3;

        public interface AsyncClosingFunction3<V1, V2, V3, U> {
            ClosingFuture<U> apply(DeferredCloser closer, @ParametricNullness V1 value1, @ParametricNullness V2 value2, @ParametricNullness V3 value3) throws Exception;
        }

        public interface ClosingFunction3<V1, V2, V3, U> {
            @ParametricNullness
            U apply(DeferredCloser closer, @ParametricNullness V1 value1, @ParametricNullness V2 value2, @ParametricNullness V3 value3) throws Exception;
        }

        /* synthetic */ Combiner3(ClosingFuture closingFuture, ClosingFuture closingFuture2, ClosingFuture closingFuture3, AnonymousClass1 anonymousClass1) {
            this(closingFuture, closingFuture2, closingFuture3);
        }

        private Combiner3(ClosingFuture<V1> future1, ClosingFuture<V2> future2, ClosingFuture<V3> future3) {
            super(true, ImmutableList.of((ClosingFuture<V3>) future1, (ClosingFuture<V3>) future2, future3), null);
            this.future1 = future1;
            this.future2 = future2;
            this.future3 = future3;
        }

        /* JADX INFO: Add missing generic type declarations: [U] */
        /* JADX INFO: renamed from: com.google.common.util.concurrent.ClosingFuture$Combiner3$1, reason: invalid class name */
        class AnonymousClass1<U> implements Combiner.CombiningCallable<U> {
            final /* synthetic */ ClosingFunction3 val$function;

            AnonymousClass1(final ClosingFunction3 val$function) {
                this.val$function = val$function;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.google.common.util.concurrent.ClosingFuture.Combiner.CombiningCallable
            @ParametricNullness
            public U call(DeferredCloser deferredCloser, Peeker peeker) throws Exception {
                return (U) this.val$function.apply(deferredCloser, peeker.getDone(Combiner3.this.future1), peeker.getDone(Combiner3.this.future2), peeker.getDone(Combiner3.this.future3));
            }

            public String toString() {
                return this.val$function.toString();
            }
        }

        public <U> ClosingFuture<U> call(ClosingFunction3<V1, V2, V3, U> closingFunction3, Executor executor) {
            return call(new AnonymousClass1(closingFunction3), executor);
        }

        /* JADX INFO: Add missing generic type declarations: [U] */
        /* JADX INFO: renamed from: com.google.common.util.concurrent.ClosingFuture$Combiner3$2, reason: invalid class name */
        class AnonymousClass2<U> implements Combiner.AsyncCombiningCallable<U> {
            final /* synthetic */ AsyncClosingFunction3 val$function;

            AnonymousClass2(final AsyncClosingFunction3 val$function) {
                this.val$function = val$function;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.google.common.util.concurrent.ClosingFuture.Combiner.AsyncCombiningCallable
            public ClosingFuture<U> call(DeferredCloser closer, Peeker peeker) throws Exception {
                return this.val$function.apply(closer, peeker.getDone(Combiner3.this.future1), peeker.getDone(Combiner3.this.future2), peeker.getDone(Combiner3.this.future3));
            }

            public String toString() {
                return this.val$function.toString();
            }
        }

        public <U> ClosingFuture<U> callAsync(AsyncClosingFunction3<V1, V2, V3, U> asyncClosingFunction3, Executor executor) {
            return callAsync(new AnonymousClass2(asyncClosingFunction3), executor);
        }
    }

    public static final class Combiner4<V1, V2, V3, V4> extends Combiner {
        private final ClosingFuture<V1> future1;
        private final ClosingFuture<V2> future2;
        private final ClosingFuture<V3> future3;
        private final ClosingFuture<V4> future4;

        public interface AsyncClosingFunction4<V1, V2, V3, V4, U> {
            ClosingFuture<U> apply(DeferredCloser closer, @ParametricNullness V1 value1, @ParametricNullness V2 value2, @ParametricNullness V3 value3, @ParametricNullness V4 value4) throws Exception;
        }

        public interface ClosingFunction4<V1, V2, V3, V4, U> {
            @ParametricNullness
            U apply(DeferredCloser closer, @ParametricNullness V1 value1, @ParametricNullness V2 value2, @ParametricNullness V3 value3, @ParametricNullness V4 value4) throws Exception;
        }

        /* synthetic */ Combiner4(ClosingFuture closingFuture, ClosingFuture closingFuture2, ClosingFuture closingFuture3, ClosingFuture closingFuture4, AnonymousClass1 anonymousClass1) {
            this(closingFuture, closingFuture2, closingFuture3, closingFuture4);
        }

        private Combiner4(ClosingFuture<V1> future1, ClosingFuture<V2> future2, ClosingFuture<V3> future3, ClosingFuture<V4> future4) {
            super(true, ImmutableList.of((ClosingFuture<V4>) future1, (ClosingFuture<V4>) future2, (ClosingFuture<V4>) future3, future4), null);
            this.future1 = future1;
            this.future2 = future2;
            this.future3 = future3;
            this.future4 = future4;
        }

        /* JADX INFO: Add missing generic type declarations: [U] */
        /* JADX INFO: renamed from: com.google.common.util.concurrent.ClosingFuture$Combiner4$1, reason: invalid class name */
        class AnonymousClass1<U> implements Combiner.CombiningCallable<U> {
            final /* synthetic */ ClosingFunction4 val$function;

            AnonymousClass1(final ClosingFunction4 val$function) {
                this.val$function = val$function;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.google.common.util.concurrent.ClosingFuture.Combiner.CombiningCallable
            @ParametricNullness
            public U call(DeferredCloser deferredCloser, Peeker peeker) throws Exception {
                return (U) this.val$function.apply(deferredCloser, peeker.getDone(Combiner4.this.future1), peeker.getDone(Combiner4.this.future2), peeker.getDone(Combiner4.this.future3), peeker.getDone(Combiner4.this.future4));
            }

            public String toString() {
                return this.val$function.toString();
            }
        }

        public <U> ClosingFuture<U> call(ClosingFunction4<V1, V2, V3, V4, U> closingFunction4, Executor executor) {
            return call(new AnonymousClass1(closingFunction4), executor);
        }

        /* JADX INFO: Add missing generic type declarations: [U] */
        /* JADX INFO: renamed from: com.google.common.util.concurrent.ClosingFuture$Combiner4$2, reason: invalid class name */
        class AnonymousClass2<U> implements Combiner.AsyncCombiningCallable<U> {
            final /* synthetic */ AsyncClosingFunction4 val$function;

            AnonymousClass2(final AsyncClosingFunction4 val$function) {
                this.val$function = val$function;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.google.common.util.concurrent.ClosingFuture.Combiner.AsyncCombiningCallable
            public ClosingFuture<U> call(DeferredCloser closer, Peeker peeker) throws Exception {
                return this.val$function.apply(closer, peeker.getDone(Combiner4.this.future1), peeker.getDone(Combiner4.this.future2), peeker.getDone(Combiner4.this.future3), peeker.getDone(Combiner4.this.future4));
            }

            public String toString() {
                return this.val$function.toString();
            }
        }

        public <U> ClosingFuture<U> callAsync(AsyncClosingFunction4<V1, V2, V3, V4, U> asyncClosingFunction4, Executor executor) {
            return callAsync(new AnonymousClass2(asyncClosingFunction4), executor);
        }
    }

    public static final class Combiner5<V1, V2, V3, V4, V5> extends Combiner {
        private final ClosingFuture<V1> future1;
        private final ClosingFuture<V2> future2;
        private final ClosingFuture<V3> future3;
        private final ClosingFuture<V4> future4;
        private final ClosingFuture<V5> future5;

        public interface AsyncClosingFunction5<V1, V2, V3, V4, V5, U> {
            ClosingFuture<U> apply(DeferredCloser closer, @ParametricNullness V1 value1, @ParametricNullness V2 value2, @ParametricNullness V3 value3, @ParametricNullness V4 value4, @ParametricNullness V5 value5) throws Exception;
        }

        public interface ClosingFunction5<V1, V2, V3, V4, V5, U> {
            @ParametricNullness
            U apply(DeferredCloser closer, @ParametricNullness V1 value1, @ParametricNullness V2 value2, @ParametricNullness V3 value3, @ParametricNullness V4 value4, @ParametricNullness V5 value5) throws Exception;
        }

        /* synthetic */ Combiner5(ClosingFuture closingFuture, ClosingFuture closingFuture2, ClosingFuture closingFuture3, ClosingFuture closingFuture4, ClosingFuture closingFuture5, AnonymousClass1 anonymousClass1) {
            this(closingFuture, closingFuture2, closingFuture3, closingFuture4, closingFuture5);
        }

        private Combiner5(ClosingFuture<V1> future1, ClosingFuture<V2> future2, ClosingFuture<V3> future3, ClosingFuture<V4> future4, ClosingFuture<V5> future5) {
            super(true, ImmutableList.of((ClosingFuture<V5>) future1, (ClosingFuture<V5>) future2, (ClosingFuture<V5>) future3, (ClosingFuture<V5>) future4, future5), null);
            this.future1 = future1;
            this.future2 = future2;
            this.future3 = future3;
            this.future4 = future4;
            this.future5 = future5;
        }

        /* JADX INFO: Add missing generic type declarations: [U] */
        /* JADX INFO: renamed from: com.google.common.util.concurrent.ClosingFuture$Combiner5$1, reason: invalid class name */
        class AnonymousClass1<U> implements Combiner.CombiningCallable<U> {
            final /* synthetic */ ClosingFunction5 val$function;

            AnonymousClass1(final ClosingFunction5 val$function) {
                this.val$function = val$function;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.google.common.util.concurrent.ClosingFuture.Combiner.CombiningCallable
            @ParametricNullness
            public U call(DeferredCloser deferredCloser, Peeker peeker) throws Exception {
                return (U) this.val$function.apply(deferredCloser, peeker.getDone(Combiner5.this.future1), peeker.getDone(Combiner5.this.future2), peeker.getDone(Combiner5.this.future3), peeker.getDone(Combiner5.this.future4), peeker.getDone(Combiner5.this.future5));
            }

            public String toString() {
                return this.val$function.toString();
            }
        }

        public <U> ClosingFuture<U> call(ClosingFunction5<V1, V2, V3, V4, V5, U> closingFunction5, Executor executor) {
            return call(new AnonymousClass1(closingFunction5), executor);
        }

        /* JADX INFO: Add missing generic type declarations: [U] */
        /* JADX INFO: renamed from: com.google.common.util.concurrent.ClosingFuture$Combiner5$2, reason: invalid class name */
        class AnonymousClass2<U> implements Combiner.AsyncCombiningCallable<U> {
            final /* synthetic */ AsyncClosingFunction5 val$function;

            AnonymousClass2(final AsyncClosingFunction5 val$function) {
                this.val$function = val$function;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.google.common.util.concurrent.ClosingFuture.Combiner.AsyncCombiningCallable
            public ClosingFuture<U> call(DeferredCloser closer, Peeker peeker) throws Exception {
                return this.val$function.apply(closer, peeker.getDone(Combiner5.this.future1), peeker.getDone(Combiner5.this.future2), peeker.getDone(Combiner5.this.future3), peeker.getDone(Combiner5.this.future4), peeker.getDone(Combiner5.this.future5));
            }

            public String toString() {
                return this.val$function.toString();
            }
        }

        public <U> ClosingFuture<U> callAsync(AsyncClosingFunction5<V1, V2, V3, V4, V5, U> asyncClosingFunction5, Executor executor) {
            return callAsync(new AnonymousClass2(asyncClosingFunction5), executor);
        }
    }

    public String toString() {
        return MoreObjects.toStringHelper(this).add("state", this.state.get()).addValue(this.future).toString();
    }

    protected void finalize() {
        if (this.state.get().equals(State.OPEN)) {
            logger.get().log(Level.SEVERE, "Uh oh! An open ClosingFuture has leaked and will close: {0}", this);
            finishToFuture();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void closeQuietly(@CheckForNull final Closeable closeable, Executor executor) {
        if (closeable == null) {
            return;
        }
        try {
            executor.execute(new ClosingFuture$$ExternalSyntheticLambda0(closeable));
        } catch (RejectedExecutionException e) {
            LazyLogger lazyLogger = logger;
            if (lazyLogger.get().isLoggable(Level.WARNING)) {
                lazyLogger.get().log(Level.WARNING, String.format("while submitting close to %s; will close inline", executor), (Throwable) e);
            }
            closeQuietly(closeable, MoreExecutors.directExecutor());
        }
    }

    static /* synthetic */ void lambda$closeQuietly$0(Closeable closeable) {
        try {
            closeable.close();
        } catch (Exception e) {
            Platform.restoreInterruptIfIsInterruptedException(e);
            logger.get().log(Level.WARNING, "thrown by close()", (Throwable) e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkAndUpdateState(State oldState, State newState) {
        Preconditions.checkState(compareAndUpdateState(oldState, newState), "Expected state to be %s, but it was %s", oldState, newState);
    }

    private boolean compareAndUpdateState(State oldState, State newState) {
        return CompositionImpl$$ExternalSyntheticBackportWithForwarding0.m(this.state, oldState, newState);
    }

    private static final class CloseableList extends IdentityHashMap<Closeable, Executor> implements Closeable {
        private volatile boolean closed;
        private final DeferredCloser closer;

        @CheckForNull
        private volatile CountDownLatch whenClosed;

        private CloseableList() {
            this.closer = new DeferredCloser(this);
        }

        /* synthetic */ CloseableList(AnonymousClass1 anonymousClass1) {
            this();
        }

        /* JADX WARN: Multi-variable type inference failed */
        <V, U> ListenableFuture<U> applyClosingFunction(ClosingFunction<? super V, U> transformation, @ParametricNullness V input) throws Exception {
            CloseableList closeableList = new CloseableList();
            try {
                return Futures.immediateFuture(transformation.apply(closeableList.closer, input));
            } finally {
                add(closeableList, MoreExecutors.directExecutor());
            }
        }

        <V, U> FluentFuture<U> applyAsyncClosingFunction(AsyncClosingFunction<V, U> transformation, @ParametricNullness V input) throws Exception {
            CloseableList closeableList = new CloseableList();
            try {
                ClosingFuture<U> closingFutureApply = transformation.apply(closeableList.closer, input);
                closingFutureApply.becomeSubsumedInto(closeableList);
                return ((ClosingFuture) closingFutureApply).future;
            } finally {
                add(closeableList, MoreExecutors.directExecutor());
            }
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (this.closed) {
                return;
            }
            synchronized (this) {
                if (this.closed) {
                    return;
                }
                this.closed = true;
                for (Map.Entry<Closeable, Executor> entry : entrySet()) {
                    ClosingFuture.closeQuietly(entry.getKey(), entry.getValue());
                }
                clear();
                if (this.whenClosed != null) {
                    this.whenClosed.countDown();
                }
            }
        }

        void add(@CheckForNull Closeable closeable, Executor executor) {
            Preconditions.checkNotNull(executor);
            if (closeable == null) {
                return;
            }
            synchronized (this) {
                if (this.closed) {
                    ClosingFuture.closeQuietly(closeable, executor);
                } else {
                    put(closeable, executor);
                }
            }
        }

        CountDownLatch whenClosedCountDown() {
            if (this.closed) {
                return new CountDownLatch(0);
            }
            synchronized (this) {
                if (this.closed) {
                    return new CountDownLatch(0);
                }
                Preconditions.checkState(this.whenClosed == null);
                CountDownLatch countDownLatch = new CountDownLatch(1);
                this.whenClosed = countDownLatch;
                return countDownLatch;
            }
        }
    }

    CountDownLatch whenClosedCountDown() {
        return this.closeables.whenClosedCountDown();
    }
}
