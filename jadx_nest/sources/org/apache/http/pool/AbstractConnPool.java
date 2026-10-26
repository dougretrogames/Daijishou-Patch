package org.apache.http.pool;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.http.concurrent.FutureCallback;
import org.apache.http.pool.PoolEntry;
import org.apache.http.util.Args;
import org.apache.http.util.Asserts;

/* INFO: loaded from: classes5.dex */
public abstract class AbstractConnPool<T, C, E extends PoolEntry<T, C>> implements ConnPool<T, E>, ConnPoolControl<T> {
    private final LinkedList<E> available;
    private final Condition condition;
    private final ConnFactory<T, C> connFactory;
    private volatile int defaultMaxPerRoute;
    private volatile boolean isShutDown;
    private final Set<E> leased;
    private final Lock lock;
    private final Map<T, Integer> maxPerRoute;
    private volatile int maxTotal;
    private final LinkedList<Future<E>> pending;
    private final Map<T, RouteSpecificPool<T, C, E>> routeToPool;
    private volatile int validateAfterInactivity;

    protected abstract E createEntry(T t, C c);

    protected void onLease(E e) {
    }

    protected void onRelease(E e) {
    }

    protected void onReuse(E e) {
    }

    protected boolean validate(E e) {
        return true;
    }

    public AbstractConnPool(ConnFactory<T, C> connFactory, int i, int i2) {
        this.connFactory = (ConnFactory) Args.notNull(connFactory, "Connection factory");
        this.defaultMaxPerRoute = Args.positive(i, "Max per route value");
        this.maxTotal = Args.positive(i2, "Max total value");
        ReentrantLock reentrantLock = new ReentrantLock();
        this.lock = reentrantLock;
        this.condition = reentrantLock.newCondition();
        this.routeToPool = new HashMap();
        this.leased = new HashSet();
        this.available = new LinkedList<>();
        this.pending = new LinkedList<>();
        this.maxPerRoute = new HashMap();
    }

    public boolean isShutdown() {
        return this.isShutDown;
    }

    public void shutdown() throws IOException {
        if (this.isShutDown) {
            return;
        }
        this.isShutDown = true;
        this.lock.lock();
        try {
            Iterator<E> it = this.available.iterator();
            while (it.hasNext()) {
                it.next().close();
            }
            Iterator<E> it2 = this.leased.iterator();
            while (it2.hasNext()) {
                it2.next().close();
            }
            Iterator<RouteSpecificPool<T, C, E>> it3 = this.routeToPool.values().iterator();
            while (it3.hasNext()) {
                it3.next().shutdown();
            }
            this.routeToPool.clear();
            this.leased.clear();
            this.available.clear();
        } finally {
            this.lock.unlock();
        }
    }

    private RouteSpecificPool<T, C, E> getPool(T t) {
        RouteSpecificPool<T, C, E> routeSpecificPool = this.routeToPool.get(t);
        if (routeSpecificPool != null) {
            return routeSpecificPool;
        }
        AnonymousClass1 anonymousClass1 = new AnonymousClass1(t, t);
        this.routeToPool.put(t, anonymousClass1);
        return anonymousClass1;
    }

    /* INFO: renamed from: org.apache.http.pool.AbstractConnPool$1, reason: invalid class name */
    class AnonymousClass1 extends RouteSpecificPool<T, C, E> {
        final /* synthetic */ Object val$route;

        /* WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(Object obj, Object obj2) {
            super(obj);
            this.val$route = obj2;
        }

        /* WARN: Multi-variable type inference failed */
        @Override // org.apache.http.pool.RouteSpecificPool
        protected E createEntry(C c) {
            return (E) AbstractConnPool.this.createEntry(this.val$route, c);
        }
    }

    /* INFO: Access modifiers changed from: private */
    public static Exception operationAborted() {
        return new CancellationException("Operation aborted");
    }

    @Override // org.apache.http.pool.ConnPool
    public Future<E> lease(T t, Object obj, FutureCallback<E> futureCallback) {
        Args.notNull(t, "Route");
        Asserts.check(!this.isShutDown, "Connection pool shut down");
        return new AnonymousClass2(futureCallback, t, obj);
    }

    /* INFO: renamed from: org.apache.http.pool.AbstractConnPool$2, reason: invalid class name */
    class AnonymousClass2 implements Future<E> {
        private final AtomicBoolean cancelled = new AtomicBoolean(false);
        private final AtomicBoolean done = new AtomicBoolean(false);
        private final AtomicReference<E> entryRef = new AtomicReference<>(null);
        final /* synthetic */ FutureCallback val$callback;
        final /* synthetic */ Object val$route;
        final /* synthetic */ Object val$state;

