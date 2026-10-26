package io.grpc;

import java.io.Closeable;
import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReference;
import java.util.logging.Level;
import java.util.logging.Logger;

/* INFO: loaded from: classes4.dex */
public class Context {
    static final int CONTEXT_DEPTH_WARN_THRESH = 1000;
    final CancellableContext cancellableAncestor;
    final int generation;
    final PersistentHashArrayMappedTrie.Node<Key<?>, Object> keyValueEntries;
    static final Logger log = Logger.getLogger(Context.class.getName());
    public static final Context ROOT = new Context();

    @interface CanIgnoreReturnValue {
    }

    public interface CancellationListener {
        void cancelled(Context context);
    }

    @interface CheckReturnValue {
    }

    public static abstract class Storage {
        public abstract Context current();

        public abstract void detach(Context context, Context context2);

        public abstract Context doAttach(Context context);
    }

    /* synthetic */ Context(Context context, PersistentHashArrayMappedTrie.Node node, AnonymousClass1 anonymousClass1) {
        this(context, (PersistentHashArrayMappedTrie.Node<Key<?>, Object>) node);
    }

    static Storage storage() {
        return LazyStorage.storage;
    }

    private static final class LazyStorage {
        static final Storage storage;

        private LazyStorage() {
        }

        static {
            AtomicReference atomicReference = new AtomicReference();
            storage = createStorage(atomicReference);
            Throwable th = (Throwable) atomicReference.get();
            if (th != null) {
                Context.log.log(Level.FINE, "Storage override doesn't exist. Using default", th);
            }
        }

        private static Storage createStorage(AtomicReference<? super ClassNotFoundException> atomicReference) {
            try {
                return (Storage) Class.forName("io.grpc.override.ContextStorageOverride").asSubclass(Storage.class).getConstructor(new Class[0]).newInstance(new Object[0]);
            } catch (ClassNotFoundException e) {
                atomicReference.set(e);
                return new ThreadLocalContextStorage();
            } catch (Exception e2) {
                throw new RuntimeException("Storage override failed to initialize", e2);
            }
        }
    }

    public static <T> Key<T> key(String str) {
        return new Key<>(str);
    }

    public static <T> Key<T> keyWithDefault(String str, T t) {
        return new Key<>(str, t);
    }

    public static Context current() {
        Context contextCurrent = storage().current();
        return contextCurrent == null ? ROOT : contextCurrent;
    }

    private Context(PersistentHashArrayMappedTrie.Node<Key<?>, Object> node, int i) {
        this.cancellableAncestor = null;
        this.keyValueEntries = node;
        this.generation = i;
        validateGeneration(i);
    }

    private Context(Context context, PersistentHashArrayMappedTrie.Node<Key<?>, Object> node) {
        this.cancellableAncestor = cancellableAncestor(context);
        this.keyValueEntries = node;
        int i = context.generation + 1;
        this.generation = i;
        validateGeneration(i);
    }

    private Context() {
        this.cancellableAncestor = null;
        this.keyValueEntries = null;
        this.generation = 0;
        validateGeneration(0);
    }

    public CancellableContext withCancellation() {
        return new CancellableContext(this, (AnonymousClass1) null);
    }

    public CancellableContext withDeadlineAfter(long j, TimeUnit timeUnit, ScheduledExecutorService scheduledExecutorService) {
        return withDeadline(Deadline.after(j, timeUnit), scheduledExecutorService);
    }

    public CancellableContext withDeadline(Deadline deadline, ScheduledExecutorService scheduledExecutorService) {
        boolean z;
        checkNotNull(deadline, "deadline");
        checkNotNull(scheduledExecutorService, "scheduler");
        Deadline deadline2 = getDeadline();
        if (deadline2 == null || deadline2.compareTo(deadline) > 0) {
            z = true;
        } else {
            z = false;
            deadline = deadline2;
        }
        CancellableContext cancellableContext = new CancellableContext(this, deadline, null);
        if (z) {
            cancellableContext.setUpDeadlineCancellation(deadline, scheduledExecutorService);
        }
        return cancellableContext;
    }

    public <V> Context withValue(Key<V> key, V v) {
        return new Context(this, (PersistentHashArrayMappedTrie.Node<Key<?>, Object>) PersistentHashArrayMappedTrie.put(this.keyValueEntries, key, v));
    }

    public <V1, V2> Context withValues(Key<V1> key, V1 v1, Key<V2> key2, V2 v2) {
        return new Context(this, (PersistentHashArrayMappedTrie.Node<Key<?>, Object>) PersistentHashArrayMappedTrie.put(PersistentHashArrayMappedTrie.put(this.keyValueEntries, key, v1), key2, v2));
    }

