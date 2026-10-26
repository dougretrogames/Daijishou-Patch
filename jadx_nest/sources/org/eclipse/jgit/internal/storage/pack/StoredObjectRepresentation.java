package org.eclipse.jgit.internal.storage.pack;

import org.eclipse.jgit.lib.ObjectId;

/* INFO: loaded from: classes5.dex */
public class StoredObjectRepresentation {
    public static final int FORMAT_OTHER = 2;
    public static final int PACK_DELTA = 0;
    public static final int PACK_WHOLE = 1;
    public static final int WEIGHT_UNKNOWN = Integer.MAX_VALUE;

    public ObjectId getDeltaBase() {
        return null;
    }

    public int getFormat() {
        return 2;
    }

    public int getWeight() {
        return Integer.MAX_VALUE;
    }

    public boolean wasDeltaAttempted() {
        int format = getFormat();
        return format == 0 || format == 1;
    }
}
