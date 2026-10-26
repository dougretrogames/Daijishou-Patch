package org.eclipse.jgit.transport;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;
import org.eclipse.jgit.lib.Ref;

/* INFO: loaded from: classes5.dex */
public abstract class OperationResult {
    StringBuilder messageBuffer;
    String peerUserAgent;
    URIish uri;
    Map<String, Ref> advertisedRefs = Collections.emptyMap();
    final SortedMap<String, TrackingRefUpdate> updates = new TreeMap();

    public URIish getURI() {
        return this.uri;
    }

    public Collection<Ref> getAdvertisedRefs() {
        return Collections.unmodifiableCollection(this.advertisedRefs.values());
    }

    public final Ref getAdvertisedRef(String str) {
        return this.advertisedRefs.get(str);
    }

    public Collection<TrackingRefUpdate> getTrackingRefUpdates() {
        return Collections.unmodifiableCollection(this.updates.values());
    }

    public TrackingRefUpdate getTrackingRefUpdate(String str) {
        return this.updates.get(str);
    }

    void setAdvertisedRefs(URIish uRIish, Map<String, Ref> map) {
        this.uri = uRIish;
        this.advertisedRefs = map;
    }

    void add(TrackingRefUpdate trackingRefUpdate) {
        this.updates.put(trackingRefUpdate.getLocalName(), trackingRefUpdate);
    }

    public String getMessages() {
        StringBuilder sb = this.messageBuffer;
        return sb != null ? sb.toString() : "";
    }

    void addMessages(String str) {
        if (str == null || str.length() <= 0) {
            return;
        }
        if (this.messageBuffer == null) {
            this.messageBuffer = new StringBuilder();
        }
        this.messageBuffer.append(str);
        if (str.endsWith("\n")) {
            return;
        }
        this.messageBuffer.append('\n');
    }

    public String getPeerUserAgent() {
        return this.peerUserAgent;
    }
}