    public <V1, V2, V3> Context withValues(Key<V1> key, V1 v1, Key<V2> key2, V2 v2, Key<V3> key3, V3 v3) {
        return new Context(this, (PersistentHashArrayMappedTrie.Node<Key<?>, Object>) PersistentHashArrayMappedTrie.put(PersistentHashArrayMappedTrie.put(PersistentHashArrayMappedTrie.put(this.keyValueEntries, key, v1), key2, v2), key3, v3));
    }

    public <V1, V2, V3, V4> Context withValues(Key<V1> key, V1 v1, Key<V2> key2, V2 v2, Key<V3> key3, V3 v3, Key<V4> key4, V4 v4) {
        return new Context(this, (PersistentHashArrayMappedTrie.Node<Key<?>, Object>) PersistentHashArrayMappedTrie.put(PersistentHashArrayMappedTrie.put(PersistentHashArrayMappedTrie.put(PersistentHashArrayMappedTrie.put(this.keyValueEntries, key, v1), key2, v2), key3, v3), key4, v4));
    }

    public Context fork() {
        return new Context(this.keyValueEntries, this.generation + 1);
    }

    public Context attach() {
        Context contextDoAttach = storage().doAttach(this);
        return contextDoAttach == null ? ROOT : contextDoAttach;
    }

    public void detach(Context context) {
        checkNotNull(context, "toAttach");
        storage().detach(this, context);
    }

    boolean isCurrent() {
        return current() == this;
    }

    public boolean isCancelled() {
        CancellableContext cancellableContext = this.cancellableAncestor;
        if (cancellableContext == null) {
            return false;
        }
        return cancellableContext.isCancelled();
    }

    public Throwable cancellationCause() {
        CancellableContext cancellableContext = this.cancellableAncestor;
        if (cancellableContext == null) {
            return null;
        }
        return cancellableContext.cancellationCause();
    }

    public Deadline getDeadline() {
        CancellableContext cancellableContext = this.cancellableAncestor;
        if (cancellableContext == null) {
            return null;
        }
        return cancellableContext.getDeadline();
    }

    public void addListener(CancellationListener cancellationListener, Executor executor) {
        checkNotNull(cancellationListener, "cancellationListener");
        checkNotNull(executor, "executor");
        CancellableContext cancellableContext = this.cancellableAncestor;
        if (cancellableContext == null) {
            return;
        }
        cancellableContext.addListenerInternal(new ExecutableListener(executor, cancellationListener, this));
    }

    public void removeListener(CancellationListener cancellationListener) {
        CancellableContext cancellableContext = this.cancellableAncestor;
        if (cancellableContext == null) {
            return;
        }
        cancellableContext.removeListenerInternal(cancellationListener, this);
    }

    int listenerCount() {
        CancellableContext cancellableContext = this.cancellableAncestor;
        if (cancellableContext == null) {
            return 0;
        }
        return cancellableContext.listenerCount();
    }

    public void run(Runnable runnable) {
        Context contextAttach = attach();
        try {
            runnable.run();
        } finally {
            detach(contextAttach);
        }
    }

    public <V> V call(Callable<V> callable) throws Exception {
        Context contextAttach = attach();
        try {
            return callable.call();
        } finally {
            detach(contextAttach);
        }
    }

    /* INFO: renamed from: io.grpc.Context$1, reason: invalid class name */
    class AnonymousClass1 implements Runnable {
        final /* synthetic */ Runnable val$r;

        AnonymousClass1(Runnable runnable) {
            this.val$r = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            Context contextAttach = Context.this.attach();
            try {
                this.val$r.run();
            } finally {
                Context.this.detach(contextAttach);
            }
        }
    }

    public Runnable wrap(Runnable runnable) {
        return new AnonymousClass1(runnable);
    }

    /* INFO: Add missing generic type declarations: [C] */
    /* INFO: renamed from: io.grpc.Context$2, reason: invalid class name */
    class AnonymousClass2<C> implements Callable<C> {
        final /* synthetic */ Callable val$c;

        AnonymousClass2(Callable callable) {
            this.val$c = callable;
        }

        @Override // java.util.concurrent.Callable
        public C call() throws Exception {
            Context contextAttach = Context.this.attach();
            try {
                return (C) this.val$c.call();
            } finally {
                Context.this.detach(contextAttach);
            }
        }
    }

    public <C> Callable<C> wrap(Callable<C> callable) {
        return new AnonymousClass2(callable);
    }

    /* INFO: renamed from: io.grpc.Context$1FixedContextExecutor, reason: invalid class name */
    final class C1FixedContextExecutor implements Executor {
        final /* synthetic */ Executor val$e;

        C1FixedContextExecutor(Executor executor) {
            this.val$e = executor;
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            this.val$e.execute(Context.this.wrap(runnable));
        }
    }

