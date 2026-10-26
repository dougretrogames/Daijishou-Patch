package org.eclipse.jgit.revplot;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.eclipse.jgit.internal.JGitText;
import org.eclipse.jgit.lib.AnyObjectId;
import org.eclipse.jgit.lib.Constants;
import org.eclipse.jgit.lib.PersonIdent;
import org.eclipse.jgit.lib.Ref;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.revwalk.RevCommit;
import org.eclipse.jgit.revwalk.RevObject;
import org.eclipse.jgit.revwalk.RevSort;
import org.eclipse.jgit.revwalk.RevTag;
import org.eclipse.jgit.revwalk.RevWalk;

/* INFO: loaded from: classes5.dex */
public class PlotWalk extends RevWalk {
    private Map<AnyObjectId, Set<Ref>> additionalRefMap;
    private Repository repository;
    private Map<AnyObjectId, Set<Ref>> reverseRefMap;

    @Override // org.eclipse.jgit.revwalk.RevWalk
    public void dispose() {
        super.dispose();
        Map<AnyObjectId, Set<Ref>> map = this.reverseRefMap;
        if (map != null) {
            map.clear();
            this.reverseRefMap = null;
        }
        Map<AnyObjectId, Set<Ref>> map2 = this.additionalRefMap;
        if (map2 != null) {
            map2.clear();
            this.additionalRefMap = null;
        }
        this.repository = null;
    }

    public PlotWalk(Repository repository) {
        super(repository);
        super.sort(RevSort.TOPO, true);
        this.additionalRefMap = new HashMap();
        this.repository = repository;
    }

    public void addAdditionalRefs(Iterable<Ref> iterable) throws IOException {
        Set<Ref> setSingleton;
        for (Ref ref : iterable) {
            Set<Ref> set = this.additionalRefMap.get(ref.getObjectId());
            if (set == null) {
                setSingleton = Collections.singleton(ref);
            } else {
                HashSet hashSet = new HashSet(set);
                hashSet.add(ref);
                setSingleton = hashSet;
            }
            this.additionalRefMap.put(ref.getObjectId(), setSingleton);
        }
    }

    @Override // org.eclipse.jgit.revwalk.RevWalk
    public void sort(RevSort revSort, boolean z) {
        if (revSort == RevSort.TOPO && !z) {
            throw new IllegalArgumentException(JGitText.get().topologicalSortRequired);
        }
        super.sort(revSort, z);
    }

    @Override // org.eclipse.jgit.revwalk.RevWalk
    protected RevCommit createCommit(AnyObjectId anyObjectId) {
        return new PlotCommit(anyObjectId);
    }

    @Override // org.eclipse.jgit.revwalk.RevWalk
    public RevCommit next() throws IOException {
        PlotCommit plotCommit = (PlotCommit) super.next();
        if (plotCommit != null) {
            plotCommit.refs = getRefs(plotCommit);
        }
        return plotCommit;
    }

    private Ref[] getRefs(AnyObjectId anyObjectId) throws IOException {
        if (this.reverseRefMap == null) {
            this.reverseRefMap = this.repository.getAllRefsByPeeledObjectId();
            for (Map.Entry<AnyObjectId, Set<Ref>> entry : this.additionalRefMap.entrySet()) {
                Set<Ref> set = this.reverseRefMap.get(entry.getKey());
                Set<Ref> value = entry.getValue();
                if (set != null) {
                    if (value.size() == 1) {
                        value = new HashSet(value);
                    }
                    value.addAll(set);
                }
                this.reverseRefMap.put(entry.getKey(), value);
            }
            this.additionalRefMap.clear();
            this.additionalRefMap = null;
        }
        Set<Ref> set2 = this.reverseRefMap.get(anyObjectId);
        if (set2 == null) {
            return PlotCommit.NO_REFS;
        }
        Ref[] refArr = (Ref[]) set2.toArray(new Ref[0]);
        Arrays.sort(refArr, new PlotRefComparator());
        return refArr;
    }

    class PlotRefComparator implements Comparator<Ref> {
        PlotRefComparator() {
        }

        @Override // java.util.Comparator
        public int compare(Ref ref, Ref ref2) {
            try {
                RevObject any = PlotWalk.this.parseAny(ref.getObjectId());
                RevObject any2 = PlotWalk.this.parseAny(ref2.getObjectId());
                long jTimeof = timeof(any);
                long jTimeof2 = timeof(any2);
                if (jTimeof > jTimeof2) {
                    return -1;
                }
                if (jTimeof < jTimeof2) {
                    return 1;
                }
                int iKind = kind(ref) - kind(ref2);
                return iKind == 0 ? ref.getName().compareTo(ref2.getName()) : iKind;
            } catch (IOException unused) {
            }
        }

        long timeof(RevObject revObject) {
            if (revObject instanceof RevCommit) {
                return ((RevCommit) revObject).getCommitTime();
            }
            if (revObject instanceof RevTag) {
                RevTag revTag = (RevTag) revObject;
                try {
                    PlotWalk.this.parseBody(revTag);
                    PersonIdent taggerIdent = revTag.getTaggerIdent();
                    if (taggerIdent != null) {
                        return taggerIdent.getWhen().getTime();
                    }
                } catch (IOException unused) {
                }
            }
            return 0L;
        }

        int kind(Ref ref) {
            if (ref.getName().startsWith(Constants.R_TAGS)) {
                return 0;
            }
            if (ref.getName().startsWith(Constants.R_HEADS)) {
                return 1;
            }
            return ref.getName().startsWith(Constants.R_REMOTES) ? 2 : 3;
        }
    }
}
