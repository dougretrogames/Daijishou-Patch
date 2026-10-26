package org.eclipse.jgit.internal.diff;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import org.eclipse.jgit.diff.DiffEntry;
import org.eclipse.jgit.diff.RenameDetector;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.treewalk.filter.PathFilter;

/* INFO: loaded from: classes5.dex */
public class FilteredRenameDetector {
    private final RenameDetector renameDetector;

    public FilteredRenameDetector(Repository repository) {
        this(new RenameDetector(repository));
    }

    public FilteredRenameDetector(RenameDetector renameDetector) {
        this.renameDetector = renameDetector;
    }

    public List<DiffEntry> compute(List<DiffEntry> list, PathFilter pathFilter) throws IOException {
        return compute(list, Arrays.asList(pathFilter));
    }

    public List<DiffEntry> compute(List<DiffEntry> list, List<PathFilter> list2) throws IOException {
        if (list2 == null) {
            throw new IllegalArgumentException("Must specify path filters");
        }
        HashSet hashSet = new HashSet(list2.size());
        Iterator<PathFilter> it = list2.iterator();
        while (it.hasNext()) {
            hashSet.add(it.next().getPath());
        }
        ArrayList arrayList = new ArrayList();
        for (DiffEntry diffEntry : list) {
            if (diffEntry.getChangeType() != DiffEntry.ChangeType.ADD || hashSet.contains(diffEntry.getNewPath())) {
                arrayList.add(diffEntry);
            }
        }
        this.renameDetector.reset();
        this.renameDetector.addAll(arrayList);
        List<DiffEntry> listCompute = this.renameDetector.compute();
        arrayList.clear();
        for (DiffEntry diffEntry2 : list) {
            if (diffEntry2.getChangeType() != DiffEntry.ChangeType.DELETE || hashSet.contains(diffEntry2.getOldPath())) {
                arrayList.add(diffEntry2);
            }
        }
        this.renameDetector.reset();
        this.renameDetector.addAll(arrayList);
        List<DiffEntry> listCompute2 = this.renameDetector.compute();
        ArrayList arrayList2 = new ArrayList();
        for (DiffEntry diffEntry3 : listCompute) {
            if (hashSet.contains(diffEntry3.getNewPath())) {
                arrayList2.add(diffEntry3);
            }
        }
        for (DiffEntry diffEntry4 : listCompute2) {
            if (hashSet.contains(diffEntry4.getOldPath())) {
                arrayList2.add(diffEntry4);
            }
        }
        this.renameDetector.reset();
        return arrayList2;
    }
}
