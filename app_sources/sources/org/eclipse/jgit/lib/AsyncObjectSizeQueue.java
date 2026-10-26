package org.eclipse.jgit.lib;

import java.io.IOException;
import org.eclipse.jgit.lib.ObjectId;

/* INFO: loaded from: classes5.dex */
public interface AsyncObjectSizeQueue<T extends ObjectId> extends AsyncOperation {
    T getCurrent();

    ObjectId getObjectId();

    long getSize();

    boolean next() throws IOException;
}