        AnonymousClass2(FutureCallback futureCallback, Object obj, Object obj2) {
            this.val$callback = futureCallback;
            this.val$route = obj;
            this.val$state = obj2;
        }

        @Override // java.util.concurrent.Future
        public boolean cancel(boolean z) {
            if (!this.done.compareAndSet(false, true)) {
                return false;
            }
            this.cancelled.set(true);
            AbstractConnPool.this.lock.lock();
            try {
                AbstractConnPool.this.condition.signalAll();
                AbstractConnPool.this.lock.unlock();
                FutureCallback futureCallback = this.val$callback;
                if (futureCallback != null) {
                    futureCallback.cancelled();
                }
                return true;
            } catch (Throwable th) {
                AbstractConnPool.this.lock.unlock();
                throw th;
            }
        }

        @Override // java.util.concurrent.Future
        public boolean isCancelled() {
            return this.cancelled.get();
        }

        @Override // java.util.concurrent.Future
        public boolean isDone() {
            return this.done.get();
        }

        @Override // java.util.concurrent.Future
        public E get() throws ExecutionException, InterruptedException {
            try {
                return (E) get(0L, TimeUnit.MILLISECONDS);
            } catch (TimeoutException e) {
                throw new ExecutionException(e);
            }
        }

        /* WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class decompiler.core.dex.instructions.args.ArgType$UnknownArg
        	at decompiler.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at decompiler.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at decompiler.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at decompiler.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at decompiler.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at decompiler.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at decompiler.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        @Override // java.util.concurrent.Future
        public E get(long j, TimeUnit timeUnit) throws Throwable {
            AnonymousClass2 anonymousClass2;
            FutureCallback futureCallback;
            Throwable th;
            long j2;
            TimeUnit timeUnit2;
            while (true) {
                synchronized (this) {
                    try {
                        E e = this.entryRef.get();
                        if (e != null) {
                            try {
                                return e;
                            } catch (Throwable th2) {
                                th = th2;
                                throw th;
                            }
                        }
                        if (!this.done.get()) {
                            anonymousClass2 = this;
                            j2 = j;
                            timeUnit2 = timeUnit;
                            try {
                                try {
                                    E e2 = (E) AbstractConnPool.this.getPoolEntryBlocking(this.val$route, this.val$state, j2, timeUnit2, anonymousClass2);
                                    if (AbstractConnPool.this.validateAfterInactivity > 0 && e2.getUpdated() + ((long) AbstractConnPool.this.validateAfterInactivity) <= System.currentTimeMillis() && !AbstractConnPool.this.validate(e2)) {
                                        e2.close();
                                        AbstractConnPool.this.release((PoolEntry) e2, false);
                                    } else {
                                        if (anonymousClass2.done.compareAndSet(false, true)) {
                                            anonymousClass2.entryRef.set(e2);
                                            anonymousClass2.done.set(true);
                                            AbstractConnPool.this.onLease(e2);
                                            FutureCallback futureCallback2 = anonymousClass2.val$callback;
                                            if (futureCallback2 != null) {
                                                futureCallback2.completed(e2);
                                            }
                                            return e2;
                                        }
                                        AbstractConnPool.this.release((PoolEntry) e2, true);
                                        throw new ExecutionException(AbstractConnPool.operationAborted());
                                    }
                                } catch (Throwable th3) {
                                    th = th3;
                                    th = th;
                                    throw th;
                                }
                            } catch (IOException e3) {
                                e = e3;
                            }
                        } else {
                            throw new ExecutionException(AbstractConnPool.operationAborted());
                        }
                    } catch (IOException e4) {
                        e = e4;
                        anonymousClass2 = this;
                    } catch (Throwable th4) {
                        th = th4;
                    }
                    IOException iOException = e;
                    if (anonymousClass2.done.compareAndSet(false, true) && (futureCallback = anonymousClass2.val$callback) != null) {
                        futureCallback.failed(iOException);
                    }
                    throw new ExecutionException(iOException);
                }
                j = j2;
                timeUnit = timeUnit2;
            }
        }
    }

    public Future<E> lease(T t, Object obj) {
        return lease(t, obj, null);
    }

    /* INFO: Access modifiers changed from: private */
    /* WARN: Multi-variable type inference failed */
    public E getPoolEntryBlocking(T t, Object obj, long j, TimeUnit timeUnit, Future<E> future) throws ExecutionException, InterruptedException, TimeoutException, IOException {
        E e;
        Date date = j > 0 ? new Date(System.currentTimeMillis() + timeUnit.toMillis(j)) : null;
        this.lock.lock();
        while (true) {
            try {
                boolean zAwaitUntil = true;
                Asserts.check(!this.isShutDown, "Connection pool shut down");
                if (future.isCancelled()) {
                    throw new ExecutionException(operationAborted());
                }
                RouteSpecificPool pool = getPool(t);
                while (true) {
                    e = (E) pool.getFree(obj);
                    if (e == null) {
                        break;
                    }
                    if (e.isExpired(System.currentTimeMillis())) {
                        e.close();
                    }
                    if (!e.isClosed()) {
                        break;
                    }
                    this.available.remove(e);
                    pool.free(e, false);
                }
                if (e != null) {
                    this.available.remove(e);
                    this.leased.add(e);
                    onReuse(e);
                    this.lock.unlock();
                    return e;
                }
                int max = getMax(t);
                int iMax = Math.max(0, (pool.getAllocatedCount() + 1) - max);
                if (iMax > 0) {
                    for (int i = 0; i < iMax; i++) {
                        PoolEntry lastUsed = pool.getLastUsed();
                        if (lastUsed == null) {
                            break;
                        }
                        lastUsed.close();
                        this.available.remove(lastUsed);
                        pool.remove(lastUsed);
                    }
                }
                if (pool.getAllocatedCount() < max) {
                    int iMax2 = Math.max(this.maxTotal - this.leased.size(), 0);
                    if (iMax2 > 0) {
                        if (this.available.size() > iMax2 - 1) {
                            E eRemoveLast = this.available.removeLast();
                            eRemoveLast.close();
                            getPool(eRemoveLast.getRoute()).remove(eRemoveLast);
                        }
                        E e2 = (E) pool.add(this.connFactory.create(t));
                        this.leased.add(e2);
                        this.lock.unlock();
                        return e2;
                    }
                }
                try {
                    pool.queue(future);
                    this.pending.add(future);
                    if (date != null) {
                        zAwaitUntil = this.condition.awaitUntil(date);
                    } else {
                        this.condition.await();
                    }
                    if (future.isCancelled()) {
                        throw new ExecutionException(operationAborted());
                    }
                    pool.unqueue(future);
                    this.pending.remove(future);
                    if (!zAwaitUntil && date != null && date.getTime() <= System.currentTimeMillis()) {
                        throw new TimeoutException("Timeout waiting for connection");
                    }
                } catch (Throwable th) {
                    pool.unqueue(future);
                    this.pending.remove(future);
                    throw th;
                }
            } catch (Throwable th2) {
                this.lock.unlock();
                throw th2;
            }
        }
    }

