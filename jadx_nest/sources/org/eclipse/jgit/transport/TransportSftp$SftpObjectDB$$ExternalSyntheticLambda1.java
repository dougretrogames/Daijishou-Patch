package org.eclipse.jgit.transport;

import java.util.Comparator;
import java.util.HashMap;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class TransportSftp$SftpObjectDB$$ExternalSyntheticLambda1 implements Comparator {
    public final /* synthetic */ HashMap f$0;

    public /* synthetic */ TransportSftp$SftpObjectDB$$ExternalSyntheticLambda1(HashMap map) {
        this.f$0 = map;
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        HashMap map = this.f$0;
        return ((Long) map.get((String) obj2)).compareTo((Long) map.get((String) obj));
    }
}
