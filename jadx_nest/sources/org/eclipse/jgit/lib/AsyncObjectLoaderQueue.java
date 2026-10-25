package org.eclipse.jgit.lib;

import java.io.IOException;
import org.eclipse.jgit.lib.ObjectId;

/* JADX INFO: loaded from: classes5.dex */
public interface AsyncObjectLoaderQueue<T extends ObjectId> extends AsyncOperation {
    T getCurrent();

    ObjectId getObjectId();

    boolean next() throws IOException;

    ObjectLoader open() throws IOException;
}
