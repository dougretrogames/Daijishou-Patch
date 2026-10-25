package org.eclipse.jgit.internal.storage.dfs;

import androidx.compose.runtime.CompositionImpl$$ExternalSyntheticBackportWithForwarding0;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;
import net.lingala.zip4j.util.InternalZipConstants;
import org.eclipse.jgit.lib.ObjectId;
import org.eclipse.jgit.lib.ObjectIdRef;
import org.eclipse.jgit.lib.Ref;
import org.eclipse.jgit.lib.RefDatabase;
import org.eclipse.jgit.lib.RefRename;
import org.eclipse.jgit.lib.RefUpdate;
import org.eclipse.jgit.lib.SymbolicRef;
import org.eclipse.jgit.revwalk.RevObject;
import org.eclipse.jgit.revwalk.RevTag;
import org.eclipse.jgit.revwalk.RevWalk;
import org.eclipse.jgit.util.RefList;
import org.eclipse.jgit.util.RefMap;

/* JADX INFO: loaded from: classes5.dex */
public abstract class DfsRefDatabase extends RefDatabase {
    private final AtomicReference<RefCache> cache = new AtomicReference<>();
    private final DfsRepository repository;

    protected abstract boolean compareAndPut(Ref ref, Ref ref2) throws IOException;

    protected abstract boolean compareAndRemove(Ref ref) throws IOException;

    @Override // org.eclipse.jgit.lib.RefDatabase
    public void create() {
    }

    protected abstract RefCache scanAllRefs() throws IOException;

    protected DfsRefDatabase(DfsRepository dfsRepository) {
        this.repository = dfsRepository;
    }

    protected DfsRepository getRepository() {
        return this.repository;
    }

    boolean exists() throws IOException {
        return read().size() > 0;
    }

    @Override // org.eclipse.jgit.lib.RefDatabase
    public Ref exactRef(String str) throws IOException {
        RefCache refCache = read();
        Ref ref = refCache.ids.get(str);
        if (ref != null) {
            return resolve(ref, 0, refCache.ids);
        }
        return null;
    }

    @Override // org.eclipse.jgit.lib.RefDatabase
    public List<Ref> getAdditionalRefs() {
        return Collections.emptyList();
    }

    @Override // org.eclipse.jgit.lib.RefDatabase
    public Map<String, Ref> getRefs(String str) throws IOException {
        RefCache refCache = read();
        RefList refListEmptyList = RefList.emptyList();
        RefList<Ref> refListRemove = refCache.ids;
        RefList.Builder builder = new RefList.Builder(refCache.sym.size());
        for (int i = 0; i < refCache.sym.size(); i++) {
            Ref ref = refCache.sym.get(i);
            String name = ref.getName();
            Ref refResolve = resolve(ref, 0, refListRemove);
            if (refResolve != null && refResolve.getObjectId() != null) {
                builder.add(refResolve);
            } else {
                int iFind = refListRemove.find(name);
                if (iFind >= 0) {
                    refListRemove = refListRemove.remove(iFind);
                }
            }
        }
        return new RefMap(str, refListEmptyList, refListRemove, builder.toRefList());
    }

    private Ref resolve(Ref ref, int i, RefList<Ref> refList) throws IOException {
        if (ref.isSymbolic()) {
            Ref target = ref.getTarget();
            if (5 <= i) {
                return null;
            }
            Ref ref2 = refList.get(target.getName());
            if (ref2 != null) {
                Ref refResolve = resolve(ref2, i + 1, refList);
                if (refResolve == null) {
                    return null;
                }
                return new SymbolicRef(ref.getName(), refResolve);
            }
        }
        return ref;
    }

    @Override // org.eclipse.jgit.lib.RefDatabase
    public Ref peel(Ref ref) throws IOException {
        Ref leaf = ref.getLeaf();
        if (leaf.isPeeled() || leaf.getObjectId() == null) {
            return ref;
        }
        Ref refDoPeel = doPeel(leaf);
        RefCache refCache = read();
        int iFind = refCache.ids.find(leaf.getName());
        if (iFind >= 0 && refCache.ids.get(iFind) == leaf) {
            CompositionImpl$$ExternalSyntheticBackportWithForwarding0.m(this.cache, refCache, new RefCache(refCache.ids.set(iFind, refDoPeel), refCache));
            cachePeeledState(leaf, refDoPeel);
        }
        return recreate(ref, refDoPeel, hasVersioning());
    }

