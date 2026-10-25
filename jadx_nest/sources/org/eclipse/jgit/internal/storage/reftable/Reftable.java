package org.eclipse.jgit.internal.storage.reftable;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Collection;
import org.eclipse.jgit.annotations.Nullable;
import org.eclipse.jgit.internal.storage.io.BlockSource;
import org.eclipse.jgit.lib.AnyObjectId;
import org.eclipse.jgit.lib.Ref;
import org.eclipse.jgit.lib.SymbolicRef;

/* JADX INFO: loaded from: classes5.dex */
public abstract class Reftable {
    protected boolean includeDeletes;

    public abstract LogCursor allLogs() throws IOException;

    public abstract RefCursor allRefs() throws IOException;

    public abstract RefCursor byObjectId(AnyObjectId anyObjectId) throws IOException;

    public abstract boolean hasObjectMap() throws IOException;

    public abstract long maxUpdateIndex() throws IOException;

    public abstract long minUpdateIndex() throws IOException;

    public abstract LogCursor seekLog(String str, long j) throws IOException;

    public abstract RefCursor seekRef(String str) throws IOException;

    public abstract RefCursor seekRefsWithPrefix(String str) throws IOException;

    public static Reftable from(Collection<Ref> collection) {
        try {
            ReftableConfig reftableConfig = new ReftableConfig();
            reftableConfig.setIndexObjects(false);
            reftableConfig.setAlignBlocks(false);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            new ReftableWriter(byteArrayOutputStream).setConfig(reftableConfig).begin().sortAndWriteRefs(collection).finish();
            return new ReftableReader(BlockSource.from(byteArrayOutputStream.toByteArray()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void setIncludeDeletes(boolean z) {
        this.includeDeletes = z;
    }

    public LogCursor seekLog(String str) throws IOException {
        return seekLog(str, Long.MAX_VALUE);
    }

    @Nullable
    public Ref exactRef(String str) throws IOException {
        Throwable th = null;
        try {
            RefCursor refCursorSeekRef = seekRef(str);
            try {
                return refCursorSeekRef.next() ? refCursorSeekRef.getRef() : null;
            } finally {
                if (refCursorSeekRef != null) {
                    refCursorSeekRef.close();
                }
            }
        } catch (Throwable th2) {
            if (0 == 0) {
                throw th2;
            }
            if (null != th2) {
                th.addSuppressed(th2);
            }
            throw null;
        }
    }

    public boolean hasRef(String str) throws IOException {
        Throwable th = null;
        try {
            RefCursor refCursorSeekRef = seekRef(str);
            try {
                return refCursorSeekRef.next();
            } finally {
                if (refCursorSeekRef != null) {
                    refCursorSeekRef.close();
                }
            }
        } catch (Throwable th2) {
            if (0 == 0) {
                throw th2;
            }
            if (null != th2) {
                th.addSuppressed(th2);
            }
            throw null;
        }
    }

    public boolean hasRefsWithPrefix(String str) throws IOException {
        Throwable th = null;
        try {
            RefCursor refCursorSeekRefsWithPrefix = seekRefsWithPrefix(str);
            try {
                return refCursorSeekRefsWithPrefix.next();
            } finally {
                if (refCursorSeekRefsWithPrefix != null) {
                    refCursorSeekRefsWithPrefix.close();
                }
            }
        } catch (Throwable th2) {
            if (0 == 0) {
                throw th2;
            }
            if (null != th2) {
                th.addSuppressed(th2);
            }
            throw null;
        }
    }

    public boolean hasId(AnyObjectId anyObjectId) throws IOException {
        Throwable th = null;
        try {
            RefCursor refCursorByObjectId = byObjectId(anyObjectId);
            try {
                return refCursorByObjectId.next();
            } finally {
                if (refCursorByObjectId != null) {
                    refCursorByObjectId.close();
                }
            }
        } catch (Throwable th2) {
            if (0 == 0) {
                throw th2;
            }
            if (null != th2) {
                th.addSuppressed(th2);
            }
            throw null;
        }
    }

    @Nullable
    public Ref resolve(Ref ref) throws IOException {
        return resolve(ref, 0);
    }

    private Ref resolve(Ref ref, int i) throws IOException {
        if (ref.isSymbolic()) {
            Ref target = ref.getTarget();
            if (5 <= i) {
                return null;
            }
            Ref refExactRef = exactRef(target.getName());
            if (refExactRef != null) {
                Ref refResolve = resolve(refExactRef, i + 1);
                if (refResolve == null) {
                    return null;
                }
                return new SymbolicRef(ref.getName(), refResolve, ref.getUpdateIndex());
            }
        }
        return ref;
    }
}
