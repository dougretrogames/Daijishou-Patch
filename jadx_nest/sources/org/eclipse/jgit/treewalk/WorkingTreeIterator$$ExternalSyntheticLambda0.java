package org.eclipse.jgit.treewalk;

import java.util.Comparator;
import org.eclipse.jgit.util.Paths;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class WorkingTreeIterator$$ExternalSyntheticLambda0 implements Comparator {
    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        WorkingTreeIterator.Entry entry = (WorkingTreeIterator.Entry) obj;
        WorkingTreeIterator.Entry entry2 = (WorkingTreeIterator.Entry) obj2;
        return Paths.compare(entry.encodedName, 0, entry.encodedNameLen, entry.getMode().getBits(), entry2.encodedName, 0, entry2.encodedNameLen, entry2.getMode().getBits());
    }
}
