package defpackage;

import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.sync.Mutex;
import org.eclipse.jgit.lib.ConfigConstants;

/* JADX INFO: compiled from: ReentrantMutex.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\t\u0010\b\u001a\u00020\u0004HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0004HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"LReentrantMutexContextKey;", "Lkotlin/coroutines/CoroutineContext$Key;", "LReentrantMutexContextElement;", "mutex", "Lkotlinx/coroutines/sync/Mutex;", "(Lkotlinx/coroutines/sync/Mutex;)V", "getMutex", "()Lkotlinx/coroutines/sync/Mutex;", "component1", ConfigConstants.CONFIG_RENAMELIMIT_COPY, "equals", "", "other", "", "hashCode", "", "toString", "", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final /* data */ class ReentrantMutexContextKey implements CoroutineContext.Key<ReentrantMutexContextElement> {
    private final Mutex mutex;

    public static /* synthetic */ ReentrantMutexContextKey copy$default(ReentrantMutexContextKey reentrantMutexContextKey, Mutex mutex, int i, Object obj) {
        if ((i & 1) != 0) {
            mutex = reentrantMutexContextKey.mutex;
        }
        return reentrantMutexContextKey.copy(mutex);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Mutex getMutex() {
        return this.mutex;
    }

    public final ReentrantMutexContextKey copy(Mutex mutex) {
        Intrinsics.checkNotNullParameter(mutex, "mutex");
        return new ReentrantMutexContextKey(mutex);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof ReentrantMutexContextKey) && Intrinsics.areEqual(this.mutex, ((ReentrantMutexContextKey) other).mutex);
    }

    public int hashCode() {
        return this.mutex.hashCode();
    }

    public String toString() {
        return "ReentrantMutexContextKey(mutex=" + this.mutex + ")";
    }

    public ReentrantMutexContextKey(Mutex mutex) {
        Intrinsics.checkNotNullParameter(mutex, "mutex");
        this.mutex = mutex;
    }

    public final Mutex getMutex() {
        return this.mutex;
    }
}
