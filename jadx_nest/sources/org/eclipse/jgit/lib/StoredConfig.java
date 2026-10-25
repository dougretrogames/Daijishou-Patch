package org.eclipse.jgit.lib;

import java.io.IOException;
import org.eclipse.jgit.errors.ConfigInvalidException;

/* JADX INFO: loaded from: classes5.dex */
public abstract class StoredConfig extends Config {
    public abstract void load() throws ConfigInvalidException, IOException;

    public abstract void save() throws IOException;

    public StoredConfig() {
    }

    public StoredConfig(Config config) {
        super(config);
    }

    @Override // org.eclipse.jgit.lib.Config
    public void clear() {
        super.clear();
    }
}
