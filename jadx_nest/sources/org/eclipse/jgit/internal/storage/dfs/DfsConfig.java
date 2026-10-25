package org.eclipse.jgit.internal.storage.dfs;

import java.io.IOException;
import org.eclipse.jgit.errors.ConfigInvalidException;
import org.eclipse.jgit.lib.StoredConfig;

/* JADX INFO: loaded from: classes5.dex */
public final class DfsConfig extends StoredConfig {
    @Override // org.eclipse.jgit.lib.StoredConfig
    public void save() throws IOException {
    }

    @Override // org.eclipse.jgit.lib.StoredConfig
    public void load() throws ConfigInvalidException, IOException {
        clear();
    }
}
