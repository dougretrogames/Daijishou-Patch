package org.eclipse.jgit.internal.storage.reftable;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.Collectors;
import net.lingala.zip4j.util.InternalZipConstants;
import org.eclipse.jgit.annotations.Nullable;
import org.eclipse.jgit.lib.ObjectId;
import org.eclipse.jgit.lib.Ref;
import org.eclipse.jgit.lib.ReflogReader;
import org.eclipse.jgit.transport.ReceiveCommand;

/* INFO: loaded from: classes5.dex */
public abstract class ReftableDatabase {
    private final ReentrantLock lock = new ReentrantLock(true);
    private Reftable mergedTables;

    protected abstract MergedReftable openMergedReftable() throws IOException;

    public long nextUpdateIndex() throws IOException {
        this.lock.lock();
        try {
            return reader().maxUpdateIndex() + 1;
        } finally {
            this.lock.unlock();
        }
    }

    public ReflogReader getReflogReader(String str) throws IOException {
        this.lock.lock();
        try {
            return new ReftableReflogReader(this.lock, reader(), str);
        } finally {
            this.lock.unlock();
        }
    }

    public static ReceiveCommand toCommand(Ref ref, Ref ref2) {
        ObjectId id2 = toId(ref);
        ObjectId id3 = toId(ref2);
        String name = ref != null ? ref.getName() : ref2.getName();
        if (ref != null && ref.isSymbolic()) {
            if (ref2 != null) {
                if (ref2.isSymbolic()) {
                    return ReceiveCommand.link(ref.getTarget().getName(), ref2.getTarget().getName(), name);
                }
                return ReceiveCommand.unlink(ref.getTarget().getName(), id3, name);
            }
            return ReceiveCommand.unlink(ref.getTarget().getName(), ObjectId.zeroId(), name);
        }
        if (ref2 == null || !ref2.isSymbolic()) {
            return new ReceiveCommand(id2, id3, name);
        }
        if (ref != null) {
            if (ref.isSymbolic()) {
                return ReceiveCommand.link(ref.getTarget().getName(), ref2.getTarget().getName(), name);
            }
            return ReceiveCommand.link(id2, ref2.getTarget().getName(), name);
        }
        return ReceiveCommand.link(ObjectId.zeroId(), ref2.getTarget().getName(), name);
    }

    private static ObjectId toId(Ref ref) {
        ObjectId objectId;
        return (ref == null || (objectId = ref.getObjectId()) == null) ? ObjectId.zeroId() : objectId;
    }

    public ReentrantLock getLock() {
        return this.lock;
    }

    private Reftable reader() throws IOException {
        if (!this.lock.isLocked()) {
            throw new IllegalStateException("must hold lock to access merged table");
        }
        if (this.mergedTables == null) {
            this.mergedTables = openMergedReftable();
        }
        return this.mergedTables;
    }

    public boolean isNameConflicting(String str, TreeSet<String> treeSet, Set<String> set) throws IOException {
        this.lock.lock();
        try {
            Reftable erVar = reader();
            int iLastIndexOf = str.lastIndexOf(47);
            while (iLastIndexOf > 0) {
                String strSubstring = str.substring(0, iLastIndexOf);
                if (set.contains(strSubstring) || (!erVar.hasRef(strSubstring) && !treeSet.contains(strSubstring))) {
                    iLastIndexOf = str.lastIndexOf(47, iLastIndexOf - 1);
                }
                return true;
            }
            String str2 = str + InternalZipConstants.ZIP_FILE_SEPARATOR;
            RefCursor refCursorSeekRefsWithPrefix = erVar.seekRefsWithPrefix(str2);
            while (refCursorSeekRefsWithPrefix.next()) {
                if (!set.contains(refCursorSeekRefsWithPrefix.getRef().getName())) {
                    return true;
                }
            }
            String strCeiling = treeSet.ceiling(str + InternalZipConstants.ZIP_FILE_SEPARATOR);
            if (strCeiling == null || !strCeiling.startsWith(str2)) {
                return false;
            }
            return true;
        } finally {
            this.lock.unlock();
        }
    }