    public Executor fixedContextExecutor(Executor executor) {
        return new C1FixedContextExecutor(executor);
    }

    /* INFO: renamed from: io.grpc.Context$1CurrentContextExecutor, reason: invalid class name */
    final class C1CurrentContextExecutor implements Executor {
        final /* synthetic */ Executor val$e;

        C1CurrentContextExecutor(Executor executor) {
            this.val$e = executor;
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            this.val$e.execute(Context.current().wrap(runnable));
        }
    }

    public static Executor currentContextExecutor(Executor executor) {
        return new C1CurrentContextExecutor(executor);
    }

    public static final class CancellableContext extends Context implements Closeable {
        private Throwable cancellationCause;
        private boolean cancelled;
        private final Deadline deadline;
        private ArrayList<ExecutableListener> listeners;
        private CancellationListener parentListener;
        private ScheduledFuture<?> pendingDeadline;
        private final Context uncancellableSurrogate;

        /* synthetic */ CancellableContext(Context context, AnonymousClass1 anonymousClass1) {
            this(context);
        }

        /* synthetic */ CancellableContext(Context context, Deadline deadline, AnonymousClass1 anonymousClass1) {
            this(context, deadline);
        }

        private CancellableContext(Context context) {
            super(context, context.keyValueEntries, null);
            this.deadline = context.getDeadline();
            this.uncancellableSurrogate = new Context(this, this.keyValueEntries, null);
        }

        private CancellableContext(Context context, Deadline deadline) {
            super(context, context.keyValueEntries, null);
            this.deadline = deadline;
            this.uncancellableSurrogate = new Context(this, this.keyValueEntries, null);
        }

        /* INFO: renamed from: io.grpc.Context$CancellableContext$1CancelOnExpiration, reason: invalid class name */
        final class C1CancelOnExpiration implements Runnable {
            C1CancelOnExpiration() {
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    CancellableContext.this.cancel(new TimeoutException("context timed out"));
                } catch (Throwable th) {
                    Context.log.log(Level.SEVERE, "Cancel threw an exception, which should not happen", th);
                }
            }
        }

        /* INFO: Access modifiers changed from: private */
        public void setUpDeadlineCancellation(Deadline deadline, ScheduledExecutorService scheduledExecutorService) {
            if (!deadline.isExpired()) {
                synchronized (this) {
                    this.pendingDeadline = deadline.runOnExpiration(new C1CancelOnExpiration(), scheduledExecutorService);
                }
            } else {
                cancel(new TimeoutException("context timed out"));
            }
        }

        @Override // io.grpc.Context
        public Context attach() {
            return this.uncancellableSurrogate.attach();
        }

        @Override // io.grpc.Context
        public void detach(Context context) {
            this.uncancellableSurrogate.detach(context);
        }

        @Override // io.grpc.Context
        public void addListener(CancellationListener cancellationListener, Executor executor) {
            checkNotNull(cancellationListener, "cancellationListener");
            checkNotNull(executor, "executor");
            addListenerInternal(new ExecutableListener(executor, cancellationListener, this));
        }

        /* INFO: Access modifiers changed from: private */
        public void addListenerInternal(ExecutableListener executableListener) {
            synchronized (this) {
                if (isCancelled()) {
                    executableListener.deliver();
                } else {
                    ArrayList<ExecutableListener> arrayList = this.listeners;
                    if (arrayList == null) {
                        ArrayList<ExecutableListener> arrayList2 = new ArrayList<>();
                        this.listeners = arrayList2;
                        arrayList2.add(executableListener);
                        if (this.cancellableAncestor != null) {
                            this.parentListener = new AnonymousClass1();
                            this.cancellableAncestor.addListenerInternal(new ExecutableListener(DirectExecutor.INSTANCE, this.parentListener, this));
                        }
                    } else {
                        arrayList.add(executableListener);
                    }
                }
            }
        }

        /* INFO: renamed from: io.grpc.Context$CancellableContext$1, reason: invalid class name */
        class AnonymousClass1 implements CancellationListener {
            AnonymousClass1() {
            }

            @Override // io.grpc.Context.CancellationListener
            public void cancelled(Context context) {
                CancellableContext.this.cancel(context.cancellationCause());
            }
        }

        @Override // io.grpc.Context
        public void removeListener(CancellationListener cancellationListener) {
            removeListenerInternal(cancellationListener, this);
        }