    Ref doPeel(Ref ref) throws IOException {
        Throwable th = null;
        try {
            RevWalk revWalk = new RevWalk(this.repository);
            try {
                RevObject any = revWalk.parseAny(ref.getObjectId());
                if (any instanceof RevTag) {
                    return new ObjectIdRef.PeeledTag(ref.getStorage(), ref.getName(), ref.getObjectId(), revWalk.peel(any).copy(), hasVersioning() ? ref.getUpdateIndex() : -1L);
                }
                Ref.Storage storage = ref.getStorage();
                String name = ref.getName();
                long updateIndex = -1;
                ObjectId objectId = ref.getObjectId();
                if (hasVersioning()) {
                    updateIndex = ref.getUpdateIndex();
                }
                return new ObjectIdRef.PeeledNonTag(storage, name, objectId, updateIndex);
            } finally {
                revWalk.close();
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

    static Ref recreate(Ref ref, Ref ref2, boolean z) {
        if (!ref.isSymbolic()) {
            return ref2;
        }
        return new SymbolicRef(ref.getName(), recreate(ref.getTarget(), ref2, z), z ? ref.getUpdateIndex() : -1L);
    }

    @Override // org.eclipse.jgit.lib.RefDatabase
    public RefUpdate newUpdate(String str, boolean z) throws IOException {
        Ref refExactRef = exactRef(str);
        boolean z2 = false;
        if (refExactRef == null) {
            refExactRef = new ObjectIdRef.Unpeeled(Ref.Storage.NEW, str, null);
        } else if (z && refExactRef.isSymbolic()) {
            z2 = true;
        }
        DfsRefUpdate dfsRefUpdate = new DfsRefUpdate(this, refExactRef);
        if (z2) {
            dfsRefUpdate.setDetachingSymbolicRef();
        }
        return dfsRefUpdate;
    }

    @Override // org.eclipse.jgit.lib.RefDatabase
    public RefRename newRename(String str, String str2) throws IOException {
        return new DfsRefRename(newUpdate(str, true), newUpdate(str2, true));
    }

    @Override // org.eclipse.jgit.lib.RefDatabase
    public boolean isNameConflicting(String str) throws IOException {
        RefList<Ref> refList = read().ids;
        int iLastIndexOf = str.lastIndexOf(47);
        while (iLastIndexOf > 0) {
            if (refList.contains(str.substring(0, iLastIndexOf))) {
                return true;
            }
            iLastIndexOf = str.lastIndexOf(47, iLastIndexOf - 1);
        }
        String str2 = str + InternalZipConstants.ZIP_FILE_SEPARATOR;
        int i = -(refList.find(str2) + 1);
        return i < refList.size() && refList.get(i).getName().startsWith(str2);
    }

    @Override // org.eclipse.jgit.lib.RefDatabase
    public void refresh() {
        clearCache();
    }

    @Override // org.eclipse.jgit.lib.RefDatabase
    public void close() {
        clearCache();
    }

    void clearCache() {
        this.cache.set(null);
    }

    void stored(Ref ref) {
        RefCache refCache;
        do {
            refCache = this.cache.get();
            if (refCache == null) {
                return;
            }
        } while (!CompositionImpl$$ExternalSyntheticBackportWithForwarding0.m(this.cache, refCache, refCache.put(ref)));
    }

    void removed(String str) {
        RefCache refCache;
        do {
            refCache = this.cache.get();
            if (refCache == null) {
                return;
            }
        } while (!CompositionImpl$$ExternalSyntheticBackportWithForwarding0.m(this.cache, refCache, refCache.remove(str)));
    }

    private RefCache read() throws IOException {
        RefCache refCache = this.cache.get();
        if (refCache != null) {
            return refCache;
        }
        RefCache refCacheScanAllRefs = scanAllRefs();
        this.cache.set(refCacheScanAllRefs);
        return refCacheScanAllRefs;
    }

    protected void cachePeeledState(Ref ref, Ref ref2) {
        try {
            compareAndPut(ref, ref2);
        } catch (IOException unused) {
        }
    }

    public static class RefCache {
        final RefList<Ref> ids;
        final RefList<Ref> sym;

        public RefCache(RefList<Ref> refList, RefList<Ref> refList2) {
            this.ids = refList;
            this.sym = refList2;
        }

        RefCache(RefList<Ref> refList, RefCache refCache) {
            this(refList, refCache.sym);
        }

        public int size() {
            return this.ids.size();
        }

        public Ref get(String str) {
            return this.ids.get(str);
        }

        public RefCache put(Ref ref) {
            RefList<T> refListPut = this.ids.put(ref);
            RefList<Ref> refListRemove = this.sym;
            if (ref.isSymbolic()) {
                refListRemove = refListRemove.put(ref);
            } else {
                int iFind = refListRemove.find(ref.getName());
                if (iFind >= 0) {
                    refListRemove = refListRemove.remove(iFind);
                }
            }
            return new RefCache(refListPut, refListRemove);
        }

        public RefCache remove(String str) {
            RefList<Ref> refListRemove = this.ids;
            int iFind = refListRemove.find(str);
            if (iFind >= 0) {
                refListRemove = refListRemove.remove(iFind);
            }
            RefList<Ref> refListRemove2 = this.sym;
            int iFind2 = refListRemove2.find(str);
            if (iFind2 >= 0) {
                refListRemove2 = refListRemove2.remove(iFind2);
            }
            return new RefCache(refListRemove, refListRemove2);
        }
    }
}