    /* WARN: Multi-variable type inference failed */
    @Override // org.apache.http.pool.ConnPool
    public void release(E e, boolean z) {
        this.lock.lock();
        try {
            if (this.leased.remove(e)) {
                RouteSpecificPool pool = getPool(e.getRoute());
                pool.free(e, z);
                if (z && !this.isShutDown) {
                    this.available.addFirst(e);
                } else {
                    e.close();
                }
                onRelease(e);
                Future<E> futureNextPending = pool.nextPending();
                if (futureNextPending != null) {
                    this.pending.remove(futureNextPending);
                } else {
                    futureNextPending = this.pending.poll();
                }
                if (futureNextPending != null) {
                    this.condition.signalAll();
                }
            }
        } finally {
            this.lock.unlock();
        }
    }

    private int getMax(T t) {
        Integer num = this.maxPerRoute.get(t);
        return num != null ? num.intValue() : this.defaultMaxPerRoute;
    }

    @Override // org.apache.http.pool.ConnPoolControl
    public void setMaxTotal(int i) {
        Args.positive(i, "Max value");
        this.lock.lock();
        try {
            this.maxTotal = i;
        } finally {
            this.lock.unlock();
        }
    }

    @Override // org.apache.http.pool.ConnPoolControl
    public int getMaxTotal() {
        this.lock.lock();
        try {
            return this.maxTotal;
        } finally {
            this.lock.unlock();
        }
    }

    @Override // org.apache.http.pool.ConnPoolControl
    public void setDefaultMaxPerRoute(int i) {
        Args.positive(i, "Max per route value");
        this.lock.lock();
        try {
            this.defaultMaxPerRoute = i;
        } finally {
            this.lock.unlock();
        }
    }

    @Override // org.apache.http.pool.ConnPoolControl
    public int getDefaultMaxPerRoute() {
        this.lock.lock();
        try {
            return this.defaultMaxPerRoute;
        } finally {
            this.lock.unlock();
        }
    }

