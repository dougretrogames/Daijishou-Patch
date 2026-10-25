package org.eclipse.jgit.transport;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
public class PushResult extends OperationResult {
    private Map<String, RemoteRefUpdate> remoteUpdates = Collections.emptyMap();

    public Collection<RemoteRefUpdate> getRemoteUpdates() {
        return Collections.unmodifiableCollection(this.remoteUpdates.values());
    }

    public RemoteRefUpdate getRemoteUpdate(String str) {
        return this.remoteUpdates.get(str);
    }

    void setRemoteUpdates(Map<String, RemoteRefUpdate> map) {
        this.remoteUpdates = map;
    }
}
