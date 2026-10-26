package org.eclipse.jgit.revwalk;

import java.io.IOException;
import org.eclipse.jgit.lib.AsyncOperation;

/* INFO: loaded from: classes5.dex */
public interface AsyncRevObjectQueue extends AsyncOperation {
    RevObject next() throws IOException;
}
