package org.eclipse.jgit.transport;

import java.util.Map;
import org.eclipse.jgit.lib.Ref;

/* INFO: loaded from: classes5.dex */
public interface RefFilter {
    public static final RefFilter DEFAULT = new RefFilter$$ExternalSyntheticLambda0();

    static /* synthetic */ Map lambda$0(Map map) {
        return map;
    }

    Map<String, Ref> filter(Map<String, Ref> map);
}
