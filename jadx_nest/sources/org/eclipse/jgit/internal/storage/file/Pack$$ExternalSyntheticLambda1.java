package org.eclipse.jgit.internal.storage.file;

import java.util.Comparator;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class Pack$$ExternalSyntheticLambda1 implements Comparator {
    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        return ((Pack) obj2).packLastModified.compareTo(((Pack) obj).packLastModified);
    }
}
