package org.eclipse.jgit.transport;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
public class FetchResult extends OperationResult {
    private final List<FetchHeadRecord> forMerge = new ArrayList();
    private final Map<String, FetchResult> submodules = new HashMap();

    FetchResult() {
    }

    void add(FetchHeadRecord fetchHeadRecord) {
        if (fetchHeadRecord.notForMerge) {
            return;
        }
        this.forMerge.add(fetchHeadRecord);
    }

    public void addSubmodule(String str, FetchResult fetchResult) {
        this.submodules.put(str, fetchResult);
    }

    public Map<String, FetchResult> submoduleResults() {
        return Collections.unmodifiableMap(this.submodules);
    }
}
