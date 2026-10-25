package org.eclipse.jgit.transport;

import java.util.Collections;
import java.util.List;
import org.eclipse.jgit.lib.ObjectId;

/* JADX INFO: loaded from: classes5.dex */
public final class ObjectInfoRequest {
    private final List<ObjectId> objectIDs;

    /* synthetic */ ObjectInfoRequest(List list, ObjectInfoRequestIA objectInfoRequestIA) {
        this(list);
    }

    private ObjectInfoRequest(List<ObjectId> list) {
        this.objectIDs = list;
    }

    public List<ObjectId> getObjectIDs() {
        return this.objectIDs;
    }

    public static Builder builder() {
        return new Builder(null);
    }

    public static final class Builder {
        private List<ObjectId> objectIDs;

        /* synthetic */ Builder(ObjectInfoRequestIA objectInfoRequestIA) {
            this();
        }

        private Builder() {
            this.objectIDs = Collections.emptyList();
        }

        public Builder setObjectIDs(List<ObjectId> list) {
            this.objectIDs = list;
            return this;
        }

        public ObjectInfoRequest build() {
            return new ObjectInfoRequest(Collections.unmodifiableList(this.objectIDs), null);
        }
    }
}