    @Override // org.apache.http.pool.ConnPoolControl
    public void setMaxPerRoute(T t, int i) {
        Args.notNull(t, "Route");
        this.lock.lock();
        try {
            if (i > -1) {
                this.maxPerRoute.put(t, Integer.valueOf(i));
            } else {
                this.maxPerRoute.remove(t);
            }
            this.lock.unlock();
        } catch (Throwable th) {
            this.lock.unlock();
            throw th;
        }
    }

    @Override // org.apache.http.pool.ConnPoolControl
    public int getMaxPerRoute(T t) {
        Args.notNull(t, "Route");
        this.lock.lock();
        try {
            return getMax(t);
        } finally {
            this.lock.unlock();
        }
    }

    @Override // org.apache.http.pool.ConnPoolControl
    public PoolStats getTotalStats() {
        this.lock.lock();
        try {
            return new PoolStats(this.leased.size(), this.pending.size(), this.available.size(), this.maxTotal);
        } finally {
            this.lock.unlock();
        }
    }

    @Override // org.apache.http.pool.ConnPoolControl
    public PoolStats getStats(T t) {
        Args.notNull(t, "Route");
        this.lock.lock();
        try {
            RouteSpecificPool<T, C, E> pool = getPool(t);
            return new PoolStats(pool.getLeasedCount(), pool.getPendingCount(), pool.getAvailableCount(), getMax(t));
        } finally {
            this.lock.unlock();
        }
    }

    public Set<T> getRoutes() {
        this.lock.lock();
        try {
            return new HashSet(this.routeToPool.keySet());
        } finally {
            this.lock.unlock();
        }
    }

    protected void enumAvailable(PoolEntryCallback<T, C> poolEntryCallback) {
        this.lock.lock();
        try {
            Iterator<E> it = this.available.iterator();
            while (it.hasNext()) {
                E next = it.next();
                poolEntryCallback.process(next);
                if (next.isClosed()) {
                    getPool(next.getRoute()).remove(next);
                    it.remove();
                }
            }
            purgePoolMap();
        } finally {
            this.lock.unlock();
        }
    }

    protected void enumLeased(PoolEntryCallback<T, C> poolEntryCallback) {
        this.lock.lock();
        try {
            Iterator<E> it = this.leased.iterator();
            while (it.hasNext()) {
                poolEntryCallback.process(it.next());
            }
            this.lock.unlock();
        } catch (Throwable th) {
            this.lock.unlock();
            throw th;
        }
    }

    private void purgePoolMap() {
        Iterator<Map.Entry<T, RouteSpecificPool<T, C, E>>> it = this.routeToPool.entrySet().iterator();
        while (it.hasNext()) {
            RouteSpecificPool<T, C, E> value = it.next().getValue();
            if (value.getPendingCount() + value.getAllocatedCount() == 0) {
                it.remove();
            }
        }
    }

    public void closeIdle(long j, TimeUnit timeUnit) {
        Args.notNull(timeUnit, "Time unit");
        long millis = timeUnit.toMillis(j);
        if (millis < 0) {
            millis = 0;
        }
        enumAvailable(new AnonymousClass3(System.currentTimeMillis() - millis));
    }

    /* INFO: renamed from: org.apache.http.pool.AbstractConnPool$3, reason: invalid class name */
    class AnonymousClass3 implements PoolEntryCallback<T, C> {
        final /* synthetic */ long val$deadline;

        AnonymousClass3(long j) {
            this.val$deadline = j;
        }

        @Override // org.apache.http.pool.PoolEntryCallback
        public void process(PoolEntry<T, C> poolEntry) {
            if (poolEntry.getUpdated() <= this.val$deadline) {
                poolEntry.close();
            }
        }
    }

    /* INFO: renamed from: org.apache.http.pool.AbstractConnPool$4, reason: invalid class name */
    class AnonymousClass4 implements PoolEntryCallback<T, C> {
        final /* synthetic */ long val$now;

        AnonymousClass4(long j) {
            this.val$now = j;
        }

        @Override // org.apache.http.pool.PoolEntryCallback
        public void process(PoolEntry<T, C> poolEntry) {
            if (poolEntry.isExpired(this.val$now)) {
                poolEntry.close();
            }
        }
    }

    public void closeExpired() {
        enumAvailable(new AnonymousClass4(System.currentTimeMillis()));
    }

    public int getValidateAfterInactivity() {
        return this.validateAfterInactivity;
    }

    public void setValidateAfterInactivity(int i) {
        this.validateAfterInactivity = i;
    }

    public String toString() {
        this.lock.lock();
        try {
            return "[leased: " + this.leased + "][available: " + this.available + "][pending: " + this.pending + CollectionUtils.DEFAULT_TOSTRING_SUFFIX;
        } finally {
            this.lock.unlock();
        }
    }
}