    @Nullable
    public Ref exactRef(String str) throws IOException {
        this.lock.lock();
        try {
            Reftable erVar = reader();
            Ref refExactRef = erVar.exactRef(str);
            if (refExactRef != null && refExactRef.isSymbolic()) {
                refExactRef = erVar.resolve(refExactRef);
            }
            return refExactRef;
        } finally {
            this.lock.unlock();
        }
    }

    public List<Ref> getRefsByPrefix(String str) throws IOException {
        ArrayList arrayList = new ArrayList();
        this.lock.lock();
        try {
            Reftable erVar = reader();
            Throwable th = null;
            try {
                RefCursor refCursorAllRefs = "".equals(str) ? erVar.allRefs() : erVar.seekRefsWithPrefix(str);
                while (refCursorAllRefs.next()) {
                    try {
                        Ref refResolve = erVar.resolve(refCursorAllRefs.getRef());
                        if (refResolve != null && refResolve.getObjectId() != null) {
                            arrayList.add(refResolve);
                        }
                    } catch (Throwable th2) {
                        if (refCursorAllRefs == null) {
                            throw th2;
                        }
                        refCursorAllRefs.close();
                        throw th2;
                    }
                }
                if (refCursorAllRefs != null) {
                    refCursorAllRefs.close();
                }
                this.lock.unlock();
                return Collections.unmodifiableList(arrayList);
            } catch (Throwable th3) {
                if (0 == 0) {
                    throw th3;
                }
                if (null != th3) {
                    th.addSuppressed(th3);
                }
                throw null;
            }
        } catch (Throwable th4) {
            this.lock.unlock();
            throw th4;
        }
    }

    public List<Ref> getRefsByPrefixWithExclusions(String str, Set<String> set) throws IOException {
        if (set.isEmpty()) {
            return getRefsByPrefix(str);
        }
        ArrayList arrayList = new ArrayList();
        this.lock.lock();
        try {
            Reftable erVar = reader();
            Iterator it = ((List) set.stream().sorted().collect(Collectors.toList())).iterator();
            Throwable th = null;
            String str2 = it.hasNext() ? (String) it.next() : null;
            try {
                RefCursor refCursorAllRefs = "".equals(str) ? erVar.allRefs() : erVar.seekRefsWithPrefix(str);
                while (refCursorAllRefs.next()) {
                    try {
                        Ref refResolve = erVar.resolve(refCursorAllRefs.getRef());
                        if (refResolve != null && refResolve.getObjectId() != null) {
                            while (it.hasNext() && !refResolve.getName().startsWith(str2) && refResolve.getName().compareTo(str2) > 0) {
                                str2 = (String) it.next();
                            }
                            if (str2 != null && refResolve.getName().startsWith(str2)) {
                                refCursorAllRefs.seekPastPrefix(str2);
                            } else {
                                arrayList.add(refResolve);
                            }
                        }
                    } catch (Throwable th2) {
                        if (refCursorAllRefs == null) {
                            throw th2;
                        }
                        refCursorAllRefs.close();
                        throw th2;
                    }
                }
                if (refCursorAllRefs != null) {
                    refCursorAllRefs.close();
                }
                this.lock.unlock();
                return Collections.unmodifiableList(arrayList);
            } catch (Throwable th3) {
                if (0 == 0) {
                    throw th3;
                }
                if (null != th3) {
                    th.addSuppressed(th3);
                }
                throw null;
            }
        } catch (Throwable th4) {
            this.lock.unlock();
            throw th4;
        }
    }

    public boolean hasFastTipsWithSha1() throws IOException {
        this.lock.lock();
        try {
            return reader().hasObjectMap();
        } finally {
            this.lock.unlock();
        }
    }

    public Set<Ref> getTipsWithSha1(ObjectId objectId) throws IOException {
        this.lock.lock();
        try {
            RefCursor refCursorByObjectId = reader().byObjectId(objectId);
            HashSet hashSet = new HashSet();
            while (refCursorByObjectId.next()) {
                hashSet.add(refCursorByObjectId.getRef());
            }
            this.lock.unlock();
            return hashSet;
        } catch (Throwable th) {
            this.lock.unlock();
            throw th;
        }
    }

    public void clearCache() {
        this.lock.lock();
        try {
            this.mergedTables = null;
        } finally {
            this.lock.unlock();
        }
    }
}