        /* INFO: Access modifiers changed from: private */
        public void removeListenerInternal(CancellationListener cancellationListener, Context context) {
            synchronized (this) {
                ArrayList<ExecutableListener> arrayList = this.listeners;
                if (arrayList != null) {
                    for (int size = arrayList.size() - 1; size >= 0; size--) {
                        ExecutableListener executableListener = this.listeners.get(size);
                        if (executableListener.listener == cancellationListener && executableListener.context == context) {
                            this.listeners.remove(size);
                            break;
                        }
                    }
                    if (this.listeners.isEmpty()) {
                        if (this.cancellableAncestor != null) {
                            this.cancellableAncestor.removeListener(this.parentListener);
                        }
                        this.parentListener = null;
                        this.listeners = null;
                    }
                }
            }
        }

        @Override // io.grpc.Context
        @Deprecated
        public boolean isCurrent() {
            return this.uncancellableSurrogate.isCurrent();
        }

        public boolean cancel(Throwable th) {
            ScheduledFuture<?> scheduledFuture;
            boolean z;
            synchronized (this) {
                scheduledFuture = null;
                if (this.cancelled) {
                    z = false;
                } else {
                    z = true;
                    this.cancelled = true;
                    ScheduledFuture<?> scheduledFuture2 = this.pendingDeadline;
                    if (scheduledFuture2 != null) {
                        this.pendingDeadline = null;
                        scheduledFuture = scheduledFuture2;
                    }
                    this.cancellationCause = th;
                }
            }
            if (scheduledFuture != null) {
                scheduledFuture.cancel(false);
            }
            if (z) {
                notifyAndClearListeners();
            }
            return z;
        }

        private void notifyAndClearListeners() {
            synchronized (this) {
                ArrayList<ExecutableListener> arrayList = this.listeners;
                if (arrayList == null) {
                    return;
                }
                CancellationListener cancellationListener = this.parentListener;
                this.parentListener = null;
                this.listeners = null;
                for (ExecutableListener executableListener : arrayList) {
                    if (executableListener.context == this) {
                        executableListener.deliver();
                    }
                }
                for (ExecutableListener executableListener2 : arrayList) {
                    if (executableListener2.context != this) {
                        executableListener2.deliver();
                    }
                }
                if (this.cancellableAncestor != null) {
                    this.cancellableAncestor.removeListener(cancellationListener);
                }
            }
        }

        @Override // io.grpc.Context
        int listenerCount() {
            int size;
            synchronized (this) {
                ArrayList<ExecutableListener> arrayList = this.listeners;
                size = arrayList == null ? 0 : arrayList.size();
            }
            return size;
        }

        public void detachAndCancel(Context context, Throwable th) {
            try {
                detach(context);
            } finally {
                cancel(th);
            }
        }

        @Override // io.grpc.Context
        public boolean isCancelled() {
            synchronized (this) {
                if (this.cancelled) {
                    return true;
                }
                if (!super.isCancelled()) {
                    return false;
                }
                cancel(super.cancellationCause());
                return true;
            }
        }

        @Override // io.grpc.Context
        public Throwable cancellationCause() {
            if (isCancelled()) {
                return this.cancellationCause;
            }
            return null;
        }

        @Override // io.grpc.Context
        public Deadline getDeadline() {
            return this.deadline;
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            cancel(null);
        }
    }

    public static final class Key<T> {
        private final T defaultValue;
        private final String name;

        Key(String str) {
            this(str, null);
        }

        Key(String str, T t) {
            this.name = (String) Context.checkNotNull(str, "name");
            this.defaultValue = t;
        }

        public T get() {
            return get(Context.current());
        }

        public T get(Context context) {
            T t = (T) PersistentHashArrayMappedTrie.get(context.keyValueEntries, this);
            return t == null ? this.defaultValue : t;
        }

        public String toString() {
            return this.name;
        }
    }

    private static final class ExecutableListener implements Runnable {
        private final Context context;
        private final Executor executor;
        final CancellationListener listener;

        ExecutableListener(Executor executor, CancellationListener cancellationListener, Context context) {
            this.executor = executor;
            this.listener = cancellationListener;
            this.context = context;
        }

        void deliver() {
            try {
                this.executor.execute(this);
            } catch (Throwable th) {
                Context.log.log(Level.INFO, "Exception notifying context listener", th);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            this.listener.cancelled(this.context);
        }
    }

    static <T> T checkNotNull(T t, Object obj) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(String.valueOf(obj));
    }

    private enum DirectExecutor implements Executor {
        INSTANCE;

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            runnable.run();
        }

        @Override // java.lang.Enum
        public String toString() {
            return "Context.DirectExecutor";
        }
    }

    static CancellableContext cancellableAncestor(Context context) {
        if (context instanceof CancellableContext) {
            return (CancellableContext) context;
        }
        return context.cancellableAncestor;
    }

    private static void validateGeneration(int i) {
        if (i == 1000) {
            log.log(Level.SEVERE, "Context ancestry chain length is abnormally long. This suggests an error in application code. Length exceeded: 1000", (Throwable) new Exception());
        }
    }
}
