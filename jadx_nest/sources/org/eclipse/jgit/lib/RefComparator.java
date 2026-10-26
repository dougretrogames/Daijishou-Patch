package org.eclipse.jgit.lib;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

/* INFO: loaded from: classes5.dex */
public class RefComparator implements Comparator<Ref> {
    public static final RefComparator INSTANCE = new RefComparator();

    @Override // java.util.Comparator
    public int compare(Ref ref, Ref ref2) {
        return compareTo(ref, ref2);
    }

    public static Collection<Ref> sort(Collection<Ref> collection) {
        ArrayList arrayList = new ArrayList(collection);
        Collections.sort(arrayList, INSTANCE);
        return arrayList;
    }

    public static int compareTo(Ref ref, String str) {
        return ref.getName().compareTo(str);
    }

    public static int compareTo(Ref ref, Ref ref2) {
        return ref.getName().compareTo(ref2.getName());
    }
}
